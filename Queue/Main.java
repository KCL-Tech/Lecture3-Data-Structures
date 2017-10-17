import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		float[] nums = new float[] { 1.0f, -1.0f, 2.75f, 3.8f, 60.4f, -22.43f };

		System.out.println(Arrays.toString(nums));

		SimpleQueue<Float> queue = new SimpleQueue<Float>();

		for (int i = 0; i < nums.length; i++) {
			queue.enqueue(nums[i]);
		}

		for (int i = 0; i < nums.length; i++) {
			nums[i] = queue.dequeue();
		}

		System.out.println(Arrays.toString(nums));
	}
}
