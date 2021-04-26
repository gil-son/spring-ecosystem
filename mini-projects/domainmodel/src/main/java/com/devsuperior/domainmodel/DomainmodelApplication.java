package com.devsuperior.domainmodel;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.domainmodel.entities.Client;
import com.devsuperior.domainmodel.entities.Order;
import com.devsuperior.domainmodel.entities.OrderItem;
import com.devsuperior.domainmodel.entities.OrderStatus;
import com.devsuperior.domainmodel.entities.Product;
import com.devsuperior.domainmodel.repositories.ClientRepository;
import com.devsuperior.domainmodel.repositories.OrderRepository;
import com.devsuperior.domainmodel.repositories.ProductRepository;

@SpringBootApplication
public class DomainmodelApplication implements CommandLineRunner{ // CommandLineRunner is an interface, that will run command when initialize the application

	// Inject an instance from clientRepository here
	
	/* 1. Declare the attribute. Its will turn clientRepository (component) an dependency inside DomainmodelApplication
	   2. Make the annotation @Autowire for framework inject here
	*/
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DomainmodelApplication.class, args);
	}

	@Override      // ELLIPSIS (...)
	public void run(String... args) throws Exception { // The args parameter will receives data from the command line
		// here will run command when initialize the application
		
		Client c1 = new Client(null,"Alex Green","alex@gmail.com");
		clientRepository.save(c1);
		
		Product p1 = new Product(null, "TV", 1000.0);
		Product p2 = new Product(null, "Mouse", 40.0);
		Product p3 = new Product(null, "PC", 1200.0);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		OrderStatus status = OrderStatus.PAID;
		Instant instant = Instant.parse("2021-04-18T11:25:09Z"); // Z = Greenwich meridian 0º //Instant.now(); 
		
		Order o1 = new Order(null,instant,status,c1); // Merge/ Join
		Order o2 = new Order(null,Instant.parse("2021-04-20T14:35:44Z"),OrderStatus.WAITING,c1);  
		
		
		orderRepository.saveAll(Arrays.asList(o1,o2));
		
		// Use 1000.0 instead p1.getPrice()
		OrderItem oi1 = new OrderItem(null,1,1000.0,p1,o1);
		OrderItem oi2 = new OrderItem(null,2,4.0,p1,o1);
		OrderItem oi3 = new OrderItem(null,1,4.0,p1,o2);
		OrderItem oi4 = new OrderItem(null,1,1200.0,p1,o2);
		
		// ordemItemRepository.saveAll((Arrays.asList(oi1,oi2,oi3,oi4)));
		
		// In this case of strong composition. The right thing would be to implement 'OrdemItem' as an association class between 'Order' and 'Product'
		// So 'OrdemItem' would only exist if there are both. But in order not to complicate the teacher went like this
		
		
		
	}

}
