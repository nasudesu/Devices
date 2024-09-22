package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import entity.*;

public class Dao {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevPU");

	public void saveDevice(Device device) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
        em.persist(device);
        
        em.getTransaction().commit();
        em.close();
	}

	public void loadDevice(int deviceId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Device device = em.find(Device.class, deviceId);
		System.out.println(device);
		em.close();
	}

	public boolean updateDeviceDescription(int id, String newDescription){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Device device = em.find(Device.class, id);
		if(device == null){
			em.close();
			return false;
		}
		device.setDescription(newDescription);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	public void deleteDevice(int id){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Device device = em.find(Device.class, id);
		if(device != null){
			em.remove(device);
			System.out.println("Device: " + device + " deleted.");
		}
		em.getTransaction().commit();
		em.close();
	}
}
