import java.util.Scanner;
class nQueen{

	public static boolean isSafetoPlace(int [][] board, int row, int col){
		//upwards
		int r=row;
		int c=col;
		while(r>0){
			if(board[r][c]==1){
				return false;
			}
			r-=1;
		}
		//diagonally right
		r=row-1;
		c=col+1;
		while(r>=0 && c<board[0].length){
			if(board[r][c]==1){
				return false;
			}
			r-=1;
			c+=1;
		}
		//diagonally left
		r=row-1;
		c=col-1;
		while(r>=0 && c>=0){
			if(board[r][c]==1){
				return false;
			}
			r-=1;
			c-=1;
		}
		return true;
	}
	public static void QueenSolver(int [][] board,int tq, int qpsf,int row ,int col)
	{
		if(tq==qpsf){
			for(int i=0;i<board.length;i++){
				for(int j=0;j<board[0].length;j++){
				System.out.print(board[i][j]+ " ");}
				System.out.println();
			}
		}
		//place
		if(isSafetoPlace(board,row,col)){
			board[row][col]=1;
			QueenSolver(board,tq,qpsf+1,row+1,col);
			board[row][col]=0;
		}
		//not placed
		QueenSolver(board,tq,qpsf,row,col+1);
	}
	public static void main(String [] args){
	QueenSolver(new int[4][4],4,0,0,0);}
}