public class Tasks {
    public static void main(String[] args) {
        System.out.println("Test tasks");
        int[] forEvens = {1, 2, 3, 4, 5};
        int[] forSum = {1, 2, 3, 4, -5};
        int[] oddSum = {44, 12, 20, 1, -1, 3, 5, -1, 99, 4};
        int countEven = countEven(forEvens);
        System.out.println(countEven);
        int sumValues = sumValues(forSum, true);
        System.out.println(sumValues);
        int odd = oddSum(oddSum);
        System.out.println(odd);
        int score = calculateScore(2, 3);
        System.out.println(score);
        int hasDoubled = hasDoubled(1000.0, 4);
        System.out.println(hasDoubled);
        int[] three1 = {3, 1, 3, 1, 3};
        int[] three2 = {3, 1, 3, 3};
        int[] three3 = {3, 4, 3, 3, 4};
        System.out.println(haveThree(three1));
        System.out.println(haveThree(three2));
        System.out.println(haveThree(three3));

    }

    // Необходимо для каждой задачи реализовать представленную функцию.
// Решать можно как в IDE, так и в бразуере. Но если Вы решаете в IDE,
// желательно не использовать подсказки по улучшению кода.
// Если у Вас возникли проблемы с английским, напишите мне, пожалуйста, я переведу условие :)
// Прислать ответ можно любым удобным вам способом - файл, текст и тд
// (но будет здорово, если сохранится то форматирование, которое было у Вас)

// Exercise: 1.even
// The countEven method returns the number of even integers in the values-array.
//
// Example test case: {1,2,3,4,5} returns 2. You don't have to deal with negative numbers.

    public static int countEven(int[] values) {
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }

////////////////////////////////////////////////////////////////////////////////////

// Exercise: 2.sumvalues
// The sumValues method adds up all numbers from the values-array,
// or only the positive numbers if the positivesOnly boolean parameter is set to true.
//
// Example test case: calling sumvalues with {1,2,3,4,-5} and true returns 10.

    public static int sumValues(int[] values, boolean positivesOnly) {
        int result = 0;
        for (int value : values) {
            if (value >= 0 || !positivesOnly) {
                result += value;
            }
        }
        return result;
    }

////////////////////////////////////////////////////////////////////////////////////

// Exercise: 3.oddsum
// The method oddSum returns the sum of all numbers at an odd index in the array parameter,
// until the number -1 is seen at an odd index.
//
// Example test case: {44, 12, 20, 1, -1, 3, 5,-1, 99, 4} returns 16 (12+1+3)

    public static int oddSum(int[] array) {
        int result = 0;
        if (array.length < 2) {
            return result;
        }
        for (int i = 1; i < array.length; i += 2) {
            if (array[i] != -1) {
                result += array[i];
            } else {
                return result;
            }
        }
        return result;
    }

////////////////////////////////////////////////////////////////////////////////////

// Exercise: 4.score
// The calculateScore method calculates the score for a train trip. The highest score is 10.
// The score is based on the number of changes and the day of the week (Monday is 1, Sunday is 7).
//
// Dutch Railways (NS) has designed the following calculation:
// Base score: 10
// For each change: -1
// Trip on a weekday: -3
//
// Example test case: for a trip with 2 changes on a Wednesday (day 3), calculateScore(2, 3) returns a score of 5 (10-2-3)

    public static int calculateScore(int changes, int day) {
        int score = 10 - changes;
        if (day > 0 && day < 6) {
            score = score - 3;
        }
        return score;
    }

////////////////////////////////////////////////////////////////////////////////////

// Exercise: 5.double
// Write a program that calculates in how many years your savings have doubled with the given interest (as a percentage).
//
// An example: if your savings are 1000 euros and the interest is 4%, it will take you 18 years to double your savings
// (then you'll have more than 2000 euros).

    public static int hasDoubled(double savings, int interest) {
        int yearsNumber = 0;
        double index = (interest / 100.0) + 1.0;
        double desiredSum = savings * 2;
        while (savings < desiredSum) {
            yearsNumber++;
            savings = savings * index;
        }
        return yearsNumber;
    }

////////////////////////////////////////////////////////////////////////////////////

// Exercise: 6.havethree
// Given an array of ints, return true if the value 3 appears in the array exactly 3 times,
// and no 3's are next to each other.
//
// Example test cases:
// haveThree with {3, 1, 3, 1, 3} returns true
// haveThree with {3, 1, 3, 3} returns false
// haveThree with {3, 4, 3, 3, 4} returns false

    public static boolean haveThree(int[] nums) {
        int countThrees = 0;
        int lastThreeIndex = -2;
        int dif;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 3) {
                countThrees++;
                dif = i - lastThreeIndex;
                if (dif == 1) {
                    return false;
                }
                lastThreeIndex = i;
            }
        }
        return countThrees == 3;
    }
}
