package com.neph.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ Author NMuchiri
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePayload {
    private String status;
    private String message;
}
