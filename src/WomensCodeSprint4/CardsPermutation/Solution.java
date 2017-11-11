package WomensCodeSprint4.CardsPermutation;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    private static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> numbers = new ArrayList<>(IntStream.range(1, n + 1).boxed().collect(Collectors.toList()));
        List<Integer> perm = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            perm.add(in.nextInt());
        }
        List<Integer> notZero = perm.stream().filter(x -> x != 0).collect(Collectors.toList());
        numbers.removeAll(notZero);
        System.out.println("numbers = " + numbers);
        permute(new ArrayList<>(numbers), 0);
        System.out.println("list = " + list);
        long sum = 0;
        for (List<Integer> list: list) {
            notZero.forEach(value -> list.add(value - 1, value));
            System.out.println(Arrays.toString(list.toArray()));
            sum += findIndexOfPermutation("", Arrays.toString(list.toArray()));
        }
        System.out.println("sum = " + sum);
    }

    private static int findIndexOfPermutation(String prefix, String str) {
        String[] split = str.split("[ ]");
        long ids[] = new long[split.length];
        for (int i = 0; i < prefix.length(); i++) {
            ids[i] = str.indexOf(prefix.charAt(i));
        }

        int index = 0;
        int base = split.length ^ prefix.length() - 1;
        for (int i = 0; i < prefix.length(); i++) {
            index += base * ids[i];
            base = base / prefix.length();
        }
        return index;
    }

    static void permute(List<Integer> arr, int k){
        for(int i = k; i < arr.size(); i++){
            Collections.swap(arr, i, k);
            permute(arr, k + 1);
            Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){
            System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr.toArray()));
            list.add(arr);
        }
    }
}
