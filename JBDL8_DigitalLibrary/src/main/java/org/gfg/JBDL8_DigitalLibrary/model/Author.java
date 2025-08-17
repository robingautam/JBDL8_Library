package org.gfg.JBDL8_DigitalLibrary.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    private int id;
    private String name;
    private String email;
    private String mobileNo;
    List<Book> books;
}
