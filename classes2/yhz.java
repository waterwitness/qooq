import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqhotspot.hotspotnode.HotSpotNodeUtil.LocationCallBack;
import cooperation.qqhotspot.ipc.QQHotSpotRemoteManager;

public class yhz
  implements HotSpotNodeUtil.LocationCallBack
{
  public yhz(QQHotSpotRemoteManager paramQQHotSpotRemoteManager, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "BusinessHandler_get_cur_location");
    localBundle.putInt("listinfoprotoex_seq", this.jdField_a_of_type_Int);
    localBundle.putBoolean("is_cooperateap_city", paramBoolean);
    localBundle.putString("city_name", paramString);
    QQHotSpotRemoteManager.a(this.jdField_a_of_type_CooperationQqhotspotIpcQQHotSpotRemoteManager, localBundle, true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yhz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */