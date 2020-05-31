package entornos.cip.Max;

public class Division extends Operacion{
    
    double div = 0;
       
    public Division(double n1, double n2) throws Exception {
             
        super(n1, n2, '/');
        if(n2==0) {
        	throw new Exception("No se puede dividir entre cero");
        	}
        else this.div = n1 / n2;
        this.setRes(this.div);
    }    
}