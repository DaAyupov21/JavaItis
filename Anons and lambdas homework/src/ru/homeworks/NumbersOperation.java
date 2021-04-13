package ru.homeworks;

public class NumbersOperation {
    static int reverse(int number1){
        int newNumber = 0;
        while ( number1 != 0){
            int digit = number1 % 10;
            if (digit != 0) newNumber = newNumber * 10 + digit;
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
        newNumber = reverse(newNumber)       ;
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
}
