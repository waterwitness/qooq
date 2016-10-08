import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class mqq
  extends BroadcastReceiver
{
  public mqq(TroopInfoActivity paramTroopInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
      } while (!"changeGroupTribe".equals(paramIntent.getStringExtra("event")));
      paramContext = paramIntent.getStringExtra("data");
    } while (paramContext == null);
    try
    {
      paramContext = new JSONObject(paramContext);
      this.a.a.tribeId = paramContext.optInt("bid");
      this.a.a.tribeName = paramContext.optString("bname");
      this.a.f = true;
      paramContext = new ArrayList();
      if (!TextUtils.isEmpty(this.a.a.tribeName)) {
        paramContext.add(this.a.a.tribeName);
      }
      this.a.a(9, paramContext, true, 1, true);
      return;
    }
    catch (JSONException paramContext) {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mqq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */