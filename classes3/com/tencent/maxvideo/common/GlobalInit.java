package com.tencent.maxvideo.common;

import com.tencent.video.decode.ShortVideoSoLoad;

public class GlobalInit
{
  public static void loadLibrary(String paramString)
  {
    ShortVideoSoLoad.LoadExtractedShortVideoSo(paramString, null);
  }
  
  public static void loadLibraryWithFullPath(String paramString)
  {
    ShortVideoSoLoad.LoadExtractedShortVideo(paramString);
  }
  
  public static native boolean nativeAsyncProcessMsg(MessageStruct paramMessageStruct, Object paramObject);
  
  public static native boolean nativeSyncProcessMsg(MessageStruct paramMessageStruct1, MessageStruct paramMessageStruct2, Object paramObject);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\maxvideo\common\GlobalInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */