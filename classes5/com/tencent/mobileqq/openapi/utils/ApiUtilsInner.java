package com.tencent.mobileqq.openapi.utils;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.QQText;

public class ApiUtilsInner
{
  public ApiUtilsInner()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static final int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1073741824;
    case -1037: 
    case -1000: 
      return 1;
    case -2002: 
      return 2;
    case -2000: 
      return 8;
    case -2007: 
      return 16;
    case -2020: 
      return 32;
    case -2005: 
      return 64;
    }
    return 4;
  }
  
  public static final int a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      switch (paramInt)
      {
      default: 
        return 1005;
      case 1003: 
        return 1007;
      }
      return 1006;
    }
    switch (paramInt)
    {
    default: 
      return 1001;
    case -1: 
      return 1000;
    case 2003: 
      return 1003;
    }
    return 1002;
  }
  
  public static final int a(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt)
  {
    return a(paramQQAppInterface, PttItemBuilder.a(paramQQAppInterface, paramMessageForPtt), paramMessageForPtt.isSendFromLocal());
  }
  
  public static final String a(int paramInt, QQMessageFacade.Message paramMessage)
  {
    switch (paramInt)
    {
    default: 
      return "[不支持显示的消息]";
    case 1: 
    case 4: 
      return new QQText(paramMessage.msg, 3).a();
    case 2: 
      return "[语音]";
    case 8: 
      return "[图片]";
    case 16: 
      return "[表情]";
    case 32: 
      return "[震动]";
    }
    return "[文件]";
  }
  
  public static final int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return 1;
    case 3000: 
      return 2;
    }
    return 4;
  }
  
  public static final int c(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 3: 
    default: 
      return 0;
    case 2: 
      return 3000;
    }
    return 1;
  }
  
  public boolean a(Context paramContext)
  {
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\openapi\utils\ApiUtilsInner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */