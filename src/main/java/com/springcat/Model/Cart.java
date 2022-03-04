package com.springcat.Model;

import lombok.Data;

import java.util.List;

@Data
public class Cart {
    // cat id
    private final List<String> selectedCats;
}
