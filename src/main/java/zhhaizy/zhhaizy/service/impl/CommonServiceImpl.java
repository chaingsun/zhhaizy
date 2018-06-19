package zhhaizy.zhhaizy.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import zhhaizy.zhhaizy.repository.BaseRepository;
import zhhaizy.zhhaizy.service.CommonService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public abstract class CommonServiceImpl<T,ID extends Serializable> implements CommonService<T,ID> {

    public abstract BaseRepository<T,ID> currentRepository();

    @Override
    public T save(T entity) {
        return this.currentRepository().save(entity);
    }

    @Override
    public T deleteById(ID id) {
        Optional<T> t=this.currentRepository().findById(id);
        T entity=t.get();
       this.currentRepository().deleteById(id);
        return entity;
    }

    @Override
    public Optional<T> findById(ID id) {
        return this.currentRepository().findById(id);
    }

    @Override
    public List<T> findAll() {
        List<T> list=this.currentRepository().findAll();
        if(null==list){
            Collections.emptyList();
        }
        return list;
    }

    @Override
    public Page<T> findByPage(T t, Pageable pageable) {
        return this.currentRepository().findAll(new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates=new ArrayList<>();
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
    }
}
