package com.tencent.biz.qqstory.utils;

import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class NetworkUtils
{
  public NetworkUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static boolean a(Context paramContext)
  {
    return AppNetConnInfo.isNetSupport();
  }
  
  public static boolean b(Context paramContext)
  {
    return AppNetConnInfo.isNetSupport();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\utils\NetworkUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */