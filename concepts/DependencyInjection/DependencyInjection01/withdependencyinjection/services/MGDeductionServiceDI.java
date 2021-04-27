package services;

public class MGDeductionServiceDI implements DeductionService{

	@Override
	public double deduction(double amount) {
		return amount * 0.12;
	}
}
