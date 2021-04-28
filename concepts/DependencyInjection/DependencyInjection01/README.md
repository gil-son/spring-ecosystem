# Dependency Injection01

## Analise SEM Injeção de Dependência

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

<p> Bom, funciona... mas caso seja necessário implementar outro serviço, agora referente a localidade SP, vamos precisar mexer na classe PayService e substituir instância por SPDeductionService(), tem como criar condicionais também... mas precisa mexer direto na classe para trocar a instância e/ou criar condicionais... não é interessante para o desenvolvimento da aplicação e manutenção. Imagina que p/ cada novo serviço, uma nova condicional e/ou instância? É por isso que vamos utilizar a inversão de dependência, mais conhecida como Injeção de Dependência.</p>


## Analise COM Injeção de Dependência


<p> Bom, então vamos implementar o conceito de Injeção de dependência. Primeiro vamos até a classe 'PayService':</p>

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


<p>Desacoplamos a instância fixa do MGDeductionService() deixando o 'DeductionService deductionService' sem nenhum vinculo:</p>

```
package services;

public class PayService {
	DeductionService deductionService;
	
	public double tax(double amount) {
		amount = amount - deductionService.deduction(amount);
		return amount * 0.2;
	}
}

```
<p>Criamos um construtor para receber como parâmetro um 'deductionService' externo que será atribuido ao 'deductionService' interno:</p>

```
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
```

<p>Observe, antes tinhamos algo fixo, agora, podemos acoplar algo que vem fora com o nosso 'deduction'.</p>

<p>Bom mas de onde virá o 'deductionService' externo? Da classe principal, no nosso caso a Program:</p>


```
package application;

import services.PayService;

public class Program {
	public static void main(String[] args) {
		PayService payService = new PayService(new MGDeductionService() );
		double tax = payService.tax(1000.0);
		System.out.println(tax);
	}
}
```

<p>Veja que agora o 'MGDeductionService()' é instânciado na classe Program (main) o que livra de mexermos na class PayService que contém a regra de negócio. Podemos otimizar:</p>

```

public class ProgramDI {
	public static void main(String[] args) {
		// DeductionService deductionService = new MGDeductionService();
		
		MGDeductionService mg = new MGDeductionService();
		
		PayServiceDI payService = new PayService(mg);
		double tax = payService.tax(1000.0);
		System.out.println(tax);
	}
}
```

<p>Se quisermos implementar a localidade SP ou outras basta criar a classe: </p>

```
package services;

public class SPDeductionServiceDI implements DeductionService{

	@Override
	public double deduction(double amount) {
		return amount * 0.10;
	}
}
```

<p>Em seguida basta:</p>

```
public class ProgramDI {
	public static void main(String[] args) {
		// DeductionService deductionService = new MGDeductionService();
		
		MGDeductionService mg = new MGDeductionService();
		SPDeductionService sp = new MGDeductionService();
		
		PayServiceDI payService = new PayService(sp);
		double tax = payService.tax(1000.0);
		System.out.println(tax);
	}
}
```

<p>Se executarmos:</p>

```
180.0
```

## Source:

<ul>
	<li><a href="https://www.youtube.com/watch?v=O07XFebgw-g">DevSuperior - Injeção de dependência e inversão de controle</a></li>
</ul>
