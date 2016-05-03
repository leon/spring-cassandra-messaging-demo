package se.radley.domain;


import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.time.LocalDateTime;
import java.util.Date;

@Table(value = "message_sent")
public class MessageSent {

    @PrimaryKey
    private MessageSentKey pk;

    @Column
    private String content;

    public MessageSent() {
    }

    public MessageSent(String from, String to, String content) {
        this.pk = new MessageSentKey(from, to, new Date());
        this.content = content;
    }

    public MessageSentKey getPk() {
        return pk;
    }

    public void setPk(MessageSentKey pk) {
        this.pk = pk;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
