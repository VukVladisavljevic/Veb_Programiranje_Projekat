package com.vp_projekat.services;

import com.vp_projekat.beans.ProgrammingLanguages;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Lupus on 8/16/2017.
 */

@Service
public class LanguageServiceImpl implements LanguageService {
    @Override
    public Boolean addLanguage(String language) {
        Boolean exists = ProgrammingLanguages.getLanguage(language);
        if(!exists)
        {
            ProgrammingLanguages.addLanguage(language);
            return exists;
        }
        return null;
    }

    @Override
    public ArrayList<String> getAll() {

        return ProgrammingLanguages.getLanguages();
    }
}
