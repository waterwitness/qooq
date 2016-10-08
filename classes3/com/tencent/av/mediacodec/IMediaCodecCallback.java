package com.tencent.av.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;

public abstract interface IMediaCodecCallback
{
  public abstract void onError(MediaCodec paramMediaCodec, Exception paramException);
  
  public abstract void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt);
  
  public abstract void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo);
  
  public abstract void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\mediacodec\IMediaCodecCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */