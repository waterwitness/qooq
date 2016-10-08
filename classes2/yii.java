import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqhotspot.QQHotSpotHelper.HotSpotNodeAPInfo;
import cooperation.qqhotspot.QQHotSpotHelper.HotSpotNodeApEx;
import cooperation.qqhotspot.hotspotnode.QQHotSpotListCacheHandler.Callback;
import cooperation.qqhotspot.ipc.QQHotSpotRemoteManager;

public class yii
  implements QQHotSpotListCacheHandler.Callback
{
  public yii(QQHotSpotRemoteManager paramQQHotSpotRemoteManager, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, QQHotSpotHelper.HotSpotNodeAPInfo paramHotSpotNodeAPInfo, QQHotSpotHelper.HotSpotNodeApEx paramHotSpotNodeApEx)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "BusinessHandler_get_wifilist_fromsvr_bssid");
    localBundle.putBoolean("result", paramBoolean);
    localBundle.putSerializable("listinfoproto", paramHotSpotNodeAPInfo);
    localBundle.putSerializable("listinfoprotoex", paramHotSpotNodeApEx);
    localBundle.putInt("listinfoprotoex_seq", this.jdField_a_of_type_Int);
    localBundle.putBoolean("listinfoprotoex_cache", true);
    QQHotSpotRemoteManager.a(this.jdField_a_of_type_CooperationQqhotspotIpcQQHotSpotRemoteManager, localBundle, true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yii.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */