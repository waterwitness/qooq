import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.trick.TrickHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class vcr
  implements Runnable
{
  public vcr(TrickHelper paramTrickHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TrickHelper", 2, "Runnable tricking=" + TrickHelper.a + ",needCheck=" + TrickHelper.b);
    }
    if ((TrickHelper.b) && (!TrickHelper.a(this.a))) {
      ThreadManager.a().postDelayed(this, 2000L);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\vcr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */