package ru.netology.helpers;

import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

import java.util.Map;
import java.util.stream.Stream;

public class DataProvider {

    static Stream<Map<String, Location>> argsProvider() {
        return Stream.of(Map.of(GeoServiceImpl.LOCALHOST, new Location(null, null, null, 0)),
                Map.of(GeoServiceImpl.MOSCOW_IP, new Location("Moscow", Country.RUSSIA, "Lenina", 15)),
                Map.of(GeoServiceImpl.NEW_YORK_IP, new Location("New York", Country.USA, " 10th Avenue", 32)),
                Map.of("172.0.0.1", new Location("Moscow", Country.RUSSIA, null, 0)),
                Map.of("96.0.0.1", new Location("New York", Country.USA, null,  0)));
    }
}
