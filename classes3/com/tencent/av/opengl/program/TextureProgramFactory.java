package com.tencent.av.opengl.program;

import android.opengl.GLES20;
import com.tencent.av.opengl.texture.BasicTexture;
import com.tencent.av.opengl.texture.BitmapTexture;
import com.tencent.av.opengl.texture.GLSurfaceTexture;
import com.tencent.av.opengl.texture.ResourceTexture;
import com.tencent.av.opengl.texture.StringTexture;
import com.tencent.av.opengl.texture.UploadedTexture;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.opengl.texture.YuvFboTexture;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public class TextureProgramFactory
{
  Map a;
  
  public TextureProgramFactory()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new HashMap();
  }
  
  public TextureProgram a(BasicTexture paramBasicTexture)
  {
    int j = 1;
    label202:
    label282:
    for (;;)
    {
      String str;
      try
      {
        str = paramBasicTexture.getClass().getSimpleName();
        paramBasicTexture = (TextureProgram)this.a.get(str);
        if (paramBasicTexture == null)
        {
          i = 1;
          if (i != 0) {
            break label282;
          }
          GLES20.glValidateProgram(paramBasicTexture.a());
          if (Utils.a() != 0)
          {
            i = j;
            if (i != 0)
            {
              if ((!str.equalsIgnoreCase(BasicTexture.class.getSimpleName())) && (!str.equalsIgnoreCase(BitmapTexture.class.getSimpleName())) && (!str.equalsIgnoreCase(ResourceTexture.class.getSimpleName())) && (!str.equalsIgnoreCase(StringTexture.class.getSimpleName())) && (!str.equalsIgnoreCase(UploadedTexture.class.getSimpleName()))) {
                continue;
              }
              paramBasicTexture = new TextureProgram();
              this.a.put(str, paramBasicTexture);
            }
            return paramBasicTexture;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        int i = 0;
        continue;
        if (str.equalsIgnoreCase(YUVTexture.class.getSimpleName()))
        {
          paramBasicTexture = new YUVTextureProgram();
          continue;
        }
        if (!str.equalsIgnoreCase(YuvFboTexture.class.getSimpleName())) {
          break label202;
        }
      }
      finally {}
      paramBasicTexture = new YUVTextureAliasingProgram();
      continue;
      if (str.equals(SharpenProgram.class.getSimpleName())) {
        paramBasicTexture = new SharpenProgram();
      } else if (str.equalsIgnoreCase(GLSurfaceTexture.class.getSimpleName())) {
        paramBasicTexture = new OesTextureProgram();
      } else if (str.equalsIgnoreCase(RGBToYUVProgrtam.class.getSimpleName())) {
        paramBasicTexture = new RGBToYUVProgrtam();
      } else {
        paramBasicTexture = new TextureProgram();
      }
    }
  }
  
  public TextureProgram a(Class paramClass)
  {
    int j = 1;
    label199:
    label279:
    for (;;)
    {
      String str;
      try
      {
        str = paramClass.getSimpleName();
        paramClass = (TextureProgram)this.a.get(str);
        if (paramClass == null)
        {
          i = 1;
          if (i != 0) {
            break label279;
          }
          GLES20.glUseProgram(paramClass.a());
          if (Utils.a() != 0)
          {
            i = j;
            if (i != 0)
            {
              if ((!str.equalsIgnoreCase(BasicTexture.class.getSimpleName())) && (!str.equalsIgnoreCase(BitmapTexture.class.getSimpleName())) && (!str.equalsIgnoreCase(ResourceTexture.class.getSimpleName())) && (!str.equalsIgnoreCase(StringTexture.class.getSimpleName())) && (!str.equalsIgnoreCase(UploadedTexture.class.getSimpleName()))) {
                continue;
              }
              paramClass = new TextureProgram();
              this.a.put(str, paramClass);
            }
            return paramClass;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        int i = 0;
        continue;
        if (str.equalsIgnoreCase(YUVTexture.class.getSimpleName()))
        {
          paramClass = new YUVTextureProgram();
          continue;
        }
        if (!str.equalsIgnoreCase(YuvFboTexture.class.getSimpleName())) {
          break label199;
        }
      }
      finally {}
      paramClass = new YUVTextureAliasingProgram();
      continue;
      if (str.equals(SharpenProgram.class.getSimpleName())) {
        paramClass = new SharpenProgram();
      } else if (str.equalsIgnoreCase(GLSurfaceTexture.class.getSimpleName())) {
        paramClass = new OesTextureProgram();
      } else if (str.equalsIgnoreCase(RGBToYUVProgrtam.class.getSimpleName())) {
        paramClass = new RGBToYUVProgrtam();
      } else {
        paramClass = new TextureProgram();
      }
    }
  }
  
  public void a()
  {
    try
    {
      this.a.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\program\TextureProgramFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */