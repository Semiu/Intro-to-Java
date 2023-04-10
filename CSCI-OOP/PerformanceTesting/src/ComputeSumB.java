
public class ComputeSumB {
	
	double computeSum (int numIterations) {
		
		double sum0, sum1, sum2, sum3, sum4, sum5, sum6, sum7;
		
		int i;
		
		double sum = 0.0;
		
		sum0 = sum1 = sum2 = sum3 = sum4 = sum5 = sum6 = sum7 = 0.0;
		
		for (i = 0; (i + 7) < numIterations; i += 8) {
			sum0 += 1.0;
			sum1 += 1.0;
			sum2 += 1.0;
			sum3 += 1.0;
			sum4 += 1.0;
			sum5 += 1.0;
			sum6 += 1.0;
			sum7 += 1.0;
		}
		
		sum = sum0 + sum1 + sum2 + sum3 + sum4 + sum5 + sum6 + sum7;
		
		for (; i < numIterations; i++) {
			sum += 1.0;
		}
		
		return sum;
	}

}
