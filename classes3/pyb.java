import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQProfileItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;

public class pyb
  extends AccountObserver
{
  public pyb(FriendsManager paramFriendsManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onExchangeUin(String paramString1, String paramString2, String paramString3)
  {
    ThreadManager.b(new pyc(this, paramString2, paramString1));
  }
  
  public void onlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, boolean paramBoolean2, long paramLong, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "onlineStatusChanged isSuccess=" + paramBoolean1 + ",curStatus=" + paramStatus.toString() + ",isFriendListChang=" + paramBoolean2 + ",timeStamp=" + paramLong + ",isGatherListChange=" + paramBoolean3);
    }
    if (paramStatus == AppRuntime.Status.online) {
      FriendsManager.a(this.a).a(11L, false);
    }
    for (;;)
    {
      FriendsManager.a(this.a).a.a(paramBoolean2, paramLong, paramBoolean3);
      if (!paramBoolean2)
      {
        paramStatus = new QQProfileItem(FriendsManager.a(this.a));
        FriendsManager.a(this.a).a.a(101, paramStatus);
      }
      return;
      if (paramStatus == AppRuntime.Status.away) {
        FriendsManager.a(this.a).a(31L, false);
      } else if (paramStatus == AppRuntime.Status.invisiable) {
        FriendsManager.a(this.a).a(41L, false);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pyb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */