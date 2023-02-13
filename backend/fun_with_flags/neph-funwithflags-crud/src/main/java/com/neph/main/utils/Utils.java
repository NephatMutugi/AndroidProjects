package com.neph.main.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

/**
 * @ Author NMuchiri
 **/
@Service
public class Utils {
    public static String objectToJson(Object entity) {
        try {
            return new ObjectMapper().writeValueAsString(entity);
        } catch (JsonProcessingException ex) {
            return ex.getMessage();
        }

    }
}
