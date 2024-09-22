package application;

import entity.*;
import dao.*;

public class DeviceApp {

    public static void main(String[] args) {
    	
    	Dao dao = new Dao();
        Device l1 = new Device("Dell Latitude 7490");
        Device l2 = new Device("HP EliteBook 840 G5");
        Device l3 = new Device("Lenovo ThinkPad T480");

        dao.saveDevice(l1);
        dao.saveDevice(l2);
        dao.saveDevice(l3);
        System.out.println("Device saved.");
        System.out.println(l1.getDeviceId());
        dao.loadDevice(1);
        boolean value = dao.updateDeviceDescription(1, "Dell Latitude 7490 - updated");
        System.out.println("Device updated: " + value);

        dao.deleteDevice(1);
    }
}

