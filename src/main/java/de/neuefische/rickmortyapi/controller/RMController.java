package de.neuefische.rickmortyapi.controller;


import de.neuefische.rickmortyapi.model.RMCharacter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import de.neuefische.rickmortyapi.service.RMService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class RMController {

    private final RMService rmService;

    @GetMapping ("/character")
    public List<RMCharacter> getAllCharacterController (){
        return rmService.getAllCharacterService();

    }

    @GetMapping ("/character/{status}")
    public List<RMCharacter> getAllCharacterStatus (@PathVariable String status){
        return rmService.getAllCharacterStatus(status);

    }

}
