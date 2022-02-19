package com.apofig.sorting;

/**
 * User: oleksandr.baglai
 * Date: 1/17/13
 * Time: 4:52 PM
 */
public class ArrayCounter<T extends Comparable> implements ArrayRecorder<T> {

    private Array<T> array;

    private boolean record = false;
    private Statistic statistic;

    public ArrayCounter(Array<T> array) {
        this.array = array;
    }

    @Override
    public void stop() {
        record = false;
    }

    @Override
    public void record() {
        statistic = new Statistic();
        record = true;
    }

    @Override
    public Statistic getStatistic() {
        return statistic;
    }

    @Override
    public int size() {
        if (record) {
            statistic.inc(Operations.SIZE);
        }
        return array.size();
    }

    @Override
    public void swap(int index1, int index2) {
        if (record) {
            statistic.inc(Operations.GET);
            statistic.inc(Operations.GET);
            statistic.inc(Operations.SET);
            statistic.inc(Operations.SET);
        }
        array.swap(index1, index2);
    }

    @Override
    public Element<T> get(int index) {
        if (record) {
            statistic.inc(Operations.GET);
        }
        return array.get(index);
    }

    @Override
    public void set(int index, T value) {
        if (record) {
            statistic.inc(Operations.SET);
        }
        array.set(index, value);
    }

    @Override
    public void copy(int fromIndex, int toIndex) {
        if (record) {
            statistic.inc(Operations.GET);
            statistic.inc(Operations.SET);
        }
        array.copy(fromIndex, toIndex);
    }

    @Override
    public void set(int index, Element element) {
        if (record) {
            statistic.inc(Operations.SET);
        }
        array.set(index, element);
    }

    @Override
    public int compare(int index1, int index2) {
        if (record) {
            statistic.inc(Operations.GET);
            statistic.inc(Operations.GET);
        }
        return array.compare(index1, index2);
    }

    @Override
    public String toString() {
        return array.toString();
    }
}
