package exercise.ex04.ex01.impl;

import exercise.ex04.ex01.IBird;
import exercise.ex04.ex01.IFish;

import java.util.ArrayList;
import java.util.Arrays;

public class Duck implements IBird, IFish {

    private final ArrayList<String> skills = new ArrayList<>(Arrays.asList(fly(), swim()));

    public ArrayList<String> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "Duck{" +
                "skills=" + skills +
                '}';
    }
}
