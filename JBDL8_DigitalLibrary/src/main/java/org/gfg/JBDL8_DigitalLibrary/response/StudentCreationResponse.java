package org.gfg.JBDL8_DigitalLibrary.response;

import lombok.Data;

@Data
public class StudentCreationResponse extends Response{

    private int id;
    private String name;
    private String email;
}
