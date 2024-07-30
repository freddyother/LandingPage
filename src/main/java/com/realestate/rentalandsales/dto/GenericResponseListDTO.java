package com.realestate.rentalandsales.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponseListDTO<T> {

    private  Boolean success;

    private String message;

    private List<T> data;

    public GenericResponseListDTO(Boolean successIn, String messageIn){

        this.success = successIn;

        this.message = messageIn;

        this.data = new ArrayList<>();
    }

    public void addData(T item){

        if (this.data == null) this.data = new ArrayList<>();

        this.data.add(item);
    }

    public void addData(List<T> itemList){

        if (this.data == null) this.data = new ArrayList<>();

        this.data.addAll(itemList);
    }
}
