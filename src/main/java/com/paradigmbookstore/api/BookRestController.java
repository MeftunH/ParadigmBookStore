package com.paradigmbookstore.api;

import com.amazonaws.services.dynamodbv2.xspec.B;
import com.paradigmbookstore.dto.BookListResponse;
import com.paradigmbookstore.dto.BookResponse;
import com.paradigmbookstore.dto.CategoryType;
import com.paradigmbookstore.model.BookStatus;
import com.paradigmbookstore.request.book.SaveBookRequest;
import com.paradigmbookstore.service.BookListService;
import com.paradigmbookstore.service.BookSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/book")
@RestController
@RequiredArgsConstructor
public class BookRestController {
    private final BookListService bookListService;
    private final BookSaveService bookSaveService;

    @PostMapping(name = "/save")
    public ResponseEntity<BookListResponse> saveBook(@RequestBody SaveBookRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bookSaveService.saveBook(request));
    }

    @GetMapping("/search")
    public ResponseEntity<List<BookResponse>> listBooks(@RequestParam(name="size",value = "5")int size, @RequestParam(name = "page",value="1")int page){
     return ResponseEntity.ok(bookListService.listBooks(size,page));
    }

    @GetMapping("/list/{categoryType}")
    public ResponseEntity<List<BookResponse>> listByCategory(@PathVariable CategoryType categoryType){
        return ResponseEntity.ok(this.bookListService.searchByCategory(categoryType));
    }

    @GetMapping("/list/{title}")
    public ResponseEntity<List<BookResponse>> listByCategory(@PathVariable String title){
        return ResponseEntity.ok(this.bookListService.findByTitle(title));
    }

    @GetMapping("/list/{bookStatus}")
    public ResponseEntity<List<BookResponse>> listByStatus(@PathVariable BookStatus bookStatus){
        return ResponseEntity.ok(this.bookListService.searchByBookStatus(bookStatus));
    }


}
