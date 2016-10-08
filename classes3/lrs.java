import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class lrs
  extends ResourcePluginListener
{
  public lrs(Leba paramLeba)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(byte paramByte)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.lebatab.leba", 4, "ResourcePluginListener listener notify = " + paramByte);
    }
    if (paramByte != -1) {
      this.a.a.sendEmptyMessage(11340002);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lrs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */