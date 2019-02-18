import java.util.stream.*;

class PlayWithStreams {

  private static double sum_of_squares(double[] numlist) {
    return DoubleStream.of(numlist).reduce(0., (x, y) -> x + y * y);
  }

  private static double factorial(double[] numlist) {
    return DoubleStream.of(numlist).reduce(1., (x, y) -> x *y);
  }

  private static double sumEvenNumbers(double[] numlist) {
    return DoubleStream.of(numlist).filter((x)  -> x%2 < 0.01).sum();}

  private static boolean isPrime(int i) {
    return IntStream.rangeClosed(2, i/2).noneMatch((x) -> (i%x) == 0);} // can x = 1..sqrt(i) but requires casting to double

  private static void printPrimesUpTo(int i) {
    IntStream.rangeClosed(2,i).filter(PlayWithStreams::isPrime).forEach(System.out::println);} // can x = 1..sqrt(i) but requires casting to double


  static void test(){
    double[] inputlist= new double[] {1.,2.,3.,4.};
    System.out.println("sum of squares {1,2,3,4}");
    System.out.println(sum_of_squares(inputlist));
    System.out.println("factorial {1,2,3,4}");
    System.out.println(factorial(inputlist));
    System.out.println("sum even numbers {1,2,3,4}");
    System.out.println(sumEvenNumbers(inputlist));
    System.out.println("primes less than 100");
    printPrimesUpTo(99);
  }
}
