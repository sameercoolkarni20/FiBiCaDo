package com.pets.fibicado.petadoption.model.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.Optional;

@Converter(autoApply = true)
public class BreedConverter implements AttributeConverter<Breed,String> {
    @Override
    public String convertToDatabaseColumn(Breed breed) {
        if(breed == null){
            return null;
        }
        return breed.toString();
    }

    @Override
    public Breed convertToEntityAttribute(String breed) {
        if(breed == null){
            return Breed.UNKNOWN;
        }
        Optional<Breed> breedToReturn = Arrays.stream(Breed.values()).filter(breed1-> breed1.toString().equalsIgnoreCase(breed)).findAny();
        return breedToReturn.orElse(Breed.UNKNOWN);

    }
}
