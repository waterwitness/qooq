package com.hiar.sdk.core;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class HiarqOptions
{
  public boolean filterEnable;
  public int recogQuality;
  public int trackingQuality;
  public boolean viewFinderEnable;
  public int[] viewFinderRect;
  
  public HiarqOptions()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\hiar\sdk\core\HiarqOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */