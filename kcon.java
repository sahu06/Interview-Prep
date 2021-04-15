import java.util.*;

class kcon {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        long t = scn.nextLong();
        
        while(t-- > 0) {
            long n = scn.nextLong(), k = scn.nextLong();
            long [] arr = new long[(int) n];

            for(long i = 0; i < n; i++) {
                arr[(int) i] = scn.nextLong();
            }

            if(k < 1000) {
                long jj = 0;
                long [] ar1 = new long[(int) (n * k)];

                for(long i = 0; i < k; i++) {
                    for(long j = 0; j < n; j++) {
                        ar1[(int) jj] = arr[(int) j];
                        jj++;
                    }
                }

                long ans = maxSum(ar1, jj);
                System.out.println(ans);
            }
            else {
                long kk = 0;
                long [] ar2 = new long[(int) (n * 40)];
                long [] ar3 = new long[40];
                long mm = 0;

                for(long i = 0; i < 40; i++) {
                    for(long j = 0; j < n; j++) {
                        ar2[(int) kk] = arr[(int) j];
                        kk++;
                    }
                    ar3[(int) mm] = maxSum(ar2, kk);
                    mm++;
                }

                if(ar3[(int) (mm - 1)] == ar3[(int) (mm - 2)]) System.out.println(ar3[(int) (mm-1)]);
                else System.out.println(ar3[2] + (k - 3)*(ar3[(int) (mm-1)] - ar3[(int) (mm-2)]));

            }
        }

        scn.close();
    }

    public static long maxSum (long [] ar1, long n) {
        long far = ar1[0];
        long curr = ar1[0];

        System.out.println(n);

        for(long i = 1; i < n; i++) {
            curr = Math.max(ar1[(int) i], curr + ar1[(int) i]);
            far = Math.max(far, curr);
        }

        return far;
    }
}