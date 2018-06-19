package zhhaizy.zhhaizy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import zhhaizy.zhhaizy.repository.BaseRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Transactional
public interface CommonService<T,ID extends Serializable> {
    @Transactional
    T save(T entity);

    @Transactional
    T deleteById(ID id);

    Optional<T> findById(ID id);

    List<T> findAll();

    Page<T> findByPage(T t, Pageable pageable);
}
