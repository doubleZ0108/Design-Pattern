import java.util.Iterator;
import java.util.Vector;

/**
 * @program: Design Pattern
 * @description: Composite
 * @author: Zhe Zhang
 * @create: 2020/02/02
 **/

class FileTreatmentException extends RuntimeException{
    public FileTreatmentException() {
    }

    public FileTreatmentException(String message) {
        super(message);
    }
}

abstract class Entry{
    /* 获取名称 */
    public abstract String getName();
    /* 获取大小 */
    public abstract int getSize();

    public Entry add(Entry entry) throws FileTreatmentException{
        throw new FileTreatmentException();
    }

    /* 输出entry的信息 */
    public void printList(){    //暴露给用户的接口
        printList("");  //默认没有前缀
    }
    protected abstract void printList(String prefix);

    @Override
    public String toString() {
        return getName() + "(" + getSize() + ")";
    }
}

class File extends Entry{
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);    //Entry重写了toString，所以直接输出this即可
    }
}

class Directory extends Entry{
    private String name;
    private Vector<Entry> directory = new Vector<Entry>();      //容器

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        Iterator iter = directory.iterator();
        while(iter.hasNext()){
            Entry entry = (Entry)iter.next();
            size += entry.getSize();
        }
        return size;
    }

    public Entry add(Entry entry){
        directory.add(entry);   //把entry放入容器
        return this;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        Iterator iter = directory.iterator();
        while(iter.hasNext()){
            Entry entry = (Entry)iter.next();
            entry.printList(prefix + "/" + name);
        }
    }
}


public class CompositeDemo {
    public static void main(String[] args) {
        try{
            System.out.println("Making root entries...");
            Directory rootdir = new Directory("root");
            Directory bindir = new Directory("bin");
            Directory tmpdir = new Directory("tmp");
            Directory usrdir = new Directory("usr");
            rootdir.add(bindir);
            rootdir.add(tmpdir);
            rootdir.add(usrdir);
            bindir.add(new File("vi", 10000));
            bindir.add(new File("latex", 20000));
            rootdir.printList();
        } catch (FileTreatmentException e){
            e.printStackTrace();
        }
    }
}
