package zhhaizy.zhhaizy.service.impl;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import zhhaizy.zhhaizy.domain.Drug;
        import zhhaizy.zhhaizy.domain.User;
        import zhhaizy.zhhaizy.repository.BaseRepository;
        import zhhaizy.zhhaizy.repository.DrugRepository;
        import zhhaizy.zhhaizy.service.DrugService;
        import zhhaizy.zhhaizy.service.UserService;

@Service
public class DrugServiceImpl extends CommonServiceImpl<Drug,Integer> implements DrugService {

    @Autowired
    private DrugRepository drugRepository;
    @Override
    public BaseRepository<Drug, Integer> currentRepository() {
        return drugRepository;
    }


}
