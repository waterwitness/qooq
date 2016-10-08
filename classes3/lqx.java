import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.LebaUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class lqx
  extends GameCenterObserver
{
  public lqx(Leba paramLeba)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((!paramBoolean1) || (paramInt == 2)) {}
    for (;;)
    {
      return;
      if (Leba.b(this.a))
      {
        ArrayList localArrayList = new ArrayList();
        LebaUtil.a(localArrayList, LebaShowListManager.a().a(this.a.a));
        this.a.b(new lqy(this, localArrayList));
      }
      while (QLog.isColorLevel())
      {
        QLog.i("Q.lebatab.leba", 2, "onGameCenterMsgReceive, " + Leba.c(this.a));
        return;
        LebaShowListManager.d |= 0x2;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lqx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */