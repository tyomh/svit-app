package com.svit.java.l7;
/**
 * 
 * Code is for study and personal use purpose, not for commercial use.
 * 
 * @author sv-it.org
 *
 */
public class ArrayDiagonalPrint {
    public static void main(String[] args) {
        int[][] matrix= new int[][]{
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16},
            
        };
        
/*        1,
        2,5,
        3,6,9,
        4,7,10,13,
        8,11,14,
        12,15,
        16,*/
        
        
//        int[] res = findDiagonalOrder(matrix);
//        for (int i: res){
//        		System.out.println(i + ",");
//        }
        upAndDown(matrix);
        up(matrix);
        down(matrix);
    }
    public static void down(int[][] matrix){
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
    		return;
    	}
    	
    	int m = matrix.length;
    	int n = matrix[0].length;
    	int[] dirs = {1, -1};
    	int[] res = new int[m * n];
    	int row = 0, col = 0;
        
    	for (int i = 0; i < m * n; i++) {
    		res[i] = matrix[row][col];
    		row += dirs[0];
    		col += dirs[1];
    		
    		
    		if (row >= m) {
    			row = row + col - n + 2;
    			col = n - 1;	
    		}
    		
    		if (col < 0) {
    			col = row + col + 1;
    			row = 0;	
    		}	
    	}
    	
    	for (int i : res) {
    		System.out.println(i);
    	}
    }
    

    public static void up(int[][] matrix) {
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
    		return;
    	}
    	
    	int m = matrix.length;
    	int n = matrix[0].length;
    	int[] dirs = {-1, 1};
    	int[] res = new int[m * n];
    	int row = 0, col = 0;
    	
    	for (int i = 0; i < m * n; i++) {
    		res[i] = matrix[row][col];
    		row += dirs[0];
    		col += dirs[1];
    		
    		
    		if (col >= n) {
    			col = row + col - m + 2;
    			row = m - 1;	
    		}
    		
    		if (row < 0) {
    			row = row + col + 1;
    			col = 0;	
    		}	
    	}
    	
    	for (int i : res) {
    		System.out.println(i);
    	}
    	
    }
    
    public static void upAndDown(int[][] matrix) {
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
    		return;
    	}
    	
    	int m = matrix.length;
    	int n = matrix[0].length;
    	int[][] dirs = {{-1, 1}, {1, -1}};
    	int[] res = new int[m * n];
    	int row = 0, col = 0, dir = 0;
    	
    	for (int i = 0; i < m * n; i++) {
    		res[i] = matrix[row][col];
    		row += dirs[dir][0];
    		col += dirs[dir][1];
    		
    		// condition orders are important for cor corner cases
    		// (m, -1) and (-1, n)
    		
    		if (row >= m) {
    			row = m - 1;
    			col += 2;
    			dir = 1 - dir;
    		}
    		
    		if (col >= n) {
    			col = n - 1;
    			row += 2;
    			dir = 1 - dir;
    		}
    		
    		if (row < 0) {
    			row = 0;
    			dir = 1 - dir;
    		}
    		
    		if (col < 0) {
    			col = 0;
    			dir = 1 - dir;
    		}
    	}
    	
    	for (int i : res) {
    		System.out.println(i);
    	}
    }
    
    
    public static int[] findDiagonalOrder(int[][] matrix) {
        int[] result = new int[matrix.length * matrix.length];
        int n = 0;
        int m = 0;
        int N = matrix.length;

        for(int i = 0; i < result.length; i++){
            result[i] = matrix[n][m];
            //System.out.printf("%d %d", n, m);
            if(N - n > 0 && N - m > 0) {
                result[N * N - i - 1] = matrix[N - n - 1][N - m - 1];
            }
            
            if( m + 1 == N) break;
            else if (n == 0) {
                n = m + 1;
                m = 0;
            }else{
                n -= 1;
                m += 1;
            }
        }
        return result;
	}
    
    
    
}
