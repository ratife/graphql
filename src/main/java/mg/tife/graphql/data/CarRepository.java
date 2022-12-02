package mg.tife.graphql.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long>{
	Car findCarByName(String name);
}
