package maze;

import java.util.LinkedList;

public class Maze {
	static int [][] maze = {
			{2,0,1,1},
			{1,1,2,0},
			{0,1,1,1}
	};
//	final int WALL = 0;
//	final int PATH = 1;
//	final int DESTINATION = 2;
	
	static LinkedList<Position> path = new LinkedList<Position>();
	
	public static void main(String [] args) {
		Position p = new Position(0,3);	
		path.push(p);

		while(true) {
			int y = path.peek().y;
			int x = path.peek().x;
			maze[y][x] = 0;
			if (isValid(y+1,x)) {
				if (maze[y+1][x] == 2){
					System.out.println("Move down. You won!");
					return;
				} //down
				else if(maze[y+1][x] == 1) {
					System.out.println("Move down");
					path.push(new Position(y+1,x));
					continue;
				}
			}
			//left
			if (isValid(y+1,x)) {
				if (maze[y][x-1] == 2){
					System.out.println("Move left. You won!");
					return;
				} 
				else if(maze[y][x-1] == 1) {
					System.out.println("Move left");
					path.push(new Position(y,x-1));
					continue;
				}
			}
			//up
			if (isValid(y+1,x)) {
				if (maze[y-1][x] == 2){
					System.out.println("Move up. You won!");
					return;
				} 
				else if(maze[y-1][x] == 1) {
					System.out.println("Move up");
					path.push(new Position(y-1,x));
					continue;
				}
			}
			//right
			if (isValid(y+1,x)) {
				if (maze[y][x+1] == 2){
					System.out.println("Move right. You won!");
					return;
				} 
				else if(maze[y][x+1] == 1) {
					System.out.println("Move right");
					path.push(new Position(y,x+1));
					continue;
				}
			}
			
			path.pop();
			if(path.size() == 0) {
				System.out.println("No path");
			}
		}
		
	}
	
	public static boolean isValid(int y, int x) {
		if( y < 0 || y >= maze.length || x<0 || x>=maze[y].length ) {
			return false;
		}
		return true;
	}
}
