import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.List;

public class tjh
  implements Runnable
{
  public tjh(ChooseInterestTagActivity paramChooseInterestTagActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    Object localObject2 = this.a.getSharedPreferences("dating_pref" + this.a.app.a(), 0);
    int j;
    int k;
    int i;
    if ((l - ((SharedPreferences)localObject2).getLong("list_last_update_time_" + ChooseInterestTagActivity.a(this.a), -1L) >= 3600000L) || (ChooseInterestTagActivity.a(this.a)))
    {
      if (NetworkUtil.e(this.a))
      {
        localObject1 = ChooseInterestTagActivity.a(this.a);
        j = ChooseInterestTagActivity.a(this.a);
        k = ChooseInterestTagActivity.b(this.a);
        if (ChooseInterestTagActivity.a(this.a)) {}
        for (i = 1;; i = 0)
        {
          ((NearbyCardHandler)localObject1).a("", j, k, 30, 0, i);
          return;
        }
      }
      ChooseInterestTagActivity.a(this.a).sendEmptyMessage(4099);
      return;
    }
    EntityManager localEntityManager = this.a.app.a().createEntityManager();
    Object localObject1 = localEntityManager.a(InterestTagInfo.class, true, "tagType = ?", new String[] { String.valueOf(ChooseInterestTagActivity.a(this.a)) }, null, null, null, String.valueOf(30));
    localEntityManager.a();
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      if (NetworkUtil.e(this.a))
      {
        localObject1 = ChooseInterestTagActivity.a(this.a);
        j = ChooseInterestTagActivity.a(this.a);
        k = ChooseInterestTagActivity.b(this.a);
        if (ChooseInterestTagActivity.a(this.a)) {}
        for (i = 1;; i = 0)
        {
          ((NearbyCardHandler)localObject1).a("", j, k, 30, 0, i);
          return;
        }
      }
      ChooseInterestTagActivity.a(this.a).sendEmptyMessage(4099);
      return;
    }
    ChooseInterestTagActivity.a(this.a, ((SharedPreferences)localObject2).getInt("list_fetch_pos_" + ChooseInterestTagActivity.a(this.a), ((List)localObject1).size()));
    localObject2 = Message.obtain();
    ((Message)localObject2).what = 4098;
    ((Message)localObject2).obj = localObject1;
    ChooseInterestTagActivity.a(this.a).sendMessage((Message)localObject2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tjh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */