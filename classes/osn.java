import android.content.Intent;
import android.os.Bundle;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.qfileJumpActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticAssist;
import mqq.app.MobileQQ;

public class osn
  implements Runnable
{
  public osn(qfileJumpActivity paramqfileJumpActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    StatisticAssist.a(this.a.app.getApplication().getApplicationContext(), this.a.app.a(), "dl_share_my_pc");
    Intent localIntent = this.a.getIntent();
    Object localObject1 = null;
    try
    {
      localObject2 = localIntent.getExtras();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        localException.printStackTrace();
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new Bundle();
    }
    ((Bundle)localObject2).putString("leftBackText", "消息");
    ((Bundle)localObject2).putBoolean("isBack2Root", true);
    localObject1 = new Intent(this.a, LiteActivity.class);
    ((Intent)localObject1).addFlags(268435456);
    ((Intent)localObject1).addFlags(67108864);
    ((Intent)localObject1).putExtra("dataline_share_finish", false);
    ((Intent)localObject1).putExtras((Bundle)localObject2);
    ((Intent)localObject1).putExtra("targetUin", this.a.a);
    ((Intent)localObject1).putExtras(localIntent);
    ((Intent)localObject1).setAction(localIntent.getAction());
    ((Intent)localObject1).setType(localIntent.getType());
    this.a.startActivity((Intent)localObject1);
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\osn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */