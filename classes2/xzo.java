import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.c2b.C2BUploadFileActivity;
import java.util.TimerTask;

public class xzo
  extends TimerTask
{
  public xzo(C2BUploadFileActivity paramC2BUploadFileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a.runOnUiThread(new xzp(this));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */