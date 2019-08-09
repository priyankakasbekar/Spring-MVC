package LearningSpring.spring_rest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import LearningSpring.spring_rest.entities.Vehicle;
import LearningSpring.spring_rest.exceptions.BadRequestException;
import LearningSpring.spring_rest.exceptions.VehicleNotFoundException;
import LearningSpring.spring_rest.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService
{
	
	@Autowired
	private VehicleRepository repository;

	@Override
	@Transactional
	public Vehicle create(Vehicle vehicle) {
		
		Vehicle existing = repository.findOne(vehicle.getVin());
		
		if (existing != null)
		{
			throw new BadRequestException("The vehicle with vin "+ vehicle.getVin()+ " already exists");
		}
		
		return repository.create(vehicle);
	
	}

	@Override
	@Transactional
	public Vehicle update(String vin, Vehicle vehicle) {
		Vehicle existing = repository.findOne(vin);
		
		if (existing == null)
		{
			throw new VehicleNotFoundException("Vehicle with vin = " + vin + "is not found");
		}
		
		return repository.update(vin, vehicle);
	}

	@Override
	@Transactional
	public void delete(String vin) {
		
		Vehicle vehicle = repository.findOne(vin);
		
		if (vehicle == null)
		{
			throw new VehicleNotFoundException("Vehicle with vin = " + vin + "is not found");
		}
		
		repository.delete(vehicle);
	}

	@Override
	public List<Vehicle> findAll() {
		
		return repository.findAll();
	}

	@Override
	public Vehicle findOne(String vin) {
		
		Vehicle vehicle = repository.findOne(vin);
		
		if (vehicle == null)
		{
			throw new VehicleNotFoundException("Vehicle with vin = " + vin + "is not found");
		}
		
		else
		{
			return vehicle;
		}
	}
		

}
