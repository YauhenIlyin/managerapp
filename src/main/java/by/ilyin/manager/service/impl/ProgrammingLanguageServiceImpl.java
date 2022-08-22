package by.ilyin.manager.service.impl;

import by.ilyin.manager.entity.ProgrammingLanguage;
import by.ilyin.manager.service.ProgrammingLanguageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgrammingLanguageServiceImpl implements ProgrammingLanguageService {
    @Override
    public Optional<ProgrammingLanguage> findByLanguageName(String languageName) {
        return Optional.empty();
    }

    @Override
    public Optional<ProgrammingLanguage> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<ProgrammingLanguage> findAll() {
        return null;
    }

    @Override
    public void save(ProgrammingLanguage programmingLanguage) {

    }
}
