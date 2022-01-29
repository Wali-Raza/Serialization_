package Pack1;
import java.io.*;

public class ObjectGraph implements Serializable
{
    Cat c1=new Cat();
}
class Cat implements Serializable
{
    Rat r1=new Rat();
}
class Rat implements Serializable
{
    int j=20;
}
class Main2
{
    public static void main(String[] args) throws Exception {
        ObjectGraph o=new ObjectGraph();
        FileOutputStream fos=new FileOutputStream("abc.ser");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(o);

        //Desrialization
        FileInputStream fis=new FileInputStream("abc.ser");
        ObjectInputStream ois=new ObjectInputStream(fis);
        ObjectGraph o2=(ObjectGraph)ois.readObject();
        System.out.println(o2.c1.r1.j);
    }
}