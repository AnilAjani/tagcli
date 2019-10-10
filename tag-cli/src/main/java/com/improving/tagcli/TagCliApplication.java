package com.improving.tagcli;

import com.improving.tagcli.database.DatabaseClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class TagCliApplication implements CommandLineRunner {

    private final DatabaseClient databaseClient;

public TagCliApplication(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    public static void main(String[] args) {
    SpringApplication.run(TagCliApplication.class);
	}

	@Override
	public void run(String... args) throws Exception {
        databaseClient.insertIntoTable();
        databaseClient.readWeaponsFromTable();
	}
}
