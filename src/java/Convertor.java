
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "convertorBean")
@SessionScoped
public class Convertor implements Serializable{
    
     public static final BigDecimal KURS_EUR = BigDecimal.valueOf(1.95);
     public static final BigDecimal KURS_USD = BigDecimal.valueOf(1.64);
    
    public Convertor(){
        
    }
    
    public BigDecimal bamToEuro(BigDecimal bamAmount) {
    BigDecimal euroAmount = bamAmount.divide(KURS_EUR, 9, RoundingMode.HALF_UP);
    euroAmount = euroAmount.setScale(2, RoundingMode.HALF_UP);
    return euroAmount;
    
}
    public BigDecimal euroToBam(BigDecimal euroAmount) {
    BigDecimal bamAmount = euroAmount.multiply(KURS_EUR);
    bamAmount.setScale(2, RoundingMode.HALF_UP);
    return bamAmount;
    }
    
}
