import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.qphone.base.util.QLog;

public class olt
  extends GameCenterObserver
{
  public olt(MainAssistObserver paramMainAssistObserver)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((paramBoolean1) && (paramBoolean2) && (paramInt != 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainActivity", 2, "inform onGameCenterMsgReceive.type=" + paramInt);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MainAssistObserver", 2, "WL_DEBUG onGameCenterMsgReceive isSuccess = " + paramBoolean1 + ", hasNew = " + paramBoolean2 + ", type = " + paramInt);
      }
    }
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      return;
    case 0: 
      this.a.g();
      this.a.j();
      return;
    case 1: 
      this.a.g();
      this.a.j();
      return;
    case 4: 
      this.a.g();
      this.a.j();
      return;
    }
    this.a.g();
    this.a.e();
    this.a.f();
    this.a.j();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\olt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */