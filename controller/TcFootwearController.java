package com.Ecommerces.TcFootwears.controller;

import com.Ecommerces.TcFootwears.dto.OrderRequestDto;
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
    public ResponseEntity<TcFootwear> createTcFootwear(@RequestBody TcFootwearDto tcFootwearDto) {
        TcFootwear createdTcFootwear = tcFootwearService.createTcFootwear(tcFootwearDto);
        return new ResponseEntity<>(createdTcFootwear, HttpStatus.CREATED);
    }

    @GetMapping("/api")
    public ResponseEntity<List<TcFootwear>> getAllTcFootwear() {
        List<TcFootwear> tcFootwears = tcFootwearService.getAllTcFootwear();
        return new ResponseEntity<>(tcFootwears, HttpStatus.OK);

    }

    @GetMapping("/api")
    public ResponseEntity<TcFootwear> getTcFootwearsById(@PathVariable Long id){
        TcFootwear tcFootwear = tcFootwearService.getTcFootwearById(id);
        return new ResponseEntity<>(tcFootwear, HttpStatus.OK) ;

    }


    @PutMapping("/{id}")
    public ResponseEntity<TcFootwear> updateTcFootwear(@RequestBody TcFootwearDto tcFootwearDto, @PathVariable Long id){
        TcFootwear updatedTcFootwear = tcFootwearService.updateTcFootwear(tcFootwearDto, id);
        return new ResponseEntity<>(updatedTcFootwear, HttpStatus.OK);

    }

    @DeleteMapping("/{id")
    public ResponseEntity<TcFootwear> deleteTcFootwear(@PathVariable Long id){
        TcFootwear deletedTcFootwear = TcFootwearService.deleteTcFootwear(id);
        return new ResponseEntity<>(deletedTcFootwear, HttpStatus.OK);
    }


}
