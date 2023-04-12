public class Dog implements Animal, Speakable {

    @Override
    public void eat() {
        System.out.println("간식 먹기");
    }

    @Override
    public void speck() {
        System.out.println("멍멍");
    }
}
