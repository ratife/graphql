package mg.tife.graphql.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import mg.tife.graphql.data.Car;
import mg.tife.graphql.data.CarInput;
import mg.tife.graphql.data.CarRepository;

@Controller
public class CarController {
	private final CarRepository carRepository;
	
	public CarController(CarRepository carRep) {
		this.carRepository = carRep;
	}
	
	@QueryMapping
	public Iterable<Car> cars(){
		return carRepository.findAll();
	}
	
	@QueryMapping
	public Car carById(@Argument Long id) {
		Car car = carRepository.findById(id).orElse(null);
		return car ;
	}
	
	@QueryMapping
	public Car carByName(@Argument String name) {
		return carRepository.findCarByName(name);
	}
	
	@MutationMapping
	public Car addCar(@Argument(name="input") CarInput carInput) {
		return carRepository.save(carInput.getCarEntity());
	}
	
}
