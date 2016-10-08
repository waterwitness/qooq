package com.tencent.av.opengl.texture;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.opengl.config.RendererConfig;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.glrenderer.GLES20Canvas;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.program.TextureProgramFactory;
import com.tencent.av.opengl.shader.ShaderParameter;
import com.tencent.av.ui.GLVideoView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class YuvFboTexture
  extends YUVTexture
{
  private static String jdField_a_of_type_JavaLangString;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "SM-G9350", "GT-I9500", "MI 3", "MX4 Pro" };
  private static String b;
  private static boolean c;
  private static boolean d;
  private static boolean f = true;
  public static int w;
  private static int x;
  private FrameBufferCenterTexture jdField_a_of_type_ComTencentAvOpenglTextureFrameBufferCenterTexture;
  private GLVideoView jdField_a_of_type_ComTencentAvUiGLVideoView;
  private boolean e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    w = 480;
    x = 1;
  }
  
  public YuvFboTexture(Context paramContext)
  {
    super(paramContext);
  }
  
  public YuvFboTexture(Context paramContext, GLVideoView paramGLVideoView)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentAvUiGLVideoView = paramGLVideoView;
    if (!this.e) {
      this.jdField_a_of_type_ComTencentAvOpenglTextureFrameBufferCenterTexture = FrameBufferCenterTexture.a();
    }
    if (jdField_a_of_type_JavaLangString == null) {
      jdField_a_of_type_JavaLangString = a(paramContext);
    }
  }
  
  public YuvFboTexture(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.e = paramBoolean;
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentAvOpenglTextureFrameBufferCenterTexture = FrameBufferCenterTexture.a();
    }
    if (jdField_a_of_type_JavaLangString == null) {
      jdField_a_of_type_JavaLangString = a(paramContext);
    }
  }
  
  public static String a(Context paramContext)
  {
    Object localObject1 = "";
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      Object localObject2;
      if (paramContext != null)
      {
        localObject2 = paramContext;
        localObject1 = paramContext;
        if (paramContext.length() > 0) {}
      }
      else
      {
        localObject2 = "";
      }
      return (String)localObject2;
    }
    catch (Exception paramContext) {}
    return (String)localObject1;
  }
  
  private static void e()
  {
    if (c) {
      return;
    }
    c = true;
    Object localObject = RendererConfig.a();
    if ((localObject != null) && (((RendererConfig)localObject).a == 1))
    {
      w = ((RendererConfig)localObject).b;
      x = ((RendererConfig)localObject).c;
      jdField_b_of_type_JavaLangString = ((RendererConfig)localObject).g;
    }
    for (;;)
    {
      String[] arrayOfString;
      int i;
      try
      {
        if ((TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))) {
          break label177;
        }
        d = false;
        localObject = jdField_b_of_type_JavaLangString.split("\\.");
        arrayOfString = jdField_a_of_type_JavaLangString.split("\\.");
        i = 0;
        if ((i >= 3) || (i >= localObject.length) || (i >= arrayOfString.length)) {
          break;
        }
        if (Integer.valueOf(arrayOfString[i]).intValue() > Integer.valueOf(localObject[i]).intValue())
        {
          d = true;
          return;
        }
      }
      catch (Exception localException)
      {
        d = false;
        return;
      }
      if (Integer.valueOf(arrayOfString[i]).intValue() < Integer.valueOf(localException[i]).intValue())
      {
        d = false;
        return;
      }
      if (i == 2)
      {
        d = true;
        break label187;
        label177:
        d = false;
        return;
        d = false;
        return;
      }
      label187:
      i += 1;
    }
  }
  
  public static boolean e()
  {
    boolean bool2 = false;
    String str = Build.MODEL;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        if (str.indexOf(jdField_a_of_type_ArrayOfJavaLangString[i]) > -1) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public TextureProgram a(GLCanvas paramGLCanvas)
  {
    return paramGLCanvas.a().a(YUVTexture.class);
  }
  
  public ShaderParameter[] a(GLCanvas paramGLCanvas)
  {
    if (a() > b())
    {
      i = a();
      e();
      if ((!d) || (getImgWidth() > w) || (i <= ((GLES20Canvas)paramGLCanvas).a() / 3 * 2) || (getImgWidth() >= i) || (getImgWidth() == 0) || (this.jdField_a_of_type_ComTencentAvUiGLVideoView.a().size() != 0)) {
        break label234;
      }
    }
    label228:
    label234:
    for (int i = 1;; i = 0)
    {
      int j = VideoController.a().a().f;
      if ((i != 0) && (j == 2)) {}
      for (i = 1;; i = 0)
      {
        if ((this.e) || (i == 0)) {
          break label228;
        }
        if (this.jdField_a_of_type_ComTencentAvOpenglTextureFrameBufferCenterTexture == null) {
          this.jdField_a_of_type_ComTencentAvOpenglTextureFrameBufferCenterTexture = FrameBufferCenterTexture.a();
        }
        super.a(paramGLCanvas);
        if (super.a() != null) {
          this.jdField_a_of_type_ComTencentAvOpenglTextureFrameBufferCenterTexture.a(paramGLCanvas, getImgWidth(), getImgHeight(), ((GLES20Canvas)paramGLCanvas).a(), ((GLES20Canvas)paramGLCanvas).b(), a()[0], a()[1], a()[2], this.jdField_b_of_type_ArrayOfFloat, this.u, x);
        }
        return paramGLCanvas.a().a(BasicTexture.class).a();
        i = b();
        break;
      }
      return super.a(paramGLCanvas);
    }
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentAvOpenglTextureFrameBufferCenterTexture != null) {
      this.jdField_a_of_type_ComTencentAvOpenglTextureFrameBufferCenterTexture.a();
    }
    c = false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\texture\YuvFboTexture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */