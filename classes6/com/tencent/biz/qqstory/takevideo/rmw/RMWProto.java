package com.tencent.biz.qqstory.takevideo.rmw;

import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class RMWProto
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  public static final int h = 4;
  public static final int i = 5;
  public static final int j = 6;
  public static final int k = 7;
  public static final int l = 8;
  public static final int m = 9;
  public static final int n = 10;
  
  public RMWProto()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "BOOLEAN";
    case 1: 
      return "TRUE";
    }
    return "FALSE";
  }
  
  public static String a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return "OTHERS[" + paramMessage.what + "] - " + paramMessage.arg1;
    case 1: 
      return "ACTION_VISIBILITY - " + paramMessage.arg1;
    case 2: 
      return "ACTION_KEEP_SHOWING - " + a(paramMessage.arg1);
    case 3: 
      return "ACTION_PLAY_ANIMATION";
    case 4: 
      return "ACTION_STOP_ANIMATION";
    case 5: 
      return "ACTION_SET_PROGRESS";
    case 7: 
      return "ACTION_UI_EVENT_CLICK - " + b(paramMessage.arg1);
    case 8: 
      return "ACTION_UI_EVENT_LONG_CLICK - " + b(paramMessage.arg1);
    case 9: 
      return "ACTION_UI_EVENT_TOUCH - " + b(paramMessage.arg1);
    case 10: 
      return "ACTION_UI_VISIBILITY_CHANGED - " + paramMessage.arg1;
    }
    return "ACTION_SET_STUBMODE";
  }
  
  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "BOOLEAN";
    case 0: 
      return "UNREGISTER";
    }
    return "REGISTER";
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\rmw\RMWProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */