import android.content.Intent;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class gnm
  extends FriendListObserver
{
  public gnm(QQServiceForAV paramQQServiceForAV)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("QQServiceForAV", 2, "WL_DEBUG onUpdateFriendInfo uin = " + paramString);
      QLog.d("QQServiceForAV", 2, "WL_DEBUG onUpdateFriendInfo isSuccess = " + paramBoolean);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    Intent localIntent;
    if ((paramBoolean) && (paramString != null))
    {
      localIntent = new Intent();
      localIntent.setAction("tencent.video.q2v.ACTION_ON_UPDATE_FRIEND_INFO");
      localIntent.putExtra("uin", paramString);
      localObject = (FriendsManager)QQServiceForAV.m(this.a).getManager(50);
      if (localObject == null) {
        break label235;
      }
      localObject = ((FriendsManager)localObject).c(paramString);
      if (localObject == null) {
        break label235;
      }
    }
    label235:
    for (Object localObject = ContactUtils.a((Friends)localObject);; localObject = paramString)
    {
      localIntent.putExtra("nick", (String)localObject);
      localIntent.setPackage(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getPackageName());
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
      this.a.jdField_a_of_type_JavaUtilArrayList.remove(paramString);
      if (this.a.b()) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      }
      return;
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    Intent localIntent = new Intent("com.tencent.qqhead.getheadresp2");
    localIntent.putExtra("uin", paramString);
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    if (this.a.b.contains(paramString)) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
    }
    this.a.b.remove(paramString);
    if (this.a.b()) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gnm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */