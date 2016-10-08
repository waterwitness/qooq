import android.os.Bundle;
import com.facebook.react.bridge.Callback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class hwf
  implements HttpWebCgiAsyncTask.Callback
{
  hwf(hwe paramhwe)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    QLog.w("ReadInjoyNetworkingModule", 2, Long.toString(Thread.currentThread().getId()));
    if (paramJSONObject != null)
    {
      this.a.a.invoke(new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt), paramJSONObject.toString() });
      if (QLog.isColorLevel()) {
        QLog.w("ReadInjoyNetworkingModule", 2, "doSendRequestWithExtraHeader:return result :" + paramJSONObject);
      }
    }
    do
    {
      return;
      this.a.a.invoke(new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt), "" });
    } while (!QLog.isColorLevel());
    QLog.w("ReadInjoyNetworkingModule", 2, "doSendRequestWithExtraHeader:return result null");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hwf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */