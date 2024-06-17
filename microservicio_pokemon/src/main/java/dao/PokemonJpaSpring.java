package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import model.Pokemon;

public interface PokemonJpaSpring extends JpaRepository<Pokemon, Integer>{
	@Transactional
	@Modifying
	@Query("SELECT p FROM Pokemon p WHERE p.name LIKE %:term%")
	List<Pokemon> searchByName(@Param("term") String term);
}
