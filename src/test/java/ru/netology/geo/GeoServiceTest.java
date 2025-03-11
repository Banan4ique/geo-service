package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import ru.netology.entity.Location;

import java.util.Map;


public class GeoServiceTest {

    @DisplayName("Проверка определения локации")
    @ParameterizedTest
    @MethodSource("ru.netology.helpers.DataProvider#argsProvider")
    public void test_location_by_ip(Map<String, Location> map) {
        GeoService geoService = Mockito.spy(GeoServiceImpl.class);

        String ip = map.keySet().stream().toList().getFirst();
        Location location = map.values().stream().toList().getFirst();

        Assertions.assertEquals(location.getCountry(), geoService.byIp(ip).getCountry());
    }

    @DisplayName("Проверка определения локации с неизвестным ip")
    @Test
    public void test_location_by_incorrect_ip() {
        GeoService geoService = Mockito.spy(GeoServiceImpl.class);

        String ip = "100.0.0.1";

        Assertions.assertNull(geoService.byIp(ip));
    }
}
