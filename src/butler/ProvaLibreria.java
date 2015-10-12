
package butler;
import butler.Lettore;
 
public class ProvaLibreria {

    public static void main(String[] args) {
String nomeProp = System.getProperty("os.name");
System.out.println( "system name: "+nomeProp);
       
        char a;
        String b;
        String c;
        System.out.print("enter char\n");
        a=Lettore.in.leggiChar();//abcd--->a
        System.out.print("char is= "+a+"\n");
        System.out.print("enter string\n");
        b=Lettore.in.leggiString();//pippo pluto --> pippo
        System.out.print("string is= "+b+"\n");
        System.out.print("enter line\n");
        c=Lettore.in.leggiLine();//pippo pluto --> pippo pluto
        System.out.print("line is= "+c+"\n");
        int d=0;
        System.out.print("enter int\n");
        d=Lettore.in.leggiInt();
          System.out.print("int is= "+d+"\n");
        
        
    }
    
}
