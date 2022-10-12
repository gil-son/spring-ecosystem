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


## Ciclo de vida do Job

<b>Job</b> pode ser definido como uma coleção de estados e transições de um para o outro definidos por steps = <b>máquina de estados</b>.

<div align="center">
<img src="https://user-images.githubusercontent.com/72712095/193472510-1943fb9a-b115-404a-8327-ab92ddd03b44.png" width="50%"/>
</div>

O <b>Job</b> possui <b>3 steps</b>, cada step possui uma lógica interna de leitura, processamento e escrita:

<div align="center">
<img src="https://miro.medium.com/max/1400/1*bYMHRTsH7cMGv9GMXEXWGQ.png" width="50%"/>
</div>

Dependendo do resultado do processamento em vários blocos a máquina de estado vai mudando de estado, até chega ao estado final que
indica que o processamento foi concluído.

Então como o Spring Batch consegue fazer essa <b>máquina de estados</b> funcionar?

Para que um job execute do início ao fim, vários componentes do spring-batch, entram em ação:

No momento da execução do job, o <b>job launcher</b> é iniciado. Isso inclui também a reinicialização e validação de 
parâmetros.

Uma vez que o job é iniciado, o job executa os seus steps que possuem seu estado salvo no <b>job repository</b>.

<div align="center">
<img src="https://miro.medium.com/max/1400/1*IotPHxVJNyYea9t34G0wzg.png" width="50%"/>
</div>

Os dados desse repoitório, são chamados de <b>metadados</b> do spring-batch, são utilizados pelos componentes do framework para controla o fluxo
de execução do job.

Dentre os metadados deve possuir vários objetos associados chamados de jobs instance que representam uma execução lógica do
job, ou seja, uma execução da lógica do job do início ao fim, até obter sucesso. Até lá pode ocorrer diversas execuções físicas, com falhas
e sucesso no final. Elas são representadas por um objeto chamado job execution.

<div align="center">
<img src="https://user-images.githubusercontent.com/72712095/193472119-383c1c39-7364-4c1e-8870-47702e3b745b.png" width="50%"/>
</div>

Resumindo, temos um job associado a diversas ações lógicas que estão associadas a  multiplas execuções físicas <b>(job execution)</b>. Outro fator que
define a criação de um objeto <b>job instance</b>, são os parâmetros de execução. Como os parâmetros modificam a lógica, se eles mudarem, uma nova
execução lógica será gerada, isto é, um <b>job instance</b>.

## Banco de Dados

Seja qual for o Banco de Dados (Postgres, MySQL, MongoDB, ...) é necessário configurar no application.properties/yaml. Com isso, ao executar um Job, o Spring Batch vai criar as seguintes tabelas com a inicial BATCH para gerenciar:
 	
- VISÃO DE ALTO NÍVEL DOS METADADOS
	- BATCH_JOB_EXECUTION:
		- quantidade de vezes que o Batch executou no total (inclui acertos e falhas)
		- quando o Job iníciou e encerrou
		- status atual do Job
	- BATCH_JOB_EXECUTION_CONTEXT
		- informações do contexto de utilização daquele Job (regras de negócio/lógicas)
	- BATCH_JOB_EXECUTION_PARAMS
		- informações do parametro
	- BATCH_JOB_EXECUTION_SEQ
		- informações da sequência executada
	- BATCH_JOB_INSTANCE
		- quantidades de vezes o Batch executou com sucesso / quantidades lógicas do Batch
		- nome do Job
	- BATCH_JOB_SEQ
		- informações da sequência executada
- VISÃO DE BAIXO NÍVEL DOS METADADOS
	- BATCH_STEP_EXECUTION
		- ver as step(s) que executaram
		- início e fim do Step
		- status do Step
	- BATCH_JOB_EXECUTION_CONTEXT
		- informações do contexto daquele Step que são importantes para indentificar a lógica/ contexto (está em chave valor)
	- BATCH_JOB_EXECUTION_SEQ
		- informações da sequência executada

<hr/>


### Sources

<ul>
  <li><a href="https://giuliana-bezerra.medium.com/spring-batch-para-desenvolvimento-de-jobs-1674ec5b9a20">Medium - Spring Batch</li>
</ul>
