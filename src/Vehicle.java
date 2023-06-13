public class Vehicle{
    String type;
    String name;
    String number;

    public Vehicle(String type, String name, String number) throws Exception{
        setType(type);
        setName(name);
        setNumber(number);
    }
    public void setType(String type) throws Exception {
        if(type == "SUV"|| type == "Sedan" || type == "Hatchback"){
            this.type = type;
        }
        else{
            throw new Exception("Invalid Vehicle Type");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) throws Exception {
        if(number.length() == 10 )
            this.number = number;
        else{
            throw new Exception("Invalid Vehicle number");
        }
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
    public String getNumber() {
        return number;
    }

    public String toString() {
        return "Vehicle{" +
                "type='" + getType() + '\'' +
                "\n, name='" + getName() + '\'' +
                "\n, number='" + getNumber() + '\'' +
                '}';
    }
}