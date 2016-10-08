package com.tencent.av.utils;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import hbo;

public class QQRecorder
{
  static final int a = 1;
  static final int b = 2;
  public static final String b = "QQRecorder";
  static final int c = 3;
  static final int d = 4;
  static final int e = 5;
  static final int f = 6;
  static final int g = 7;
  public static final int h = 500;
  public static final int k = 0;
  public static final int l = 1;
  public static final int m = 0;
  public static final int n = 1;
  public static final int o = 2;
  private static final int p = 48000;
  private static final int q = 2;
  private static final int r = 2;
  private static final int s = 20480;
  private static final int t = 800;
  private static final int w = 160;
  private static final int x = -1;
  public Context a;
  public AudioManager a;
  public AudioRecord a;
  public QQRecorder.OnQQRecorderListener a;
  public hbo a;
  public String a;
  public int i;
  int j;
  private int u;
  private int v;
  
  public QQRecorder(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidMediaAudioRecord = null;
    this.jdField_a_of_type_AndroidMediaAudioManager = null;
    this.u = 20480;
    this.v = 800;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.i = -1;
    this.j = -1;
    this.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener = null;
    this.jdField_a_of_type_Hbo = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)paramContext.getSystemService("audio"));
    paramContext = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.qq_audio_record.name());
    if (QLog.isColorLevel()) {
      QLog.d("QQRecorder", 2, "Init | dpc config = " + paramContext);
    }
    if (!TextUtils.isEmpty(paramContext)) {
      try
      {
        paramContext = paramContext.split("\\|");
        this.i = Integer.parseInt(paramContext[0]);
        this.j = Integer.parseInt(paramContext[1]);
        if (paramContext.length > 4) {
          a(Integer.parseInt(paramContext[2]), Integer.parseInt(paramContext[3]), Integer.parseInt(paramContext[4]));
        }
        if ((!VersionUtils.e()) && ((this.i == 3) || (this.j == 7))) {
          throw new RuntimeException("Illegal dpc config");
        }
      }
      catch (Exception paramContext)
      {
        this.i = -1;
        this.j = -1;
        if (QLog.isColorLevel()) {
          QLog.d("QQRecorder", 2, "QQRecord init error.", paramContext);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQRecorder", 2, "mMode = " + this.i + " | mAudioSource = " + this.j + " | recorderBufSize = " + this.u + " | readLength = " + this.v);
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 != -1)
    {
      paramInt2 = AudioRecord.getMinBufferSize(48000, 2, 2);
      if ((paramInt2 != -2) && (paramInt2 != -1)) {
        this.u = (paramInt2 * paramInt1);
      }
    }
    for (;;)
    {
      if (paramInt3 != -1) {
        this.v = paramInt3;
      }
      return;
      if (paramInt2 != -1) {
        this.u = paramInt2;
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQRecorder", 2, "QQRecord Stop");
    }
    if (this.jdField_a_of_type_Hbo != null) {
      this.jdField_a_of_type_Hbo.a = false;
    }
  }
  
  public void a(QQRecorder.OnQQRecorderListener paramOnQQRecorderListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQRecorder", 2, "setQQRecorderListener");
    }
    if (paramOnQQRecorderListener == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQRecorder", 2, "setQQRecorderListener--> listener is null");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener = paramOnQQRecorderListener;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQRecorder", 2, "QQRecord Start --> Path = " + paramString);
    }
    if (this.jdField_a_of_type_Hbo == null)
    {
      this.jdField_a_of_type_Hbo = new hbo(this, paramString);
      this.jdField_a_of_type_Hbo.start();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "Record :start --> Record is Not Ready");
      }
    } while (this.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener == null);
    this.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener.a(paramString, 1);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      return this.jdField_a_of_type_AndroidMediaAudioManager.isWiredHeadsetOn();
    }
    return false;
  }
  
  public void b()
  {
    int i2 = 0;
    if (this.jdField_a_of_type_AndroidMediaAudioRecord != null)
    {
      this.jdField_a_of_type_AndroidMediaAudioRecord.release();
      this.jdField_a_of_type_AndroidMediaAudioRecord = null;
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {}
    for (int i1 = this.jdField_a_of_type_AndroidMediaAudioManager.getMode();; i1 = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "Record :startRecording | audio mode = " + i1);
      }
      if ((this.jdField_a_of_type_AndroidMediaAudioManager != null) && (this.i != -1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQRecorder", 2, "Record :initRecording --> SetMode ,mode = " + this.i);
        }
        this.jdField_a_of_type_AndroidMediaAudioManager.setMode(this.i);
      }
      if (this.jdField_a_of_type_AndroidMediaAudioRecord == null) {
        if (QLog.isColorLevel()) {
          QLog.d("QQRecorder", 2, "Record: new AudioRecord --> mAudioSource = " + this.j + " ,SAMPLE_RATE_IN_HZ = , + SAMPLE_RATE_IN_HZ" + " ,CHANNEL_CONFIG = " + 2 + " ,AUDIO_FORMAT =" + 2 + " ,recorderInitBufSize = " + this.u);
        }
      }
      try
      {
        if (this.j == -1) {}
        for (i1 = i2;; i1 = this.j)
        {
          this.jdField_a_of_type_AndroidMediaAudioRecord = new AudioRecord(i1, 48000, 2, 2, this.u);
          if (this.jdField_a_of_type_AndroidMediaAudioRecord.getState() == 1) {
            break;
          }
          i1 = this.jdField_a_of_type_AndroidMediaAudioRecord.getState();
          if (QLog.isColorLevel()) {
            QLog.d("QQRecorder", 2, "Record State = " + i1);
          }
          if (this.jdField_a_of_type_AndroidMediaAudioRecord != null) {
            this.jdField_a_of_type_AndroidMediaAudioRecord.release();
          }
          this.jdField_a_of_type_AndroidMediaAudioRecord = null;
          if (this.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener != null) {
            this.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener.a(this.jdField_a_of_type_JavaLangString, 3);
          }
          throw new RuntimeException("Record.getState is not STATE_INITIALIZED, state = " + i1);
        }
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQRecorder", 2, "Record : new AudioRecord Failed:" + Log.getStackTraceString(localIllegalArgumentException), localIllegalArgumentException);
        }
        if (this.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener != null) {
          this.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener.a(this.jdField_a_of_type_JavaLangString, 3);
        }
      }
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Hbo == null) {}
    while (!this.jdField_a_of_type_Hbo.a) {
      return true;
    }
    return false;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Hbo != null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\utils\QQRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */