package com.thoughtworks.collection;

import com.sun.xml.internal.bind.v2.util.CollisionCheckStack;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        int start = left > right ? right : left;
        int end = left > right ? left : right;
        if (left > right) {
            return IntStream.range(start, end + 1).boxed().sorted((x, y) -> y.compareTo(x)).collect(Collectors.toList());
        } else {
            return IntStream.range(start, end + 1).boxed().collect(Collectors.toList());
        }
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        int start = left > right ? right : left;
        int end = left > right ? left : right;
        Stream<Integer> evenList = IntStream.rangeClosed(start, end).boxed().filter(x -> x % 2 == 0);
        if (left > right) {
            return evenList.sorted((x, y) -> y.compareTo(x)).collect(Collectors.toList());
        } else {
            return evenList.collect(Collectors.toList());
        }
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).filter(x -> x % 2 == 0).boxed().collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return Arrays.stream(array).sorted().boxed().sorted(Comparator.reverseOrder()).findFirst().get();
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        throw new NotImplementedException();
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        throw new NotImplementedException();
    }
}
