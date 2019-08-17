package com.tutorialspoint;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FriendsController {

    @RequestMapping(value = "/friends.html", method = RequestMethod.GET)
    public String showFriendsList() {
        return "friendsListView";
    }

    @RequestMapping(value = "/friends/potential-friends.html", method = RequestMethod.GET)
    public String showPotentialFriends() {
        return "potentialFriendsView";
    }

}
