package org.gfg.JBDL8_DigitalLibrary.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.gfg.JBDL8_DigitalLibrary.model.BookType;

@Data
@ToString
@Builder
public class BookCreationRequest {

    @NotNull
    private int bookId;
    @NotNull
    private String bookName;
    @NotNull
    private String description;
    @NotNull
    private String authorName;
    @NotNull
    private BookType bookType;
    @NotNull
    private double bookPrice;
    @NotNull
    private String publisher;
    @NotNull
    private String authorEmail;
    @NotNull
    private String authorMobile;


}
