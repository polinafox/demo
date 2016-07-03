
package lib;


import java.io.Serializable;
import java.util.ArrayList;


    public class Library implements Serializable {
        public ArrayList<Book> lib;
         public Library(){
             lib = new ArrayList<Book>();
        }
         public Book get(int i){
             return lib.get(i);
         }
         public void add(Book b){
             lib.add(b);
        }
         public void delete(Book b){
             lib.remove(b);
         }
         public void change(Book b, String n, int c, int s){
             Book temp = b;
             int index = lib.indexOf(b);
             temp.setName(n);
             temp.setCost(c);
             temp.setSize(s);
             lib.set(index, temp);
                          
         }
         public void change(Book b, String n){
             Book temp = b;
             int index = lib.indexOf(b);
             temp.setName(n);
             lib.set(index, temp);               
         }
         public void change(Book b, int cost){
             Book temp = b;
             int index = lib.indexOf(b);
             temp.setCost(cost);
             lib.set(index, temp);             
         }        
         public void sortByName(){
             for (int i = lib.size()-1; i >= 0; i--){
                 for (int j = 0; j < i; j++){
                     if (firstIsOver(lib.get(j).getName(), lib.get(j+1).getName())){
                         Book temp1 = lib.get(j);
                         lib.set(j, lib.get(j+1));
                         lib.set(j+1, temp1);                     
                     }           
                                         
                }
             }
         }
         public void sortByCost(){
             for (int i = lib.size()-1; i >= 0; i--){
                 for (int j = 0; j < i; j++){
                     if ((lib.get(j).getCost() > lib.get(j+1).getCost())){
                         Book temp1 = lib.get(j);
                         lib.set(j, lib.get(j+1));
                         lib.set(j+1, temp1);                     
                     }            
                                         
                }
             }
         }
         public void sortBySize(){
             for (int i = lib.size()-1; i >= 0; i--){
                 for (int j = 0; j < i; j++){
                     if ((lib.get(j).getSize() > lib.get(j+1).getSize())){
                         Book temp1 = lib.get(j);
                         lib.set(j, lib.get(j+1));
                         lib.set(j+1, temp1);                     
                     }            
                                         
                }
             }
         }
         public Book findByName(String name){
             Book res = new Book("", 0, 0);
            for (Book lib1 : lib) {
                if (lib1.getName().equals(name)) {
                    res = lib1;
                    break;
                }
            }
             return res;
         }
         public String show(){
             String res = "";
             for (Book b: lib){
                res+= "Name: "+b.getName()+", Cost: "+b.getCost()+", Pages: "+b.getSize()+"\n";              
                
             }
             return res;
             
         }
         public static boolean firstIsOver(String a, String b){
        char [] first = a.toCharArray();
        char [] second = b.toCharArray();
        int index = 0;
        while(first[index] == second[index]){
            index++;
            if (index == a.length()){
                System.out.println("Строки равны");
                return true;
            }
        }
        if (first[index] > second[index]){
            return true;
        } else 
            return false;
         
    }
    }

