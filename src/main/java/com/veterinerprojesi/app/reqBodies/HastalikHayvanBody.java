package com.veterinerprojesi.app.reqBodies;

import lombok.Data;

import java.util.List;

@Data
public class HastalikHayvanBody {
    Integer hayvanId;
    List<Integer> hastaliklar;

}
