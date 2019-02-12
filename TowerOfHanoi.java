import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

class TowerOfHanoi {
    private int nDisk;
    private ArrayList<Deque<Integer>> towers;
        /* holds 3 "towers", each a deque object of ints in decreasing order.
         All ints in towers are unique, and between 0 and nDisk-1 */

    TowerOfHanoi(int nDisk) {
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

    private void printTowers(){
        StringBuilder output = new StringBuilder();
        for(Deque<Integer> tower:this.towers){
            for(Integer item:tower){
                output.append(item ).append(" ");}
            for(int i = tower.size(); i<this.nDisk;i++){
                output.append("  ");}
            output.append("|");}
        System.out.println(output);}


    void play(int n, int source, int target) {
        if (n == 1) {
            towers.get(target).addLast(towers.get(source).pollLast());
            this.printTowers();
        } else {
            int aux = 3 - (source + target);
            this.play(n - 1, source, aux);
            towers.get(target).addLast(towers.get(source).pollLast());
            this.printTowers();
            this.play(n - 1, aux, target);
        }

    }
}

