package de.neuefische.rickmortyapi.service;

import de.neuefische.rickmortyapi.model.RMAllCharacters;
import de.neuefische.rickmortyapi.model.RMCharacter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RMService {

    WebClient webClient = WebClient.create("https://rickandmortyapi.com/api/");
    public List<RMCharacter> getAllCharacterService() {
        RMAllCharacters response =
                        Objects.requireNonNull(webClient.get())
                        .uri("character")
                        .header(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE)
                        .retrieve()
                        .toEntity(RMAllCharacters.class)
                        .block()
                        .getBody();

        return response.getResults();




    }

    public List<RMCharacter> getAllCharacterStatus(String status) {
        RMAllCharacters response =
                Objects.requireNonNull(webClient.get())
                        .uri("character/?name=rick&status=" + status)
                        .header(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE)
                        .retrieve()
                        .toEntity(RMAllCharacters.class)
                        .block()
                        .getBody();

        return response.getResults();
    }
}
