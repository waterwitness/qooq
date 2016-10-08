package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.VersionUtils;
import java.io.IOException;
import java.util.Map;
import vul;
import vum;
import vun;
import vuo;
import vup;
import vuq;
import vur;
import vus;
import vut;
import vuu;
import vuv;

public class VideoViewX
  extends SurfaceView
  implements MediaControllerX.MediaPlayerControlX
{
  public static final int a = -1;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public static final int g = 5;
  Context jdField_a_of_type_AndroidContentContext;
  public AudioManager.OnAudioFocusChangeListener a;
  private MediaPlayer.OnBufferingUpdateListener jdField_a_of_type_AndroidMediaMediaPlayer$OnBufferingUpdateListener;
  private MediaPlayer.OnCompletionListener jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener;
  private MediaPlayer.OnErrorListener jdField_a_of_type_AndroidMediaMediaPlayer$OnErrorListener;
  private MediaPlayer.OnInfoListener jdField_a_of_type_AndroidMediaMediaPlayer$OnInfoListener;
  MediaPlayer.OnPreparedListener jdField_a_of_type_AndroidMediaMediaPlayer$OnPreparedListener;
  private MediaPlayer.OnSeekCompleteListener jdField_a_of_type_AndroidMediaMediaPlayer$OnSeekCompleteListener;
  MediaPlayer.OnVideoSizeChangedListener jdField_a_of_type_AndroidMediaMediaPlayer$OnVideoSizeChangedListener;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private Uri jdField_a_of_type_AndroidNetUri;
  SurfaceHolder.Callback jdField_a_of_type_AndroidViewSurfaceHolder$Callback;
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private MediaControllerX jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX;
  private VideoViewX.OnPlayListener jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX$OnPlayListener;
  private VideoViewX.OnSeekListener jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX$OnSeekListener;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private String jdField_a_of_type_JavaLangString;
  private Map jdField_a_of_type_JavaUtilMap;
  public boolean a;
  private MediaPlayer.OnBufferingUpdateListener jdField_b_of_type_AndroidMediaMediaPlayer$OnBufferingUpdateListener;
  private MediaPlayer.OnCompletionListener jdField_b_of_type_AndroidMediaMediaPlayer$OnCompletionListener;
  private MediaPlayer.OnErrorListener jdField_b_of_type_AndroidMediaMediaPlayer$OnErrorListener;
  private MediaPlayer.OnPreparedListener jdField_b_of_type_AndroidMediaMediaPlayer$OnPreparedListener;
  public boolean b;
  public boolean c;
  public boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  
  public VideoViewX(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "VideoView";
    this.jdField_i_of_type_Int = 0;
    this.jdField_j_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidMediaMediaPlayer$OnVideoSizeChangedListener = new vup(this);
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new vuq(this);
    this.jdField_a_of_type_AndroidMediaMediaPlayer$OnPreparedListener = new vur(this);
    this.jdField_b_of_type_AndroidMediaMediaPlayer$OnCompletionListener = new vus(this);
    this.jdField_b_of_type_AndroidMediaMediaPlayer$OnErrorListener = new vut(this);
    this.jdField_a_of_type_AndroidMediaMediaPlayer$OnSeekCompleteListener = new vuu(this);
    this.jdField_b_of_type_AndroidMediaMediaPlayer$OnBufferingUpdateListener = new vuv(this);
    this.jdField_a_of_type_AndroidViewSurfaceHolder$Callback = new vum(this);
    this.d = false;
    this.jdField_a_of_type_JavaLangRunnable = new vun(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    h();
  }
  
  public VideoViewX(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    h();
  }
  
  public VideoViewX(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaLangString = "VideoView";
    this.jdField_i_of_type_Int = 0;
    this.jdField_j_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidMediaMediaPlayer$OnVideoSizeChangedListener = new vup(this);
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new vuq(this);
    this.jdField_a_of_type_AndroidMediaMediaPlayer$OnPreparedListener = new vur(this);
    this.jdField_b_of_type_AndroidMediaMediaPlayer$OnCompletionListener = new vus(this);
    this.jdField_b_of_type_AndroidMediaMediaPlayer$OnErrorListener = new vut(this);
    this.jdField_a_of_type_AndroidMediaMediaPlayer$OnSeekCompleteListener = new vuu(this);
    this.jdField_b_of_type_AndroidMediaMediaPlayer$OnBufferingUpdateListener = new vuv(this);
    this.jdField_a_of_type_AndroidViewSurfaceHolder$Callback = new vum(this);
    this.d = false;
    this.jdField_a_of_type_JavaLangRunnable = new vun(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    h();
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      this.jdField_i_of_type_Int = 0;
      m();
      if (paramBoolean) {
        this.jdField_j_of_type_Int = 0;
      }
    }
  }
  
  private boolean g()
  {
    return (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_i_of_type_Int != -1) && (this.jdField_i_of_type_Int != 0) && (this.jdField_i_of_type_Int != 1);
  }
  
  private void h()
  {
    this.k = 0;
    this.l = 0;
    getHolder().addCallback(this.jdField_a_of_type_AndroidViewSurfaceHolder$Callback);
    getHolder().setType(3);
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
    this.jdField_i_of_type_Int = 0;
    this.jdField_j_of_type_Int = 0;
    setOnClickListener(new vul(this));
    setOnFocusChangeListener(new vuo(this));
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_AndroidNetUri == null) || (this.jdField_a_of_type_AndroidViewSurfaceHolder == null)) {
      return;
    }
    Intent localIntent = new Intent("com.android.music.musicservicecommand");
    localIntent.putExtra("command", "pause");
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    a(false);
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(this.jdField_a_of_type_AndroidMediaMediaPlayer$OnPreparedListener);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnVideoSizeChangedListener(this.jdField_a_of_type_AndroidMediaMediaPlayer$OnVideoSizeChangedListener);
      this.jdField_h_of_type_Int = -1;
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(this.jdField_b_of_type_AndroidMediaMediaPlayer$OnCompletionListener);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this.jdField_b_of_type_AndroidMediaMediaPlayer$OnErrorListener);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnInfoListener(this.jdField_a_of_type_AndroidMediaMediaPlayer$OnInfoListener);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnSeekCompleteListener(this.jdField_a_of_type_AndroidMediaMediaPlayer$OnSeekCompleteListener);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnBufferingUpdateListener(this.jdField_b_of_type_AndroidMediaMediaPlayer$OnBufferingUpdateListener);
      this.o = 0;
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidNetUri, this.jdField_a_of_type_JavaUtilMap);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDisplay(this.jdField_a_of_type_AndroidViewSurfaceHolder);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setScreenOnWhilePlaying(true);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
      this.jdField_i_of_type_Int = 1;
      j();
      return;
    }
    catch (IOException localIOException)
    {
      Log.w(this.jdField_a_of_type_JavaLangString, "Unable to open content: " + this.jdField_a_of_type_AndroidNetUri, localIOException);
      this.jdField_i_of_type_Int = -1;
      this.jdField_j_of_type_Int = -1;
      this.jdField_b_of_type_AndroidMediaMediaPlayer$OnErrorListener.onError(this.jdField_a_of_type_AndroidMediaMediaPlayer, 1, 0);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Log.w(this.jdField_a_of_type_JavaLangString, "Unable to open content: " + this.jdField_a_of_type_AndroidNetUri, localIllegalArgumentException);
      this.jdField_i_of_type_Int = -1;
      this.jdField_j_of_type_Int = -1;
      this.jdField_b_of_type_AndroidMediaMediaPlayer$OnErrorListener.onError(this.jdField_a_of_type_AndroidMediaMediaPlayer, 1, 0);
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.setMediaPlayer(this);
      if (!(getParent() instanceof View)) {
        break label60;
      }
    }
    label60:
    for (Object localObject = (View)getParent();; localObject = this)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.setAnchorView((View)localObject);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.setEnabled(g());
      return;
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.b())
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.c();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.b();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.setEnabled(true);
  }
  
  private void l()
  {
    if (!this.jdField_j_of_type_Boolean)
    {
      this.jdField_j_of_type_Boolean = true;
      postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
    }
  }
  
  private void m()
  {
    this.jdField_j_of_type_Boolean = false;
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public int a()
  {
    if (g())
    {
      if (this.jdField_h_of_type_Int > 0) {
        return this.jdField_h_of_type_Int;
      }
      this.jdField_h_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaPlayer.getDuration();
      return this.jdField_h_of_type_Int;
    }
    this.jdField_h_of_type_Int = -1;
    return this.jdField_h_of_type_Int;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    switch (i1)
    {
    case 0: 
    default: 
      return paramInt1;
    case -2147483648: 
      return Math.min(paramInt1, paramInt2);
    }
    return paramInt2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      this.jdField_i_of_type_Int = 0;
      this.jdField_j_of_type_Int = 0;
      m();
    }
  }
  
  public void a(int paramInt)
  {
    if (g())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX$OnSeekListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX$OnSeekListener.h();
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(paramInt);
      this.p = 0;
      return;
    }
    this.p = paramInt;
  }
  
  public boolean a()
  {
    return (g()) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying());
  }
  
  public int b()
  {
    if (g()) {
      return this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
    }
    return 0;
  }
  
  public void b()
  {
    a(false);
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      return this.o;
    }
    return 0;
  }
  
  public void c()
  {
    i();
  }
  
  public boolean c()
  {
    return this.f;
  }
  
  public int d()
  {
    return this.jdField_i_of_type_Int;
  }
  
  public void d()
  {
    if (g())
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setVolume(1.0F, 1.0F);
      this.c = false;
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      l();
      this.jdField_i_of_type_Int = 3;
    }
    this.jdField_j_of_type_Int = 3;
    this.jdField_h_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.d();
    }
  }
  
  public boolean d()
  {
    return this.g;
  }
  
  public void e()
  {
    if ((g()) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()))
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
      this.jdField_i_of_type_Int = 4;
    }
    this.jdField_j_of_type_Int = 4;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.d();
    }
  }
  
  public boolean e()
  {
    return this.jdField_h_of_type_Boolean;
  }
  
  public void f()
  {
    int i1 = 1;
    int i2;
    if (this.jdField_h_of_type_Boolean)
    {
      i2 = this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition() - 1;
      if (i2 >= 1) {
        break label74;
      }
    }
    for (;;)
    {
      if (this.jdField_i_of_type_Int == -1)
      {
        i();
        this.jdField_j_of_type_Int = 3;
        this.jdField_h_of_type_Boolean = false;
      }
      do
      {
        return;
        d();
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.d();
      } while (this.jdField_i_of_type_Boolean);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(i1);
      return;
      label74:
      i1 = i2;
    }
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX == null) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.b()) {
      return true;
    }
    return this.d;
  }
  
  public void g()
  {
    a(true);
    if (VersionUtils.b()) {
      ((AudioManager)BaseApplication.getContext().getSystemService("audio")).abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(VideoViewX.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(VideoViewX.class.getName());
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt != 4) && (paramInt != 24) && (paramInt != 25) && (paramInt != 164) && (paramInt != 82) && (paramInt != 5) && (paramInt != 6)) {}
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = getDefaultSize(this.k, paramInt1);
    int i2 = getDefaultSize(this.l, paramInt2);
    paramInt1 = i2;
    paramInt2 = i1;
    if (this.k > 0)
    {
      paramInt1 = i2;
      paramInt2 = i1;
      if (this.l > 0)
      {
        if (this.k * i2 <= this.l * i1) {
          break label80;
        }
        paramInt1 = this.l * i1 / this.k;
        paramInt2 = i1;
      }
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      label80:
      paramInt1 = i2;
      paramInt2 = i1;
      if (this.k * i2 < this.l * i1)
      {
        paramInt2 = this.k * i2 / this.l;
        paramInt1 = i2;
      }
    }
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    if ((g()) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null)) {
      k();
    }
    return false;
  }
  
  public void setLive(boolean paramBoolean)
  {
    this.jdField_i_of_type_Boolean = paramBoolean;
  }
  
  public void setMediaController(MediaControllerX paramMediaControllerX)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX = paramMediaControllerX;
    this.jdField_a_of_type_Boolean = true;
    j();
  }
  
  public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener paramOnBufferingUpdateListener)
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer$OnBufferingUpdateListener = paramOnBufferingUpdateListener;
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
  
  public void setOnPlayListener(VideoViewX.OnPlayListener paramOnPlayListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX$OnPlayListener = paramOnPlayListener;
  }
  
  public void setOnPreparedListener(MediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.jdField_b_of_type_AndroidMediaMediaPlayer$OnPreparedListener = paramOnPreparedListener;
  }
  
  public void setOnSeekListener(VideoViewX.OnSeekListener paramOnSeekListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX$OnSeekListener = paramOnSeekListener;
  }
  
  public void setOnViewClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
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
    this.p = 0;
    i();
    requestLayout();
    invalidate();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\widget\VideoViewX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */