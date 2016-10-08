package com.tencent.maxvideo.mediadevice;

public class AudioSampleUtil
{
  public static int bytesInMillisecond(int paramInt1, int paramInt2, int paramInt3)
  {
    return bytesInSecond(paramInt1, paramInt2, paramInt3) / 1000;
  }
  
  public static int bytesInSecond(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    switch (paramInt2)
    {
    default: 
      paramInt2 = i;
      i = 1;
      switch (paramInt3)
      {
      default: 
        paramInt3 = i;
      }
      break;
    }
    for (;;)
    {
      return paramInt1 * paramInt3 * paramInt2;
      paramInt2 = 1;
      break;
      paramInt2 = 2;
      break;
      paramInt3 = 2;
      continue;
      paramInt3 = 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\maxvideo\mediadevice\AudioSampleUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */