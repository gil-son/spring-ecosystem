package services;

public class PayServiceDI {
	DeductionService deductionService;
	
	public PayServiceDI(DeductionService deductionService){
		this.deductionService = deductionService;
	}
	
	public double tax(double amount) {
		amount = amount - deductionService.deduction(amount);
		return amount * 0.2;
	}
}
