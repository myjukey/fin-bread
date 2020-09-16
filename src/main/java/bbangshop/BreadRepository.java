package bbangshop;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface BreadRepository extends PagingAndSortingRepository<Bread, Long>{

    //Optional<Bread> findByBreadId(Long breadId);
}