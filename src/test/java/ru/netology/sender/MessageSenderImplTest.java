package ru.netology.sender;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MessageSenderImplTest {
    Map<String, String> headers;

@BeforeEach
void setUp() {
    headers = new HashMap<String, String>();

}
    @Test
    void CheckingTextByIP_Test() {
         LocalizationService localizationService = Mockito.mock(LocalizationService.class);
         Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn( "Добро пожаловать");

         GeoService geoService = Mockito.mock(GeoService.class);
         Mockito.when(geoService.byIp(Mockito.startsWith("172."))).thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

         MessageSenderImpl messageSender = new MessageSenderImpl(geoService,localizationService);


        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");

        assertEquals("Добро пожаловать", messageSender.send(headers));

    }
    @Test
   void CheckingTextForAmericanIP_Test(){
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.USA)).thenReturn( "Welcome");

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(Mockito.startsWith("96."))).thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService,localizationService);


        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");

        assertEquals("Welcome", messageSender.send(headers));
   }
}