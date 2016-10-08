package com.tencent.mobileqq.activity.richmedia.state;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.widget.Toast;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.maxvideo.mediadevice.AVCodec.AVCodecCallback;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.common.GloableValue;
import com.tencent.mobileqq.shortvideo.common.TCTimer;
import com.tencent.mobileqq.shortvideo.common.TCTimer.TCTimerCallback;
import com.tencent.mobileqq.shortvideo.error.ErrorCenter;
import com.tencent.mobileqq.shortvideo.error.ErrorCenter.ErrorHandleCallback;
import com.tencent.mobileqq.shortvideo.hwcodec.HwEnvData;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture.OnAudioRecordListener;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl.CustomSize;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.CameraPreviewObservable;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.ParamCache;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.RecordManager;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.mobileqq.shortvideo.util.storage.StorageManager;
import com.tencent.mobileqq.shortvideo.util.storage.StorageManager.OnSdCardChangedListener;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.video.decode.ShortVideoSoLoad;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import pdk;
import pdm;
import pdn;
import pdt;

public class RMVideoStateMgr
  implements AVCodec.AVCodecCallback, TCTimer.TCTimerCallback, ErrorCenter.ErrorHandleCallback, AudioCapture.OnAudioRecordListener, StorageManager.OnSdCardChangedListener
{
  private static final int F = 4;
  private static final int H = 500;
  private static RMVideoStateMgr jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
  public static boolean a = false;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 850, 780, 650, 480 };
  public static final int b = 1;
  private static final String jdField_b_of_type_JavaLangString = "RMVideoStateMgr";
  public static boolean b = false;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int g = 1;
  public static final int h = 2;
  public static final int i = 3;
  public static final int j = 4;
  public static final int k = 0;
  public static final int l = 1;
  public static final int m = 2;
  public static final int n = 3;
  public static final int o = 4;
  public static final int p = 1;
  public static final int q = 2;
  public static final int r = 3;
  public static final int s = 4;
  public static final int t = 5;
  public static final int u = 6;
  public static final int v = 4;
  private int G = 1;
  public double a;
  public int a;
  public Context a;
  public Handler a;
  public RMVideoClipSpec a;
  final RMVideoPreviewState jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoPreviewState = new RMVideoPreviewState();
  public RMVideoStateMgr.ForceReleaseLockOnPause a;
  public final RMVideoSwitchCameraPicMgr a;
  public final RMVideoThumbGenMgr a;
  public RMViewSTInterface a;
  public AudioCapture.OnAudioRecordListener a;
  public AudioCapture a;
  public CameraProxy a;
  public PreviewContext a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  public AtomicBoolean a;
  public AtomicInteger a;
  public pdk a;
  final pdm jdField_a_of_type_Pdm = new pdm();
  final pdn jdField_a_of_type_Pdn = new pdn();
  final pdt jdField_a_of_type_Pdt = new pdt();
  public AtomicInteger b;
  private int[] jdField_b_of_type_ArrayOfInt = new int[8];
  public boolean c;
  public boolean d;
  public boolean e = true;
  public int f;
  public boolean f;
  public boolean g;
  public boolean h = true;
  private boolean i;
  private boolean j;
  private volatile boolean k;
  private boolean l = true;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_Boolean = true;
  }
  
  private RMVideoStateMgr()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr = new RMVideoThumbGenMgr();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr = new RMVideoSwitchCameraPicMgr();
    this.jdField_f_of_type_Int = 480;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause = new RMVideoStateMgr.ForceReleaseLockOnPause();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec = new RMVideoClipSpec();
  }
  
  private int a(int[] paramArrayOfInt)
  {
    int i2 = GloableValue.h.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (paramArrayOfInt[1] == GloableValue.h[i1])
      {
        paramArrayOfInt[0] = GloableValue.g[i1];
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public static RMVideoStateMgr a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr == null) {
      jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr = new RMVideoStateMgr();
    }
    return jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
  }
  
  private boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    if (QLog.isColorLevel()) {
      QLog.e("RMVideoStateMgr", 2, "initTMMEngine[begin]");
    }
    for (;;)
    {
      long l1;
      boolean bool2;
      try
      {
        l1 = Long.valueOf(paramString).longValue();
        if (l1 == -1L)
        {
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.e("RMVideoStateMgr", 2, "initTMMEngine mLongUnin is invalid. mLongUnin=" + l1);
            bool2 = bool1;
          }
          return bool2;
        }
      }
      catch (NumberFormatException paramString)
      {
        l1 = -1L;
        continue;
      }
      try
      {
        bool1 = GloableValue.a(l1, paramContext, paramInt1, paramInt2);
        bool2 = false;
        if (bool2)
        {
          if (QLog.isColorLevel()) {
            QLog.e("RMVideoStateMgr", 2, "crashed=" + bool2 + " soLoadStatus=" + ShortVideoSoLoad.VIDEO_SO_LOAD_STATUS);
          }
          ShortVideoSoLoad.VIDEO_SO_LOAD_STATUS = -4;
          VideoEnvironment.a("AVCodec", paramContext, true);
        }
      }
      catch (UnsatisfiedLinkError paramString)
      {
        for (;;)
        {
          try
          {
            bool1 = GloableValue.a(l1, paramContext, paramInt1, paramInt2);
            bool2 = bool1;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("RMVideoStateMgr", 2, "initTMMEngine[end]");
            return bool1;
            paramString = paramString;
            paramString.printStackTrace();
            GloableValue.jdField_a_of_type_Long = -1L;
            bool2 = true;
            bool1 = false;
          }
          catch (UnsatisfiedLinkError paramContext)
          {
            paramContext.printStackTrace();
            bool1 = bool3;
            if (QLog.isColorLevel())
            {
              QLog.e("RMVideoStateMgr", 2, "[SecondCrash]crashed=" + bool2 + " soLoadStatus=" + ShortVideoSoLoad.VIDEO_SO_LOAD_STATUS);
              bool1 = bool3;
            }
          }
        }
      }
    }
  }
  
  public static boolean a(boolean paramBoolean)
  {
    return (HwEnvData.a()) || (paramBoolean);
  }
  
  private int b(int[] paramArrayOfInt)
  {
    int i2 = GloableValue.jdField_a_of_type_ArrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if ((paramArrayOfInt[0] == GloableValue.jdField_a_of_type_ArrayOfInt[i1]) && (paramArrayOfInt[1] == GloableValue.jdField_b_of_type_ArrayOfInt[i1])) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  private void b(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i2 = GloableValue.jdField_c_of_type_ArrayOfInt.length / 2;
    int i1 = 0;
    if (i1 < i2)
    {
      int i3 = a(GloableValue.jdField_c_of_type_ArrayOfInt[(i1 * 2 + 1)], paramBoolean);
      if ((GloableValue.jdField_c_of_type_ArrayOfInt[(i1 * 2)] != paramInt1) || (i3 != paramInt2)) {}
    }
    for (;;)
    {
      if ((i1 >= 0) && (jdField_a_of_type_ArrayOfInt[i1] != this.jdField_f_of_type_Int)) {
        this.jdField_f_of_type_Int = jdField_a_of_type_ArrayOfInt[i1];
      }
      return;
      i1 += 1;
      break;
      i1 = -1;
    }
  }
  
  private void c(int paramInt)
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(paramInt);
  }
  
  private void d(int paramInt)
  {
    if ((paramInt != -1) && (paramInt < GloableValue.h.length))
    {
      paramInt *= 4;
      CodecParam.j = GloableValue.jdField_c_of_type_ArrayOfInt[paramInt];
      CodecParam.k = GloableValue.jdField_c_of_type_ArrayOfInt[(paramInt + 1)];
      CodecParam.l = GloableValue.jdField_c_of_type_ArrayOfInt[(paramInt + 2)];
      CodecParam.m = GloableValue.jdField_c_of_type_ArrayOfInt[(paramInt + 3)];
      return;
    }
    CodecParam.j = GloableValue.jdField_f_of_type_Int;
    CodecParam.k = GloableValue.jdField_f_of_type_Int * 3 / 4;
    CodecParam.l = CodecParam.j * CodecParam.h / CodecParam.i;
    CodecParam.m = CodecParam.k * CodecParam.h / CodecParam.i;
  }
  
  private void m()
  {
    this.k = false;
  }
  
  private native void setBeautyLevelNative(int paramInt);
  
  private native void setResolutionAlignedByteNative(int paramInt);
  
  private native void setVideoClipSpec(int[] paramArrayOfInt);
  
  public float a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_f_of_type_Int <= 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.e <= 0)) {
      return 1.3333334F;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.e * 1.0F / this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_f_of_type_Int;
  }
  
  public int a()
  {
    return this.G;
  }
  
  int a(int paramInt, boolean paramBoolean)
  {
    int i1 = paramInt;
    if (a(paramBoolean))
    {
      int i2 = paramInt % 16;
      i1 = paramInt;
      if (i2 > 0) {
        i1 = paramInt + (16 - i2);
      }
    }
    return i1;
  }
  
  public int a(TCTimer.TCTimerCallback paramTCTimerCallback, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    int i1 = -1;
    if (paramTCTimerCallback == this)
    {
      a().a(paramTCTimerCallback, paramBoolean, paramInt1, paramInt2);
      i1 = 0;
    }
    return i1;
  }
  
  public RMVideoState a()
  {
    int i1 = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    pdn localpdn = this.jdField_a_of_type_Pdn;
    switch (i1)
    {
    default: 
      return localpdn;
    case 2: 
      return this.jdField_a_of_type_Pdm;
    case 3: 
      return this.jdField_a_of_type_Pdt;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoPreviewState;
  }
  
  public void a()
  {
    if (this.h) {
      GloableValue.a();
    }
    StorageManager.a().a(this);
    a().a();
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy != null) && (!this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    c(paramInt);
    a().a();
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    i();
    int i1 = 0;
    while (i1 < paramInt2)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.removeLatestVideo();
      if (paramBoolean) {
        AVCodec.get().removeLastCapture();
      }
      i1 += 1;
    }
    this.jdField_a_of_type_Double = paramInt1;
    RecordManager.a().a().b(paramInt1);
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndAdd(0) < 3) {
      h();
    }
  }
  
  public void a(int paramInt1, RMVideoClipSpec paramRMVideoClipSpec, int paramInt2)
  {
    switch (paramInt1)
    {
    case 3: 
    default: 
      return;
    case 1: 
    case 2: 
      paramRMVideoClipSpec.jdField_a_of_type_Int = paramInt2;
      paramRMVideoClipSpec.b = 0;
      return;
    }
    paramRMVideoClipSpec.jdField_a_of_type_Int = (paramRMVideoClipSpec.e - paramRMVideoClipSpec.d - paramInt2);
    paramRMVideoClipSpec.b = 0;
  }
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      GloableValue.c();
      a().f();
      if (paramInt == 0)
      {
        a(0, "SD卡被移除，短视频将退出", false);
        if (1 == FlowCameraMqqAction.jdField_a_of_type_Int) {
          QzoneVideoBeaconReport.a(GloableValue.jdField_a_of_type_Long + "", "qzone_video_record", "1", null);
        }
      }
      return;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      for (;;) {}
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface.a(paramInt, paramString, paramBoolean);
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt1, String paramString, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4)
  {
    int i3 = 2;
    if (paramInt1 == 0)
    {
      PtvFilterUtils.a(0);
      if (QLog.isColorLevel()) {
        QLog.d("FlowCameraActivity", 2, "initVideoParams(): ptvMaxTime=" + paramInt4);
      }
      CodecParam.J = 0;
      CodecParam.M = 0;
      CodecParam.a();
      CodecParam.d = paramInt4 * 1000;
      VideoEnvironment.b();
      paramBoolean = CameraCompatibleList.a(CameraCompatibleList.l);
      if (QLog.isColorLevel()) {
        QLog.e("RMVideoStateMgr", 2, "isFoundProductFeature:need640Black=" + paramBoolean);
      }
      if (paramBoolean)
      {
        GloableValue.e = 640;
        GloableValue.jdField_f_of_type_Int = 480;
        if (QLog.isColorLevel()) {
          QLog.e("RMVideoStateMgr", 2, "isFoundProductFeature:true[640*480]");
        }
      }
      for (;;)
      {
        this.G = 1;
        AudioCapture.d = 4000;
        return;
        paramBoolean = CameraCompatibleList.a(CameraCompatibleList.s);
        if (QLog.isColorLevel()) {
          QLog.e("RMVideoStateMgr", 2, "isFoundProductFeature:need1024Black=" + paramBoolean);
        }
        if (paramBoolean)
        {
          GloableValue.e = 1024;
          GloableValue.jdField_f_of_type_Int = 768;
          if (QLog.isColorLevel()) {
            QLog.e("RMVideoStateMgr", 2, "isFoundProductFeature:true[1024*768]");
          }
        }
        else
        {
          GloableValue.e = 320;
          GloableValue.jdField_f_of_type_Int = 240;
        }
      }
    }
    if (paramInt1 == 1)
    {
      PtvFilterUtils.a(0);
      AudioCapture.d = 4000;
      AudioCapture.e = 1;
      CodecParam.M = 1;
      CodecParam.a();
    }
    for (;;)
    {
      int i1;
      try
      {
        VideoEnvironment.a(paramAppInterface, paramString, paramBoolean);
        VideoEnvironment.a();
        paramAppInterface = VideoEnvironment.a(paramInt2, false);
        if (a(paramAppInterface))
        {
          i1 = a(paramAppInterface);
          GloableValue.e = paramAppInterface[0];
          GloableValue.jdField_f_of_type_Int = paramAppInterface[1];
          paramInt4 = paramAppInterface[2];
          paramInt1 = paramAppInterface[3];
          d(i1);
          paramAppInterface = VideoEnvironment.a(paramInt2);
          if (paramInt3 != 1) {
            continue;
          }
          paramInt2 = paramAppInterface[0];
          if (paramInt2 != 0) {
            break label1290;
          }
          if (paramInt4 > 0)
          {
            VideoEnvironment.c(paramInt4);
            VideoEnvironment.b(paramInt4);
            this.jdField_f_of_type_Int = paramInt4;
          }
          this.jdField_f_of_type_Boolean = true;
          this.G = 2;
        }
      }
      catch (Throwable paramAppInterface)
      {
        paramAppInterface.printStackTrace();
        continue;
        GloableValue.e = GloableValue.g[1];
        GloableValue.jdField_f_of_type_Int = GloableValue.h[1];
        paramInt4 = 450;
        paramInt1 = 750;
        i1 = 1;
        continue;
        if ((paramInt3 == 4) || (paramInt3 == 3))
        {
          paramInt2 = paramAppInterface[1];
          continue;
        }
        paramInt2 = paramAppInterface[2];
        continue;
      }
      if (paramInt1 == 2)
      {
        PtvFilterUtils.a(1);
        CodecParam.J = 0;
        CodecParam.M = 0;
        CodecParam.a();
      }
      for (;;)
      {
        try
        {
          VideoEnvironment.a(paramAppInterface, paramString, false);
          VideoEnvironment.a();
          paramAppInterface = VideoEnvironment.a(paramInt2, true);
          if (a(paramAppInterface))
          {
            i1 = b(paramAppInterface);
            GloableValue.e = paramAppInterface[0];
            GloableValue.jdField_f_of_type_Int = paramAppInterface[1];
            paramInt4 = paramAppInterface[2];
            paramInt1 = paramAppInterface[3];
            d(i1);
            paramAppInterface = VideoEnvironment.a(paramInt2);
            if (paramInt3 != 1) {
              continue;
            }
            paramInt2 = paramAppInterface[0];
            if (paramInt2 != 0) {
              break label1284;
            }
            if (paramInt4 > 0)
            {
              VideoEnvironment.c(paramInt4);
              VideoEnvironment.b(paramInt4);
              if (paramInt2 != 1) {
                continue;
              }
              paramBoolean = true;
              VideoEnvironment.a(paramInt4, paramBoolean);
              this.jdField_f_of_type_Int = paramInt4;
            }
            this.G = 3;
            AudioCapture.d = 4000;
            AudioCapture.e = 1;
            if (CameraCompatibleList.e(CameraCompatibleList.u)) {
              PtvFilterUtils.b(false);
            }
            paramInt2 = VcSystemInfo.e();
            paramInt1 = paramInt2;
            if (paramInt2 > 4) {
              paramInt1 = 4;
            }
            paramInt2 = paramInt1;
            if (paramInt1 <= 0) {
              paramInt2 = 2;
            }
            paramInt1 = paramInt2;
            if (paramInt2 != 1)
            {
              paramInt1 = paramInt2;
              if (paramInt2 % 2 != 0) {
                paramInt1 = 2;
              }
            }
            PtvFilterUtils.b(paramInt1);
          }
        }
        catch (Throwable paramAppInterface)
        {
          paramAppInterface.printStackTrace();
          continue;
          GloableValue.e = GloableValue.jdField_a_of_type_ArrayOfInt[1];
          GloableValue.jdField_f_of_type_Int = GloableValue.jdField_b_of_type_ArrayOfInt[1];
          paramInt4 = 450;
          paramInt1 = 750;
          i1 = 1;
          continue;
          if ((paramInt3 == 4) || (paramInt3 == 3))
          {
            paramInt2 = paramAppInterface[1];
            continue;
          }
          paramInt2 = paramAppInterface[2];
          continue;
          paramBoolean = false;
          continue;
        }
        if (paramInt1 == 3)
        {
          PtvFilterUtils.a(1);
          CodecParam.J = 0;
          CodecParam.M = 0;
          CodecParam.a();
        }
        for (;;)
        {
          try
          {
            VideoEnvironment.a(paramAppInterface, paramString, false);
            VideoEnvironment.a();
            paramAppInterface = VideoEnvironment.a(paramInt2, true);
            if (a(paramAppInterface))
            {
              i2 = b(paramAppInterface);
              GloableValue.e = paramAppInterface[0];
              GloableValue.jdField_f_of_type_Int = paramAppInterface[1];
              i1 = paramAppInterface[2];
              paramInt1 = paramAppInterface[3];
              d(i2);
              paramAppInterface = VideoEnvironment.a(paramInt2);
              if (paramInt3 != 1) {
                continue;
              }
              paramInt2 = paramAppInterface[0];
              if (paramInt2 != 0) {
                break label1278;
              }
              if (i1 > 0)
              {
                VideoEnvironment.d(paramInt4);
                VideoEnvironment.b(i1);
                if (paramInt2 != 1) {
                  continue;
                }
                paramBoolean = true;
                VideoEnvironment.a(i1, paramBoolean);
                this.jdField_f_of_type_Int = i1;
              }
              this.G = 3;
              AudioCapture.d = 4000;
              AudioCapture.e = 1;
              if (CameraCompatibleList.e(CameraCompatibleList.u)) {
                PtvFilterUtils.b(false);
              }
              paramInt2 = VcSystemInfo.e();
              paramInt1 = paramInt2;
              if (paramInt2 > 4) {
                paramInt1 = 4;
              }
              paramInt2 = paramInt1;
              if (paramInt1 <= 0) {
                paramInt2 = 2;
              }
              if ((paramInt2 == 1) || (paramInt2 % 2 == 0)) {
                break label1272;
              }
              paramInt1 = i3;
              PtvFilterUtils.b(paramInt1);
            }
          }
          catch (Throwable paramAppInterface)
          {
            paramAppInterface.printStackTrace();
            continue;
            GloableValue.e = GloableValue.jdField_a_of_type_ArrayOfInt[1];
            GloableValue.jdField_f_of_type_Int = GloableValue.jdField_b_of_type_ArrayOfInt[1];
            i1 = 450;
            paramInt1 = 750;
            int i2 = 1;
            continue;
            if ((paramInt3 == 4) || (paramInt3 == 3))
            {
              paramInt2 = paramAppInterface[1];
              continue;
            }
            paramInt2 = paramAppInterface[2];
            continue;
            paramBoolean = false;
            continue;
          }
          if (paramInt1 != 4) {
            break;
          }
          PtvFilterUtils.a(0);
          if (QLog.isColorLevel()) {
            QLog.d("FlowCameraActivity", 2, "initVideoParams(): ptvMaxTime=" + paramInt4);
          }
          CodecParam.J = 0;
          CodecParam.M = 0;
          CodecParam.a();
          CodecParam.d = paramInt4 * 1000;
          VideoEnvironment.b();
          CodecParam.g = 18;
          paramBoolean = CameraCompatibleList.a(CameraCompatibleList.l);
          if (QLog.isColorLevel()) {
            QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:need640Black=" + paramBoolean);
          }
          if (paramBoolean)
          {
            GloableValue.e = 640;
            GloableValue.jdField_f_of_type_Int = 480;
            if (QLog.isColorLevel()) {
              QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:true[640*480]");
            }
          }
          for (;;)
          {
            this.G = 4;
            AudioCapture.d = 4000;
            return;
            paramBoolean = CameraCompatibleList.a(CameraCompatibleList.s);
            if (QLog.isColorLevel()) {
              QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:need1024Black=" + paramBoolean);
            }
            if (paramBoolean)
            {
              GloableValue.e = 1024;
              GloableValue.jdField_f_of_type_Int = 768;
              if (QLog.isColorLevel()) {
                QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:true[1024*768]");
              }
            }
            else
            {
              GloableValue.e = 640;
              GloableValue.jdField_f_of_type_Int = 480;
            }
          }
          label1272:
          paramInt1 = paramInt2;
          continue;
          label1278:
          i1 = paramInt1;
        }
        label1284:
        paramInt4 = paramInt1;
      }
      label1290:
      paramInt4 = paramInt1;
    }
  }
  
  public void a(RMVideoClipSpec paramRMVideoClipSpec, boolean paramBoolean)
  {
    for (int i1 = 1;; i1 = 0)
    {
      try
      {
        boolean bool1 = CameraCompatibleList.d(CameraCompatibleList.e);
        boolean bool2 = CameraCompatibleList.b(CameraCompatibleList.f);
        boolean bool3 = CameraCompatibleList.b(CameraCompatibleList.x);
        if (((bool1) || (bool2) || (bool3)) && (FlowCameraConstant.d == 1)) {
          paramRMVideoClipSpec.b = (-paramRMVideoClipSpec.b);
        }
        this.jdField_b_of_type_ArrayOfInt[0] = paramRMVideoClipSpec.jdField_a_of_type_Int;
        this.jdField_b_of_type_ArrayOfInt[1] = paramRMVideoClipSpec.b;
        this.jdField_b_of_type_ArrayOfInt[2] = paramRMVideoClipSpec.jdField_c_of_type_Int;
        this.jdField_b_of_type_ArrayOfInt[3] = paramRMVideoClipSpec.d;
        this.jdField_b_of_type_ArrayOfInt[4] = paramRMVideoClipSpec.e;
        this.jdField_b_of_type_ArrayOfInt[5] = paramRMVideoClipSpec.jdField_f_of_type_Int;
        int[] arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
        if (FlowCameraConstant.d != 1) {
          continue;
        }
        arrayOfInt[6] = i1;
        if (QLog.isColorLevel()) {
          QLog.i("RMVideoStateMgr", 2, "setVideoClipSpecdst_width=" + paramRMVideoClipSpec.e + "spec.dst_height=" + paramRMVideoClipSpec.jdField_f_of_type_Int + "xoffset=" + paramRMVideoClipSpec.jdField_a_of_type_Int + "y_offset=" + paramRMVideoClipSpec.b + "clip_width=" + paramRMVideoClipSpec.jdField_c_of_type_Int + "clip_height" + paramRMVideoClipSpec.d);
        }
        setVideoClipSpec(this.jdField_b_of_type_ArrayOfInt);
      }
      catch (UnsatisfiedLinkError paramRMVideoClipSpec)
      {
        for (;;)
        {
          paramRMVideoClipSpec.printStackTrace();
        }
      }
      b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.e, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_f_of_type_Int, paramBoolean);
      return;
    }
  }
  
  public void a(CameraProxy paramCameraProxy)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy = paramCameraProxy;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy != null) {
      paramCameraProxy.a(this);
    }
  }
  
  public void a(PreviewContext paramPreviewContext)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.jdField_a_of_type_Int = this.G;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext = paramPreviewContext;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame = true;
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      a().a(paramObject, paramInt, paramVarArgs);
    }
    do
    {
      return;
    } while ((!CameraProxy.CameraPreviewObservable.class.isInstance(paramObject)) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext == null));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame = true;
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
  }
  
  public void a(String paramString)
  {
    i();
    if (QLog.isColorLevel()) {
      QLog.d("" + paramString, 2, "[@][deleteCacheFile] [RMFileEventNotify]stopWatching");
    }
    if (this.jdField_a_of_type_JavaLangString != null) {
      FileUtils.a(this.jdField_a_of_type_JavaLangString, false);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4;
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = false;
    if (paramInt == 4) {
      bool = a().a();
    }
    return bool;
  }
  
  public boolean a(Context paramContext, String paramString, RMViewSTInterface paramRMViewSTInterface)
  {
    c(1);
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    GloableValue.jdField_c_of_type_Int = localDisplayMetrics.widthPixels;
    GloableValue.d = localDisplayMetrics.heightPixels;
    this.i = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Double = 0.0D;
    this.g = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext = null;
    this.c = false;
    this.d = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface = paramRMViewSTInterface;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.l = true;
    if (!a(paramContext, paramString, GloableValue.jdField_c_of_type_ArrayOfInt[4], GloableValue.jdField_c_of_type_ArrayOfInt[5]))
    {
      if (QLog.isColorLevel()) {
        QLog.e("RMVideoStateMgr", 2, "initTMMEngine[failed]");
      }
      if (1 == FlowCameraMqqAction.jdField_a_of_type_Int) {
        QzoneVideoBeaconReport.a(paramString, "qzone_video_record", "0", null);
      }
      return false;
    }
    b(1);
    PtvFilterUtils.b(true);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a = ((RMVideoSwitchCameraPicMgr.ViewBitmapSource)paramContext);
      RecordManager.a().a().addCodecCallback(this);
      RecordManager.a().a().a(this);
      StorageManager.a();
      if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface.h();
        RecordManager.a().a().b();
        RecordManager.a().a();
      }
      RecordManager.a().a().a(this);
      RecordManager.a().a().a();
      return true;
    }
    catch (ClassCastException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public boolean a(int[] paramArrayOfInt)
  {
    return (paramArrayOfInt != null) && (paramArrayOfInt.length == 4) && (paramArrayOfInt[0] > 0) && (paramArrayOfInt[1] > 0);
  }
  
  public void b()
  {
    GloableValue.b();
    a().f();
    StorageManager.a().a(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause.jdField_a_of_type_Boolean = true;
  }
  
  public void b(int paramInt)
  {
    try
    {
      setBeautyLevelNative(paramInt);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  public void b(int paramInt1, RMVideoClipSpec paramRMVideoClipSpec, int paramInt2)
  {
    switch (paramInt1)
    {
    case 3: 
    default: 
      return;
    case 1: 
      paramRMVideoClipSpec.jdField_a_of_type_Int = paramInt2;
      paramRMVideoClipSpec.b = (paramRMVideoClipSpec.jdField_f_of_type_Int - paramRMVideoClipSpec.jdField_c_of_type_Int);
      return;
    case 2: 
      paramRMVideoClipSpec.jdField_a_of_type_Int = paramInt2;
      paramRMVideoClipSpec.b = 0;
      return;
    case 4: 
      paramRMVideoClipSpec.jdField_a_of_type_Int = (paramRMVideoClipSpec.e - paramRMVideoClipSpec.d - paramInt2);
      paramRMVideoClipSpec.b = (paramRMVideoClipSpec.jdField_f_of_type_Int - paramRMVideoClipSpec.jdField_c_of_type_Int);
      return;
    case 5: 
      paramRMVideoClipSpec.jdField_a_of_type_Int = (paramRMVideoClipSpec.e - paramRMVideoClipSpec.d - paramInt2);
      paramRMVideoClipSpec.b = 0;
      return;
    }
    paramRMVideoClipSpec.jdField_a_of_type_Int = 0;
    paramRMVideoClipSpec.b = (-(paramRMVideoClipSpec.jdField_f_of_type_Int - paramRMVideoClipSpec.jdField_c_of_type_Int) / 2);
  }
  
  public void b(int paramInt, String paramString, boolean paramBoolean)
  {
    Toast.makeText(VideoEnvironment.a(), "" + paramString, 0).show();
  }
  
  public void b(boolean paramBoolean)
  {
    c(1);
    a().a(paramBoolean);
    a().a();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause.jdField_a_of_type_Boolean)) {
      a().f();
    }
  }
  
  public boolean b()
  {
    return this.j;
  }
  
  public boolean b(int paramInt)
  {
    try
    {
      setResolutionAlignedByteNative(paramInt);
      return true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext = null;
      this.jdField_a_of_type_AndroidContentContext = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface.h();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface = null;
      this.jdField_a_of_type_Pdn.f();
      this.jdField_a_of_type_Pdn.g();
      this.jdField_a_of_type_Pdm.f();
      this.jdField_a_of_type_Pdm.g();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture = null;
      i();
      this.jdField_a_of_type_Pdk = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a = null;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture$OnAudioRecordListener = null;
      f();
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy = null;
  }
  
  public void c(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy == null) {}
    while ((!this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.b.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.c.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.b.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.c.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize))) {
      return true;
    }
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Double = 0.0D;
    RecordManager.a().a().c();
    if (RecordManager.a().a().a.getState() == Thread.State.TERMINATED)
    {
      RecordManager.a().a();
      RecordManager.a().a().a(this);
      RecordManager.a().a().a();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public boolean d()
  {
    int i1 = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if (i1 == 3) {
      a().b();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RMVideoStateMgr", 2, "[exitRecordMode]currentState = " + i1 + " mCurrentSegInvalid=" + this.j);
      }
      return this.j;
      if (i1 == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RMVideoStateMgr", 2, "current = G_STATUS_IDLE ,so do not change state...");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause.jdField_b_of_type_Boolean = true;
      }
    }
  }
  
  public void e()
  {
    m();
    this.j = false;
    if (QLog.isColorLevel()) {
      QLog.e("RMVideoStateMgr", 2, "[enterRecordMode]currentState = " + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + " mCurrentSegInvalid=" + this.j);
    }
    a().b();
  }
  
  public boolean e()
  {
    long l1 = StorageManager.a(StorageManager.a().d);
    if (l1 <= StorageManager.c)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RMVideoStateMgr", 2, "[@] checkDiskSpaceIsOK,freeSpace <= FREESPACE_LIMIT_EXIT freeSpace=" + l1 + "StorageManager.FREESPACE_LIMIT_EXIT=" + StorageManager.c + " 手机剩余存储空间不足");
      }
      a(0, "手机剩余存储空间不足,清理外部存储空间后再试", false);
      return false;
    }
    return true;
  }
  
  public void f()
  {
    if (this.i) {
      return;
    }
    RecordManager.a().a().b();
    RecordManager.a().a().a(null);
    RecordManager.a().a().removeCodecCallback(this);
    RecordManager.a().a().recycle();
    RecordManager.a().a().a();
    RecordManager.a().a();
    try
    {
      GloableValue.c();
      StorageManager.a().a();
      this.i = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
      }
    }
  }
  
  public boolean f()
  {
    if (!this.k) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        boolean bool = this.k;
        if (!bool) {}
        try
        {
          this.jdField_a_of_type_JavaLangObject.wait(500L);
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
    return true;
  }
  
  public void g()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.k = true;
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  public boolean g()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) && (this.c);
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_Pdk != null) && (this.jdField_a_of_type_Double > 0.0D)) {
      this.jdField_a_of_type_Pdk.startWatching();
    }
  }
  
  public boolean h()
  {
    return this.l;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Pdk != null) {
      this.jdField_a_of_type_Pdk.stopWatching();
    }
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, "[@][initAudioRecord]mIsAudioReady=" + this.c + " mAI=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture);
    }
    if (!g())
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture = new AudioCapture(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.a(this);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, "[@][initAudioRecord]");
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.d();
    }
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, "[@][openAudioRecord]");
    }
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, "[@][closeAudioRecord]mIsAudioReady=" + this.c + " mAI=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture);
    }
    if (g())
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.b(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture$OnAudioRecordListener);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.g();
      if (QLog.isColorLevel()) {
        QLog.d("RMVideoStateMgr", 2, "[@][closeAudioRecord]");
      }
    }
    this.c = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture = null;
    this.d = false;
  }
  
  public void onAVCodecEvent(AVCodec.AVCodecCallback arg1, MessageStruct paramMessageStruct)
  {
    a().a(???, paramMessageStruct);
    if (paramMessageStruct.mId == 33554451)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RMVideoStateMgr", 2, "[@] onAVCodecEvent, MSG_RECORD_SUBMIT_FINISH_CALLBACK");
      }
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.notifyAll();
        if (QLog.isColorLevel()) {
          QLog.d("RMVideoStateMgr", 2, "[@] onAVCodecEvent, MSG_RECORD_SUBMIT_FINISH_CALLBACK ,notifyAll");
        }
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\state\RMVideoStateMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */