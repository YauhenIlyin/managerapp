package by.ilyin.manager.service;

import by.ilyin.manager.entity.ApplicationServer;

import java.util.List;
import java.util.Optional;

public interface ApplicationServerService {

    Optional<ApplicationServer> findByServerName(String serverName);

    public Optional<ApplicationServer> findById(Long id);

    public List<ApplicationServer> findAll();

    public void save(ApplicationServer applicationServer);

}
