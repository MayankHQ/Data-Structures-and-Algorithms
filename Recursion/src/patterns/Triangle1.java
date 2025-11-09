package patterns;

public class Triangle1 {
    public static void main(String[] args) {
        func(4,0);
    }
    public static void func(int row, int col){
        if(row == 0){
            return;
        }
        if(col < row){
            System.out.print("*");
            if(col < row - 1){
                System.out.print(" ");
            }
            func(row ,col+1);
        }
        else{
            System.out.println();
            func(row-1,0);
        }
    }
}
