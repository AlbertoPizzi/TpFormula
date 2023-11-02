package edu.austral.ingsis.math.visitor.function;

import edu.austral.ingsis.math.visitor.Visitable;
import edu.austral.ingsis.math.visitor.Visitor;

public class Abs implements Visitable {
    private final Visitable abs;

    // |a|
    public Abs(Visitable a) {
        this.abs = a;
    }

    public Visitable getAbs() {
        return abs;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
