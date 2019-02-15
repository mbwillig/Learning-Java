import java.util.ArrayList;

abstract class Q8Problem {
    /* Solves 8 queens recursively by depth first finding arrangements of the numbers 0 through 7
    where no difference between two numbers equals the difference in position*/
    static void nextDigit(ArrayList<Integer> partial){
        if (partial.size()>7){
            System.out.println(partial);}
        else{
            for(int i=0;i<8;i++){ // option for the next digit
                if(!partial.contains(i)){
                    boolean canFit = true;
                    for(int j=0;j<partial.size();j++){
                        if(java.lang.Math.abs(partial.get(j) - i) == (partial.size()-j)){
                            canFit = false;
                            break;
                        }
                    }
                    if(canFit){
                        ArrayList<Integer> newList = new ArrayList<>(partial);
                        newList.add(i);
                        nextDigit(newList);
                    }
                }

            }

        }

    }
}
