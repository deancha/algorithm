package dfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main_2667_단지번호붙이기 {
	static int[][] map;
	static int n;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/dfs/2667.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(in.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			String temp = in.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = temp.charAt(j) -'0';
			}
		}
		
		int no=1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j]==1) {
					no++;
					map[i][j]=no;
					dfs(i,j,no);
				}
			}
			
		}
		int[] counts = new int[no];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j]!=0) {
					counts[map[i][j]-1] +=1;
				}
			}
		}
		Arrays.sort(counts);
		System.out.println(no-1);
		for (int i = 1; i < no; i++) {
			System.out.println(counts[i]);
		}
	}
	private static void dfs(int i, int j, int no) {

		for (int d = 0; d < 4; d++) {
			int nr = i + dir[d][0];
			int nc = j + dir[d][1];
			
			if(nr>=0 && nc>=0 && nr<n && nc<n && map[nr][nc]==1) {
				map[nr][nc] = no;
				dfs(nr,nc,no);
			}
		}
	}

}
