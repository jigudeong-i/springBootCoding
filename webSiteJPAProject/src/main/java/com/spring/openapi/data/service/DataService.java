package com.spring.openapi.data.service;

import com.spring.openapi.data.dto.AnimalDaejeonDTO;

public interface DataService {
    public String busanWalkingList();
    public String busanWalkingDetail(String seq);
    public String animalDaejeonList(AnimalDaejeonDTO animalDaejeonDTO);
<<<<<<< HEAD
=======
    public String animalDaejeonItem(AnimalDaejeonDTO animalDaejeonDTO);
>>>>>>> ba67dafdb5f72ce3388b19ca2bc89c64c9c85c94
}
