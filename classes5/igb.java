import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class igb
  implements HttpWebCgiAsyncTask.Callback
{
  igb(iga paramiga)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramJSONObject != null) {
      if (QLog.isColorLevel()) {
        QLog.w("PublicAccountUtil", 2, "videoPlayRealtimeReport:return result :" + paramJSONObject);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("PublicAccountUtil", 2, "videoPlayRealtimeReport:return result null");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\igb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */