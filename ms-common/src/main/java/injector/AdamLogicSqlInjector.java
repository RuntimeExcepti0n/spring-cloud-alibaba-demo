package injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.extension.injector.methods.LogicDeleteByIdWithFill;
import injector.method.LogicDeleteByIdsWithFill;
import injector.method.SaveAllInBatch;

import java.util.List;

/**
 * @ClassName: MyLogicSqlInjector
 * @Description: 添加自定义mapper方法
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
