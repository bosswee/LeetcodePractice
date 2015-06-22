public class Test{
    public boolean isPalindromeNumber(long num){
        String str = num + "";
        int start = 0;
        int end = str.length() - 1;
        while(start <= end){
            char s = str.charAt(start);
            char e = str.charAt(end);
            if(s != e){
                return false;
            }else{
                start++;
                end--;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Test t = new Test();
        System.out.print(t.isPalindromeNumber(12321));// true
        System.out.print(t.isPalindromeNumber(1));// true
        System.out.print(t.isPalindromeNumber(12343)); //false
    }
}