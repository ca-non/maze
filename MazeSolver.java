import java.util.LinkedList;

public class MazeSolver {
	
	int [][] maze = {
			{1, 1, 0, 0},
			{1, 1, 1, 1},
			{2, 0, 0, 0}
	};
	
	LinkedList<Position> pathStack = new LinkedList<Position>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 MazeSolver myMaze = new MazeSolver();
		 Position p = new Position(0,3);
		 myMaze.pathStack.push(p);
		 
		 while(true) {
			 int y = myMaze.pathStack.peek().y;
			 int x = myMaze.pathStack.peek().x;
			 
			 myMaze.maze[x][y] = 0;
			 
			 if(myMaze.isValid(x+1, y)) {
				 // down
				 if(myMaze.maze[x+1][y] == 2) {
					 System.out.println("Moved down. You won!");
					 return;
				 }
				 else if(myMaze.maze[x+1][y] == 1) {
					 System.out.println("Move down");
					 myMaze.pathStack.push(new Position(x+1, y));
					 continue;
				 }	
			 }
			 
			 
			 if(myMaze.isValid(x, y-1)) {
				 // left
				 if(myMaze.maze[x][y-1] == 2) {
					 System.out.println("Moved left. You won!");
					 return;
				 }
				 else if(myMaze.maze[x][y-1] == 1) {
					 System.out.println("Move left");
					 myMaze.pathStack.push(new Position(x, y-1));
					 continue;
				 }	
			 }
			 
			 if(myMaze.isValid(x, y+1)) {
				 // right
				 if(myMaze.maze[x][y+1] == 2) {
					 System.out.println("Moved right. You won!");
					 return;
				 }
				 else if(myMaze.maze[x][y+1] == 1) {
					 System.out.println("Move right");
					 myMaze.pathStack.push(new Position(x, y+1));
					 continue;
				 }	
			 }
			 
			 
			 if(myMaze.isValid(x-1, y)) {
				 // up
				 if(myMaze.maze[x-1][y] == 2) {
					 System.out.println("Moved up. You won!");
					 return;
				 }
				 else if(myMaze.maze[x-1][y] == 1) {
					 System.out.println("Move up");
					 myMaze.pathStack.push(new Position(x-1, y));
					 continue;
				 }	
			 }
			 
			 myMaze.pathStack.pop();
			 
			 if(myMaze.pathStack.size() <= 0) {
				 System.out.println("No path");
				 return;
			 }
		 }

	}
	
	public boolean isValid(int x, int y) {
		if(x < 0 || x >= maze.length || y < 0 || y >= maze[x].length) {
			return false;
		}
		
		return true;
	}

}
