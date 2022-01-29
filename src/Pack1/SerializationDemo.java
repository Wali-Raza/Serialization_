package Pack1;

import java.io.*;

public class SerializationDemo implements Serializable
{
    int i=10;
   transient static int j=20;
}
class Main {
    public static void main(String[] args) throws Exception{
        //Serialization
        SerializationDemo ser=new SerializationDemo();
        FileOutputStream fos=new FileOutputStream("abc.ser");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(ser);

        //Desiarilaztion
        FileInputStream fis=new FileInputStream("abc.ser");
        ObjectInputStream ois=new ObjectInputStream(fis);
        SerializationDemo ser2=(SerializationDemo)ois.readObject();

        System.out.println(ser2.i+"----"+ ser2.j);

    }
}