package hou.forwz.Point1Acres3.tree;

import hou.forwz.Point1Acres3.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月23日下午3:40:10
 * @url http://www.1point3acres.com/bbs/thread-197742-1-1.html
 */

public class BestMatch {
	int left = Integer.MIN_VALUE, right = Integer.MAX_VALUE;

	int best(TreeNode root, int tar) {
		if (root.val == tar)
			return root.val;
		else {
			while (root != null) {
				if (root.val > tar) {
					right = Math.max(right, root.val);
					root = root.left;
				} else if (root.val < tar) {
					left = Math.min(left, root.val);
					root = root.right;
				} else
					return tar;
			}

			if ((tar - left) < (right - tar))
				return left;
			else
				return right;
		}
	}
}
