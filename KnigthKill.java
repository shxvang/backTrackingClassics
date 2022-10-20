class KnigthKill
{
	public static int count;
	public static boolean isSafeToPlace(boolean [][] board,int row,int col)
	{
		int rowArr[]= new int[]{ -1,-2,-2,-1};
		int colArr[]= new int[]{ -2,-1,+1,+2};
		for(int i=0;i<4;i++)
		{
			if(row+rowArr[i]>=0 && row+rowArr[i]<board.length && col+colArr[i]>=0 && col+colArr[i]<board[0].length){
				if(board[row+rowArr[i]][col+colArr[i]]){
		return false;}}}
			return true;
	}
	public static void Qk(boolean [][]board,int tq,int qpsf,String ans,int r, int c)
	{
		
		if(qpsf==tq)
		{
			char QueenArr[][]= new char[board.length][board[0].length];
			count++;
			System.out.println(count+".)");
			for(int i=0;i<ans.length();i+=2){
				int a=Character.getNumericValue(ans.charAt(i));
				int b=Character.getNumericValue(ans.charAt(i+1));
				QueenArr[a][b]='K';
			}
			for(int i=0;i<board.length;i++){
				for(int j=0;j<board[0].length;j++){
				if(QueenArr[i][j]=='K'){System.out.print(QueenArr[i][j]+" ");}
				else{System.out.print("- ");
				}}
				System.out.println();
			}
			System.out.println();	
					
			return;
		}	
		if(c>=board[0].length)
		{
			r++;
			c=0;
			if(r>=board.length)
			{return;}
		}
		//place
		if(isSafeToPlace(board,r,c))
		{
			board[r][c]=true;
			Qk(board,tq,qpsf+1,ans+r+c,r,c+1);
			board[r][c]=false;
		}
		//not_placed
		Qk(board,tq,qpsf,ans,r,c+1);
	}
	public static void main(String[] args)
	{
		Qk(new boolean[3][3],3,0,"",0,0);
	}
}