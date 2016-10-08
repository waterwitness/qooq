import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lio
  extends BroadcastReceiver
{
  public lio(FavEmosmManageActivity paramFavEmosmManageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.action.update.emotiom".equals(paramIntent.getAction()))
    {
      paramIntent = ((FavroamingDBManager)this.a.app.getManager(148)).a(200);
      paramContext = paramIntent;
      if (paramIntent == null) {
        paramContext = new ArrayList();
      }
    }
    try
    {
      Collections.reverse(paramContext);
      paramContext.add(0, new EmoticonInfo());
      FavEmosmManageActivity.a(this.a, paramContext);
      return;
    }
    catch (UnsupportedOperationException paramIntent)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FavEmoRoamingHandler", 2, paramIntent.getMessage());
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */