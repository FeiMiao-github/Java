package sum;

public class Solution {
	private static int []nums = {2, 7, 11, 15};
	private static int target = 9;
	
    public static int[] twoSum() {
        int i, j;
        int[] back = new int[2];
        for (i = 0; i < nums.length - 1; i++)
            for (j = i + 1; j < nums.length; j++)
                if ((nums[i] + nums[j]) == target) {
					{
						back[0] = i;
						back[1] = j;
					}
				}
        return back;
    }
}
