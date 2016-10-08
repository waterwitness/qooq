import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.dingdong.DingdongJsApiPlugin;
import org.json.JSONException;
import org.json.JSONObject;

public class yan
  implements TroopMemberApiClient.Callback
{
  public yan(DingdongJsApiPlugin paramDingdongJsApiPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bundle paramBundle)
  {
    int i = 0;
    if (paramBundle != null)
    {
      boolean bool = paramBundle.getBoolean("CheckOpenIdResult", false);
      paramBundle = new JSONObject();
      if (bool) {
        i = 1;
      }
    }
    try
    {
      paramBundle.put("result", i);
      DingdongJsApiPlugin.a(this.a, paramBundle, 6);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */