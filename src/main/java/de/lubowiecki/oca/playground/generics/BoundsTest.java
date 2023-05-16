package de.lubowiecki.oca.playground.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BoundsTest {

    public static void main(String[] args) {

        List<Mensch> mList = new ArrayList<>(); // new ArrayList<Mensch>()
        mList.add(new Mensch());
        mList.add(new Student()); // CoVarianz

        List<?> wList = new ArrayList<>(); // new ArrayList<Object>()
        //wList.add(new Mensch()); // Erweitern nicht möglich
        //wList.add(new Student());
        wList = new ArrayList<Mensch>();
        wList = new ArrayList<Student>();

        //Student s = wList.get(0);
        Object o = wList.get(0);

        // UpperBound (Mensch und seine Kindklassen)
        List<? extends Mensch> mList2 = new ArrayList<>(); // new ArrayList<Mensch>()
        mList2 = new ArrayList<Student>(); // Student extends Mensch
        mList2 = new ArrayList<JuraStudent>(); // JuraStudent extends Student extends Mensch

        // LowerBound (Student und seine Elternklassen)
        List<? super Student> mList3 = new ArrayList<>();
        mList3 = new ArrayList<Student>();
        mList3 = new ArrayList<Mensch>();
        mList3 = new ArrayList<Object>();

        mList3.add(new Student()); // Bei super ist die Liste erweiterbar
        //mList3.add(new Mensch()); // Error

        Predicate<String> pred1 = (s) -> s.length() > 0;
        Predicate<Object> pred2 = (obj) -> obj.hashCode() > 0;
        pred1 = pred1.and(pred2);

    }
}

class Mensch {

}

class Student extends Mensch {

}

class JuraStudent extends Student {

}

class InformatikStudent extends Student {

}
