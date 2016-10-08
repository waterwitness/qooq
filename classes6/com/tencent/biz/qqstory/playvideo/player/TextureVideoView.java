package com.tencent.biz.qqstory.playvideo.player;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import ipq;
import ipr;
import ips;
import ipt;
import ipu;
import ipw;
import java.io.IOException;
import java.util.Map;

public class TextureVideoView
  extends TextureView
  implements TextureView.SurfaceTextureListener, MediaController.MediaPlayerControl
{
  protected static final int a = -1;
  protected static final int b = 0;
  protected static final int c = 1;
  protected static final int d = 2;
  protected static final int e = 3;
  protected static final int f = 4;
  protected static final int g = 5;
  private MediaPlayer.OnBufferingUpdateListener jdField_a_of_type_AndroidMediaMediaPlayer$OnBufferingUpdateListener;
  public MediaPlayer.OnCompletionListener a;
  public MediaPlayer.OnErrorListener a;
  public MediaPlayer.OnInfoListener a;
  public MediaPlayer.OnPreparedListener a;
  MediaPlayer.OnVideoSizeChangedListener jdField_a_of_type_AndroidMediaMediaPlayer$OnVideoSizeChangedListener;
  public MediaPlayer a;
  protected Uri a;
  protected Surface a;
  public MediaController a;
  public String a;
  protected Map a;
  public boolean a;
  private MediaPlayer.OnCompletionListener jdField_b_of_type_AndroidMediaMediaPlayer$OnCompletionListener;
  private MediaPlayer.OnErrorListener jdField_b_of_type_AndroidMediaMediaPlayer$OnErrorListener;
  private MediaPlayer.OnInfoListener jdField_b_of_type_AndroidMediaMediaPlayer$OnInfoListener;
  MediaPlayer.OnPreparedListener jdField_b_of_type_AndroidMediaMediaPlayer$OnPreparedListener;
  public boolean b;
  public boolean c;
  protected boolean d;
  public int h;
  public int i;
  protected int j;
  public int k;
  public int l;
  public int m;
  public int n;
  
  public TextureVideoView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "Q.qqstory.player.TextureVideoView";
    this.h = 0;
    this.i = 0;
    this.jdField_a_of_type_AndroidMediaMediaPlayer$OnVideoSizeChangedListener = new ipq(this);
    this.jdField_b_of_type_AndroidMediaMediaPlayer$OnPreparedListener = new ipr(this);
    this.jdField_b_of_type_AndroidMediaMediaPlayer$OnCompletionListener = new ips(this);
    this.jdField_b_of_type_AndroidMediaMediaPlayer$OnInfoListener = new ipt(this);
    this.jdField_b_of_type_AndroidMediaMediaPlayer$OnErrorListener = new ipu(this);
    this.jdField_a_of_type_AndroidMediaMediaPlayer$OnBufferingUpdateListener = new ipw(this);
    g();
  }
  
  public TextureVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    g();
  }
  
  public TextureVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaLangString = "Q.qqstory.player.TextureVideoView";
    this.h = 0;
    this.i = 0;
    this.jdField_a_of_type_AndroidMediaMediaPlayer$OnVideoSizeChangedListener = new ipq(this);
    this.jdField_b_of_type_AndroidMediaMediaPlayer$OnPreparedListener = new ipr(this);
    this.jdField_b_of_type_AndroidMediaMediaPlayer$OnCompletionListener = new ips(this);
    this.jdField_b_of_type_AndroidMediaMediaPlayer$OnInfoListener = new ipt(this);
    this.jdField_b_of_type_AndroidMediaMediaPlayer$OnErrorListener = new ipu(this);
    this.jdField_a_of_type_AndroidMediaMediaPlayer$OnBufferingUpdateListener = new ipw(this);
    g();
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      this.h = 0;
      if (paramBoolean) {
        this.i = 0;
      }
      ((AudioManager)getContext().getApplicationContext().getSystemService("audio")).abandonAudioFocus(null);
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.h != -1) && (this.h != 0) && (this.h != 1);
  }
  
  private void g()
  {
    this.k = 0;
    this.l = 0;
    super.setSurfaceTextureListener(this);
    super.setFocusable(true);
    super.setFocusableInTouchMode(true);
    super.requestFocus();
    this.h = 0;
    this.i = 0;
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_AndroidNetUri == null) || (this.jdField_a_of_type_AndroidViewSurface == null)) {
      return;
    }
    a(false);
    try
    {
      ((AudioManager)getContext().getApplicationContext().getSystemService("audio")).requestAudioFocus(null, 3, 1);
    }
    catch (Exception localException)
    {
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(this.d);
        if (this.j != 0)
        {
          this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioSessionId(this.j);
          this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(this.jdField_b_of_type_AndroidMediaMediaPlayer$OnPreparedListener);
          this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnVideoSizeChangedListener(this.jdField_a_of_type_AndroidMediaMediaPlayer$OnVideoSizeChangedListener);
          this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(this.jdField_b_of_type_AndroidMediaMediaPlayer$OnCompletionListener);
          this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this.jdField_b_of_type_AndroidMediaMediaPlayer$OnErrorListener);
          this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnInfoListener(this.jdField_b_of_type_AndroidMediaMediaPlayer$OnInfoListener);
          this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnBufferingUpdateListener(this.jdField_a_of_type_AndroidMediaMediaPlayer$OnBufferingUpdateListener);
          this.m = 0;
          this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(getContext().getApplicationContext(), this.jdField_a_of_type_AndroidNetUri, this.jdField_a_of_type_JavaUtilMap);
          this.jdField_a_of_type_AndroidMediaMediaPlayer.setSurface(this.jdField_a_of_type_AndroidViewSurface);
          this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
          this.jdField_a_of_type_AndroidMediaMediaPlayer.setScreenOnWhilePlaying(true);
          this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
          this.h = 1;
          i();
          return;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w(this.jdField_a_of_type_JavaLangString, 2, "Unable to open content: " + this.jdField_a_of_type_AndroidNetUri, localIOException);
          }
          this.h = -1;
          this.i = -1;
          this.jdField_b_of_type_AndroidMediaMediaPlayer$OnErrorListener.onError(this.jdField_a_of_type_AndroidMediaMediaPlayer, 1, 0);
          return;
          localException = localException;
          if (QLog.isColorLevel())
          {
            QLog.w(this.jdField_a_of_type_JavaLangString, 2, "requestAudioFocus Exception: " + QLog.getStackTraceString(localException));
            continue;
            this.j = this.jdField_a_of_type_AndroidMediaMediaPlayer.getAudioSessionId();
          }
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        if (QLog.isColorLevel()) {
          QLog.w(this.jdField_a_of_type_JavaLangString, 2, "Unable to open content: " + this.jdField_a_of_type_AndroidNetUri, localIllegalArgumentException);
        }
        this.h = -1;
        this.i = -1;
        this.jdField_b_of_type_AndroidMediaMediaPlayer$OnErrorListener.onError(this.jdField_a_of_type_AndroidMediaMediaPlayer, 1, 0);
      }
    }
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidWidgetMediaController != null))
    {
      this.jdField_a_of_type_AndroidWidgetMediaController.setMediaPlayer(this);
      if (!(getParent() instanceof View)) {
        break label60;
      }
    }
    label60:
    for (Object localObject = (View)getParent();; localObject = this)
    {
      this.jdField_a_of_type_AndroidWidgetMediaController.setAnchorView((View)localObject);
      this.jdField_a_of_type_AndroidWidgetMediaController.setEnabled(a());
      return;
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_AndroidWidgetMediaController.isShowing())
    {
      this.jdField_a_of_type_AndroidWidgetMediaController.hide();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetMediaController.show();
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    return getDefaultSize(paramInt1, paramInt2);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      this.h = 0;
      this.i = 0;
      ((AudioManager)getContext().getApplicationContext().getSystemService("audio")).abandonAudioFocus(null);
    }
  }
  
  public void b()
  {
    a(false);
  }
  
  public void c()
  {
    h();
  }
  
  public boolean canPause()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean canSeekBackward()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean canSeekForward()
  {
    return this.c;
  }
  
  public void d()
  {
    pause();
    seekTo(0);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetMediaController != null) {
      this.jdField_a_of_type_AndroidWidgetMediaController.hide();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_AndroidWidgetMediaController != null) {
      this.jdField_a_of_type_AndroidWidgetMediaController.show();
    }
  }
  
  public int getAudioSessionId()
  {
    if (this.j == 0)
    {
      MediaPlayer localMediaPlayer = new MediaPlayer();
      this.j = localMediaPlayer.getAudioSessionId();
      localMediaPlayer.release();
    }
    return this.j;
  }
  
  public int getBufferPercentage()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      return this.m;
    }
    return 0;
  }
  
  public int getCurrentPosition()
  {
    if (a()) {
      return this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
    }
    return 0;
  }
  
  public int getDuration()
  {
    if (a()) {
      return this.jdField_a_of_type_AndroidMediaMediaPlayer.getDuration();
    }
    return -1;
  }
  
  public boolean isPlaying()
  {
    return (a()) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying());
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(TextureVideoView.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(TextureVideoView.class.getName());
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int i1;
    if ((paramInt != 4) && (paramInt != 24) && (paramInt != 25) && (paramInt != 164) && (paramInt != 82) && (paramInt != 5) && (paramInt != 6))
    {
      i1 = 1;
      if ((!a()) || (i1 == 0) || (this.jdField_a_of_type_AndroidWidgetMediaController == null)) {
        break label182;
      }
      if ((paramInt != 79) && (paramInt != 85)) {
        break label114;
      }
      if (!this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
        break label101;
      }
      pause();
      this.jdField_a_of_type_AndroidWidgetMediaController.show();
    }
    label101:
    label114:
    label143:
    do
    {
      do
      {
        return true;
        i1 = 0;
        break;
        start();
        this.jdField_a_of_type_AndroidWidgetMediaController.hide();
        return true;
        if (paramInt != 126) {
          break label143;
        }
      } while (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying());
      start();
      this.jdField_a_of_type_AndroidWidgetMediaController.hide();
      return true;
      if ((paramInt != 86) && (paramInt != 127)) {
        break label178;
      }
    } while (!this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying());
    pause();
    this.jdField_a_of_type_AndroidWidgetMediaController.show();
    return true;
    label178:
    j();
    label182:
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i3 = getDefaultSize(this.k, paramInt1);
    int i4 = getDefaultSize(this.l, paramInt2);
    int i2 = i4;
    int i1 = i3;
    int i5;
    if (this.k > 0)
    {
      i2 = i4;
      i1 = i3;
      if (this.l > 0)
      {
        i4 = View.MeasureSpec.getMode(paramInt1);
        paramInt1 = View.MeasureSpec.getSize(paramInt1);
        i5 = View.MeasureSpec.getMode(paramInt2);
        paramInt2 = View.MeasureSpec.getSize(paramInt2);
        if ((i4 != 1073741824) || (i5 != 1073741824)) {
          break label157;
        }
        if (this.k * paramInt2 >= this.l * paramInt1) {
          break label124;
        }
        i2 = this.l * paramInt1 / this.k;
        i1 = paramInt1;
      }
    }
    for (;;)
    {
      super.setMeasuredDimension(i1, i2);
      return;
      label124:
      if (this.k * paramInt2 > this.l * paramInt1)
      {
        i1 = this.k * paramInt2 / this.l;
        i2 = paramInt2;
        continue;
        label157:
        if (i4 == 1073741824)
        {
          i2 = this.l * paramInt1 / this.k;
          if ((i5 == Integer.MIN_VALUE) && (i2 > paramInt2))
          {
            i2 = paramInt2;
            i1 = paramInt1;
          }
        }
        else
        {
          if (i5 == 1073741824)
          {
            i3 = this.k * paramInt2 / this.l;
            i2 = paramInt2;
            i1 = i3;
            if (i4 != Integer.MIN_VALUE) {
              continue;
            }
            i2 = paramInt2;
            i1 = i3;
            if (i3 <= paramInt1) {
              continue;
            }
            i2 = paramInt2;
            i1 = paramInt1;
            continue;
          }
          i3 = this.k;
          i1 = this.l;
          if ((i5 == Integer.MIN_VALUE) && (i1 > paramInt2)) {
            i3 = this.k * paramInt2 / this.l;
          }
          for (;;)
          {
            i2 = paramInt2;
            i1 = i3;
            if (i4 != Integer.MIN_VALUE) {
              break;
            }
            i2 = paramInt2;
            i1 = i3;
            if (i3 <= paramInt1) {
              break;
            }
            i2 = this.l * paramInt1 / this.k;
            i1 = paramInt1;
            break;
            paramInt2 = i1;
          }
        }
        i1 = paramInt1;
      }
      else
      {
        i2 = paramInt2;
        i1 = paramInt1;
      }
    }
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewSurface = new Surface(paramSurfaceTexture);
    h();
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    if (this.jdField_a_of_type_AndroidViewSurface != null)
    {
      this.jdField_a_of_type_AndroidViewSurface.release();
      this.jdField_a_of_type_AndroidViewSurface = null;
    }
    if (this.jdField_a_of_type_AndroidWidgetMediaController != null) {
      this.jdField_a_of_type_AndroidWidgetMediaController.hide();
    }
    a(true);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    int i2 = 1;
    int i1;
    if (this.i == 3)
    {
      i1 = 1;
      if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
        break label67;
      }
    }
    label67:
    for (paramInt1 = i2;; paramInt1 = 0)
    {
      if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (i1 != 0) && (paramInt1 != 0))
      {
        if (this.n != 0) {
          seekTo(this.n);
        }
        start();
      }
      return;
      i1 = 0;
      break;
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((a()) && (this.jdField_a_of_type_AndroidWidgetMediaController != null)) {
      j();
    }
    return false;
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    if ((a()) && (this.jdField_a_of_type_AndroidWidgetMediaController != null)) {
      j();
    }
    return false;
  }
  
  public void pause()
  {
    if ((a()) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()))
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
      this.h = 4;
    }
    this.i = 4;
  }
  
  public void seekTo(int paramInt)
  {
    if (a())
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(paramInt);
      this.n = 0;
      return;
    }
    this.n = paramInt;
  }
  
  public void setLooping(boolean paramBoolean)
  {
    this.d = paramBoolean;
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(paramBoolean);
    }
  }
  
  public void setMediaController(MediaController paramMediaController)
  {
    if (this.jdField_a_of_type_AndroidWidgetMediaController != null) {
      this.jdField_a_of_type_AndroidWidgetMediaController.hide();
    }
    this.jdField_a_of_type_AndroidWidgetMediaController = paramMediaController;
    i();
  }
  
  public void setOnCompletionListener(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener = paramOnCompletionListener;
  }
  
  public void setOnErrorListener(MediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer$OnErrorListener = paramOnErrorListener;
  }
  
  public void setOnInfoListener(MediaPlayer.OnInfoListener paramOnInfoListener)
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer$OnInfoListener = paramOnInfoListener;
  }
  
  public void setOnPreparedListener(MediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer$OnPreparedListener = paramOnPreparedListener;
  }
  
  public void setVideoPath(String paramString)
  {
    setVideoURI(Uri.parse(paramString));
  }
  
  public void setVideoURI(Uri paramUri)
  {
    setVideoURI(paramUri, null);
  }
  
  public void setVideoURI(Uri paramUri, Map paramMap)
  {
    this.jdField_a_of_type_AndroidNetUri = paramUri;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    this.n = 0;
    h();
    super.requestLayout();
    super.invalidate();
  }
  
  public void start()
  {
    if (a())
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      this.h = 3;
    }
    this.i = 3;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\playvideo\player\TextureVideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */