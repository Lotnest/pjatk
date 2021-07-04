package exercise.ex04.ex01.impl;

import exercise.ex04.ex01.IFish;

import java.util.ArrayList;
import java.util.Collections;

public class Guppy implements IFish {

    private final ArrayList<String> skills = new ArrayList<>(Collections.singletonList(swim()));

    public ArrayList<String> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "Guppy{" +
                "skills='" + skills + '\'' +
                '}';
    }
}
