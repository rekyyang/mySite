package reky.server.domain.Result;
import java.io.Serializable;

public class Result implements Serializable{
    private static final long serialVersionUID = 1L;
    private boolean success;
    private String message;
    private Integer code;
    private Object data;

    public Result(){this.success = true;}

    public Result(Object data){
        this.data = data;
        this.success = true;
        this.code = 200;
    }

    public Result(boolean success, Integer code, String message){
        super();
        this.success = success;
        this.code = code;
        if(message != null){
            this.message = message;
        }
    }

    public static Result ok(){
        return new Result();
    }

    public static Result ok(Object data){
        if(data == null){
            throw new NullPointerException();
        }
        return new Result(data);
    }

    public static Result okMsg(String message) {
        return new Result(true,200, message);
    }

    public static Result fail(String message){
        if(message == null){
            message = "NullPointerException";
        }
        return new Result(false, 500, message);
    }

    public static Result fail(String message, Integer code){
        if(message == null){
            message = "NullPointerException";
        }
        return new Result(false,code, message);
    }

    public static Result fail(Throwable throwable){
        String s = throwable.getMessage();
        return fail(s);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setAll(String message, boolean success, Integer code) {
        this.success = success;
        if(message != null) {
            this.message = message;
        }
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
