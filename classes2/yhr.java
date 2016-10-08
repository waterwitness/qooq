import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqhotspot.hotspotnode.HotSpotNodeUtil.GetLocalWiFiListCallBack;
import cooperation.qqhotspot.hotspotnode.ShowNodeTaskManager;
import java.util.ArrayList;

public class yhr
  implements HotSpotNodeUtil.GetLocalWiFiListCallBack
{
  public yhr(ShowNodeTaskManager paramShowNodeTaskManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ArrayList paramArrayList)
  {
    ThreadManager.a(new yhs(this, paramArrayList), 5, null, true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yhr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */