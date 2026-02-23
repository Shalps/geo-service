package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

class GeoServiceImplTest {
GeoService geoService;
    @BeforeEach
    void setUp() {
        geoService = new GeoServiceImpl();
    }

    @Test
    void checkingTheLocationByIP_Test() {

        Assertions.assertEquals(new Location("Moscow", Country.RUSSIA, "Lenina", 15).getCountry(),geoService.byIp("172.0.32.11").getCountry());
        Assertions.assertEquals(new Location("New York", Country.USA, " 10th Avenue", 32).getCity(),geoService.byIp("96.44.183.149").getCity());

    }


}