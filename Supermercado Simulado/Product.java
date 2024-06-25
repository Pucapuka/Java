public class Product {
  String name;
  String barcode;
  double price;
  
  Product(String barcode, String name, double price){
  	this.barcode = barcode;
    this.name = name;
    this.price = price;
  }

  public void setPrice(float price){
  	this.price = price;
  }
  
  public double getPrice(){
  	return this.price;
  }
  
  public void setName(String name){
  	this.name = name;
  }
  
  public String getName(){
  	return this.name;
  }
  
  public void setBarcode(String barcode){
  	this.barcode = barcode;
  }
  
  public String getBarcode(){
  	return this.barcode;
  }
 
  @Override
  public String toString(){
      
      return "Produtos:\n"
            +"\nCódigo de Barras: " + barcode
        	+"\nProduto: " + name
            +"\nPreço: " + price+"\n";
    }
}