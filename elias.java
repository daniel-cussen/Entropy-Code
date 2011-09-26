import java.io.*;

public class elias{
    public static void main(String[] args){
	System.out.println(""+encodeInt(22));
    }
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
	int i = 0, index = 1, payload = n, y = 4;
	payload++;
	while(payload >= y){
	    payload++;
	    payload -= y;
	    y *= y;
	    escaper = "1" + escaper;
	}
	index = loglen(payload);
	String indexstr = (""+binary(index));
	for(int j=indexstr.length(); j<escaper.length(); j++)
	    indexstr = "0"+indexstr;
	str=str.concat(escaper+" "+indexstr);
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