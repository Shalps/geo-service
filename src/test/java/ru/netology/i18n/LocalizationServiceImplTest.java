package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

class LocalizationServiceImplTest {


    @Test
    void checkingTheReturnedText_Test() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        String locale = localizationService.locale(Country.RUSSIA);
        Assertions.assertEquals("Добро пожаловать",locale);

    }


}