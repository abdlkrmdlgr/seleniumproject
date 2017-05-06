package com.dlgr.yoksis.dao;

import com.dlgr.yoksis.model.Announce;
import org.springframework.stereotype.Repository;

/**
 * Created by dlgr on 30.10.2016.
 */
@Repository
public class AnnounceDao extends BaseDao<Announce> {
    public AnnounceDao() {
        super(Announce.class);
    }
}
