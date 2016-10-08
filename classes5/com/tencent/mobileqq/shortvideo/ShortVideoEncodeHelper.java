package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ShortVideoEncodeHelper
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 0;
  
  public ShortVideoEncodeHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public native int startMixWithBgAudio(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2);
  
  public native int startMixWithBgAudioWithStereo(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\ShortVideoEncodeHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */