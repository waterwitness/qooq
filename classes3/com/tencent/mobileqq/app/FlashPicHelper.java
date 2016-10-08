package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class FlashPicHelper
{
  static final String a = "FlashPicHelper";
  static final String b = "commen_flash_pic";
  
  public FlashPicHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null) {
      paramMessageRecord.saveExtInfoToExtStr("commen_flash_pic", "true");
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramMessageRecord.msgtype == 63536) {
      paramMessageRecord.saveExtInfoToExtStr("commen_flash_pic", paramBoolean + "");
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("FlashPicHelper", 4, "setFlashPicFlag,troopUin:" + paramMessageRecord.frienduin + ",isReaded:" + paramBoolean + ",msgType:" + paramMessageRecord.msgtype);
    }
  }
  
  public static boolean a(int paramInt, HotChatManager paramHotChatManager, String paramString)
  {
    return ((paramInt == 0) || (paramInt == 1) || (paramInt == 3000)) && (!paramHotChatManager.b(paramString));
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessageRecord != null) {
      if (paramMessageRecord.msgtype != 63536)
      {
        bool1 = bool2;
        if (paramMessageRecord.msgtype != 63530) {}
      }
      else
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("commen_flash_pic"))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    try
    {
      boolean bool = Boolean.valueOf(paramMessageRecord.getExtInfoFromExtStr("commen_flash_pic")).booleanValue();
      return bool;
    }
    catch (Exception paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\FlashPicHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */