package exercise.ex01;

public class Hero {

    private String name;
    private Integer healthPoints;

    public Hero(String name, Integer healthPoints) {
        this.name = name;
        this.healthPoints = healthPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(Integer healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void sayHelloTo(Hero hero) {
        System.out.println(this + " says hello to " + hero);
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", healthPoints=" + healthPoints +
                '}';
    }
}
