package com.tencent.video.decode;

public class AVDecodeFactory
{
  public static final int TYPE_MP4_AVDECODE = 0;
  public static final int TYPE_YUV_AVDECODE = 1;
  
  public static AbstractAVDecode newDecode(AVDecodeOption paramAVDecodeOption)
  {
    if (paramAVDecodeOption.mDecodeType == 0) {
      return AVDecode.newInstance(paramAVDecodeOption);
    }
    if (paramAVDecodeOption.mDecodeType == 1) {
      return YuvAVDecode.newInstance(paramAVDecodeOption);
    }
    return null;
  }
  
  public static AbstractAVDecode newDecodeUncatched(AVDecodeOption paramAVDecodeOption)
    throws AVideoException
  {
    if (paramAVDecodeOption.mDecodeType == 0) {
      return AVDecode.newInstanceUncatched(paramAVDecodeOption);
    }
    if (paramAVDecodeOption.mDecodeType == 1) {
      return YuvAVDecode.newInstance(paramAVDecodeOption);
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\video\decode\AVDecodeFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */