import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;

public class wdy
  extends Thread
{
  int jdField_a_of_type_Int;
  volatile boolean jdField_a_of_type_Boolean;
  
  wdy(HttpCommunicator paramHttpCommunicator)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void run() {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\wdy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */