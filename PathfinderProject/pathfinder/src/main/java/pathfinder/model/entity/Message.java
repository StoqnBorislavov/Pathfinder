package pathfinder.model.entity;

import pathfinder.model.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message extends BaseEntity {

    private LocalDateTime dateTime;
    private String textContent;
    private User author;
    private User recipient;

    public Message() {
    }

    @Column(nullable = false)
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Message setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    @Column(nullable = false, columnDefinition = "TEXT")
    public String getTextContent() {
        return textContent;
    }

    public Message setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }
    @ManyToOne
    public User getAuthor() {
        return author;
    }

    public Message setAuthor(User author) {
        this.author = author;
        return this;
    }
    @ManyToOne
    public User getRecipient() {
        return recipient;
    }

    public Message setRecipient(User recipient) {
        this.recipient = recipient;
        return this;
    }
}
