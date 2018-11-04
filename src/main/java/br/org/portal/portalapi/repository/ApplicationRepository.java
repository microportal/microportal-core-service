package br.org.portal.portalapi.repository;

import br.org.portal.portalapi.model.ApplicationDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepository extends MongoRepository<ApplicationDocument, String> {

    List<ApplicationDocument> findByService(Boolean service);

    Optional<ApplicationDocument> findByName(String name);
}
