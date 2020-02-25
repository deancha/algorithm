package dfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012_유기농배추 {
	static int[][] map;
	static int C, R;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/dfs/1012.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			map = new int[R][C];

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(in.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}
			int no = 1;

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 1) {
						map[i][j] = ++no;
						dfs(i, j, no);
					}

				}
			}

			System.out.println(no-1);
		}
	}

	private static void dfs(int i, int j, int no) {
		for (int k = 0; k < 4; k++) {
			int r = i + dir[k][0];
			int c = j + dir[k][1];
			if (r >= 0 && c >= 0 && r < R && c < C && map[r][c] == 1) {
				map[r][c]=no;
				dfs(r,c,no);
			}
		}

	}
}
