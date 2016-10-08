package com.tencent.video.decode;

import android.graphics.Bitmap;

public abstract class AbstractAVDecode
{
  public static final int STREAM_AUDIO = 1096108367;
  public static final int STREAM_VIDEO = 1447642447;
  public static boolean soLoaded = false;
  public final AVAudioParam audioParam = new AVAudioParam();
  public final AVVideoParam videoParam = new AVVideoParam();
  
  static void checkSoLoaded()
  {
    if (!soLoaded) {
      AVDecodeError.throwException(65334);
    }
  }
  
  public abstract void close();
  
  public abstract void resetVideoPlayer(AVDecodeOption paramAVDecodeOption);
  
  public abstract byte[] seekToNextAudioByteFrame()
    throws AVideoException;
  
  public abstract float[] seekToNextAudioFloatFrame()
    throws AVideoException;
  
  public abstract short[] seekToNextAudioShortFrame()
    throws AVideoException;
  
  public abstract void seekToNextFrame(Bitmap paramBitmap)
    throws AVideoException;
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\video\decode\AbstractAVDecode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */