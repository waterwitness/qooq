import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.c2b.C2BTakePhotoActivity;
import java.util.TimerTask;

public class xzk
  extends TimerTask
{
  public xzk(C2BTakePhotoActivity paramC2BTakePhotoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.runOnUiThread(new xzl(this));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */