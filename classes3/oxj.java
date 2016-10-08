import android.os.Bundle;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.qphone.base.util.QLog;

public class oxj
  extends GameCenterObserver
{
  public oxj(RecentCallHelper paramRecentCallHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHelper", 2, "WL_DEBUG GameCenterObserver.onReceive type = " + paramInt + ", isSuc = " + paramBoolean);
    }
    this.a.m();
    this.a.n();
    VideoMsgTools.a(this.a.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oxj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */