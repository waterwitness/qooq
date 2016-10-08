import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import friendlist.GetOnlineInfoResp;

public class ljz
  extends FriendListObserver
{
  public ljz(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (TextUtils.equals(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a, paramString))) {
      this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.e(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a.equals(String.valueOf(paramObject))))
    {
      this.a.a(2131367531, 2);
      this.a.finish();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a)) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt)
  {
    Object localObject1 = null;
    if ((!paramBoolean) || (paramString == null) || (paramString.length() == 0)) {}
    Object localObject2;
    label57:
    label221:
    label223:
    do
    {
      return;
      if (ProfileActivity.AllInOne.h(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a))
      {
        localObject2 = (PhoneContactManager)this.a.app.getManager(10);
        if (localObject2 == null)
        {
          if ((localObject1 == null) || (((PhoneContact)localObject1).mobileNo == null) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a == null) || (!((PhoneContact)localObject1).mobileNo.equals(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a))) {
            break label221;
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateAddFriend, uin: " + paramString + ", pc.mobileNo = " + ((PhoneContact)localObject1).mobileNo);
          }
          localObject1 = this.a.a(paramString, FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a));
          localObject2 = Message.obtain();
          ((Message)localObject2).what = 3;
          if (localObject1 != null) {
            break label223;
          }
        }
        for (;;)
        {
          ((Message)localObject2).obj = paramString;
          this.a.b.sendMessage((Message)localObject2);
          return;
          localObject1 = ((PhoneContactManager)localObject2).a(paramString);
          break label57;
          break;
          paramString = (String)localObject1;
        }
      }
    } while ((paramString == null) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a == null) || (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a)));
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateAddFriend, uin: " + paramString);
    }
    localObject1 = (FriendsManager)this.a.app.getManager(50);
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = Message.obtain();
      ((Message)localObject2).what = 3;
      if (localObject1 != null) {
        break label381;
      }
    }
    for (;;)
    {
      ((Message)localObject2).obj = paramString;
      this.a.b.sendMessage((Message)localObject2);
      return;
      localObject1 = ((FriendsManager)localObject1).a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a);
      break;
      label381:
      paramString = (String)localObject1;
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a != null))
    {
      localObject2 = (FriendsManager)this.a.app.getManager(50);
      if (!ProfileActivity.AllInOne.b(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a)) {
        break label113;
      }
      if (localObject2 != null)
      {
        localObject2 = ((FriendsManager)localObject2).c(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a);
        if (localObject2 != null)
        {
          localObject1 = "";
          if (((Friends)localObject2).remark != null) {
            localObject1 = ((Friends)localObject2).remark;
          }
          this.a.c((String)localObject1);
        }
      }
    }
    label113:
    do
    {
      for (;;)
      {
        return;
        if (!ProfileActivity.AllInOne.h(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a)) {
          break;
        }
        localObject1 = (PhoneContactManager)this.a.app.getManager(10);
        if (localObject1 == null) {}
        for (localObject1 = null; (localObject2 != null) && (localObject1 != null) && (((FriendsManager)localObject2).b(((PhoneContact)localObject1).uin)); localObject1 = ((PhoneContactManager)localObject1).c(FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateFriendList, pc.uin: " + ((PhoneContact)localObject1).uin);
          }
          localObject3 = this.a.a(((PhoneContact)localObject1).uin, FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a));
          Message localMessage = Message.obtain();
          localMessage.what = 3;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = ((PhoneContact)localObject1).uin;
          }
          localMessage.obj = localObject2;
          this.a.b.sendMessage(localMessage);
          return;
        }
      }
    } while ((localObject2 == null) || (!((FriendsManager)localObject2).b(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a)) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a.equals(this.a.app.a())));
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateFriendList, cardInfo.allinone.uin: " + this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a);
    }
    Object localObject2 = ((FriendsManager)localObject2).a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a);
    Object localObject3 = Message.obtain();
    ((Message)localObject3).what = 3;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a;
    }
    ((Message)localObject3).obj = localObject1;
    this.a.b.sendMessage((Message)localObject3);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((!paramBoolean1) || (!paramBoolean2) || (!paramBoolean3)) {}
    Object localObject;
    do
    {
      return;
      paramBundle = paramBundle.getString("result_uin");
      if ((ProfileActivity.AllInOne.h(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a)) && (FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a).equals(paramString)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateAddFriend, uin: " + paramBundle + ", mobileNum = " + paramString);
        }
        localObject = this.a.a(paramBundle, FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a));
        Message localMessage = Message.obtain();
        localMessage.what = 3;
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = paramBundle;
        }
        localMessage.obj = paramString;
        this.a.b.sendMessage(localMessage);
        return;
      }
    } while ((paramBundle == null) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a == null) || (!paramBundle.equalsIgnoreCase(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a)));
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateAddFriend, uin: " + paramBundle + ", mobileNum = " + paramString);
    }
    paramString = (FriendsManager)this.a.app.getManager(50);
    if (paramString == null)
    {
      paramString = null;
      localObject = Message.obtain();
      ((Message)localObject).what = 3;
      if (paramString != null) {
        break label336;
      }
    }
    for (;;)
    {
      ((Message)localObject).obj = paramBundle;
      this.a.b.sendMessage((Message)localObject);
      return;
      paramString = paramString.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a);
      break;
      label336:
      paramBundle = paramString;
    }
  }
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    int j;
    int i;
    if ((paramBoolean) && (paramArrayOfString != null))
    {
      j = paramArrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        if ((paramArrayOfString[i] == null) || (!paramArrayOfString[i].equals(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a))) {
          break label99;
        }
        paramArrayOfString = ((FriendsManager)this.a.app.getManager(50)).a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a);
        if (paramArrayOfString != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(paramArrayOfString.getRichStatus());
        }
      }
      return;
      label99:
      i += 1;
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a.equals(this.a.app.a()))
    {
      ExtensionInfo localExtensionInfo = ((FriendsManager)this.a.app.getManager(50)).a(this.a.app.a());
      if (localExtensionInfo != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setNewSignature(localExtensionInfo.richBuffer, localExtensionInfo.richTime);
      }
    }
  }
  
  protected void b(boolean paramBoolean, String[] paramArrayOfString)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.e(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
    }
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "onUpdateMobileQQHead() mobileNumber = " + paramString);
    }
    if ((!paramBoolean) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a == null)) {}
    String str;
    do
    {
      return;
      str = FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a);
    } while ((str == null) || (!str.equals(paramString)) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null));
    this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a, 1, str, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ljz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */