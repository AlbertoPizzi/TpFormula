package edu.austral.ingsis.math.composite.function;

import edu.austral.ingsis.math.composite.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pow implements Function {
    private final Function a;
    private final Function b;

    // a ^ b
    public Pow(Function a, Function b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double evaluate(Map<String, Double> map) {
        return Math.pow(a.evaluate(map), b.evaluate(map));
    }

    @Override
    public String toString() {
        return a.toString() + " ^ " + b.toString();
    }

    @Override
    public List<String> getChildren(List<String> list) {
        List<String> copy = new ArrayList<>(list);
        copy.addAll(a.getChildren(copy));
        copy.addAll(b.getChildren(copy));
        return copy;
    }

    @Override
    public List<String> listVariables(List<String> list) {
        return Stream.concat(a.listVariables(list).stream(), b.listVariables(list).stream()).collect(Collectors.toList());
    }
}
