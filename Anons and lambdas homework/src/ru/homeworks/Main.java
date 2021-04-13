package ru.homeworks;

import java.util.Scanner;

public class Main {

        static int reverse(int number1){
         int newNumber = 0;
         while ( number1 != 0){
             int digit = number1 % 10;
             newNumber = newNumber * 10 + digit;
             number1 /= 10;
         }
         return newNumber;
       }

       static int DeleteZeroInNumber(int number1) {
        int newNumber = 0;
        while ( number1 != 0){
            int digit = number1 % 10;
            if (digit != 0) newNumber = newNumber * 10 + digit;
            number1 /= 10;
            }
        newNumber = reverse(newNumber);
        return newNumber;
        }

        static int evenConversion(int number1){
         int newNumber = 0;
         while ( number1 != 0){
             int digit = number1 % 10;
             if (digit % 2 != 0){
                newNumber = newNumber * 10 + digit-1;
             }
             else {
                 newNumber = newNumber * 10 + digit;
             }
             number1 /= 10;

         }
         newNumber = reverse(newNumber);
         return newNumber;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        int number = scanner.nextInt();

        //преобразование в обратный порядок
        NumbersProcess numberProcess1 = Main::reverse;
        //удаление нулей из числа
        NumbersProcess numberProcess2 = Main::DeleteZeroInNumber;
        //перевод чисел в четные
        NumbersProcess numberProcess3 = Main::evenConversion;

        NumberUtil numberUtil = new NumberUtil(number);

        System.out.println("1 процесс над числом " + number + " - " + numberUtil.process(numberProcess1));
        System.out.println("2 процесс над числом " + number + " - " + numberUtil.process(numberProcess2));
        System.out.println("3 процесс над числом " + number + " - " + numberUtil.process(numberProcess3));
        System.out.println("\n");

        String stringToProcess = scanner.next();

        StringProcess stringProcess1 = process -> {
            char[] array = process.toCharArray();
            StringBuilder result = new StringBuilder();
            for (int i = array.length - 1; i >= 0; i--) {
                result.append(array[i]);
            }
            return result.toString();
        };
        StringProcess stringProcess2 = process -> process.replaceAll("\\d", "");
        StringProcess stringProcess3 = String::toUpperCase;

        StringUtil stringUtil = new StringUtil(stringToProcess);

        System.out.println("1 процесс над строкой: " + stringToProcess + " - " + stringUtil.procces(stringProcess1));
        System.out.println("2 процесс над строкой: " + stringToProcess + " - " + stringUtil.procces(stringProcess2));
        System.out.println("3 процесс над строкой: " + stringToProcess + " - " + stringUtil.procces(stringProcess3));




    }
}
