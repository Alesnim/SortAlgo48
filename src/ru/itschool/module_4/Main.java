package ru.itschool.module_4;

import edu.princeton.cs.algs4.*;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Integer[] a = new Random().ints().limit(10000).boxed().toArray(Integer[]::new);

        /*Stopwatch time = new Stopwatch();
        sortBubbles(a);
        double timeOne = time.elapsedTime();
        time = new Stopwatch();
        sortSelection(a);
        double timeTwo = time.elapsedTime();
        show(a);
        StdOut.print(timeOne);
        StdOut.print(timeTwo);*/
    }


    public static void sortBubbles(Comparable[] array) {
        int N = array.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(array[j], array[i])) {
                    min = j;
                    exch(array, i, min);
                }
            }
        }
    }


    public static void sortSelection(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            int pos = i;
            Comparable min = array[i];

            for (int j = i + 1; j < array.length; j++) {
                if (less(array[j], min)) {
                    pos = j;
                    min = array[j];
                }
            }
            array[pos] = array[i];
            array[i] = min;
        }
    }


    public static void sortInsert(Comparable[] array) {
        for (int left = 0; left < array.length; left++) {
            // Вытаскиваем значение элемента
            Comparable value = array[left];
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;
            for (; i >= 0; i--) {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (less(value, array[i])) {
                    array[i + 1] = array[i];
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем вытащенное значение
            array[i + 1] = value;
        }
    }

    public static void sortMerge(Comparable[] a){
        Merge.sort(a);
    }

    public static void sortMergeUp(Comparable[] a){
        MergeBU.sort(a);
    }


    public static void sortQuick(Comparable[] a){
        Quick.sort(a);
    }

    public static void sortQuickThreeMode(Comparable[] a){
        Quick3way.sort(a);
    }


    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] array, int i, int j) {
        Comparable t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    private static void show(Comparable[] array) {
        StdOut.println(
                Stream.of(array)
                        .map(String::valueOf)
                        .collect(Collectors.joining(" ", "<", ">")
                        ));

    }


    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

}
