package stacksandqueues;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelter {
    private Queue<Dog> dogQueue = new LinkedList<Dog>();
    private Queue<Cat> catQueue = new LinkedList<Cat>();
    int time = 0;

    public void enqueue(Animal s){
        s.setTime(time);
        time++;
        if(s instanceof Dog) dogQueue.add((Dog) s);
        else if(s instanceof Cat) catQueue.add((Cat) s);
    }

    public Animal dequeueAny(){
        if(dogQueue==null)
            return catQueue.poll();
        else if(catQueue == null)
            return dogQueue.poll();
        Dog dog = dogQueue.peek();
        Cat cat = catQueue.peek();
        if(dog.isOlderThan(cat))
            return dequeueDog();
        else
            return dequeueCat();

    }

    public Dog dequeueDog(){
        return dogQueue.poll();
    }

    public Cat dequeueCat(){
        return catQueue.poll();
    }

    public static void main(String[] args) {
        Cat firstc = new Cat("firstc");
        Cat secondc = new Cat("secondc");
        Cat thirdc = new Cat("thirdc");
        Dog firstd = new Dog("firstd");
        Dog secondd = new Dog("secondd");
        Dog thirdd = new Dog("thirdd");
        AnimalShelter as = new AnimalShelter();
        as.enqueue(firstc);
        as.enqueue(firstd);
        as.enqueue(secondc);
        as.enqueue(secondd);
        as.enqueue(thirdc);
        as.enqueue(thirdd);
        Animal t = as.dequeueAny();
        System.out.println(t.getName());
        Dog d = as.dequeueDog();
        System.out.println(d.getName());
        Cat c = as.dequeueCat();
        System.out.println(c.getName());
    }
}

abstract class Animal{
    private int timestamp;
    private String name;
    public Animal(String s){
        name = s;
    }
    public String getName(){
        return name;
    }
    public void setTime(int time){
        timestamp = time;
    }
    public int getTime(){
        return timestamp;
    }
    public boolean isOlderThan(Animal a){
        return this.timestamp < a.timestamp;
    }
}

class Dog extends Animal{
    public Dog(String s){
        super(s);
    }
}

class Cat extends Animal{
    public Cat(String s){
        super(s);
    }
}
