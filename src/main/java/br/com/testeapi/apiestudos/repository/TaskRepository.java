package br.com.testeapi.apiestudos.repository;

import br.com.testeapi.apiestudos.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
