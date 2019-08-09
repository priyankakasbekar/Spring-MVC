package LearningSpring.spring_rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import LearningSpring.spring_rest.entities.Vehicle;


@Repository
public class VehicleRepositoryImpl implements VehicleRepository 
{
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Vehicle> findAll() {
		// TODO Auto-generated method stub
		TypedQuery<Vehicle> query =  em.createNamedQuery("Vehicle.findall",Vehicle.class);
		
		List<Vehicle> result = query.getResultList();
		return result;
	}

	@Override
	public Vehicle findOne(String vin) {
		// TODO Auto-generated method stub
		return em.find(Vehicle.class, vin);
	}

	@Override
	public Vehicle create(Vehicle vehicle) {
		// TODO Auto-generated method stub
		em.persist(vehicle);
		return vehicle;
	}

	@Override
	public Vehicle update(String vin, Vehicle vehicle) {
		// TODO Auto-generated method stub
		return em.merge(vehicle);
		
	}

	@Override
	public void delete(Vehicle vehicle) {
		// TODO Auto-generated method stub
		em.remove(vehicle);
		
	}

}
