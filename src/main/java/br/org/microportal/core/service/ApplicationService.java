package br.org.microportal.core.service;

import br.org.microportal.core.model.ApplicationDocument;
import br.org.microportal.core.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public List<ApplicationDocument> findAll() {
        return applicationRepository.findAll();
    }

    public List<ApplicationDocument> findServices() {
        return applicationRepository.findByService(true);
    }

    public Optional<ApplicationDocument> findById(String applicationId) {
        return applicationRepository.findById(applicationId);
    }

    public ApplicationDocument save(ApplicationDocument applicationDocument) {
        Optional<ApplicationDocument> savedDocument = applicationRepository.findByName(applicationDocument.getName());
        savedDocument.ifPresent(document -> applicationDocument.setId(document.getId()));
        return applicationRepository.save(applicationDocument);
    }

    public void unregister(String applicationId) {
        applicationRepository.deleteById(applicationId);
    }
}
