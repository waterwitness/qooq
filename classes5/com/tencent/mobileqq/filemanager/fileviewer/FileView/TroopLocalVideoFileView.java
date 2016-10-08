package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.util.Timer;
import sgt;
import sgv;
import sgw;
import sgy;
import sgz;
import sha;
import shc;
import she;
import shg;

public class TroopLocalVideoFileView
  extends FileViewBase
{
  long jdField_a_of_type_Long;
  public Activity a;
  PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  public ImageView a;
  public LinearLayout a;
  public SeekBar a;
  public TextView a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public TVK_IMediaPlayer a;
  TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  String jdField_a_of_type_JavaLangString;
  Timer jdField_a_of_type_JavaUtilTimer;
  boolean jdField_a_of_type_Boolean;
  final long jdField_b_of_type_Long;
  View jdField_b_of_type_AndroidViewView;
  public ImageView b;
  public TextView b;
  private final String jdField_b_of_type_JavaLangString;
  public boolean b;
  final long c;
  public boolean c;
  final long d;
  
  public TroopLocalVideoFileView(Activity paramActivity)
  {
    super(paramActivity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_JavaLangString = "LocalVideoFileView";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 86400L;
    this.jdField_c_of_type_Long = 3600L;
    this.d = 60L;
    this.jdField_a_of_type_Boolean = true;
    paramActivity.setRequestedOrientation(-1);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = ((PowerManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("power")).newWakeLock(536870922, "LocalVideoFileView");
    this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.setReferenceCounted(false);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    int i = (int)DeviceInfoUtil.j();
    int j = (int)DeviceInfoUtil.k();
    float f1 = i / paramBitmap.getWidth();
    float f2 = j / paramBitmap.getHeight();
    if (f1 > f2) {
      f1 = f2;
    }
    for (;;)
    {
      try
      {
        Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(paramBitmap.getWidth() * f1), (int)(paramBitmap.getHeight() * f1), false);
        if (f1 != 1.0F) {
          paramBitmap.recycle();
        }
        return localBitmap;
      }
      catch (Throwable localThrowable)
      {
        return paramBitmap;
      }
      catch (OutOfMemoryError localOutOfMemoryError) {}
    }
    return paramBitmap;
  }
  
  private String a(long paramLong)
  {
    long l3 = (500L + paramLong) / 1000L;
    paramLong = l3 / 86400L;
    long l1 = l3 % 86400L / 3600L;
    long l2 = l3 % 86400L % 3600L / 60L;
    l3 = l3 % 86400L % 3600L % 60L;
    if (paramLong > 0L) {
      return String.format("%02d:%02d:%02d:%02d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
    }
    if (l1 > 0L) {
      return String.format("%02d:%02d:%02d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
    }
    return String.format("%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l3) });
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      String str = a(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130840421);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      o();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130840420);
    p();
  }
  
  private void f()
  {
    int j;
    int k;
    if (this.jdField_a_of_type_AndroidWidgetImageView.getDrawable() == null)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      this.jdField_b_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      j = localDisplayMetrics.widthPixels;
      k = localDisplayMetrics.heightPixels;
      if ((int)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion() != 0) {
        break label83;
      }
    }
    label83:
    for (int i = 1000;; i = (int)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion())
    {
      FileManagerUtil.a(this.jdField_a_of_type_JavaLangString, false, j, k, i, new sgt(this));
      return;
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null) && (this.jdField_b_of_type_AndroidViewView == null))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131301006);
      this.jdField_b_of_type_AndroidViewView = ((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView(this.jdField_a_of_type_AndroidAppActivity));
      if (this.jdField_a_of_type_AndroidWidgetImageView == null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
        localRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, 0);
      }
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-16777216);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      localRelativeLayout.addView(this.jdField_b_of_type_AndroidViewView, 0);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301023));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301024));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131301028));
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131301022));
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new sgv(this));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299909));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new sgw(this));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301029));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new sgy(this));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new sgz(this));
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null) {
        break label30;
      }
      if (QLog.isDevelopLevel()) {
        QLog.w("LocalVideoFileView", 4, "initVarView: but adapter is null");
      }
    }
    return;
    label30:
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(this.jdField_a_of_type_AndroidAppActivity, (IVideoViewBase)this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(new shg(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(new she(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(new sha(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 0L, 0L);
    this.jdField_a_of_type_Boolean = true;
    n();
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    }
    a(false);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocalVideoFileView", 2, "play but musicService is null");
      }
      return;
    }
    this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.acquire();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    a(true);
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener.d();
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 0L, 0L);
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_Boolean = false;
    n();
  }
  
  private void n()
  {
    boolean bool2 = true;
    label47:
    IFileViewListener localIFileViewListener;
    if (!this.jdField_a_of_type_Boolean)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (!this.jdField_a_of_type_Boolean) {
        break label81;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener != null)
      {
        localIFileViewListener = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener;
        if (this.jdField_a_of_type_Boolean) {
          break label111;
        }
      }
    }
    label81:
    label111:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localIFileViewListener.a(bool1);
      return;
      bool1 = false;
      break;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label47;
    }
  }
  
  private void o()
  {
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilTimer.scheduleAtFixedRate(new shc(this), 0L, 1000L);
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130904026, paramViewGroup, false);
    h();
    i();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
  }
  
  public void a()
  {
    p();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener = null;
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying())) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocalVideoFileView", 2, "doOnFinish");
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld()) {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c()
  {
    i();
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPauseing()) {
      f();
    }
  }
  
  public void e()
  {
    super.e();
    j();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\FileView\TroopLocalVideoFileView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */