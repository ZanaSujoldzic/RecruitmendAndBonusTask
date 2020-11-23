/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Device;
import java.util.List;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Zana
 */
@Stateless
public class DeviceFacade extends AbstractFacade<Device> implements DeviceFacadeLocal {

    @PersistenceContext(unitName = "RecruitmentTaskPU")
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public DeviceFacade() {
        super(Device.class);
    }

    @Override
    public void addNewDevice(String name) {

        Device device = new Device();

        UUID nameUUID = new UUID(0, 0);
        UUID randomDeviceName = nameUUID.randomUUID();
        String deviceName = randomDeviceName.toString();

        device.setName(deviceName);

    }
}
