package net.journey.dimension.nether.noise;

public class WorleyNoise {

    /* Created by paulevs, from the Better Nether mod
     * Big thanks to him*/

    private final PermutationTable randX;
    private final PermutationTable randY;

    public WorleyNoise(long seed) {
        randX = new PermutationTable(seed);
        randY = new PermutationTable((seed + 1337L));
    }

    public double GetValue(double x, double y) {
        int px = (int) x;
        int py = (int) y;
        x -= px;
        y -= py;
        double d = 10;
        for (int i = -1; i < 2; i++) {
            int cx = (px + i) & 255;
            for (int j = -1; j < 2; j++) {
                int cy = (py + j) & 255;
                double nd = Math.sqrt(
                        sqr(x - randX.PosReal(cx, cy) - (double) i) + sqr(y - randY.PosReal(-cy, -cx) - (double) j));
                if (nd < d)
                    d = nd;
            }
        }
        return d;
    }

    private double sqr(double x) {
        return x * x;
    }
}
