package blocks;

import twoPlayerTetris.block;

public class ZBlock extends block {

    public ZBlock() {
        this.block = new int[][][]{
            {
                    {1, 1, 0},
                    {0, 1, 1},
                    {0, 0, 0},
            },
            {
                    {0, 1, 0},
                    {1, 1, 0},
                    {1, 0, 0},
            },
        };
        numOfBlockType = 2;
        x = 0;
        y = 4;
        r = 0;
        w = 3;
        h = 3;
        type = 7;
    }

    public int[][] getBlock() {
        return block[r];
    }
}
