package com.theironyard;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by Jake on 5/8/17.
 */

@RestController
public class MicroblogJSONController {
    //.json URL
    //not storing model anymore because we hae no view anymore.
    @RequestMapping(path = "/add-message.json", method = RequestMethod.POST)
    public ArrayList<Message> jsonAdd(@RequestBody Message messageText) {
        MicroBlogSpringController.messages.add(messageText);
        return MicroBlogSpringController.messages;
    }
    @RequestMapping(path = "/remove-message.json", method = RequestMethod.POST)
    public ArrayList<Message> jsonRemove(@RequestBody Message id) {
        for (Message allMessage: MicroBlogSpringController.messages) {
            if (allMessage.id == id.id) {
                Message a = allMessage;
                MicroBlogSpringController.messages.remove(a);
                break;
            }
        }

        return MicroBlogSpringController.messages;
    }
    @RequestMapping(path = "/get-messages.json", method = RequestMethod.GET)
    public ArrayList<Message> jsonReturn(Message messageText) {
        return MicroBlogSpringController.messages;
    }

}
