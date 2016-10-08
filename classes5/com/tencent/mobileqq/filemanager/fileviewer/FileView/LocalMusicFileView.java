package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewMusicEvent;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import ses;
import set;
import seu;
import sev;
import sew;
import sey;

public class LocalMusicFileView
  extends FileViewBase
  implements SensorEventListener, IFileViewMusicEvent
{
  float jdField_a_of_type_Float;
  Sensor jdField_a_of_type_AndroidHardwareSensor;
  SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FileViewMusicService jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService;
  private final String jdField_a_of_type_JavaLangString;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private boolean jdField_a_of_type_Boolean;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private Button c;
  
  public LocalMusicFileView(Activity paramActivity)
  {
    super(paramActivity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "LocalMusicFileView";
    this.jdField_a_of_type_AndroidHardwareSensorManager = null;
    this.jdField_a_of_type_AndroidHardwareSensor = null;
    this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)BaseApplicationImpl.getContext().getSystemService("sensor"));
    this.jdField_a_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(8);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b();
      Object localObject = new Time();
      ((Time)localObject).set(i);
      localObject = ((Time)localObject).format("%M:%S");
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130840416);
      l();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130840417);
    m();
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131301022));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new ses(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299909));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new set(this));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131301025));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new seu(this));
    this.c = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131301026));
    this.c.setOnClickListener(new sev(this));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301024));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301023));
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("LocalMusicFileView", 4, "initVarView: but adapter is null");
      }
      return;
    }
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300889)).setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300890)).setText(FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()));
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a())
    {
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b()) {
        break label244;
      }
      this.c.setEnabled(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService = FileViewMusicService.a();
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b();
      if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.d() != 6) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.d() != 7)) || (FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b())))) {
        break label255;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      I_();
      return;
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      break;
      label244:
      this.c.setEnabled(false);
    }
    label255:
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a(this.jdField_b_of_type_JavaLangString, new sew(this));
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b(this.jdField_b_of_type_JavaLangString))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b();
      Object localObject = new Time();
      ((Time)localObject).set(i);
      localObject = ((Time)localObject).format("%M:%S");
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a(this);
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b(this.jdField_b_of_type_JavaLangString)) || (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a())) {
        break label428;
      }
    }
    label428:
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        break label433;
      }
      a(bool);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText("00:00");
      break;
    }
    label433:
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.i())
    {
      j();
      return;
    }
    a(bool);
  }
  
  private void j()
  {
    FileManagerReporter.a("0X8004BE0");
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a(this);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a(this.jdField_b_of_type_JavaLangString)) {}
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b();
      a(true);
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener == null);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener.c();
  }
  
  private void k()
  {
    FileManagerReporter.a("0X8004BE1");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a();
    a(false);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener.d();
    }
  }
  
  private void l()
  {
    m();
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimer.scheduleAtFixedRate(new sey(this), 0L, 1000L);
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
  }
  
  public void I_()
  {
    if (this.jdField_a_of_type_Boolean) {
      k();
    }
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130904020, paramViewGroup, false);
    h();
    if (FontSettingManager.a() > 17.0F)
    {
      paramViewGroup = (AsyncImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301021);
      float f = this.jdField_b_of_type_AndroidAppActivity.getResources().getDisplayMetrics().density;
      paramViewGroup.setLayoutParams(new LinearLayout.LayoutParams((int)(150.0F * f), (int)(f * 150.0F)));
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public String a()
  {
    return BaseApplicationImpl.getContext().getString(2131362789);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a(null);
    }
    this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this);
    m();
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b(this.jdField_b_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService = null;
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
    return true;
  }
  
  public void b() {}
  
  public boolean b()
  {
    this.jdField_b_of_type_AndroidAppActivity.setRequestedOrientation(1);
    return false;
  }
  
  public void c()
  {
    i();
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, this.jdField_a_of_type_AndroidHardwareSensor, 3);
    i();
  }
  
  public void e()
  {
    m();
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText("00:00");
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    a(false);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener.d();
    }
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    this.jdField_a_of_type_Float = paramSensorEvent.values[0];
    if (QLog.isDevelopLevel()) {
      QLog.w("LocalMusicFileView", 4, "--> " + this.jdField_a_of_type_Float + " | " + this.jdField_a_of_type_AndroidHardwareSensor.getMaximumRange());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\FileView\LocalMusicFileView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */