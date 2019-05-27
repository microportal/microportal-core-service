package br.org.microportal.core.controller;

import br.org.microportal.core.model.ApplicationDocument;
import br.org.microportal.core.service.ApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/applications")
public class ApplicationsController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    public List<ApplicationDocument> findAll() {
        log.debug("[GET] /applications");
        return applicationService.findAll();
    }

    @GetMapping("/services")
    public List<ApplicationDocument> findServices() {
        log.debug("[GET] /applications/services");
        return applicationService.findServices();
    }

    @GetMapping("/{applicationId}")
    public Optional<ApplicationDocument> findById(@PathVariable("applicationId") String applicationId) {
        log.debug("[GET] /applications/{}", applicationId);
        return applicationService.findById(applicationId);
    }

    @PostMapping
    public ApplicationDocument registerApplication(@RequestBody ApplicationDocument applicationDocument) {
        log.debug("[POST] /applications");
        return applicationService.save(applicationDocument);
    }

    @PutMapping("/{applicationId}")
    public ApplicationDocument updateApplication(@PathVariable("applicationId") String applicationId, @RequestBody ApplicationDocument applicationDocument) {
        log.debug("[PUT] /applications/{}", applicationId);
        return applicationService.save(applicationDocument);
    }

    @DeleteMapping("/{applicationId}")
    public void unregister(@PathVariable("applicationId") String applicationId) {
        log.debug("[DELETE] /applications/{}", applicationId);
        applicationService.unregister(applicationId);
    }
}
