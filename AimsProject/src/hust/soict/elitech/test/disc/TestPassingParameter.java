package hust.soict.elitech.test.disc;

import hust.soict.elitech.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
    static void swap(DigitalVideoDisc o1, DigitalVideoDisc o2) {
        System.out.println("Inside swap (before): o1=" + o1.getTitle() + ", o2=" + o2.getTitle());
        DigitalVideoDisc tmp = o1;
        o1 = o2;
        o2 = tmp;
        System.out.println("Inside swap (after): o1=" + o1.getTitle() + ", o2=" + o2.getTitle());
    }

    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc starDVD = new DigitalVideoDisc("Star");
        System.out.println("Before swap: a=" + jungleDVD.getTitle() + ", b=" + starDVD.getTitle());
        swap(jungleDVD, starDVD);
        System.out.println("After swap: a=" + jungleDVD.getTitle() + ", b=" + starDVD.getTitle());
    }
}
