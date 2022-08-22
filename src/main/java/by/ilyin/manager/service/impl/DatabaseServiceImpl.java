package by.ilyin.manager.service.impl;

import by.ilyin.manager.entity.Database;
import by.ilyin.manager.service.DatabaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DatabaseServiceImpl implements DatabaseService {
    @Override
    public Optional<Database> findByName(String databaseName) {
        return Optional.empty();
    }

    @Override
    public Optional<Database> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Database> findAll() {
        return null;
    }

    @Override
    public void save(Database database) {

    }
}
