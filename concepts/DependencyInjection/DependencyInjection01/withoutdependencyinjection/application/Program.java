package application;

import services.PayService;

public class Program {
	public static void main(String[] args) {
		PayService payService = new PayService();
		double tax = payService.tax(1000.0);
		System.out.println(tax);
	}
}
