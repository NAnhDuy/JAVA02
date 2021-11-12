import java.io.*;
import java.util.Scanner;


public class MyList {
    MyStack s;
    Node head;
    Node tail;
    // Node của stack
    Node heads;
    Node tails;
    // Node của queue
    Node headq;
    Node tailq;
    Scanner sc = new Scanner(System.in);
    
    public MyList() {
        head=tail=null;
    }
    
    public MyList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    
    // thêm phần tử vào đầu danh sách
    public void insertToHead(Product item) {
        Node newNode = new Node();
            if (head == null) {
            head = newNode;
            tail = newNode;
        }
        newNode.next = head;
        head = newNode;
    }
    // thêm phần tử vào cuối danh sách 
    public void AddLast(Product item){
        Node q = new Node(item);
        if(head == null) {
            head=tail=q;
            return;
        }
        tail.next = q;
        tail = q;
    }
    // hàm duyệt danh sách và hiển trị ra màn hình
    public void traverse() {
        if(head == null) {
            System.out.println("THÔNG BÁO: Danh sách hiện đang trống!");
        }
        Node p = head;
        while(p!=null) {
            System.out.println(p.info.toString());
            p=p.next;
        }
    }

/* những hàm chức năng trong bài !!! */ 

    // đọc dữ liệu từ file
    public void getAllItemsFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Data.txt"));
            String a = reader.readLine();

            while(a != null) {
                // in dữ liệu ra màn hình
                System.out.println(a);
                // tách chuỗi dựa trên ký tự
                String[] b = a.split("\\|");
                Product save = new Product(b[0].trim(), b[1].trim(), Integer.parseInt(b[2].trim()), Double.parseDouble(b[3].trim())); 

                AddLast(save);
                a = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // thêm node mới 
    public void addNewNode() {
        System.out.println("nhập ID: ");
        String newId = sc.next();
        System.out.println("nhập tên sản phẩm:  ");
        String newTitle = sc.next();
        System.out.println("nhập số lượng: ");
        int newQuantity = sc.nextInt();
        System.out.println("giá bán(double): ");
        double newPrice = sc.nextDouble();

        Product newAdd = new Product();
        newAdd.id = newId;
        newAdd.title = newTitle;
        newAdd.quantity = newQuantity;
        newAdd.price = newPrice;
        // thêm phần tử vào danh sách
        AddLast(newAdd);
    } 

    // lưu danh sách vào file 
    public void save() throws IOException {
        FileWriter out = null;
        try {
            out = new FileWriter("Data.txt");
            Node p = head;
            while(p != null) {
                out.write(p.info + "\n");
                p = p.next;
            }
        } finally {
            if(out != null) {
                out.close();
            }
        }
    }

    // hàm tìm kiếm id sản phẩm
     public void searchId() {
        String x = sc.next();
        Node current;

        if(head == null) {
            System.out.println("Danh sach lien ket chua duoc khoi tao");
            return;
        } 
        current = head;
        while(current != null) {
            if(current.info.id.equals(x)) {
                System.out.println("Result: " + current.info);
                return;
            }
            current = current.next;
        }
        System.out.println("-1");
    }

    // hàm xóa sản phẩm khỏi list
    public void deleteElement() {
        String x = sc.next();
        Node pDel = head; // tạo một node pDel để xóa
        //Nếu pDel == Null thì danh sách rỗng
        if(pDel == null) {
            System.out.println("Danh sách rỗng!");
        //ngược lại thì xét điều kiện
        } else { 
            Node pPre = null;
            //dùng vòng lặp while để tìm ra pDel và pPre (vị trí đứng trước pDel)
            while(pDel != null){
                if(pDel.info.id.equals(x)){
                    break;
                }
                pPre = pDel;
                pDel = pDel.next;
            }
            //Nếu pDel == null tức là không tìm thấy số cần xóa
            if(pDel == null){
                System.out.println("Không tìm thấy số cần xóa");
            // Ngược lại tiếp tục xét điều kiện
            // Nếu pDel == head, tức là số cần xóa ở đầu danh sách
            }else if(pDel == head) {
                head = head.next;
                pDel.next = null;   
                pDel = null;
            //Nếu pDel == tail, tức là số cần xóa ở cuối danh sách
            }else if(pDel.next == null){
                tail = pPre;
                pPre.next = null;
                pDel = null;
            // và trường hợp cuối cùng số muốn xóa nằm ở giữa danh sách
            }else{
                pPre.next = pDel.next;
                pDel.next = null;
                pDel = null; 
            }
        }
    }

    // hàm sắp xếp theo ID trong danh sách
    public void sortByID() {
        Node current = head;
        Node currentNext;
         // vòng lặp so sánh
        while(current != null) {
            currentNext = current.next;
            while(currentNext != null) {
                // nếu kết quả của compareTo lớn hơn 0 có nghĩa là id phần tử đứng trước lớn hơn(trong bảng chữ cái) id phần tử đứng sau.  
                if(current.info.id.compareTo(currentNext.info.id) > 0) {
                    Product swap = current.info;
                    current.info = currentNext.info;
                    currentNext.info = swap;
                }
                currentNext = currentNext.next;
            }
            current = current.next;
        }
         // in dữ liệu đã sắp xếp ra màn hình 
        traverse();
    }

    // hàm chuyển đổi hệ đếm cơ số 10 sang hệ đếm nhị phân.
    public void PrintNhiPhan(int num) {

        int binary[] = new int[40];
        int index = 0;
        while(num > 0){
            binary[index++] = num%2;
            num = num/2;
        }
        for(int i = index-1;i >= 0;i--){
            System.out.print(binary[i]);
        }
    } 

    /* hàm Stack
    *  hàm đọc dữ liệu từ file và thêm vào stack
    */ 
    public void readStack() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Data.txt"));
            String a = reader.readLine();

            while(a != null) {
                // tách chuỗi dựa trên ký tự
                String[] b = a.split("\\|");
                Product save = new Product(b[0].trim(), b[1].trim(), Integer.parseInt(b[2].trim()), Double.parseDouble(b[3].trim())); 
                push(save);
                a = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // hàm thêm node vào đầu stack
    public void push(Product x) {
        heads = new Node(x, heads);
    }
    // hàm in stack ra màn hình
    public void printStack() {
        Node current = heads;
        if(current != null) {
            while(current != null) {
                System.out.println(current.info + " ");
                current = current.next;
            }
        } else {
            System.out.println("Danh sách trống");
        }
    }

    /* hàm Stack
    *  hàm đọc dữ liệu từ file và thêm vào stack
    */
    public void readQueue() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Data.txt"));
            String a = reader.readLine();

            while(a != null) {
                // tách chuỗi dựa trên ký tự
                String[] b = a.split("\\|");
                Product save = new Product(b[0].trim(), b[1].trim(), Integer.parseInt(b[2].trim()), Double.parseDouble(b[3].trim())); 
                pushQueue(save);
                a = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // hàm thêm node vào Queue
    public void pushQueue(Product x) {
        Node p = new Node(x);
        if(headq == null) {
            headq = tailq = p;
        } else {
            tailq.next = p;
            tailq = p;
        }
    }
    // hàm in Queue ra màn hình
    public void print() {
        Node current = headq;
        if(current != null) {
            while(current != null) {
                System.out.println(current.info + " ");
                current = current.next;
            }
        } else {
            System.out.println("Danh sách trống");
        }
    }
    
}
    