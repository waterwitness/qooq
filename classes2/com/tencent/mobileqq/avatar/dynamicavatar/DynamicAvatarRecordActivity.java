package com.tencent.mobileqq.avatar.dynamicavatar;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ConfigurationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.richmedia.FlowActivity;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoClipSpec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoThumbGenMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoThumbGenMgr.ThumbGenItem;
import com.tencent.mobileqq.activity.richmedia.state.RMViewSTInterface;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover;
import com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView;
import com.tencent.mobileqq.activity.richmedia.view.CameraTextureView;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraAbility;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.Callback;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraPreview;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.SurfacePreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.TexturePreviewContext;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.video.decode.ShortVideoSoLoad;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.util.PerfTracer;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import qsn;
import qso;
import qsq;
import qss;
import qst;
import qsv;
import qsw;
import qsx;
import qsz;

public class DynamicAvatarRecordActivity
  extends FlowActivity
  implements View.OnClickListener, RMViewSTInterface
{
  public static final String a = "param_source";
  public static final int b = 1;
  public static final int c = 2;
  private static final String c;
  private static final int j = 1;
  private static final int k = 8;
  private static final int l = 15000;
  private static final int m = 30;
  ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new qsn(this);
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new qst(this);
  public Button a;
  public ImageView a;
  public TextView a;
  public RMVideoStateMgr a;
  public CameraCover a;
  public CameraGLSurfaceView a;
  CameraExceptionHandler.Callback jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler$Callback = new qsw(this);
  CameraProxy jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy;
  ImageViewVideoPlayer jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer;
  public QQCustomDialog a;
  public CircleProgress a;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  volatile AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public Button b;
  public ImageView b;
  public TextView b;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  public TextView c;
  public int d;
  public TextView d;
  public boolean d;
  int jdField_e_of_type_Int = 0;
  public TextView e;
  boolean jdField_e_of_type_Boolean = true;
  int f = 0;
  int g = -1;
  int h = -1;
  int i;
  private int n;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_c_of_type_JavaLangString = DynamicAvatarRecordActivity.class.getSimpleName();
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_c_of_type_JavaLangString, 2, "LoadExtractedShortVideoSo :soLoadStatus=" + ShortVideoSoLoad.VIDEO_SO_LOAD_STATUS);
      }
      int i1 = VideoEnvironment.a("AVCodec", null, true);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_c_of_type_JavaLangString, 2, "LoadExtractedShortVideoSo :code=" + i1);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public DynamicAvatarRecordActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr = RMVideoStateMgr.a();
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    Object localObject = DynamicAvatarRecordActivity.class;
    if (CameraCompatibleList.d(CameraCompatibleList.jdField_c_of_type_JavaLangString)) {
      localObject = MX3DynamicAvatarRecordActivity.class;
    }
    localObject = new Intent(paramActivity, (Class)localObject);
    ((Intent)localObject).putExtra("param_source", paramInt1);
    paramActivity.startActivityForResult((Intent)localObject, paramInt2);
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean)
  {
    if (paramBundle == null) {
      return;
    }
    com.tencent.mobileqq.shortvideo.hwcodec.HwEnvData.jdField_b_of_type_Boolean = paramBundle.getBoolean("key_video_hard_encode_enable", false);
    float f1 = paramBundle.getFloat("key_video_presend_slice_duration", 1.5F);
    if (f1 > 0.0F) {
      com.tencent.mobileqq.shortvideo.hwcodec.HwEnvData.jdField_a_of_type_Int = (int)(f1 * 1000.0F);
    }
    if (RMVideoStateMgr.a(paramBoolean))
    {
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(16);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(4);
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_c_of_type_JavaLangString, 2, "showProgressDialog");
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog == null)
      {
        this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this, 2131558973);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130903453);
      }
      ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131298665)).setText(paramString);
      if (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
      }
      return;
    }
    catch (Throwable paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i(jdField_c_of_type_JavaLangString, 2, "showProgressDialog", paramString);
    }
  }
  
  private boolean b()
  {
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.i();
    a(104);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeViewAt(0);
    if (FlowCameraConstant.jdField_d_of_type_Int == 1)
    {
      FlowCameraConstant.jdField_d_of_type_Int = 2;
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription("相机选取器，在前置相机和后置相机之间切换，按钮，当前为后置相机");
    }
    for (;;)
    {
      b(false);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.h();
      return true;
      FlowCameraConstant.jdField_d_of_type_Int = 1;
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription("相机选取器，在前置相机和后置相机之间切换，按钮，当前为前置相机");
    }
  }
  
  private void q()
  {
    if (this.n == 1) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
    try
    {
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      this.n = 1;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void r()
  {
    runOnUiThread(new qsv(this));
  }
  
  private void s()
  {
    runOnUiThread(new qsx(this));
  }
  
  /* Error */
  private void t()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 118	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   4: getfield 329	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext	Lcom/tencent/mobileqq/shortvideo/mediadevice/PreviewContext;
    //   7: ifnonnull +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: getfield 142	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   15: iconst_1
    //   16: invokevirtual 332	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   19: pop
    //   20: invokestatic 338	java/lang/System:currentTimeMillis	()J
    //   23: lstore 11
    //   25: invokestatic 116	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	()Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   28: astore_1
    //   29: invokestatic 340	com/tencent/mobileqq/shortvideo/VideoEnvironment:e	()Z
    //   32: ifeq +459 -> 491
    //   35: ldc_w 342
    //   38: iconst_0
    //   39: invokestatic 347	com/tencent/mobileqq/shortvideo/tools/QzoneHandlerThreadFactory:a	(Ljava/lang/String;Z)Lcom/tencent/mobileqq/shortvideo/tools/QzoneBaseThread;
    //   42: new 349	qsy
    //   45: dup
    //   46: aload_0
    //   47: aload_1
    //   48: invokespecial 352	qsy:<init>	(Lcom/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity;Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;)V
    //   51: invokevirtual 356	com/tencent/mobileqq/shortvideo/tools/QzoneBaseThread:a	(Ljava/lang/Runnable;)V
    //   54: invokestatic 340	com/tencent/mobileqq/shortvideo/VideoEnvironment:e	()Z
    //   57: ifeq +219 -> 276
    //   60: lconst_0
    //   61: lstore 9
    //   63: aload_1
    //   64: getfield 357	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   67: astore_2
    //   68: aload_2
    //   69: monitorenter
    //   70: aload_1
    //   71: getfield 357	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   74: invokevirtual 360	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   77: istore 13
    //   79: lload 9
    //   81: lstore 7
    //   83: iload 13
    //   85: ifne +112 -> 197
    //   88: lload 9
    //   90: lstore 5
    //   92: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   95: ifeq +17 -> 112
    //   98: lload 9
    //   100: lstore 5
    //   102: getstatic 66	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   105: iconst_2
    //   106: ldc_w 362
    //   109: invokestatic 97	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   112: lload 9
    //   114: lstore 5
    //   116: invokestatic 367	android/os/SystemClock:elapsedRealtime	()J
    //   119: lstore 7
    //   121: lload 9
    //   123: lstore 5
    //   125: aload_1
    //   126: getfield 357	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   129: ldc2_w 368
    //   132: invokevirtual 375	java/lang/Object:wait	(J)V
    //   135: lload 9
    //   137: lstore 5
    //   139: invokestatic 367	android/os/SystemClock:elapsedRealtime	()J
    //   142: lload 7
    //   144: lsub
    //   145: lstore 9
    //   147: lload 9
    //   149: lstore 7
    //   151: lload 9
    //   153: lstore 5
    //   155: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +39 -> 197
    //   161: lload 9
    //   163: lstore 5
    //   165: getstatic 66	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   168: iconst_2
    //   169: new 74	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 377
    //   179: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: lload 9
    //   184: invokevirtual 380	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   187: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 97	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: lload 9
    //   195: lstore 7
    //   197: aload_2
    //   198: monitorexit
    //   199: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +13 -> 215
    //   205: getstatic 66	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   208: iconst_2
    //   209: ldc_w 382
    //   212: invokestatic 97	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: lload 7
    //   217: ldc2_w 383
    //   220: lcmp
    //   221: ifge +55 -> 276
    //   224: bipush 30
    //   226: lload 7
    //   228: l2i
    //   229: isub
    //   230: istore 4
    //   232: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   235: ifeq +31 -> 266
    //   238: getstatic 66	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   241: iconst_2
    //   242: new 74	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   249: ldc_w 386
    //   252: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: iload 4
    //   257: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   260: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   266: iload 4
    //   268: i2l
    //   269: lstore 5
    //   271: lload 5
    //   273: invokestatic 393	java/lang/Thread:sleep	(J)V
    //   276: aload_1
    //   277: getfield 329	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext	Lcom/tencent/mobileqq/shortvideo/mediadevice/PreviewContext;
    //   280: ifnull -270 -> 10
    //   283: aload_1
    //   284: getfield 396	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_Double	D
    //   287: d2i
    //   288: putstatic 401	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:K	I
    //   291: aload_1
    //   292: getfield 329	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext	Lcom/tencent/mobileqq/shortvideo/mediadevice/PreviewContext;
    //   295: invokevirtual 407	com/tencent/mobileqq/shortvideo/mediadevice/PreviewContext:getFrameIndex	()I
    //   298: putstatic 410	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:L	I
    //   301: new 412	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread
    //   304: dup
    //   305: aconst_null
    //   306: aconst_null
    //   307: aload_1
    //   308: getfield 414	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   311: aconst_null
    //   312: aconst_null
    //   313: invokespecial 417	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:<init>	(Landroid/content/Context;Landroid/os/Handler;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   316: astore_1
    //   317: aload_1
    //   318: iconst_1
    //   319: invokevirtual 419	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:a	(Z)V
    //   322: aload_1
    //   323: iconst_0
    //   324: invokevirtual 420	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:b	(Z)V
    //   327: aload_1
    //   328: iconst_1
    //   329: invokevirtual 422	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:d	(Z)V
    //   332: aload_1
    //   333: invokevirtual 425	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:run	()V
    //   336: aload_0
    //   337: aload_1
    //   338: getfield 426	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   341: putfield 428	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   344: aload_0
    //   345: getfield 428	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   348: invokestatic 434	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   351: ifne +54 -> 405
    //   354: new 436	java/io/File
    //   357: dup
    //   358: aload_0
    //   359: getfield 428	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   362: invokespecial 438	java/io/File:<init>	(Ljava/lang/String;)V
    //   365: astore_1
    //   366: aload_1
    //   367: invokevirtual 441	java/io/File:exists	()Z
    //   370: ifeq +35 -> 405
    //   373: new 74	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   380: aload_1
    //   381: invokevirtual 444	java/io/File:getParent	()Ljava/lang/String;
    //   384: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: getstatic 447	java/io/File:separator	Ljava/lang/String;
    //   390: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: ldc_w 449
    //   396: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: invokestatic 453	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)V
    //   405: aload_0
    //   406: getfield 142	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   409: iconst_0
    //   410: invokevirtual 332	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   413: pop
    //   414: aload_0
    //   415: getfield 219	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   418: ifnull +21 -> 439
    //   421: aload_0
    //   422: getfield 219	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   425: invokevirtual 250	android/app/ProgressDialog:isShowing	()Z
    //   428: ifeq +11 -> 439
    //   431: aload_0
    //   432: invokevirtual 455	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:n	()V
    //   435: aload_0
    //   436: invokespecial 458	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:u	()V
    //   439: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   442: ifeq -432 -> 10
    //   445: getstatic 66	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   448: iconst_2
    //   449: new 74	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   456: ldc_w 460
    //   459: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: aload_0
    //   463: getfield 428	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   466: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: ldc_w 462
    //   472: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: invokestatic 338	java/lang/System:currentTimeMillis	()J
    //   478: lload 11
    //   480: lsub
    //   481: invokevirtual 380	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   484: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   487: invokestatic 97	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   490: return
    //   491: invokestatic 467	com/tencent/mobileqq/shortvideo/mediadevice/RecordManager:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/RecordManager;
    //   494: invokevirtual 470	com/tencent/mobileqq/shortvideo/mediadevice/RecordManager:a	()Lcom/tencent/maxvideo/mediadevice/AVCodec;
    //   497: invokevirtual 475	com/tencent/maxvideo/mediadevice/AVCodec:recordSubmit	()I
    //   500: pop
    //   501: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   504: ifeq -450 -> 54
    //   507: getstatic 66	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   510: iconst_2
    //   511: ldc_w 477
    //   514: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   517: goto -463 -> 54
    //   520: astore_2
    //   521: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   524: ifeq +13 -> 537
    //   527: getstatic 66	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   530: iconst_2
    //   531: ldc_w 479
    //   534: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   537: aload_2
    //   538: invokevirtual 480	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   541: goto -487 -> 54
    //   544: astore_3
    //   545: lload 5
    //   547: lstore 7
    //   549: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   552: ifeq -355 -> 197
    //   555: getstatic 66	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarRecordActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   558: iconst_2
    //   559: new 74	java/lang/StringBuilder
    //   562: dup
    //   563: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   566: ldc_w 482
    //   569: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: aload_3
    //   573: invokevirtual 485	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   576: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   582: invokestatic 97	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   585: lload 5
    //   587: lstore 7
    //   589: goto -392 -> 197
    //   592: astore_1
    //   593: aload_2
    //   594: monitorexit
    //   595: aload_1
    //   596: athrow
    //   597: astore_2
    //   598: goto -322 -> 276
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	601	0	this	DynamicAvatarRecordActivity
    //   28	353	1	localObject1	Object
    //   592	4	1	localObject2	Object
    //   67	131	2	localAtomicBoolean	AtomicBoolean
    //   520	74	2	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   597	1	2	localInterruptedException1	InterruptedException
    //   544	29	3	localInterruptedException2	InterruptedException
    //   230	37	4	i1	int
    //   90	496	5	l1	long
    //   81	507	7	l2	long
    //   61	133	9	l3	long
    //   23	456	11	l4	long
    //   77	7	13	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   491	517	520	java/lang/UnsatisfiedLinkError
    //   92	98	544	java/lang/InterruptedException
    //   102	112	544	java/lang/InterruptedException
    //   116	121	544	java/lang/InterruptedException
    //   125	135	544	java/lang/InterruptedException
    //   139	147	544	java/lang/InterruptedException
    //   155	161	544	java/lang/InterruptedException
    //   165	193	544	java/lang/InterruptedException
    //   70	79	592	finally
    //   92	98	592	finally
    //   102	112	592	finally
    //   116	121	592	finally
    //   125	135	592	finally
    //   139	147	592	finally
    //   155	161	592	finally
    //   165	193	592	finally
    //   197	199	592	finally
    //   549	585	592	finally
    //   593	595	592	finally
    //   271	276	597	java/lang/InterruptedException
  }
  
  private void u()
  {
    Intent localIntent = new Intent(this, SelectCoverActivity.class);
    localIntent.putExtra("param_source", this.jdField_d_of_type_Int);
    localIntent.putExtra("key_video_file_path", this.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("key_video_duration", this.i);
    if (((Boolean)this.jdField_a_of_type_AndroidWidgetButton.getTag()).booleanValue())
    {
      str = "1";
      localIntent.putExtra("key_video_has_voice", str);
      if (FlowCameraConstant.jdField_d_of_type_Int != 1) {
        break label110;
      }
    }
    label110:
    for (String str = "0";; str = "1")
    {
      localIntent.putExtra("key_camera_id", str);
      startActivityForResult(localIntent, 1);
      return;
      str = "0";
      break;
    }
  }
  
  public void E_()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_c_of_type_JavaLangString, 4, "initUI_InitState()");
    }
  }
  
  public void F_()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_c_of_type_JavaLangString, 4, "initUI_RecordState()");
    }
  }
  
  public void G_()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_c_of_type_JavaLangString, 4, "initUI_IdleState()");
    }
  }
  
  int a(int paramInt1, int paramInt2, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int i3 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.getMeasuredHeight();
    int i4 = (int)(paramInt2 * FlowCameraConstant.a);
    int i2;
    int i1;
    if (i3 <= this.jdField_e_of_type_Int)
    {
      i2 = (i3 - (int)(i3 * 0.83F)) / 2;
      paramInt1 = this.jdField_e_of_type_Int;
      i1 = this.jdField_e_of_type_Int;
      paramArrayOfInt[0] = paramInt2;
      paramArrayOfInt[1] = i4;
    }
    for (;;)
    {
      if (paramBoolean) {
        i1 = paramInt1;
      }
      i3 = paramInt1;
      if (paramInt1 % 2 != 0) {
        i3 = paramInt1 - 1;
      }
      paramInt1 = i1;
      if (i1 % 2 != 0) {
        paramInt1 = i1 - 1;
      }
      paramArrayOfInt[2] = i3;
      paramArrayOfInt[3] = paramInt1;
      paramArrayOfInt[4] = paramInt2;
      paramArrayOfInt[5] = i4;
      return i2;
      i2 = this.jdField_e_of_type_Int;
      i1 = this.jdField_e_of_type_Int * paramInt1 / paramInt2;
      paramArrayOfInt[0] = paramInt2;
      paramArrayOfInt[1] = (i3 * paramInt2 / this.jdField_e_of_type_Int);
      i3 = (i3 - i2) / 2;
      paramInt1 = i2;
      i2 = i3;
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_c_of_type_JavaLangString, 4, "realDeleteVideoSegment(), delReason = " + paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_c_of_type_JavaLangString, 4, "previewSizeAdjustUI(), width = " + paramInt1 + ", height = " + paramInt2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_c_of_type_JavaLangString, 2, "[previewSizeAdjustUI]rmStateMgr == null");
      }
      return;
    }
    this.g = paramInt1;
    this.h = paramInt2;
    int[] arrayOfInt = new int[6];
    RMVideoClipSpec localRMVideoClipSpec = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView;
      label104:
      if (localObject != this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView) {
        break label240;
      }
    }
    label240:
    for (boolean bool = true;; bool = false)
    {
      a(paramInt1, paramInt2, arrayOfInt, bool);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)a((View)localObject);
      localLayoutParams.width = arrayOfInt[2];
      localLayoutParams.height = arrayOfInt[3];
      ((View)localObject).setLayoutParams(localLayoutParams);
      localRMVideoClipSpec.c = arrayOfInt[0];
      localRMVideoClipSpec.jdField_d_of_type_Int = arrayOfInt[1];
      localRMVideoClipSpec.jdField_e_of_type_Int = 480;
      localRMVideoClipSpec.f = 480;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(localRMVideoClipSpec, false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setPreviewSize(this.g, this.h, localRMVideoClipSpec);
      return;
      localObject = a(2131296494);
      break label104;
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_c_of_type_JavaLangString, 4, "errorOcured(), errCode = " + paramInt + ", errMsg = " + paramString + ", isReport = " + paramBoolean);
    }
    runOnUiThread(new qso(this, paramString, paramInt));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.i = paramInt;
    RMVideoStateMgr localRMVideoStateMgr = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
    localRMVideoStateMgr.jdField_a_of_type_Int += 1;
    if (paramBoolean)
    {
      r();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.post(new qsz(this, paramInt));
  }
  
  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_d_of_type_Int = paramBundle.getInt("param_source", 0);
    if (this.jdField_d_of_type_Int == 0) {
      throw new IllegalArgumentException("source must not be null");
    }
    FlowCameraConstant.jdField_d_of_type_Int = 1;
    if (!CameraAbility.c()) {
      FlowCameraConstant.jdField_d_of_type_Int = 2;
    }
    FlowCameraConstant.a = 1.0F;
    a(paramBundle, false);
    paramBundle = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.NewShortVideoConfig.name(), null);
    int i1 = NetworkUtil.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a((AppInterface)getAppRuntime(), 4, paramBundle, false, 0, i1, 8);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(this, FlowCameraMqqAction.a(this), this))
    {
      super.finish();
      return;
    }
    paramBundle = getResources().getDisplayMetrics();
    this.jdField_e_of_type_Int = paramBundle.widthPixels;
    this.f = paramBundle.heightPixels;
    if (this.jdField_e_of_type_Int <= 0)
    {
      paramBundle = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
      this.jdField_e_of_type_Int = paramBundle.widthPixels;
      this.f = paramBundle.heightPixels;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy = new CameraProxy(this, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(new CameraExceptionHandler(this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler$Callback));
  }
  
  public void a(Message paramMessage)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_c_of_type_JavaLangString, 4, "onHandleMessage(), msg.what = " + paramMessage.what);
    }
  }
  
  protected void a(ViewGroup paramViewGroup)
  {
    getLayoutInflater().inflate(2130904144, paramViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover = ((CameraCover)a(2131301547));
    paramViewGroup = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.getLayoutParams();
    paramViewGroup.height = this.jdField_e_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setLayoutParams(paramViewGroup);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131301545));
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetButton.setTag(Boolean.valueOf(true));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)a(2131301546));
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131301557));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131301556));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer = ((ImageViewVideoPlayer)a(2131301548));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131301550));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131301551));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)a(2131301555));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131301552));
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131301553));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)a(2131301554));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, getResources().getColor(2131427407), 100, getResources().getColor(2131427713));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(6.0F);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)a(2131301555));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    ImageView localImageView = new ImageView(this);
    if (this.jdField_e_of_type_Int > 0) {
      localImageView.setImageBitmap(DynamicUtils.a(this.jdField_e_of_type_Int, this.jdField_e_of_type_Int, this.jdField_e_of_type_Int / 2 - 8));
    }
    for (paramViewGroup = new FrameLayout.LayoutParams(-1, -1);; paramViewGroup = new FrameLayout.LayoutParams(1, 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.addView(localImageView, -1, paramViewGroup);
      return;
      localImageView.setImageBitmap(DynamicUtils.a(5, 5, 2));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_c_of_type_JavaLangString, 4, "deleteLastVideoSegment(), deleteNative = " + paramBoolean);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131296494) == null)
    {
      localObject1 = localObject2;
      if (paramBoolean) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext;
      }
    }
    if (VersionUtils.d())
    {
      localObject2 = new CameraTextureView(this);
      if ((localObject1 != null) && ((localObject1 instanceof TexturePreviewContext)))
      {
        ((CameraTextureView)localObject2).a = ((TexturePreviewContext)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(((CameraTextureView)localObject2).a);
        localObject1 = new FrameLayout.LayoutParams(-1, -1);
        this.jdField_e_of_type_Boolean = false;
        ConfigurationInfo localConfigurationInfo = ((ActivityManager)super.getSystemService("activity")).getDeviceConfigurationInfo();
        paramBoolean = VideoEnvironment.a();
        if ((localConfigurationInfo == null) || (localConfigurationInfo.reqGlEsVersion < 131072) || (!paramBoolean)) {
          break label309;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView = ((CameraGLSurfaceView)a(2131296496));
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setVideoContext(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext);
        ((FrameLayout.LayoutParams)localObject1).height = 1;
        ((FrameLayout.LayoutParams)localObject1).width = 1;
      }
    }
    for (;;)
    {
      ((View)localObject2).setId(2131296494);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.addView((View)localObject2, 0, (ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setCameraView((View)localObject2);
      this.jdField_d_of_type_Boolean = true;
      return;
      ((CameraTextureView)localObject2).a = new TexturePreviewContext(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy, this.jdField_e_of_type_Int, this.f);
      break;
      localObject2 = new CameraPreview(this);
      if ((localObject1 != null) && ((localObject1 instanceof SurfacePreviewContext))) {}
      for (((CameraPreview)localObject2).a = ((SurfacePreviewContext)localObject1);; ((CameraPreview)localObject2).a = new SurfacePreviewContext(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy, this.jdField_e_of_type_Int, this.f))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(((CameraPreview)localObject2).a);
        localObject1 = new FrameLayout.LayoutParams(-1, -1);
        this.jdField_e_of_type_Boolean = true;
        break;
      }
      label309:
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView = ((CameraGLSurfaceView)a(2131296496));
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView = null;
    }
  }
  
  public int c_()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_c_of_type_JavaLangString, 4, "getCurrentBlockTimeLength()");
    }
    return 0;
  }
  
  public void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_c_of_type_JavaLangString, 4, "initUI_previewState()");
    }
    int i1 = this.i;
    int i2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(CodecParam.jdField_d_of_type_Int, i1, i2, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setCyclePlay(true);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr.a();
    BitmapFactory.Options localOptions;
    Object localObject1;
    if ((localObject2 != null) && (((RMVideoThumbGenMgr.ThumbGenItem)localObject2).jdField_c_of_type_JavaLangString != null) && (((RMVideoThumbGenMgr.ThumbGenItem)localObject2).a.get() == 3) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null))
    {
      localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = 2;
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      localObject1 = null;
    }
    try
    {
      localObject2 = BitmapFactory.decodeFile(((RMVideoThumbGenMgr.ThumbGenItem)localObject2).jdField_c_of_type_JavaLangString, localOptions);
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;) {}
    }
    if (localObject1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(super.getResources(), (Bitmap)localObject1);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a();
  }
  
  public void e()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_c_of_type_JavaLangString, 4, "initRecordEngineOK()");
    }
  }
  
  public void f()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_c_of_type_JavaLangString, 4, "addOneSegment_RecordState()");
    }
  }
  
  public void g()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_c_of_type_JavaLangString, 4, "recordVideoFinish()");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.i();
  }
  
  public void h()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_c_of_type_JavaLangString, 4, "onViewDestroy()");
    }
  }
  
  public void i()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_c_of_type_JavaLangString, 4, "enterViewVideoMode()");
    }
  }
  
  public void j()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_c_of_type_JavaLangString, 4, "exitViewVideoMode()");
    }
  }
  
  public void k()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_c_of_type_JavaLangString, 4, "getFirstFrame()");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.getVisibility() != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setVisibility(0);
    }
  }
  
  public void l()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_c_of_type_JavaLangString, 4, "finishUI()");
    }
  }
  
  public void m()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_c_of_type_JavaLangString, 4, "notifyAvcodecOK()");
    }
  }
  
  protected void n()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_c_of_type_JavaLangString, 2, "dismissProgressDialog");
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void o()
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr);
    if (QLog.isColorLevel()) {
      QLog.i(jdField_c_of_type_JavaLangString, 2, "playVideo getVFileAndAFile=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString + "errcode=" + i1 + "hasFrame=" + bool);
    }
    if ((i1 != 0) || (!bool))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(0, "视频录制出错，请重新录制", false);
      p();
    }
    do
    {
      do
      {
        return;
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i(jdField_c_of_type_JavaLangString, 2, "playVideo isCurrentPreviewState= true......");
      return;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Boolean = true;
      View localView = a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131296494);
      if (localView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView(localView);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(4);
    } while (!QLog.isColorLevel());
    QLog.i(jdField_c_of_type_JavaLangString, 2, "replay totaltime = " + (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      if (this.jdField_d_of_type_Int != 1) {
        break label71;
      }
      setResult(-1);
      finish();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "onActivityResult，requestCode:" + paramInt1 + ",resultCode:" + paramInt2);
      }
      return;
      label71:
      if ((this.jdField_d_of_type_Int == 2) && (paramIntent != null) && (!TextUtils.isEmpty(paramIntent.getStringExtra("key_photo_file_path"))))
      {
        setResult(-1, paramIntent);
        finish();
      }
    }
  }
  
  public void onBackPressed()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double == 0.0D)
    {
      finish();
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.b(this, false);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a("放弃录制，当前视频将会被删除");
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a("放弃", 3);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.d("取消");
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new qss(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  public void onClick(View paramView)
  {
    int i2 = 1;
    int i3 = 1;
    int i4 = 1;
    int i5 = 1;
    int i1 = 1;
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
      if (((Boolean)this.jdField_a_of_type_AndroidWidgetButton.getTag()).booleanValue())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d(false);
        this.jdField_a_of_type_AndroidWidgetButton.setTag(Boolean.valueOf(false));
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130840660);
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription("静音选项，开启或关闭视频声音，按钮，当前已关闭声音");
        if (this.jdField_d_of_type_Int == 1) {
          i1 = 0;
        }
        ReportController.b(null, "dc00898", "", "", "0X8007104", "0X8007104", i1, 0, "", "", "", "");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d(true);
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Boolean.valueOf(true));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130840663);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription("静音选项，开启或关闭视频声音，按钮，当前已开启声音");
      break;
      if (paramView == this.jdField_b_of_type_AndroidWidgetButton)
      {
        b();
        i1 = i2;
        if (this.jdField_d_of_type_Int == 1) {
          i1 = 0;
        }
        ReportController.b(null, "dc00898", "", "", "0X8007105", "0X8007105", i1, 0, "", "", "", "");
        return;
      }
      if (paramView == this.jdField_e_of_type_AndroidWidgetTextView)
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          a("视频处理中...");
        }
        for (;;)
        {
          i1 = i3;
          if (this.jdField_d_of_type_Int == 1) {
            i1 = 0;
          }
          ReportController.b(null, "dc00898", "", "", "0X8007109", "0X8007109", i1, 0, "", "", "", "");
          return;
          if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (new File(this.jdField_b_of_type_JavaLangString).exists())) {
            u();
          }
        }
      }
      if (paramView == this.jdField_c_of_type_AndroidWidgetTextView)
      {
        i1 = i4;
        if (this.jdField_d_of_type_Int == 1) {
          i1 = 0;
        }
        ReportController.b(null, "dc00898", "", "", "0X8007107", "0X8007107", i1, 0, "", "", "", "");
        finish();
        return;
      }
    } while (paramView != this.jdField_d_of_type_AndroidWidgetTextView);
    EncodeThread.a();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.b();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.d();
    b(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d();
    s();
    this.jdField_b_of_type_JavaLangString = null;
    i1 = i5;
    if (this.jdField_d_of_type_Int == 1) {
      i1 = 0;
    }
    ReportController.b(null, "dc00898", "", "", "0X8007108", "0X8007108", i1, 0, "", "", "", "");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("DeviceInfo:");
      localStringBuilder.append("PRODUCT=").append(Build.PRODUCT).append("|");
      localStringBuilder.append("MODEL=").append(Build.MODEL).append("|");
      localStringBuilder.append("BOARD=").append(Build.BOARD).append("|");
      localStringBuilder.append("BOOTLOADER=").append(Build.BOOTLOADER).append("|");
      localStringBuilder.append("CPU_ABI=").append(Build.CPU_ABI).append("|");
      localStringBuilder.append("CPU_ABI2=").append(Build.CPU_ABI2).append("|");
      localStringBuilder.append("DEVICE=").append(Build.DEVICE).append("|");
      localStringBuilder.append("DISPLAY=").append(Build.DISPLAY).append("|");
      localStringBuilder.append("FLNGERPRINT=").append(Build.FINGERPRINT).append("|");
      localStringBuilder.append("HARDWARE=").append(Build.HARDWARE).append("|");
      localStringBuilder.append("ID=").append(Build.ID).append("|");
      localStringBuilder.append("MANUFACTURER=").append(Build.MANUFACTURER).append("|");
      localStringBuilder.append("SDK_INT=").append(Build.VERSION.SDK_INT).append("|");
      QLog.i(jdField_c_of_type_JavaLangString, 2, localStringBuilder.toString());
    }
    this.L = true;
    this.M = false;
    PerfTracer.a("Video_component_onCreate");
    super.onCreate(paramBundle);
    PerfTracer.b("Video_component_onCreate");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.c();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.onPause();
    }
    View localView = a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131296494);
    if (localView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView(localView);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
    }
    if ((a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131296494) == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.get() != 4)) {
      Looper.myQueue().addIdleHandler(new qsq(this));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.onResume();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    q();
  }
  
  protected void onStop()
  {
    super.onStop();
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.b();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d();
      if (this.n == 1)
      {
        unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.n = 0;
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i(jdField_c_of_type_JavaLangString, 2, " already unregisterReceiver" + localIllegalArgumentException);
    }
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d();
      this.jdField_a_of_type_AndroidWidgetTextView.setText("0\"");
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\avatar\dynamicavatar\DynamicAvatarRecordActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */