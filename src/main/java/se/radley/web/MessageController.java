package se.radley.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.radley.domain.MessageRecieved;
import se.radley.domain.MessageService;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageService msgService;

    @RequestMapping("/{user}/inbox")
    public List<MessageRecieved> inbox(@PathVariable String user) {
        return msgService.inbox(user);
    }
}
