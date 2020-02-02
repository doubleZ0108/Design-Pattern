package Visitor;

import java.util.Iterator;
import java.util.Vector;

/**
 * @program: Design Pattern
 * @description: Acceptor
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

/**
 * Acceptor interface
 */
interface Acceptor{
    public abstract void accept(Visitor v);
}

abstract class Entry implements Acceptor{
    /* 获取名称 */
    public abstract String getName();
    /* 获取大小 */
    public abstract int getSize();

    public Entry add(Entry entry) throws FileTreatmentException{
        throw new FileTreatmentException();
    }

    public Iterator iterator() throws FileTreatmentException{
        throw new FileTreatmentException();
    }

    @Override
    public String toString() {
        return getName() + "(" + getSize() + ")";
    }

    /* 不再提供printList方法而是交给某一个Visitor实现 */
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
    public void accept(Visitor v) {
        v.visit(this);
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

    @Override
    public Entry add(Entry entry) throws FileTreatmentException {
        directory.add(entry);
        return this;
    }

    @Override
    public Iterator iterator() throws FileTreatmentException {
        return directory.iterator();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

