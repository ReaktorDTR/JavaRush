package com.javarush.test.level17.lesson10.home02;

/* Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach, который будет использоваться нитями.
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach obj) {
        int distanceParam = (int) (distance - obj.getDistance());
        int qualityParam = quality - obj.getQuality();
        return 10000 * name.compareTo(obj.getName()) + 100 * distanceParam + qualityParam;
    }

    public static void main(String[] args) {

        Beach beach1 = new Beach("beach1", 12.6f, 3);
        Beach beach2 = new Beach("beach2", 174.6f, 8);
        Beach beach3 = new Beach("beach3", 145.3f, 8);
        Beach beach4 = new Beach("beach3", 145.3f, 9);

        System.out.println("b1 -> b2 " + beach1.compareTo(beach2));
        System.out.println("b1 -> b3 " + beach1.compareTo(beach3));
        System.out.println("b2 -> b3 " + beach2.compareTo(beach3));
        System.out.println("b3 -> b4 " + beach3.compareTo(beach4));
    }
}
