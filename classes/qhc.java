import android.os.Looper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public final class qhc
  extends MqqHandler
{
  public qhc(Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void removeCallbacksAndMessages(Object paramObject)
  {
    if (paramObject == null)
    {
      QLog.e("TM.global", 1, "global SubHandler cannot excute removeCallbacksAndMessages");
      return;
    }
    super.removeCallbacksAndMessages(paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qhc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */