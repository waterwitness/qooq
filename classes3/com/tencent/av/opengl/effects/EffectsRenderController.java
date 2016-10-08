package com.tencent.av.opengl.effects;

import android.content.Context;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.AndroidCamera;
import com.tencent.av.camera.CameraObserver;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.config.EffectFaceDeviceConfig;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.glrenderer.GLES20Canvas;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.util.DecryptListener;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import gjl;
import gjn;
import gjo;

public class EffectsRenderController
  extends AbstractEffects
{
  public static final int a = 4;
  public static final DecryptListener a;
  public static String a;
  public static final int b = 1400000;
  public static String b;
  static boolean b;
  static boolean c;
  CameraObserver a;
  public FilterProcessRender a;
  public boolean a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "EffectsRenderController";
    jdField_b_of_type_JavaLangString = "actAVFunChatDecorate";
    jdField_a_of_type_ComTencentTtpicUtilDecryptListener = new gjn();
  }
  
  public EffectsRenderController(Context paramContext, GLRootView paramGLRootView)
  {
    super(paramContext, paramGLRootView);
    this.jdField_a_of_type_ComTencentAvCameraCameraObserver = new gjl(this);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender = new FilterProcessRender(paramContext, paramGLRootView);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updatePreviewSize EffectsRenderController new ()");
    }
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
  
  public static boolean a()
  {
    long l1 = System.currentTimeMillis();
    if (!jdField_b_of_type_Boolean)
    {
      boolean bool = VideoController.a().a().j();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getEffectsSoLoadIsOk  isResult：  " + bool);
      }
      if (!bool) {}
      EffectFaceDeviceConfig localEffectFaceDeviceConfig;
      do
      {
        long l2;
        do
        {
          int i;
          do
          {
            do
            {
              return false;
              jdField_b_of_type_Boolean = true;
              if (!GraphicRenderMgr.soloadedPTV)
              {
                if (QLog.isColorLevel()) {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "EffectsRenderController  soloadedPTV = " + GraphicRenderMgr.soloadedPTV);
                }
                GraphicRenderMgr.soloadedPTV = PtvFilterSoLoad.a(BaseApplicationImpl.getContext(), false);
              }
            } while (!GraphicRenderMgr.soloadedPTV);
            i = VcSystemInfo.e();
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "isUserEffectFace cpucount: " + i);
            }
          } while (i < 4);
          l2 = VcSystemInfo.c();
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "isUserEffectFace cpuFrequency: " + l2);
          }
        } while (l2 < 1400000L);
        localEffectFaceDeviceConfig = EffectFaceDeviceConfig.a();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "isUserEffectFace useTime: " + (System.currentTimeMillis() - l1));
        }
      } while ((localEffectFaceDeviceConfig != null) && (localEffectFaceDeviceConfig.a == 1));
      c = true;
      return c;
    }
    return c;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "updatePreviewSize  EffectsRenderController initial() " + AndroidCamera.jdField_a_of_type_Boolean);
        }
      } while (!GraphicRenderMgr.soloadedPTV);
      CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_ComTencentAvCameraCameraObserver);
      this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.a();
      if (VideoController.a().a().K == 0) {
        a(VideoController.a().a().y, VideoController.a().a().z);
      }
    } while (!AndroidCamera.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.a(AndroidCamera.m, AndroidCamera.l);
  }
  
  public void a(GLCanvas paramGLCanvas)
  {
    if (!GraphicRenderMgr.soloadedPTV) {}
    byte[] arrayOfByte;
    do
    {
      do
      {
        return;
      } while ((VideoController.a().a().K != 0) || (VideoController.a().a().f != 2));
      arrayOfByte = VideoController.a().a;
      VideoController.a().a = null;
    } while (arrayOfByte == null);
    this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.a(paramGLCanvas, ((GLES20Canvas)paramGLCanvas).a(), ((GLES20Canvas)paramGLCanvas).b(), true, arrayOfByte);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setVideoFilter  patternPath：  " + paramString1);
    }
    if (!GraphicRenderMgr.soloadedPTV) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.setOnEvent(new gjo(this, paramString1, paramString2));
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.requestRender();
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "updatePreviewSize unfreeze()  ");
      }
    } while (!GraphicRenderMgr.soloadedPTV);
    this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.b();
    CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).b(this.jdField_a_of_type_ComTencentAvCameraCameraObserver);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\effects\EffectsRenderController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */