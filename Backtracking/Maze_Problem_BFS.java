

import java.util.LinkedList;
import java.util.Queue;

public class Maze_Problem_BFS {
    public int nearestExit(char[][] maze, int[] entrance) {
        
    Queue <Coordinates> cordinates=new LinkedList<>();

    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    
    int startX=entrance[0];
    int startY=entrance[1];

     int rows=maze.length;
     int cols=maze[0].length;

    boolean [][] visited=new boolean [rows][cols];


    cordinates.add(new Coordinates(startX, startY));

    visited[startX][startY]=true;

    int distance=0;
    

    while(!cordinates.isEmpty())
    {
        int size=cordinates.size();

        distance++;

        for(int i=0; i <size;i++)
        {
            Coordinates currentCordinates=cordinates.poll();

            for(int [] direction: dirs)
            {
                int dx=currentCordinates.x+direction[0];
                int dy=currentCordinates.y+direction[1];

                if(dx<0||dx>=rows ||dy<0||dy>=cols)
                {continue;};
                if(visited[dx][dy]|| maze[dx][dy]=='+')
                continue;

                if(dx==0||dx==rows-1 || dy==0 || dy==cols-1)
                return distance;
                visited[dx][dy]=true;
                cordinates.add(new Coordinates(dx, dy));


            }

        }


        
    }



    return -1 ;
}
}
class Coordinates {
    int x ,y ;
    Coordinates(int x ,int y)
    {
        this.x=x;
        this.y=y;

    }
}
