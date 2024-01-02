package com.Ecommerces.TcFootwears.controller;

import com.Ecommerces.TcFootwears.dto.TcFootwearDto;
import com.Ecommerces.TcFootwears.model.TcFootwear;
import com.Ecommerces.TcFootwears.service.OrderService;
import com.Ecommerces.TcFootwears.service.TcFootwearService;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.Ecommerces.TcFootwears.service.TcFootwearService.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/TcFootwear")

public class TcFootwearController {
    private final TcFootwearService tcFootwearService;

    @PostMapping
    public <TcFootwearRequestDto> ResponseEntity createTcFootwear(@RequestBody TcFootwearRequestDto tcFootwearRequestDto) {
        TcFootwearService createdTcFootwear = getAllTcFootwear (TcFootwearRequestDto);
        return new RequestEntity<>(TcFootwearService, HttpStatus.CREATED);
    }

    @GetMapping("/api")
    public ResponseEntity<List<TcFootwear>> getAllTcFootwear() {
        List TcFootwear = TcFootwearService.getAllTcFootwear();
        return new ResponseEntity<>(TcFootwear, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<TcFootwear> updateTcFootwear(@RequestBody TcFootwearDto tcFootwearDto, @PathVariable Long id){
        TcFootwear updatedTcFootwear = TcFootwearService.getAllTcFootwear(tcFootwearService, Id);
        return new ResponseEntity<>(updatedTcFootwear, HttpStatus.OK);

    }

    @DeleteMapping("/{id")
    public ResponseEntity<TcFootwear> deleteTcFootwear(@PathVariable Long id){
        TcFootwear deletedTcFootwear = TcFootwearService.deleteTcFootwear(id);
        return new ResponseEntity<>(deletedTcFootwear, HttpStatus.OK);
    }


}
