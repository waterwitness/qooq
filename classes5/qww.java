import com.tencent.mobileqq.businessCard.helpers.CameraHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qww
  extends Thread
{
  static final long jdField_a_of_type_Long = 3000L;
  
  public qww(CameraHelper paramCameraHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    try
    {
      CameraHelper.a().c();
      return;
    }
    finally {}
  }
  
  public void run()
  {
    try
    {
      for (;;)
      {
        Thread.sleep(3000L);
        try
        {
          a();
        }
        catch (RuntimeException localRuntimeException) {}
      }
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qww.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */