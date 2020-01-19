package blocks;

import twoPlayerTetris.block;

public class OBlock extends block{
	
    public OBlock() {
        this.block = new int[][][]{
            {
                    {1, 1},
                    {1, 1}
            },
        };
        numOfBlockType = 1;
        x = 0;
        y = 4;
        r = 0;
        w = 2;
        h = 2;
        type = 1;
    }
    
    public void rotate() {
        r = 0;
    }

    public int[][] getBlock() {
        return block[r];
    }
}
