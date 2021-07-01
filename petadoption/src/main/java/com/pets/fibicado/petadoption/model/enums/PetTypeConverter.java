package com.pets.fibicado.petadoption.model.enums;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.Optional;

@Converter
public class PetTypeConverter implements AttributeConverter<PetType,String> {
    @Override
    public String convertToDatabaseColumn(PetType petType) {
        if(petType == null){
            return null;
        }
        return petType.toString();
    }

    @Override
    public PetType convertToEntityAttribute(String petType) {
        if(petType == null){
            return PetType.UNKNOWN;
        }
        Optional<PetType> petTypeToReturn = Arrays.stream(PetType.values()).filter(petType1-> petType1.toString().equalsIgnoreCase(petType)).findAny();
        return petTypeToReturn.orElse(PetType.UNKNOWN);
    }
}
