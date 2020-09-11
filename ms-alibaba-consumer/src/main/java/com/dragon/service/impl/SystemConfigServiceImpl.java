package com.dragon.service.impl;

import com.dragon.model.entity.SystemConfigPo;
import com.dragon.mapper.SystemConfigMapper;
import com.dragon.service.ISystemConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @ClassName: SystemConfigPo
 * @Description:  服务实现类
 * @since 2020-09-11
 */

@Service
public class SystemConfigServiceImpl extends ServiceImpl<SystemConfigMapper, SystemConfigPo> implements ISystemConfigService {

}
