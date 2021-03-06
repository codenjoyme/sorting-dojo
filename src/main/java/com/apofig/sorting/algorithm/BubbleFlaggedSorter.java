package com.apofig.sorting.algorithm;

import com.apofig.sorting.Array;
import com.apofig.sorting.Sorter;

/**
 * User: oleksandr.baglai
 * Date: 1/17/13
 * Time: 3:25 PM
 * Second sample from http://ru.wikipedia.org/wiki/%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0_%D0%BF%D1%83%D0%B7%D1%8B%D1%80%D1%8C%D0%BA%D0%BE%D0%BC
 */
public class BubbleFlaggedSorter implements Sorter {

    @Override
    public void sort(Array data) {
        int size = data.size();
        for (int j = 0; j < size - 1; j++) {
            boolean f = false;
            for (int i = 0; i < size - j - 1; i++) {
                if (data.get(i).compareTo(data.get(i + 1)) > 0) {
                    data.swap(i, i + 1);
                    f = true;
                }
            }
            if (!f) {
                break;
            }
        }
    }
}
