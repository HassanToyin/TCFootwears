package com.Ecommerces.TcFootwears.service;

import com.Ecommerces.TcFootwears.dto.TcFootwearDto;
import com.Ecommerces.TcFootwears.model.TcFootwear;
import com.Ecommerces.TcFootwears.repository.TcFootwearRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor

public class TcFootwearService {
    private static TcFootwearRepo tcFootwearRepo;

    public TcFootwear createTcFootwear(TcFootwearDto tcFootwearDto) {
        TcFootwear tcFootwear = new TcFootwear();

        tcFootwear.setName(tcFootwearDto.getName());
        tcFootwear.setDescription(tcFootwearDto.getDescription());
        tcFootwear.setPrice(String.valueOf(tcFootwearDto.getPrice()));
        tcFootwear.setStockQuantity(String.valueOf(tcFootwearDto.getStockQuantity()));

        return tcFootwearRepo.save(tcFootwear);
    }

    public TcFootwear getTcFootwearById(Long id) {
        return tcFootwearRepo.findById(id).orElseThrow( () -> new RuntimeException("TcFootwear not found"));
    }

    public ArrayList<TcFootwear> getAllTcFootwear(){
        return (ArrayList<TcFootwear>) tcFootwearRepo.findAll();
    }

    public TcFootwear updateTcFootwear(TcFootwearDto tcFootwearDto, Long id){
        TcFootwear tcFootwear = tcFootwearRepo.findById(id).orElseThrow(() -> new RuntimeException("TcFootwear not found"));

        tcFootwear.setName(tcFootwearDto.getName());
        tcFootwear.setDescription(tcFootwearDto.getDescription());
        tcFootwear.setPrice(String.valueOf(tcFootwearDto.getPrice()));
        tcFootwear.setStockQuantity(tcFootwearDto.setStockQuantity());

        return tcFootwearRepo.save(tcFootwear);
    }

    public static TcFootwear deleteTcFootwear(Long id) {
        TcFootwear tcFootwear = tcFootwearRepo.findById(id).get();
        tcFootwearRepo.deleteById(id);
        return tcFootwear;
    }


}
