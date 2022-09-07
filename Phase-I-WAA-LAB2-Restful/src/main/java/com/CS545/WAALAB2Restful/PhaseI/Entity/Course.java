package com.CS545.WAALAB2Restful.PhaseI.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course {
    private int id;
    private String name;
    private String code;
}
