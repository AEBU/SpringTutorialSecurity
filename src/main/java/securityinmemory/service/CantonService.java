package securityinmemory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import securityinmemory.model.Canton;
import securityinmemory.repository.CantonRepository;

import java.util.List;

/**
 * Created by Alexis on 05/04/2017.
 */
@Service
public class CantonService {
    @Autowired
    private CantonRepository cantonRepository;

    public List<Canton> listAllCantons(){
        return cantonRepository.findAll();
    }

    public Canton getCantonById(Integer id) {
        return cantonRepository.findOne(id);
    }
    public Canton saveCanton(Canton canton){
        return cantonRepository.save(canton);
    }

    public void deleteCanton(Integer id){
        cantonRepository.delete(id);
    }

}
