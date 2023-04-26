package dependency_inversion_principle;

/*
- High-level modules should not depend on low-level modules
- Both should depend on abstractions.

- Abstractions should not depend on details.
- Details should depend on abstractions.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class Triplet<U, V, W> {
    public final U value0;
    public final V value1;
    public final W value2;

    public Triplet(U value0, V value1, W value2) {
        this.value0 = value0;
        this.value1 = value1;
        this.value2 = value2;
    }

    public U getValue0() {
        return value0;
    }

    public V getValue1() {
        return value1;
    }

    public W getValue2() {
        return value2;
    }
}

enum Relationship {
    PARENT,
    CHILD,
    SIBLING
}

class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }
}

interface RelationshipBrowser {
    List<Person> findAllChildrenOf(String name);
}

class Relationships implements RelationshipBrowser{ //low-level module - no business logic - just details and how to manipulate them.

    private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();

    public List<Triplet<Person, Relationship, Person>> getRelations() {
        return relations;
    }

    public void addParentAndChild(Person parent, Person child) {
        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }

    @Override //correct implementation
    public List<Person> findAllChildrenOf(String name) {
        return relations.stream()
                .filter(x -> Objects.equals(x.getValue0().name, name)
                && x.getValue1() == Relationship.PARENT)
                .map(Triplet::getValue2)
                .collect(Collectors.toList());
    }
}

class Research { //high-level module - allows us to perform operations on the low level constructs. (higher to the end user)
//    public Research(Relationships relationships) { >>>> here is a violation of the DIP.
//        List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
//        relations.stream()
//                .filter(x -> x.getValue0().name.equals("John")
//                && x.getValue1() == Relationship.PARENT)
//                .forEach(ch -> System.out.println(
//                        "John has a child called " + ch.getValue2().name
//                ));
//
//    }
//
    public Research(RelationshipBrowser browser) {
        List<Person> children = browser.findAllChildrenOf("John");
        for (Person child : children)
            System.out.println("John has a child called " + child.name);
    }
}

class Demo {
    public static void main(String[] args) {
        Person parent = new Person("John");
        Person child1 = new Person("Chris");
        Person child2 = new Person("Matt");

        Relationships relationships = new Relationships();
        relationships.addParentAndChild(parent, child1);
        relationships.addParentAndChild(parent, child2);

        new Research(relationships);
    }
}