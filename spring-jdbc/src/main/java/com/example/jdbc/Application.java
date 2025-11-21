package com.example.jdbc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
  public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
  }

  @Bean
  CommandLineRunner run(PersonDao dao) {
      return args -> {
          System.out.println("--- JDBC: insert, update, delete demo ---");
          dao.insert(new Person(1, "Alice", "alice@example.com"));
          dao.insert(new Person(2, "Bob", "bob@example.com"));
          dao.listAll().forEach(System.out::println);

          System.out.println("\n--- JDBC: PreparedStatement via JdbcTemplate (insert) ---");
          dao.insertWithPrepared(3, "Charlie", "charlie@example.com");
          dao.listAll().forEach(System.out::println);

          System.out.println("\n--- JDBC: ResultSetExtractor demo (fetch by id 2) ---");
          System.out.println(dao.findByIdUsingExtractor(2));

          System.out.println("\n--- JDBC: RowMapper demo (fetch all) ---");
          dao.listAll().forEach(System.out::println);

          System.out.println("\n--- JDBC: update and delete demo ---");
          dao.updateEmail(1, "alice.new@example.com");
          dao.delete(3);
          dao.listAll().forEach(System.out::println);
      };
  }
}
