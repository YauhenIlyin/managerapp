package by.ilyin.manager.service;

import by.ilyin.manager.entity.ApplicationServer;
import by.ilyin.manager.util.observer.Observable;

import java.util.List;
import java.util.Optional;

public interface ApplicationServerService extends Observable {

    Optional<ApplicationServer> findByServerName(String serverName);

    public Optional<ApplicationServer> findById(Long id);

    public List<ApplicationServer> findAll();

    public void save(ApplicationServer applicationServer);

}
