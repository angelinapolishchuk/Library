package Patterns;

public class Librarian {
    String name;
    String secondName;
    short age;
    int phoneNumber;


    public static Builder builder(){
        return new Librarian().new Builder();
    }
    public class Builder{
        private Builder(){

        }
        public Builder withName(String name){
            Librarian.this.name =name;
            return this;
        }

        public Builder withSecondName(String secondName){
            Librarian.this.secondName =secondName;
            return this;
        }
        public Builder withAge(short age){
            Librarian.this.age =age;
            return this;
        }
        public Builder withPhoneNumber(int phoneNumber){
            Librarian.this.phoneNumber =phoneNumber;
            return this;
        }
        public Librarian build(){
            return Librarian.this;
        }


    }
    @Override
    public String toString() {
        return "Librarian {" +
                "name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

}
