package Strings;

public class Streams {
    public static void main(String[] args) {
        skip("","bcadtaama");
        System.out.println(skip("tatoakea"));
    }
    static void skip(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if(ch == 'a'){
            skip(p, up.substring(1));
        }
        else{
            skip(p + ch, up.substring(1));
        }
    }
    static String skip(String str){
        if(str.isEmpty()){
            return "";
        }
        char ch = str.charAt(0);
        if(ch == 'a'){
            return skip(str.substring(1));
        }
        else{
            return ch + skip(str.substring(1));
        }
    }
}
