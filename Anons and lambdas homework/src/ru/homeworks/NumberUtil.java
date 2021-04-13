package ru.homeworks;

public  class NumberUtil {

    //число для преобразования
    int number;

    public NumberUtil(int number) {
        this.number = number;
    }

    public int process(NumbersProcess numbersProcess){
        return numbersProcess.process(number);
    }
}
