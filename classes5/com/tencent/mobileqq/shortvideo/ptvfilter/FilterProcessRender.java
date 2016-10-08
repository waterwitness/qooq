package com.tencent.mobileqq.shortvideo.ptvfilter;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.SystemClock;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ptvfilter.test.PtvFilterTimeStatistics;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.mobileqq.shortvideo.util.TextureDataPipe;
import com.tencent.mobileqq.shortvideo.util.TexturePileQueue;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.filter.VideoFilterList;
import com.tencent.ttpic.filter.VideoFlipFilter;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoUtil;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector.FACE_DETECT_MODE;
import com.tencent.util.PhoneProperty;
import com.tencent.view.RendererUtils;
import usf;

public class FilterProcessRender
{
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter;
  Frame jdField_a_of_type_ComTencentFilterFrame;
  private TexturePileQueue jdField_a_of_type_ComTencentMobileqqShortvideoUtilTexturePileQueue;
  volatile VideoFilterList jdField_a_of_type_ComTencentTtpicFilterVideoFilterList;
  VideoFlipFilter jdField_a_of_type_ComTencentTtpicFilterVideoFlipFilter;
  public boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private final float[] jdField_a_of_type_ArrayOfFloat;
  private int[] jdField_a_of_type_ArrayOfInt;
  private double jdField_b_of_type_Double;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  BaseFilter jdField_b_of_type_ComTencentFilterBaseFilter;
  Frame jdField_b_of_type_ComTencentFilterFrame;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  Frame jdField_c_of_type_ComTencentFilterFrame;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  Frame jdField_d_of_type_ComTencentFilterFrame;
  private int jdField_e_of_type_Int;
  private Frame jdField_e_of_type_ComTencentFilterFrame;
  
  public FilterProcessRender()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfInt = new int[3];
    this.jdField_a_of_type_ComTencentFilterBaseFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
    this.jdField_b_of_type_ComTencentFilterBaseFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
    this.jdField_a_of_type_ComTencentTtpicFilterVideoFlipFilter = VideoFlipFilter.createVideoFlipFilter();
    this.jdField_a_of_type_ComTencentFilterFrame = new Frame();
    this.jdField_b_of_type_ComTencentFilterFrame = new Frame();
    this.jdField_c_of_type_ComTencentFilterFrame = new Frame();
    this.jdField_d_of_type_ComTencentFilterFrame = new Frame();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilTexturePileQueue = new TexturePileQueue();
    this.jdField_a_of_type_ArrayOfFloat = new float[16];
    this.jdField_b_of_type_Boolean = PhoneProperty.instance().isCannotReuseFrameBuffer();
    this.jdField_b_of_type_Double = 1.0D;
    this.jdField_e_of_type_ComTencentFilterFrame = new Frame();
  }
  
  private Frame a(Frame paramFrame)
  {
    if (paramFrame == null) {
      return null;
    }
    Frame localFrame2 = paramFrame;
    Frame localFrame1 = paramFrame;
    for (paramFrame = localFrame2; (paramFrame.nextFrame != null) && (paramFrame.nextFrame.getTextureId() != 0); paramFrame = localFrame2)
    {
      localFrame2 = paramFrame.nextFrame;
      localFrame1 = paramFrame;
    }
    localFrame1.nextFrame = null;
    return paramFrame;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentFilterFrame.getLastRenderTextureId();
  }
  
  public SurfaceTexture a()
  {
    return this.jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  }
  
  public TexturePileQueue a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilTexturePileQueue;
  }
  
  public void a()
  {
    b();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilTexturePileQueue.a();
    GLES20.glGenTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
    this.jdField_a_of_type_ComTencentFilterBaseFilter.setNextFilter(this.jdField_b_of_type_ComTencentFilterBaseFilter, null);
    this.jdField_a_of_type_ComTencentFilterBaseFilter.ApplyGLSLFilter(true, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentTtpicFilterVideoFlipFilter.ApplyGLSLFilter();
    VideoPreviewFaceOutlineDetector.getInstance().setFaceDetectMode(VideoPreviewFaceOutlineDetector.FACE_DETECT_MODE.SINGLE);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = ((int)(this.jdField_a_of_type_Int * VideoMaterialUtil.SCALE_FACE_DETECT));
    this.jdField_d_of_type_Int = ((int)(this.jdField_b_of_type_Int * VideoMaterialUtil.SCALE_FACE_DETECT));
    this.jdField_e_of_type_Int = (this.jdField_c_of_type_Int * this.jdField_d_of_type_Int * 4);
    this.jdField_b_of_type_Double = (paramInt1 / paramInt1);
    if ((this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList != null) && (this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.isValid())) {
      this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.updateVideoSize(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_Double);
    }
    this.jdField_a_of_type_ComTencentFilterFrame.clear();
    this.jdField_d_of_type_ComTencentFilterFrame.clear();
    this.jdField_c_of_type_ComTencentFilterFrame.clear();
  }
  
  public void a(int paramInt1, int paramInt2, TextureDataPipe paramTextureDataPipe, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentFilterBaseFilter.nativeUpdateMatrix(this.jdField_a_of_type_ArrayOfFloat);
    long l;
    if ((this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList != null) && (paramBoolean))
    {
      PtvFilterTimeStatistics.a();
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
      BaseFilter localBaseFilter = this.jdField_a_of_type_ComTencentFilterBaseFilter.getmNextFilter();
      this.jdField_a_of_type_ComTencentFilterBaseFilter.removeTheFilter(localBaseFilter);
      this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(paramTextureDataPipe.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_Double, this.jdField_d_of_type_ComTencentFilterFrame);
      this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[ReadSurfaceData=" + (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L + "us]");
      }
      VideoPreviewFaceOutlineDetector.getInstance().init();
      if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length != this.jdField_e_of_type_Int)) {
        this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_e_of_type_Int];
      }
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
      this.jdField_a_of_type_ComTencentTtpicFilterVideoFlipFilter.RenderProcess(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_a_of_type_ArrayOfInt[1], this.jdField_a_of_type_Double, this.jdField_c_of_type_ComTencentFilterFrame);
      RendererUtils.saveTextureToRgbBuffer(this.jdField_a_of_type_ArrayOfInt[1], this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_a_of_type_ArrayOfByte, this.jdField_c_of_type_ComTencentFilterFrame.getFBO());
      this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[PrepareFaceData=" + (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L + "us]");
      }
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
      VideoPreviewFaceOutlineDetector.getInstance().doTrackProceses(this.jdField_a_of_type_ArrayOfByte, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
      this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
      l = (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L;
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[doTrackProceses=" + l + "us]");
      }
      if (VideoPreviewFaceOutlineDetector.getInstance().needDetectFace()) {
        VideoPreviewFaceOutlineDetector.getInstance().postJob(new usf(this));
      }
      int j;
      for (;;)
      {
        PtvFilterTimeStatistics.b(l);
        this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
        float f = VideoPreviewFaceOutlineDetector.getInstance().getPhotoAngle(this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.getMaterial().isSupportLandscape());
        j = VideoPreviewFaceOutlineDetector.getInstance().getFaceCount();
        if (j <= 0)
        {
          this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.updateAllFilters(null, VideoUtil.getFaceAngle(null), f);
          this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.RenderProcess(this.jdField_d_of_type_ComTencentFilterFrame.getFBO(), this.jdField_d_of_type_ComTencentFilterFrame.getTextureId(), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        }
        int i = 0;
        while (i < Math.min(j, this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.getMaterial().getMaxFaceCount()))
        {
          paramTextureDataPipe = VideoPreviewFaceOutlineDetector.getInstance().getAllPoints(i);
          this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.updateAllFilters(paramTextureDataPipe, VideoUtil.getFaceAngle(paramTextureDataPipe), f);
          this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.RenderProcess(this.jdField_d_of_type_ComTencentFilterFrame.getFBO(), this.jdField_d_of_type_ComTencentFilterFrame.getTextureId(), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          i += 1;
        }
        this.jdField_a_of_type_Boolean = true;
      }
      localBaseFilter.RenderProcess(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, -2, this.jdField_a_of_type_Double, this.jdField_a_of_type_ComTencentFilterFrame);
      this.jdField_a_of_type_ComTencentFilterBaseFilter.setNextFilter(localBaseFilter, null);
      this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[updateAllFilters=" + (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L + "us]" + "   faceCount=" + j);
      }
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
      if (!this.jdField_c_of_type_Boolean) {
        break label1008;
      }
      this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(this.jdField_e_of_type_ComTencentFilterFrame.getTextureId(), paramInt1, paramInt2, 0, this.jdField_a_of_type_Double, this.jdField_b_of_type_ComTencentFilterFrame);
      this.jdField_e_of_type_ComTencentFilterFrame.clear();
      this.jdField_c_of_type_Boolean = false;
    }
    for (;;)
    {
      this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[RenderOperation=" + (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L + "us]");
      }
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentFilterFrame.clear();
        this.jdField_c_of_type_ComTencentFilterFrame.clear();
        this.jdField_d_of_type_ComTencentFilterFrame.clear();
      }
      this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[ReuseFrameBuffer=" + (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L + "us]" + " cannotReuseFrameBuffer=" + this.jdField_b_of_type_Boolean);
      }
      return;
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
      this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(paramTextureDataPipe.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, -2, this.jdField_a_of_type_Double, this.jdField_a_of_type_ComTencentFilterFrame);
      this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
      l = (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L;
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[ReadSurfaceFilter[2]=" + l + "us]");
      }
      PtvFilterTimeStatistics.c(l);
      break;
      label1008:
      this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(this.jdField_a_of_type_ComTencentFilterFrame.getLastRenderTextureId(), paramInt1, paramInt2, 0, this.jdField_a_of_type_Double, this.jdField_b_of_type_ComTencentFilterFrame);
    }
  }
  
  public void a(TextureDataPipe paramTextureDataPipe)
  {
    if (paramTextureDataPipe != null) {}
    try
    {
      paramTextureDataPipe.a(this.jdField_a_of_type_ArrayOfFloat);
      if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)
      {
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
      }
      return;
    }
    catch (Exception paramTextureDataPipe)
    {
      paramTextureDataPipe.printStackTrace();
    }
  }
  
  public void a(VideoFilterList paramVideoFilterList)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_e_of_type_ComTencentFilterFrame = a(this.jdField_a_of_type_ComTencentFilterFrame);
    this.jdField_e_of_type_ComTencentFilterFrame.nextFrame = null;
    if (this.jdField_e_of_type_ComTencentFilterFrame != this.jdField_a_of_type_ComTencentFilterFrame) {
      this.jdField_a_of_type_ComTencentFilterFrame.clear();
    }
    this.jdField_d_of_type_ComTencentFilterFrame.clear();
    this.jdField_c_of_type_ComTencentFilterFrame.clear();
    if ((this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList != null) && (this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.isValid()))
    {
      this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.destroy();
      this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList = null;
    }
    if ((paramVideoFilterList != null) && (paramVideoFilterList.isValid()))
    {
      this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList = paramVideoFilterList;
      this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.ApplyGLSLFilter();
      this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.updateVideoSize(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_Double);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentFilterFrame.clear();
    this.jdField_b_of_type_ComTencentFilterFrame.clear();
    this.jdField_c_of_type_ComTencentFilterFrame.clear();
    this.jdField_d_of_type_ComTencentFilterFrame.clear();
    this.jdField_e_of_type_ComTencentFilterFrame.clear();
    GLES20.glDeleteTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
    this.jdField_a_of_type_ComTencentFilterBaseFilter.ClearGLSL();
    this.jdField_a_of_type_ComTencentTtpicFilterVideoFlipFilter.ClearGLSL();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilTexturePileQueue.b();
    if ((PtvFilterUtils.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null))
    {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.release();
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
    }
    if ((this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList != null) && (this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.isValid())) {
      this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.destroy();
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList != null) && (this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.isValid())) {
      this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.destroyAudio();
    }
    VideoPreviewFaceOutlineDetector.getInstance().destroy();
  }
  
  public void d() {}
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList != null) && (this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.isValid())) {
      this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.clearFilterTextures();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\ptvfilter\FilterProcessRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */