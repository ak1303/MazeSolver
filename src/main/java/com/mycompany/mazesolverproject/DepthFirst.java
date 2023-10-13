/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mazesolverproject;

import java.util.List;

/**
 *
 * @author ntedd
 */
public class DepthFirst {
    static int[] dir = {-1,0,1,0,1};//xY direction (i,i+1);
    public static boolean searchPath(int[][] maze , int x, int y, List<Integer> path){
        if(maze[y][x]==9){
            path.add(x);
            path.add(y);
            return true;
        }
        if(maze[y][x]==0){//-------add to path if maze[y][x]==0;
            maze[y][x]=2;//path visited
            for(int i=0;i<4;i++){//all 4 direction
                int h = y + dir[i];
                int w = x + dir[i+1];
                if(searchPath(maze,w,h,path)){
                    path.add(x);
                    path.add(y);
                    return true;
                }
            } 
        }//------ if maze[y][x]==0
        return false;// if maze[y][x] is 1(blocked) or 2(visited)
    }
}
