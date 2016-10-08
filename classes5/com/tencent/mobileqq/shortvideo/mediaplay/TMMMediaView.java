package com.tencent.mobileqq.shortvideo.mediaplay;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class TMMMediaView
  extends FrameLayout
{
  public static final String a = "TMMMediaView";
  private TMMCoverView jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMCoverView;
  private TMMProgressView jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMProgressView;
  private TMMVideoView jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView;
  private String b;
  
  public TMMMediaView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    j();
  }
  
  public TMMMediaView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    j();
  }
  
  public TMMMediaView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    j();
  }
  
  private void j()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView = new TMMSWVideoView(getContext());
    addView(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMCoverView = new TMMCoverView(getContext());
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMCoverView.setVisibility(4);
    addView(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMCoverView, localLayoutParams);
    localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMProgressView = new TMMProgressView(getContext());
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMProgressView.setMax(100);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMProgressView.setVisibility(4);
    addView(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMProgressView, localLayoutParams);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView.onPause();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView.seekTo(paramInt);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView.isLooping();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView.onResume();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView.isPlaying();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView.start();
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView.isGlThreadExited();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView.stop();
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView.pause();
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TMMMediaView", 2, "[@][reset]");
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView.reset();
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView.release();
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView.playAudio();
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView.stopAudio();
  }
  
  public void setAudioPath(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView.setAudioPath(paramString);
  }
  
  public void setCoverImagePath(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMCoverView.setImage(paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView.isPlaying())
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMCoverView.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMCoverView.setVisibility(0);
  }
  
  public void setDefaultCoverImagePath(String paramString)
  {
    if (paramString != null)
    {
      this.b = paramString;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMCoverView.setImage(this.b);
    }
  }
  
  public void setFilter(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView.setFilter(paramInt);
  }
  
  public void setLooping(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView.setLooping(paramBoolean);
  }
  
  public void setPlayOrder(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView.setPlayOrder(paramInt);
  }
  
  public void setPlaySpeed(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView.setPlaySpeed(paramInt);
  }
  
  public void setPlayingAudio(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView.setPlayingAudio(paramBoolean);
  }
  
  public void setVideoFramesAndTime(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView.setVideoFramesAndTime(paramInt1, paramInt2);
  }
  
  public void setVideoPath(String paramString)
  {
    if (paramString == null) {
      return;
    }
    f();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView.setVideoPath(paramString);
  }
  
  public void setVideoView(TMMVideoView paramTMMVideoView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView.release();
      removeView(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView = null;
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView = paramTMMVideoView;
    addView(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediaplayTMMVideoView, 0, localLayoutParams);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\mediaplay\TMMMediaView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */