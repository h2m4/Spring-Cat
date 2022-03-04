package com.springcat.Model;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Cat {
    private final Long id;
    private final String name;
    private final String gender;
    private final boolean longHaired;
    private final boolean roundFace;
    private final boolean lively;
    private final String picPath;
    private final String thPicPath;
}
