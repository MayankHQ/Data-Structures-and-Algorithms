package Strings;

//public class PermutationString {
//    public static void main(String[] args) {
//        permute("","abc");
//    }
//    public static void permute(String p, String up){
//        if(up.isEmpty()){
//            System.out.println(p);
//            return;
//        }
//        char ch = up.charAt(0);
//        for(int i = 0; i <=p.length(); i++){
//            String f = p.substring(0,i);
//            String s = p.substring(i);
//            permute(f+ch+s,up.substring(1));
//        }
//    }
//}

public class PermutationString {
    public static void main(String[] args) {
        String str = "abc";
        permute(str.toCharArray(), 0);
    }

    static void permute(char[] arr, int index) {
        if (index == arr.length) {
            System.out.println(String.valueOf(arr));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            permute(arr, index + 1);
            swap(arr, i, index); // backtrack
        }
    }

    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

