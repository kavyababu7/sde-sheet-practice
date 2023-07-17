package sde.sheet.practice.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphInitializer {
    /**
               1
            /     \
          2         6
       /   \      /   \
     3      4    7     8
             \  /
              5
     */

    public static List<List<Integer>> buildType1() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of());
        list.add(List.of(2,6));
        list.add(List.of(3,1,4));
        list.add(List.of(2));
        list.add(List.of(2,5));
        list.add(List.of(4,7));
        list.add(List.of(1,7,8));
        list.add(List.of(5,6));
        list.add(List.of(6));
        return list;
    }

    /**
               1
            /    \
           2      3----4
         /  \     |    |
        5    6    7----8
     */
    public static List<List<Integer>> buildType2() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of());
        list.add(List.of(2,3));
        list.add(List.of(1,5,6));
        list.add(List.of(1,4,7));
        list.add(List.of(3,8));
        list.add(List.of(2));
        list.add(List.of(2));
        list.add(List.of(3,8));
        list.add(List.of(4,7));
        return list;
    }

    /**
            1--2        4--5        7
              /           /         |
             3           6          8

     */
    public static List<List<Integer>> buildDisconnected() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of());
        list.add(List.of(2)); //1
        list.add(List.of(1,3)); //2
        list.add(List.of(2)); //3
        list.add(List.of(5)); //4
        list.add(List.of(4,6)); //5
        list.add(List.of(5)); //6
        list.add(List.of(8)); //7
        list.add(List.of(7)); //8
        return list;
    }

    /**
     1--2        4--5         7
     /           /          /  \
     3           6          8---9

     */
    public static List<List<Integer>> buildDisconnectedCycle() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of());
        list.add(List.of(2,3)); //1
        list.add(List.of(1)); //2
        list.add(List.of(1)); //3
        list.add(List.of(5,6)); //4
        list.add(List.of(4)); //5
        list.add(List.of(4)); //6
        list.add(List.of(8,9)); //7
        list.add(List.of(7,9)); //8
        list.add(List.of(7,8)); //9
        return list;
    }

    /**
       2-------5
     /          \
    1            7
     \          /
      3--------6
     /
    4

     */
    public static List<List<Integer>> buildCyclic() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of());
        list.add(List.of(2,3)); //1
        list.add(List.of(1,5)); //2
        list.add(List.of(1,4,6)); //3
        list.add(List.of(3)); //4
        list.add(List.of(2,7)); //5
        list.add(List.of(3,7)); //6
        list.add(List.of(5,6)); //7
        return list;
    }

    /**
     1 -> 2 -> 3 -> 4
          *    |    |
          |    *    *
           8   7 -> 5 -> 6
           *
        /   \
       *
       9 -> 10

     */

    public static List<List<Integer>> buildDirectedCyclic() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of());
        list.add(List.of(2)); //1
        list.add(List.of(3)); //2
        list.add(List.of(4,7)); //3
        list.add(List.of(5)); //4
        list.add(List.of(6)); //5
        list.add(List.of()); //6
        list.add(List.of(5)); //7
        list.add(List.of(2,9)); //8
        list.add(List.of(10)); //9
        list.add(List.of(8)); //10
        return list;
    }

    /**

        5 -> 0 <- 4
        |         |
        *         *
        2 -> 3 -> 1
     */

    public static List<List<Integer>> buildDAG() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of());
        list.add(List.of()); //1
        list.add(List.of(3)); //2
        list.add(List.of(1)); //3
        list.add(List.of(0,1)); //4
        list.add(List.of(0,2)); //5
        return list;
    }
}
