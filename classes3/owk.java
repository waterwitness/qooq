import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class owk
  implements Runnable
{
  public owk(BannerManager paramBannerManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = ((QCallFacade)BannerManager.a(this.a).app.getManager(37)).a();
    if (i > 0) {
      if (!BannerManager.a(this.a).hasMessages(6)) {
        BannerManager.a(this.a).sendEmptyMessageDelayed(6, 0L);
      }
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.recent.banner", 4, "checkShowMissedCall.count=" + i);
      }
      return;
      BannerManager.a(this.a).sendEmptyMessageDelayed(7, 0L);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\owk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */