package zhhaizy.zhhaizy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhhaizy.zhhaizy.domain.KeyWord;
import zhhaizy.zhhaizy.repository.BaseRepository;
import zhhaizy.zhhaizy.repository.KeyWordRepository;
import zhhaizy.zhhaizy.service.KeyWordService;

@Service
public class KeyWordServiceImpl extends CommonServiceImpl<KeyWord,Integer> implements KeyWordService {

    @Autowired
    private KeyWordRepository keyWordRepository;
    @Override
    public BaseRepository<KeyWord, Integer> currentRepository() {
        return keyWordRepository;
    }


}
