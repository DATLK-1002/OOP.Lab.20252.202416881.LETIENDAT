public class Aims {
    public static void main(String[] args) {
        // Tạo giỏ hàng
        Cart cart = new Cart();

        // Tạo một số DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 88, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 121, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 29.95f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Toy Story", "Animation", "John Lasseter", 81, 19.95f);

        // Thêm vào giỏ
        cart.addDigitalVideoDisc(dvd1);
        cart.addDigitalVideoDisc(dvd2);
        cart.addDigitalVideoDisc(dvd3);
        cart.addDigitalVideoDisc(dvd4);

        // In giỏ hàng
        cart.printCart();

        // Tìm kiếm theo tên
        System.out.println("\n--- Tìm kiếm theo tên ---");
        DigitalVideoDisc found = cart.searchByTitle("Inception");
        if (found != null) {
            System.out.println("Tìm thấy: " + found);
        }

        // Tìm kiếm theo thể loại
        System.out.println("\n--- Tìm kiếm theo thể loại ---");
        java.util.ArrayList<DigitalVideoDisc> animationDVDs = cart.searchByCategory("Animation");
        System.out.println("Animation: " + animationDVDs.size() + " DVD");
        for (DigitalVideoDisc dvd : animationDVDs) {
            System.out.println("  - " + dvd.getTitle());
        }

        // Xóa một DVD
        System.out.println("\n--- Xóa DVD ---");
        cart.removeDigitalVideoDisc(dvd2);

        // In lại giỏ
        cart.printCart();
    }
}
