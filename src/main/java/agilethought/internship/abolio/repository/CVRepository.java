package agilethought.internship.abolio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import agilethought.internship.abolio.model.CV;

@Repository
public interface CVRepository extends MongoRepository<CV, String> {
}