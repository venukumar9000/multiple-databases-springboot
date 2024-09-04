package com.example.mds;

import com.example.mds.orderentity.Order;
import com.example.mds.productentity.Product;
import com.example.mds.orderRepository.OrderDao;
import com.example.mds.productrepository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class MdsApplication implements CommandLineRunner {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private OrderDao orderDao;

	public static void main(String[] args) {
		SpringApplication.run(MdsApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("inserting-------------------------");
		Product product = new Product(2,"phone",100000.00);
		productDao.save(product);

		Order order = new Order(1,"book", LocalDate.now());
		orderDao.save(order);
		System.out.println("inserted-------------------------");
	}
}
