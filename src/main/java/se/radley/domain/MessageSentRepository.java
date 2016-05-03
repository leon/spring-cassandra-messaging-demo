package se.radley.domain;

import org.springframework.data.cassandra.repository.TypedIdCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
interface MessageSentRepository extends TypedIdCassandraRepository<MessageSent, MessageSentKey> {
}
