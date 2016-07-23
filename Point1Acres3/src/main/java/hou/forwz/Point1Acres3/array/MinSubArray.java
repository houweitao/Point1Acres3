package hou.forwz.Point1Acres3.array;

/**
 * @author houweitao
 * @date 2016年7月23日下午6:34:51
 * @url http://mp.weixin.qq.com/s?__biz=MjM5ODIzNDQ3Mw==&mid=2649965753&idx=1&sn
 *      =787eab6fbd1f47563dd9bf4851499e79&scene=0#wechat_redirect
 */

public class MinSubArray {

	int minBrefy(int[] nums) {
		int minEndingHere = Integer.MAX_VALUE;
		int minSoFar = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {
			minEndingHere = Math.min(minEndingHere + nums[i], nums[i]);
			minSoFar = Math.min(minSoFar, minEndingHere);
		}

		return minSoFar;
	}

	int getMin(int[] nums) {
		int minAll = Integer.MAX_VALUE;
		int minEndHere = nums[0];

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] <= 0) {
				minEndHere = minEndHere + nums[i];
			} else {
				minAll = Math.min(minAll, minEndHere);
				if (minEndHere + nums[i] > nums[i]) {
					minEndHere = nums[i];
				} else
					minEndHere = minEndHere + nums[i];
			}
		}

		return minAll;
	}

	int getMx(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];

		int maxAll = Integer.MIN_VALUE;
		int maxEndHere = nums[0];

		for (int i = 1; i < nums.length; i++) {
			maxAll = Math.max(maxAll, maxEndHere);

			if (maxEndHere + nums[i] >= nums[i]) {
				maxEndHere = maxEndHere + nums[i];
			} else {
				// maxAll = Math.max(maxAll, maxEndHere);
				maxEndHere = nums[i];
			}
		}
		return maxAll;
	}
}
