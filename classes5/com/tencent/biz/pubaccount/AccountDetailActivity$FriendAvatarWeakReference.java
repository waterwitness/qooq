package com.tencent.biz.pubaccount;

import android.os.AsyncTask;
import com.tencent.mobileqq.activity.FriendProfileImageAvatar;
import com.tencent.mobileqq.activity.FriendProfileImageModel.ProfileImageInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import hno;
import hnp;
import mqq.util.WeakReference;

public class AccountDetailActivity$FriendAvatarWeakReference
{
  public FriendProfileImageAvatar a;
  hnp jdField_a_of_type_Hnp;
  WeakReference jdField_a_of_type_MqqUtilWeakReference;
  
  public AccountDetailActivity$FriendAvatarWeakReference(QQAppInterface paramQQAppInterface, AccountDetailActivity paramAccountDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar = new FriendProfileImageAvatar(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.b = paramAccountDetailActivity.p;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAccountDetailActivity);
    this.jdField_a_of_type_Hnp = new hnp(paramAccountDetailActivity);
  }
  
  public void a()
  {
    FriendProfileImageModel.ProfileImageInfo localProfileImageInfo = new FriendProfileImageModel.ProfileImageInfo();
    localProfileImageInfo.e = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.b;
    localProfileImageInfo.a = null;
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.a((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get(), localProfileImageInfo);
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.a(this.jdField_a_of_type_Hnp);
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.b((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get());
    new hno(this, localProfileImageInfo).execute(new Void[0]);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.a(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.a((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\AccountDetailActivity$FriendAvatarWeakReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */