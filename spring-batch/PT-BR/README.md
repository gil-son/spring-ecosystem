# Spring Batch - PT-BR

## Sistemas Batch

Talvez o termo batch não seja tão familiar, mas com certeza você já ouviu falar sobre algum sistema ou rotina que uma empresa utiliza de
forma automática: enviar e-mails, notificações, processar a folha de pagamento, e etc.


Esses sistemas tem algo em comum, que é o grande volume de dados. O termo batch se refere a exatamente a isso... um lote de dados. Então por
definição, um sistema batch seria um <b>sistema que realiza um processamento de uma quantidade finita de dados sem interação ou interrupção</b>.

Historicamente o COBOL, foi a tecnologia dominante a utilizar o processamento batch. E ainda é utilizada por diversas empresas nos dias de hoje.
Programas COBOL executam mainframes que são computadores com alta capacidade de armazenamento e processamento, mas também de alto custo financeiro.

<div align="center">
<img src="https://thumbs2.imgbox.com/a7/c7/WOy6jVN1_t.png"/>
</div>

Pensando em uma forma de padrozinar o sistema batch, a Accenture junto diversas boas práticas, juntada em décadas, em um único framework que veio
a se chamar spring batch

Esse framework, trouxe o processamento batch, para a JVM, utilizando o Spring que já era um framework popular pela sua facilidade de uso

Na versão mais autal, também adotou a utilização do spring boot


## Refletir

Uma das grandes dificuldades é o processamento desse grande lote de dados, algumas questões que devem ser indereçadas, são:

- Tempo
	- em quanto tempo o processamento precisa ser realizado sem prejuizo aos sistemas que dependem desses dados?
- Integridade
	- se o sistema falhar, como garantir a integridade dos dados?

- Execução
	- como o sistema ira executar de forma agendada e encerrar sem interferência humana?

- Monitoramento
	- como acompanhar a execução do processamento para sabem o seu andamento e indentificar se houveram falhas
	
- Escalabilidade
	- é crucial para garantir que o processamento de dados seja feito dento da janela de tempo definida para a execução

- Disponbilidade
	- uma vez que a escabilidade é compromentidade, seja indisponibilidade de dados, a disponbilidades desses dados não é feita

- Usabilidade
	- normalmente se refere a interface gráfica do sistema, mas para o sistema batch se refere ao código em si
	- o quão simples é mantê-los/ indentificarerros 

<hr/>


### Sources

<ul>
  <li><a href="https://giuliana-bezerra.medium.com/spring-batch-para-desenvolvimento-de-jobs-1674ec5b9a20">Medium - Spring Batch</li>
</ul>
