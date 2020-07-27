package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class VersionTask {

    public static void main(String[] args) {
        List<String> sortedVersionList = VersionTask.sortVersion(new String[]{
                "2.4.31", "1.2.3", "1.2.4", "1.2.30", "1.2.31"
        });

        for (String str:sortedVersionList){
            System.out.println(str);
        }
    }

    public static List<String> sortVersion(String[] strings) {

        return Stream.of(strings)
                .map(versionString -> Stream.of(versionString.split("\\."))
                        .mapToInt(Integer::parseInt)
                        .toArray()
                )
                .sorted(Arrays::compare)
                .map(versionInts -> IntStream.of(versionInts)
                        .mapToObj(Integer::toString)
                        .collect(Collectors.joining("."))
                )
                .collect(Collectors.toList());
    }

}
