package com.tencent.mobileqq.struct;

import android.graphics.Bitmap;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class NearbyPushBanner
  extends PushBanner
{
  public Bitmap a;
  
  public NearbyPushBanner(long paramLong, String paramString, short paramShort)
  {
    super(paramLong, paramString, paramShort);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\struct\NearbyPushBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */