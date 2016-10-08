import android.os.Handler;
import com.tencent.biz.pubaccount.PublicAccountManager.InitDoneObserver;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class oac
  implements PublicAccountManager.InitDoneObserver
{
  oac(oab paramoab)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    PublicAccountChatPie.b(this.a.a, false);
    this.a.a.a.sendEmptyMessage(1);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */