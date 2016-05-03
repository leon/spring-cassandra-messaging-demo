package se.radley.domain;

import org.springframework.data.cassandra.repository.TypedIdCassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface MessageRecievedRepository extends TypedIdCassandraRepository<MessageRecieved, MessageRecievedKey> {

    //List<MessageRecieved> findAllByPkFromUserId(String userId);

}
