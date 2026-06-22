import java.util.*;
import java.util.stream.*;
public class Main {
    private static final String MR = "HeapInspector_8a19ad";
    record Entry(String key, int count) {}
    public static void main(String[] args) { var entries = List.of(new Entry("a",3),new Entry("b",7),new Entry("a",5),new Entry("c",2),new Entry("b",1),new Entry("c",8)); var reduced = entries.stream().collect(Collectors.groupingBy(Entry::key, Collectors.summingInt(Entry::count))); var sorted = reduced.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().reversed()).toList(); System.out.printf("[%s] Aggregated: %s%n", MR, reduced); sorted.forEach(e -> System.out.printf("[%s]   %s = %d%n", MR, e.getKey(), e.getValue())); }
}
