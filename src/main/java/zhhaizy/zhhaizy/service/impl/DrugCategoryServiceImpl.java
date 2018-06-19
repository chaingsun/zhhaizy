package zhhaizy.zhhaizy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhhaizy.zhhaizy.domain.DrugCategory;
import zhhaizy.zhhaizy.repository.BaseRepository;
import zhhaizy.zhhaizy.repository.DrugCategoryRepository;
import zhhaizy.zhhaizy.service.DrugCategoryService;

@Service
public class DrugCategoryServiceImpl extends CommonServiceImpl<DrugCategory,Integer> implements DrugCategoryService {

    @Autowired
    private DrugCategoryRepository drugCategoryRepository;

    @Override
    public BaseRepository<DrugCategory, Integer> currentRepository() {
        return drugCategoryRepository;
    }


}
