
package screen;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;
import entity.Device;
import entity.Stake;
import entity.Ticket;
import model.TicketFacadeLocal;


@Named(value = "ticketManagedBean")
@SessionScoped
public class TicketManagedBean implements Serializable {

   @Inject
   private TicketFacadeLocal ticketFacadelocal;
   
   private Device addedDevice = new Device();
   private Ticket ticket = new Ticket();
   private Stake stake = new Stake();

    public Device getDevice() {
        return addedDevice;
    }

    public Stake getStake() {
        return stake;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setDevice(Device device) {
        this.addedDevice = device;
    }

    public void setStake(Stake stake) {
        this.stake = stake;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
   
    public TicketManagedBean() {
        this.addedDevice = new Device();
    }
    
    public void add(){
        this.ticketFacadelocal.create(ticket);
    }
    
    public void checkStakeLimit(){
        if(this.stake.getAmount() < 800){
            System.out.println("OK should be produced."); 
        }else if(this.stake.getAmount() >= 800 && this.stake.getAmount() <= 999){
            System.out.println("HOT should be produced.");
        }else{
            System.out.println("BLOCKED should be produced.");
        }
    }
    
}
