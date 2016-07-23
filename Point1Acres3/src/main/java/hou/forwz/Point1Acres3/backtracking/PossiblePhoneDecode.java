package hou.forwz.Point1Acres3.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月23日下午3:03:50
 * @end 2016年07月23日15:17:51
 * @description 输出可能的解锁方案
 */

public class PossiblePhoneDecode {
	int[][] phone = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
	List<List<Integer>> ret = new LinkedList<>();

	public static void main(String[] args) {
		PossiblePhoneDecode pp = new PossiblePhoneDecode();
		List<List<Integer>> list = pp.possible(4);
		for (List<Integer> l : list)
			System.out.println(l);

		System.out.println(list.size());
	}

	List<List<Integer>> possible(int k) {
		for (int i = 0; i < phone.length; i++) {
			for (int j = 0; j < phone[0].length; j++) {
				dfs(phone, i, j, k, new LinkedList<Integer>());
			}
		}
		return ret;
	}

	private void dfs(int[][] phone, int x, int y, int k, LinkedList<Integer> before) {
		if (in(phone, x, y) && phone[x][y] != 0) {
			if (k == 1) {
				before.add(phone[x][y]);
				ret.add(new ArrayList<>(before));
				before.removeLast();
			}

			int tmp = phone[x][y];
			before.add(tmp);
			phone[x][y] = 0;

			dfs(phone, x + 1, y, k - 1, before);
			dfs(phone, x - 1, y, k - 1, before);
			dfs(phone, x, y + 1, k - 1, before);
			dfs(phone, x, y - 1, k - 1, before);
			dfs(phone, x - 1, y - 1, k - 1, before);
			dfs(phone, x + 1, y - 1, k - 1, before);
			dfs(phone, x - 1, y + 1, k - 1, before);
			dfs(phone, x + 1, y + 1, k - 1, before);

			before.removeLast();
			phone[x][y] = tmp;

		}

	}

	private boolean in(int[][] phone, int x, int y) {
		if (x >= 0 && x < phone.length && y >= 0 && y < phone[0].length)
			return true;
		else
			return false;
	}
}
