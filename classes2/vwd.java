import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troopreward.TroopRewardPayActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class vwd
  extends BroadcastReceiver
{
  public vwd(TroopRewardPayActivity paramTroopRewardPayActivity)
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
      } while (!"payEvent".equals(paramIntent.getStringExtra("event")));
      paramContext = paramIntent.getStringExtra("data");
    } while (paramContext == null);
    try
    {
      paramContext = new JSONObject(paramContext);
      switch (paramContext.optInt("step"))
      {
      case 2: 
        int i = paramContext.optInt("ret");
        paramContext = paramContext.optString("msg");
        paramIntent = new Intent();
        paramIntent.putExtra("ret", i);
        if (paramContext != null) {
          paramIntent.putExtra("msg", paramContext);
        }
        this.a.setResult(-1, paramIntent);
        this.a.finish();
        return;
      }
    }
    catch (JSONException paramContext)
    {
      paramContext = new Intent();
      paramContext.putExtra("ret", -1);
      this.a.setResult(-1, paramContext);
      this.a.finish();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vwd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */