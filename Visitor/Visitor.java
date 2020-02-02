package Visitor;

import java.util.Iterator;

/**
 * @program: Design Pattern
 * @description: Visitor
 * @author: Zhe Zhang
 * @create: 2020/02/02
 **/


/**
 * abstract Visitor class
 */
abstract class Visitor{
    public abstract void visit(File file);
    public abstract void visit(Directory directory);
}

/**
 * concrete Visitor class
 */
class ListVisitor extends Visitor{
    private String currentDir = "";

    @Override
    public void visit(File file) {
        System.out.println(currentDir + "/" + file);
    }

    @Override
    public void visit(Directory directory) {
        System.out.println(currentDir + "/" + directory);
        String saveDir = currentDir;
        currentDir = currentDir + "/" + directory.getName();
        Iterator iter = directory.iterator();   //adaptor需要提供足够对信息给visitor
        while(iter.hasNext()){
            Entry entry = (Entry)iter.next();
            entry.accept(this);     //再次呼叫adaptor
        }
        currentDir = saveDir;
    }
}