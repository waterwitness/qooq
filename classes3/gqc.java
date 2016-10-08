import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.BeautySettingUi;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gqc
  implements Runnable
{
  public gqc(BeautySettingUi paramBeautySettingUi)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.c = AVNotifyCenter.c(this.a.a.a());
    this.a.d(this.a.c);
    if (this.a.c > 0)
    {
      SessionInfo localSessionInfo = SessionMgr.a().a();
      if (localSessionInfo != null) {
        localSessionInfo.r = true;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gqc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */