import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nyn
  implements Runnable
{
  public nyn(HotChatPie paramHotChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ConfigServlet.a(this.a.a, this.a.a.getAccount(), -1);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nyn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */