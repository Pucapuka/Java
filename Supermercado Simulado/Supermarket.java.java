import java.util.ArrayList;
import java.util.List;

public class Supermarket{
    
	public static void main(String[] args) {
	    List<Product> products = new ArrayList<>();
    	Product product1 = new Product("789654021", "Sabão", 15.75);
    	    products.add(product1);
    	Product product2 = new Product("789653321", "Detergente", 10.21);
    	    products.add(product2);
    	
        for(Product product : products){
          System.out.println(product);
	    }
	    
	    product2.setName("Detergente líquido");
	    
	    for(Product product : products){
          System.out.println(product);
	    }
    }
}