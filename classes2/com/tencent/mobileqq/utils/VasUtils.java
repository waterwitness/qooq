package com.tencent.mobileqq.utils;

import com.etrump.mixlayout.FontManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public final class VasUtils
{
  private static int a;
  public static String a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "VasUtils";
    jdField_a_of_type_Int = 1000;
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    paramAppInterface = paramAppInterface.a(ChatActivity.class);
    if (paramAppInterface != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "refreshAIO");
      }
      paramAppInterface.removeMessages(16711697);
      paramAppInterface.sendMessageDelayed(paramAppInterface.obtainMessage(16711697), jdField_a_of_type_Int);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    int i3 = 1;
    GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)paramQQAppInterface.getManager(11);
    int i;
    int j;
    label45:
    int k;
    label58:
    int m;
    label71:
    int n;
    label84:
    int i1;
    label97:
    int i2;
    label110:
    boolean bool;
    if (localGameCenterManagerImp != null)
    {
      if (localGameCenterManagerImp.a("100005.100001") == -1) {
        break label245;
      }
      i = 1;
      if (i != 0)
      {
        if (localGameCenterManagerImp.a("100005.100003") == -1) {
          break label250;
        }
        j = 1;
        if (localGameCenterManagerImp.a("100005.100002") == -1) {
          break label255;
        }
        k = 1;
        if (localGameCenterManagerImp.a("100005.100006") == -1) {
          break label261;
        }
        m = 1;
        if (localGameCenterManagerImp.a("100005.100018") == -1) {
          break label267;
        }
        n = 1;
        if (localGameCenterManagerImp.a("100005.100020") == -1) {
          break label273;
        }
        i1 = 1;
        if (localGameCenterManagerImp.a("100005.100021") == -1) {
          break label279;
        }
        i2 = 1;
        bool = ((FontManager)paramQQAppInterface.getManager(41)).a;
        if (!bool) {
          break label295;
        }
        if (localGameCenterManagerImp.a("100005.100011") == -1) {
          break label285;
        }
        i = 1;
      }
    }
    for (;;)
    {
      label141:
      if (((bool) && (j == 0) && (k == 0) && (m == 0) && (i == 0) && (n == 0) && (i1 == 0) && (i2 == 0)) || ((!bool) && (j == 0) && (k == 0) && (m == 0) && (n == 0) && (i1 == 0) && (i2 == 0))) {
        if (localGameCenterManagerImp.a("100005") == -1) {
          break label290;
        }
      }
      label245:
      label250:
      label255:
      label261:
      label267:
      label273:
      label279:
      label285:
      label290:
      for (i = i3;; i = 0)
      {
        if (i != 0) {
          ((RedTouchManager)paramQQAppInterface.getManager(35)).b("100005");
        }
        return;
        i = 0;
        break;
        j = 0;
        break label45;
        k = 0;
        break label58;
        m = 0;
        break label71;
        n = 0;
        break label84;
        i1 = 0;
        break label97;
        i2 = 0;
        break label110;
        i = 0;
        break label141;
      }
      label295:
      i = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\VasUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */