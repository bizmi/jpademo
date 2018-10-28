package pl.oskarpolak.jpademo.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.oskarpolak.jpademo.models.BarcodeEntity;

import java.util.List;

@Repository
public interface BarcodeRepository extends CrudRepository<BarcodeEntity, Integer> {
    List<BarcodeEntity> findAllByOrderByIdDesc();
    //List<BarcodeEntity> findByBarcodeMatchesAndWeightIsGreaterThanEqual(String s, int o);
    List<BarcodeEntity> findAllByProductCompanyContains(String text);
    List<BarcodeEntity> findAllByProductNameContains(String text);
 }
