/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import model.DeviceFacadeLocal;
import entity.Device;



@Named(value = "deviceManagedBean")
@SessionScoped
public class DeviceManagedBean implements Serializable {
    
    @Inject
    private DeviceFacadeLocal deviceFacadeLocal;
    private Device device = new Device();
    private String name;

    public DeviceManagedBean() {
    }
    
        public Device getDevice() {
        return device;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
        

    public void setDevice(Device device) {
        this.device = device;
    }

    public List<Device> findAll(){
        return this.deviceFacadeLocal.findAll();
    }
    
    public String add(){
        this.deviceFacadeLocal.create(device);
        return "index";
    }
    
    public String addNewDevice(String name){
        this.deviceFacadeLocal.addNewDevice(name);
        return "index";
    }
}
