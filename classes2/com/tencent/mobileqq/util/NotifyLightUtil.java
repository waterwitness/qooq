package com.tencent.mobileqq.util;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import java.util.Calendar;

public class NotifyLightUtil
{
  public NotifyLightUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static boolean a(Context paramContext, AppInterface paramAppInterface)
  {
    if ((SettingCloneUtil.readValue(paramContext, paramAppInterface.a(), paramContext.getString(2131368466), "qqsetting_notify_blncontrol_key", true)) && ((paramAppInterface.isBackground_Pause) || (!ReflectionUtil.a(BaseApplicationImpl.a))))
    {
      if (SettingCloneUtil.readValue(paramContext, null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", false))
      {
        int i = Calendar.getInstance().get(11);
        if ((i < 23) && (i >= 8)) {}
      }
    }
    else {
      return false;
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\util\NotifyLightUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */