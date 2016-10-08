import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.CommonUtil;
import java.util.ArrayList;

public class lfo
  extends BroadcastReceiver
{
  public lfo(DirectForwardActivity paramDirectForwardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    if (paramIntent != null)
    {
      paramContext = paramIntent.getStringArrayList("procNameList");
      paramIntent = paramIntent.getString("verify");
      if ((paramContext != null) && (paramContext.size() != 0) && (this.a.f != null) && (CommonUtil.a(paramIntent, paramContext))) {
        break label53;
      }
    }
    for (;;)
    {
      return;
      label53:
      int i = 0;
      while (i < paramContext.size())
      {
        if (this.a.f.equals(paramContext.get(i)))
        {
          this.a.finish();
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */