package butler;
import java.io.*;
/*Progetto per la lettura semplificata di dati per i vari tipi
 * primitivi di java da tastiera.
 * versione 1.2;
 * autore: Alejandro Emmanuel Ontivero
 * Ingegneria Informatica(Sistemi Informatici)La Sapienza 01/10/2015
 */
public class Lettore extends BufferedReader{
    private char prossimo;
        //costruttore costruttore statico affinche l'oggetto creato non possa essere riasegnato ma possa inseguito essere modificato
    
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
        //lettura singolo carattere
	
    public char leggiChar(){
	while (eoln()){ 
          elimFine(); 
       }
        return get(); 
	}
	//lettura sequenza continua senza spazzi bianchi
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
            //lettura linea di testo senza terminazione
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
	
	//lettura di un long compreso di segno negativo
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
        //lettura di un intero
    public int leggiInt(){ 
        return (int) leggiLong(); 
    } 
        //lettura di un short
    public short leggiShort(){ 
        return (short) leggiLong(); 
    } 
        //lettura di un float
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
        //lettura di un nuomero razionale
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
    
        //lettura di un boolean
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

        //verifico fine flusso dati
    public boolean eof(){ 
        char c=ultimoc(); 
        return (c==(char)-1); 
    } 
    
        //end of line verifica se si è giunti alla fine della linea
    public boolean eoln(){ 
        char c= ultimoc(); 
        return (c=='\n') || (c=='\r') || eof(); 
    } 
        //aggiungo alla stringa ottenuta un terminatore
    private static String fine(String s){
		if (s!=null){
			int l=s.length();
			if(l>0 && (s.charAt(l-1)!='\n' ||s.charAt(l-1)!='\r') ){
				s+='\n';
                        }
		}
		return s;
		}
    	//verifico spazio bianco
    private static boolean isWhite(char c){ 
        return Character.isWhitespace(c); 
    } 
        //restituisce un carattere letto da in
    private char scan(){ 
        char c; 
        try{ 
            c=(char) in.read(); 
        } catch (IOException e){ 
            //do per certo di aver raggiunto la fine del flusso
            c=(char) -1; 
        } 
        return c; 
    }
        //restituisce il carattere corrente senza eliminarlo
    private char ultimoc(){ 
        if (prossimo==0) 
           prossimo=scan(); 
        return prossimo; 
    } 
        //elimina carattere e lo restituisce
    private char get(){ 
        char c=ultimoc(); 
        prossimo=0;  // lo elimino
        return c; 
    } 
    
        //elimino caratteri di fine linea (problemi con differenti os)
    private void elimFine(){ 
        char c=ultimoc(); 
        if (c=='\r'){ 
            get(); 
            c=ultimoc(); 
        } 
        if (c=='\n'){ 
            get(); 
        } 
    } 
        //elimino spazi bianchi
    private void elimspazio(){ 
        char c=ultimoc(); 
        while (isWhite(c)){ 
            get(); 
            c=ultimoc(); 
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

