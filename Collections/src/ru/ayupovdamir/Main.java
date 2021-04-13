package ru.ayupovdamir;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	ArrayList<String> strings = new ArrayList<>();
	strings.add("Hello");
	strings.add("Damir!");
	/*strings.add(5);*/


	String value = strings.get(1);
	System.out.println(value);

	ArrayList<Scanner> scanners = new ArrayList<>();
	scanners.add(new Scanner(System.in));

	ArrayList<Integer> integers = new ArrayList<>();
	integers.add(123);
	integers.add(3594);
	integers.add(9402348);
	System.out.println(integers.get(1));
    }
}
