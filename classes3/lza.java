import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;
import mqq.os.MqqHandler;

public class lza
  implements Runnable
{
  public lza(PermisionPrivacyActivity paramPermisionPrivacyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = ((FriendsManager)this.a.app.getManager(50)).e();
    Object localObject = (PhoneContactManagerImp)this.a.app.getManager(10);
    int j = ((PhoneContactManagerImp)localObject).d();
    if ((((PhoneContactManagerImp)localObject).b()) || (j == 5)) {
      i = ((PhoneContactManagerImp)localObject).a(false).size() + i;
    }
    for (;;)
    {
      if (i > 0) {}
      for (localObject = i + "人";; localObject = "暂无")
      {
        ThreadManager.c().post(new lzb(this, (String)localObject));
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */