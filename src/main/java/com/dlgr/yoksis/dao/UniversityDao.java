package com.dlgr.yoksis.dao;

import com.dlgr.yoksis.model.University;
import org.springframework.stereotype.Repository;

/**
 * Created by dlgr on 29.10.2016.
 */
@Repository
public class UniversityDao extends BaseDao<University> {
    public UniversityDao() {
        super(University.class);
    }
}
