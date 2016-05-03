package se.radley.mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.radley.domain.MessageService;

//@Component
public class MockConversation {

    @Autowired
    public MockConversation(MessageService msgService) {
        msgService.send("leon", "johan", "Hello World");
        msgService.send("johan", "leon", "Hello back");

        msgService.send("jimmy", "micke", "Are you there");
        msgService.send("jimmy", "micke", "Are you there");
    }
}
