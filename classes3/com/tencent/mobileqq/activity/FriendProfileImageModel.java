package com.tencent.mobileqq.activity;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class FriendProfileImageModel
{
  public static final int h = 0;
  protected FriendProfileImageModel.InfoUpdateListener a;
  public FriendProfileImageModel.ProfileImageInfo a;
  public QQAppInterface a;
  public String b;
  protected int i;
  
  public FriendProfileImageModel(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.i = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public abstract int a();
  
  public Drawable a()
  {
    return null;
  }
  
  public FriendProfileImageModel.ProfileImageInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo;
  }
  
  public abstract FriendProfileImageModel.ProfileImageInfo a(int paramInt);
  
  public abstract void a(int paramInt);
  
  public void a(FriendProfileImageModel.InfoUpdateListener paramInfoUpdateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$InfoUpdateListener = paramInfoUpdateListener;
  }
  
  public abstract void a(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo);
  
  public abstract void a(BaseActivity paramBaseActivity);
  
  public abstract void a(BaseActivity paramBaseActivity, FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo);
  
  public int b()
  {
    return this.i;
  }
  
  public abstract void b(BaseActivity paramBaseActivity);
  
  public void c(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    if ((paramProfileImageInfo == this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$InfoUpdateListener != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$InfoUpdateListener.a(paramProfileImageInfo);
    }
  }
  
  public void d(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    if ((paramProfileImageInfo == this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$InfoUpdateListener != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$InfoUpdateListener.b(paramProfileImageInfo);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\FriendProfileImageModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */