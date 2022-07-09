import java.util.*;
import java.io.*;
public class USACOblockedbillboard{
	static int area = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("billboard.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
		int[] lawnBill = new int[4]; //0 is xLL, 1 is yLL, 2 is xUR, 3 is yUR
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i < 4; i++) {
			lawnBill[i] = Integer.parseInt(st.nextToken());
		}
		int[] feedBill = new int[4];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < 4; i++) {
			feedBill[i] = Integer.parseInt(st.nextToken());
		}
		solve(lawnBill, feedBill);
		pw.println(area);
		pw.close();
		in.close();
	}
	public static void solve(int[] lawnBill, int[] feedBill) {
		int A = feedBill[0];
		int B = feedBill[2];
		int E = feedBill[3];
		int F = feedBill[1];
		
		int C = lawnBill[0];
		int D = lawnBill[2];
		int G = lawnBill[3];
		int H = lawnBill[1];
		
		area = (D - C) * (G - H);
		
		if((A <= C && B >= D) && ((E >= G && F < G) || (F <= H && E > H))){ 
			//If a less than equal c and b larger than equal d
			//and if e is greater than or equal to g and f is less than g
			//or if f is less than or equal to h while e is greater than h
			area -= (D - C) * (Math.min(E, G) - Math.max(F,  H));
			return;
		}
		else if((E >= G && F <= H) && ((A <= C && B > C) || (B >= D && A < D))) {
			//if e is greater than or equal to g and f is less than or equal to h
			//and either a less equal to c while b greater than c or b greater than equal to d while a less than d
			area -= (Math.min(B, D) - Math.max(A, C)) * (G - H);
			return;
		}
	}
}