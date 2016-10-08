import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.huangye.download.HYDownloadAsyncTask;

public class ycz
  extends Handler
{
  private ycz()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    ycy localycy = (ycy)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    localycy.jdField_a_of_type_CooperationHuangyeDownloadHYDownloadAsyncTask.a(((cooperation.huangye.download.DownloadParams[])localycy.jdField_a_of_type_ArrayOfJavaLangObject)[0]);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ycz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */