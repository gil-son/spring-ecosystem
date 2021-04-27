package services;

public class SPDeductionServiceDI implements DeductionService{

	@Override
	public double deduction(double amount) {
		return amount * 0.10;
	}
}