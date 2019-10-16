import java.util.Iterator;
import java.util.LinkedList;

public class IteratorDemo {

    public static void main(String[] args) {

        LinkedList<Integer> il = new LinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            il.add(new Integer(i));
        }

        /* Iterator使用 */
        Iterator iter = il.iterator();      //每个容器专属的迭代器
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

    }

}
