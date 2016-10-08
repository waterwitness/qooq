import SecurityAccountServer.RespondQueryQQBindingStat;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mybusiness.MyBusinessManager;

public class thc
  implements Runnable
{
  public thc(MyBusinessManager paramMyBusinessManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = ((PhoneContactManagerImp)this.a.a.getManager(10)).a();
    String str = "";
    int i = 0;
    if (localRespondQueryQQBindingStat != null)
    {
      str = localRespondQueryQQBindingStat.mobileNo;
      i = localRespondQueryQQBindingStat.type;
    }
    this.a.b(str, i, "");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\thc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */