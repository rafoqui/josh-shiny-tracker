package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Counter;

public interface CounterJpaSpring extends JpaRepository<Counter, Long>{

}
