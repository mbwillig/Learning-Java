import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.stream.*;

class Q8ProblemWithStreams {
  
  /* Solves 8 queens recursively by depth first finding arrangements of the numbers 0 through 7
  where no difference between two numbers equals the difference in position*/
  
  private static boolean no_diagonal_collision (ArrayList<Integer> partial, int candidate) {
    return IntStream.range(0, partial.size()) //for all previous positions
        .noneMatch(j -> (abs(partial.get(j) - candidate) == (partial.size() - j)));  
  }

  private static ArrayList<Integer> copyAndAddElement(ArrayList<Integer> partial, int element) {
    ArrayList<Integer> newList = new ArrayList<>(partial);
    newList.add(element);
    return newList;
  }

  static void nextDigit(ArrayList<Integer> partial) {
    if (partial.size() > 7) {
      System.out.println(partial);
    } else {
      IntStream.range(0, 8).filter((x) -> (!partial.contains(x)))
          .filter((x) -> (no_diagonal_collision (partial, x)))
          .forEach(x -> nextDigit(copyAndAddElement(partial, x)));
    }
  }
}

