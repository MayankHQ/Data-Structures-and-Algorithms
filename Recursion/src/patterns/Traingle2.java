package patterns;

public class Traingle2 {
    public static void main(String[] args) {
        func(4,0);
    }
    public static void func(int row, int col){
        if(row == 0){
            return;
        }
        if(col < row){
            func(row ,col+1);
            System.out.print("*");
        }
        else{
            func(row-1,0);
            System.out.println();
        }
    }
}
