package sriharilabs.reactive.sriharilabs_reactive;

import java.awt.print.Book;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SriharilabsReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(SriharilabsReactiveApplication.class, args);
	}

	

	 @Bean
		public ApplicationRunner booksInitializer() {
	    	
		 
		 
		 System.out.println("its working...");
		 return null;

		}
}
