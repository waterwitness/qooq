package com.tencent.ttpic.util;

import com.tencent.ttpic.recorder.RetrieveDataListener.DATA_TYPE;

public class RetrieveDataUtil
{
  private static final TexSaveProcess mRGBATexSaveProcess = new RGBATexSaveProcess();
  private static final TexSaveProcess mYUVTexSaveProcess = new YUVTexSaveProcess();
  
  public static void clear()
  {
    mRGBATexSaveProcess.clear();
    mYUVTexSaveProcess.clear();
  }
  
  private static TexSaveProcess createTexSaveProcess(int paramInt)
  {
    if (paramInt == RetrieveDataListener.DATA_TYPE.RGBA.value) {
      return mRGBATexSaveProcess;
    }
    if (paramInt == RetrieveDataListener.DATA_TYPE.YUV.value) {
      return mYUVTexSaveProcess;
    }
    return null;
  }
  
  public static boolean isValid(int paramInt)
  {
    boolean bool2 = false;
    RetrieveDataListener.DATA_TYPE[] arrayOfDATA_TYPE = RetrieveDataListener.DATA_TYPE.values();
    int j = arrayOfDATA_TYPE.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfDATA_TYPE[i].value == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static byte[] retrieveData(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    TexSaveProcess localTexSaveProcess = createTexSaveProcess(paramInt1);
    if (localTexSaveProcess != null) {
      return localTexSaveProcess.retrieveData(paramInt2, paramInt3, paramInt4);
    }
    return new byte[0];
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\util\RetrieveDataUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */