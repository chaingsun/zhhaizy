package zhhaizy.zhhaizy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhhaizy.zhhaizy.domain.DrugSeries;
import zhhaizy.zhhaizy.repository.BaseRepository;
import zhhaizy.zhhaizy.repository.DrugRepository;
import zhhaizy.zhhaizy.repository.DrugSeriesRepository;
import zhhaizy.zhhaizy.service.DrugSeriesService;

@Service
public class DrugSeriesServiceImpl extends CommonServiceImpl<DrugSeries,Integer> implements DrugSeriesService {

    @Autowired
    private DrugSeriesRepository drugSeriesRepository;
    @Override
    public BaseRepository<DrugSeries, Integer> currentRepository() {
        return drugSeriesRepository;
    }


}
