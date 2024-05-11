public class Factorial {
    public static Long pureRecursive(int n){
        if(n < 1){
            throw new IllegalArgumentException("IllegalArgumentException");
        }
        if(n == 1){
            return Long.valueOf(1);
        }
        else{
            return n * pureRecursive(n -1);
        }
    }
    public static Long tailRecursive(int n ){
        return tail(n);
    }
    private static Long tail(int s){
        if(s < 1){
            throw new IllegalArgumentException("IllegalArgumentException");
        }
        if(s <= 1){
            return Long.valueOf(1);
        }
        return s*tail(s-1);
    }
    public static Long iterative(int n){
        if(n < 1){
            throw new IllegalArgumentException("IllegalArgumentException");
        }
        Long ans = Long.valueOf(n);
        for(int i = n-1; i > 0; i--){   //for loop going through and multiplying by the previous number
            ans *= i;
        }
        return ans;
    }
}
