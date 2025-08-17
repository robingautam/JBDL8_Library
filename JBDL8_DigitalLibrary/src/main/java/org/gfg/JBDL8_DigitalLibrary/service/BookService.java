package org.gfg.JBDL8_DigitalLibrary.service;

import org.gfg.JBDL8_DigitalLibrary.model.Author;
import org.gfg.JBDL8_DigitalLibrary.model.Book;
import org.gfg.JBDL8_DigitalLibrary.repository.AuthorRepository;
import org.gfg.JBDL8_DigitalLibrary.repository.BookRepository;
import org.gfg.JBDL8_DigitalLibrary.request.BookCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public Book createBookInDatabase(BookCreationRequest bookCreationRequest){

        Book book = Book.builder().bookId(bookCreationRequest.getBookId()).bookName(bookCreationRequest.getBookName())
                .price(bookCreationRequest.getBookPrice()).bookType(bookCreationRequest.getBookType())
                .publisher(bookCreationRequest.getPublisher()).description(bookCreationRequest.getDescription()).build();


        Author author = Author.builder().name(bookCreationRequest.getAuthorName()).email(bookCreationRequest.getAuthorEmail())
                .mobileNo(bookCreationRequest.getAuthorMobile()).build();

        int bookUpdated = 0;
        boolean authorExists = false;
        try {
            // Create Author if Not Exists
              Author dbAuthor =  authorRepository.checkAuthor(author.getEmail(),author.getMobileNo());
              if (dbAuthor==null || dbAuthor.getName()==null || dbAuthor.getName().isEmpty()){
                  // author does not exists, we need to create the author

              int rows =  authorRepository.createAuthor(author);
          }

        //
            authorExists = true;
        }
        catch (Exception e){
            System.out.println(e);
            System.out.println("Going to create the author");
            authorExists = false;
        }

        try {
            if (!authorExists){
                int rows =  authorRepository.createAuthor(author);
            }

            bookUpdated = bookRepository.createBookInDatabase(book);
        }
        catch (Exception e){
            System.out.println(e);
        }

        if (bookUpdated==0){
            return null;
        }
        return book;
    }
}
