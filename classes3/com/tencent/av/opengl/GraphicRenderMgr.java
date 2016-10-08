package com.tencent.av.opengl;

import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;

public class GraphicRenderMgr
{
  private static final String TAG = "GraphicRenderMgr";
  private static volatile GraphicRenderMgr sGraphicRenderMgr;
  private static boolean soloaded;
  public static boolean soloadedPTV;
  public int decoderPtrRef;
  private GraphicRenderMgr.FocusDetectCallback mAutoFocusCallback;
  private Object mAutoFocusCallbackLock;
  
  private GraphicRenderMgr()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mAutoFocusCallbackLock = new Object();
    loadSo();
  }
  
  public static native int checkhwyuv(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9);
  
  public static GraphicRenderMgr getInstance()
  {
    if (sGraphicRenderMgr == null) {}
    try
    {
      if (sGraphicRenderMgr == null) {
        sGraphicRenderMgr = new GraphicRenderMgr();
      }
      return sGraphicRenderMgr;
    }
    finally {}
  }
  
  public static void loadSo()
  {
    if (!soloaded) {}
    try
    {
      SoLoadUtil.a(BaseApplicationImpl.getContext(), "stlport_shared", 0, false);
      UpdateAvSo.a(BaseApplicationImpl.getContext(), "qav_graphics", true);
      soloadedPTV = PtvFilterSoLoad.a(BaseApplicationImpl.getContext(), false);
      soloaded = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
  }
  
  private native int sendCameraFrame2Native(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public native void clearCameraFrames();
  
  public native String findConfigValue(String paramString1, String paramString2, String paramString3);
  
  public native void flushGlRender(String paramString);
  
  public native int getBeautyConfig();
  
  public native int getRecvDecoderFrameFunctionptr();
  
  public native void nativeRotatePlane(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3);
  
  public native void nativeScalePlane(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public void onFocusDetectResult(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GraphicRenderMgr", 2, "onFocusDetectResult:" + paramBoolean);
    }
    if (this.mAutoFocusCallback != null) {
      this.mAutoFocusCallback.a(paramBoolean);
    }
  }
  
  public native void onUinChanged(String paramString1, String paramString2);
  
  public int sendCameraFrame2Native(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, boolean paramBoolean)
  {
    return sendCameraFrame2Native(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramLong, paramBoolean, 0.0F, 0.0F, 0.0F);
  }
  
  public int sendCameraFrame2Native(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, boolean paramBoolean, float[] paramArrayOfFloat)
  {
    if ((!paramBoolean) && (paramArrayOfFloat != null) && (paramArrayOfFloat.length >= 3)) {
      return sendCameraFrame2Native(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramLong, paramBoolean, paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2]);
    }
    return sendCameraFrame2Native(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramLong, paramBoolean, 0.0F, 0.0F, 0.0F);
  }
  
  public native void setAccountUin(String paramString);
  
  public native void setBeautyConfig(int paramInt);
  
  public void setBeautyOrFaceConfig(int paramInt1, int paramInt2)
  {
    int i = getBeautyConfig();
    if (QLog.isColorLevel()) {
      QLog.w("GraphicRenderMgr", 2, "setBeautyOrFaceConfig thisLevel   " + i + "  level  " + paramInt1 + " type  " + paramInt2);
    }
    if (paramInt2 == 0)
    {
      i = i % 1000 / 100;
      if (i > 0)
      {
        paramInt2 = 100;
        paramInt1 = paramInt2 + paramInt1 % 11;
        setBeautyConfig(paramInt1);
        if (QLog.isColorLevel()) {
          QLog.w("GraphicRenderMgr", 2, "setBeautyOrFaceConfig  endlevel   " + paramInt1 + "  isHaveFace " + i);
        }
      }
    }
    do
    {
      do
      {
        return;
        paramInt2 = 0;
        break;
      } while (paramInt2 != 1);
      paramInt2 = i % 100;
      paramInt1 = paramInt1 * 100 + paramInt2;
      setBeautyConfig(paramInt1);
    } while (!QLog.isColorLevel());
    QLog.w("GraphicRenderMgr", 2, "setBeautyOrFaceConfig  endlevel   " + paramInt1 + "  isHaveBeauty " + paramInt2);
  }
  
  public native void setFocusConfig(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2);
  
  public void setFocusDetectCallback(GraphicRenderMgr.FocusDetectCallback paramFocusDetectCallback)
  {
    synchronized (this.mAutoFocusCallbackLock)
    {
      this.mAutoFocusCallback = paramFocusDetectCallback;
      return;
    }
  }
  
  public native void setGlRender(String paramString, YUVTexture paramYUVTexture);
  
  public native void setIsFocusing(boolean paramBoolean);
  
  public native void setProcessEncodeFrameFunctionPtr(int paramInt);
  
  public native boolean setYuvFrame(String paramString, int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\GraphicRenderMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */