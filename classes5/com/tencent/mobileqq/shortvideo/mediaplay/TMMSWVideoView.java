package com.tencent.mobileqq.shortvideo.mediaplay;

import android.content.Context;
import android.media.AudioTrack;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.maxvideo.mediaplay.TMMNativeVideoPlayer;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import urw;
import urx;
import ury;
import urz;
import usa;
import usb;
import usc;
import usd;
import use;

public class TMMSWVideoView
  extends TMMVideoView
  implements GLSurfaceView.Renderer, SurfaceHolder.Callback
{
  public static final String TAG = "TMMSWVideoView";
  private int frames;
  private boolean glExitCheckInited;
  private boolean glExitCheckValue;
  AudioTrack mAudioTrack;
  long mCurFrameRenderTime;
  GLSurfaceView mGLSurfaceView;
  private Handler mHandler;
  public boolean mIsQQ;
  public TMMNativeVideoPlayer mNativeVideoPlayer;
  public TMMSWVideoView.OnSurfaceListener mOnSurfaceListener;
  long mRenderTotalFrames;
  long mRenderTotalTime;
  long mStartPlayTime;
  boolean mSurfaceIsReady;
  TextView mTextViewAveragePlayerFPS;
  TextView mTextViewAverageRenderFPS;
  TextView mTextViewCurRenderFPS;
  String mVideoPath;
  private int times;
  
  public TMMSWVideoView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mIsQQ = true;
    this.mSurfaceIsReady = false;
    init();
  }
  
  public TMMSWVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mIsQQ = true;
    this.mSurfaceIsReady = false;
    init();
  }
  
  public TMMSWVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mIsQQ = true;
    this.mSurfaceIsReady = false;
    init();
  }
  
  private Object getFieldValue(Object paramObject, String paramString)
  {
    Object localObject = null;
    try
    {
      Class localClass = paramObject.getClass();
      if (localClass != null)
      {
        paramString = localClass.getDeclaredField(paramString);
        paramString.setAccessible(true);
        localObject = paramString.get(paramObject);
      }
      return localObject;
    }
    catch (Throwable paramObject) {}
    return null;
  }
  
  private void init()
  {
    this.glExitCheckInited = true;
    this.glExitCheckValue = true;
    this.mHandler = new Handler();
    setBackgroundColor(-16777216);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.mGLSurfaceView = new GLSurfaceView(getContext());
    this.mGLSurfaceView.setEGLContextClientVersion(2);
    addView(this.mGLSurfaceView, localLayoutParams);
    this.mGLSurfaceView.getHolder().addCallback(this);
    this.mGLSurfaceView.setRenderer(this);
    this.mGLSurfaceView.setRenderMode(0);
    this.mGLSurfaceView.getHolder().setFormat(1);
    this.mNativeVideoPlayer = new TMMNativeVideoPlayer();
    this.mGLSurfaceView.queueEvent(new urw(this));
  }
  
  private void updateTextViewFPS() {}
  
  public void ProcessMsg(MessageStruct paramMessageStruct)
  {
    switch (paramMessageStruct.mId)
    {
    }
    do
    {
      do
      {
        Object localObject;
        do
        {
          do
          {
            for (;;)
            {
              return;
              if (QLog.isColorLevel()) {
                QLog.d("TMMSWVideoView", 2, "[@][ProcessMsg][MSG_VIDEOPLAYER_RENDER_FRAME]mSurfaceIsReady=" + this.mSurfaceIsReady);
              }
              if ((this.mSurfaceIsReady) && (this.mGLSurfaceView != null))
              {
                this.mGLSurfaceView.requestRender();
                return;
                if (this.mAudioTrack != null)
                {
                  this.mAudioTrack.release();
                  this.mAudioTrack = null;
                }
                paramMessageStruct = (AVIOStruct)paramMessageStruct.mObj0;
                int i = AudioTrack.getMinBufferSize(paramMessageStruct.aSampleRate, 2, 2);
                localObject = new MessageStruct(67108871);
                ((MessageStruct)localObject).mParam0 = i;
                this.mNativeVideoPlayer.nativeProcessMsg((MessageStruct)localObject);
                if (QLog.isColorLevel()) {
                  QLog.d("TMMSWVideoView", 2, "[@][ProcessMsg][MSG_VIDEOPLAYER_INIT_AUDIO_DEVICE]minBufSize=" + i);
                }
                try
                {
                  this.mAudioTrack = new AudioTrack(3, paramMessageStruct.aSampleRate, 2, 2, i, 1);
                  if (QLog.isColorLevel())
                  {
                    QLog.d("TMMSWVideoView", 2, "[@][ProcessMsg][MSG_VIDEOPLAYER_INIT_AUDIO_DEVICE]mAudioTrack=" + this.mAudioTrack);
                    return;
                  }
                }
                catch (Exception paramMessageStruct)
                {
                  paramMessageStruct.printStackTrace();
                  return;
                }
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("TMMSWVideoView", 2, "[@][ProcessMsg][MSG_VIDEOPLAYER_PLAY_AUDIO]mAudioTrack=" + this.mAudioTrack);
            }
          } while ((this.mAudioTrack == null) || (this.mAudioTrack.getPlayState() == 3));
          try
          {
            this.mAudioTrack.play();
            return;
          }
          catch (IllegalStateException paramMessageStruct)
          {
            this.mAudioTrack.release();
            this.mAudioTrack = null;
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("TMMSWVideoView", 2, "[@][ProcessMsg][MSG_VIDEOPLAYER_WRITE_AUDIO]mAudioTrack=" + this.mAudioTrack);
          }
        } while (this.mAudioTrack == null);
        try
        {
          localObject = (byte[])paramMessageStruct.mObj0;
          this.mAudioTrack.write((byte[])localObject, 0, paramMessageStruct.mParam0);
          return;
        }
        catch (Throwable paramMessageStruct)
        {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TMMSWVideoView", 2, "[@][ProcessMsg][MSG_VIDEOPLAYER_STOP_AUDIO]mAudioTrack=" + this.mAudioTrack);
        }
      } while ((this.mAudioTrack == null) || (this.mAudioTrack.getPlayState() == 1));
      try
      {
        this.mAudioTrack.stop();
        return;
      }
      catch (IllegalStateException paramMessageStruct)
      {
        this.mAudioTrack.release();
        this.mAudioTrack = null;
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TMMSWVideoView", 2, "[@][ProcessMsg][MSG_VIDEOPLAYER_PAUSE_AUDIO]mAudioTrack=" + this.mAudioTrack);
      }
    } while ((this.mAudioTrack == null) || (this.mAudioTrack.getPlayState() != 3));
    try
    {
      this.mAudioTrack.pause();
      return;
    }
    catch (IllegalStateException paramMessageStruct)
    {
      this.mAudioTrack.release();
      this.mAudioTrack = null;
    }
  }
  
  public String getVideoPath()
  {
    return this.mVideoPath;
  }
  
  public boolean isGlThreadExited()
  {
    if (!this.glExitCheckInited)
    {
      Object localObject = getFieldValue(this.mGLSurfaceView, "mGLThread");
      if (localObject != null) {
        this.glExitCheckValue = ((Boolean)getFieldValue(localObject, "mExited")).booleanValue();
      }
      this.glExitCheckInited = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TMMSWVideoView", 2, "[@][init]isGlThreadExited  glExitCheckValue=" + this.glExitCheckValue + " glExitCheckInited=" + this.glExitCheckInited);
    }
    return this.glExitCheckValue;
  }
  
  public boolean isLooping()
  {
    return this.mNativeVideoPlayer.nativeIsLooping();
  }
  
  public boolean isPlaying()
  {
    return this.mNativeVideoPlayer.nativeIsPlaying();
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TMMSWVideoView", 2, "[@][onDrawFrame]mSurfaceIsReady=" + this.mSurfaceIsReady);
    }
    if (!this.mSurfaceIsReady)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TMMSWVideoView", 2, "[@][onDrawFrame]mSurfaceIsReady=false [onSurfaceCreated not be called...]");
      }
      return;
    }
    long l = System.currentTimeMillis();
    this.mNativeVideoPlayer.nativeRenderScene();
    this.mCurFrameRenderTime = (System.currentTimeMillis() - l);
    this.mRenderTotalFrames += 1L;
    this.mRenderTotalTime += this.mCurFrameRenderTime;
  }
  
  public void onPause()
  {
    if (this.mGLSurfaceView != null) {
      this.mGLSurfaceView.onPause();
    }
    pause();
  }
  
  public void onResume()
  {
    if (this.mGLSurfaceView != null) {
      this.mGLSurfaceView.onResume();
    }
    start();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TMMSWVideoView", 2, "[@][onSurfaceChanged]mSurfaceIsReady=" + this.mSurfaceIsReady + " width=" + paramInt1 + " height=" + paramInt2);
    }
    if (!this.mSurfaceIsReady)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TMMSWVideoView", 2, "[@][onSurfaceChanged]mSurfaceIsReady=false [onSurfaceCreated not be called...]");
      }
      return;
    }
    paramGL10.glViewport(0, 0, paramInt1, paramInt2);
    this.mNativeVideoPlayer.nativeChangeSize(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TMMSWVideoView", 2, "[@][onSurfaceCreated]mSurfaceIsReady=true");
    }
    this.mNativeVideoPlayer.nativeShutdownScene();
    this.mNativeVideoPlayer.nativeSetupScene();
    this.mSurfaceIsReady = true;
    if (this.mOnSurfaceListener != null) {
      this.mOnSurfaceListener.v();
    }
  }
  
  public void pause()
  {
    if (this.mGLSurfaceView != null) {
      this.mGLSurfaceView.queueEvent(new usd(this));
    }
  }
  
  public void playAudio()
  {
    this.mNativeVideoPlayer.nativePlayAudio();
  }
  
  public void release()
  {
    this.mSurfaceIsReady = false;
    if (this.mAudioTrack != null) {}
    try
    {
      this.mAudioTrack.stop();
      this.mAudioTrack.release();
      this.mAudioTrack = null;
      if (this.mGLSurfaceView != null)
      {
        this.mGLSurfaceView.queueEvent(new urx(this));
        removeView(this.mGLSurfaceView);
        this.mGLSurfaceView = null;
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;) {}
    }
  }
  
  public void reset()
  {
    if (this.mGLSurfaceView != null) {
      this.mGLSurfaceView.queueEvent(new use(this));
    }
  }
  
  public void seekTo(int paramInt)
  {
    if (this.mGLSurfaceView != null) {
      this.mGLSurfaceView.queueEvent(new usc(this, paramInt));
    }
  }
  
  public void setAudioPath(String paramString)
  {
    this.mNativeVideoPlayer.nativeSetAudioPath(paramString);
  }
  
  public void setFilter(int paramInt)
  {
    this.mNativeVideoPlayer.nativeSetFilter(paramInt);
  }
  
  public void setLooping(boolean paramBoolean)
  {
    this.mNativeVideoPlayer.nativeSetLooping(paramBoolean);
  }
  
  public void setOnSurfaceListener(TMMSWVideoView.OnSurfaceListener paramOnSurfaceListener)
  {
    this.mOnSurfaceListener = paramOnSurfaceListener;
  }
  
  public void setPlayOrder(int paramInt)
  {
    this.mNativeVideoPlayer.nativeSetPlayOrder(paramInt);
  }
  
  public void setPlaySpeed(int paramInt)
  {
    this.mNativeVideoPlayer.nativeSetPlaySpeed(paramInt);
  }
  
  public void setPlayingAudio(boolean paramBoolean)
  {
    this.mNativeVideoPlayer.nativeSetPlayingAudio(paramBoolean);
    if ((!paramBoolean) && (this.mAudioTrack != null)) {}
    try
    {
      this.mAudioTrack.stop();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      this.mAudioTrack.release();
      this.mAudioTrack = null;
    }
  }
  
  public void setVideoFramesAndTime(int paramInt1, int paramInt2)
  {
    this.times = paramInt1;
    this.frames = paramInt2;
  }
  
  public void setVideoPath(String paramString)
  {
    this.mVideoPath = paramString;
    if (this.mGLSurfaceView != null) {
      this.mGLSurfaceView.queueEvent(new urz(this, paramString));
    }
  }
  
  public void setVideoURI(Uri paramUri)
  {
    this.mNativeVideoPlayer.nativeSetVideoURI(paramUri.toString());
  }
  
  public void start()
  {
    this.mStartPlayTime = System.currentTimeMillis();
    this.mRenderTotalFrames = 0L;
    this.mRenderTotalTime = 0L;
    this.mCurFrameRenderTime = 0L;
    if (QLog.isColorLevel()) {
      QLog.d("TMMSWVideoView", 2, "[@][start]time=" + this.times + " frames=" + this.frames);
    }
    this.mGLSurfaceView.queueEvent(new usa(this));
  }
  
  public void stop()
  {
    if (this.mGLSurfaceView != null) {
      this.mGLSurfaceView.queueEvent(new usb(this));
    }
  }
  
  public void stopAudio()
  {
    this.mNativeVideoPlayer.nativeStopAudio();
    if (this.mAudioTrack != null) {}
    try
    {
      this.mAudioTrack.stop();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      this.mAudioTrack.release();
      this.mAudioTrack = null;
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TMMSWVideoView", 2, "[@][surfaceChanged]mSurfaceIsReady=" + this.mSurfaceIsReady);
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TMMSWVideoView", 2, "[@][surfaceCreated]mSurfaceIsReady=" + this.mSurfaceIsReady);
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TMMSWVideoView", 2, "[@][surfaceDestroyed]mSurfaceIsReady=false");
    }
    this.mSurfaceIsReady = false;
    if (this.mGLSurfaceView != null) {
      this.mGLSurfaceView.queueEvent(new ury(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\mediaplay\TMMSWVideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */