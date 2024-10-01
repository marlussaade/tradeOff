package br.com.mrsitech.tradeOff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TradeOffApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeOffApplication.class, args);
	}

}
