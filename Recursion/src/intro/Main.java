public class Main {
    public static void main(String[] args) {

        num(5);
    }
    public static void num(int n){
        if(n == 0){
            return ;
        }
        System.out.println(n);
        num(n-1);

    }
}