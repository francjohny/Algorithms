package ProjectEuler;

public class PrimeTriplets {
    public static void main(String[] args) {
        int row = 8, column = 0, sum = 0;
        for (int start = 1 + ((row - 1) * row / 2), end = start + row - 1; start <= end; start++, column++) {
            System.out.print(start + " ");
            if (isPrimeTriplet(row, column, start, 0))
                sum += start;
        }
        System.out.println(sum);
    }

    private static boolean isPrimeTriplet(int row, int column, int number, int count) {
        if (!isPrime(number))
            return false;
        if(isPrimeTriplet(row, column, anyNeighbour(number, row, column), count)) {
            count += 1;
            if (count == 2)
                return true;
        }
        return false;
    }

    // TODO
    private static int anyNeighbour(int number, int row, int column) {
        return 1;
    }

    private static boolean isPrime(int number) {
        if (number % 2 == 0)
            return false;
        for (int i = 3; i * i <= number; i+= 2) {
            if ((number % i) == 0)
                return false;
        }
        return true;
    }
}
