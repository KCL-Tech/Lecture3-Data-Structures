import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		float[] nums = new float[] { 1.0f, -1.0f, 2.75f, 3.8f, 60.4f, -22.43f };

		System.out.println(Arrays.toString(nums));

		SimpleStack<Float> stack = new SimpleStack<Float>();

		for (int i = 0; i < nums.length; i++) {
			stack.push(nums[i]);
		}

		for (int i = 0; i < nums.length; i++) {
			nums[i] = stack.pop();
		}

		System.out.println(Arrays.toString(nums));
	}
}
