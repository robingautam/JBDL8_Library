package org.gfg.JBDL8_DigitalLibrary.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private int bookId;
    private String description;
    private String bookName;
    private double price;
    private String publisher;
    private Author author;
    private BookType bookType;

}
