// 问题1.19的源代码
public class Fibonacci
{
	// 原代码 递归存在重复
	public static long F(int N)
	{
		if (N == 0) return 0;
		if (N == 1)	return 1;
		return F(N-1) + F(N-2);
	}
	// 这是优化之后的代码
	public static long F_change(int next,int last,int n) {
		if (n>2)	return F_change(next+last,next,n-1);
		return next;
	}
	public static void main(String[] args) 
	{
		for (int N = 0; N<100; N++)	
			System.out.println(N + " " + F(N));
	}
}
// 问题1.27
public class Binomial { 

    // slow
	// 递归产生2^n个函数调用
    public static double binomial1(int N, int k, double p) {
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        return (1.0 - p) *binomial1(N-1, k, p) + p*binomial1(N-1, k-1, p);
    }

    // memoization
	// 这是优化之后的代码
    public static double binomial2(int N, int k, double p) {
        double[][] b = new double[N+1][k+1];

        // base cases
        for (int i = 0; i <= N; i++)
            b[i][0] = Math.pow(1.0 - p, i);
        b[0][0] = 1.0;

        // recursive formula
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= k; j++) {
                b[i][j] = p * b[i-1][j-1] + (1.0 - p) *b[i-1][j];
            }
        }
        return b[N][k];
    }

    public static void main(String[] args) { 
        int N = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        double p = Double.parseDouble(args[2]);
        StdOut.println(binomial1(N, k, p));
        StdOut.println(binomial2(N, k, p));
    }

}