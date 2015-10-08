package com.hupu.db;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.hupu.db.Board;
import com.hupu.db.User;

import com.hupu.db.BoardDao;
import com.hupu.db.UserDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig boardDaoConfig;
    private final DaoConfig userDaoConfig;

    private final BoardDao boardDao;
    private final UserDao userDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        boardDaoConfig = daoConfigMap.get(BoardDao.class).clone();
        boardDaoConfig.initIdentityScope(type);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        boardDao = new BoardDao(boardDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);

        registerDao(Board.class, boardDao);
        registerDao(User.class, userDao);
    }
    
    public void clear() {
        boardDaoConfig.getIdentityScope().clear();
        userDaoConfig.getIdentityScope().clear();
    }

    public BoardDao getBoardDao() {
        return boardDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

}