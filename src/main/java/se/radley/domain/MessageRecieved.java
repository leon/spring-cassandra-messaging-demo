package se.radley.domain;


import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.time.LocalDateTime;
import java.util.Date;

@Table(value = "message_recieved")
public class MessageRecieved {

    @PrimaryKey
    private MessageRecievedKey pk;

    @Column
    private String content;

    public MessageRecieved() {
    }

    public MessageRecieved(String to, String from, String content) {
        this.pk = new MessageRecievedKey(to, from, new Date());
        this.content = content;
    }

    public MessageRecievedKey getPk() {
        return pk;
    }

    public void setPk(MessageRecievedKey pk) {
        this.pk = pk;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
