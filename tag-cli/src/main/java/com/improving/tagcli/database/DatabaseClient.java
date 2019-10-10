package com.improving.tagcli.database;

import com.improving.tagcli.models.Weapon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DatabaseClient {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseClient.class);
    private final JdbcTemplate jdbcTemplate;

    public DatabaseClient(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Weapon> readWeaponsFromTable(){
        try{
            List<Weapon> weapons = jdbcTemplate.query("SELECT * FROM weapon LIMIT 10",
                    (result, rowNum) -> new Weapon(result.getInt("Id"),
                                                    result.getString("Name"),
                                                    result.getString("Area"),
                                                    result.getString("ItemType")));
            weapons.forEach(weapon -> logger.info("Weapon ID: {}, Name: {}", weapon.getId(), weapon.getName()));
            return weapons;

        } catch (DataAccessException e){
            logger.error("Error: ", e);
        }
        return Collections.EMPTY_LIST;
    }
    public void insertIntoTable() {
        logger.info("YOU GOT IT");
        int rowsAffected = jdbcTemplate.update
                ("Insert Into weapon (Name, Area, ItemType) " + "VALUES ('Smallish Dagger', 'Dagger Shop', 'Weapon')");
        logger.info("Rows Affected: {}", rowsAffected);
    }
}
