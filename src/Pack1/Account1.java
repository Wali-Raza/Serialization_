package Pack1;

import java.io.*;

public class Account1 implements Serializable
{
    String Uname="Wali Raza";
    transient String pass="Wali@123";
    transient int pin=1999;

    //Method1
    private void writeObject(ObjectOutputStream fos) throws Exception
    {
        fos.defaultWriteObject();

        String epwd="123"+pass;
        fos.writeObject(epwd);

        int epin=4444+pin;
        fos.writeInt(epin);

    }

    //Method2
     private void readObject(ObjectInputStream ois) throws Exception
    {

        ois.defaultReadObject();

        String epwd=(String) ois.readObject();
        pass=epwd.substring(3);

        int epin=ois.readInt();
        pin=epin-4444;
    }
}
class CustSerialization
{
    public static void main(String[] args) throws Exception
    {
        Account1 a1=new Account1();

        //Serialization
        FileOutputStream fos=new FileOutputStream("abc1.ser");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(a1);

        //De-Serialization
        FileInputStream fis=new FileInputStream("abc1.ser");
        ObjectInputStream ois=new ObjectInputStream(fis);
        Account1 a2=(Account1)ois.readObject();

        System.out.println("User Name : "+a2.Uname);
        System.out.println("Uers Password : "+a2.pass);
        System.out.println("Users PIN : "+a2.pin);

    }
}
