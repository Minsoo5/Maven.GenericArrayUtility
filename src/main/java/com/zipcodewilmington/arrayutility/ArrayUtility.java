package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    private T[] array;

    public ArrayUtility(T[] inputArray) {
        this.array = inputArray;
    }





    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        //Make a new array to merge two arrays into
        T[] newArray = (T[]) Array.newInstance(arrayToMerge.getClass(), array.length + arrayToMerge.length);
        int lengthOfBaseArray = array.length;

        //Merge!!!!
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        for (int i = array.length; i < arrayToMerge.length + lengthOfBaseArray; i++) {
            newArray[i] = arrayToMerge[i];
        }
        //Count ValueToEvaluate!!!!

        int duplicate = getNumberOfOccurrences((T) newArray);

        return duplicate > 0 ? duplicate -1 : duplicate;

    }











    public T[] removeValue(T valueToRemove) {

        int sizeModifier = getNumberOfOccurrences(valueToRemove);  //How many to remove

        //New array created with the size modified how many we are expecting to remove
        T[] newArray = (T[]) Array.newInstance(valueToRemove.getClass(), array.length - sizeModifier);
        int newArrayIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals(valueToRemove)) {
                newArray[newArrayIndex] = array[i];
                newArrayIndex++;

            }
        }
        return newArray;
    }




    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        int counter = 0;                                //Keep track of how many

        for (int i = 0; i < array.length; i++) {        //Go through the array
            if(array[i].equals(valueToEvaluate)) {           //Counter up if valueToEvaluate matches
                counter++;
            }
        }
        return counter;            //   )>'_')>
    }










    public T getMostCommonFromMerge(T[] arrayToMerge) {
        return null;
    }





}
