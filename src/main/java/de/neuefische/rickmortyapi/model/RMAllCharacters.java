package de.neuefische.rickmortyapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RMAllCharacters {


    private List<RMCharacter> results;
}
