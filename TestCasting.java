import java.util.*;

public class TestCasting {
    static void test(){
        ArrayList<Object> l = new ArrayList<>();
        l.add(1);
        l.add(1.2);
        l.add("hi!");
        l.add(false);

        for(int i = 0;i<l.size();i++){
            System.out.println(l.get(i).getClass());
        }



    }
}
