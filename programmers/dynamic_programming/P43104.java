class Solution {
    long[] fibo = new long[81];
    public long solution(long N) {return getFibo(N+1)*2+getFibo(N)*2;}
    long getFibo(long x){ return (x <= 2) ? 1 : ((fibo[(int)x] != 0) ? fibo[(int)x] : (fibo[(int)x] = getFibo(x-1) + getFibo(x-2)));}
}