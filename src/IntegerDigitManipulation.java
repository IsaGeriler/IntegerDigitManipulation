import java.util.Scanner;

public class IntegerDigitManipulation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        menu();
        while(true){
            System.out.print("\nChoose an action to perform: ");
            int action = scn.nextInt();

            switch(action){
                case 1:
                    System.out.print("Enter the number to find its least significant digit: ");
                    int number1 = scn.nextInt();
                    System.out.println("The least significant digit: " + digitZero(number1));
                    break;
                case 2:
                    System.out.print("Enter the number: ");
                    int number2 = scn.nextInt();
                    System.out.print("Enter i: ");
                    int i1 = scn.nextInt();
                    System.out.println("ith digit: " + digitI(number2, i1));
                    break;
                case 3:
                    System.out.print("Enter the number to find digit sum: ");
                    int number3 = scn.nextInt();
                    System.out.print("Enter a limit: ");
                    int limit = scn.nextInt();
                    System.out.println("The limit digit sum is calculated as: " + digitLimitSum(number3, limit));
                    break;
                case 4:
                    System.out.print("Enter the number: ");
                    int number4 = scn.nextInt();
                    System.out.print("Which number you're looking for: ");
                    int targetNumber1 = scn.nextInt();
                    System.out.println(targetNumber1 + " exists in " + number4 + " " +
                            digitCount(number4, targetNumber1) + " times.");
                    break;
                case 5:
                    System.out.print("Enter the number to remove digit: ");
                    int number5 = scn.nextInt();
                    System.out.print("Which digit to remove: ");
                    int removeDigitK = scn.nextInt();
                    System.out.println("Removed digit: " + removeDigitK(number5, removeDigitK));
                    break;
                case 6:
                    System.out.print("Enter the digit: ");
                    int number6 = scn.nextInt();
                    System.out.print("Remove digit with value: ");
                    int removeDigitWithValue = scn.nextInt();
                    System.out.println("Number after removal: " + digitRemove(number6, removeDigitWithValue));
                    break;
                case 7:
                    System.out.print("Enter the digit count: ");
                    int digit = scn.nextInt();
                    System.out.println("Generated random number with " + digit + " digits: " + randomNumber(digit));
                    break;
                case 8:
                    System.out.print("Enter the number to invert: ");
                    int number8 = scn.nextInt();
                    System.out.println("Reverse is found as: " + reverse(number8));
                    break;
                case 9:
                    System.out.print("Enter the number to check: ");
                    int number9 = scn.nextInt();
                    System.out.println("Is palindrome: " + isPalindrome(number9));
                    break;
                case 10:
                    System.out.print("Enter a string: ");
                    String str = scn.nextLine();
                    System.out.println("CharDigitSum: " + charDigitSum(str));
                    break;
                case 11:
                    System.out.print("Exiting the program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid action, please try again!");
                    break;
            }
        }
    }

    public static void menu(){
        System.out.println("Digits Library Menu:");
        System.out.println("1. Least significant digit");
        System.out.println("2. ith digit");
        System.out.println("3. Sum of the digits with limit");
        System.out.println("4. Count digits");
        System.out.println("5. Remove digitK");
        System.out.println("6. Remove digit with value");
        System.out.println("7. Generate random number");
        System.out.println("8. Reverse digits");
        System.out.println("9. Check palindrome");
        System.out.println("10. CharDigitSum");
        System.out.println("11. Quit");
    }

    public static int digitZero(int number){
        return number % 10;
    }

    public static int digitI(int number, int i){
        if(Math.pow(10, i) < 1 || Math.pow(10, i) > number)
            return -1;
        return number / (int) Math.pow(10, i) % 10;
    }

    public static int digitLimitSum(int number, int limit){
        int i = 0;
        int limitSum = 0;
        int greaterThanLimit;
        while (Math.pow(10, i) < number){
            if(number / (int) Math.pow(10, i) % 10 > limit){
                greaterThanLimit = number / (int) Math.pow(10, i) % 10;
                limitSum += greaterThanLimit;
            }
            i++;
        }
        return limitSum;
    }

    public static int digitCount(int number, int targetNumber){
        int i = 0;
        int count = 0;
        while (Math.pow(10, i) < number){
            if(number / (int) Math.pow(10, i) % 10 == targetNumber)
                count++;
            i++;
        }
        return count;
    }

    public static int removeDigitK(int number, int digitK){
        int i = 0;
        int newNumber = 0;
        while (Math.pow(10, i) < number){
            if(i < digitK)
                newNumber += (number / (int) Math.pow(10, i) % 10) * (int) Math.pow(10, i);
            else if(i > digitK)
                newNumber += (number / (int) Math.pow(10, i) % 10) * (int) Math.pow(10, i - 1);
            i++;
        }
        return newNumber;
    }

    public static int digitRemove(int number, int targetNumber){
        int newNumber = 0;
        int occurrence = 0;
        int i = 0;
        while (Math.pow(10, i) < number){
            if(number / (int) Math.pow(10, i) % 10 == targetNumber)
                occurrence++;
            else
                newNumber += (number / (int) Math.pow(10, i) % 10) * (int) Math.pow(10, i - occurrence);
            i++;
        }
        return newNumber;
    }

    public static int randomNumber(int k){
        int randomNumber = (int) Math.floor(Math.random() * (Math.pow(10, k) - Math.pow(10, k - 1) + 1)
                + Math.pow(10, k - 1));
        int tempNumber = randomNumber;
        int[] digits = new int[10];
        int index;

        do{
            index = tempNumber % 10;
            digits[index]++;
            if (digits[index] > 1)
                return randomNumber(k);
            tempNumber /= 10;
        } while (tempNumber > 0);
        return randomNumber;
    }

    public static int reverse(int number){
        int lastDigit;
        int reverse = 0;
        while(number > 0){
            lastDigit = number % 10;
            reverse = (reverse * 10) + lastDigit;
            number /= 10;
        }
        return reverse;
    }

    public static boolean isPalindrome(int number){
        return number == reverse(number);
    }

    public static int charDigitSum(String str){
        int sum = 0;
        char[] charArrayOfString = str.toCharArray();
        for(char ch : charArrayOfString)
            sum += ch;
        return sum;
    }
}