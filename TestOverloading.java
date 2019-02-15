public class TestOverloading {
    private static void print_multiple(int number, int times){
        System.out.println(number*times);
    }

    private static void print_multiple(String word, int times){
        for(int i=0;i<times;i++){
            System.out.println(word);}
    }

    static void test(){
        print_multiple(5,5);
        print_multiple("5",5);
    }
}
