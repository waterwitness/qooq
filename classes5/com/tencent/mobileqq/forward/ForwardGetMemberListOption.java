package com.tencent.mobileqq.forward;

import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ForwardGetMemberListOption
  extends ForwardBaseOption
{
  public static final String a = "ForwardOption.ForwardGetMemberListOption";
  public static final int b = 0;
  public static final int c = 1;
  public static final String g = "uinType";
  public static final String h = "uin";
  public static final String i = "selectMore";
  public static final String j = "title";
  
  public ForwardGetMemberListOption(Intent paramIntent)
  {
    super(paramIntent);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\forward\ForwardGetMemberListOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */