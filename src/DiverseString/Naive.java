package DiverseString;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Given letters A, B, and C, print a diverse string. A diverse string is one is which no 3 distinct
 * characters are consecutive. Input consists of counts for each letter A, B, and C.
 * Output a diverse string which satisfies the above condition.
 *
 * Example:
 * Input:
 * 6 4 1
 * Output:
 * AABBAABBAAC
 *
 * Input:
 * 4 0 0
 * Output:
 * AA
 *
 * Input:
 * 3 3 3
 * Output:
 * AABBCCABC
 *
 */
class Naive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(new Naive().solution(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
    }

    public String solution(int A, int B, int C) {
        StringBuilder sb = new StringBuilder();
        LetterCount letterCounts[] = new LetterCount[]{
                new LetterCount('A', A),
                new LetterCount('B', B),
                new LetterCount('C', C)
        };
        sortLettersByCountDecreasing(letterCounts);
        char lastLetterPrinted = 0;
        while (true) {
            int flag = 0; // set a flag to alternate between letters
            for (LetterCount letterCount : letterCounts) {
                if (letterCount.count >= 2) {
                    sb.append(printNTimes(letterCount.letter, 2));
                    lastLetterPrinted = letterCount.letter;
                    letterCount.count -= 2;
                    flag++;
                } else if (letterCount.count == 1) {
                    sb.append(printNTimes(letterCount.letter, 1));
                    lastLetterPrinted = letterCount.letter;
                    letterCount.count -= 1;
                    flag++;
                }
                if (flag == 2 || !hasMoreDiverseStrings(letterCounts))
                    break;
            }
            if (!hasMoreDiverseStrings(letterCounts)) {
                // print any last letter with count ≠ 0 except the last printed letter N times
                for (LetterCount letterCount : letterCounts) {
                    if (letterCount.letter == lastLetterPrinted)
                        continue;
                    if (letterCount.count != 0) {
                        if (letterCount.count >= 2) {
                            sb.append(printNTimes(letterCount.letter, 2));
                            letterCount.count -= 2;
                        } else if (letterCount.count == 1) {
                            sb.append(printNTimes(letterCount.letter, 1));
                            letterCount.count -= 1;
                        }
                    }
                }
                break;
            }
            sortLettersByCountDecreasing(letterCounts);
        }
        return sb.toString();
    }

    private void sortLettersByCountDecreasing(LetterCount[] letterCounts) {
        Arrays.sort(letterCounts, (o1, o2) -> {
            if (o1.count < o2.count) {
                return 1;
            } else if (o1.count == o2.count) {
                return 0;
            }
            return -1;
        });
    }

    private boolean hasMoreDiverseStrings(LetterCount[] list) {
        for (int i = 0; i < list.length; i++) {
            if ((list[i].count + list[(i + 1) % list.length].count) == 0) {
                return false;
            }
        }
        return true;
    }

    private String printNTimes(char letter, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(letter);
        }
        return sb.toString();
    }

    class LetterCount {
        char letter;
        int count;

        LetterCount(char letter, int count) {
            this.letter = letter;
            this.count = count;
        }
    }
}
