package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Select exercise number: ");
        int exNum = Integer.parseInt(sc.nextLine());
        switch (exNum) {
            case 1 -> findNumberOfDaysAboveAverageTemp();
            case 2 -> {
                int[] array = {1, 2, 3, 4};
                int[] middle = middle(array);
                System.out.println(Arrays.toString(middle));
            }
            case 3 -> {
                int[][] myArray2D = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
                int i = sumDiagonalElementsFunction(myArray2D);
                System.out.println(i);
            }
            case 4 -> {
                int[] myArray = {84, 85, 86, 87, 85, 90, 85, 83, 23, 45, 84, 1, 2, 0};
                int[] newArr = firstTopTwoScores(myArray);
                System.out.println(Arrays.toString(newArr));
            }
            case 5 -> {
                int[] myArray = {1, 2, 3, 4, 5, 6, 8, 7};
                int missing = findMissingNumberInArray(myArray);
                System.out.println(missing);
            }
            case 6 -> {
                int[] output = removeDuplicates(new int[]{1, 1, 2, 2, 3, 4, 5});
                System.out.println(Arrays.toString(output));
            }
            case 7 -> {
                int length = removeDuplicates2(new int[]{1, 1, 2, 2, 2, 2, 2, 3, 4, 5, 5, 5, 6});
                System.out.println(length);
            }
            case 8 -> {
                int maxProfit = maxProfit(new int[]{7, 1, 5, 3, 6, 7});
                System.out.println(maxProfit);
            }
            case 9 -> {
                int[] output = twoSum(new int[]{2, 7, 11, 15}, 9);
                System.out.println(Arrays.toString(output));
            }
            case 10 -> {
                int index = searchInArray(new int[]{1, 2, 3, 4, 5, 6}, 6);
                System.out.println(index);
            }
            case 11 -> {
                String output = maxProduct(new int[]{10, 60, 30, 40, 50});
                System.out.println(output);
            }
            case 12 -> {
                System.out.println(isUnique(new int[]{1, 2, 3, 4, 5, 6}));
            }
            case 13 -> {
                System.out.println(permutation(new int[]{1, 2, 3, 4, 5}, new int[]{5, 1, 2, 3, 4}));
            }
        }
    }

    private static boolean permutation(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }

        int[] arr1Sorted = Arrays.stream(array1).sorted().toArray();
        int[] arr2Sorted = Arrays.stream(array2).sorted().toArray();
        return Arrays.equals(arr1Sorted, arr2Sorted);
    }

    private static boolean isUnique(int[] intArray) {
        for (int i = 0; i < intArray.length - 1; i++) {
            for (int j = i + 1; j < intArray.length; j++) {
                if (intArray[i] == intArray[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String maxProduct(int[] intArray) {
        String pairs = "";

        int max = 0;

        for (int i = 0; i < intArray.length - 1; i++) {
            for (int j = i + 1; j < intArray.length; j++) {
                if (intArray[i] + intArray[j] > max) {
                    pairs = intArray[i] + "," + intArray[j];
                    max = intArray[i] + intArray[j];
                }
            }
        }
        return pairs;
    }

    private static int searchInArray(int[] intArray, int valueToSearch) {
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == valueToSearch) return i;
        }
        return -1;
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] output = new int[]{-1, -1};
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    output[i] = i;
                    output[j] = j;
                    return output;
                }
            }
        }
        return null;
    }

    private static int maxProfit(int[] prices) {
        int lowestPrice = Integer.MAX_VALUE;
        int maxProfit = 0;


        for (int price : prices) {
            if (price < lowestPrice) {
                lowestPrice = price;
            } else if (price - lowestPrice > maxProfit) {
                maxProfit = price - lowestPrice;
            }
        }

        return maxProfit;
    }

    private static int removeDuplicates2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int c = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[c]) {
                c++;
                nums[c] = nums[i];
            }
        }
        return c + 1;
    }

    private static int[] removeDuplicates(int[] arr) {
        List<Integer> list = new ArrayList<>();

        for (int i : arr) {
            if (!list.contains(i)) {
                list.add(i);
            }
        }

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static int findMissingNumberInArray(int[] arr) {
        int n = arr.length + 1;

        int expectedSum = (n * (n + 1)) / 2;
        int actualSum = 0;

        for (int j : arr) {
            actualSum += j;
        }

        return expectedSum - actualSum;
    }

    private static int[] firstTopTwoScores(int[] myArray) {
        int[] newArr = {Integer.MIN_VALUE, Integer.MIN_VALUE};


        for (int score : myArray) {
            if (newArr[0] < score) {
                newArr[1] = newArr[0];
                newArr[0] = score;
            } else if (newArr[1] < score && newArr[0] > score) {
                newArr[1] = score;
            }
        }

        return newArr;
    }

    private static int sumDiagonalElementsFunction(int[][] myArray2D) {
        int total = 0;

        if (myArray2D.length != myArray2D[0].length) {
            //For square array->
            for (int i = 0; i < myArray2D.length; i++) {
                total += myArray2D[i][i];
            }
        } else {
            //For Jagged Array->
            for (int i = 0; i < myArray2D.length; i++) {
                for (int j = 0; j < myArray2D[i].length; j++) {
                    if (i == j) {
                        total += myArray2D[i][j];
                    }
                }
            }
        }

        return total;
    }

    private static int[] middle(int[] array) {
        if (array.length < 2) {
            return new int[0];
        }

        int[] newArr = new int[array.length - 2];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = array[i + 1];
        }
        return newArr;
    }

    private static void findNumberOfDaysAboveAverageTemp() {
        System.out.println("How many days' temperatures?");
        System.out.print("Enter days: ");

        int days = Integer.parseInt(sc.nextLine());

        double[] arr = new double[days];
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Day " + i + "'s high temp: ");
            double temp = Double.parseDouble(sc.nextLine());
            arr[i] = temp;
            sum += arr[i];
        }

        double average = sum / arr.length;
        System.out.println("Average: " + average);

        int counter = 0;

        for (double v : arr) {
            if (v > average) counter++;
        }

        System.out.println(counter + " day(s) above average");
    }
}
