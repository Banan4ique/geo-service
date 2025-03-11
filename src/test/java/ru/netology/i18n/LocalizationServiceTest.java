package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.Mockito;
import ru.netology.entity.Country;

public class LocalizationServiceTest {

    @DisplayName("Русская локализация")
    @ParameterizedTest
    @EnumSource(value = Country.class, names = {"RUSSIA"})
    public void test_locale_by_country_russia(Country country) {
        LocalizationService localizationService = Mockito.spy(LocalizationServiceImpl.class);

        String message = "Добро пожаловать";

        Assertions.assertEquals(message, localizationService.locale(country));
    }

    @DisplayName("Английская локализация")
    @ParameterizedTest
    @EnumSource(value = Country.class, names = {"GERMANY", "USA", "BRAZIL"})
    public void test_locale_by_country_others(Country country) {
        LocalizationService localizationService = Mockito.spy(LocalizationServiceImpl.class);

        String message = "Welcome";

        Assertions.assertEquals(message, localizationService.locale(country));
    }
}
