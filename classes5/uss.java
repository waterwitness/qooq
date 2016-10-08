import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.util.ShortVideoGuideUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;

public final class uss
  implements Runnable
{
  public uss()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      TVK_SDKMgr.installPlugin(BaseApplicationImpl.a().getApplicationContext(), new ust(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(ShortVideoGuideUtil.a, 2, "installSDK t==" + localThrowable.toString());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uss.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */