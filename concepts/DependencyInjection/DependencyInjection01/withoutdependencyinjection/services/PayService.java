package services;

public class PayService {
	DeductionService deductionService = new MGDeductionService();
	
	public double tax(double amount) {
		amount = amount - deductionService.deduction(amount);
		return amount * 0.2;
	}
}
