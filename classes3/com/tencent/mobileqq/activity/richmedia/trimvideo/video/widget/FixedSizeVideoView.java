package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.content.Context;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.VideoView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import pea;
import peb;

public class FixedSizeVideoView
  extends VideoView
  implements Handler.Callback
{
  private static final int jdField_a_of_type_Int = 0;
  private static final String jdField_a_of_type_JavaLangString = "FixedSizeVideoView";
  private Handler jdField_a_of_type_AndroidOsHandler;
  public FixedSizeVideoView.OnTrimVDPlayCompelteListener a;
  private int b;
  private int c;
  private int d;
  
  public FixedSizeVideoView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = -1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    super.setOnCompletionListener(new pea(this));
  }
  
  public FixedSizeVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b = -1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    super.setOnCompletionListener(new peb(this));
  }
  
  public int a()
  {
    return this.d;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView$OnTrimVDPlayCompelteListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView$OnTrimVDPlayCompelteListener.a(this, this.d, this.b);
      }
    }
  }
  
  public void pause()
  {
    super.pause();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
  }
  
  public void setOnCompletionListener(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setOnFixVDPlayCompelteListener(FixedSizeVideoView.OnTrimVDPlayCompelteListener paramOnTrimVDPlayCompelteListener)
  {
    if (paramOnTrimVDPlayCompelteListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView$OnTrimVDPlayCompelteListener = paramOnTrimVDPlayCompelteListener;
    }
  }
  
  public void setPlayDuration(int paramInt)
  {
    setPlayDuration(0, paramInt);
  }
  
  public void setPlayDuration(int paramInt1, int paramInt2)
  {
    try
    {
      int i = getDuration();
      if (paramInt1 >= i) {
        return;
      }
      int j = paramInt2 + paramInt1;
      this.c = j;
      if (j > i) {
        this.c = i;
      }
      this.d = paramInt1;
      this.b = paramInt2;
      seekTo(paramInt1);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void start()
  {
    int i = getCurrentPosition();
    i = this.c - i;
    if (i >= 0)
    {
      super.start();
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, i);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\trimvideo\video\widget\FixedSizeVideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */