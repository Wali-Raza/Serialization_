package Pack1;

import java.io.*;

public class Account implements Serializable
{
    String U_name="Wali Raza";
    transient String pwd="Wali@123";

    private void writeObject(ObjectOutputStream oos) throws IOException
    {
        oos.defaultWriteObject();
        String epwd="123"+pwd;
        oos.writeObject(epwd);
    }

    private void readObject(ObjectInputStream ois) throws Exception
    {
        ois.defaultReadObject();
        String epwd=(String)ois.readObject();
        pwd=epwd.substring(3);
    }
}
class CustomizedSer
{
    public static void main(String[] args) throws Exception
    {
        Account a1=new Account();

        //Serialization
        FileOutputStream fos=new FileOutputStream("abc.ser");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(a1);

        //De-Serialization
        FileInputStream fis=new FileInputStream("abc.ser");
        ObjectInputStream ois=new ObjectInputStream(fis);
        Account a2=(Account)ois.readObject();

        System.out.println(a2.U_name+"--"+a2.pwd);
    }
}
