package com.amadeus.flightsearch.entitys;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@ApiModel(value = "Airport Classim", description = "Havayoluna ait bilgiler")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@ApiModelProperty(value = "Havaalanına ait tekil id")
    private Long id;
    //@ApiModelProperty(value = "Havaalanına ait şehir kodu")
    private String code;
    //@ApiModelProperty(value = "Havaalanına ait şehir")
    private String city;

    public Airport(String code, String city) {
        this.code = code;
        this.city = city;
    }
}

