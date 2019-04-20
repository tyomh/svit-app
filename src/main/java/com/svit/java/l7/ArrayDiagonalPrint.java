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
        
        
        int[] res = findDiagonalOrder(matrix);
        for (int i: res){
        		System.out.println(i + ",");
        }
    }
    
    
    public static void print(int[][] matrix){
    		// to do
        
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
