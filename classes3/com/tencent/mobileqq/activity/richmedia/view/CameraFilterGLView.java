package com.tencent.mobileqq.activity.richmedia.view;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoClipSpec;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.mediadevice.FilterPreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.ptvfilter.FilterProcessRender;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.TemplateParser;
import com.tencent.mobileqq.shortvideo.ptvfilter.test.PtvFilterTimeStatistics;
import com.tencent.mobileqq.shortvideo.util.GlPostProcessThread;
import com.tencent.mobileqq.shortvideo.util.GlPostProcessThread.FilterDrawFrameParam;
import com.tencent.mobileqq.shortvideo.util.GlPostProcessThread.FilterInitParam;
import com.tencent.mobileqq.shortvideo.util.OffScreenGLSurface;
import com.tencent.mobileqq.shortvideo.util.OffScreenGLSurface.GLSharedData;
import com.tencent.mobileqq.shortvideo.util.PTVSwitchControl;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.mobileqq.shortvideo.util.SVFilterEncodeDoubleCache;
import com.tencent.mobileqq.shortvideo.util.SVFilterEncodeDoubleCache.SharedMemoryCache;
import com.tencent.mobileqq.shortvideo.util.TextureDataPipe;
import com.tencent.mobileqq.shortvideo.util.TextureDataPipe.FrameMetaData;
import com.tencent.mobileqq.shortvideo.util.TextureDataPipe.OnFrameAvailableListener;
import com.tencent.mobileqq.shortvideo.util.TexturePileQueue;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.VideoModule;
import com.tencent.ttpic.cache.VideoImageCache2;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.filter.VideoFilterList;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import com.tencent.ttpic.util.VideoPrefsUtil;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import pef;
import peg;
import peh;
import pei;

public class CameraFilterGLView
  extends GLSurfaceView
  implements GLSurfaceView.Renderer
{
  public static final int a = 4;
  private static final GlPostProcessThread jdField_a_of_type_ComTencentMobileqqShortvideoUtilGlPostProcessThread = new GlPostProcessThread();
  private static OffScreenGLSurface jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface;
  public static final String a = "CameraFilterGLView";
  private static final int jdField_b_of_type_Int = 0;
  private static final boolean jdField_c_of_type_Boolean = true;
  private static final boolean jdField_d_of_type_Boolean = true;
  private static final boolean jdField_e_of_type_Boolean = false;
  private static final int jdField_g_of_type_Int = 90;
  private static final int jdField_h_of_type_Int = 100;
  private CameraFilterGLView.CameraGlFilterListener jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener;
  public CameraFilterGLView.SVRecordSessionParam a;
  public FilterPreviewContext a;
  private PreviewContext jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext;
  private FilterProcessRender jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender = new FilterProcessRender();
  private SVFilterEncodeDoubleCache jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache = new SVFilterEncodeDoubleCache();
  private TextureDataPipe.OnFrameAvailableListener jdField_a_of_type_ComTencentMobileqqShortvideoUtilTextureDataPipe$OnFrameAvailableListener = new pef(this);
  private peh jdField_a_of_type_Peh = new peh(null);
  private pei jdField_a_of_type_Pei = new pei(this, null);
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private int jdField_d_of_type_Int;
  private int jdField_e_of_type_Int;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private boolean jdField_g_of_type_Boolean;
  private boolean jdField_h_of_type_Boolean;
  private int i = 90;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    VideoModule.init(VideoEnvironment.a());
    VideoPrefsUtil.init(VideoEnvironment.a());
    VideoPrefsUtil.setMaterialMute(false);
  }
  
  public CameraFilterGLView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CameraFilterGLView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = 240;
    this.d = 240;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SVRecordSessionParam = new CameraFilterGLView.SVRecordSessionParam();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceFilterPreviewContext = new FilterPreviewContext();
    f();
  }
  
  private Handler a()
  {
    Handler localHandler1 = null;
    if (jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface != null) {
      localHandler1 = jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface.a();
    }
    Handler localHandler2 = localHandler1;
    if (localHandler1 == null) {
      localHandler2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mMsghandler;
    }
    return localHandler2;
  }
  
  private SVFilterEncodeDoubleCache.SharedMemoryCache a(int paramInt)
  {
    SVFilterEncodeDoubleCache.SharedMemoryCache localSharedMemoryCache = this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache.a();
    if (localSharedMemoryCache == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[writeSharedMemtoFileDegree]memoryCache=null");
      }
      return null;
    }
    if (localSharedMemoryCache.a(this.e, this.jdField_f_of_type_Int, 4))
    {
      PtvFilterUtils.a(paramInt, this.e, this.jdField_f_of_type_Int, 4, localSharedMemoryCache.a);
      return localSharedMemoryCache;
    }
    localSharedMemoryCache.a();
    return null;
  }
  
  private String a(int paramInt)
  {
    if (paramInt == VideoMaterialUtil.TRIGGER_TYPE.MOUTH_OPEN.value) {
      return "张开你的嘴";
    }
    if (paramInt == VideoMaterialUtil.TRIGGER_TYPE.EYEBROWS_RAISE.value) {
      return "挑动你的眉毛";
    }
    if (paramInt == VideoMaterialUtil.TRIGGER_TYPE.BLINK.value) {
      return "眨眨你的眼睛";
    }
    if (paramInt == VideoMaterialUtil.TRIGGER_TYPE.HEAD_SHAKE.value) {
      return "摇一摇你的头";
    }
    if (paramInt == VideoMaterialUtil.TRIGGER_TYPE.KISS.value) {
      return "嘟起你的嘴";
    }
    return null;
  }
  
  public static void a()
  {
    jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface = null;
  }
  
  private void a(SVFilterEncodeDoubleCache.SharedMemoryCache paramSharedMemoryCache, int paramInt1, boolean paramBoolean, AVIOStruct paramAVIOStruct, int paramInt2)
  {
    CameraFilterGLView.SharedMemWriteFile localSharedMemWriteFile = GlPostProcessThread.a(paramSharedMemoryCache);
    localSharedMemWriteFile.jdField_a_of_type_Int = this.e;
    localSharedMemWriteFile.jdField_b_of_type_Int = this.jdField_f_of_type_Int;
    localSharedMemWriteFile.c = paramInt1;
    localSharedMemWriteFile.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct = paramAVIOStruct;
    localSharedMemWriteFile.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache$SharedMemoryCache = paramSharedMemoryCache;
    localSharedMemWriteFile.jdField_a_of_type_Boolean = paramBoolean;
    localSharedMemWriteFile.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SVRecordSessionParam.jdField_a_of_type_Boolean;
    localSharedMemWriteFile.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache = this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache;
    localSharedMemWriteFile.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener;
    localSharedMemWriteFile.d = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache.a(localSharedMemWriteFile);
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 180;
  }
  
  private boolean b()
  {
    boolean bool = false;
    Handler localHandler = a();
    Message localMessage = Message.obtain(localHandler);
    localMessage.what = -16716523;
    jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface.a.a(EGL14.eglGetCurrentContext());
    jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface.a.a = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.a();
    if (localHandler != null)
    {
      localHandler.sendMessage(localMessage);
      bool = true;
    }
    while (!QLog.isColorLevel()) {
      return bool;
    }
    QLog.d("CameraFilterGLView", 2, "setSurfaceCreated mHandler is null=");
    return false;
  }
  
  private void f()
  {
    super.setEGLContextClientVersion(2);
    super.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    this.h = false;
    super.setRenderer(this);
    super.setRenderMode(0);
    super.getHolder().setFormat(1);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener = null;
    g();
    b();
    jdField_a_of_type_ComTencentMobileqqShortvideoUtilGlPostProcessThread.a();
  }
  
  private void g()
  {
    this.g = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_Peh.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Peh.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.jdField_a_of_type_Boolean = false;
  }
  
  private void h()
  {
    if (jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface != null) {
      jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext);
    }
  }
  
  private void i()
  {
    int m = this.e;
    int k = this.jdField_f_of_type_Int;
    int j = m / 2;
    k /= 2;
    while ((j > 100) && (k > 100))
    {
      int n = j / 2;
      k /= 2;
      m = j;
      j = n;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame tempWidth=" + m + "mDrawVideoWidth=" + this.e);
    }
    VideoMaterialUtil.SCALE_FACE_DETECT = m * 1.0D / this.e;
    if (VideoMaterialUtil.SCALE_FACE_DETECT < 0.25D) {
      VideoMaterialUtil.SCALE_FACE_DETECT = 0.25D;
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.d();
    super.requestRender();
  }
  
  private void k()
  {
    Handler localHandler = null;
    if (jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface != null)
    {
      localHandler = jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface.a();
      jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface.a.a();
    }
    if (localHandler != null)
    {
      Message localMessage = Message.obtain(localHandler);
      localMessage.what = -16716522;
      localHandler.sendMessage(localMessage);
    }
  }
  
  private void l()
  {
    if (jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface != null) {
      jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface.b();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache.a();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PtvFilterUtils", 2, "createInputSurface inputSurface=" + jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface + "  preViewContext=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext);
    }
    if (jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface == null)
    {
      jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface = new OffScreenGLSurface();
      jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface.a();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraFilterGLView", 2, "sendOffScreenGLSurfaceEGLFinish:mHasSendSurfaceFinishMsg=" + this.jdField_a_of_type_Pei.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
    }
    if (!this.jdField_a_of_type_Pei.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true)) {
      k();
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraFilterGLView", 2, "sendOffScreenGLSurfaceEGLFinish:mHasSendSurfaceFinishMsg2=" + this.jdField_a_of_type_Pei.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
    }
  }
  
  public void d()
  {
    l();
  }
  
  public void e()
  {
    jdField_a_of_type_ComTencentMobileqqShortvideoUtilGlPostProcessThread.b();
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.jdField_b_of_type_Boolean) {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender != null) {
        if (jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface.a.a == null) {
          break label700;
        }
      }
    }
    label616:
    label676:
    label700:
    for (paramGL10 = jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface.a.a.c();; paramGL10 = null)
    {
      if (paramGL10 != null) {
        paramGL10.f();
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.a(paramGL10);
      int j = 90;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener != null) {
        j = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener.a();
      }
      if ((j == 90) || (j != this.i)) {}
      this.i = j;
      Object localObject1;
      Object localObject2;
      if (paramGL10 != null)
      {
        long l1 = PtvFilterUtils.a();
        this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.a(this.c, this.d, paramGL10, true);
        l1 = (PtvFilterUtils.a() - l1) / 1000L;
        PtvFilterTimeStatistics.d(l1);
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[showPreview=" + l1 / 1000.0D + "ms]");
        }
        if ((!this.g) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener.b();
          this.g = true;
        }
        if ((this.jdField_a_of_type_Peh.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_Peh.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener.h_(true);
          this.jdField_a_of_type_Peh.jdField_b_of_type_Boolean = true;
        }
        j = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.a();
        long l2 = SystemClock.elapsedRealtime();
        if (!paramGL10.a.jdField_a_of_type_Boolean) {
          break label676;
        }
        long l3 = PtvFilterUtils.a();
        localObject1 = (AVIOStruct)paramGL10.a.jdField_a_of_type_JavaLangObject;
        ((AVIOStruct)localObject1).vFrameTime = l2;
        GLSurfaceUtil.a("handleMessage:requestRender  renderTime=" + l2);
        if (((AVIOStruct)localObject1).pFrameIndex == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SVRecordSessionParam.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SVRecordSessionParam.jdField_a_of_type_Int = 0;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SVRecordSessionParam.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SVRecordSessionParam.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener.a());
          }
          this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceFilterPreviewContext.a();
        }
        ((AVIOStruct)localObject1).pFrameIndex = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceFilterPreviewContext.a();
        if (!jdField_a_of_type_ComTencentMobileqqShortvideoUtilGlPostProcessThread.a()) {
          break label616;
        }
        localObject2 = new GlPostProcessThread.FilterDrawFrameParam();
        ((GlPostProcessThread.FilterDrawFrameParam)localObject2).jdField_a_of_type_Int = this.e;
        ((GlPostProcessThread.FilterDrawFrameParam)localObject2).jdField_b_of_type_Int = this.jdField_f_of_type_Int;
        ((GlPostProcessThread.FilterDrawFrameParam)localObject2).c = j;
        ((GlPostProcessThread.FilterDrawFrameParam)localObject2).jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct = ((AVIOStruct)localObject1);
        ((GlPostProcessThread.FilterDrawFrameParam)localObject2).d = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SVRecordSessionParam.jdField_a_of_type_Int;
        ((GlPostProcessThread.FilterDrawFrameParam)localObject2).jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache = this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache;
        ((GlPostProcessThread.FilterDrawFrameParam)localObject2).e = 4;
        ((GlPostProcessThread.FilterDrawFrameParam)localObject2).jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SVRecordSessionParam.jdField_a_of_type_Boolean;
        localObject1 = Message.obtain();
        ((Message)localObject1).what = 57380;
        ((Message)localObject1).obj = localObject2;
        jdField_a_of_type_ComTencentMobileqqShortvideoUtilGlPostProcessThread.a((Message)localObject1);
        paramGL10.c();
        l2 = (PtvFilterUtils.a() - l3) / 1000L;
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[recordToFile=" + l2 / 1000.0D + "ms]");
        }
        PtvFilterTimeStatistics.e(l2 + (0L + l1));
        PtvFilterTimeStatistics.b();
      }
      for (;;)
      {
        if (PTVSwitchControl.jdField_a_of_type_Boolean)
        {
          paramGL10 = jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface.a.a.c();
          if (paramGL10 != null) {
            paramGL10.a();
          }
        }
        return;
        localObject2 = a(j);
        paramGL10.c();
        if (localObject2 == null) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SVRecordSessionParam.jdField_a_of_type_Int == 180)
        {
          a((SVFilterEncodeDoubleCache.SharedMemoryCache)localObject2, 0, false, (AVIOStruct)localObject1, 0);
          break;
        }
        a((SVFilterEncodeDoubleCache.SharedMemoryCache)localObject2, 180, true, (AVIOStruct)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SVRecordSessionParam.jdField_a_of_type_Int);
        break;
        paramGL10.c();
      }
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glClear(16384);
      GLES20.glFinish();
      return;
    }
  }
  
  public void onPause()
  {
    if (this.h)
    {
      super.onPause();
      this.h = false;
    }
    g();
  }
  
  public void onResume()
  {
    super.onResume();
    h();
    this.h = true;
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.a(null);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.a(this.e, this.jdField_f_of_type_Int);
    }
    if ((!this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener.a();
      this.jdField_f_of_type_Boolean = true;
    }
    if ((!this.jdField_a_of_type_Pei.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender != null))
    {
      b();
      this.jdField_a_of_type_Pei.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("face", 2, "onSurfaceCreated");
    }
    setSurfaceCreated();
  }
  
  public void setFilterListener(CameraFilterGLView.CameraGlFilterListener paramCameraGlFilterListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener = paramCameraGlFilterListener;
  }
  
  public void setNeedWrite(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("faceuu", 2, "setNeedWrite isRecord" + paramBoolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SVRecordSessionParam.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setPreviewSize(int paramInt1, int paramInt2, RMVideoClipSpec paramRMVideoClipSpec)
  {
    this.e = paramRMVideoClipSpec.c;
    this.jdField_f_of_type_Int = paramRMVideoClipSpec.d;
    if (QLog.isColorLevel()) {
      QLog.d("CameraFilterGLView", 2, "setPreviewSize preViewContext=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext + "  mMsghandler" + this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mMsghandler);
    }
    Handler localHandler = a();
    Message localMessage = Message.obtain(localHandler);
    localMessage.what = -16716524;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.obj = paramRMVideoClipSpec;
    if (localHandler != null) {
      localHandler.sendMessage(localMessage);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("CameraFilterGLView", 2, "setPreviewSize mHandler is null=");
  }
  
  public void setSurfaceCreated()
  {
    this.jdField_a_of_type_Pei.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Pei.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.b();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.a();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache.a();
    this.jdField_a_of_type_Pei.jdField_a_of_type_Boolean = b();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.a().a(this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilTextureDataPipe$OnFrameAvailableListener);
    jdField_a_of_type_ComTencentMobileqqShortvideoUtilGlPostProcessThread.a.a(EGL14.eglGetCurrentContext(), this.e, this.jdField_f_of_type_Int);
    Message localMessage = Message.obtain();
    localMessage.what = 57379;
    jdField_a_of_type_ComTencentMobileqqShortvideoUtilGlPostProcessThread.a(localMessage);
    i();
  }
  
  public void setSurfaceDestroyed()
  {
    jdField_a_of_type_ComTencentMobileqqShortvideoUtilGlPostProcessThread.a.a(null, -1, -1);
    Message localMessage = Message.obtain();
    localMessage.what = 57381;
    jdField_a_of_type_ComTencentMobileqqShortvideoUtilGlPostProcessThread.a(localMessage);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache.b();
    c();
    g();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void setVideoContext(PreviewContext paramPreviewContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext = paramPreviewContext;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mPTVRealBeauty = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraFilterGLView", 2, "setVideoContext preViewContext=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext);
    }
    h();
  }
  
  public void setVideoFilter(String paramString)
  {
    VideoMaterial localVideoMaterial = null;
    Object localObject2 = null;
    int k = VideoMaterialUtil.TRIGGER_TYPE.UNKNOW.value;
    long l = SystemClock.elapsedRealtime();
    int j = k;
    Object localObject1 = localVideoMaterial;
    if (paramString != null)
    {
      j = k;
      localObject1 = localVideoMaterial;
      if (!"".equals(paramString))
      {
        VideoMemoryManager.getInstance().getVideoImageCache().clear();
        localVideoMaterial = TemplateParser.a(paramString, "params");
        VideoMemoryManager.getInstance().getVideoImageCache().loadAllImages(localVideoMaterial);
        localVideoMaterial.setDataPath(paramString);
        localVideoMaterial.setLoadImageFromCache(true);
        if (localVideoMaterial != null) {
          break label196;
        }
      }
    }
    label196:
    for (paramString = (String)localObject2;; paramString = VideoFilterUtil.createFilters(localVideoMaterial))
    {
      j = k;
      localObject1 = paramString;
      if (paramString != null)
      {
        j = k;
        localObject1 = paramString;
        if (localVideoMaterial != null)
        {
          j = localVideoMaterial.getTriggerType();
          localObject1 = paramString;
        }
      }
      l = (SystemClock.elapsedRealtime() - l) / 1000L;
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[setVideoFilter_parser=" + l / 1000.0D + "ms]");
      }
      super.queueEvent(new peg(this, (VideoFilterList)localObject1, j));
      return;
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("face", 2, "surfaceDestroyed");
    }
    setSurfaceDestroyed();
    super.surfaceDestroyed(paramSurfaceHolder);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\view\CameraFilterGLView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */