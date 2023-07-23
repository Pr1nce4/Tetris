package com.mycompany.tetris;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GameArea extends JPanel
{
    private int gridRows;
    private int gridColumns;
    private int gridCellSize;
    
    //get the game information from the place area
    public GameArea(JPanel placeholder, int columns)
    {
        placeholder.setVisible(false);
        this.setBounds(placeholder.getBounds());
        this.setBackground(placeholder.getBackground());
        this.setBorder(placeholder.getBorder());
        
        gridCellSize = this.getBounds().width / gridColumns;
        gridColumns = columns;
        gridRows = this.getBounds().height / gridCellSize;
    }
                
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.fill3DRect(0, 0, 50, 50, true);
    }
    
}
