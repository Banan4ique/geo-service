package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderTest {

    @DisplayName("Отправка сообщения с российским ip")
    @ParameterizedTest
    @ValueSource(strings = { GeoServiceImpl.MOSCOW_IP, "172.0.0.1" })
    public void test_send_russian_text(String ip) {
        GeoService geoService = Mockito.spy(GeoServiceImpl.class);

        LocalizationService localizationService = Mockito.spy(LocalizationServiceImpl.class);

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);

        Assertions.assertEquals("Добро пожаловать", messageSender.send(headers));
    }

    @DisplayName("Отправка сообщения с иностранным ip")
    @ParameterizedTest
    @ValueSource(strings = { GeoServiceImpl.NEW_YORK_IP, "96.0.0.1" })
    public void test_send_english_text(String ip) {
        GeoService geoService = Mockito.spy(GeoServiceImpl.class);

        LocalizationService localizationService = Mockito.spy(LocalizationServiceImpl.class);

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);

        Assertions.assertEquals("Welcome", messageSender.send(headers));
    }
}
