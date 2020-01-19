package blocks;

import twoPlayerTetris.block;

public class JBlock extends block {
	
    public JBlock() {
        this.block = new int[][][]{
            {
                {0, 1, 0},
                {0, 1, 0},
                {1, 1, 0},
            },
            {
                {1, 0, 0},
                {1, 1, 1},
                {0, 0, 0},
            },
            {
                {1, 1, 0},
                {1, 0, 0},
                {1, 0, 0},
            },
            {
                {1, 1, 1},
                {0, 0, 1},
                {0, 0, 0},
            }
        };
        numOfBlockType = 4;
        x = 0;
        y = 4;
        r = 0;
        w = 3;
        h = 3;
        type = 4;
    }

    public int[][] getBlock() {
        return block[r];
    }
}
