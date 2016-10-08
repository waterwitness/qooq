import com.tencent.mobileqq.activity.LebaListMgrActivity;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class lsa
  extends GameCenterObserver
{
  public lsa(LebaListMgrActivity paramLebaListMgrActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.mgr", 2, "onGameCenterMsgReceive. notifyData.");
    }
    if ((this.a.isResume()) && (paramBoolean1) && (paramInt != 2) && (LebaListMgrActivity.a(this.a) != null))
    {
      List localList = LebaShowListManager.a().a();
      this.a.runOnUiThread(new lsb(this, localList));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lsa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */