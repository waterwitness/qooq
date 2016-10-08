package com.tencent.mobileqq.activity.richmedia.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoClipSpec;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext.VFrameData;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import pej;

public class CameraGLSurfaceView
  extends GLSurfaceView
  implements GLSurfaceView.Renderer, Handler.Callback
{
  public static final int a = 0;
  private static final String jdField_a_of_type_JavaLangString = "CameraGLSurfaceView";
  public static final boolean a = true;
  public static final int b = 1;
  public static final int c = -16716526;
  public static final int d = -16716525;
  private static final int jdField_e_of_type_Int = 2;
  private static final int n = 0;
  private static final int o = 1;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public GLSurfaceUtil a;
  private PreviewContext jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  private volatile boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  
  public CameraGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.m = 270;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    b();
  }
  
  public CameraGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.m = 270;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    b();
  }
  
  private int a()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndAdd(0) != 0)
    {
      a("beginRenderFileCacheData: lost frame");
      return -1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.a.position(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.jdField_b_of_type_JavaNioByteBuffer.position(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.jdField_c_of_type_JavaNioByteBuffer.position(0);
      return 0;
    }
    a("handleMessage:beginRenderFileCacheData:panelY=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.a);
    return -2;
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraGLSurfaceView", 2, paramString);
    }
  }
  
  public static native ByteBuffer allocate(int paramInt1, int paramInt2);
  
  private void b()
  {
    setEGLContextClientVersion(2);
    super.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    super.setRenderer(this);
    super.setRenderMode(0);
    super.getHolder().setFormat(1);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.e = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandlerThread = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil = new GLSurfaceUtil();
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mMsghandler = null;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void e()
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    this.d = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.a(this.d, this.jdField_f_of_type_Int, this.g, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.a, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.jdField_b_of_type_JavaNioByteBuffer, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.jdField_c_of_type_JavaNioByteBuffer);
    int i1 = GLES20.glGetError();
    if (i1 != 0) {
      a("glDrawFrame:err=" + i1);
    }
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
  }
  
  public static native int getBitmap(Bitmap paramBitmap, ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, ByteBuffer paramByteBuffer3, int paramInt);
  
  public static native void initTotalBufferSize(int paramInt1, int paramInt2, int paramInt3);
  
  public static native int processVideoFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, ByteBuffer paramByteBuffer3, boolean paramBoolean2);
  
  public static native int writeVideoFrame(int paramInt1, int paramInt2, AVIOStruct paramAVIOStruct);
  
  public Handler a()
  {
    if ((this.jdField_a_of_type_AndroidOsHandlerThread != null) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
      return this.jdField_a_of_type_AndroidOsHandler;
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("glProcess");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mMsghandler = this.jdField_a_of_type_AndroidOsHandler;
      }
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 2)) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(paramInt);
    }
  }
  
  public boolean a()
  {
    return GLSurfaceUtil.jdField_b_of_type_Boolean;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    byte[] arrayOfByte = null;
    int i1;
    if (paramMessage.what == -16716526)
    {
      i1 = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      if (i1 != 0) {
        a("handleMessage:[RenderModeCheck-Recorder][May Lost Frame] mode=" + i1);
      }
    }
    label340:
    do
    {
      do
      {
        do
        {
          return true;
        } while (paramMessage.obj == null);
        if (paramMessage.arg1 == 0) {
          arrayOfByte = (byte[])paramMessage.obj;
        }
        for (;;)
        {
          i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.a(this.l, this.jdField_f_of_type_Int, this.g, this.h, this.i, this.m, arrayOfByte);
          if ((paramMessage.arg2 == 1) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)) {
            this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.addUserBufferRecycle(arrayOfByte);
          }
          if (i1 != 0) {
            break label340;
          }
          requestRender();
          long l1 = SystemClock.elapsedRealtime();
          a("handleMessage:requestRender  renderTime=" + l1);
          if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame)) {
            post(new pej(this));
          }
          if (paramMessage.arg1 != 1) {
            break;
          }
          try
          {
            paramMessage = ((PreviewContext.VFrameData)paramMessage.obj).jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct;
            if (l1 != 0L)
            {
              a("handleMessage:writeVideoFrame  renderTime=" + l1 + " oldtime=" + paramMessage.vFrameTime + " diff=" + (l1 - paramMessage.vFrameTime));
              paramMessage.vFrameTime = l1;
            }
            i1 = writeVideoFrame(this.jdField_f_of_type_Int, this.g, paramMessage);
          }
          catch (UnsatisfiedLinkError paramMessage)
          {
            for (;;)
            {
              i1 = -15;
            }
          }
          a("handleMessage:writeVideoFrame  error=" + i1);
          return true;
          if (paramMessage.arg1 == 1) {
            arrayOfByte = ((PreviewContext.VFrameData)paramMessage.obj).jdField_a_of_type_ArrayOfByte;
          }
        }
        a("handleMessage:byteBufferProcessFrame  error=" + i1);
        return true;
      } while (paramMessage.what != -16716525);
      i1 = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      if (i1 != 1)
      {
        a("handleMessage:[RenderModeCheck-Preview] mode=" + i1);
        return true;
      }
    } while (a() != 0);
    requestRender();
    return true;
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    GLES20.glClear(16384);
    if ((this.e) && (this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean)) {
      e();
    }
  }
  
  public void onPause()
  {
    if (this.jdField_f_of_type_Boolean)
    {
      super.onPause();
      this.jdField_f_of_type_Boolean = false;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    a();
    this.jdField_f_of_type_Boolean = true;
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.a()) {
      this.jdField_b_of_type_Boolean = false;
    }
    this.jdField_c_of_type_Boolean = true;
    this.d = false;
  }
  
  public void setPreviewSize(int paramInt1, int paramInt2, RMVideoClipSpec paramRMVideoClipSpec)
  {
    this.h = paramInt1;
    this.i = paramInt2;
    this.jdField_f_of_type_Int = paramRMVideoClipSpec.c;
    this.g = paramRMVideoClipSpec.d;
    this.j = paramRMVideoClipSpec.e;
    this.k = paramRMVideoClipSpec.jdField_f_of_type_Int;
    if (this.jdField_f_of_type_Int % 2 != 0) {
      this.jdField_f_of_type_Int -= 1;
    }
    if (this.g % 2 != 0) {
      this.g -= 1;
    }
    if (this.j % 2 != 0) {
      this.j -= 1;
    }
    if (this.k % 2 != 0) {
      this.k -= 1;
    }
    this.l = CameraControl.a().a();
    paramInt1 = CameraControl.a().b();
    if (paramInt1 <= 0) {
      this.m = 270;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraGLSurfaceView", 2, "setPreviewSize:mVideoClipDegree=" + this.m);
      }
      GLSurfaceUtil.jdField_c_of_type_Boolean = false;
      try
      {
        initTotalBufferSize(this.h, this.i, this.l);
        GLSurfaceUtil.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.a(this.jdField_f_of_type_Int, this.g);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.d = false;
        this.e = true;
        return;
        this.m = paramInt1;
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
  
  public void setVideoContext(PreviewContext paramPreviewContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext = paramPreviewContext;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mMsghandler = this.jdField_a_of_type_AndroidOsHandler;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mPTVRealBeauty = true;
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    super.surfaceDestroyed(paramSurfaceHolder);
    d();
    c();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\view\CameraGLSurfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */