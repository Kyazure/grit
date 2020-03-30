package com.hdjd.grit.service;

import com.hdjd.grit.core.exception.ParameterException;
import com.hdjd.grit.mapper.BattleMapper;
import com.hdjd.grit.model.dto.ExtendBattle;
import com.hdjd.grit.model.pojo.Battle;
import com.hdjd.grit.model.pojo.RO.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.Action;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author: yuan
 * @Date: 2020/3/27 12:42
 * @Version 1.0
 */
@Service
public class BattleService {
    private final BattleMapper battleMapper;

    @Autowired
    public BattleService(BattleMapper battleMapper){
        this.battleMapper = battleMapper;
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer insert(Battle battle){
        if (battle == null){
            throw  new ParameterException("参数异常");
        }
        String uuid = UUID.randomUUID().toString().replace("-", "");
        battle.setId(uuid);
        return battleMapper.insert(battle);
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer delete(String id){
        if (id == null){
            throw  new ParameterException("参数异常");
        }
        return battleMapper.deleteById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer update(Battle battle){
        if (battle.getId() == null){
            throw  new ParameterException("参数异常");
        }
        return battleMapper.updateById(battle);
    }

    public List<ExtendBattle> getBattles(){
        List<ExtendBattle> extendBattles = new ArrayList<>();
        List<Battle> battles = battleMapper.selectList(null);
        battles.forEach(battle -> {
            Location location = new Location(battle.getLongitude(), battle.getLatitude());
            ExtendBattle extendBattle = new ExtendBattle(battle.getId(), battle.getName(), location);
            extendBattles.add(extendBattle);
        });
        return extendBattles;
    }
}
