package com.tencent.mobileqq.shortvideo.mediaplay;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class TMMVideoView
  extends FrameLayout
{
  protected TMMVideoView.OnErrorListener mErrorListener;
  
  public TMMVideoView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    init();
  }
  
  public TMMVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public TMMVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init() {}
  
  public abstract boolean isGlThreadExited();
  
  public abstract boolean isLooping();
  
  public abstract boolean isPlaying();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void pause();
  
  public abstract void playAudio();
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void seekTo(int paramInt);
  
  public abstract void setAudioPath(String paramString);
  
  public abstract void setFilter(int paramInt);
  
  public abstract void setLooping(boolean paramBoolean);
  
  public void setOnErrorListener(TMMVideoView.OnErrorListener paramOnErrorListener)
  {
    this.mErrorListener = paramOnErrorListener;
  }
  
  public abstract void setPlayOrder(int paramInt);
  
  public abstract void setPlaySpeed(int paramInt);
  
  public abstract void setPlayingAudio(boolean paramBoolean);
  
  public abstract void setVideoFramesAndTime(int paramInt1, int paramInt2);
  
  public abstract void setVideoPath(String paramString);
  
  public abstract void setVideoURI(Uri paramUri);
  
  public abstract void start();
  
  public abstract void stop();
  
  public abstract void stopAudio();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\mediaplay\TMMVideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */