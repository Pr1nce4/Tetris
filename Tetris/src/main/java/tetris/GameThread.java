
package tetris;

import java.util.logging.Level;
import java.util.logging.Logger;


public class GameThread extends Thread
{
    private GameArea ga;
    private GameForm gf;
    private int score;
    private int level =1;
    private int scorePerLevel = 4;
    
    private int puase = 1000;
    private int speedPerLevel = 100;
    
    public GameThread(GameArea ga, GameForm gf)
    {
        this.ga = ga;
        this.gf = gf;
    }
   @Override
    public void run()
    {
        //infinite loop to move block down
        while(true)
        {
            ga.spawnBlock();
            
            while (ga.moveBlockDown())
            {
        try {
            Thread.sleep(puase);
        } catch (InterruptedException ex) {
            Logger.getLogger(GameThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            if(ga.isBlockOutOfBounds())
            {
                System.out.println("Game Over");
                break;
            }
            ga.moveBlockToBackground();
            score += ga.clearLines();
            gf.updateScore(score);
            
            int lvl = score / scorePerLevel + 1;
            if(lvl > level)
            {
                level = lvl;
                gf.updateLevel(level);
                puase -= speedPerLevel;
                    
            }
            
        }
    }

}
