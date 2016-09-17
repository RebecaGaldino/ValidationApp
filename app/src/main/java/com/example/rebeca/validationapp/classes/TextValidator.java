package com.example.rebeca.validationapp.classes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rebeca on 16/09/2016.
 */
public class TextValidator {
    private Pattern pattern;
    private Matcher matcher;

    private static final String NOME_PATTERN = "[A-Za-záàâãéèêíïóôõöúüçñÁÀÂÃÉÈÍÏÓÔÕÖÚÜÇÑ ]*";

    public TextValidator() {
        pattern = Pattern.compile(NOME_PATTERN);
    }

    public boolean nameValidation(String name){

        matcher = pattern.matcher(name);

        if(name.isEmpty()){
            return false;
        }

        if(!matcher.matches()){
            return false;
        }

        if(name.split(" ").length <= 1){
            return false;
        }

        return true;
    }


}
