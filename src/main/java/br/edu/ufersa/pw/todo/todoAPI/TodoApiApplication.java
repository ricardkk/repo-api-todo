package br.edu.ufersa.pw.todo.todoAPI;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoApiApplication.class, args);
	}
	@Component
	public static class Runner implements ApplicationRunner{
		@Value("${var1:valor default na classe app!}")
		String teste;
		@Override
		public void run(ApplicationArguments args) throws Exception {
			System.out.println("Rodou corretamente!!  com " + teste);
		}
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
