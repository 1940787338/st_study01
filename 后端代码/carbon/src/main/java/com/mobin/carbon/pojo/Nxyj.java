package com.mobin.carbon.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Nxyj {
    private Integer id;
    private String name;
    private String address;
    private String power;   //实时功率
    private String voltage; //实时电压
    private String status;
    private LocalDate date;
    private String notes;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
