package com.tencent.mobileqq.shortvideo.util;

import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoClipSpec;
import com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView;
import com.tencent.mobileqq.activity.richmedia.view.GLSurfaceUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext.VFrameData;
import com.tencent.mobileqq.shortvideo.ptvfilter.test.PerformenceDataTag;
import com.tencent.mobileqq.shortvideo.ptvfilter.test.SVFilterPreprocessFpsTest;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import usj;
import usk;

public class OffScreenGLSurface
  implements Handler.Callback
{
  public static final int a = 0;
  private static final String jdField_a_of_type_JavaLangString = "OffScreenGLSurface";
  public static final boolean a = true;
  public static final int b = 1;
  private static boolean jdField_b_of_type_Boolean = CameraCompatibleList.c(CameraCompatibleList.z);
  public static final int c = -16716526;
  public static final int d = -16716525;
  public static final int e = -16716524;
  public static final int f = -16716523;
  public static final int g = -16716522;
  private static final int jdField_h_of_type_Int = 2;
  private static final int q = 0;
  private static final int r = 1;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  GLSurfaceUtil jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil;
  private PreviewContext jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext;
  public OffScreenGLSurface.GLSharedData a;
  OffScreenInputSurface jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface;
  PtvFilterOpenglFrameBuffer jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterOpenglFrameBuffer;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private usk jdField_a_of_type_Usk = new usk(null);
  private Handler jdField_b_of_type_AndroidOsHandler;
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean c;
  private boolean d;
  private boolean e;
  private volatile boolean f;
  private boolean g;
  private boolean jdField_h_of_type_Boolean;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p = 270;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public OffScreenGLSurface()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface$GLSharedData = new OffScreenGLSurface.GLSharedData();
    f();
    this.jdField_a_of_type_AndroidOsHandlerThread = null;
    this.jdField_b_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil = new GLSurfaceUtil();
  }
  
  private TextureDataPipe a()
  {
    TextureDataPipe localTextureDataPipe = this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface$GLSharedData.a.b();
    if (localTextureDataPipe != null) {
      return localTextureDataPipe;
    }
    localTextureDataPipe = this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface$GLSharedData.a.a();
    if (localTextureDataPipe != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterOpenglFrameBuffer.a(localTextureDataPipe.a, this.i, this.j);
      return localTextureDataPipe;
    }
    return null;
  }
  
  private void a(AVIOStruct paramAVIOStruct)
  {
    if (this.jdField_a_of_type_Usk.a)
    {
      usk localusk = this.jdField_a_of_type_Usk;
      localusk.d += 1;
      if (this.jdField_a_of_type_Usk.d >= 3) {
        b(paramAVIOStruct);
      }
    }
  }
  
  private void b(AVIOStruct paramAVIOStruct)
  {
    this.jdField_a_of_type_Usk.c = paramAVIOStruct.pFrameIndex;
    paramAVIOStruct.pFrameIndex = 0;
    this.jdField_a_of_type_Usk.a = false;
    this.jdField_a_of_type_Usk.d = 0;
    GLSurfaceUtil.a("handleMessage:writeVideoFrame[false]  mThumbPicControl.mSendThumbOKIndex=" + this.jdField_a_of_type_Usk.c);
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.jdField_b_of_type_Int = 0;
    this.d = false;
  }
  
  private boolean b()
  {
    boolean bool2 = true;
    bool1 = false;
    synchronized (OffScreenGLSurface.GLSharedData.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface$GLSharedData))
    {
      Object localObject2 = OffScreenGLSurface.GLSharedData.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface$GLSharedData);
      if (localObject2 == null) {
        return false;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface != null) && ((this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface.c()) || (!this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface.a((EGLContext)localObject2))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("OffScreenGLSurface", 2, "initInputSurface[releasePBufferAndFrameBuffer]1 glContextH=" + OffScreenInputSurface.a((EGLContext)localObject2));
        }
        if ((!this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface.c()) && (QLog.isColorLevel())) {
          QLog.d("OffScreenGLSurface", 2, "initInputSurface[releasePBufferAndFrameBuffer]2 mSharedDataContextH=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface.a());
        }
        h();
      }
      OffScreenInputSurface localOffScreenInputSurface = this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface;
      if (localOffScreenInputSurface == null) {}
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface = new OffScreenInputSurface(this.i, this.j, (EGLContext)localObject2);
        bool1 = bool2;
      }
      catch (OffScreenInputSurface.EGLCreateContextException localEGLCreateContextException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OffScreenGLSurface", 2, "createInputSurface[EGLCreateContextException]exp=", localEGLCreateContextException);
          }
          PerformenceDataTag.a(1);
          this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface = null;
          bool1 = false;
          continue;
        }
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface;
      if (localObject2 != null)
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface.c();
          if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface.a()) {
            break label283;
          }
          throw new RuntimeException("checkEGL failed");
        }
        catch (OffScreenInputSurface.EGLMakeCurrentException localEGLMakeCurrentException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OffScreenGLSurface", 2, "createInputSurface[EGLMakeCurrentException]exp=", localEGLMakeCurrentException);
          }
          PerformenceDataTag.a(2);
          this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface = null;
        }
        return bool1;
      }
    }
  }
  
  private void f()
  {
    this.jdField_c_of_type_Boolean = true;
    this.d = false;
    this.f = false;
    this.g = false;
    this.h = false;
  }
  
  private void g()
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    this.e = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.a(this.e, this.i, this.j, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.a, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.jdField_b_of_type_JavaNioByteBuffer, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.jdField_c_of_type_JavaNioByteBuffer);
    int i1 = GLES20.glGetError();
    if (i1 != 0) {
      GLSurfaceUtil.a("glDrawFrame:err=" + i1);
    }
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterOpenglFrameBuffer != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterOpenglFrameBuffer.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterOpenglFrameBuffer = null;
    c();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface = null;
  }
  
  public Handler a()
  {
    if ((this.jdField_a_of_type_AndroidOsHandlerThread != null) && (this.jdField_b_of_type_AndroidOsHandler != null)) {
      return this.jdField_b_of_type_AndroidOsHandler;
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("glProcess");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_b_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mMsghandler = this.jdField_b_of_type_AndroidOsHandler;
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 2)) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, RMVideoClipSpec paramRMVideoClipSpec)
  {
    this.k = paramInt1;
    this.l = paramInt2;
    this.i = paramRMVideoClipSpec.c;
    this.j = paramRMVideoClipSpec.d;
    this.m = paramRMVideoClipSpec.e;
    this.n = paramRMVideoClipSpec.f;
    if (this.i % 2 != 0) {
      this.i -= 1;
    }
    if (this.j % 2 != 0) {
      this.j -= 1;
    }
    if (this.m % 2 != 0) {
      this.m -= 1;
    }
    if (this.n % 2 != 0) {
      this.n -= 1;
    }
    com.tencent.ttpic.config.MediaConfig.VIDEO_OUTPUT_WIDTH = this.i;
    com.tencent.ttpic.config.MediaConfig.VIDEO_OUTPUT_HEIGHT = this.j;
    com.tencent.ttpic.config.MediaConfig.VIDEO_IMAGE_WIDTH = this.i;
    com.tencent.ttpic.config.MediaConfig.VIDEO_IMAGE_HEIGHT = this.j;
    this.o = CameraControl.a().a();
    paramInt1 = CameraControl.a().b();
    if (paramInt1 <= 0) {
      this.p = 270;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OffScreenGLSurface", 2, "setPreviewSize:mVideoClipDegree=" + this.p);
      }
      GLSurfaceUtil.jdField_c_of_type_Boolean = false;
      try
      {
        CameraGLSurfaceView.initTotalBufferSize(this.k, this.l, this.o);
        GLSurfaceUtil.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.a(this.i, this.j);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.d = false;
        this.f = true;
        return;
        this.p = paramInt1;
      }
      catch (UnsatisfiedLinkError paramRMVideoClipSpec)
      {
        for (;;)
        {
          GLSurfaceUtil.jdField_c_of_type_Boolean = false;
        }
      }
    }
  }
  
  public void a(PreviewContext paramPreviewContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext = paramPreviewContext;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mPTVRealBeauty = true;
      if (this.jdField_b_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mMsghandler = this.jdField_b_of_type_AndroidOsHandler;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface != null)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterOpenglFrameBuffer = new PtvFilterOpenglFrameBuffer();
        this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterOpenglFrameBuffer.a(false, false);
        d();
      }
      SVFilterPreprocessFpsTest.b();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterOpenglFrameBuffer = null;
  }
  
  public boolean a()
  {
    return GLSurfaceUtil.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mMsghandler = null;
      }
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      PtvFilterUtils.a(this.jdField_a_of_type_AndroidOsHandlerThread);
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
      this.jdField_b_of_type_AndroidOsHandler = null;
    }
  }
  
  public void c()
  {
    b(false);
  }
  
  public void d()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.a()) {
      this.jdField_c_of_type_Boolean = false;
    }
    this.d = true;
    this.e = false;
  }
  
  public void e()
  {
    GLES20.glClear(16384);
    if ((this.f) && (this.jdField_c_of_type_Boolean) && (this.d)) {
      g();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject = null;
    if (paramMessage.what == -16716524)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OffScreenGLSurface", 2, "handleMessage SETPREVIEW=" + paramMessage.arg1 + "*" + paramMessage.arg2);
      }
      a(paramMessage.arg1, paramMessage.arg2, (RMVideoClipSpec)paramMessage.obj);
      this.g = true;
      if (this.h) {
        a(b());
      }
    }
    do
    {
      for (;;)
      {
        return true;
        if (paramMessage.what == -16716523)
        {
          this.h = true;
          if (this.g) {
            a(b());
          }
          if (QLog.isColorLevel()) {
            QLog.d("OffScreenGLSurface", 2, "[FILE_CACHE_OPENGL_RANDER_DATA_INIT]");
          }
        }
        else
        {
          if (paramMessage.what != -16716522) {
            break;
          }
          f();
          this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface$GLSharedData.a();
          this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface$GLSharedData.a = null;
          this.jdField_a_of_type_Usk.d = 0;
          this.jdField_a_of_type_Usk.a = false;
          this.jdField_a_of_type_Usk.c = -1;
          h();
          if (QLog.isColorLevel()) {
            QLog.d("OffScreenGLSurface", 2, "[FILE_CACHE_OPENGL_RANDER_DATA_FINISH]");
          }
        }
      }
    } while (paramMessage.what != -16716526);
    if (QLog.isColorLevel()) {
      QLog.d("OffScreenGLSurface", 2, "[CAMERA_OPENGL_RANDER_DATA]");
    }
    int i1 = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if (i1 != 0)
    {
      GLSurfaceUtil.a("handleMessage:[RenderModeCheck-Recorder][May Lost Frame] mode=" + i1);
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterOpenglFrameBuffer != null) {
      SVFilterPreprocessFpsTest.a(PtvFilterUtils.a() / 1000L);
    }
    int i2;
    if (paramMessage.obj != null)
    {
      if (paramMessage.arg1 == 0) {
        localObject = (byte[])paramMessage.obj;
      }
      for (;;)
      {
        l1 = PtvFilterUtils.a();
        i2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.a(this.o, this.i, this.j, this.k, this.l, this.p, (byte[])localObject);
        SVFilterPreprocessFpsTest.d((PtvFilterUtils.a() - l1) / 1000L);
        if ((paramMessage.arg2 == 1) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)) {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.addUserBufferRecycle((byte[])localObject);
        }
        if (i2 != 0) {
          break label1082;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterOpenglFrameBuffer == null) {
          break label1073;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface$GLSharedData.a != null) {
          break;
        }
        GLSurfaceUtil.a("handleMessage:[RenderModeCheck-Recorder][May Lost Frame] mode=" + i1);
        return true;
        if (paramMessage.arg1 == 1) {
          localObject = ((PreviewContext.VFrameData)paramMessage.obj).jdField_a_of_type_ArrayOfByte;
        }
      }
      long l1 = PtvFilterUtils.a();
      TextureDataPipe localTextureDataPipe = a();
      if (localTextureDataPipe != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterOpenglFrameBuffer.a(localTextureDataPipe.a);
        GLSurfaceUtil.a("handleMessage:[CAMERA_OPENGL_RANDER_DATA] bindTextureId=" + localTextureDataPipe.a);
        GLES20.glViewport(0, 0, this.i, this.j);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLSurfaceUtil.a("handleMessage:[CAMERA_OPENGL_RANDER_DATA] Begin drawFrame mWidth=" + this.i + " mHeight=" + this.j);
        e();
        GLSurfaceUtil.a("handleMessage:[CAMERA_OPENGL_RANDER_DATA] End drawFrame");
        if (!jdField_b_of_type_Boolean) {}
        AVIOStruct localAVIOStruct;
        for (boolean bool = true;; bool = false)
        {
          PtvFilterUtils.a(bool);
          GLSurfaceUtil.a("handleMessage:[CAMERA_OPENGL_RANDER_DATA] glSyncCommand OK: sNeedSyncUseFlush=" + jdField_b_of_type_Boolean);
          if (paramMessage.arg1 != 1) {
            break label1062;
          }
          localAVIOStruct = ((PreviewContext.VFrameData)paramMessage.obj).jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct;
          if (localAVIOStruct != null) {
            break;
          }
          throw new RuntimeException("OffScreenGLSurface:msg.arg1=" + paramMessage.arg1 + " frame=null");
        }
        QLog.d("PtvFilterUtils", 4, "OffScreenGLSurface:handleMessage:writeVideoFrame frameIndex=" + localAVIOStruct.pFrameIndex);
        localObject = localAVIOStruct;
        if (localAVIOStruct.pFrameIndex == 0)
        {
          this.jdField_a_of_type_Usk.a = true;
          localObject = localAVIOStruct;
        }
        label750:
        long l2 = SystemClock.elapsedRealtime();
        ((AVIOStruct)localObject).vFrameTime = l2;
        localTextureDataPipe.a(paramMessage.arg1, localObject);
        localTextureDataPipe.e();
        bool = this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface$GLSharedData.a.a();
        GLSurfaceUtil.a("handleMessage:writeVideoFrame  mNewSession=" + this.jdField_a_of_type_Usk.a + "  Make data ready: frameIndex= " + ((AVIOStruct)localObject).pFrameIndex + "  hasRenaderFrame=" + bool);
        if (!bool)
        {
          if (this.jdField_a_of_type_Usk.a) {
            b((AVIOStruct)localObject);
          }
          localTextureDataPipe.a();
        }
        GLSurfaceUtil.a("handleMessage:writeVideoFrame  error=" + i2 + " frameBufferTime=" + l2 + "  sNeedSyncUseFlush=" + jdField_b_of_type_Boolean);
      }
      SVFilterPreprocessFpsTest.c((PtvFilterUtils.a() - l1) / 1000L);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OffScreenGLSurface", 2, "[CAMERA_OPENGL_RANDER_DATA]videoContext=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext);
      }
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)) {
        QLog.d("OffScreenGLSurface", 2, "[CAMERA_OPENGL_RANDER_DATA]videoContext.notifyFirstFrame=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame)) {
        this.jdField_a_of_type_AndroidOsHandler.post(new usj(this));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterOpenglFrameBuffer == null) {
        break;
      }
      SVFilterPreprocessFpsTest.b(PtvFilterUtils.a() / 1000L);
      SVFilterPreprocessFpsTest.a();
      break;
      label1062:
      localObject = new AVIOStruct();
      break label750;
      label1073:
      GLSurfaceUtil.a("handleMessage:byteBufferProcessFrame  framebuffer=null");
    }
    label1082:
    GLSurfaceUtil.a("handleMessage:byteBufferProcessFrame  error=" + i2);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\util\OffScreenGLSurface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */