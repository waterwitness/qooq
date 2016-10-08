import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;

public final class ppx
  implements Runnable
{
  public ppx(AppInterface paramAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    List localList;
    if (this.a != null)
    {
      localList = ((ApolloDaoManager)this.a.getManager(154)).a();
      boolean bool = this.a.getApplication().getSharedPreferences("apollo_sp", 0).getBoolean("6.5.5" + this.a.a(), false);
      if ((localList == null) || (localList.size() == 0) || (!bool)) {
        ((ApolloManager)this.a.getManager(152)).a();
      }
    }
    else
    {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("checkApolloPanelJsonCfg json have been parsed action size: ");
    if (localList == null) {}
    for (int i = 0;; i = localList.size())
    {
      QLog.d("ApolloManager", 1, i);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ppx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */