package exercise.ex04.ex01.impl;

import exercise.ex04.ex01.IBird;
import exercise.ex04.ex01.IFish;
import exercise.ex04.ex01.IRunner;

import java.util.ArrayList;
import java.util.Arrays;

public class Human implements IBird, IFish, IRunner {

    private final ArrayList<String> skills = new ArrayList<>(Arrays.asList(fly(), swim(), run()));

    public ArrayList<String> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "Human{" +
                "skills=" + skills +
                '}';
    }
}