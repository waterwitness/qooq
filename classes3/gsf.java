import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gsf
  implements Runnable
{
  public gsf(DoubleVideoCtrlUI paramDoubleVideoCtrlUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      this.a.a.a(new Object[] { Integer.valueOf(102) });
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("DoubleVideoCtrlUI", 2, "mRootView.post(new Runnable()-->exception=" + localException.getMessage());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gsf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */