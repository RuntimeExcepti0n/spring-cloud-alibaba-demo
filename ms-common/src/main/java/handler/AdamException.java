package handler;

import lombok.Data;

/**
 * @ClassName: AdamException
 * @Description: 框架统一异常
 * @author: hao.xinyue
 * @date: 2020/3/24
 * @Copyright: 2020 www.baoneng.com Inc. All rights reserved. 注意：本内容仅限于宝能汽车公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Data
public class AdamException extends RuntimeException
{
    private static final long serialVersionUID = 7285964645196358092L;

    private String code;

    public AdamException(String message) {
        super(message);
    }

    public AdamException(String message, Throwable cause) {
        super(message, cause);
    }


    public AdamException(String code, String message) {
        super(message);
        this.code = code;
    }

    public AdamException(Throwable cause) {
        super(cause);
    }
}
