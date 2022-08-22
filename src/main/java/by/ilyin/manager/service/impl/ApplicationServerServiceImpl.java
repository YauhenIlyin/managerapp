package by.ilyin.manager.service.impl;

import by.ilyin.manager.entity.ApplicationServer;
import by.ilyin.manager.service.ApplicationServerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServerServiceImpl implements ApplicationServerService {
    @Override
    public Optional<ApplicationServer> findByServerName(String serverName) {
        return Optional.empty();
    }

    @Override
    public Optional<ApplicationServer> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<ApplicationServer> findAll() {
        return null;
    }

    @Override
    public void save(ApplicationServer applicationServer) {

    }
}
