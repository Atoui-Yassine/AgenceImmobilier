package com.example.AgenceImmobilier.models.logement;

import com.example.AgenceImmobilier.models.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "logement")
public class Logement extends BaseEntity {
    private  String title;
    private  String description;
    private  Integer square_meters;
    private  double overneight_price;
    private  double price_of_person;
    private  Integer max_people;
    private  Integer min_overneights;
    private  Integer beds;
    private  Integer bathrooms;
    private  Integer bedrooms;
    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private TypeLogement type;



}
