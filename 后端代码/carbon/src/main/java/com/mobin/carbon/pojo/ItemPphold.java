package com.mobin.carbon.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPphold {
    private Integer id;
    private String itemName;
    private String headPerson;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private String introduction;
    private LocalDate createTime;
    private LocalDate updateTime;
}
