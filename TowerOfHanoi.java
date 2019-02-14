import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

class TowerOfHanoi {
    private int nDisk;
    private ArrayList<Deque<Integer>> towers;
        /* holds 3 "towers", each a deque object of ints in decreasing order.
         All ints in towers are unique, and between 0 and nDisk-1 */

    TowerOfHanoi(int nDisk) { //initialize tower of hanoi
        this.nDisk = nDisk;
        Deque<Integer> disks = new ArrayDeque<>();
        for (int i = 0; i <nDisk; i++) {
            disks.addFirst(i);}
        ArrayList<Deque<Integer>> towers = new ArrayList<>();
        towers.add(disks);
        towers.add(new ArrayDeque<>());
        towers.add(new ArrayDeque<>());
        this.towers = towers;
    }

    public String toString(){
        StringBuilder output = new StringBuilder();
        for(Deque<Integer> tower:this.towers){
            for(Integer item:tower){
                output.append(item ).append(" ");}
            for(int i = tower.size(); i<this.nDisk;i++){
                output.append("  ");}
            output.append("|");}
        return output.toString();}


    void play(int n, int source, int target) {
        if (n == 1) {
            towers.get(target).addLast(towers.get(source).pollLast());
            System.out.println(this);
        } else {
            int aux = 3 - (source + target);
            this.play(n - 1, source, aux);
            towers.get(target).addLast(towers.get(source).pollLast());
            System.out.println(this);
            this.play(n - 1, aux, target);
        }

    }
}

