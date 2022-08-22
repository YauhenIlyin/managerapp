package by.ilyin.manager.service;

import by.ilyin.manager.entity.ProgrammingLanguage;
import by.ilyin.manager.util.observer.Observable;

import java.util.List;
import java.util.Optional;

public interface ProgrammingLanguageService extends Observable {

    public Optional<ProgrammingLanguage> findByLanguageName(String languageName);

    public Optional<ProgrammingLanguage> findById(Long id);

    public List<ProgrammingLanguage> findAll();

    public void save(ProgrammingLanguage programmingLanguage);

}
