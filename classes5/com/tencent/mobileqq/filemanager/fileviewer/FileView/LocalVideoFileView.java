package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
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
import com.tencent.mobileqq.filemanager.fileviewer.FileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewMusicEvent;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import sfi;
import sfk;
import sfl;
import sfn;
import sfo;
import sfp;
import sfu;
import sfv;

public class LocalVideoFileView
  extends FileViewBase
  implements IFileViewMusicEvent
{
  private int jdField_a_of_type_Int;
  final long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock;
  private SurfaceView jdField_a_of_type_AndroidViewSurfaceView;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FileViewMusicService jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService;
  private final String jdField_a_of_type_JavaLangString;
  private Timer jdField_a_of_type_JavaUtilTimer;
  boolean jdField_a_of_type_Boolean;
  final long jdField_b_of_type_Long;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  final long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  
  public LocalVideoFileView(Activity paramActivity)
  {
    super(paramActivity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "LocalVideoFileView";
    this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = 86400L;
    this.jdField_b_of_type_Long = 3600L;
    this.jdField_c_of_type_Long = 60L;
    this.e = true;
    this.jdField_c_of_type_Boolean = true;
    paramActivity.setRequestedOrientation(-1);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = ((PowerManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("power")).newWakeLock(536870922, "LocalVideoFileView");
    this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.setReferenceCounted(false);
  }
  
  private String a(long paramLong)
  {
    long l3 = paramLong / 1000L;
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
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Boolean)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b();
      String str = a(i);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130840421);
      o();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130840420);
    p();
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301023));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301024));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131301028));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131301022));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new sfk(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299909));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new sfl(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301029));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new sfn(this));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new sfo(this));
  }
  
  private void i()
  {
    this.jdField_c_of_type_Boolean = false;
    j();
  }
  
  private void j()
  {
    boolean bool2 = true;
    label47:
    IFileViewListener localIFileViewListener;
    if (!this.jdField_c_of_type_Boolean)
    {
      bool1 = true;
      this.jdField_c_of_type_Boolean = bool1;
      if (!this.jdField_c_of_type_Boolean) {
        break label81;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener != null)
      {
        localIFileViewListener = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener;
        if (this.jdField_c_of_type_Boolean) {
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
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("LocalVideoFileView", 4, "initVarView: but adapter is null");
      }
      return;
    }
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService = FileViewMusicService.a();
    new Handler().postDelayed(new sfp(this), 100L);
    if (this.jdField_a_of_type_AndroidViewSurfaceView == null)
    {
      this.jdField_a_of_type_AndroidViewSurfaceView = new SurfaceView(this.jdField_a_of_type_AndroidAppActivity);
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131301006);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13, -1);
      localRelativeLayout.addView(this.jdField_a_of_type_AndroidViewSurfaceView, 0, localLayoutParams);
    }
    if (Build.VERSION.SDK_INT < 11) {
      this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().setType(3);
    }
    this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().addCallback(new sfu(this));
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a(this);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a())) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return;
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocalVideoFileView", 2, "play but musicService is null");
      }
      return;
    }
    FileManagerReporter.a("0X8004BE4");
    this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.acquire();
    if (Build.VERSION.SDK_INT > 16) {
      this.jdField_a_of_type_AndroidViewSurfaceView.setBackground(null);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b();
      a(true);
      return;
      this.jdField_a_of_type_AndroidViewSurfaceView.setBackgroundDrawable(null);
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService == null) {
      if (QLog.isColorLevel()) {
        QLog.d("LocalVideoFileView", 2, "play but musicService is null");
      }
    }
    do
    {
      do
      {
        return;
      } while (!this.d);
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.acquire();
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b(this.jdField_b_of_type_JavaLangString)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a(this);
    } while (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a(this.jdField_b_of_type_JavaLangString));
    this.jdField_a_of_type_AndroidViewSurfaceView.setVisibility(0);
    if (Build.VERSION.SDK_INT > 16) {
      this.jdField_a_of_type_AndroidViewSurfaceView.setBackground(null);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a(this.jdField_b_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewSurfaceView);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a(this.jdField_b_of_type_AndroidAppActivity);
      return;
      this.jdField_a_of_type_AndroidViewSurfaceView.setBackgroundDrawable(null);
    }
  }
  
  private void n()
  {
    this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
    FileManagerReporter.a("0X8004BE5");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a();
    a(false);
  }
  
  private void o()
  {
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimer.scheduleAtFixedRate(new sfv(this), 0L, 1000L);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b(this.jdField_b_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.c();
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocalVideoFileView", 2, "doOnFinish");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService = null;
    if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld()) {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a(this.jdField_b_of_type_AndroidAppActivity);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840419);
      if (this.jdField_a_of_type_Boolean) {
        break label56;
      }
    }
    label56:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840422);
      break;
    }
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      FMToastUtil.a("对不起，该音频文件无法播放！");
    }
    for (;;)
    {
      a(false);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener.d();
      }
      return;
      FMToastUtil.a(paramString);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    this.jdField_c_of_type_Boolean = false;
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public void c()
  {
    k();
  }
  
  public void d()
  {
    k();
  }
  
  public void e()
  {
    p();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a(null);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b(this.jdField_b_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld()) {
        this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
      }
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.c();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      this.jdField_b_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      int i = localDisplayMetrics.widthPixels;
      int j = localDisplayMetrics.heightPixels;
      FileManagerUtil.a(this.jdField_b_of_type_JavaLangString, false, i, j, this.jdField_a_of_type_Int * 1000, new sfi(this));
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText("00:00");
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    a(false);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener.d();
    }
    this.jdField_c_of_type_Boolean = false;
    i();
  }
  
  public void g()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\FileView\LocalVideoFileView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */