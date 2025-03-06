import java.util.Random;

public class BasicPerceptrone {
	float wb;
	float bias = 1;
	
	float w0, w1;
	float learningRate = 0.01f;

	public void init() {
		Random random = new Random();
		wb = (random.nextFloat() - 0.5f) * 2f;
		w0 = (random.nextFloat() - 0.5f) * 2f;
		w0 = (random.nextFloat() - 0.5f) * 2f;
	}

	public int guess(float x0, float x1) {
		float total = wb * bias + x0 * w0 + x1 * w1;
		if (total > 0) {
			return 1;
		} else {
			return -1;
		}
	}

	public int[] createGuessSet(float[] x0s, float x1s[], int numberOfElement) {
		int[] results = new int[numberOfElement];
		for (int i = 0; i < numberOfElement; i++) {
			results[i] = guess(x0s[i], x1s[i]);
		}
		return results;
	}

	public void training(float x0, float x1, int o) {
		int t = guess(x0, x1);
		int d = o - t;
		wb += d * bias * learningRate;
		w0 += d * x0 * learningRate;
		w1 += d * x1 * learningRate;
	}
	
	public float x0InTen() {
		return ((-w0 * 10) - wb) / w1;
	}

	public float mX0InTen() {
		return ((-w0 * -10) - wb) / w1;
	}

}
