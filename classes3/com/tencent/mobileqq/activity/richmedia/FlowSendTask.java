package com.tencent.mobileqq.activity.richmedia;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.TextView;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoClipSpec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoThumbGenMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoThumbGenMgr.ThumbGenItem;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.RecordManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.test.PerformenceDataTag;
import com.tencent.mobileqq.shortvideo.tools.QzoneBaseThread;
import com.tencent.mobileqq.shortvideo.tools.QzoneHandlerThreadFactory;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import mqq.os.MqqHandler;
import paa;
import pac;

public class FlowSendTask
  extends AsyncTask
{
  static final int jdField_a_of_type_Int = 0;
  static final String jdField_a_of_type_JavaLangString = "FlowSendTask";
  private static AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong;
  static final int jdField_b_of_type_Int = -1;
  static final int jdField_c_of_type_Int = -2;
  static long jdField_c_of_type_Long = 0L;
  static final int jdField_d_of_type_Int = -3;
  static final int jdField_e_of_type_Int = -4;
  static final int jdField_f_of_type_Int = -5;
  static final int jdField_g_of_type_Int = -6;
  static final int jdField_h_of_type_Int = -7;
  static final int i = -8;
  static final int j = -9;
  static final int k = 10;
  double jdField_a_of_type_Double;
  float jdField_a_of_type_Float;
  long jdField_a_of_type_Long;
  public Activity a;
  ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  FlowComponentInterface jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface;
  public RMVideoStateMgr a;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  boolean jdField_a_of_type_Boolean;
  double jdField_b_of_type_Double;
  long jdField_b_of_type_Long = 0L;
  public String b;
  ArrayList jdField_b_of_type_JavaUtilArrayList = null;
  public boolean b;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean;
  String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean = false;
  String jdField_e_of_type_JavaLangString;
  String jdField_f_of_type_JavaLangString;
  String jdField_g_of_type_JavaLangString;
  String jdField_h_of_type_JavaLangString;
  public String i = "";
  int l;
  int m;
  int n;
  int o;
  int p;
  int q;
  int r;
  int s = 0;
  public int t;
  int u;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
    jdField_c_of_type_Long = 20000L;
    bool = CameraCompatibleList.e(CameraCompatibleList.t);
    if (QLog.isColorLevel()) {
      QLog.d("FlowSendTask", 2, "KEY_IO_RW_VERY_SLOW_MODLE: ioSlow=" + bool);
    }
    if (bool) {
      jdField_c_of_type_Long = 46000L;
    }
  }
  
  public FlowSendTask(Activity paramActivity, RMVideoStateMgr paramRMVideoStateMgr, String paramString1, int paramInt1, String paramString2, float paramFloat, boolean paramBoolean, double paramDouble1, double paramDouble2, FlowComponentInterface paramFlowComponentInterface, int paramInt2, int paramInt3)
  {
    a(paramActivity, paramRMVideoStateMgr, paramString1, paramInt1, paramString2, paramFloat, paramBoolean, paramDouble1, paramDouble2, paramFlowComponentInterface, paramInt2, paramInt3);
  }
  
  public FlowSendTask(Activity paramActivity, RMVideoStateMgr paramRMVideoStateMgr, String paramString1, int paramInt1, String paramString2, float paramFloat, boolean paramBoolean1, double paramDouble1, double paramDouble2, FlowComponentInterface paramFlowComponentInterface, int paramInt2, int paramInt3, String paramString3, int paramInt4, ArrayList paramArrayList, boolean paramBoolean2)
  {
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.n = paramInt4;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    a(paramActivity, paramRMVideoStateMgr, paramString1, paramInt1, paramString2, paramFloat, paramBoolean1, paramDouble1, paramDouble2, paramFlowComponentInterface, paramInt2, paramInt3);
  }
  
  private void a(Activity paramActivity, RMVideoStateMgr paramRMVideoStateMgr, String paramString1, int paramInt1, String paramString2, float paramFloat, boolean paramBoolean, double paramDouble1, double paramDouble2, FlowComponentInterface paramFlowComponentInterface, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr = paramRMVideoStateMgr;
    this.jdField_b_of_type_JavaLangString = paramRMVideoStateMgr.jdField_a_of_type_JavaLangString;
    this.l = ((int)paramRMVideoStateMgr.jdField_a_of_type_Double);
    this.jdField_b_of_type_Long = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.getAndIncrement();
    this.i = ("FlowSendTask_[mSessionId=" + this.jdField_b_of_type_Long + "]");
    if (QLog.isColorLevel()) {
      QLog.d(this.i, 2, "FlowSendTask(): structureMethod: totalFrame=" + paramInt3);
    }
    if (paramInt3 <= 0)
    {
      this.m = paramRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex();
      if (QLog.isColorLevel()) {
        QLog.d(this.i, 2, "FlowSendTask(): structureMethod: recordFrames=" + this.m);
      }
      this.u = (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.e * this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.f * 3 / 2);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface = paramFlowComponentInterface;
      this.jdField_d_of_type_Boolean = false;
      this.s = paramInt2;
      this.jdField_d_of_type_JavaLangString = paramString1;
      this.o = paramInt1;
      this.e = paramString2;
      this.jdField_a_of_type_Float = paramFloat;
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_c_of_type_Boolean = false;
      this.r = ((this.l + 500) / 1000);
      this.p = 320;
      if ((RMVideoStateMgr.jdField_a_of_type_Boolean) && (!paramBoolean)) {
        this.p = paramRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.e;
      }
      if (paramBoolean)
      {
        this.p = 160;
        paramActivity = paramActivity.getIntent();
        this.jdField_b_of_type_JavaUtilArrayList = paramActivity.getStringArrayListExtra("uin_list");
        this.h = paramActivity.getStringExtra("bless_ptv_mp4_path");
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.i, 2, "FlowSendTask() constructor : isPTV:" + this.jdField_b_of_type_Boolean + ", mVideoFileDir:" + this.jdField_b_of_type_JavaLangString + " recordTime=" + this.l + " mVideoRecordTime=" + this.r + " recordFrames=" + this.m);
      }
      this.q = ((int)(this.p / this.jdField_a_of_type_Float));
      if (this.q % 2 > 0) {
        this.q -= 1;
      }
      this.t = 0;
      if (!VideoEnvironment.e()) {
        break label701;
      }
      QzoneHandlerThreadFactory.a("Normal_HandlerThread", false).a(new paa(this));
    }
    for (;;)
    {
      if (!this.jdField_b_of_type_Boolean)
      {
        paramActivity = paramRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr.a();
        if ((paramActivity != null) && (paramActivity.jdField_c_of_type_JavaLangString != null) && (paramActivity.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3))
        {
          this.p = paramActivity.jdField_a_of_type_Int;
          this.q = paramActivity.b;
          this.f = paramActivity.jdField_c_of_type_JavaLangString;
          this.g = paramActivity.jdField_d_of_type_JavaLangString;
          this.jdField_c_of_type_Boolean = true;
        }
      }
      paramRMVideoStateMgr.f();
      this.jdField_a_of_type_Double = paramDouble1;
      this.jdField_b_of_type_Double = paramDouble2;
      if (QLog.isColorLevel()) {
        QLog.d(this.i, 2, "FlowSendTask(): isPTV:" + paramBoolean + ", mVideoFileDir:" + this.jdField_b_of_type_JavaLangString + ",mVideoRecordTime: " + this.r + ", recordFrames: " + this.m + ",mThumbWidth: " + this.p + ", mThumbHeight:" + this.q + ", mLatitude:" + this.jdField_a_of_type_Double + ", mLongitude:" + this.jdField_b_of_type_Double + ", mThumbOK:" + this.jdField_c_of_type_Boolean);
      }
      return;
      this.m = paramInt3;
      break;
      try
      {
        label701:
        RecordManager.a().a().recordSubmit();
      }
      catch (UnsatisfiedLinkError paramActivity)
      {
        paramActivity.printStackTrace();
        this.t = -6;
      }
    }
  }
  
  int a()
  {
    if (this.jdField_b_of_type_JavaLangString == null) {}
    File localFile;
    String[] arrayOfString;
    do
    {
      do
      {
        return -3;
        if (this.l <= 0) {
          return -9;
        }
        localFile = new File(this.jdField_b_of_type_JavaLangString);
      } while ((!localFile.exists()) || (!localFile.isDirectory()));
      arrayOfString = localFile.list();
    } while (arrayOfString == null);
    if (QLog.isColorLevel()) {
      QLog.d(this.i, 2, "checkVideoSourceValidate(), sourceDirFile =" + localFile.getAbsolutePath() + ",files = " + Arrays.toString(arrayOfString) + ",filse count = " + localFile.listFiles().length);
    }
    int i5 = arrayOfString.length;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    while (i1 < i5)
    {
      String str = arrayOfString[i1];
      if (QLog.isColorLevel()) {
        QLog.d(this.i, 2, "checkVideoSourceValidate(), current file = " + str);
      }
      if (str.endsWith(".af")) {
        i3 = 1;
      }
      int i4 = i2;
      if (str.endsWith(".vf"))
      {
        long l1 = FileUtils.a(localFile.getAbsolutePath() + "/" + str);
        if (QLog.isColorLevel()) {
          QLog.d(this.i, 2, "checkVideoSourceValidate(), videofilesize = " + l1);
        }
        if (this.m >= 10) {
          this.u *= 5;
        }
        i4 = i2;
        if (l1 > this.u) {
          i4 = 1;
        }
      }
      i1 += 1;
      i2 = i4;
    }
    if (this.m <= 0) {
      return -8;
    }
    if (i3 == 0) {
      return -4;
    }
    if (i2 == 0) {
      return -5;
    }
    return 0;
  }
  
  /* Error */
  protected Integer a(Void... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 398	android/os/SystemClock:elapsedRealtime	()J
    //   4: putfield 400	com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_a_of_type_Long	J
    //   7: aload_0
    //   8: getfield 244	com/tencent/mobileqq/activity/richmedia/FlowSendTask:t	I
    //   11: ifeq +11 -> 22
    //   14: aload_0
    //   15: getfield 244	com/tencent/mobileqq/activity/richmedia/FlowSendTask:t	I
    //   18: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: areturn
    //   22: invokestatic 248	com/tencent/mobileqq/shortvideo/VideoEnvironment:e	()Z
    //   25: ifeq +275 -> 300
    //   28: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +14 -> 45
    //   34: aload_0
    //   35: getfield 118	com/tencent/mobileqq/activity/richmedia/FlowSendTask:i	Ljava/lang/String;
    //   38: iconst_2
    //   39: ldc_w 408
    //   42: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: lconst_0
    //   46: lstore 9
    //   48: aload_0
    //   49: getfield 139	com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   52: getfield 411	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   55: astore_1
    //   56: aload_1
    //   57: monitorenter
    //   58: aload_0
    //   59: getfield 139	com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   62: getfield 411	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   65: invokevirtual 415	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   68: istore 11
    //   70: lload 9
    //   72: lstore 7
    //   74: iload 11
    //   76: ifne +136 -> 212
    //   79: lload 9
    //   81: lstore 5
    //   83: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   86: ifeq +18 -> 104
    //   89: lload 9
    //   91: lstore 5
    //   93: aload_0
    //   94: getfield 118	com/tencent/mobileqq/activity/richmedia/FlowSendTask:i	Ljava/lang/String;
    //   97: iconst_2
    //   98: ldc_w 417
    //   101: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: lload 9
    //   106: lstore 5
    //   108: invokestatic 398	android/os/SystemClock:elapsedRealtime	()J
    //   111: lstore 7
    //   113: lload 9
    //   115: lstore 5
    //   117: aload_0
    //   118: getfield 137	com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   121: new 419	pab
    //   124: dup
    //   125: aload_0
    //   126: invokespecial 420	pab:<init>	(Lcom/tencent/mobileqq/activity/richmedia/FlowSendTask;)V
    //   129: invokevirtual 423	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   132: lload 9
    //   134: lstore 5
    //   136: aload_0
    //   137: getfield 139	com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   140: getfield 411	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   143: getstatic 72	com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_c_of_type_Long	J
    //   146: invokevirtual 428	java/lang/Object:wait	(J)V
    //   149: lload 9
    //   151: lstore 5
    //   153: invokestatic 398	android/os/SystemClock:elapsedRealtime	()J
    //   156: lload 7
    //   158: lsub
    //   159: lstore 9
    //   161: lload 9
    //   163: lstore 7
    //   165: lload 9
    //   167: lstore 5
    //   169: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   172: ifeq +40 -> 212
    //   175: lload 9
    //   177: lstore 5
    //   179: aload_0
    //   180: getfield 118	com/tencent/mobileqq/activity/richmedia/FlowSendTask:i	Ljava/lang/String;
    //   183: iconst_2
    //   184: new 87	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   191: ldc_w 430
    //   194: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: lload 9
    //   199: invokevirtual 158	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   202: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: lload 9
    //   210: lstore 7
    //   212: aload_1
    //   213: monitorexit
    //   214: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   217: ifeq +14 -> 231
    //   220: aload_0
    //   221: getfield 118	com/tencent/mobileqq/activity/richmedia/FlowSendTask:i	Ljava/lang/String;
    //   224: iconst_2
    //   225: ldc_w 432
    //   228: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   231: lload 7
    //   233: getstatic 72	com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_c_of_type_Long	J
    //   236: lcmp
    //   237: iflt +63 -> 300
    //   240: bipush -7
    //   242: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   245: areturn
    //   246: astore_2
    //   247: lload 5
    //   249: lstore 7
    //   251: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   254: ifeq -42 -> 212
    //   257: aload_0
    //   258: getfield 118	com/tencent/mobileqq/activity/richmedia/FlowSendTask:i	Ljava/lang/String;
    //   261: iconst_2
    //   262: new 87	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   269: ldc_w 434
    //   272: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_2
    //   276: invokevirtual 437	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   279: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: lload 5
    //   290: lstore 7
    //   292: goto -80 -> 212
    //   295: astore_2
    //   296: aload_1
    //   297: monitorexit
    //   298: aload_2
    //   299: athrow
    //   300: aload_0
    //   301: invokevirtual 439	com/tencent/mobileqq/activity/richmedia/FlowSendTask:a	()I
    //   304: istore 4
    //   306: iload 4
    //   308: ifeq +44 -> 352
    //   311: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   314: ifeq +32 -> 346
    //   317: aload_0
    //   318: getfield 118	com/tencent/mobileqq/activity/richmedia/FlowSendTask:i	Ljava/lang/String;
    //   321: iconst_2
    //   322: new 87	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   329: ldc_w 441
    //   332: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: iload 4
    //   337: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   340: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   346: iload 4
    //   348: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   351: areturn
    //   352: aload_0
    //   353: getfield 203	com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_c_of_type_Boolean	Z
    //   356: ifeq +256 -> 612
    //   359: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq +14 -> 376
    //   365: aload_0
    //   366: getfield 118	com/tencent/mobileqq/activity/richmedia/FlowSendTask:i	Ljava/lang/String;
    //   369: iconst_2
    //   370: ldc_w 443
    //   373: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   376: aload_0
    //   377: getfield 112	com/tencent/mobileqq/activity/richmedia/FlowSendTask:s	I
    //   380: bipush 90
    //   382: if_icmpeq +13 -> 395
    //   385: aload_0
    //   386: getfield 112	com/tencent/mobileqq/activity/richmedia/FlowSendTask:s	I
    //   389: sipush 270
    //   392: if_icmpne +23 -> 415
    //   395: aload_0
    //   396: getfield 207	com/tencent/mobileqq/activity/richmedia/FlowSendTask:p	I
    //   399: istore 4
    //   401: aload_0
    //   402: aload_0
    //   403: getfield 242	com/tencent/mobileqq/activity/richmedia/FlowSendTask:q	I
    //   406: putfield 207	com/tencent/mobileqq/activity/richmedia/FlowSendTask:p	I
    //   409: aload_0
    //   410: iload 4
    //   412: putfield 242	com/tencent/mobileqq/activity/richmedia/FlowSendTask:q	I
    //   415: aload_0
    //   416: getfield 290	com/tencent/mobileqq/activity/richmedia/FlowSendTask:f	Ljava/lang/String;
    //   419: aload_0
    //   420: getfield 296	com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_a_of_type_Double	D
    //   423: aload_0
    //   424: getfield 298	com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_b_of_type_Double	D
    //   427: invokestatic 448	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;DD)Z
    //   430: ifeq +117 -> 547
    //   433: new 335	java/io/File
    //   436: dup
    //   437: aload_0
    //   438: getfield 290	com/tencent/mobileqq/activity/richmedia/FlowSendTask:f	Ljava/lang/String;
    //   441: invokespecial 338	java/io/File:<init>	(Ljava/lang/String;)V
    //   444: astore_2
    //   445: new 450	java/io/FileInputStream
    //   448: dup
    //   449: aload_0
    //   450: getfield 290	com/tencent/mobileqq/activity/richmedia/FlowSendTask:f	Ljava/lang/String;
    //   453: invokespecial 451	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   456: astore_1
    //   457: aload_0
    //   458: aload_1
    //   459: aload_2
    //   460: invokevirtual 454	java/io/File:length	()J
    //   463: invokestatic 460	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   466: invokestatic 466	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   469: putfield 293	com/tencent/mobileqq/activity/richmedia/FlowSendTask:g	Ljava/lang/String;
    //   472: aload_1
    //   473: ifnull +7 -> 480
    //   476: aload_1
    //   477: invokevirtual 469	java/io/FileInputStream:close	()V
    //   480: aload_0
    //   481: getfield 293	com/tencent/mobileqq/activity/richmedia/FlowSendTask:g	Ljava/lang/String;
    //   484: invokestatic 475	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   487: ifeq +33 -> 520
    //   490: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   493: ifeq +14 -> 507
    //   496: aload_0
    //   497: getfield 118	com/tencent/mobileqq/activity/richmedia/FlowSendTask:i	Ljava/lang/String;
    //   500: iconst_2
    //   501: ldc_w 477
    //   504: invokestatic 479	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   507: iconst_m1
    //   508: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   511: areturn
    //   512: astore_1
    //   513: aload_1
    //   514: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   517: goto -37 -> 480
    //   520: aload_0
    //   521: getfield 293	com/tencent/mobileqq/activity/richmedia/FlowSendTask:g	Ljava/lang/String;
    //   524: ldc_w 482
    //   527: invokestatic 487	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   530: astore_1
    //   531: aload_0
    //   532: getfield 290	com/tencent/mobileqq/activity/richmedia/FlowSendTask:f	Ljava/lang/String;
    //   535: aload_1
    //   536: invokestatic 490	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   539: ifeq +13 -> 552
    //   542: aload_0
    //   543: aload_1
    //   544: putfield 290	com/tencent/mobileqq/activity/richmedia/FlowSendTask:f	Ljava/lang/String;
    //   547: iconst_0
    //   548: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   551: areturn
    //   552: aload_1
    //   553: invokestatic 492	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   556: ifne -9 -> 547
    //   559: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   562: ifeq +44 -> 606
    //   565: aload_0
    //   566: getfield 118	com/tencent/mobileqq/activity/richmedia/FlowSendTask:i	Ljava/lang/String;
    //   569: iconst_2
    //   570: new 87	java/lang/StringBuilder
    //   573: dup
    //   574: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   577: ldc_w 494
    //   580: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: aload_0
    //   584: getfield 290	com/tencent/mobileqq/activity/richmedia/FlowSendTask:f	Ljava/lang/String;
    //   587: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: ldc_w 496
    //   593: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload_1
    //   597: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: invokestatic 479	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   606: bipush -2
    //   608: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   611: areturn
    //   612: aload_0
    //   613: aload_0
    //   614: getfield 145	com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   617: aload_0
    //   618: getfield 207	com/tencent/mobileqq/activity/richmedia/FlowSendTask:p	I
    //   621: aload_0
    //   622: getfield 242	com/tencent/mobileqq/activity/richmedia/FlowSendTask:q	I
    //   625: aload_0
    //   626: getfield 112	com/tencent/mobileqq/activity/richmedia/FlowSendTask:s	I
    //   629: getstatic 502	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   632: invokestatic 507	com/tencent/mobileqq/shortvideo/cover/RecordThumbnailUtils:a	(Ljava/lang/String;IIILandroid/graphics/Bitmap$Config;)Ljava/lang/String;
    //   635: putfield 290	com/tencent/mobileqq/activity/richmedia/FlowSendTask:f	Ljava/lang/String;
    //   638: aload_0
    //   639: getfield 112	com/tencent/mobileqq/activity/richmedia/FlowSendTask:s	I
    //   642: bipush 90
    //   644: if_icmpeq +13 -> 657
    //   647: aload_0
    //   648: getfield 112	com/tencent/mobileqq/activity/richmedia/FlowSendTask:s	I
    //   651: sipush 270
    //   654: if_icmpne +23 -> 677
    //   657: aload_0
    //   658: getfield 207	com/tencent/mobileqq/activity/richmedia/FlowSendTask:p	I
    //   661: istore 4
    //   663: aload_0
    //   664: aload_0
    //   665: getfield 242	com/tencent/mobileqq/activity/richmedia/FlowSendTask:q	I
    //   668: putfield 207	com/tencent/mobileqq/activity/richmedia/FlowSendTask:p	I
    //   671: aload_0
    //   672: iload 4
    //   674: putfield 242	com/tencent/mobileqq/activity/richmedia/FlowSendTask:q	I
    //   677: aload_0
    //   678: getfield 290	com/tencent/mobileqq/activity/richmedia/FlowSendTask:f	Ljava/lang/String;
    //   681: invokestatic 475	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   684: ifeq +26 -> 710
    //   687: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   690: ifeq +14 -> 704
    //   693: aload_0
    //   694: getfield 118	com/tencent/mobileqq/activity/richmedia/FlowSendTask:i	Ljava/lang/String;
    //   697: iconst_2
    //   698: ldc_w 509
    //   701: invokestatic 479	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   704: bipush -2
    //   706: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   709: areturn
    //   710: aload_0
    //   711: getfield 290	com/tencent/mobileqq/activity/richmedia/FlowSendTask:f	Ljava/lang/String;
    //   714: aload_0
    //   715: getfield 296	com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_a_of_type_Double	D
    //   718: aload_0
    //   719: getfield 298	com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_b_of_type_Double	D
    //   722: invokestatic 448	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;DD)Z
    //   725: pop
    //   726: new 335	java/io/File
    //   729: dup
    //   730: aload_0
    //   731: getfield 290	com/tencent/mobileqq/activity/richmedia/FlowSendTask:f	Ljava/lang/String;
    //   734: invokespecial 338	java/io/File:<init>	(Ljava/lang/String;)V
    //   737: astore_3
    //   738: aload_3
    //   739: invokevirtual 341	java/io/File:exists	()Z
    //   742: ifeq +459 -> 1201
    //   745: new 450	java/io/FileInputStream
    //   748: dup
    //   749: aload_0
    //   750: getfield 290	com/tencent/mobileqq/activity/richmedia/FlowSendTask:f	Ljava/lang/String;
    //   753: invokespecial 451	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   756: astore_2
    //   757: aload_2
    //   758: astore_1
    //   759: aload_0
    //   760: aload_2
    //   761: aload_3
    //   762: invokevirtual 454	java/io/File:length	()J
    //   765: invokestatic 460	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   768: invokestatic 466	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   771: putfield 293	com/tencent/mobileqq/activity/richmedia/FlowSendTask:g	Ljava/lang/String;
    //   774: aload_2
    //   775: ifnull +7 -> 782
    //   778: aload_2
    //   779: invokevirtual 469	java/io/FileInputStream:close	()V
    //   782: aload_0
    //   783: getfield 293	com/tencent/mobileqq/activity/richmedia/FlowSendTask:g	Ljava/lang/String;
    //   786: invokestatic 475	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   789: ifeq +33 -> 822
    //   792: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   795: ifeq +14 -> 809
    //   798: aload_0
    //   799: getfield 118	com/tencent/mobileqq/activity/richmedia/FlowSendTask:i	Ljava/lang/String;
    //   802: iconst_2
    //   803: ldc_w 477
    //   806: invokestatic 479	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   809: iconst_m1
    //   810: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   813: areturn
    //   814: astore_1
    //   815: aload_1
    //   816: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   819: goto -37 -> 782
    //   822: aload_0
    //   823: getfield 293	com/tencent/mobileqq/activity/richmedia/FlowSendTask:g	Ljava/lang/String;
    //   826: ldc_w 482
    //   829: invokestatic 487	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   832: astore_1
    //   833: aload_0
    //   834: getfield 290	com/tencent/mobileqq/activity/richmedia/FlowSendTask:f	Ljava/lang/String;
    //   837: aload_1
    //   838: invokestatic 490	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   841: ifeq +13 -> 854
    //   844: aload_0
    //   845: aload_1
    //   846: putfield 290	com/tencent/mobileqq/activity/richmedia/FlowSendTask:f	Ljava/lang/String;
    //   849: iconst_0
    //   850: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   853: areturn
    //   854: aload_1
    //   855: invokestatic 492	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   858: ifne -9 -> 849
    //   861: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   864: ifeq +44 -> 908
    //   867: aload_0
    //   868: getfield 118	com/tencent/mobileqq/activity/richmedia/FlowSendTask:i	Ljava/lang/String;
    //   871: iconst_2
    //   872: new 87	java/lang/StringBuilder
    //   875: dup
    //   876: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   879: ldc_w 494
    //   882: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   885: aload_0
    //   886: getfield 290	com/tencent/mobileqq/activity/richmedia/FlowSendTask:f	Ljava/lang/String;
    //   889: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   892: ldc_w 496
    //   895: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: aload_1
    //   899: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   905: invokestatic 479	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   908: bipush -2
    //   910: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   913: areturn
    //   914: astore_3
    //   915: aconst_null
    //   916: astore_2
    //   917: aload_2
    //   918: astore_1
    //   919: aload_3
    //   920: invokevirtual 510	java/io/FileNotFoundException:printStackTrace	()V
    //   923: aload_2
    //   924: ifnull +7 -> 931
    //   927: aload_2
    //   928: invokevirtual 469	java/io/FileInputStream:close	()V
    //   931: aload_0
    //   932: getfield 293	com/tencent/mobileqq/activity/richmedia/FlowSendTask:g	Ljava/lang/String;
    //   935: invokestatic 475	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   938: ifeq +33 -> 971
    //   941: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   944: ifeq +14 -> 958
    //   947: aload_0
    //   948: getfield 118	com/tencent/mobileqq/activity/richmedia/FlowSendTask:i	Ljava/lang/String;
    //   951: iconst_2
    //   952: ldc_w 477
    //   955: invokestatic 479	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   958: iconst_m1
    //   959: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   962: areturn
    //   963: astore_1
    //   964: aload_1
    //   965: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   968: goto -37 -> 931
    //   971: aload_0
    //   972: getfield 293	com/tencent/mobileqq/activity/richmedia/FlowSendTask:g	Ljava/lang/String;
    //   975: ldc_w 482
    //   978: invokestatic 487	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   981: astore_1
    //   982: aload_0
    //   983: getfield 290	com/tencent/mobileqq/activity/richmedia/FlowSendTask:f	Ljava/lang/String;
    //   986: aload_1
    //   987: invokestatic 490	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   990: ifeq +11 -> 1001
    //   993: aload_0
    //   994: aload_1
    //   995: putfield 290	com/tencent/mobileqq/activity/richmedia/FlowSendTask:f	Ljava/lang/String;
    //   998: goto -149 -> 849
    //   1001: aload_1
    //   1002: invokestatic 492	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   1005: ifne -156 -> 849
    //   1008: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1011: ifeq +44 -> 1055
    //   1014: aload_0
    //   1015: getfield 118	com/tencent/mobileqq/activity/richmedia/FlowSendTask:i	Ljava/lang/String;
    //   1018: iconst_2
    //   1019: new 87	java/lang/StringBuilder
    //   1022: dup
    //   1023: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1026: ldc_w 494
    //   1029: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: aload_0
    //   1033: getfield 290	com/tencent/mobileqq/activity/richmedia/FlowSendTask:f	Ljava/lang/String;
    //   1036: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: ldc_w 496
    //   1042: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1045: aload_1
    //   1046: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1049: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1052: invokestatic 479	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1055: bipush -2
    //   1057: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1060: areturn
    //   1061: astore_2
    //   1062: aconst_null
    //   1063: astore_1
    //   1064: aload_1
    //   1065: ifnull +7 -> 1072
    //   1068: aload_1
    //   1069: invokevirtual 469	java/io/FileInputStream:close	()V
    //   1072: aload_0
    //   1073: getfield 293	com/tencent/mobileqq/activity/richmedia/FlowSendTask:g	Ljava/lang/String;
    //   1076: invokestatic 475	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1079: ifeq +33 -> 1112
    //   1082: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1085: ifeq +14 -> 1099
    //   1088: aload_0
    //   1089: getfield 118	com/tencent/mobileqq/activity/richmedia/FlowSendTask:i	Ljava/lang/String;
    //   1092: iconst_2
    //   1093: ldc_w 477
    //   1096: invokestatic 479	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1099: iconst_m1
    //   1100: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1103: areturn
    //   1104: astore_1
    //   1105: aload_1
    //   1106: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   1109: goto -37 -> 1072
    //   1112: aload_0
    //   1113: getfield 293	com/tencent/mobileqq/activity/richmedia/FlowSendTask:g	Ljava/lang/String;
    //   1116: ldc_w 482
    //   1119: invokestatic 487	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1122: astore_1
    //   1123: aload_0
    //   1124: getfield 290	com/tencent/mobileqq/activity/richmedia/FlowSendTask:f	Ljava/lang/String;
    //   1127: aload_1
    //   1128: invokestatic 490	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1131: ifeq +10 -> 1141
    //   1134: aload_0
    //   1135: aload_1
    //   1136: putfield 290	com/tencent/mobileqq/activity/richmedia/FlowSendTask:f	Ljava/lang/String;
    //   1139: aload_2
    //   1140: athrow
    //   1141: aload_1
    //   1142: invokestatic 492	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   1145: ifne -6 -> 1139
    //   1148: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1151: ifeq +44 -> 1195
    //   1154: aload_0
    //   1155: getfield 118	com/tencent/mobileqq/activity/richmedia/FlowSendTask:i	Ljava/lang/String;
    //   1158: iconst_2
    //   1159: new 87	java/lang/StringBuilder
    //   1162: dup
    //   1163: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1166: ldc_w 494
    //   1169: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1172: aload_0
    //   1173: getfield 290	com/tencent/mobileqq/activity/richmedia/FlowSendTask:f	Ljava/lang/String;
    //   1176: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1179: ldc_w 496
    //   1182: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1185: aload_1
    //   1186: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1189: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1192: invokestatic 479	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1195: bipush -2
    //   1197: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1200: areturn
    //   1201: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1204: ifeq +34 -> 1238
    //   1207: aload_0
    //   1208: getfield 118	com/tencent/mobileqq/activity/richmedia/FlowSendTask:i	Ljava/lang/String;
    //   1211: iconst_2
    //   1212: new 87	java/lang/StringBuilder
    //   1215: dup
    //   1216: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1219: ldc_w 512
    //   1222: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1225: aload_0
    //   1226: getfield 290	com/tencent/mobileqq/activity/richmedia/FlowSendTask:f	Ljava/lang/String;
    //   1229: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1232: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1235: invokestatic 479	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1238: bipush -2
    //   1240: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1243: areturn
    //   1244: astore_2
    //   1245: goto -181 -> 1064
    //   1248: astore_3
    //   1249: goto -332 -> 917
    //   1252: astore_1
    //   1253: aconst_null
    //   1254: astore_1
    //   1255: goto -783 -> 472
    //   1258: astore_2
    //   1259: goto -787 -> 472
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1262	0	this	FlowSendTask
    //   0	1262	1	paramVarArgs	Void[]
    //   246	30	2	localInterruptedException	InterruptedException
    //   295	4	2	localObject1	Object
    //   444	484	2	localObject2	Object
    //   1061	79	2	localObject3	Object
    //   1244	1	2	localObject4	Object
    //   1258	1	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   737	25	3	localFile	File
    //   914	6	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   1248	1	3	localFileNotFoundException3	java.io.FileNotFoundException
    //   304	369	4	i1	int
    //   81	208	5	l1	long
    //   72	219	7	l2	long
    //   46	163	9	l3	long
    //   68	7	11	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   83	89	246	java/lang/InterruptedException
    //   93	104	246	java/lang/InterruptedException
    //   108	113	246	java/lang/InterruptedException
    //   117	132	246	java/lang/InterruptedException
    //   136	149	246	java/lang/InterruptedException
    //   153	161	246	java/lang/InterruptedException
    //   169	175	246	java/lang/InterruptedException
    //   179	208	246	java/lang/InterruptedException
    //   58	70	295	finally
    //   83	89	295	finally
    //   93	104	295	finally
    //   108	113	295	finally
    //   117	132	295	finally
    //   136	149	295	finally
    //   153	161	295	finally
    //   169	175	295	finally
    //   179	208	295	finally
    //   212	214	295	finally
    //   251	288	295	finally
    //   296	298	295	finally
    //   476	480	512	java/io/IOException
    //   778	782	814	java/io/IOException
    //   745	757	914	java/io/FileNotFoundException
    //   927	931	963	java/io/IOException
    //   745	757	1061	finally
    //   1068	1072	1104	java/io/IOException
    //   759	774	1244	finally
    //   919	923	1244	finally
    //   759	774	1248	java/io/FileNotFoundException
    //   445	457	1252	java/io/FileNotFoundException
    //   457	472	1258	java/io/FileNotFoundException
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e(this.i, 2, "cancleProgressDailog");
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(Context paramContext, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e(this.i, 2, "showProgressDialog");
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        a();
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
        if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          break;
        }
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(paramContext, 2131558973);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130903453);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131298665));
      }
      return;
    }
    catch (Throwable paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.i, 2, "showProgressDialog", paramContext);
      }
    }
  }
  
  void a(Intent paramIntent)
  {
    paramIntent.putExtra("file_video_source_dir", this.jdField_b_of_type_JavaLangString);
    paramIntent.putExtra("thumbfile_send_path", this.f);
    paramIntent.putExtra("thumbfile_send_width", this.p);
    paramIntent.putExtra("thumbfile_send_height", this.q);
    paramIntent.putExtra("thumbfile_md5", this.g);
    paramIntent.putExtra("file_send_duration", this.r);
    paramIntent.putExtra("sv_encode_max_bitrate", CodecParam.D);
    paramIntent.putExtra("sv_encode_min_bitrate", CodecParam.E);
    paramIntent.putExtra("sv_encode_qmax", CodecParam.F);
    paramIntent.putExtra("sv_encode_qmin", CodecParam.G);
    paramIntent.putExtra("sv_encode_qmaxdiff", CodecParam.H);
    paramIntent.putExtra("sv_encode_ref_frame", CodecParam.I);
    paramIntent.putExtra("sv_encode_smooth", CodecParam.J);
    paramIntent.putExtra("sv_total_frame_count", this.m);
    paramIntent.putExtra("sv_total_record_time", this.l);
    paramIntent.putExtra("sv_encode_totaltime_adjust", CodecParam.M);
    paramIntent.putExtra("sv_encode_timestamp_fix", CodecParam.N);
    paramIntent.putExtra("sv_encode_bless_audio_time_low", CodecParam.O);
    paramIntent.putExtra("sv_encode_bless_audio_time_high", CodecParam.P);
    paramIntent.putExtra("sv_encode_bless_audio_time_ratio", CodecParam.Q);
    paramIntent.putExtra("sv_encode_baseline_mp4", false);
    paramIntent.putExtra("video_mood_content", this.jdField_c_of_type_JavaLangString);
    paramIntent.putExtra("video_mood_priv", this.n);
    paramIntent.putExtra("video_mood_privUinList", this.jdField_a_of_type_JavaUtilArrayList);
    paramIntent.putExtra("enable_edit_video", this.jdField_a_of_type_Boolean);
    PerformenceDataTag.a("sv_filter_mp4_fps", this.m * 1000 / this.l);
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    a();
    if (paramInteger.intValue() == 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface == null) {}
      for (paramInteger = "";; paramInteger = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface.a())
      {
        if ((VideoEnvironment.e()) && (!"From_HealthBusiness".equals(paramInteger)) && (!this.jdField_b_of_type_Boolean) && (((this.jdField_a_of_type_AndroidAppActivity instanceof FlowCameraActivity2)) || ((this.jdField_a_of_type_AndroidAppActivity instanceof NewFlowCameraActivity))))
        {
          this.jdField_a_of_type_AndroidAppActivity.setResult(1001);
          this.jdField_a_of_type_AndroidAppActivity.finish();
        }
        paramInteger = new Intent();
        a(paramInteger);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface.a(this.jdField_a_of_type_AndroidAppActivity, paramInteger);
        return;
      }
      paramInteger.putExtra("uin", this.jdField_d_of_type_JavaLangString);
      paramInteger.putExtra("uintype", this.o);
      paramInteger.putExtra("troop_uin", this.e);
      if (!this.jdField_b_of_type_Boolean) {
        break label494;
      }
    }
    label494:
    for (int i1 = 3;; i1 = 2)
    {
      paramInteger.putExtra("file_send_business_type", i1);
      paramInteger.putExtra("ab_test_send_btn_click_time", this.jdField_a_of_type_AndroidAppActivity.getIntent().getLongExtra("ab_test_send_btn_click_time", 0L));
      paramInteger.putExtra("ab_test_generate_thumb_cost_time", SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long);
      paramInteger.setClass(this.jdField_a_of_type_AndroidAppActivity, SendVideoActivity.class);
      if (QLog.isColorLevel()) {
        QLog.d(this.i, 2, "onPostExecute(), SendVideoTask is to start  SendVideoActivity,mVideoFileDir = " + this.jdField_b_of_type_JavaLangString);
      }
      if ((this.jdField_d_of_type_JavaLangString != null) && (this.jdField_d_of_type_JavaLangString.equals(MessageForBlessPTV.BLESS_REQ_UIN)) && (this.jdField_b_of_type_JavaUtilArrayList != null))
      {
        paramInteger.putExtra("bless_uin_list", this.jdField_b_of_type_JavaUtilArrayList);
        paramInteger.putExtra("bless_ptv_mp4_path", this.h);
        this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramInteger, 1001);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidAppActivity = null;
        if (!this.jdField_d_of_type_Boolean) {
          break;
        }
        FileUtils.a(this.jdField_b_of_type_JavaLangString);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(this.i, 2, "onPostExecute() delete cache...");
        return;
        this.jdField_a_of_type_AndroidAppActivity.startActivity(paramInteger);
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "系统处理超时,短视频发送失败", 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131492908));
      if (QLog.isColorLevel()) {
        QLog.d(this.i, 2, "onPostExecute(), SendVideoTask error = " + paramInteger);
      }
      if (!VideoEnvironment.e()) {
        break;
      }
      if ((!this.jdField_b_of_type_Boolean) && ((this.jdField_a_of_type_AndroidAppActivity instanceof FlowCameraActivity2)))
      {
        ThreadManager.b().postDelayed(new pac(this), 1000L);
        return;
      }
      this.jdField_a_of_type_AndroidAppActivity = null;
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\FlowSendTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */