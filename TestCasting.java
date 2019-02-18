import java.util.*;

class TestCasting {
    static void test(){
        ArrayList<Object> l = new ArrayList<>();
        l.add(1);
        l.add(1.2);
        l.add("hi!");
        l.add(false);

        // not allowed:
        // System.out.println(l.get(1)+1.);

        // allowed:
        System.out.println(((double) l.get(1))+1.);
        }
    }
