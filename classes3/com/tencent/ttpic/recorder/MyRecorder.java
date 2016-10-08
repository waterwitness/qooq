package com.tencent.ttpic.recorder;

import android.annotation.TargetApi;
import android.hardware.Camera.Parameters;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import android.view.Surface;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.util.FrameRateUtil;
import com.tencent.ttpic.util.FrameRateUtil.DOWNGRADE_LEVEL;
import java.nio.ByteBuffer;

@TargetApi(18)
public class MyRecorder
{
  private static final String TAG = MyRecorder.class.getSimpleName();
  private MediaCodec.BufferInfo mBufferInfo = null;
  private MediaCodec mMediaCodec = null;
  private MediaMuxer mMediaMuxer = null;
  private boolean mMuxerStarted = false;
  private String mOutput;
  private Surface mSurface;
  private int mTotalSize = 0;
  private int mTrackIndex = -1;
  private final VideoParam mVideoParam = new VideoParam();
  
  public MyRecorder(Camera.Parameters paramParameters, String paramString)
  {
    this.mVideoParam.init(paramParameters);
    this.mOutput = paramString;
  }
  
  private void drainEncoder(boolean paramBoolean)
  {
    if (!isValid()) {
      return;
    }
    if (paramBoolean) {}
    int i;
    MediaFormat localMediaFormat;
    for (;;)
    {
      try
      {
        this.mMediaCodec.signalEndOfInputStream();
        ByteBuffer[] arrayOfByteBuffer = this.mMediaCodec.getOutputBuffers();
        i = this.mMediaCodec.dequeueOutputBuffer(this.mBufferInfo, 0L);
        if (i == -1)
        {
          if (paramBoolean) {
            continue;
          }
          return;
        }
        if (i == -3)
        {
          arrayOfByteBuffer = this.mMediaCodec.getOutputBuffers();
          continue;
        }
        if (i != -2) {
          break label154;
        }
        if (this.mMuxerStarted)
        {
          Log.e(TAG, "format changed twice");
          this.mMediaCodec.releaseOutputBuffer(i, false);
          continue;
        }
        localMediaFormat = this.mMediaCodec.getOutputFormat();
      }
      catch (RuntimeException localRuntimeException)
      {
        Log.e(TAG, localRuntimeException.toString());
        return;
      }
      this.mTrackIndex = this.mMediaMuxer.addTrack(localMediaFormat);
      this.mMediaMuxer.start();
      this.mMuxerStarted = true;
      continue;
      label154:
      localMediaFormat = localRuntimeException[i];
      if (localMediaFormat == null)
      {
        Log.e(TAG, "encoderOutputBuffer " + i + " was null");
        this.mMediaCodec.releaseOutputBuffer(i, false);
      }
      else
      {
        if ((this.mBufferInfo.flags & 0x2) != 0) {
          this.mBufferInfo.size = 0;
        }
        if (this.mBufferInfo.size == 0) {
          break label397;
        }
        if (this.mMuxerStarted) {
          break;
        }
        Log.e(TAG, "muxer hasn't started");
        this.mMediaCodec.releaseOutputBuffer(i, false);
      }
    }
    localMediaFormat.position(this.mBufferInfo.offset);
    localMediaFormat.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
    if (1 != 0)
    {
      long l = System.currentTimeMillis();
      this.mMediaMuxer.writeSampleData(this.mTrackIndex, localMediaFormat, this.mBufferInfo);
      this.mTotalSize += this.mBufferInfo.size;
      l = System.currentTimeMillis() - l;
      if (l > 50L) {
        Log.e("DEBUG", String.format("XXX: dt=%d, size=%.2f", new Object[] { Long.valueOf(l), Float.valueOf(this.mTotalSize / 1024.0F / 1024.0F) }));
      }
    }
    for (;;)
    {
      label397:
      this.mMediaCodec.releaseOutputBuffer(i, false);
      if ((this.mBufferInfo.flags & 0x4) == 0) {
        break;
      }
      return;
      this.mMediaMuxer.writeSampleData(this.mTrackIndex, localMediaFormat, this.mBufferInfo);
    }
  }
  
  private boolean isValid()
  {
    return (this.mMediaCodec != null) && (this.mMediaMuxer != null) && (this.mBufferInfo != null);
  }
  
  public Surface getInputSurface()
  {
    if ((this.mSurface == null) && (this.mMediaCodec != null)) {
      this.mSurface = this.mMediaCodec.createInputSurface();
    }
    return this.mSurface;
  }
  
  public String getOutputPath()
  {
    return this.mOutput;
  }
  
  public boolean isRecording()
  {
    return this.mMediaCodec != null;
  }
  
  public void prepareEncoder()
  {
    if (this.mMediaCodec != null)
    {
      Log.e(TAG, "prepareEncoder called twice?");
      return;
    }
    if (this.mVideoParam.mMime == null)
    {
      Log.e(TAG, "MIME type error!");
      return;
    }
    this.mBufferInfo = new MediaCodec.BufferInfo();
    try
    {
      MediaFormat localMediaFormat = MediaFormat.createVideoFormat(this.mVideoParam.mMime, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
      localMediaFormat.setInteger("color-format", 2130708361);
      localMediaFormat.setInteger("bitrate", FrameRateUtil.getRenderLevel().bps);
      localMediaFormat.setInteger("frame-rate", 18);
      localMediaFormat.setInteger("i-frame-interval", this.mVideoParam.mIfi);
      this.mMediaCodec = MediaCodec.createEncoderByType(this.mVideoParam.mMime);
      this.mMediaCodec.configure(localMediaFormat, null, null, 1);
      this.mMediaMuxer = new MediaMuxer(this.mOutput, 0);
      this.mMuxerStarted = false;
      return;
    }
    catch (Exception localException)
    {
      releaseEncoder();
      localException.printStackTrace();
    }
  }
  
  public void releaseEncoder()
  {
    try
    {
      if (this.mMediaCodec != null)
      {
        this.mMediaCodec.stop();
        this.mMediaCodec.release();
        this.mMediaCodec = null;
      }
      if (this.mMediaMuxer != null)
      {
        this.mMediaMuxer.stop();
        this.mMediaMuxer.release();
        this.mMediaMuxer = null;
      }
      this.mBufferInfo = null;
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.e(TAG, "releaseEncoder error!");
    }
  }
  
  public void start()
  {
    if (this.mMediaCodec != null) {
      this.mMediaCodec.start();
    }
  }
  
  public void stop()
  {
    drainEncoder(true);
    releaseEncoder();
  }
  
  public void swapBuffers()
  {
    if ((!isRecording()) || (!isValid())) {
      return;
    }
    drainEncoder(false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\recorder\MyRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */