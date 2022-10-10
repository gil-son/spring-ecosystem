# Spring Batch - ENG-US

## Batch Systems

Perhaps the term batch is not so familiar, but surely you have heard about some system or routine that a company uses
automatic way: send emails, notifications, process payroll, etc.


These systems have something in common, which is the large volume of data. The term batch refers to exactly that... a batch of data. so why
definition, a batch system would be a <b>system that performs a processing of a finite amount of data without interaction or interruption</b>.

Historically COBOL has been the dominant technology using batch processing. It is still used by many companies today.
COBOL programs run mainframes, which are computers with high storage and processing capacity, but also high financial cost.

<div align="center">
<img src="https://thumbs2.imgbox.com/a7/c7/WOy6jVN1_t.png"/>
</div>

Thinking of a way to standardize the batch system, Accenture put together several good practices, gathered in decades, in a single framework that came
to be called spring batch

This framework brought batch processing to the JVM, using Spring, which was already a popular framework for its ease of use.

In the latest version, it also adopted the use of spring boot


## Reflect

One of the great difficulties is the processing of this large batch of data, some issues that must be addressed are:

- Time
  - how long does the processing need to be carried out without harm to the systems that depend on this data?

- Integrity
  - if the system fails, how to ensure data integrity?

- Execution
  - how will the system run on a schedule and shut down without human interference?

- Monitoring
  - how to follow the execution of the processing to know its progress and identify if there were failures

- Scalability
- it is crucial to ensure that the data processing is done within the time window defined for the execution

- Availability
  - since scalability is commitment, whether data unavailability, the availability of these data is not made

- Usability
  - normally refers to the graphical interface of the system, but for the batch system it refers to the code itself
  - how simple it is to keep them/identify errors


## Job lifecycle

<b>Job</b> can be defined as a collection of states and transitions from one to another defined by steps = <b>state machine</b>.

<div align="center">
<img src="https://user-images.githubusercontent.com/72712095/193472510-1943fb9a-b115-404a-8327-ab92ddd03b44.png" width="50%"/>
</div>

The <b>Job</b> has <b>3 steps</b>, each step has an internal logic of reading, processing and writing:

<div align="center">
<img src="https://miro.medium.com/max/1400/1*bYMHRTsH7cMGv9GMXEXWGQ.png" width="50%"/>
</div>

Depending on the result of processing in several blocks, the state machine changes its state, until it reaches the final state that
indicates that processing is complete.

So how does Spring Batch get this <b>state machine</b> to work?

In order for a job to run from start to finish, several spring-batch components come into play:

At the time of job execution, the <b>job launcher</b> is started. This also includes resetting and validating
parameters.

Once the job starts, the job executes its steps which have their state saved in the <b>job repository</b>.

<div align="center">
<img src="https://miro.medium.com/max/1400/1*IotPHxVJNyYea9t34G0wzg.png" width="50%"/>
</div>

The data in this repository, called spring-batch <b>metadata</b>, is used by the framework components to control the flow
of running the job.

Among the metadata must have several associated objects called instance jobs that represent a logical execution of the
job, that is, an execution of the job logic from start to finish, until it succeeds. Until then, several physical executions can occur, with
and success in the end. They are represented by an object called job execution.

<div align="center">
<img src="https://user-images.githubusercontent.com/72712095/193472119-383c1c39-7364-4c1e-8870-47702e3b745b.png" width="50%"/>
</div>

In short, we have a job associated with several logical actions that are associated with multiple physical executions <b>(job execution)</b>. Another factor that
defines the creation of a <b>job instance</b> object, are the execution parameters. As the parameters modify the logic, if they change, a new
logical execution will be generated, ie a <b>job instance</b>.


<hr/>


### Sources

<ul>
  <li><a href="https://giuliana-bezerra.medium.com/spring-batch-para-desenvolvimento-de-jobs-1674ec5b9a20">Medium - Spring Batch</li>
</ul>
