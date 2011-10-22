import java.io.*;
import java.io.*;
class U { //en archivo U.java
    //declaracion de entrada estandar (teclado)
    static public BufferedReader teclado =
	new BufferedReader(new InputStreamReader(System.in));
    //funciones (metodos) para leer enteros y reales
    static public String readLine(String x)throws IOException{
	print(x); return teclado.readLine();
    }
    static public int readInt(String x)throws IOException{
	return Integer.parseInt(readLine(x));
    }
    static public int readInt()throws IOException{
	return readInt("");
    }
    static public double readDouble(String x)throws IOException{
	return Double.parseDouble(readLine(x));
    }
    static public double readDouble()throws IOException{
	return readDouble("");
    }
    //metodos para escribir frases, enteros y reales
    static public void print(String x){
	System.out.print(x);
    }
    static public void print(int x){
	System.out.print(x);
    }
    static public void print(double x){
	System.out.print(x);
    }
    static public void println(String x){
	System.out.println(x);
    }
    static public void println(int x){
	System.out.println(x);
    }
    static public void println(double x){
	System.out.println(x);
    }
}//fin de clase U
public class elias{
    public static void main(String[] args){
	try{
	    int input = U.readInt("Integer: ");
	    System.out.println(""+encodeInt(65807));
	}
	catch(java.io.IOException exp){
	    exp.printStackTrace();
	}
    }
	//
    public static int loglen(int n){
	int i = 0;
	while (n > 0){
	    n >>= 1;
	    i ++;
	}
	return i;
    }
    public static String binary(int n){
	String str = "";
	int aux = n;
	while(aux > 0){
	    aux >>= 1;
	    str = ""+(aux & 1)+str;
	}
	return str;
    }
    public static String encodeInt(int n){
	String str = "", escaper = "0";
	int i = 0, index = 1, payload = n+1, y = 4;
	while(payload >= y){
	    payload++;
	    payload -= y;
	    y *= y;
	    escaper = "1" + escaper;
	}
	index = loglen(payload);
	String indexstr = (""+binary(index));
	for(int j=indexstr.length();j<escaper.length();j++)
	    indexstr = "0"+indexstr;
	str = str.concat(escaper+" "+indexstr);
	if(index>0)
	    str = str.concat(" "+binary(payload));
	return str;
    }
    public static int decodeInt(String str){
	int n = 0, i = 0, bin = 0;
	while(str.charAt(i)=='1'){
	    n += (1 << (1 << ++i));
	    n--;
	}
	i++;
	int j = i, size = 0;
	i <<= 1;
	while(j < i){
	    size <<= 1;
	    size += (str.charAt(j) - 48);
	    j++;
	}
	n += ((1 << size) - 1);
	i += size;
	while(j < i){
	    bin <<= 1;
	    bin += (str.charAt(j) - 48);
	    j++;
	}
	n += bin;
	return n;
    }
}
