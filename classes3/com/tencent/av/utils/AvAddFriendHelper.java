package com.tencent.av.utils;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import hau;

public class AvAddFriendHelper
{
  public BroadcastReceiver a;
  public VideoAppInterface a;
  public AvAddFriendHelper.IAvAddFriendCallBack a;
  
  public AvAddFriendHelper(VideoAppInterface paramVideoAppInterface, AvAddFriendHelper.IAvAddFriendCallBack paramIAvAddFriendCallBack)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper$IAvAddFriendCallBack = null;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new hau(this);
    IntentFilter localIntentFilter = new IntentFilter("tencent.video.q2v.AddfrindMsg");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper$IAvAddFriendCallBack = paramIAvAddFriendCallBack;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  public int a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c(paramString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper$IAvAddFriendCallBack = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(paramString);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(paramString, paramInt);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.g();
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c(paramString);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.h();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\utils\AvAddFriendHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */