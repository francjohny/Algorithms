package leetcode.two.two.four.one;

import java.util.Arrays;

class ATM {

    final int[] denominations = new int[]{20, 50, 100, 200, 500};
    long[] notes;
    public ATM() {
        notes = new long[5];
    }
    
    public void deposit(int[] banknotesCount) {
        for(int i = 0; i < banknotesCount.length; i++) {
            notes[i] += banknotesCount[i];
        }
        // System.out.println("Deposit: " + Arrays.toString(notes));
    }
    
    public int[] withdraw(int amount) {
        // System.out.println("Withdraw: " + amount + " "+ Arrays.toString(notes));
        long[] notesToUser = new long[5];
        for(int i = notesToUser.length - 1; i >= 0; i--) {
            notesToUser[i] = Math.min(notes[i], amount / denominations[i]);
            amount -= notesToUser[i] * denominations[i];
        }
        if (amount > 0) {
            return new int[]{-1};
        }
        for(int i = 0; i < notesToUser.length; i++) {
            notes[i] -= notesToUser[i];
        }
        return Arrays.stream(notesToUser).mapToInt(i -> (int) i).toArray();
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */
