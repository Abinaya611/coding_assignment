//package structural;

import java.util.ArrayList;
import java.util.List;

// Component
interface Graphic {
    void draw();
}

// Leaf
class Circle implements Graphic {
    private final String name;
    public Circle(String name) { this.name = name; }
    public void draw() { System.out.println("Drawing circle: " + name); }
}

// Composite
class CompositeGraphic implements Graphic {
    private final List<Graphic> children = new ArrayList<>();
    public void add(Graphic g) { children.add(g); }
    public void remove(Graphic g) { children.remove(g); }
    public void draw() {
        for (Graphic g : children) g.draw();
    }
}

public class CompositeDemo {
    public static void main(String[] args) {
        CompositeGraphic root = new CompositeGraphic();
        root.add(new Circle("A"));
        CompositeGraphic subgroup = new CompositeGraphic();
        subgroup.add(new Circle("B"));
        subgroup.add(new Circle("C"));
        root.add(subgroup);
        root.draw();
    }
}
