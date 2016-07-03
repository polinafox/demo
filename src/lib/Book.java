
package lib;

public class Book implements Comparable<Book>{
        private String name;
        private int cost;
        private int size;
        
        public Book(String name, int cost, int size){
            this.name = name;
            this.cost = cost;
            this.size = size;
    }

        public String getName() {
            return name;
        }

        public int getCost() {
            return cost;
        }

        public int getSize() {
            return size;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public void setSize(int size) {
            this.size = size;
        }

                @Override
        public int compareTo(Book t) {
            try{
            if (this.getSize()> t.getSize()) {
                return 1;
            } else if (this.getSize()< t.getSize()){
                return -1;
            } else
                return 0;
            }
            catch(Exception e){
                System.out.println("Wrong object");
                return -1;
            }
        }
        
    }