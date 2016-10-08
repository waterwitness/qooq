import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.ChangeMachineManager;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class vog
  implements HttpWebCgiAsyncTask.Callback
{
  public vog(ChangeMachineManager paramChangeMachineManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.change_machine", 2, "getChangeMachineFlag result:" + paramJSONObject);
    }
    int j = 0;
    int k = -1;
    paramInt = k;
    int i = j;
    if (paramJSONObject != null)
    {
      if (paramJSONObject.has("code")) {
        break label81;
      }
      i = j;
      paramInt = k;
    }
    for (;;)
    {
      if ((paramInt == 0) && (i != 0)) {
        ChangeMachineManager.a(this.a);
      }
      return;
      label81:
      k = paramJSONObject.optInt("code");
      paramInt = k;
      i = j;
      if (k == 0)
      {
        i = paramJSONObject.optInt("flag");
        paramInt = k;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */