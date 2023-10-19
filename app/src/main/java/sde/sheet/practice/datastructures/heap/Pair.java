package sde.sheet.practice.datastructures.heap;

public class Pair implements Comparable<Pair> {
    public int value;
    public int diff;

    public Pair(int diff, int value) {
        this.diff = diff;
        this.value = value;
    }


    @Override
    public int compareTo(Pair pair) {
        if (pair.diff == diff)
            return value - pair.value;
        return pair.diff - diff;
    }
}
