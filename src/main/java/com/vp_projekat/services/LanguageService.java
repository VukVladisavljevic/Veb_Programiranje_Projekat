package com.vp_projekat.services;

import com.vp_projekat.beans.ProgrammingLanguages;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Lupus on 8/16/2017.
 */

@Service
public interface LanguageService {

    Boolean addLanguage(String language);

    ArrayList<String> getAll();
}
