package Teoria;

public class SistemaDescuentoMiembros {
    public static void main(String[] args) {
        Date fecha = new Date("23", "11","1800" , "19:30");
        
        Customer c1 = new Customer("Juan Perez");
        c1.setMember(true);
        c1.setMemberType("Premium");

        Visit v1 = new Visit(c1, fecha);
        v1.setProductExpense(2100.00);
        v1.setServiceExpense(3500.50);

        double descuento = v1.getServiceExpense() * DiscountRate.getServiceDiscountRate(c1.getMemberType());

        v1.setServiceExpense(v1.getServiceExpense() - descuento);

        System.out.println(v1.toString());

        


    }

}


class Customer{
    private String name;
    private boolean member = false;
    private String memberType = "";


    // Constructor
    public Customer(String name){
        this.name = name;
    }


    // Setters y Getters

    public String getName() {
        return name;
    }

    public boolean isMember(){
        return this.member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    @Override
    public String toString() {
        String esMiembro = (this.member)? "Es miembro": "No es miembro";
        String tipoMiembro = (this.member)? this.memberType: "No tiene tipo";
        String mensaje = "Nombre:  " + this.name + "    " + esMiembro + "    " + tipoMiembro; 
        return mensaje;
    }

}

class Date{
    private String dia;
    private String mes;
    private String anio;
    private String hora;

    public Date(String dia, String mes, String anio, String hora){
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.hora = hora;
    }

    @Override
    public String toString() {
        String mensaje = this.dia + "/" + this.mes + "/" + this.anio + "   " + this.hora; 
        return mensaje;
    }



}

class Visit{
    private Customer customer;
    private Date date;
    private double serviceExpense;
    private double productExpense;

    // Constructor
    public Visit(Customer customer, Date date){
        this.customer = customer;
        this.date = date;
    }

    public Visit(String name, Date date){
        this.customer = new Customer(name);
        this.date = date;
    }

    // Setters y Getters

    public String getName(){
        return this.customer.getName();
    }

    public double getProductExpense() {
        return productExpense;
    }
    
    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }


    public double getTotalExpense(){
        return this.productExpense + this.serviceExpense;
    }

    @Override
    public String toString() {
        String mensaje = "Fecha y hora: " + this.date.toString()
        + "\nNombre: " + this.customer.getName() + "    Productos: " + this.productExpense + "    Servicios" + this.serviceExpense;
        return mensaje;
    }
}

class DiscountRate{
    private static double serviceDiscountPremium = 0.2;
    private static double serviceDiscountGold = 0.15;
    private static double serviceDiscountSilver = 0.1;

    public static double getServiceDiscountRate(String type){
        if (type.equals("Premium")) {
            return serviceDiscountPremium;
        } else {
            if (type.equals("Gold")) {
                return serviceDiscountGold;
            } else {
                if (type.equals("Silver")) {
                    return serviceDiscountSilver;
                } else {
                    return 0;
                }
            }
        }
    }


}