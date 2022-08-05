package topFrequentCharactors;

import java.lang.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args){


        System.out.println( "ababbbsasfasd".chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList())
                .stream().collect(Collectors.
                        groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted((x, y) ->
                        y.getValue().equals(x.getValue()) ?
                                y.getKey().compareTo(x.getKey()) :
                                y.getValue().compareTo(x.getValue()))
                .map(characterLongEntry ->
                        Collections.nCopies(characterLongEntry.getValue().intValue(),
                                characterLongEntry.getKey()))
                .flatMap(List::stream)
                .collect(Collectors.toList()));

    }
}
