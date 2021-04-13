package ru.homeworks;

public class StringUtil {
    String stringToProcess;

    public StringUtil(String stringToProcess) {
        this.stringToProcess = stringToProcess;
    }

    public String getStringToProcess() {
        return stringToProcess;
    }

    public String procces(StringProcess stringProcess){
        return stringProcess.process(stringToProcess);
    }
}
