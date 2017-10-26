package com.main;
import java.util.Random;

public class Vincent {

	// This is a class where I put all the methods I will be using.
	public static String key[] = new String[]{"Ö","Ç","Ü","Ğ","Ş","İ","ö","ç","ş","ü","ğ","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","_","-","=","+","%","&","/","(",")","[","]","{","}",":",";",".","*","#","$","é","!","?"," ","'","^","~","€",",","|","<",">"," ","0","1","2","3","4","5","6","7","8","9"};
	
	// Print one dimensional array
	public static void printArray (boolean a[]){
		for (int x = 0; x < a.length; x++){
			System.out.print(a[x]+" ");}}
	public static void printArray (int a[]){
		for (int x = 0; x < a.length; x++){
			System.out.print(a[x]+" ");}}
	public static void printArray (double a[]){
		for (int x = 0; x < a.length; x++){
			System.out.print(a[x]+" ");}}
	public static void printArray (float a[]){
		for (int x = 0; x < a.length; x++){
			System.out.print(a[x]+" ");}}
	public static void printArray (char a[]){
		for (int x = 0; x < a.length; x++){
			System.out.print(a[x]+" ");}}
	public static void printArray (String a[]){
		for (int x = 0; x < a.length; x++){
			System.out.print(a[x]+" ");}}
	
	// Print two dimensional array
	public static void printArray (boolean a[][]){
		for (int x = 0; x < a.length; x++){
			for (int y = 0; y < a[x].length; y++){
				System.out.print(a[x][y]+" ");}
			System.out.println();}}
	public static void printArray (int a[][]){
		for (int x = 0; x < a.length; x++){
			for (int y = 0; y < a[x].length; y++){
				System.out.print(a[x][y]+" ");}
			System.out.println();}}
	public static void printArray (double a[][]){
		for (int x = 0; x < a.length; x++){
			for (int y = 0; y < a[x].length; y++){
				System.out.print(a[x][y]+" ");}
			System.out.println();}}
	public static void printArray (float a[][]){
		for (int x = 0; x < a.length; x++){
			for (int y = 0; y < a[x].length; y++){
				System.out.print(a[x][y]+" ");}
			System.out.println();}}
	public static void printArray (char a[][]){
		for (int x = 0; x < a.length; x++){
			for (int y = 0; y < a[x].length; y++){
				System.out.print(a[x][y]+" ");}
			System.out.println();}}
	public static void printArray(String a[][]){
		for (int x = 0; x < a.length; x++){
			for (int y = 0; y < a[x].length; y++){
				System.out.print(a[x][y]+" ");}
			System.out.println();}}
	
	// Create and fill an two dimensional array
	public static void fillArray (boolean[][] x, boolean y){
		for (int b = 0; b < x.length; b++){
			for (int a = 0; a < x[b].length; a++){
				x[a][b] = y;}}}
	public static void fillArray (int[][] x, int y){
		for (int b = 0; b < x.length; b++){
			for (int a = 0; a < x[b].length; a++){
				x[a][b] = y;}}}
	public static void fillArray (double[][] x, double y){
		for (int b = 0; b < x.length; b++){
			for (int a = 0; a < x[b].length; a++){
				x[a][b] = y;}}}
	public static void fillArray(float[][] x, float y){
		for (int b = 0; b < x.length; b++){
			for (int a = 0; a < x[b].length; a++){
				x[a][b] = y;}}}
	public static void fillArray (char[][] x, char y){
		for (int b = 0; b < x.length; b++){
			for (int a = 0; a < x[b].length; a++){
				x[a][b] = y;}}}
	public static void fillArray (String[][] x, String y){
		for (int b = 0; b < x.length; b++){
			for (int a = 0; a < x[b].length; a++){
				x[a][b] = y;}}}
	
	// Counting methods
	public static int countArray(boolean a[], boolean i){
		int c = 0;
		for (int p = 0; p < a.length; p++){
			if (a[p] == i){
				c++;
			}
		}
		return c;}
	public static int countArray(int a[], int i){
		int c = 0;
		for (int p = 0; p < a.length; p++){
			if (a[p] == i){
				c++;
			}
		}
		return c;}
	public static int countArray(double a[], double i){
		int c = 0;
		for (int p = 0; p < a.length; p++){
			if (a[p] == i){
				c++;
			}
		}
		return c;}
	public static int countArray(float a[], float i){
		int c = 0;
		for (int p = 0; p < a.length; p++){
			if (a[p] == i){
				c++;
			}
		}
		return c;}
	public static int countArray(char a[], char i){
		int c = 0;
		for (int p = 0; p < a.length; p++){
			if (a[p] == i){
				c++;
			}
		}
		return c;}
	public static int countArray(String a[], String i){
		int c = 0;
		for (int p = 0; p < a.length; p++){
			if (a[p].equals(i)){
				c++;
			}
		}
		return c;}
	public static int countArray(boolean a[][], boolean i){
		int c = 0;
		for (int p = 0; p < a.length; p++){
			for (int q = 0; q < a.length; q++){
				if (a[p][q] == i){
					c++;
				}
			}
		}
		return c;}
	public static int countArray(int a[][], int i){
		int c = 0;
		for (int p = 0; p < a.length; p++){
			for (int q = 0; q < a.length; q++){
				if (a[p][q] == i){
					c++;
				}
			}
		}
		return c;}
	public static int countArray(double a[][], double i){
		int c = 0;
		for (int p = 0; p < a.length; p++){
			for (int q = 0; q < a.length; q++){
				if (a[p][q] == i){
					c++;
				}
			}
		}
		return c;}
	public static int countArray(float a[][], float i){
		int c = 0;
		for (int p = 0; p < a.length; p++){
			for (int q = 0; q < a.length; q++){
				if (a[p][q] == i){
					c++;
				}
			}
		}
		return c;}
	public static int countArray(char a[][], char i){
		int c = 0;
		for (int p = 0; p < a.length; p++){
			for (int q = 0; q < a.length; q++){
				if (a[p][q] == i){
					c++;
				}
			}
		}
		return c;}
	public static int countArray(String a[][], String i){
		int c = 0;
		for (int p = 0; p < a.length; p++){
			for (int q = 0; q < a.length; q++){
				if (a[p][q].equals(i)){
					c++;
				}
			}
		}
		return c;}
	
	// Sorting methods
	public static int[] sortArray (int a[], int t){
		int h = 0;
		for (int p = 0; p < a.length; p++){
			for (int q = 0; q < a.length; q++){
				if (t == 0){
					if (a[p] < a[q]){
						h = a[q];
						a[q] = a[p];
						a[p] = h;}}
				else if (t == 1){
					if (a[q] < a[p]){
						h = a[p];
						a[p] = a[q];
						a[q] = h;}}}}
		return a;}
	public static double[] sortArray (double a[], int t){
		double h = 0;
		for (int p = 0; p < a.length; p++){
			for (int q = 0; q < a.length; q++){
				if (t == 0){
					if (a[p] < a[q]){
						h = a[q];
						a[q] = a[p];
						a[p] = h;}}
				else if (t == 1){
					if (a[q] < a[p]){
						h = a[p];
						a[p] = a[q];
						a[q] = h;}}}}
		return a;}
	public static float[] sortArray (float a[], int t){

		float h = 0;
		for (int p = 0; p < a.length; p++){
			for (int q = 0; q < a.length; q++){
				if (t == 0){
					if (a[p] < a[q]){
						h = a[q];
						a[q] = a[p];
						a[p] = h;}}
				else if (t == 1){
					if (a[q] < a[p]){
						h = a[p];
						a[p] = a[q];
						a[q] = h;}}}}
		return a;}
	
	// Randomiser methods
	public static int[] randomizeArray (int a[]){
		Random r = new Random();
		int h[] = new int[a.length];
		int b[] = new int[a.length];
		for (int c = 0; c < a.length; c++){
	    	if (c == 0){
	    		b[c] = r.nextInt(a.length);}
	    	else {
	    		b[c] = r.nextInt(a.length);
	    		for (int d = 0; d < c; d++){
	    			while (b[c] == b[d]){
	    				if (b[c] == b[d]){
		    				d = 0;
		    			}
	    			b[c] = r.nextInt(a.length);}
	    		}
	    	}
	    	h[c] = a[c]; 
	    }
		for (int c = 0; c < a.length; c++){
			a[c] = h[b[c]];
		}
		return a;
	}
	public static double[] randomizeArray (double a[]){
		Random r = new Random();
		double h[] = new double[a.length];
		int b[] = new int[a.length];
		for (int c = 0; c < a.length; c++){
	    	if (c == 0){
	    		b[c] = r.nextInt(a.length);}
	    	else {
	    		b[c] = r.nextInt(a.length);
	    		for (int d = 0; d < c; d++){
	    			while (b[c] == b[d]){
	    				if (b[c] == b[d]){
		    				d = 0;
		    			}
	    			b[c] = r.nextInt(a.length);}
	    		}
	    	}
	    	h[c] = a[c]; 
	    }
		for (int c = 0; c < a.length; c++){
			a[c] = h[b[c]];
		}
		return a;
	}
	public static float[] randomizeArray (float a[]){
		Random r = new Random();
		float h[] = new float[a.length];
		int b[] = new int[a.length];
		for (int c = 0; c < a.length; c++){
	    	if (c == 0){
	    		b[c] = r.nextInt(a.length);}
	    	else {
	    		b[c] = r.nextInt(a.length);
	    		for (int d = 0; d < c; d++){
	    			while (b[c] == b[d]){
	    				if (b[c] == b[d]){
		    				d = 0;
		    			}
	    			b[c] = r.nextInt(a.length);}
	    		}
	    	}
	    	h[c] = a[c]; 
	    }
		for (int c = 0; c < a.length; c++){
			a[c] = h[b[c]];
		}
		return a;
	}
	public static long[] randomizeArray (long a[]){
		Random r = new Random();
		long h[] = new long[a.length];
		int b[] = new int[a.length];
		for (int c = 0; c < a.length; c++){
	    	if (c == 0){
	    		b[c] = r.nextInt(a.length);}
	    	else {
	    		b[c] = r.nextInt(a.length);
	    		for (int d = 0; d < c; d++){
	    			while (b[c] == b[d]){
	    				if (b[c] == b[d]){
		    				d = 0;
		    			}
	    			b[c] = r.nextInt(a.length);}
	    		}
	    	}
	    	h[c] = a[c]; 
	    }
		for (int c = 0; c < a.length; c++){
			a[c] = h[b[c]];
		}
		return a;
	}
	public static short[] randomizeArray (short a[]){
		Random r = new Random();
		short h[] = new short[a.length];
		int b[] = new int[a.length];
		for (int c = 0; c < a.length; c++){
	    	if (c == 0){
	    		b[c] = r.nextInt(a.length);}
	    	else {
	    		b[c] = r.nextInt(a.length);
	    		for (int d = 0; d < c; d++){
	    			while (b[c] == b[d]){
	    				if (b[c] == b[d]){
		    				d = 0;
		    			}
	    			b[c] = r.nextInt(a.length);}
	    		}
	    	}
	    	h[c] = a[c]; 
	    }
		for (int c = 0; c < a.length; c++){
			a[c] = h[b[c]];
		}
		return a;
	}
	public static boolean[] randomizeArray (boolean a[]){
		Random r = new Random();
		boolean h[] = new boolean[a.length];
		int b[] = new int[a.length];
		for (int c = 0; c < a.length; c++){
	    	if (c == 0){
	    		b[c] = r.nextInt(a.length);}
	    	else {
	    		b[c] = r.nextInt(a.length);
	    		for (int d = 0; d < c; d++){
	    			while (b[c] == b[d]){
	    				if (b[c] == b[d]){
		    				d = 0;
		    			}
	    			b[c] = r.nextInt(a.length);}
	    		}
	    	}
	    	h[c] = a[c]; 
	    }
		for (int c = 0; c < a.length; c++){
			a[c] = h[b[c]];
		}
		return a;
	}
	public static String[] randomizeArray (String a[]){
		Random r = new Random();
		String h[] = new String[a.length];
		int b[] = new int[a.length];
		for (int c = 0; c < a.length; c++){
	    	if (c == 0){
	    		b[c] = r.nextInt(a.length);}
	    	else {
	    		b[c] = r.nextInt(a.length);
	    		for (int d = 0; d < c; d++){
	    			while (b[c] == b[d]){
	    				if (b[c] == b[d]){
		    				d = 0;
		    			}
	    			b[c] = r.nextInt(a.length);}
	    		}
	    	}
	    	h[c] = a[c]; 
	    }
		for (int c = 0; c < a.length; c++){
			a[c] = h[b[c]];
		}
		return a;
	}
	public static char[] randomizeArray (char a[]){
		Random r = new Random();
		char h[] = new char[a.length];
		int b[] = new int[a.length];
		for (int c = 0; c < a.length; c++){
	    	if (c == 0){
	    		b[c] = r.nextInt(a.length);}
	    	else {
	    		b[c] = r.nextInt(a.length);
	    		for (int d = 0; d < c; d++){
	    			while (b[c] == b[d]){
	    				if (b[c] == b[d]){
		    				d = 0;
		    			}
	    			b[c] = r.nextInt(a.length);}
	    		}
	    	}
	    	h[c] = a[c]; 
	    }
		for (int c = 0; c < a.length; c++){
			a[c] = h[b[c]];
		}
		return a;
	}
	
	// Array searching methods
	public static boolean searchArray (String a[], String b){
		boolean r = false;
		for (int p = 0; p < a.length; p++){
			if (a[p].equals(b)){
				r = true;
			}
		}
		return r;
	}
	public static boolean searchArray (boolean a[], boolean b){
		boolean r = false;
		for (int p = 0; p < a.length; p++){
			if (a[p] == b){
				r = true;
			}
		}
		return r;
	}
	public static boolean searchArray (double a[], double b){
		boolean r = false;
		for (int p = 0; p < a.length; p++){
			if (a[p] == b){
				r = true;
			}
		}
		return r;
	}
	public static boolean searchArray (float a[], float b){
		boolean r = false;
		for (int p = 0; p < a.length; p++){
			if (a[p] == b){
				r = true;
			}
		}
		return r;
	}
	public static boolean searchArray (long a[], long b){
		boolean r = false;
		for (int p = 0; p < a.length; p++){
			if (a[p] == b){
				r = true;
			}
		}
		return r;
	}
	public static boolean searchArray (short a[], short b){
		boolean r = false;
		for (int p = 0; p < a.length; p++){
			if (a[p] == b){
				r = true;
			}
		}
		return r;
	}
	public static boolean searchArray (char a[], char b){
		boolean r = false;
		for (int p = 0; p < a.length; p++){
			if (a[p] == b){
				r = true;
			}
		}
		return r;
	}
	public static boolean searchArray (int a[], int b){
		boolean r = false;
		for (int p = 0; p < a.length; p++){
			if (a[p] == b){
				r = true;
			}
		}
		return r;
	}
	public static boolean searchArray(String a[][], String b){
		boolean r = false;
		for (int p = 0; p < a.length; p++){
			for (int q = 0; q < a[p].length; q++){
				if (a[p][q].equals(b)){
					r = true;
				}
			}
		}
		return r;
	}
	public static boolean searchArray(boolean a[][], boolean b){
		boolean r = false;
		for (int p = 0; p < a.length; p++){
			for (int q = 0; q < a[p].length; q++){
				if (a[p][q] == b){
					r = true;
				}
			}
		}
		return r;
	}
	public static boolean searchArray(double a[][], double b){
		boolean r = false;
		for (int p = 0; p < a.length; p++){
			for (int q = 0; q < a[p].length; q++){
				if (a[p][q] == b){
					r = true;
				}
			}
		}
		return r;
	}
	public static boolean searchArray(float a[][], float b){
		boolean r = false;
		for (int p = 0; p < a.length; p++){
			for (int q = 0; q < a[p].length; q++){
				if (a[p][q] == b){
					r = true;
				}
			}
		}
		return r;
	}
	public static boolean searchArray(short a[][], short b){
		boolean r = false;
		for (int p = 0; p < a.length; p++){
			for (int q = 0; q < a[p].length; q++){
				if (a[p][q] == b){
					r = true;
				}
			}
		}
		return r;
	}
	public static boolean searchArray(long a[][], long b){
		boolean r = false;
		for (int p = 0; p < a.length; p++){
			for (int q = 0; q < a[p].length; q++){
				if (a[p][q] == b){
					r = true;
				}
			}
		}
		return r;
	}
	public static boolean searchArray(char a[][], char b){
		boolean r = false;
		for (int p = 0; p < a.length; p++){
			for (int q = 0; q < a[p].length; q++){
				if (a[p][q] == b){
					r = true;
				}
			}
		}
		return r;
	}
	public static boolean searchArray(int a[][], int b){
		boolean r = false;
		for (int p = 0; p < a.length; p++){
			for (int q = 0; q < a[p].length; q++){
				if (a[p][q] == b){
					r = true;
				}
			}
		}
		return r;
	}
	
	
	// My encryption methods
	public static String encryptString(String a[], String w) {
		Random r = new Random();
		
		String e[] = new String[2 *(w.length())];
		int n[] = new int[w.length()];
		int i[] = new int[w.length()];
		
		for (int p = 0; p < w.length(); p++){
			for (int q = 0; q < a.length; q++){
				if (String.valueOf(w.charAt(p)).equals((a[q]))){
					n[p] = q;
					break;
					}
			}
		}

		for (int p = 0; p < w.length(); p++){
			i[p] = r.nextInt(10);
		}

		for (int p = 0,q = 0; p < e.length; p++,q++){
			if (p % 2 == 0){
				if (n[(p / 2)] + i[(p / 2)] >= a.length){
					e[p] = a[(n[(p / 2)] + i[(p / 2)] - a.length)];
				}
				else {
					e[p] = a[n[(p + 1) / 2] + i[(p + 1) / 2]];
				}
			}
			else {
				e[p] = Integer.toString(i[(p - ((q + 1) / 2))]);
			}
		}
		
		w = "";
		for (int p = 0; p < e.length; p++){
			w = w + e[p];
		}
		return w;
	}
	public static String decryptString(String a[], String w) {
		
		String l[] = new String[(w.length() / 2)];
		String d[] = new String[(w.length() / 2)];
		int v[] = new int[(w.length() / 2)];
		int i[] = new int[(w.length() / 2)];
		
		for (int p = 0, q = 1; p < w.length(); p++){
			if (p % 2 == 0){
				l[(p / 2)] = String.valueOf(w.charAt(p));
			}
			else {
				i[((p + 1) / 2) - 1] = Integer.parseInt(String.valueOf(w.charAt(p)));
				q = q + 1;
			}
		}
		
		for (int p = 0; p < l.length; p++){
			for (int q = 0; q < a.length; q++){
				if (l[p].equals((a[q]))){
					v[p] = q;
					}
			}
		}

		for (int p = 0; p < d.length; p++){
			if (v[(p)] - i[(p)] < 0){
				d[p] = a[a.length - (i[(p)] - v[(p)])];
			}
			else {
				d[p] = a[Math.abs(i[(p)] - v[(p)])];
			}
		}
		
		w = "";
		
		for (int p = 0; p < d.length; p++){
			w = w + d[p];
		}
		
		return w;
	}
	
	public static String[] getKey(){
		return key;
	}
	// [24.11.2016] # [13:19] # [Home]
	// Created this class and added simple methods
	
	// [24.11.2016] # [13:28] # [Home]
	// Added methods for creating and filling two dimensional arrays
	
	// [30.11.2016] # [11:38] # [DT]
	// Added methods for sorting.
	
	// [08.12.2016] # [23:55] # [Home]
	// Added simple encryption methods.
	
	// [11.12.2016] # [00:00] # [Home]
	// Added randomising methods.
	
	// [11.12.2016] # [14:06] # [Home]
	// Added search array methods.
}
