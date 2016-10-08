package com.tencent.av.opengl.effects;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.opengl.GLES20;
import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.AndroidCamera;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.glrenderer.GLES20Canvas;
import com.tencent.av.opengl.program.RGBToYUVProgrtam;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.program.TextureProgramFactory;
import com.tencent.av.opengl.shader.ShaderParameter;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.av.utils.TipsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.VideoModule;
import com.tencent.ttpic.filter.VideoFilterList;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.VideoPrefsUtil;
import com.tencent.ttpic.util.VideoUtil;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector.FACE_DETECT_MODE;
import com.tencent.util.PhoneProperty;
import com.tencent.view.RendererUtils;
import gjp;
import gjq;
import gjr;
import gjs;
import gjt;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.List;

public class FilterProcessRender
  extends AbstractEffects
{
  public static final int a = 5;
  public static final String a = "effects_face_file";
  public static final String b = "key_frist_use_Face";
  public static final int f = 4;
  private double jdField_a_of_type_Double;
  long jdField_a_of_type_Long;
  Handler jdField_a_of_type_AndroidOsHandler;
  public TipsManager a;
  public volatile VideoFilterList a;
  ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  private FloatBuffer jdField_a_of_type_JavaNioFloatBuffer;
  boolean jdField_a_of_type_Boolean;
  byte[] jdField_a_of_type_ArrayOfByte;
  private int[] jdField_a_of_type_ArrayOfInt;
  int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  boolean jdField_b_of_type_Boolean;
  byte[] jdField_b_of_type_ArrayOfByte;
  private int[] jdField_b_of_type_ArrayOfInt;
  int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  public boolean c;
  byte[] jdField_c_of_type_ArrayOfByte;
  private int[] jdField_c_of_type_ArrayOfInt;
  int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  byte[] jdField_d_of_type_ArrayOfByte;
  int jdField_e_of_type_Int;
  byte[] jdField_e_of_type_ArrayOfByte;
  private int g;
  private int h;
  private int i;
  
  public FilterProcessRender(Context paramContext, GLRootView paramGLRootView)
  {
    super(paramContext, paramGLRootView);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Double = 1.0D;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfInt = new int[2];
    this.jdField_b_of_type_ArrayOfInt = new int[1];
    this.jdField_c_of_type_ArrayOfInt = new int[1];
    this.jdField_a_of_type_JavaNioByteBuffer = null;
    this.jdField_d_of_type_Boolean = PhoneProperty.instance().isCannotReuseFrameBuffer();
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    VideoModule.init(paramContext);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("effects_face_file", 4).getBoolean("key_frist_use_Face" + VideoController.a().a().a(), false);
    VideoPreviewFaceOutlineDetector.getInstance().setFaceDetectMode(VideoPreviewFaceOutlineDetector.FACE_DETECT_MODE.SINGLE);
    VideoPrefsUtil.setMaterialMute(true);
    com.tencent.ttpic.util.VideoMaterialUtil.SCALE_FACE_DETECT = 0.25D;
    if (QLog.isColorLevel()) {
      QLog.d(EffectsRenderController.a, 2, "isFristUseFace    " + this.jdField_a_of_type_Boolean + "  " + VideoController.a().a().a());
    }
    this.jdField_b_of_type_ArrayOfInt[0] = -1;
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_JavaNioFloatBuffer != null) {
      return;
    }
    float[] arrayOfFloat = new float[8];
    arrayOfFloat[0] = (-0.5F + 0.0F);
    arrayOfFloat[1] = (-0.5F + 0.0F);
    arrayOfFloat[2] = (0.5F + 0.0F);
    arrayOfFloat[3] = (-0.5F + 0.0F);
    arrayOfFloat[4] = (-0.5F + 0.0F);
    arrayOfFloat[5] = (0.5F + 0.0F);
    arrayOfFloat[6] = (0.5F + 0.0F);
    arrayOfFloat[7] = (0.5F + 0.0F);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(arrayOfFloat.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_a_of_type_JavaNioFloatBuffer = localByteBuffer.asFloatBuffer();
    this.jdField_a_of_type_JavaNioFloatBuffer.put(arrayOfFloat);
    this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(EffectsRenderController.a, 2, "updatePreviewSize initial()     " + this.g + "  " + this.h + " yuvCenterTextureId[0] " + this.jdField_b_of_type_ArrayOfInt[0]);
    }
    if (this.jdField_b_of_type_ArrayOfInt[0] != -1) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(EffectsRenderController.a, 2, "updatePreviewSize initial()  noreturn    " + this.g + "  " + this.h + " yuvCenterTextureId[0] " + this.jdField_b_of_type_ArrayOfInt[0]);
      }
      this.jdField_b_of_type_Boolean = true;
      GLES20.glGenTextures(this.jdField_b_of_type_ArrayOfInt.length, this.jdField_b_of_type_ArrayOfInt, 0);
      GLES20.glGenTextures(this.jdField_c_of_type_ArrayOfInt.length, this.jdField_c_of_type_ArrayOfInt, 0);
      GLES20.glGenTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
    } while (this.g == 0);
    int j = this.g;
    int k = this.h;
    this.g = 0;
    this.h = 0;
    if (this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList != null) {
      this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.ApplyGLSLFilter();
    }
    a(j, k);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) && (paramInt2 != 0) && ((this.g != paramInt1) || (this.h != paramInt2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(EffectsRenderController.a, 2, "updatePreviewSize " + paramInt1 + "   " + paramInt2 + "   " + this.g + "  " + this.h + "  " + this.jdField_c_of_type_Int);
      }
      this.g = paramInt1;
      this.h = paramInt2;
      this.i = (this.g * this.h * 4);
      if (this.jdField_a_of_type_JavaNioByteBuffer != null) {
        this.jdField_a_of_type_JavaNioByteBuffer.clear();
      }
      this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(paramInt1 * paramInt2 * 3 / 2);
      this.jdField_b_of_type_Int = AVGLUtils.a(paramInt1, paramInt2, this.jdField_b_of_type_ArrayOfInt[0]);
      this.jdField_c_of_type_Int = AVGLUtils.a(paramInt2, paramInt1, this.jdField_c_of_type_ArrayOfInt[0]);
      this.jdField_a_of_type_Double = (paramInt1 / paramInt1);
      if ((this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList != null) && (this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.isValid())) {
        this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.updateVideoSize(this.g, this.h, this.jdField_a_of_type_Double);
      }
      e();
      if (QLog.isColorLevel()) {
        QLog.d(EffectsRenderController.a, 2, "updatePreviewSize  rgbRotateCenterTextureFbo " + this.jdField_c_of_type_Int);
      }
    }
  }
  
  void a(GLCanvas paramGLCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glBindFramebuffer(36160, this.jdField_c_of_type_Int);
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    paramGLCanvas = paramGLCanvas.a().a(RGBToYUVProgrtam.class);
    ShaderParameter[] arrayOfShaderParameter = paramGLCanvas.a();
    GLES20.glUseProgram(paramGLCanvas.a());
    GLES20Canvas.a(false);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt3);
    GLES20.glUniform1i(arrayOfShaderParameter[4].a, 0);
    GLES20.glUniform1f(arrayOfShaderParameter[2].a, 1.0F);
    GLES20.glUniformMatrix4fv(arrayOfShaderParameter[1].a, 1, false, AVGLUtils.d, 0);
    GLES20.glUniformMatrix4fv(arrayOfShaderParameter[3].a, 1, false, AVGLUtils.a, 0);
    GLES20.glVertexAttribPointer(arrayOfShaderParameter[0].a, 2, 5126, false, 8, this.jdField_a_of_type_JavaNioFloatBuffer);
    GLES20.glEnableVertexAttribArray(arrayOfShaderParameter[0].a);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public void a(GLCanvas paramGLCanvas, int paramInt1, int paramInt2, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    long l2 = System.currentTimeMillis();
    if ((this.g == 0) || (this.h == 0)) {
      return;
    }
    if ((this.g != 0) && (this.jdField_b_of_type_Int == -1)) {
      a();
    }
    int j;
    int k;
    int m;
    long l1;
    if ((this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList != null) && (paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d(EffectsRenderController.a, 2, "FilterProcessRender_showPreview nextFilter  " + 0L + "  " + (System.currentTimeMillis() - l2));
      }
      j = this.g * this.h / 4 / 4;
      if ((this.jdField_d_of_type_ArrayOfByte == null) || (this.jdField_d_of_type_ArrayOfByte.length < j))
      {
        this.jdField_d_of_type_ArrayOfByte = new byte[j];
        this.jdField_e_of_type_ArrayOfByte = new byte[j];
      }
      if ((this.jdField_c_of_type_ArrayOfByte == null) || (this.jdField_c_of_type_ArrayOfByte.length != this.h * this.g)) {
        this.jdField_c_of_type_ArrayOfByte = new byte[this.h * this.g];
      }
      System.arraycopy(paramArrayOfByte, 0, this.jdField_c_of_type_ArrayOfByte, 0, this.g * this.h);
      GraphicRenderMgr.getInstance().nativeScalePlane(this.jdField_c_of_type_ArrayOfByte, this.jdField_d_of_type_ArrayOfByte, this.h, this.g, this.h / 4, this.g / 4);
      if (QLog.isColorLevel()) {
        QLog.d(EffectsRenderController.a, 2, "FilterProcessRender_showPreview nativeScalePlane draw() " + 0L + "  " + (System.currentTimeMillis() - l2));
      }
      Object localObject = GraphicRenderMgr.getInstance();
      byte[] arrayOfByte1 = this.jdField_d_of_type_ArrayOfByte;
      byte[] arrayOfByte2 = this.jdField_e_of_type_ArrayOfByte;
      k = this.h / 4;
      m = this.g / 4;
      if (VideoController.a().m)
      {
        j = 270;
        ((GraphicRenderMgr)localObject).nativeRotatePlane(arrayOfByte1, arrayOfByte2, k, m, j);
        if (QLog.isColorLevel()) {
          QLog.d(EffectsRenderController.a, 2, "FilterProcessRender_showPreview nativeRotatePlane() " + 0L + "  " + (System.currentTimeMillis() - l2));
        }
        VideoPreviewFaceOutlineDetector.getInstance().init();
        VideoPreviewFaceOutlineDetector.getInstance().doTrackProcesesByY(this.jdField_e_of_type_ArrayOfByte, this.g / 4, this.h / 4);
        l1 = (this.jdField_c_of_type_Long - this.jdField_b_of_type_Long) / 1000L;
        if (QLog.isColorLevel()) {
          QLog.d(EffectsRenderController.a, 2, "FilterProcessRender_showPreview doTrackProceses=" + l1 + "  " + (System.currentTimeMillis() - l2));
        }
        if (!VideoPreviewFaceOutlineDetector.getInstance().needDetectFace()) {
          break label812;
        }
        VideoPreviewFaceOutlineDetector.getInstance().postJob(new gjp(this));
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(EffectsRenderController.a, 2, "FilterProcessRender_showPreview needDetectFace() " + l1 + "  " + (System.currentTimeMillis() - l2));
        }
        if ((paramArrayOfByte != null) && (paramBoolean))
        {
          a(paramGLCanvas, this.h, this.g, YUVTexture.a, paramArrayOfByte, this.jdField_a_of_type_ArrayOfInt, VideoController.a().m);
          GLES20.glViewport(0, 0, paramInt1, paramInt2);
          if (QLog.isColorLevel()) {
            QLog.d(EffectsRenderController.a, 2, "FilterProcessRender_drawYuvToTexture yuvCenterTextureFbo " + this.jdField_b_of_type_Int + "  " + (System.currentTimeMillis() - l2));
          }
        }
        float f1 = VideoPreviewFaceOutlineDetector.getInstance().getPhotoAngle(this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.getMaterial().isSupportLandscape());
        k = VideoPreviewFaceOutlineDetector.getInstance().getFaceCount();
        if (k <= 0)
        {
          this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.updateAllFilters(null, VideoUtil.getFaceAngle(null), f1);
          this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.RenderProcess(this.jdField_b_of_type_Int, this.jdField_b_of_type_ArrayOfInt[0], this.g, this.h);
        }
        j = 0;
        while (j < Math.min(k, this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.getMaterial().getMaxFaceCount()))
        {
          localObject = VideoPreviewFaceOutlineDetector.getInstance().getAllPoints(j);
          this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.updateAllFilters((List)localObject, VideoUtil.getFaceAngle((List)localObject), f1);
          this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.RenderProcess(this.jdField_b_of_type_Int, this.jdField_b_of_type_ArrayOfInt[0], this.g, this.h);
          j += 1;
        }
        j = 90;
        break;
        label812:
        this.jdField_d_of_type_Int = 0;
        this.jdField_c_of_type_Boolean = true;
        d();
      }
      if (QLog.isColorLevel()) {
        QLog.d(EffectsRenderController.a, 2, "FilterProcessRender_showPreview updateAllFilters() " + l1 + "  " + (System.currentTimeMillis() - l2) + "  faceCount " + k);
      }
    }
    for (;;)
    {
      a(paramGLCanvas, this.h, this.g, this.jdField_b_of_type_ArrayOfInt[0]);
      if (QLog.isColorLevel()) {
        QLog.d(EffectsRenderController.a, 2, "FilterProcessRender_showPreview  drawTextureRotate rgb2yuv =" + l1 + "us]  " + (System.currentTimeMillis() - l2));
      }
      if ((this.jdField_b_of_type_ArrayOfByte == null) || (this.jdField_b_of_type_ArrayOfByte.length != this.i)) {
        this.jdField_b_of_type_ArrayOfByte = new byte[this.i];
      }
      RendererUtils.saveTextureToRgbBuffer(this.jdField_c_of_type_ArrayOfInt[0], this.h, this.g, this.jdField_b_of_type_ArrayOfByte, this.jdField_c_of_type_Int);
      l1 = (this.jdField_c_of_type_Long - this.jdField_b_of_type_Long) / 1000L;
      if (QLog.isColorLevel()) {
        QLog.d(EffectsRenderController.a, 2, "FilterProcessRender_showPreview saveTextureToRgbBuffer " + l1 + "  " + (System.currentTimeMillis() - l2));
      }
      int n;
      if ((paramArrayOfByte != null) && (!this.jdField_b_of_type_Boolean))
      {
        paramGLCanvas = GraphicRenderMgr.getInstance();
        paramArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
        k = this.h;
        m = this.g;
        n = VideoController.a().ac;
        if (!VideoController.a().m) {
          break label1330;
        }
      }
      label1330:
      for (j = 0;; j = 2)
      {
        paramGLCanvas.sendCameraFrame2Native(paramArrayOfByte, 21, k, m, (n - j + 4) % 4, System.currentTimeMillis(), VideoController.a().m, VideoController.a().a);
        l1 = (this.jdField_c_of_type_Long - this.jdField_b_of_type_Long) / 1000L;
        if (QLog.isColorLevel()) {
          QLog.d(EffectsRenderController.a, 2, "FilterProcessRender_showPreview[GraphicRenderMgr[2]=" + l1 + "us]  " + (System.currentTimeMillis() - l2));
        }
        this.jdField_b_of_type_Boolean = false;
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, paramInt1, paramInt2);
        if (!QLog.isColorLevel()) {
          break;
        }
        this.jdField_a_of_type_Long += System.currentTimeMillis() - l2;
        this.jdField_e_of_type_Int += 1;
        QLog.d(EffectsRenderController.a, 2, "FilterProcessRender_showPreview ztime " + (System.currentTimeMillis() - l2) + "    " + this.jdField_a_of_type_Long / this.jdField_e_of_type_Int);
        return;
      }
      l1 = 0L;
    }
  }
  
  void a(GLCanvas paramGLCanvas, int paramInt1, int paramInt2, float[] paramArrayOfFloat, byte[] paramArrayOfByte, int[] paramArrayOfInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaNioByteBuffer == null) || (paramArrayOfByte == null)) {
      return;
    }
    this.jdField_a_of_type_JavaNioByteBuffer.position(0);
    this.jdField_a_of_type_JavaNioByteBuffer.put(paramArrayOfByte, 0, paramInt1 * paramInt2);
    this.jdField_a_of_type_JavaNioByteBuffer.position(0);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramArrayOfInt[0]);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glTexImage2D(3553, 0, 6409, paramInt1, paramInt2, 0, 6409, 5121, this.jdField_a_of_type_JavaNioByteBuffer);
    this.jdField_a_of_type_JavaNioByteBuffer.position(0);
    this.jdField_a_of_type_JavaNioByteBuffer.put(paramArrayOfByte, paramInt1 * paramInt2, paramInt1 * paramInt2 / 2);
    this.jdField_a_of_type_JavaNioByteBuffer.position(0);
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, paramArrayOfInt[1]);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glTexImage2D(3553, 0, 6410, paramInt1 / 2, paramInt2 / 2, 0, 6410, 5121, this.jdField_a_of_type_JavaNioByteBuffer);
    GLES20.glBindFramebuffer(36160, this.jdField_b_of_type_Int);
    GLES20.glViewport(0, 0, paramInt2, paramInt1);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16640);
    paramGLCanvas = paramGLCanvas.a().a(YUVTexture.class);
    paramArrayOfByte = paramGLCanvas.a();
    GLES20.glUseProgram(paramGLCanvas.a());
    GLES20.glUniform1f(paramGLCanvas.a()[7].a, paramInt1);
    GLES20.glUniform1f(paramGLCanvas.a()[8].a, paramInt2);
    GLES20.glUniformMatrix4fv(paramGLCanvas.a()[9].a, 1, false, paramArrayOfFloat, 0);
    if (AndroidCamera.n == 17)
    {
      GLES20.glUniform1i(paramGLCanvas.a()[10].a, 3);
      GLES20.glUniform1i(paramGLCanvas.a()[11].a, 0);
      GLES20Canvas.a(false);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramArrayOfInt[0]);
      GLES20.glUniform1i(paramArrayOfByte[4].a, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, paramArrayOfInt[1]);
      GLES20.glUniform1i(paramArrayOfByte[5].a, 1);
      if (!paramBoolean) {
        break label566;
      }
      GLES20.glUniformMatrix4fv(paramArrayOfByte[1].a, 1, false, AVGLUtils.c, 0);
    }
    for (;;)
    {
      GLES20.glUniformMatrix4fv(paramArrayOfByte[3].a, 1, false, AVGLUtils.a, 0);
      GLES20.glVertexAttribPointer(paramArrayOfByte[0].a, 2, 5126, false, 8, this.jdField_a_of_type_JavaNioFloatBuffer);
      GLES20.glEnableVertexAttribArray(paramArrayOfByte[0].a);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(paramArrayOfByte[0].a);
      GLES20.glBindFramebuffer(36160, 0);
      return;
      GLES20.glUniform1i(paramGLCanvas.a()[10].a, 1);
      break;
      label566:
      GLES20.glUniformMatrix4fv(paramArrayOfByte[1].a, 1, false, AVGLUtils.d, 0);
    }
  }
  
  public void a(VideoFilterList paramVideoFilterList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(EffectsRenderController.a, 2, "updatePreviewSize changeVideoFilter    " + this.g + "  " + this.h);
    }
    if ((this.g == 0) || (this.h == 0)) {
      a(AndroidCamera.m, AndroidCamera.l);
    }
    if ((paramVideoFilterList != null) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidOsHandler.post(new gjr(this));
    }
    if ((this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList != null) && (this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.isValid()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(EffectsRenderController.a, 2, "updatePreviewSize destroy() ");
      }
      this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.destroy();
      this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList = null;
    }
    if ((paramVideoFilterList != null) && (paramVideoFilterList.isValid()))
    {
      this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList = paramVideoFilterList;
      this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.ApplyGLSLFilter();
      this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.updateVideoSize(this.g, this.h, this.jdField_a_of_type_Double);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(EffectsRenderController.a, 2, "FilterProcessRender_showPreview showFacePrompt  msg: " + paramString);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new gjs(this, paramString));
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new gjt(this), 1500L);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    paramArrayOfByte.position(0);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glTexImage2D(3553, 0, 6409, paramInt2, paramInt3, 0, 6409, 5121, paramArrayOfByte);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(EffectsRenderController.a, 2, "FilterProcessRender clear()    " + this.g + " yuvCenterTextureId[0] " + this.jdField_b_of_type_ArrayOfInt[0] + "  yuvCenterTextureFbo " + this.jdField_b_of_type_Int);
    }
    if (this.jdField_a_of_type_JavaNioByteBuffer != null)
    {
      this.jdField_a_of_type_JavaNioByteBuffer.clear();
      this.jdField_a_of_type_JavaNioByteBuffer = null;
    }
    if (this.jdField_b_of_type_Int != -1)
    {
      GLES20.glDeleteFramebuffers(2, new int[] { this.jdField_c_of_type_Int, this.jdField_b_of_type_Int }, 0);
      this.jdField_b_of_type_Int = -1;
      this.jdField_c_of_type_Int = -1;
    }
    if (this.jdField_b_of_type_ArrayOfInt[0] != -1)
    {
      GLES20.glDeleteTextures(this.jdField_b_of_type_ArrayOfInt.length, this.jdField_b_of_type_ArrayOfInt, 0);
      GLES20.glDeleteTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
      GLES20.glDeleteTextures(this.jdField_c_of_type_ArrayOfInt.length, this.jdField_c_of_type_ArrayOfInt, 0);
      this.jdField_a_of_type_ArrayOfInt[0] = -1;
      this.jdField_a_of_type_ArrayOfInt[1] = -1;
      this.jdField_b_of_type_ArrayOfInt[0] = -1;
      this.jdField_c_of_type_ArrayOfInt[0] = -1;
      if (this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList != null) {
        this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList.destroy();
      }
    }
  }
  
  public void d()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("effects_face_file", 4).edit().putBoolean("key_frist_use_Face" + VideoController.a().a().a(), true);
      this.jdField_a_of_type_AndroidOsHandler.post(new gjq(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\effects\FilterProcessRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */