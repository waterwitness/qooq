import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.kingkong.Common.Log;
import com.tencent.kingkong.PatchInfo;
import com.tencent.kingkong.UpdateManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONObject;

public class kfc
  extends Handler
{
  public kfc()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = paramMessage.getData();
    try
    {
      String str = paramMessage.getString("PATCH_JSON_STRING");
      boolean bool = paramMessage.getBoolean("PATCH_FORCE_UPDATE");
      paramMessage = PatchInfo.a(new JSONObject(str));
      if (paramMessage != null) {
        UpdateManager.a(paramMessage, bool);
      }
      return;
    }
    catch (Exception paramMessage)
    {
      Common.Log.a("KingKongUpdateManager", "Update patch exception : " + paramMessage);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\kfc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */