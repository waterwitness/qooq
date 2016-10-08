package com.tencent.mobileqq.emosm.web;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;

final class IPCConstants$1
  extends HashMap
{
  IPCConstants$1()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    put("queryFontInfo", Integer.valueOf(2));
    put("setupChatFont", Integer.valueOf(1));
    put("font_startDownLoad", Integer.valueOf(3));
    put("font_StopDownLoad", Integer.valueOf(4));
    put("queryBubbleInfo", Integer.valueOf(6));
    put("bubble_startDownLoad", Integer.valueOf(5));
    put("bubble_StopDownLoad", Integer.valueOf(7));
    put("setFontSwtich", Integer.valueOf(8));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emosm\web\IPCConstants$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */