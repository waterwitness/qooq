import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqhotspot.hotspotnode.HotSpotNodeUtil.GetLocalWiFiListCallBack;
import cooperation.qqhotspot.hotspotnode.QQHotSpotWiFiScanTool.Callback;
import java.util.ArrayList;
import java.util.List;

public final class yhg
  implements QQHotSpotWiFiScanTool.Callback
{
  public yhg(HotSpotNodeUtil.GetLocalWiFiListCallBack paramGetLocalWiFiListCallBack)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, List paramList)
  {
    if (this.a != null) {
      this.a.a((ArrayList)paramList);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yhg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */