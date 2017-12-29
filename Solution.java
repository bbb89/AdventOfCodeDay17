package com.lukasz;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int stepsForward;
    private List<Integer> circularBuffer;
    private int currentPosition;
    private int index;
    private int partISolution;
    private int partIISolution;
    private int fakeLength;

    public Solution(int stepsForward) {
        this.stepsForward = stepsForward;
        currentPosition = 0;
        index = 0;
        circularBuffer = new ArrayList<>();
        circularBuffer.add(0);

        int i = 0;

        for(; i < 2017; i++) {
            doACycle();
        }
        findValueAfter2017();

        fakeLength = circularBuffer.size();
        for(; i < 50000000; i++) {
            doAFakeCycle();
        }

    }

    private void findValueAfter0() {
        index = circularBuffer.indexOf(0);
        partIISolution = circularBuffer.get(index + 1);
    }

    private void findValueAfter2017() {
        index = circularBuffer.indexOf(2017);
        partISolution = circularBuffer.get(index + 1);
    }

    private void doAFakeCycle() {
        index += stepsForward;
        while(index >= fakeLength) index -= fakeLength;
        if(index == 0) partIISolution = currentPosition + 1;
        fakeLength++;
        index++;
        currentPosition++;
    }

    private void doACycle() {
        goForward();
        insertValue();
    }

    private void insertValue() {
        circularBuffer.add(++index, ++currentPosition);
    }

    private void goForward() {
        index += stepsForward;
        while(index >= circularBuffer.size()) index -= circularBuffer.size();
    }


    public int getPartISolution() {
        return partISolution;
    }

    public int getPartIISolution() {
        return partIISolution;
    }
}
