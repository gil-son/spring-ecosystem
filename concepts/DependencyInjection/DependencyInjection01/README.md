# Dependency Injection01

<p> Imagina que você tem uma quantidade de dinheiro e você quer descobrir o quanto de imposto precisa pagar:</p>

```
package application;

import services.PayService;

public class Program {
	public static void main(String[] args) {
		PayService payService = new PayService();
		double tax = payService.tax(1000.0);
		System.out.println(tax);
	}
}

```

<p>Para descobrir esse imposto foi instânciado um serviço de pagamento:</p>

```
  PayService payService = new PayService();
```

<p>Desse serviço de pagamento, foi chamado o método 'tax' que é referente ao imposto, passando a quantida de 1000.0:</p>

```
  double tax = payService.tax(1000.0);
```

<p> O resultado será:</p>

```
176.0
```

<p>Porque deu 176.0? Acessando a classe 'PayService':</p>

```
package services;

public class PayService {
	DeductionService deductionService = new MGDeductionService();
	
	public double tax(double amount) {
		amount = amount - deductionService.deduction(amount);
		return amount * 0.2;
	}
}
```

<p>Vemos que ele tem uma dependência para 'DeductionService deductionService' que é um serviço de dedução (abate o valor valor antes de calcular o imposto). Bom Esse 'deductionService' tem a instância do 'MGDeductionService()', ou seja, é o serviço de dedução especifico da região de MG. </p>


<p> Se acessarmos o DeductionService vamos ver que ele é uma Interface que define o método 'deduction':</p>

```
package services;

public interface DeductionService {

	public double deduction(double amount);
}

```

<p>Então a classe 'MGDeductionService' vai implamentar o 'DeductionService' e vai sobreescrever o método 'deduction' informando que o valor que entrar retornará 12% do seu valor:</p>

```
package services;

public class MGDeductionService implements DeductionService{

	@Override
	public double deduction(double amount) {
		return amount * 0.12;
	}
}

```

<p> Então voltando para a classe PayService:</p>

```
package services;

public class PayService {
	DeductionService deductionService = new MGDeductionService();
	
	public double tax(double amount) {
		amount = amount - deductionService.deduction(amount);
		return amount * 0.2;
	}
}
```

<p> O método 'tax()' vai subtrair o valor que entrar com 12% desse mesmo valor e em seguida multiplicar esse valor por 20%. No de correr desse processo temos:</p>

```
  (1000.0 - (1000.0 * 0.12)) * 0.2 = 176.0

```

<p></p>
```
```
<p></p>
```
```
<p></p>
```
```
<p></p>
```
```
<p></p>
