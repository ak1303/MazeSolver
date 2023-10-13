/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mazesolverproject;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.JFrame;

/**
 *
 * @author ntedd
 */
public class MazeSolverProject extends JFrame{
    
    MazeSolverProject(){
        setTitle("Maze Solver");
        setSize(640, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DepthFirst.searchPath(maze,1,1,path);
    }
    List<Integer> path = new ArrayList<>();
    int[][] maze = {
        {1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,0,0,0,0,1},
        {1,0,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,1,1,1,1,1,0,0,0,0,0,1},
        {1,0,0,1,0,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,0,0,1},
        {1,0,1,0,1,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,9,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    @Override
    public void paint(Graphics g){  
       Color color;
       g.translate(50,50);
       for(int i=0;i<maze.length;i++){
           for(int j=0;j<maze[0].length;j++){
               int num = maze[i][j];
               color = switch (num) {
                   case 9 -> Color.red;
                   case 1 -> Color.black;
                   default -> Color.white;
               };
               g.setColor(color);
               g.fillRect(30*j, 30*i, 30, 30);
               g.setColor(Color.red);
               g.drawRect(30*j, 30*i, 30, 30);
           }
       }
       for(int i=0;i<path.size();i+=2){
           int x = path.get(i);
           int y = path.get(i+1);
           g.setColor(Color.GREEN);
           g.fillRect(30*x + 5,30*y,20,30);
       }
    }
    public static void main(String[] args) {
        MazeSolverProject maze = new MazeSolverProject();
        maze.setVisible(true);
    }
}
