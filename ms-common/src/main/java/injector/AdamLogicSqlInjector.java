package injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.extension.injector.methods.LogicDeleteByIdWithFill;
import injector.method.LogicDeleteByIdsWithFill;
import injector.method.SaveAllInBatch;

import java.util.List;

/**
 * @author zhangjianghua1
 * @ClassName: MyLogicSqlInjector
 * @Description: 添加自定义mapper方法
 * @Copyright: 2020 www.baoneng.com Inc. All rights reserved. 注意：本内容仅限于宝能汽车公司内部传阅，禁止外泄以及用于其他的商业目的
 * @since 2020-06-22
 */
public class AdamLogicSqlInjector extends DefaultSqlInjector {
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
        methodList.add(new SaveAllInBatch());
        methodList.add(new LogicDeleteByIdWithFill());
        methodList.add(new LogicDeleteByIdsWithFill());
        return methodList;
    }
}
