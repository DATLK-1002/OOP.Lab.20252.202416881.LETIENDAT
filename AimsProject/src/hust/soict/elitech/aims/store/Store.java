package hust.soict.elitech.aims.store;

import hust.soict.elitech.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("Media already exists in store!");
        } else {
            itemsInStore.add(media);
        }
    }

    public void removeMedia(Media media) {
        if (!itemsInStore.remove(media)) {
            System.out.println("Media not found in store!");
        }
    }

    public ArrayList<Media> getItemsInStore() { return itemsInStore; }

    public void print() {
        System.out.println("***********************STORE***********************");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
        }
        System.out.println("***************************************************");
    }
}
