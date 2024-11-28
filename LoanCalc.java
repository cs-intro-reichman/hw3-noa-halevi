public class LoanCalc {
	
	static double epsilon = 0.001;  
	static int iterationCounter;   
	
		public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}
	private static double endBalance(double loan, double rate, int n, double payment) {	
        double balance = loan;
        rate = rate / 100; 
        for(int i=0; i < n; i++){
            balance -= payment;
            balance *= (rate+1);
        } return balance;
	
	}
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
        double payment = loan / n ; 
        iterationCounter = 0;  
        double balance = loan;
        while (balance >= epsilon) {
            balance = endBalance(loan, rate, n, payment);
            if (balance <= epsilon){
                break;
            }else{
            payment += epsilon;
            balance = loan;
            }
            iterationCounter++;
        }
        return payment;
    }

    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
        double low = loan / n; 
        double high = loan;  
        iterationCounter = 0;    
        while (high - low > epsilon) {
            double mid = (low + high) / 2; 
            double balance = endBalance(loan, rate, n, mid);
    
            if (balance > 0) {
                low = mid;
            } else {
                high = mid; 
            }
            iterationCounter++;
        }
        return (low + high) / 2; 
    }
}
	



