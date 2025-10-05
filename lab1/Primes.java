public class Primes {
    public static boolean isPrime(int n) {
        double sqrtNum = Math.sqrt(n);

        for (int i = 2; i <= sqrtNum; i++) {

            int remainder = n % i;
            if (remainder == 0) {

                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            boolean result = isPrime(i);

            if (result) {
                System.out.println(i);
            }

        }
    }
}