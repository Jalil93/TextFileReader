package leetCodeSolutions;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

public class Solutions {

    public static void main(String[] args) throws FileNotFoundException {


//        int[] nums = {1, 2, 3, 4};
//        runningSum(nums);

//        int[] nums = {1,7,3,6,5,6};
//        pivotIndex(nums);

//        System.out.println(isIsomorphic("egg", "add"));

//        How do you check whether a string is a palindrome in Java?
//        System.out.println("Is it a palindrome: "+palindrome("a"));

//        How do you find the second largest number in an array in Java?
//        int[] array = {1,2,3,4,5,3456,3456,45,42,23,65,456,23,66,33,81};
//        int result = secondLargestNumberFromArray(array);
//        System.out.println(result);

//        How can you find a string in a text file in Java?
//          boolean containedInFile = stringFromFile(new File("C:\\Users\\PC\\IdeaProjects\\Testing\\src\\main\\java\\list.txt"), "jalapeno");
//          System.out.println(containedInFile);

        //1672 from leetcode
//        int[][] wealth = {{1,5},{7,3},{3,5}};
//        System.out.println(solution1672(wealth));

        System.out.println(fizzBuzz412(25));


    }

    public static int[] runningSum(int[] nums) {
        int[] sumsOfNums = nums;
        int currentSum = 0;
        for(int i=0; i<nums.length; i++){
            currentSum = currentSum + nums[i];
            sumsOfNums[i] = currentSum;
        }
        return sumsOfNums;
    }

    public int maxProfit(int[] prices){

        LinkedList<Integer> priceList = new LinkedList<Integer>();

        for (int i=0; i<prices.length; i++) {
            priceList.add(prices[i]);
        }

        int minPrice = priceList.get(0);
        int maxPrice = priceList.get(0);
        for (int i=0; i<priceList.size(); i++){
            if(priceList.get(i) <minPrice){
                minPrice = priceList.get(i);
            }
            if(priceList.get(i)>maxPrice){
                maxPrice = priceList.get(i);
            }
        }

        int buyDay = priceList.indexOf(minPrice);
        int sellDay = priceList.indexOf(maxPrice);
        int profit;

        if(sellDay>buyDay){
            profit = maxPrice - minPrice;
        }
        else{
            profit=0;
        }
        return profit;
    }

    public static int pivotIndex(int[] nums) {
        // Input: nums = [1,7,3,6,5,6]
        // Output: 3

        int leftSum=0;
        int rightSum=0;
        int thePivotIndex = -1;
        int totalSum = 0;
        int length = nums.length;



        for(int i = 1; i < length+1; i++){
//            if(i == 0){
//                leftSum = 0;
//            }

            leftSum = leftSum + nums[i-1];

            for (int j=i+1; j<length+1; j++) {
                rightSum = rightSum + nums[j];
            }

            if(rightSum == leftSum ){
                break;
            }
            thePivotIndex = i;
//            leftSum = leftSum + nums[i];
//            for(int j = i+1)
        }
        return thePivotIndex;
    }

    public static boolean isIsomorphic(String s, String t) {

//        Input: s = "egg", t = "add"
//        Output: true

//        Input: s = "paper", t = "title"
//        Output: true


        boolean result = false;

        for(int i = 0; i<s.length();i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            t = t.replace(tChar, sChar);
            if(s.equals(t)){
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean isSubsequence(String s, String t) {

        boolean result = false;
        Character letter;
        Integer currentIndex;
        Integer lastIndex = -1;

        Map<Character, Integer> mapping = new LinkedHashMap<Character, Integer>();

        for(int i=0; i<s.length(); i++){
            letter = s.charAt(i);
            currentIndex = t.indexOf(letter);
            mapping.put(letter, currentIndex);
            if(currentIndex<=lastIndex){
                result = false;
                break;
            } else{
                lastIndex = currentIndex;
                result = true;
            }
        }
        if(s.isEmpty()){
            result = true;
        } else if(s.length() == t.length()){
            if(s == t){
                result = true;
            }
            else{
                result = false;
            }
        }
        else if(t.isEmpty()) {
            result = false;
        }

        // if(mapping.containsValue(-1)){
        //     result = false;
        // } else{
        //     result = true;
        // }

        return result;
    }

    public static boolean palindrome(String input) {

        char[] chars = input.toCharArray();
        int length = chars.length;

        char[] reversechars = new char[length];

        for(int i=0; i<length;  i++){
            reversechars[i] = chars[length-1-i];
        }

        return Arrays.equals(chars, reversechars);
    }

    public static int secondLargestNumberFromArray(int[] input) {
        int max = 0;
        int maxTwo = 0;
        for(int i : input){
            if(i>max){
                maxTwo = max;
                max = i;
            }
        }
        return maxTwo;
    }

    public static boolean stringFromFile(File file, String targetString) throws FileNotFoundException {
        Scanner in = new Scanner(
                new FileReader(file.getAbsolutePath())
        );
        StringBuilder sb = new StringBuilder();

        while(in.hasNext()) {
            sb.append(in.next());
        }
        in.close();
        String fileAsString =  sb.toString();
        boolean result = fileAsString.contains(targetString);
        return result;
    }

    public static int solution1672(int[][] accounts) {
        int numberCustomers = accounts.length;
        int[] eachCustomerWealth = new int[numberCustomers];
        for(int i=0; i<numberCustomers; i++){
            for(int j=0; j<accounts[i].length; j++){
                eachCustomerWealth[i] += accounts[i][j];
            }
        }
        int maxWealth = 0;
        for(int i: eachCustomerWealth){
            if(i>maxWealth){
                maxWealth=i;
            }
        }
        return maxWealth;
    }

    public static List<String> fizzBuzz412(int n) {
        List<String> list = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(i%3==0 && i%5==0){
                list.add("FizzBuzz");
            }
            else if(i%3==0){
                list.add("Fizz");
            }
            else if(i%5==0){
                list.add("Buzz");
            } else{
                list.add(Integer.toString(i));
            }
        }
        return list;
    }

    public int numberOfSteps1342(int num) {
        int stepCount = 0;
        while(num!=0){
            if(num%2==0){
                num = num/2;
            } else {
                num = num -1;
            }
            stepCount++;
        }
        return stepCount;
    }

//    public ListNode middleNode876(ListNode head) {
//        ListNode middle = head;
//        ListNode end = head;
//
//        while(end !=null && end.next != null){
//            end = end.next.next;
//            middle = middle.next;
//        }
//        return middle;
//    }

    public void canConstruct383(String ransomNote, String magazine) {

    HashMap<Character, Integer> ransomMap = new HashMap<Character, Integer>();

    char[] charArr = ransomNote.toCharArray();

    for(char c: charArr){
        int value = ransomMap.get(c);
        ransomMap.put(c, value+1);
        }

    }


}
