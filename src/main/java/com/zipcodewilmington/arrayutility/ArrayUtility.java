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

    public T[] mergeArray(T[] arrayToMerge) {
        //Make a new array to merge two arrays into
        T[] newArray = (T[]) Array.newInstance(arrayToMerge[0].getClass(), array.length + arrayToMerge.length);
        int mergeCounter = 0;

        //Merge!!!!
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        for (int i = array.length; i < arrayToMerge.length + array.length; i++) {
            newArray[i] = arrayToMerge[mergeCounter];
            mergeCounter++;
        }

        return newArray;
    }



    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {

        //This method moved to its own apartment

//        //Make a new array to merge two arrays into
//        T[] newArray = (T[]) Array.newInstance(valueToEvaluate.getClass(), array.length + arrayToMerge.length);
//        int mergeCounter = 0;
//
//        //Merge!!!!
//        for (int i = 0; i < array.length; i++) {
//            newArray[i] = array[i];
//        }
//        for (int i = array.length; i < arrayToMerge.length + array.length; i++) {
//            newArray[i] = arrayToMerge[mergeCounter];
//            mergeCounter++;
//        }
//
       T[] newArray = mergeArray(arrayToMerge);

        //Count ValueToEvaluate!!!!
        this.array = newArray;
        int duplicate = getNumberOfOccurrences(valueToEvaluate);

        return duplicate;

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
        T[] newArray = mergeArray(arrayToMerge);
        int mostCommonCounter = 0;
        T mostCommonElement = null;

        for (int i = 0; i < newArray.length; i++) {
            int currentCounter = getNumberOfOccurrences(newArray[i]);
            if (currentCounter > mostCommonCounter) {
                mostCommonCounter = currentCounter;
                mostCommonElement = newArray[i];
            }
        }

        return mostCommonElement;
    }





}
