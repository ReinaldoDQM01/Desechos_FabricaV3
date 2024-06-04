package actividad3.desechosfabrica.commons;

public class Response<T> {
  private boolean success;
  private String message;
  private T data;

  public Response(boolean success, String message, T data) {
    this.success = success;
    this.message = message;
    this.data = data;
  }

  public boolean isSucces() {
    return success;
  }

  public void setSucces(boolean success) {
    this.success = success;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

}
