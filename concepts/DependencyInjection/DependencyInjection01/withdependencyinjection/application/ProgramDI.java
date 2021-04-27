package application;

import services.DeductionService;
import services.MGDeductionService;
import services.MGDeductionServiceDI;
import services.PayServiceDI;
import services.SPDeductionServiceDI;

public class ProgramDI {
	public static void main(String[] args) {
		// DeductionService deductionService = new MGDeductionService();
		
		MGDeductionServiceDI mg = new MGDeductionServiceDI();
		SPDeductionServiceDI sp = new SPDeductionServiceDI();
		
		PayServiceDI payServiceDI = new PayServiceDI(mg);
		double tax = payServiceDI.tax(1000.0);
		System.out.println(tax);
	}
}