package com.hadas.zooticketssystem.repositories;

import com.hadas.zooticketssystem.visitors.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
//public interface VisitorRepository extends JpaRepository<Visitor, Long> {
public interface VisitorRepository extends CrudRepository<Visitor, Long> {

}
