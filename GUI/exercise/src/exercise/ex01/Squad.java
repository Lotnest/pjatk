package exercise.ex01;

import java.util.ArrayList;

public class Squad {

    private String name;
    private Leader leader;
    private int maxHeroes = 2;
    private final ArrayList<Hero> heroes = new ArrayList<>();

    public Squad(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    public int getMaxHeroes() {
        return maxHeroes;
    }

    public void setMaxHeroes(int maxHeroes) {
        this.maxHeroes = maxHeroes;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void addHero(Hero hero) throws TooManyHeroesException {
        if (heroes.size() + 1 == maxHeroes) {
            throw new TooManyHeroesException("Too many heroes");
        }
        heroes.add(hero);
    }

    @Override
    public String toString() {
        return "Squad{" +
                "name='" + name + '\'' +
                ", leader=" + leader +
                ", maxHeroes=" + maxHeroes +
                ", heroes=" + heroes +
                '}';
    }
}
