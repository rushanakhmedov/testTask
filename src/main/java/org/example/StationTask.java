package org.example;

import java.util.*;

public class StationTask {

    private static List<Station> STATION_LIST = Arrays.asList(
            new Station("МОСКВА"),
            new Station("МОЖГА"),
            new Station("МОЗДОК"),
            new Station("САНКТ-ПЕТЕРБУРГ"),
            new Station("САМАРА"));

    private Map<String, List<Station>> stationMap = new HashMap<>();

    public static void main(String[] args) {
        StationTask task = new StationTask(STATION_LIST);
        System.out.println(task.getStationsByTwoFirstLetters("МО"));
        System.out.println(task.getStationsByTwoFirstLetters("СА"));
    }

    private StationTask(List<Station> stationList) {
        // TODO
        for (Station station : stationList) {
            String stationName = station.getName();
            String twoFirstLetters = stationName.substring(0, 2);
            if (stationMap.containsKey(twoFirstLetters)) {
                List<Station> stationsListFromMap = stationMap.get(twoFirstLetters);
                stationsListFromMap.add(station);
            } else {
                List<Station> stationsListFromMap = new ArrayList<>();
                stationsListFromMap.add(station);
                stationMap.put(twoFirstLetters, stationsListFromMap);
            }
        }
        System.out.println("test");
    }

    private Collection<Station> getStationsByTwoFirstLetters(String prefix) {
        if (!stationMap.containsKey(prefix)) return null;
        return stationMap.get(prefix);
    }

    private static class Station {

        private String name;

        public Station(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return getName();
        }
    }
}


