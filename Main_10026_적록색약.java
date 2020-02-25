package dfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10026_적록색약 {
	static char[][] map;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int n;
	static boolean[][] visit1;
	static boolean[][] visit2;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/dfs/10026.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		map = new char[n][n];
		visit1 = new boolean[n][n];
		visit2 = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = in.readLine().toCharArray();
		}

		int cnt1 = 0;
		int cnt2 = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit1[i][j]) {
					visit1[i][j] = true;
					dfs1(i, j, map[i][j]);
					cnt1++;
				}
				if (!visit2[i][j]) {
					visit2[i][j] = true;
					dfs2(i, j, map[i][j]);
					cnt2++;
				}
			}
		}
		System.out.println(cnt1);
		System.out.println(cnt2);

	}

	private static void dfs2(int i, int j, char c) {
		for (int d = 0; d < 4; d++) {
			int nr = i + dir[d][0];
			int nc = j + dir[d][1];
			if(c!='B') {
				if (nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] != 'B' && !visit2[nr][nc]) {
					visit2[nr][nc] = true;
					dfs2(nr, nc, c);
				}
			}else {
				if (nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] == 'B' && !visit2[nr][nc]) {
					visit2[nr][nc] = true;
					dfs2(nr, nc, c);
				}
			}
		}
	}

	// 일반인이 봤을 때 - R,G,B 모두 구
	private static void dfs1(int i, int j, char c) {
		for (int d = 0; d < 4; d++) {
			int nr = i + dir[d][0];
			int nc = j + dir[d][1];
			if (nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] == c && !visit1[nr][nc]) {
				visit1[nr][nc] = true;
				dfs1(nr, nc, c);
			}
		}

	}
}
