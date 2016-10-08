import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqhotspot.hotspotnode.HotSpotNodeUtil.LocationCallBack;
import cooperation.qqhotspot.hotspotnode.ShowNodeTaskManager;

public class yhn
  implements HotSpotNodeUtil.LocationCallBack
{
  public yhn(ShowNodeTaskManager paramShowNodeTaskManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    ThreadManager.a(new yho(this, paramBoolean, paramString), 5, null, true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yhn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */