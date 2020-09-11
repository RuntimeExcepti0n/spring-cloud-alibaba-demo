package handler;

import lombok.Data;

/**
 * @ClassName: BussinessException
 * @Description: 框架统一异常
 * @date: 2020/3/24
 */
@Data
public class BussinessException extends RuntimeException
{
    private static final long serialVersionUID = 7285964645196358092L;

    private String code;

    public BussinessException(String message) {
        super(message);
    }

    public BussinessException(String message, Throwable cause) {
        super(message, cause);
    }


    public BussinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BussinessException(Throwable cause) {
        super(cause);
    }
}
