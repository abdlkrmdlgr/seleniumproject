package com.dlgr.yoksis.service;

import com.dlgr.yoksis.dao.AnnounceDao;
import com.dlgr.yoksis.dao.UniversityDao;
import com.dlgr.yoksis.dto.AnnounceDTO;
import com.dlgr.yoksis.dto.UniversityDTO;
import com.dlgr.yoksis.model.Announce;
import com.dlgr.yoksis.model.University;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dlgr on 29.10.2016.
 */
public class ProjectService {


    @Transactional
    public UniversityDTO saveUniversity(UniversityDTO universityDTO) {

        UniversityDao universityDao = new UniversityDao();
        University university = universityDTO.getId() != null ? universityDao.get(universityDTO.getId()) : new University();
        university.setLogo(universityDTO.getLogo());
        university.setName(universityDTO.getName());
        return universityDao.save(university).toDTO();

    }

    @Transactional
    public void saveAnnounce(AnnounceDTO announceDTO) {
        AnnounceDao announceDao = new AnnounceDao();
        Announce announce = announceDTO.getId() != null ? announceDao.get(announceDTO.getId()) : new Announce();
        announceDao.save(announce).toDTO();
    }


}
