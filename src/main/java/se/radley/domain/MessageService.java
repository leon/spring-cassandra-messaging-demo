package se.radley.domain;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageSentRepository sentRepository;
    private final MessageRecievedRepository recievedRepository;
    private final CassandraOperations cas;

    @Autowired
    public MessageService(MessageSentRepository sentRepository, MessageRecievedRepository recievedRepository, CassandraOperations cas) {
        this.sentRepository = sentRepository;
        this.recievedRepository = recievedRepository;
        this.cas = cas;
    }

    //region Reads

    public List<MessageRecieved> inbox(String userId) {
        Select select = QueryBuilder.select().from("message_recieved");
        select.where(QueryBuilder.eq("to_user", userId));
        select.allowFiltering();
        return cas.select(select, MessageRecieved.class);
    }

    //endregion

    public MessageSent send(String from, String to, String content) {
        MessageSent sent = new MessageSent(from, to, content);
        sentRepository.save(sent);

        MessageRecieved recieved = new MessageRecieved(to, from, content);
        recievedRepository.save(recieved);

        return sent;
    }
}
