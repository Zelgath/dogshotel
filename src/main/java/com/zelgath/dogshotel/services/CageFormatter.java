package com.zelgath.dogshotel.services;

import com.zelgath.dogshotel.domain.Cage;
import com.zelgath.dogshotel.domain.repositories.CageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;

@Service
public class CageFormatter implements Formatter<Cage> {

    @Autowired
    CageRepository cageRepository;

    @Override
    public Cage parse(String idTxt, Locale locale) throws ParseException {
        Integer id = Integer.parseInt(idTxt);
       return cageRepository.getCage(id);

    }

    @Override
    public String print(Cage object, Locale locale) {
        return object.toString();
    }
}
