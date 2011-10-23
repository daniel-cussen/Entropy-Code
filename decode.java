class decode{
    public static void main

(String str){
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