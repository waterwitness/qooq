import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqhotspot.QQHotSpotHelper.HotSpotNodeAPInfo;
import cooperation.qqhotspot.hotspotnode.QQHotSpotListCacheHandler.Callback_WIFiId;
import cooperation.qqhotspot.ipc.QQHotSpotRemoteManager;

public class yih
  implements QQHotSpotListCacheHandler.Callback_WIFiId
{
  public yih(QQHotSpotRemoteManager paramQQHotSpotRemoteManager, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, QQHotSpotHelper.HotSpotNodeAPInfo paramHotSpotNodeAPInfo, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "BusinessHandler_get_wifilist_fromsvr_wifiid");
    localBundle.putBoolean("result", paramBoolean);
    localBundle.putSerializable("listinfoproto", paramHotSpotNodeAPInfo);
    localBundle.putString("listinfoprotoex", paramString);
    localBundle.putInt("listinfoprotoex_seq", this.jdField_a_of_type_Int);
    QQHotSpotRemoteManager.a(this.jdField_a_of_type_CooperationQqhotspotIpcQQHotSpotRemoteManager, localBundle, true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yih.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */