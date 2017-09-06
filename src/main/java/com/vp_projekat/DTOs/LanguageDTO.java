package com.vp_projekat.DTOs;

import com.vp_projekat.services.LanguageService;

/**
 * Created by Lupus on 9/5/2017.
 */
public class LanguageDTO {

    private String languageName;

    public String getLanguageName() {
        return languageName;
    }

    public  void setLanguageName(String languageName){
        this.languageName = languageName;
    }

    public LanguageDTO() {}

    public LanguageDTO(String languageName){
        super();
        this.languageName = languageName;
    }
}
