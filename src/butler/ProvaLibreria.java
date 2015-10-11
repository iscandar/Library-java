
package butler;
import butler.Lettore;
 
public class ProvaLibreria {

    public static void main(String[] args) {
String nomeProp = System.getProperty("os.name");
System.out.println( "Nome di sistema: "+nomeProp);
       
        char a;
        String b;
        String c;
        System.out.print("inserisci char\n");
        a=Lettore.in.leggiChar();//abcd--->a
        System.out.print("ilchar = "+a+"\n");
        System.out.print("inserisci string\n");
        b=Lettore.in.leggiString();//pippo pluto --> pippo
        System.out.print("la stringa inserita= "+b+"\n");
        System.out.print("inserisci line\n");
        c=Lettore.in.leggiLine();//pippo pluto --> pippo pluto
        System.out.print("la linea inserita= "+c+"\n");
        int d=0;
        System.out.print("inserisci intero\n");
        d=Lettore.in.leggiInt();
          System.out.print("intero inserito= "+d+"\n");
        
        
    }
    
}
