import java.util.*;


import java.io.*;
/**
 * AS2_Main
 */
public class AS2_Main {
    Product info;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int chose;
        MyList a = new MyList();
        
        do {
            System.out.println();
            System.out.println("|  1. Đọc dữ liệu có sẵn từ file chứa các sản phẩm!                   |");
            System.out.println("|  2. Thêm một sản phẩm mới vào cuối danh sách.                       |");
            System.out.println("|  3. Duyệt sản phần tử trong danh sách và in ra màn hình             |");
            System.out.println("|  4. lưu dữ liệu trong danh sách vào file                            |");
            System.out.println("|  5. Tìm kiếm sản phẩm theo ID                                       |");
            System.out.println("|  6. Xóa sản phẩm theo ID                                            |");
            System.out.println("|  7. Xắp xếp sản phẩm theo ID                                        |");
            System.out.println("|  8. Đổi số lượng của sản phẩm đầu tiên từ thập phân sang nhị phân!  |");
            System.out.println("|  9. Hiển thị danh sách được lưu vào Stack.                          |");
            System.out.println("|  10. Hiển thị danh sách được lưu vào Queue.                         |");
            System.out.println("|  0. Exit                                                            |");
            System.out.println("                 Choose one of this options!         ");
            chose = sc.nextInt();
            switch (chose) {
                case 1:
                    System.out.println("Đọc dữ liệu có sẵn từ file chứa các sản phẩm!");
                    a.getAllItemsFromFile();
                    break;
                case 2:
                    System.out.println("Bạn muốn thêm một sản phẩm vào danh sách.");
                    a.addNewNode();
                    a.save();
                    System.out.println("Successfully!");
                    break;
                case 3:
                    System.out.println("Duyệt sản phần tử trong danh sách và in ra màn hình.");
                    a.traverse();
                    break;
                case 4:
                    System.out.println("lưu dữ liệu trong danh sách vào file Data.txt");
                    a.save();
                    System.out.println("Successfully!");
                    break;
                case 5:
                    System.out.println("Nhập ID cần tìm kiếm");
                    a.searchId();
                    break;
                case 6:
                    System.out.println("Nhập vào giá trị ID cần xóa");
                    a.deleteElement();
                    a.save();
                    System.out.println("Deleted!");
                    break;
                case 7:
                    System.out.println("Sắp xếp phần tử trong danh sách theo ID");
                    a.sortByID();
                    a.save();
                    System.out.println("Successfully!");
                    break;
                case 8:
                    System.out.println("Đổi số đếm từ thập phân sang nhị phân.");
                    int p = a.head.info.quantity;
                    System.out.print("Quantity = " + p + " => ");
                    a.PrintNhiPhan(p);
                    break;
                case 9:
                    System.out.println("Thông tin về Stack.");
                    a.readStack();
                    a.printStack();
                    break;
                case 10:
                System.out.println("Thông tin về Queue.");
                    a.readQueue();
                    a.print();
                    break;
                case 0:
                    System.out.println("Thank for coming!");
                    break;
                default: System.out.println("Bạn đã nhập sai, xin hãy nhập lại!");
                    
            }
        
        } while(chose != 0);
    }


}