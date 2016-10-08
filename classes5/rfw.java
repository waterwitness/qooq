import android.content.SharedPreferences;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.CarrierHelper;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearpeople.NearbyRecommender.NearbyRecommenderUtils;
import java.util.List;

public class rfw
  implements Runnable
{
  public rfw(MsgBoxListActivity paramMsgBoxListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (MsgBoxListActivity.a(this.a) != null)
    {
      MsgBoxListActivity.a(this.a).a("msglist_carrier_5.8");
      this.a.a = MsgBoxListActivity.a(this.a).a();
      this.a.runOnUiThread(new rfx(this));
      long l = this.a.app.getPreferences().getLong("sp_key_dating_config_time", 0L);
      Object localObject;
      if (Math.abs(System.currentTimeMillis() - l) > 180000L)
      {
        localObject = (LBSHandler)this.a.app.a(3);
        if (localObject != null) {
          ((LBSHandler)localObject).a(null);
        }
      }
      if (NearbyRecommenderUtils.b(this.a.app))
      {
        localObject = NearbyRecommenderUtils.a(this.a.app, this.a.app.a());
        this.a.runOnUiThread(new rfy(this, (List)localObject));
        if (NearbyRecommenderUtils.a(this.a.app, 1))
        {
          localObject = (LBSHandler)this.a.app.a(3);
          if (localObject != null) {
            ((LBSHandler)localObject).a(1);
          }
        }
        NearbyRecommenderUtils.b(this.a.app);
      }
    }
    else
    {
      return;
    }
    this.a.runOnUiThread(new rfz(this));
    this.a.d = false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rfw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */