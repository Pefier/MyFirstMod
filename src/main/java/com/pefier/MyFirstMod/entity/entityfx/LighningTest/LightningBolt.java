package com.pefier.MyFirstMod.entity.entityfx.LighningTest;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by New Profile on 24.04.2016.
 */
public class LightningBolt {
    public ArrayList<Segment> segments = new ArrayList<Segment>();
    public Vector3 start;
    public Vector3 end;
    BlockCoord target;
    HashMap<Integer, Integer> splitparents = new HashMap<Integer, Integer>();

    public double length;
    public int numsegments0;
    private int numsplits;
    private boolean finalized;
    private Random rand;
    public long seed;

    public int particleAge;
    public int particleMaxAge;
    public boolean isDead;
    private AxisAlignedBB boundingBox;

    private World world;
    private Entity source;

    public static ConcurrentLinkedQueue<LightningBolt> boltlist = new ConcurrentLinkedQueue<LightningBolt>();

    public float speed = 1.5F;// ticks per metre
    public static final int fadetime = 20;

    /* Damage in half hearts */
    public static int playerdamage = 1;
    public static int entitydamage = 1;

    public int colorOuter;
    public int colorInner;

    public class BoltPoint {
        public BoltPoint(Vector3 basepoint, Vector3 offsetvec) {
            point = basepoint.copy().add(offsetvec);
            this.basepoint = basepoint;
            this.offsetvec = offsetvec;
        }

        public Vector3 point;
        Vector3 basepoint;
        Vector3 offsetvec;
    }

    public class SegmentSorter implements Comparator<Segment> {
        @Override
        public int compare(Segment o1, Segment o2) {
            int comp = Integer.valueOf(o1.splitno).compareTo(o2.splitno);
            if (comp == 0) {
                return Integer.valueOf(o1.segmentno).compareTo(o2.segmentno);
            } else {
                return comp;
            }
        }
    }

    public class SegmentLightSorter implements Comparator<Segment> {
        @Override
        public int compare(Segment o1, Segment o2) {
            return Float.compare(o2.light, o1.light);
        }
    }

    public class Segment {
        public Segment(BoltPoint start, BoltPoint end, float light, int segmentnumber, int splitnumber) {
            startpoint = start;
            endpoint = end;
            this.light = light;
            segmentno = segmentnumber;
            splitno = splitnumber;

            calcDiff();
        }

        public Segment(Vector3 start, Vector3 end) {
            this(new BoltPoint(start, new Vector3(0, 0, 0)), new BoltPoint(end, new Vector3(0, 0, 0)), 1, 0, 0);
        }

        public void calcDiff() {
            diff = endpoint.point.copy().subtract(startpoint.point);
        }

        public void calcEndDiffs() {
            if (prev != null) {
                Vector3 prevdiffnorm = prev.diff.copy().normalize();
                Vector3 thisdiffnorm = diff.copy().normalize();

                prevdiff = thisdiffnorm.copy().add(prevdiffnorm).normalize();
                sinprev = (float) Math.sin(thisdiffnorm.angle(prevdiffnorm.multiply(-1)) / 2);
            } else {
                prevdiff = diff.copy().normalize();
                sinprev = 1;
            }

            if (next != null) {
                Vector3 nextdiffnorm = next.diff.copy().normalize();
                Vector3 thisdiffnorm = diff.copy().normalize();

                nextdiff = thisdiffnorm.add(nextdiffnorm).normalize();
                sinnext = (float) Math.sin(thisdiffnorm.angle(nextdiffnorm.multiply(-1)) / 2);
            } else {
                nextdiff = diff.copy().normalize();
                sinnext = 1;
            }
        }

        @Override
        public String toString() {
            return startpoint.point.toString() + " " + endpoint.point.toString();
        }

        public BoltPoint startpoint;
        public BoltPoint endpoint;

        public Vector3 diff;

        public Segment prev;
        public Segment next;

        public Vector3 nextdiff;
        public Vector3 prevdiff;

        public float sinprev;
        public float sinnext;
        public float light;

        public int segmentno;
        public int splitno;
    }

    public LightningBolt(World world, Vector3 sourcevec, Vector3 targetvec, float ticksPerMeter, long seed, int colorOuter, int colorInner) {
        this.world = world;
        this.seed = seed;
        rand = new Random(seed);

        start = sourcevec;
        end = targetvec;

        speed = ticksPerMeter;

        this.colorOuter = colorOuter;
        this.colorInner = colorInner;

        numsegments0 = 1;

        length = end.copy().subtract(start).mag();
        particleMaxAge = fadetime + rand.nextInt(fadetime) - fadetime / 2;
        particleAge = -(int) (length * speed);


        boundingBox = new AxisAlignedBB(Math.min(start.x, end.x), Math.min(start.y, end.y), Math.min(start.z, end.z), Math.max(start.x, end.x), Math.max(start.y, end.y), Math.max(start.z, end.z)).expand(length / 2, length / 2, length / 2);

        segments.add(new Segment(start, end));
    }

    public static Vector3 getFocalPoint(TileEntity tile) {
        return Vector3.fromTileEntityCenter(tile);
    }

    public LightningBolt(World world, Vector3 sourcevec, TileEntity target, float ticksPerMeter, long seed, int colorOuter, int colorInner) {
        this(world, sourcevec, getFocalPoint(target), ticksPerMeter, seed, colorOuter, colorInner);
        this.target = new BlockCoord(target);
    }

    public void setWrapper(Entity entity) {
        source = entity;
    }

    public void fractal(int splits, double amount, double splitchance, double splitlength, double splitangle) {
        if (finalized) {
            return;
        }

        ArrayList<Segment> oldsegments = segments;
        segments = new ArrayList<Segment>();

        Segment prev = null;

        for (Segment segment : oldsegments) {
            prev = segment.prev;

            Vector3 subsegment = segment.diff.copy().multiply(1F / splits);

            BoltPoint[] newpoints = new BoltPoint[splits + 1];

            Vector3 startpoint = segment.startpoint.point;
            newpoints[0] = segment.startpoint;
            newpoints[splits] = segment.endpoint;

            for (int i = 1; i < splits; i++) {
                Vector3 randoff = segment.diff.copy().perpendicular().normalize().rotate(rand.nextFloat() * 360, segment.diff);
                randoff.multiply((rand.nextFloat() - 0.5F) * amount * 2);

                Vector3 basepoint = startpoint.copy().add(subsegment.copy().multiply(i));

                newpoints[i] = new BoltPoint(basepoint, randoff);
            }
            for (int i = 0; i < splits; i++) {
                Segment next = new Segment(newpoints[i], newpoints[i + 1], segment.light, segment.segmentno * splits + i, segment.splitno);
                next.prev = prev;
                if (prev != null) {
                    prev.next = next;
                }

                if (i != 0 && rand.nextFloat() < splitchance) {
                    Vector3 splitrot = next.diff.copy().xCrossProduct().rotate(rand.nextFloat() * 360, next.diff);
                    Vector3 diff = next.diff.copy().rotate((rand.nextFloat() * 0.66F + 0.33F) * splitangle, splitrot).multiply(splitlength);

                    numsplits++;
                    splitparents.put(numsplits, next.splitno);

                    Segment split = new Segment(newpoints[i], new BoltPoint(newpoints[i + 1].basepoint, newpoints[i + 1].offsetvec.copy().add(diff)), segment.light / 2F, next.segmentno, numsplits);
                    split.prev = prev;

                    segments.add(split);
                }

                prev = next;
                segments.add(next);
            }
            if (segment.next != null) {
                segment.next.prev = prev;
            }
        }

        numsegments0 *= splits;
    }

    public void defaultFractal() {
        fractal(2, length / 1.5, 0.7F, 0.7F, 45);
        fractal(2, length / 4, 0.5F, 0.8F, 50);
        fractal(2, length / 15, 0.5F, 0.9F, 55);
        fractal(2, length / 30, 0.5F, 1.0F, 60);
        fractal(2, length / 60, 0, 0, 0);
        fractal(2, length / 100, 0, 0, 0);
        fractal(2, length / 400, 0, 0, 0);
    }

    private float rayTraceResistance(Vector3 start, Vector3 end, float prevresistance) {
        RayTraceResult mop = world.rayTraceBlocks(start.toVec3D(), end.toVec3D());

        if (mop == null) {
            return prevresistance;
        }


         else {
            return prevresistance;
        }
    }

    private void calculateCollisionAndDiffs() {
        HashMap<Integer, Integer> lastactivesegment = new HashMap<Integer, Integer>();

        Collections.sort(segments, new SegmentSorter());

        int lastsplitcalc = 0;
        int lastactiveseg = 0;
        float splitresistance = 0;

        for (Segment segment : segments) {
            if (segment.splitno > lastsplitcalc)
            {
                lastactivesegment.put(lastsplitcalc, lastactiveseg);
                lastsplitcalc = segment.splitno;
                lastactiveseg = lastactivesegment.get(splitparents.get(segment.splitno));
                splitresistance = lastactiveseg < segment.segmentno ? 50 : 0;

            }
            if (splitresistance >= 40 * segment.light) {
                continue;
            }
            splitresistance = rayTraceResistance(segment.startpoint.point, segment.endpoint.point, splitresistance);
            lastactiveseg = segment.segmentno;
        }
        lastactivesegment.put(lastsplitcalc, lastactiveseg);


        lastsplitcalc = 0;
        lastactiveseg = lastactivesegment.get(0);
        for (Iterator<Segment> iterator = segments.iterator(); iterator.hasNext();)

        {
            Segment segment = iterator.next();
            if (lastsplitcalc != segment.splitno) {
                lastsplitcalc = segment.splitno;
                lastactiveseg = lastactivesegment.get(segment.splitno);
            }
            if (segment.segmentno > lastactiveseg) {
                iterator.remove();
            }
            segment.calcEndDiffs();
        }

        if (lastactivesegment.get(0) + 1 < numsegments0) {}
    }

    public void finalizeBolt() {
        if (finalized) {
            return;
        }
        finalized = true;

        calculateCollisionAndDiffs();

        Collections.sort(segments, new SegmentLightSorter());

        boltlist.add(this);
    }

    public void onUpdate() {
        particleAge++;


        if (particleAge == 0) {

        }

        if (particleAge >= particleMaxAge) {
            isDead = true;
        }
    }

    public static void update() {
        for (Iterator<LightningBolt> iterator = boltlist.iterator(); iterator.hasNext();) {
            LightningBolt bolt = iterator.next();
            bolt.onUpdate();
            if (bolt.isDead) {
                iterator.remove();
            }
        }
    }
}
