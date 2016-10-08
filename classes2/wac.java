import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;

public final class wac
  implements Runnable
{
  public wac(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantUtil", 2, "bulkGetStrangerPendantId, getStrangerInfo, size=" + AvatarPendantUtil.a.size());
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.a.a(1);
    if (localFriendListHandler != null)
    {
      String[] arrayOfString = new String[AvatarPendantUtil.a.size()];
      localFriendListHandler.a((String[])AvatarPendantUtil.a.toArray(arrayOfString), new int[] { 27201, 27025 });
      AvatarPendantUtil.a(System.currentTimeMillis());
    }
    AvatarPendantUtil.a.clear();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */