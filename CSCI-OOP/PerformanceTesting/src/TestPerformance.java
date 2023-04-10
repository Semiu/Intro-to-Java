
public class TestPerformance {
	
	public static void main(String[] args) {
		
	/**
	 * Sentinel values for performance improvement
	
		int numOfRuns = 40; //25, 30, 35, 40
		
		int t = 3;
		 
		long startTimeSet = System.currentTimeMillis();
		
		for (int i = 0; i < numOfRuns; i++) {
			
			//new FindTestValueA().find(t);
			
			new FindTestValueB().find(t);
			
		}

		long endTimeSet = System.currentTimeMillis();
		
		System.out.println("It took: " + (endTimeSet - startTimeSet) + " ms");
		
		 */
		/**
		 * Loop unrolling for performance improvement
		
		 */
		int numOfCycles = 40; //25, 30, 35, 40
		int iterations = 1000000; //1000, 10000; 100000; 1000000
		 
		long startTimeLoop = System.currentTimeMillis();
		
		for (int i = 0; i < numOfCycles; i++) {
			
			//new ComputeSumA().computeSum(iterations);
			
			new ComputeSumB().computeSum(iterations);
			
		}

		long endTimeLoop = System.currentTimeMillis();
		
		System.out.println("The loop took: " + (endTimeLoop - startTimeLoop) + " ms");
		

	}

}
