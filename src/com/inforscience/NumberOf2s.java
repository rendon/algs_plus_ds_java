package com.inforscience;

public class NumberOf2s {
    public int f(int n)
    {
        if (n < 10) {
            return (n > 1) ? 1: 0;
        }

        int t = 0;
        int p = 1;
        while (p * 10 < n) {
            t = t * 10 + p;
            p *= 10;
        }

        int d = n / p;
        t *= d;

        if (d > 2) {
            t += p;
        } else if (d == 2) {
            t += n - d * p + 1;
        }

        return t + f(n - d * p);
    }

    public int g(int n)
    {
        int t = 0;
        for (int i = 1; i <= n; i++) {
            String digits = i + "";
            digits = digits.replaceAll("[^2]", "");
            t += digits.length();
        }

        return t;
    }
}
