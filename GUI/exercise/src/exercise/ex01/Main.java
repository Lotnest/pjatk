package exercise.ex01;

public class Main {

    public static void main(String[] args) {
        Hero hero = new Hero("Jan", 50);
        Leader leader = new Leader("Eagle", 20);
        hero.sayHelloTo(leader);
        leader.sayHelloTo(hero);
        Squad squad = new Squad("DELTA");
        squad.setLeader(leader);
        try {
            squad.addHero(hero);
        } catch (TooManyHeroesException e) {
            e.printStackTrace();
        }
        System.out.println(squad);
    }
}