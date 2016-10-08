package com.rookery.translate.util;

import android.content.Context;
import com.rookery.translate.type.Language;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class LocaleUtil
{
  public LocaleUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static final String a(Context paramContext)
  {
    return Language.CHINESE_SIMPLIFIED.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\rookery\translate\util\LocaleUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */