package butler;
import java.io.*;
/* The Project for simplified reading of data for the various types
* Primitive Java keyboard .
* Version 1.2 ;
* Author : Alejandro Emmanuel ONTIVERO
* Computer Engineering ( Computer Systems ) La Sapienza 2015
*/
public class Lettore extends BufferedReader{
    private char prossimo;
        //static constructor Directory to the created object can not be reassigned chased but could be changed
    
    public static Lettore in=new Lettore();

    public Lettore(){
		this(new InputStreamReader(System.in));
	}
    
    public Lettore(String s){
		this(new StringReader(fine(s)));
    }

    public Lettore(Reader in){
		super(in);
		this.prossimo=(char)0;
	}
        //reading Single Character
	
    public char leggiChar(){
	while (eoln()){ 
          elimFine(); 
       }
        return get(); 
	}
	//reading a continuous sequence without white spaces
    public String leggiString(){
	StringBuffer s=new StringBuffer(); 
        char c;
        cancella();
        elimspazio();
        c=get(); 
        while (!isWhite(c)){ 
            s.append(c); 
            c=get(); 
        }
        return s.toString();
    } 
            //reading continuous sequence
    public String leggiLine(){ 
        StringBuffer line=new StringBuffer(); 
        cancella();
        char c; 
        while (!eoln()){ 
            c=get(); 
            line.append(c); 
        }  
        
        return line.toString();
    }
	
	//reading signed long
    public long leggiLong(){ 
        String s=leggiString(); 
        long n; 
        try{ 
            n=Long.parseLong(s); 
        } catch (NumberFormatException e){ 
            n=0; 
        } 
        return n;
    } 
        //reading signed int
    public int leggiInt(){ 
        return (int) leggiLong(); 
    } 
       //reading signed short
    public short leggiShort(){ 
        return (short) leggiLong(); 
    } 
      //reading signed float
    public float leggiFloat(){ 
        String string=leggiString(); 
        float n; 
        try{ 
            n=(new Float(string)).floatValue(); 
        } catch (NumberFormatException e){ 
            n=0; 
        } 
        return n;
    } 
     //reading signed double
    public double leggiDouble(){
    	String string=leggiString();
    	double n;
    	try{
    		n=(new Double(string)).doubleValue();
    	} catch (NumberFormatException e){
    		n=0;
    	}
    	return n;
    		
    }
    
        //reading boolean
    public boolean leggiBoolean(){
    	String string=leggiString();
    	boolean n;
    	try{
    		n=(new Boolean(string)).booleanValue();
    	} catch (NumberFormatException e){
    		n=false;
    	}
    	return n;
    }

        //check order flow data
    public boolean eof(){ 
        int c=ultimoc(); 
        return (c==-1); 
    } 
    
        //check end of line
    public boolean eoln(){ 
        char c= (char)ultimoc(); 
        return (c=='\n') || (c=='\r') || eof(); 
    } 
        //add end to the string
    private static String fine(String s){
		if (s!=null){
			int l=s.length();
			if(l>0 && (s.charAt(l-1)!='\n' ||s.charAt(l-1)!='\r') ){
				s+='\n';
                        }
		}
		return s;
		}
    	//check if char is white
    private static boolean isWhite(char c){ 
        return Character.isWhitespace(c); 
    } 
        //return char readed
    private int scan(){ 
        int c; 
        try{ 
            c= in.read(); 
        } catch (IOException e){ 
            c=-1; 
        } 
        return c; 
    }
        //return chart without delet it
    private int ultimoc(){ 
        int c=(int)prossimo;
        if (prossimo==0) {
            c=scan();
            if (c!=-1){
                prossimo=(char) c;
            }
        }
        return c; 
    } 
        //delet and return char
    private char get(){ 
        char c=(char)ultimoc(); 
        prossimo=0;  // lo elimino
        return c; 
    } 
    
        //delete end of line(problems with some O.S)
    private void elimFine(){ 
        char c=(char)ultimoc(); 
        if (c=='\r'){ 
            get(); 
            c=(char)ultimoc(); 
        } 
        if (c=='\n'){ 
            get(); 
        } 
    } 
        //delete white space
    private void elimspazio(){ 
        char c=(char)ultimoc(); 
        while (isWhite(c)){ 
            get(); 
            c=(char)ultimoc(); 
        } 
    } 
    private void cancella(){ 
        char c;
        while (!eoln()){ 
            c=get(); 
        } 
        elimFine(); 
    } 

}

