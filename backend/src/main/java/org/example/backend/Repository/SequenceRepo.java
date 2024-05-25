package org.example.backend.Repository;

import org.example.backend.Entities.DatabaseSequence;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SequenceRepo extends MongoRepository<DatabaseSequence, String> {
}
