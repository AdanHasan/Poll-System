package com.PollSystemApplication.controller;

import com.PollSystemApplication.model.Poll;
import com.PollSystemApplication.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/poll")
public class PollController {

    @Autowired
   PollService pollService;


    @PostMapping(value = "/create")
    @CrossOrigin
    public Long createPoll(@RequestBody Poll poll) {
        return pollService.createPoll(poll);
    }




    @GetMapping(value = "/get/{pollId}")
    public Poll getPollById(@PathVariable Long  pollId) {
        return pollService.getPollById(pollId);

    }



    @DeleteMapping("/delete/{pollId}")
    private void deletePoll(@PathVariable("pollId") Long pollId) {
        pollService.deletePollById(pollId);
    }



    @PutMapping(value = "/update/{pollId}")
    public void updatePollById(@PathVariable Long pollId,
                               @RequestBody Poll poll) {
        pollService.updatePollById(pollId, poll);
    }



}

