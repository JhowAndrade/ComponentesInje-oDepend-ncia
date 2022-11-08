package com.johanny.desafio1;

import com.johanny.entities.Order;
import com.johanny.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan({"com.johanny"})
public class Desafio1Application implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(Desafio1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.printf("ENTRADA(dados do pedido: código, valor básico, porcentagem de desconto)%n");
		System.out.println();
		Integer code = sc.nextInt();
		double basic = sc.nextDouble();
		double discount = sc.nextDouble();

		Order order = new Order(code, basic, discount);

		System.out.println();
		System.out.println("Pedido Codigo " + order.getCode() + "\nValor total: R$ "
				+ String.format("%.2f ", orderService.total(order)));

	}
}
