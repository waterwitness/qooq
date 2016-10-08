import android.os.Message;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.util.WeakReferenceHandler;

public class lkw
  implements Runnable
{
  public lkw(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int j = 0;
    Object localObject = (FriendsManager)this.a.app.getManager(50);
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label161;
      }
      localObject = new Card();
    }
    label161:
    for (int i = 1;; i = 0)
    {
      ((Card)localObject).feedPreviewTime = System.currentTimeMillis();
      ((Card)localObject).strQzoneFeedsDesc = "";
      Message localMessage = Message.obtain();
      localMessage.obj = localObject;
      if (i != 0) {}
      for (localMessage.what = 6;; localMessage.what = 5)
      {
        if (this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null) {
          this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(localMessage);
        }
        i = j;
        if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a != null) {
          i = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.g;
        }
        FriendProfileCardActivity.a(this.a, i);
        return;
        localObject = ((FriendsManager)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a);
        break;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lkw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */