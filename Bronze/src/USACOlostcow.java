import java.io.*;
import java.util.*;

public class USACOlostcow {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("lostcow.in"));
		PrintWriter out = new PrintWriter(new FileWriter("lostcow.out"));

		StringTokenizer st = new StringTokenizer(in.readLine());
		int xPos = Integer.parseInt(st.nextToken());
		int yPos = Integer.parseInt(st.nextToken());


		int toWalk = 1;
		int Distance = 0;
		int direction = 0;
		int x = xPos;

		while(xPos != yPos){
			if(direction == 0){
				xPos = xPos + toWalk;
				Distance = Distance + toWalk;
				if(xPos >= yPos) {
					Distance = Distance - (xPos - yPos);
					break;
				}
				else{
					Distance = Distance + toWalk;
					xPos = x;
				}
				direction = 1;
			}	   
			else{
				xPos = xPos - toWalk;
				Distance = Distance + toWalk;
				if(xPos <= yPos) {
					Distance = Distance - Math.abs(xPos - yPos);
					break;
				}
				else{
					Distance = Distance + toWalk;
					xPos = x;
				}
				direction = 0;
			}
			toWalk = toWalk * 2;
		}
	}
}