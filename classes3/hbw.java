import com.tencent.av.utils.TipsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class hbw
  implements Runnable
{
  public hbw(TipsManager paramTipsManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "tipsRunnable");
    }
    this.a.a();
    if (this.a.b) {
      this.a.e();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hbw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */