package com.esolonari.generics;

import java.util.Arrays;

public class GenericMethods implements Comparable<Object> {
    private static GenericMethods genericMethods;

    public Object[] swapArrayElements(Object[] array) {
        int flag = 0;
        Object[] firstHalf = Arrays.copyOfRange(array, 0, array.length / 2);
        Object[] secondHalf = Arrays.copyOfRange(array, (array.length / 2), array.length);
        if (array.length % 2 == 0) {
            for (int i = 0; i < firstHalf.length; i++) {
                array[i] = secondHalf[i];
                flag++;
            }
            for (int j = 0; j < secondHalf.length; j++) {
                array[flag++] = firstHalf[j];
            }
        } else {
            System.out.println("Wrong size of array : " + array.getClass().getSimpleName());
        }

        return array;
    }

    public Object[] pairSwapElements(Object[] array) {
//        Object[] newArray = new Object[array.length];
        for (int i = 0; i < array.length; i += 2) {
            Object aux = array[i];
            array[i] = array[i + 1];
            array[i + 1] = aux;
        }
        return array;
    }

    public int numberOfOccurences(Object[] array, Object param) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (param == array[i]) {
                result++;
            }
        }
        System.out.println("Param: " + param + " => " + result);
        return result;
    }

    public Object secondLargestNumber(Comparable[] array) {
        Object result;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i].compareTo(array[j]) < 0) {
                    result = array[i];
                    array[i] = array[j];
                    array[j] = (Comparable) result;
                }
            }
        }
        System.out.print("Second largest number in array: " + array[array.length - 2]);
        return array[array.length - 2];
    }

    public Object[] bubbleSort(Comparable[] array) {
        Object aux;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = (Comparable) aux;
                }
            }
        }

        return array;
    }

    public Object[] recursiveBubbleSort(Comparable[] array, int n) {
        Object aux;
        for (int i = 0; i < n - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                aux = array[i];
                array[i] = array[i + 1];
                array[i + 1] = (Comparable) aux;
            }
            recursiveBubbleSort(array, n - 1);
        }
        return array;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
