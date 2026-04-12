import java.util.ArrayList;

public class Cart {
    private int qtyOrdered;
    private ArrayList<DigitalVideoDisc> items;

    public Cart() {
        this.qtyOrdered = 0;
        this.items = new ArrayList<DigitalVideoDisc>();
    }

    // Thêm DVD vào giỏ
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (disc != null && this.qtyOrdered < 20) {
            this.items.add(disc);
            this.qtyOrdered++;
            System.out.println("Đã thêm: " + disc.getTitle());
        } else if (this.qtyOrdered >= 20) {
            System.out.println("Giỏ đã đầy!");
        }
    }

    // Xóa DVD khỏi giỏ
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (this.items.remove(disc)) {
            this.qtyOrdered--;
            System.out.println("Đã xóa: " + disc.getTitle());
        } else {
            System.out.println("DVD không có trong giỏ!");
        }
    }

    // Tính tổng tiền
    public float getTotalCost() {
        float total = 0.0f;
        for (DigitalVideoDisc disc : this.items) {
            total += disc.getCost();
        }
        return total;
    }

    public int getQtyOrdered() {
        return this.qtyOrdered;
    }

    public ArrayList<DigitalVideoDisc> getItems() {
        return this.items;
    }

    // In danh sách giỏ hàng
    public void printCart() {
        System.out.println("*****Giỏ hàng*****");
        for (int i = 0; i < this.items.size(); i++) {
            DigitalVideoDisc disc = this.items.get(i);
            System.out.println((i + 1) + ". " + disc.getTitle() + " - $" + disc.getCost());
        }
        System.out.println("Tổng: $" + this.getTotalCost());
        System.out.println("*****");
    }

    // Tìm DVD theo tên
    public DigitalVideoDisc searchByTitle(String title) {
        for (DigitalVideoDisc disc : this.items) {
            if (disc.getTitle().equalsIgnoreCase(title)) {
                return disc;
            }
        }
        return null;
    }

    // Tìm DVD theo thể loại
    public ArrayList<DigitalVideoDisc> searchByCategory(String category) {
        ArrayList<DigitalVideoDisc> result = new ArrayList<DigitalVideoDisc>();
        for (DigitalVideoDisc disc : this.items) {
            if (disc.getCategory().equalsIgnoreCase(category)) {
                result.add(disc);
            }
        }
        return result;
    }
}
