package com.javaguides.springboot.note;

import com.javaguides.springboot.entity.NoteTable;
import com.javaguides.springboot.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping("/api/notes")
    public String createNote(@RequestBody NoteTable note)
    {

//        return noteService.savetoDb(note);
        return "Hii Post Request";

    }
}
package com.atherenergy.dvp.dto;

import com.atherenergy.dvp.dto.screens.repoDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component

public class dvpRepoDto {

    @JsonProperty("dashboard")
    static List<repoDto> repoDetail;


    public dvpRepoDto() {
        List<repoDto> repoDetails = new ArrayList<>();
        repoDetails.add(new repoDto("dvp_001", "trialDVP", "gen3", " ", "24-02-2024", "approved", "Tarun", "Nataraj"));
        repoDetails.add(new repoDto("dvp_002", "testDVP", "gen3", " ", "29-02-2024", "updated", "Tarun", "Nataraj"));
        this.repoDetail = repoDetails;


    }


    //static repoDto repo=new repoDto("dvp_001","trialDVP","gen3"," ","24-02-2024","approved","Tarun","Nataraj");
    public static repoDto getDvpById(String dvpId) {
        for (repoDto dvpTest : repoDetail) {
            if (dvpTest.getDvpId().equals(dvpId)) {
                return dvpTest;
            }
        }
        return null;
    }
}

