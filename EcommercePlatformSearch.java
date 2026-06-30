/*
Big O Notation: Big O notation is a mathematical notation used to describe how the running time or memory usage of an algorithm grows as the input size (n) increases.
For search Algorithms,Linear search, best case is O(1) and worst case is O(n). Binary search, best case is O(1) and worst case is O(log n).
O(1)<O(log n)<O(n)<O(n log n)<O(n^2)<O(2^n)<O(n!)
thus binary search is more efficient than linear search for large datasets, but it requires the data to be sorted beforehand. Linear search can be used on unsorted data but is less efficient for large datasets.
But spacecomplexity is O(1) for both linear and binary search, as they do not require any additional data structures that grow with the input size.
 */
import java.util.*;
class Product{
    int productId;
    String productName;
    String category;
    Product(int productId, String productName, String category){
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}
public class EcommercePlatformSearch{
    private static void LinearSearch(Product[] products, int targetProductId){
        for(int i=0;i<products.length;i++){
            if(products[i].productId == targetProductId){
                System.out.println("Product found: " + products[i].productName + ", Category: " + products[i].category);
                return;
            }
        }
        System.out.println("Product not found");
    }
    private static void BinarySearch(Product[] products, int targetProductId){
        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));
        int low = 0;
        int high = products.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(products[mid].productId == targetProductId){
                System.out.println("Product found: " + products[mid].productName + ", Category: " + products[mid].category);
                return;
            }
            else if(products[mid].productId < targetProductId){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        System.out.println("Product not found");
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        Product[] products = new Product[n];
        for(int i=0;i<n;i++){
            int productId = sc.nextInt();
            String productName = sc.next();
            String category = sc.next();
            products[i] = new Product(productId, productName, category);
        }
        int targetProductId = sc.nextInt();
        LinearSearch(products, targetProductId);
        BinarySearch(products, targetProductId);
    }
}