import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqhotspot.hotspotnode.QQHotSpotListHandler.Callback;
import cooperation.qqhotspot.hotspotnode.protocol.pbsrc.APNodeCheckResult;
import cooperation.qqhotspot.ipc.QQHotSpotRemoteManager;
import java.io.Serializable;

public class yij
  implements QQHotSpotListHandler.Callback
{
  public yij(QQHotSpotRemoteManager paramQQHotSpotRemoteManager, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, APNodeCheckResult paramAPNodeCheckResult, Serializable paramSerializable)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "BusinessHandler_get_wifilist_fromsvr_bssid");
    localBundle.putBoolean("result", paramBoolean);
    localBundle.putSerializable("listinfoproto", paramAPNodeCheckResult);
    localBundle.putSerializable("listinfoprotoex", paramSerializable);
    localBundle.putInt("listinfoprotoex_seq", this.jdField_a_of_type_Int);
    localBundle.putBoolean("listinfoprotoex_cache", false);
    QQHotSpotRemoteManager.a(this.jdField_a_of_type_CooperationQqhotspotIpcQQHotSpotRemoteManager, localBundle, true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yij.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */