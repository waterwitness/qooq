package cooperation.c2b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.Size;
import android.media.AudioManager;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import xzb;
import xzc;
import xzd;
import xze;
import xzf;
import xzg;
import xzh;
import xzi;
import xzk;

public class C2BTakePhotoActivity
  extends Activity
  implements View.OnClickListener
{
  public static final int a = 66;
  public static final String a = "defalut_camera";
  public static final String b = "photo_video_path";
  public static final String c = "read_wording";
  public static final String d = "photo_ratio";
  public static final String e = "allow_switch_camera";
  public static final String f = "max_video_duration";
  public static final String g = "error_code";
  public static final String h = AppConstants.bj + "C2BFile/";
  private static final String k = "C2BTakePhotoActivity";
  float jdField_a_of_type_Float;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Camera.PictureCallback jdField_a_of_type_AndroidHardwareCamera$PictureCallback = new xzg(this);
  Camera.Size jdField_a_of_type_AndroidHardwareCamera$Size = null;
  public Camera a;
  MediaRecorder jdField_a_of_type_AndroidMediaMediaRecorder = null;
  public SurfaceHolder a;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  public LinearLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public Long a;
  TimerTask jdField_a_of_type_JavaUtilTimerTask = null;
  xzi jdField_a_of_type_Xzi;
  public boolean a;
  public int b;
  BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver;
  Button jdField_b_of_type_AndroidWidgetButton;
  public TextView b;
  public boolean b;
  public int c;
  Button c;
  public boolean c;
  int jdField_d_of_type_Int = 0;
  Button jdField_d_of_type_AndroidWidgetButton;
  boolean jdField_d_of_type_Boolean = true;
  public int e;
  Button e;
  public boolean e;
  int jdField_f_of_type_Int = -1;
  Button jdField_f_of_type_AndroidWidgetButton;
  boolean jdField_f_of_type_Boolean = false;
  public int g;
  Button g;
  public String i = null;
  String j = null;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public C2BTakePhotoActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 15;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_e_of_type_Int = -1;
    this.jdField_g_of_type_Int = -1;
    this.jdField_a_of_type_AndroidViewSurfaceHolder = null;
  }
  
  private void a(File paramFile)
  {
    paramFile = paramFile.listFiles();
    if (paramFile != null)
    {
      int n = paramFile.length;
      int m = 0;
      if (m < n)
      {
        File localFile = paramFile[m];
        if (localFile.isDirectory()) {
          a(localFile);
        }
        for (;;)
        {
          m += 1;
          break;
          b(localFile);
        }
      }
    }
  }
  
  private void b(File paramFile)
  {
    if (paramFile.exists()) {}
    try
    {
      paramFile.delete();
      return;
    }
    catch (Exception paramFile) {}
  }
  
  private void c(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.isDirectory())
    {
      a(paramString);
      return;
    }
    b(paramString);
  }
  
  private void d(String paramString)
  {
    b(new File(paramString));
  }
  
  private void m()
  {
    Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
    localParameters.setPictureFormat(256);
    a(localParameters);
    if (this.jdField_c_of_type_Int == 0) {
      b(localParameters);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
      this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
      return;
      c(localParameters);
    }
  }
  
  int a(List paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f4 = paramInt1 * 1.0F / paramInt2;
    float f1 = 1000000.0F;
    paramInt2 = 0;
    int n = 1000000000;
    paramInt1 = 0;
    while (paramInt1 < paramList.size())
    {
      Camera.Size localSize = (Camera.Size)paramList.get(paramInt1);
      int i2 = localSize.width * localSize.height;
      float f2 = localSize.width * 1.0F / localSize.height;
      float f3 = (f4 - f2) * (f4 - f2);
      int i1;
      int m;
      if (f3 >= f1)
      {
        i1 = n;
        f2 = f1;
        m = paramInt2;
        if (f3 == f1)
        {
          i1 = n;
          f2 = f1;
          m = paramInt2;
          if (i2 >= n) {}
        }
      }
      else
      {
        i1 = n;
        f2 = f1;
        m = paramInt2;
        if (i2 <= paramInt3)
        {
          i1 = n;
          f2 = f1;
          m = paramInt2;
          if (i2 >= paramInt4)
          {
            i1 = i2;
            f2 = f3;
            m = paramInt1;
          }
        }
      }
      paramInt1 += 1;
      n = i1;
      f1 = f2;
      paramInt2 = m;
    }
    return paramInt2;
  }
  
  public String a()
  {
    File localFile = null;
    if (Environment.getExternalStorageState().equals("mounted")) {
      localFile = Environment.getExternalStorageDirectory();
    }
    if (localFile == null) {
      return "";
    }
    return localFile.toString();
  }
  
  void a()
  {
    Display localDisplay = getWindowManager().getDefaultDisplay();
    float f1 = getResources().getDisplayMetrics().density;
    LinearLayout localLinearLayout1 = (LinearLayout)findViewById(2131299279);
    LinearLayout localLinearLayout2 = (LinearLayout)findViewById(2131299284);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localLinearLayout2.getLayoutParams();
    Intent localIntent = getIntent();
    this.j = localIntent.getStringExtra("read_wording");
    this.jdField_c_of_type_Int = localIntent.getIntExtra("work_mode", 0);
    this.jdField_d_of_type_Int = localIntent.getIntExtra("defalut_camera", 0);
    this.jdField_b_of_type_Int = localIntent.getIntExtra("max_video_duration", 15);
    this.jdField_d_of_type_Boolean = localIntent.getBooleanExtra("allow_switch_camera", true);
    this.jdField_a_of_type_Float = localIntent.getFloatExtra("photo_ratio", 0.0F);
    if (this.jdField_c_of_type_Int == 0)
    {
      localLinearLayout1.setVisibility(0);
      localLinearLayout2.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = localLinearLayout1;
      localLayoutParams.height = (localDisplay.getHeight() - (int)(f1 * 150.0F));
      if (this.jdField_a_of_type_Float > 0.0F)
      {
        if (this.jdField_a_of_type_Float > 1.0F) {
          this.jdField_a_of_type_Float = 1.0F;
        }
        if (this.jdField_a_of_type_Float < 0.5625F) {
          this.jdField_a_of_type_Float = 0.5625F;
        }
        int m = localDisplay.getWidth() - 200;
        int n = (int)(localDisplay.getHeight() - getResources().getDisplayMetrics().density * 150.0F);
        n = Math.min((int)(m / this.jdField_a_of_type_Float), n);
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(new LinearLayout.LayoutParams(m, n));
      }
    }
    for (;;)
    {
      localLinearLayout2.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_Xzi = new xzi(this, this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_Xzi, new LinearLayout.LayoutParams(-1, -1));
      b(false);
      return;
      if (this.jdField_c_of_type_Int == 1)
      {
        localLinearLayout1.setVisibility(4);
        localLinearLayout2.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout = localLinearLayout2;
        localLayoutParams.height = Math.min(localDisplay.getWidth() * 4 / 3, localDisplay.getHeight() - (int)(f1 * 120.0F));
      }
    }
  }
  
  void a(Camera.Parameters paramParameters)
  {
    List localList = paramParameters.getSupportedFocusModes();
    if ((this.jdField_c_of_type_Int == 0) && (localList.contains("continuous-picture"))) {
      paramParameters.setFocusMode("continuous-picture");
    }
    do
    {
      return;
      if ((this.jdField_c_of_type_Int == 1) && (localList.contains("continuous-video")))
      {
        paramParameters.setFocusMode("continuous-video");
        return;
      }
    } while (!localList.contains("auto"));
    paramParameters.setFocusMode("auto");
  }
  
  public void a(String paramString)
  {
    paramString = Toast.makeText(getApplicationContext(), paramString, 1);
    paramString.setGravity(17, 0, 0);
    paramString.show();
  }
  
  void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(paramString1);
    localQQCustomDialog.setMessage(paramString2);
    localQQCustomDialog.setPositiveButton("确定", new xzd(this, paramBoolean));
    localQQCustomDialog.setOnCancelListener(new xze(this, paramBoolean));
    localQQCustomDialog.show();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaRecorder != null) {
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaRecorder.stop();
        this.jdField_a_of_type_AndroidMediaMediaRecorder.release();
        this.jdField_a_of_type_AndroidMediaMediaRecorder = null;
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidHardwareCamera$Size = null;
        this.jdField_e_of_type_Boolean = true;
        l();
        if (this.jdField_c_of_type_Boolean) {
          a("录制完成", "视频时长超过了商家的限制，已停止录制。", false);
        }
        if (paramBoolean)
        {
          this.jdField_a_of_type_AndroidHardwareCamera.takePicture(null, null, this.jdField_a_of_type_AndroidHardwareCamera$PictureCallback);
          return;
        }
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        localRuntimeException.printStackTrace();
        return;
      }
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  boolean a(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidViewSurfaceHolder == null) || (paramInt == this.jdField_g_of_type_Int)) {}
    while (paramInt == -1) {
      return false;
    }
    h();
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera = Camera.open(paramInt);
      if ((paramInt != this.jdField_f_of_type_Int) && (Build.MODEL.toLowerCase().equals("nexus 6p"))) {
        this.jdField_a_of_type_AndroidHardwareCamera.setDisplayOrientation(270);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidHardwareCamera.setPreviewDisplay(this.jdField_a_of_type_AndroidViewSurfaceHolder);
        m();
        this.jdField_g_of_type_Int = paramInt;
        return true;
        this.jdField_a_of_type_AndroidHardwareCamera.setDisplayOrientation(90);
      }
      return false;
    }
    catch (RuntimeException localRuntimeException)
    {
      a("温馨提示", getString(2131363688), true);
      return false;
    }
    catch (IOException localIOException)
    {
      if (this.jdField_a_of_type_AndroidHardwareCamera != null)
      {
        this.jdField_a_of_type_AndroidHardwareCamera.release();
        this.jdField_a_of_type_AndroidHardwareCamera = null;
      }
      this.jdField_g_of_type_Int = -1;
      localIOException.printStackTrace();
    }
  }
  
  void b()
  {
    ((TelephonyManager)getSystemService("phone")).listen(new xzb(this), 32);
  }
  
  void b(Camera.Parameters paramParameters)
  {
    Object localObject = getWindowManager().getDefaultDisplay();
    int m = ((Display)localObject).getWidth();
    int n = ((Display)localObject).getHeight();
    localObject = paramParameters.getSupportedPreviewSizes();
    if (localObject != null)
    {
      int i1 = a((List)localObject, n, m, m * n, 480000);
      paramParameters.setPreviewSize(((Camera.Size)((List)localObject).get(i1)).width, ((Camera.Size)((List)localObject).get(i1)).height);
    }
    localObject = paramParameters.getSupportedPictureSizes();
    if (localObject != null)
    {
      m = a((List)localObject, n, m, m * n, 480000);
      paramParameters.setPictureSize(((Camera.Size)((List)localObject).get(m)).width, ((Camera.Size)((List)localObject).get(m)).height);
    }
  }
  
  void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2BTakePhotoActivity", 2, paramString);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_g_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_d_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      if (this.jdField_c_of_type_Int == 0)
      {
        this.jdField_f_of_type_AndroidWidgetButton.setVisibility(4);
        this.jdField_e_of_type_AndroidWidgetButton.setVisibility(4);
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      }
    }
    label237:
    do
    {
      return;
      this.jdField_f_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(4);
      return;
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_f_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      if (this.jdField_d_of_type_Boolean) {
        this.jdField_g_of_type_AndroidWidgetButton.setVisibility(0);
      }
      for (;;)
      {
        if (this.jdField_c_of_type_Int != 0) {
          break label237;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetButton.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        if (this.jdField_a_of_type_Float == 0.0F) {
          break;
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
        this.jdField_g_of_type_AndroidWidgetButton.setVisibility(4);
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_d_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetButton.setBackgroundResource(2130839091);
    } while ((this.j == null) || (this.j.equals("")));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("录制时请念出屏幕上的文字");
  }
  
  void c()
  {
    if ((this.jdField_a_of_type_AndroidHardwareCamera == null) || (this.jdField_a_of_type_AndroidMediaMediaRecorder != null))
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.unlock();
      this.jdField_a_of_type_AndroidMediaMediaRecorder = new MediaRecorder();
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setCamera(this.jdField_a_of_type_AndroidHardwareCamera);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setAudioSource(1);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setVideoSource(1);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setOutputFormat(2);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setAudioEncoder(0);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setVideoEncoder(2);
      if (Build.MODEL.toLowerCase().equals("h60-l01"))
      {
        this.jdField_a_of_type_AndroidMediaMediaRecorder.setVideoEncodingBitRate(131072);
        if (this.jdField_a_of_type_AndroidHardwareCamera$Size != null) {
          this.jdField_a_of_type_AndroidMediaMediaRecorder.setVideoSize(this.jdField_a_of_type_AndroidHardwareCamera$Size.width, this.jdField_a_of_type_AndroidHardwareCamera$Size.height);
        }
        if ((this.jdField_g_of_type_Int != this.jdField_f_of_type_Int) && (!Build.MODEL.toLowerCase().equals("nexus 6p"))) {
          break label399;
        }
        this.jdField_a_of_type_AndroidMediaMediaRecorder.setOrientationHint(90);
        this.jdField_a_of_type_AndroidMediaMediaRecorder.setPreviewDisplay(this.jdField_a_of_type_AndroidViewSurfaceHolder.getSurface());
        File localFile = new File(h);
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        this.i = (h + System.currentTimeMillis() + ".mp4");
        this.jdField_a_of_type_AndroidMediaMediaRecorder.setOutputFile(this.i);
        this.jdField_a_of_type_AndroidMediaMediaRecorder.prepare();
        this.jdField_a_of_type_AndroidMediaMediaRecorder.start();
        this.jdField_b_of_type_Boolean = true;
        this.jdField_g_of_type_AndroidWidgetButton.setVisibility(4);
        this.jdField_d_of_type_AndroidWidgetButton.setBackgroundResource(2130839092);
        k();
        if ((this.j != null) && (!this.j.equals(""))) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.j);
        }
        new Timer().schedule(new xzc(this), 1500L);
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        a("温馨提示", getString(2131363689), true);
        localIllegalStateException.printStackTrace();
        this.jdField_a_of_type_Boolean = false;
        return;
        this.jdField_a_of_type_AndroidMediaMediaRecorder.setVideoEncodingBitRate(524288);
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
        continue;
        label399:
        this.jdField_a_of_type_AndroidMediaMediaRecorder.setOrientationHint(270);
      }
    }
  }
  
  void c(Camera.Parameters paramParameters)
  {
    Object localObject = paramParameters.getSupportedPreviewSizes();
    if ((localObject != null) && (Build.VERSION.SDK_INT >= 11))
    {
      List localList = paramParameters.getSupportedVideoSizes();
      if (localList != null)
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = ((List)localObject).iterator();
        for (;;)
        {
          localObject = localArrayList;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (Camera.Size)localIterator.next();
          if (localList.contains(localObject)) {
            localArrayList.add(localObject);
          }
        }
      }
    }
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        b("preview and encode have not common size!");
      }
      if (!Build.MANUFACTURER.toLowerCase().equals("huawei")) {
        break label312;
      }
    }
    label312:
    for (int m = 76800;; m = 172800)
    {
      this.jdField_a_of_type_AndroidHardwareCamera$Size = ((Camera.Size)((List)localObject).get(a((List)localObject, 4, 3, 1228800, m)));
      b(String.format("common video size(%d,%d)", new Object[] { Integer.valueOf(this.jdField_a_of_type_AndroidHardwareCamera$Size.width), Integer.valueOf(this.jdField_a_of_type_AndroidHardwareCamera$Size.height) }));
      paramParameters.setPreviewSize(this.jdField_a_of_type_AndroidHardwareCamera$Size.width, this.jdField_a_of_type_AndroidHardwareCamera$Size.height);
      localObject = paramParameters.getSupportedPictureSizes();
      if (localObject != null)
      {
        if (((List)localObject).contains(this.jdField_a_of_type_AndroidHardwareCamera$Size)) {
          paramParameters.setPictureSize(this.jdField_a_of_type_AndroidHardwareCamera$Size.width, this.jdField_a_of_type_AndroidHardwareCamera$Size.height);
        }
        m = a((List)localObject, this.jdField_a_of_type_AndroidHardwareCamera$Size.width, this.jdField_a_of_type_AndroidHardwareCamera$Size.height, 2764800, 172800);
        paramParameters.setPictureSize(((Camera.Size)((List)localObject).get(m)).width, ((Camera.Size)((List)localObject).get(m)).height);
      }
      return;
    }
  }
  
  public void d()
  {
    a(false);
    if (this.jdField_a_of_type_AndroidHardwareCamera != null)
    {
      h();
      b(true);
    }
  }
  
  void e()
  {
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    int n = Camera.getNumberOfCameras();
    int m = 0;
    if (m < n)
    {
      Camera.getCameraInfo(m, localCameraInfo);
      if (localCameraInfo.facing == 1) {
        this.jdField_e_of_type_Int = m;
      }
      for (;;)
      {
        m += 1;
        break;
        if (localCameraInfo.facing == 0) {
          this.jdField_f_of_type_Int = m;
        }
      }
    }
  }
  
  void f()
  {
    int m;
    if (this.jdField_g_of_type_Int != this.jdField_f_of_type_Int)
    {
      m = this.jdField_f_of_type_Int;
      this.jdField_d_of_type_Int = 0;
    }
    for (;;)
    {
      if (m == -1)
      {
        a("无法切换摄像头");
        return;
        if (this.jdField_g_of_type_Int != this.jdField_e_of_type_Int)
        {
          m = this.jdField_e_of_type_Int;
          this.jdField_d_of_type_Int = 1;
        }
      }
      else
      {
        a(m);
        return;
      }
      m = -1;
    }
  }
  
  public void finish()
  {
    if (this.jdField_f_of_type_Boolean) {
      return;
    }
    this.jdField_f_of_type_Boolean = true;
    if (this.jdField_b_of_type_Boolean) {
      d();
    }
    h();
    Bundle localBundle = getIntent().getExtras();
    Object localObject = localBundle.getString("destaction");
    if ((localObject != null) && (((String)localObject).length() > 0))
    {
      localObject = new Intent((String)localObject);
      ((Intent)localObject).putExtras(localBundle);
      ((Intent)localObject).putExtra("error_code", 1);
      ((Intent)localObject).setPackage(getPackageName());
      sendBroadcast((Intent)localObject);
    }
    c(h);
    super.finish();
  }
  
  public void g()
  {
    int m = this.jdField_f_of_type_Int;
    if (this.jdField_d_of_type_Int == 1) {
      m = this.jdField_e_of_type_Int;
    }
    a(m);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera != null)
    {
      this.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
      this.jdField_a_of_type_AndroidHardwareCamera.release();
      this.jdField_a_of_type_AndroidHardwareCamera = null;
      this.jdField_g_of_type_Int = -1;
    }
  }
  
  void i()
  {
    if (((this.jdField_e_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) && (this.jdField_c_of_type_Int == 1))
    {
      ActionSheet localActionSheet = ActionSheet.c(this);
      localActionSheet.a("重新录制，当前视频将会被删除");
      localActionSheet.c("重新录制");
      localActionSheet.c(" 直接退出");
      localActionSheet.d("取消");
      localActionSheet.a(new xzf(this, localActionSheet));
      localActionSheet.show();
      return;
    }
    finish();
  }
  
  public void j()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    b(false);
    d(this.i);
    if (this.jdField_a_of_type_Xzi.getVisibility() != 0)
    {
      this.jdField_a_of_type_Xzi.setVisibility(0);
      return;
    }
    g();
  }
  
  void k()
  {
    if (this.jdField_a_of_type_JavaUtilTimerTask == null)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(System.currentTimeMillis());
      this.jdField_a_of_type_JavaUtilTimerTask = new xzk(this);
      new Timer().schedule(this.jdField_a_of_type_JavaUtilTimerTask, 0L, 200L);
    }
  }
  
  void l()
  {
    if (this.jdField_a_of_type_JavaUtilTimerTask != null)
    {
      this.jdField_a_of_type_JavaUtilTimerTask.cancel();
      this.jdField_a_of_type_JavaUtilTimerTask = null;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 66) && (paramInt2 == -1))
    {
      c(h);
      super.finish();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131299282: 
    case 2131299284: 
    case 2131299285: 
    case 2131299286: 
    case 2131299287: 
    default: 
    case 2131299290: 
    case 2131299292: 
    case 2131299288: 
    case 2131299281: 
    case 2131299291: 
      do
      {
        do
        {
          return;
        } while ((this.jdField_a_of_type_AndroidHardwareCamera == null) || (this.jdField_a_of_type_Boolean));
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidHardwareCamera.takePicture(null, null, this.jdField_a_of_type_AndroidHardwareCamera$PictureCallback);
        return;
        paramView = new Intent(this, C2BUploadFileActivity.class);
        paramView.putExtras(getIntent());
        paramView.putExtra("qq.process.param.uploadfile.filepath", this.i);
        paramView.putExtra("qq.process.param.uploadfile.choose", false);
        paramView.putExtra("error_code", 0);
        startActivityForResult(paramView, 66);
        return;
        j();
        return;
        i();
        return;
      } while (this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_b_of_type_Boolean)
      {
        a(true);
        return;
      }
      c();
      return;
    case 2131299289: 
      paramView = new Intent(this, C2BVideoPreviewActivity.class);
      paramView.putExtras(super.getIntent());
      paramView.putExtra("video_path", this.i);
      startActivity(paramView);
      return;
    }
    f();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent().getBooleanExtra("FinishActivity", false)) {
      finish();
    }
    setContentView(2130903568);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131299290));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131299292));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131299288));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131299280);
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)findViewById(2131299291));
    this.jdField_e_of_type_AndroidWidgetButton = ((Button)findViewById(2131299289));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299286));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299282));
    this.jdField_f_of_type_AndroidWidgetButton = ((Button)findViewById(2131299281));
    this.jdField_g_of_type_AndroidWidgetButton = ((Button)findViewById(2131299283));
    a();
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_g_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetButton.setOnClickListener(this);
    e();
    setVolumeControlStream(3);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = C2BDestoryReceiver.a(this, super.getIntent());
    if (this.jdField_b_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = new xzh(this);
      paramBundle = new IntentFilter();
      paramBundle.addAction("tencent.av.v2q.AudioVideoRequest");
      paramBundle.addAction("mqq.intent.action.ACCOUNT_KICKED");
      registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, paramBundle);
    }
    this.jdField_f_of_type_Boolean = false;
    b();
  }
  
  protected void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("C2BTakePhotoActivity", 2, "onDestroy. time=" + System.currentTimeMillis());
    }
    C2BDestoryReceiver.a(this, this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
    this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AudioManager localAudioManager = (AudioManager)getSystemService("audio");
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    case 25: 
      localAudioManager.adjustStreamVolume(3, -1, 1);
      return true;
    case 24: 
      localAudioManager.adjustStreamVolume(3, 1, 1);
      return true;
    }
    i();
    return true;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (paramIntent.getBooleanExtra("FinishActivity", false)) {
      finish();
    }
  }
  
  protected void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.i("C2BTakePhotoActivity", 2, "onPause. time=" + System.currentTimeMillis());
    }
    if (this.jdField_b_of_type_Boolean) {
      a(true);
    }
    for (;;)
    {
      super.onPause();
      return;
      if (!this.jdField_e_of_type_Boolean) {
        h();
      }
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (!this.jdField_e_of_type_Boolean) {
      g();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\c2b\C2BTakePhotoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */