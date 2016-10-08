import com.tencent.mobileqq.app.FriendAnniverManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.FriendAnniver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class pxs
  implements Runnable
{
  public pxs(FriendAnniverManager paramFriendAnniverManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ArrayList localArrayList = (ArrayList)FriendAnniverManager.a(this.a).a(FriendAnniver.class, false, null, null, null, null, null, null);
    if (localArrayList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendAnniverManager", 2, "initData|FriendAnniver.Size = " + localArrayList.size());
      }
      if (localArrayList.size() > 1) {
        throw new IllegalStateException("wrong FriendAnniver size with " + localArrayList.size());
      }
    }
    for (;;)
    {
      try
      {
        FriendAnniverManager.a(this.a, (FriendAnniver)localArrayList.get(0));
        ((FriendListHandler)FriendAnniverManager.a(this.a).a(1)).a(109, true, FriendAnniverManager.a(this.a));
        return;
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("FriendAnniverManager", 2, "initData|FriendAnniver is null");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pxs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */