package com.example.landonhotel.repository;

import java.util.List;

import com.example.landonhotel.entity.RoomEntity;
import org.springframework.data.repository.CrudRepository;



public interface RoomRepository extends CrudRepository<RoomEntity, Long> {

	//RoomEntity findById(Long id);
}
