package se.radley.domain;

import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@PrimaryKeyClass
public class MessageSentKey implements Serializable {

    @PrimaryKeyColumn(name = "from_user", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String fromUserId;

    @PrimaryKeyColumn(name = "to_user", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String toUserId;

    @PrimaryKeyColumn(name = "sent_at", ordinal = 2, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private Date messageTime;

    @PrimaryKeyColumn(name = "delivered", ordinal = 3, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private boolean delivered;

    public MessageSentKey() {}

    public MessageSentKey(String fromUserId, String toUserId, Date messageTime) {
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.messageTime = messageTime;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public Date getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageSentKey that = (MessageSentKey) o;
        return delivered == that.delivered &&
                Objects.equals(fromUserId, that.fromUserId) &&
                Objects.equals(toUserId, that.toUserId) &&
                Objects.equals(messageTime, that.messageTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromUserId, toUserId, messageTime, delivered);
    }
}
