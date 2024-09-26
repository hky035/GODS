public class lv3_42898 {

	public static void main(String[] args) {
		lv3_42898 sol = new lv3_42898();
		
		int[][] puddles = {{2,2}};
		int answer = sol.solution(4, 3, puddles);
		System.out.println(answer);
	}
	
	private int[][] route;
	private int[][] puddles;
	
	public int solution(int m, int n, int[][] puddles) {
		
		route = new int[n][m];
		this.puddles = puddles;
		
		int eM = m-1;
		int eN = n-1;
		
		for(int i = 1 ; i < m  ; i++ ) {
			if(isPuddle(0, i))
				break;
			else 
				this.route[0][i] = 1; 
		}
		print(route);
		System.out.println();
		
		for(int i = 1 ; i < n  ; i++ ) {
			if(isPuddle(i, 0))
				break;
			else 
				this.route[i][0] = 1;
		}
		print(route);
		System.out.println();
		
		
		for(int x = 1 ; x < m ; x++) {
			for(int y = 1 ; y < n ; y++) {
				if(isPuddle(x, y))
					continue;
				route[y][x] = route[y-1][x] + route[y][x-1];
			}
		}
		
		print(route);
		
		
		return route[eN][eM];
	}
	
	private boolean isPuddle(int x, int y) {
		for(int[] puddle : puddles) {
			if(puddle[0]-1 == x && puddle[1]-1 == y) {
				System.out.println("true");
				return true;
			}
		}
		System.out.println("false");
		return false;
	}
	
	private void print(int[][] arr) {
		for(int i = 0 ; i < arr.length ; i++) {
			for(int j = 0 ; j < arr[i].length ; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
