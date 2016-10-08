package com.tencent.mobileqq.systemmsg;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import uya;

public class FriendSystemMsgController
{
  private static FriendSystemMsgController jdField_a_of_type_ComTencentMobileqqSystemmsgFriendSystemMsgController;
  private long jdField_a_of_type_Long;
  private final String jdField_a_of_type_JavaLangString;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  
  public FriendSystemMsgController()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = FriendSystemMsgController.class.getName();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = -1L;
  }
  
  public static FriendSystemMsgController a()
  {
    if (jdField_a_of_type_ComTencentMobileqqSystemmsgFriendSystemMsgController == null) {
      jdField_a_of_type_ComTencentMobileqqSystemmsgFriendSystemMsgController = new FriendSystemMsgController();
    }
    return jdField_a_of_type_ComTencentMobileqqSystemmsgFriendSystemMsgController;
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public structmsg.StructMsg a(Long paramLong)
  {
    structmsg.StructMsg localStructMsg = null;
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      localStructMsg = (structmsg.StructMsg)this.jdField_a_of_type_JavaUtilHashMap.get(paramLong);
    }
    return localStructMsg;
  }
  
  public void a()
  {
    jdField_a_of_type_ComTencentMobileqqSystemmsgFriendSystemMsgController = null;
  }
  
  public void a(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void a(Long paramLong, structmsg.StructMsg paramStructMsg)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "putStructMsgToMap key=" + paramLong);
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramLong, paramStructMsg);
    }
  }
  
  public void a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_JavaLangString = paramQQAppInterface.a();
    paramQQAppInterface.a(new uya(this, paramQQAppInterface, paramBoolean));
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_b_of_type_JavaLangString != null) && (!this.jdField_b_of_type_JavaLangString.equals(paramQQAppInterface.a()))) {
      this.jdField_a_of_type_Boolean = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0).getBoolean("friend_system_msg_nomore_msg", false);
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\systemmsg\FriendSystemMsgController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */