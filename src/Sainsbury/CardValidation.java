package Sainsbury;

public class CardValidation {
    public static void main(String[] args) {
        CardValidation n = new CardValidation();
        System.out.println(n.isValid("4242424242426742"));
        System.out.println(n.isValid("11111111111111111111111111111111"));
    }

    public boolean isValid(String cardNumber) {
        int sum = 0;
        StringBuilder sb = new StringBuilder(cardNumber);
        boolean flag = false;
        for(int i = sb.length() - 1; i >= 0; i--) {
            char ch = sb.charAt(i);
            int digit = ch - '0';
            sum += flag ? getSingleDigit(digit * 2): digit;
            flag = !flag;
        }
        double lastDigit = sum % 10;
        return lastDigit == 0;
    }

    private int getSingleDigit(int digit) {
        int sum = 0;
        while (digit > 0) {
            sum += digit % 10;
            digit /= 10;
        }
        return sum;
    }
}
