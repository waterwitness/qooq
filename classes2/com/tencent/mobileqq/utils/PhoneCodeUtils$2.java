package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;

final class PhoneCodeUtils$2
  extends HashMap
{
  PhoneCodeUtils$2(int paramInt)
  {
    super(paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    put("zh-cn", "86");
    put("zh-hk", "852");
    put("zh-tw", "886");
    put("zh-sg", "853");
    put("en-us", "1");
    put("en-gb", "44");
    put("en-au", "61");
    put("en-ca", "1");
    put("ja-jp", "81");
    put("ko-kr", "82");
    put("pt-br", "55");
    put("pt-pt", "351");
    put("es-es", "34");
    put("de-de", "49");
    put("fr-fr", "33");
    put("it-it", "39");
    put("en-ph", "63");
    put("en-my", "60");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\PhoneCodeUtils$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */