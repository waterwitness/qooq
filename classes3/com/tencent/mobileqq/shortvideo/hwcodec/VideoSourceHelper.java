package com.tencent.mobileqq.shortvideo.hwcodec;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

public class VideoSourceHelper
{
  public static final int STATUS_ERROR = -1;
  public static final int STATUS_SUCCESS = 0;
  private boolean isInited = false;
  private long mAfFilePtr;
  private String mAfPath;
  private int mAudioBufferSize = 0;
  public int mChannel;
  private int mDestVideoHeight;
  private int mDestVideoWidth;
  public int mOrientationDegree = 0;
  public int mPCMFormat;
  public int mSampleRate;
  private long mTmpBufferPtr;
  private long mVfFilePtr;
  private String mVfPath;
  private int mVideoBufferSize = 0;
  
  public VideoSourceHelper(String paramString1, String paramString2)
  {
    this.mVfPath = paramString1;
    this.mAfPath = paramString2;
    this.isInited = false;
    this.mOrientationDegree = 0;
  }
  
  private native int nativeCloseHelper(long paramLong1, long paramLong2, long paramLong3);
  
  private native int nativeGetNextAudioFrame(byte[] paramArrayOfByte, int paramInt, long paramLong);
  
  private native int nativeGetNextVideoFrame(byte[] paramArrayOfByte, int paramInt1, long paramLong1, long[] paramArrayOfLong, long paramLong2, int paramInt2);
  
  private native int nativeGetNextVideoFrameBitmap(long paramLong1, Bitmap paramBitmap, long paramLong2);
  
  private native int nativeGetNextVideoFrameCache(long paramLong, ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, ByteBuffer paramByteBuffer3, boolean paramBoolean);
  
  private native int nativeInitHelper(String paramString1, String paramString2, long[] paramArrayOfLong, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3);
  
  private native int nativeResetSource(long paramLong1, long paramLong2);
  
  public static native int nativeSetMosaic(int paramInt, byte[] paramArrayOfByte);
  
  public static native int nativeSetPlayAFMute(boolean paramBoolean);
  
  public static native void nativeSetPlayMode(int paramInt);
  
  public static native int nativeSetSlideMode(int paramInt, float paramFloat);
  
  public void closeHelper()
  {
    if (!this.isInited) {
      return;
    }
    try
    {
      nativeCloseHelper(this.mVfFilePtr, this.mAfFilePtr, this.mTmpBufferPtr);
      this.isInited = false;
      this.mVfFilePtr = 0L;
      this.mAfFilePtr = 0L;
      this.mTmpBufferPtr = 0L;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
      }
    }
  }
  
  public int[] getBufferSize()
  {
    return new int[] { this.mVideoBufferSize, this.mAudioBufferSize };
  }
  
  public int getNextAudioFrame(byte[] paramArrayOfByte)
  {
    if (!this.isInited) {
      return -1;
    }
    return nativeGetNextAudioFrame(paramArrayOfByte, paramArrayOfByte.length, this.mAfFilePtr);
  }
  
  public int getNextVideoFrame(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, ByteBuffer paramByteBuffer3, boolean paramBoolean)
  {
    if (!this.isInited) {
      return -1;
    }
    try
    {
      int i = nativeGetNextVideoFrameCache(this.mVfFilePtr, paramByteBuffer1, paramByteBuffer2, paramByteBuffer3, paramBoolean);
      return i;
    }
    catch (UnsatisfiedLinkError paramByteBuffer1)
    {
      paramByteBuffer1.printStackTrace();
    }
    return 0;
  }
  
  public int getNextVideoFrame(byte[] paramArrayOfByte, long[] paramArrayOfLong, int paramInt)
  {
    if ((!this.isInited) || (paramArrayOfLong.length < 1)) {
      return -1;
    }
    return nativeGetNextVideoFrame(paramArrayOfByte, paramArrayOfByte.length, this.mVfFilePtr, paramArrayOfLong, this.mTmpBufferPtr, paramInt);
  }
  
  public int getNextVideoFrameBitmap(Bitmap paramBitmap)
  {
    if (!this.isInited) {
      return -1;
    }
    try
    {
      int i = nativeGetNextVideoFrameBitmap(this.mVfFilePtr, paramBitmap, this.mTmpBufferPtr);
      return i;
    }
    catch (UnsatisfiedLinkError paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
    return 0;
  }
  
  public int[] getSourceVideoParam()
  {
    return new int[] { this.mDestVideoWidth, this.mDestVideoHeight };
  }
  
  public int initHelperParam()
  {
    long[] arrayOfLong = new long[3];
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[3];
    int[] arrayOfInt3 = new int[3];
    int i = -1;
    try
    {
      int j = nativeInitHelper(this.mVfPath, this.mAfPath, arrayOfLong, arrayOfInt1, arrayOfInt2, arrayOfInt3);
      i = j;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
        continue;
        this.mChannel = 3;
        continue;
        this.mPCMFormat = 2;
      }
    }
    if (i == 0)
    {
      this.mVfFilePtr = arrayOfLong[0];
      this.mAfFilePtr = arrayOfLong[1];
      this.mTmpBufferPtr = arrayOfLong[2];
      this.mVideoBufferSize = arrayOfInt1[0];
      this.mAudioBufferSize = 4000;
      this.mDestVideoWidth = arrayOfInt2[0];
      this.mDestVideoHeight = arrayOfInt2[1];
      this.mOrientationDegree = arrayOfInt2[2];
      this.mSampleRate = arrayOfInt3[0];
      if (arrayOfInt3[1] == 1)
      {
        this.mChannel = 2;
        if (arrayOfInt3[2] != 0) {
          break label163;
        }
        this.mPCMFormat = 3;
        this.isInited = true;
      }
    }
    else
    {
      return i;
    }
  }
  
  public int resetDataSource()
  {
    int i = -1;
    if (!this.isInited) {
      return -1;
    }
    try
    {
      int j = nativeResetSource(this.mVfFilePtr, this.mAfFilePtr);
      i = j;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
      }
    }
    return i;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\shortvideo\hwcodec\VideoSourceHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */