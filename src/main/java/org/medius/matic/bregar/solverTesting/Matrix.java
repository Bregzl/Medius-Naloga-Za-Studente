package org.medius.matic.bregar.solverTesting;

import java.util.*;

public class Matrix {
        
    
        private static int[][] toggleMatrix(int N, int K) {
            int M[][] = new int[K][K];
            
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++) {
                    int k = N*i+j;
                    M[k][k] = 1;
                    if (i > 0) M[k][k-N] = 1;
                    if (i < N-1) M[k][k+N] = 1;
                    if (j > 0) M[k][k-1] = 1;
                    if (j < N-1) M[k][k+1] = 1;
                }
            
            return M;
        }

        public static int[][] randomProblem(int N) {
            Random rand = new Random();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    M[i][j] = rand.nextInt(2);
            return M;
        }


        public static int[] multiply(int[][] a, int[] x) {
            int m = a.length;
            int n = a[0].length;
            if (x.length != n) throw new RuntimeException("Illegal matrix dimensions.");
            int[] y = new int[m];
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++)
                    y[i] += a[i][j] * x[j];
                y[i] = y[i] % 2;
            }
            return y;
        }

        public static int[] matrixToArray(int[][] a) {
            int m = a.length;
            int n = a[0].length;
            int[] y = new int[m*n];
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++)
                    y[(i*n)+j] = a[i][j];
            }
            return y;
        }
   
        /*
        public static int[][] gauss(int [][] a){
            int numRows = a.length;
            int numColumns = a[0].length;

            if(numRows != numColumns)
                throw new RuntimeException("Illegal matrix dimensions.");

            boolean[] pivotTab = new boolean[numRows];
            boolean pivotFound = false;
            int whichRow = 0;
            for(int j = 0; j < numColumns; j++){
                pivotFound = false;

                for(int i = 0; i < numRows; i++){
                    if(a[i][j] == 1){
                        pivotTab[i] = true;
                        whichRow = i;
                        pivotFound = true;
                        break;
                    }
                }

                if(pivotFound){
                    for(int k = 0; k < numColumns; k++){
                        if(a[whichRow][k] == 1 && k != j){
                            for(int rowIndex = 0; rowIndex < numRows; rowIndex++){
                                a[rowIndex][k] = (a[rowIndex][k] + a[rowIndex][j]) % 2;
                            }

                        }
                    }
                }
                
            }
            System.out.println(Arrays.toString(pivotTab));
            return a;
        }

        */
        public static int[][] rowEchelonForm(int[][] a){

            int N = a.length;
            int [][] result = new int [N][N];

            boolean pivotFound = false;
            boolean[] pivots = new boolean[N];
            int whichRow = 0;
            int numOfPivots = 0;
            

            for (int col = 0; col < N; col++){
                // find pivot row 
                whichRow = col;
                pivotFound = false;

                for (int row = 0; row < N; row++) 
                    if (a[row][col] == 1 && !pivots[row]){
                        whichRow = row; 
                        pivotFound = true;
                        pivots[row] = true;
                        break; 
                    }
                

                if(pivotFound){
                    for (int i = whichRow+ 1; i < N; i++){
                        if(a[i][col] == 1){
                            for (int j = 0; j < N; j++)
                                a[i][j] = (a[i][j] + a[whichRow][j])%2;
                        }
                    }
                
                    result[numOfPivots] = a[whichRow].clone();
                    numOfPivots++;
                }
                show(result);
            }
            
            return result;

        }

        // print matrix to standard output
        public static void show(int[][] M) {
            for (int i = 0; i < M.length; i++) {
                for (int j = 0; j < M[0].length; j++) 
                    System.out.print(M[i][j]+" ");
                System.out.println();
            }
            System.out.println();
        }
    
    
    
        // test client
        public static void main(String[] args) {
            int N = 5;
            int K = N*N;
            //int[][] problem = randomProblem(N);
            int [][] problem = new int [][] {{0,0,1,1},{1,0,1,1},{1,0,0,1},{1,1,1,1}};
            int[][] toggle = toggleMatrix(N,K);
            int [] solution = new int[] {0,0,1,0,1,1,0,1,0,0,1,0,0,0,1,1};
            show(problem);
            System.out.println(Arrays.toString(matrixToArray(problem)));
            //show(toggle);
            /*
            int [] rez = multiply(toggle, solution);
            int [] problemVector = matrixToArray(problem);

            System.out.println(Arrays.toString(rez));
            System.out.println(Arrays.toString(problemVector));

            if(Arrays.equals(problemVector, rez))
                System.out.println("Resitev je pravilna");
            else
                System.out.println("Resitev ni pravilna");
            */
            
            //int [][] togglegauss = gauss(toggle);
            //show(togglegauss);
            show(toggle);
            int result[][] = rowEchelonForm(toggle);
            show(result);
    
        }
    }