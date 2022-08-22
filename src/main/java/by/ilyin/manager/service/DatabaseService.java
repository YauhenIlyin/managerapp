package by.ilyin.manager.service;

import by.ilyin.manager.entity.Database;

import java.util.List;
import java.util.Optional;

public interface DatabaseService {

    public Optional<Database> findByName(String databaseName);

    public Optional<Database> findById(Long id);

    public List<Database> findAll();

    public void save(Database database);

}
