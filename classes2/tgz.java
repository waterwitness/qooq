import MyCarrier.Carrier;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mybusiness.MyBusinessManager;
import com.tencent.mobileqq.mybusiness.MyBusinessObserver;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class tgz
  extends MyBusinessObserver
{
  public tgz(MyBusinessManager paramMyBusinessManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, Carrier paramCarrier, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MyBusinessManager", 4, "onCarrierQuery refreshTimeSpan = " + paramInt);
    }
    this.a.a = paramInt;
    if (this.a.a > 86400) {
      this.a.a = 86400;
    }
    if (!paramBoolean)
    {
      this.a.b = false;
      return;
    }
    ThreadManager.a().post(new tha(this, paramCarrier));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tgz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */