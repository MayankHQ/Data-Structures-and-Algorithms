public class Patterns {
    public static void main(String[] args) {
        pattern31(4);

    }
    static void pattern1(int n){
        for (int row = 1; row <= n; row++){
            for(int col = 1; col <=row; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern2(int n){
        for (int row = 1; row <= n; row++){
            for(int col = 1; col <=n-row+1; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern3(int n){
        for (int row = 1; row <= n; row++){
            for(int col = 1; col <=row; col++){
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
//    static void pattern4(int n){
//        for (int row = 1; row <= n; row++){
//            for(int col = 1; col <=row; col++){
//                System.out.print("*"+" ");
//            }
//            System.out.println();
//        }
//        for (int row = 1; row <= n-1; row++){
//            for(int col = n-row; col > 0; col--){
//                System.out.print("*"+" ");
//            }
//            System.out.println();
//        }
//    }
    static void pattern4(int n){
        for (int row = 1; row < 2*n; row++){
            int newCol = row > n ? 2 * n - row : row;
            for(int col = 1; col <=newCol; col++){
                System.out.print("*"+" ");
            }
            System.out.println();
        }
    }
    static void pattern5(int n){
        for (int row = 1; row < 2*n; row++){
            int newCol = row > n ? 2 * n - row : row;
            int space = n - newCol;
            for(int col = 1; col <=space; col++){
                System.out.print(" ");
            }
            for(int col = 1; col <=newCol; col++){
                System.out.print("*"+" ");
            }
            System.out.println();
        }
    }
    static void pattern31(int n){
        int original = n ;
        n = 2 * n - 1;

        for (int row = 0; row < n; row++){
            for (int col = 0; col < n ; col++){
                int atEveryIndex = original - Math.min(Math.min(row, col), Math.min(n-row-1, n- col-1));
                System.out.print(atEveryIndex + " ");
            }
            System.out.println();

        }
    }
}
