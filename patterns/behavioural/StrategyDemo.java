//package behavioural;

import java.util.Arrays;
import java.util.Comparator;

// Strategy interface
interface SortStrategy {
    void sort(Integer[] arr);
}

// Concrete strategies
class AscendingSort implements SortStrategy {
    public void sort(Integer[] arr) { Arrays.sort(arr); }
}
class DescendingSort implements SortStrategy {
    public void sort(Integer[] arr) {
        Arrays.sort(arr, Comparator.reverseOrder());
    }
}

// Context
class Sorter {
    private SortStrategy strategy;
    public Sorter(SortStrategy strategy) { this.strategy = strategy; }
    public void setStrategy(SortStrategy strategy) { this.strategy = strategy; }
    public void sort(Integer[] arr) { strategy.sort(arr); }
}

public class StrategyDemo {
    public static void main(String[] args) {
        Integer[] data = {5, 2, 9, 1, 4};
        Sorter sorter = new Sorter(new AscendingSort());
        sorter.sort(data);
        System.out.println("Ascending: " + Arrays.toString(data));

        sorter.setStrategy(new DescendingSort());
        sorter.sort(data);
        System.out.println("Descending: " + Arrays.toString(data));
    }
}
