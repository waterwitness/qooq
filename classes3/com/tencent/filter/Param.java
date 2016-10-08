package com.tencent.filter;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.util.BitmapUtils;
import com.tencent.util.LogUtil;
import com.tencent.view.FilterDefault;
import com.tencent.view.RendererUtils;

public abstract class Param
{
  int handle;
  String name;
  
  public Param(String paramString)
  {
    this.name = paramString;
  }
  
  public void clear() {}
  
  public void initialParams(int paramInt)
  {
    this.handle = GLES20.glGetUniformLocation(paramInt, this.name);
  }
  
  public abstract void setParams(int paramInt);
  
  public String toString()
  {
    return this.name;
  }
  
  public static class Float1sParam
    extends Param
  {
    float[] value;
    
    public Float1sParam(String paramString, float[] paramArrayOfFloat)
    {
      super();
      this.value = new float[paramArrayOfFloat.length];
      int i = 0;
      while (i < paramArrayOfFloat.length)
      {
        this.value[i] = paramArrayOfFloat[i];
        i += 1;
      }
    }
    
    public void setParams(int paramInt)
    {
      if (this.handle < 0) {
        return;
      }
      GLES20.glUniform1fv(this.handle, this.value.length, this.value, 0);
      RendererUtils.checkGlError("FloatParam setParams");
    }
    
    public String toString()
    {
      return this.name + "=" + this.value;
    }
  }
  
  public static class Float2fParam
    extends Param
  {
    float x;
    float y;
    
    public Float2fParam(String paramString, float paramFloat1, float paramFloat2)
    {
      super();
      this.x = paramFloat1;
      this.y = paramFloat2;
    }
    
    public void setParams(int paramInt)
    {
      if (this.handle < 0) {
        return;
      }
      GLES20.glUniform2f(this.handle, this.x, this.y);
      RendererUtils.checkGlError("Float2fParam setParams");
    }
    
    public String toString()
    {
      return this.name + "=" + this.x + ", " + this.y;
    }
  }
  
  public static class Float2sParam
    extends Param
  {
    float[] value;
    
    public Float2sParam(String paramString, float[] paramArrayOfFloat)
    {
      super();
      this.value = new float[paramArrayOfFloat.length];
      int i = 0;
      while (i < paramArrayOfFloat.length)
      {
        this.value[i] = paramArrayOfFloat[i];
        i += 1;
      }
    }
    
    public void setParams(int paramInt)
    {
      if (this.handle < 0) {
        return;
      }
      GLES20.glUniform2fv(this.handle, this.value.length / 2, this.value, 0);
      RendererUtils.checkGlError("Float2sParam setParams");
    }
    
    public String toString()
    {
      return this.name + "=" + this.value;
    }
  }
  
  public static class Float3fParam
    extends Param
  {
    float x;
    float y;
    float z;
    
    public Float3fParam(String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
    {
      super();
      this.x = paramFloat1;
      this.y = paramFloat2;
      this.z = paramFloat3;
    }
    
    public void setParams(int paramInt)
    {
      if (this.handle < 0) {
        return;
      }
      GLES20.glUniform3f(this.handle, this.x, this.y, this.z);
      RendererUtils.checkGlError("Float2fParam setParams");
    }
    
    public String toString()
    {
      return this.name + "=" + this.x + ", " + this.y + ", " + this.z;
    }
  }
  
  public static class FloatParam
    extends Param
  {
    float value;
    
    public FloatParam(String paramString, float paramFloat)
    {
      super();
      this.value = paramFloat;
    }
    
    public void setParams(int paramInt)
    {
      if (this.handle < 0) {
        return;
      }
      GLES20.glUniform1f(this.handle, this.value);
      RendererUtils.checkGlError("FloatParam setParams");
    }
    
    public String toString()
    {
      return this.name + "=" + this.value;
    }
    
    public float value()
    {
      return this.value;
    }
  }
  
  public static class FloatsParam
    extends Param
  {
    float[] value;
    
    public FloatsParam(String paramString, float[] paramArrayOfFloat)
    {
      super();
      this.value = new float[paramArrayOfFloat.length];
      int i = 0;
      while (i < paramArrayOfFloat.length)
      {
        this.value[i] = paramArrayOfFloat[i];
        i += 1;
      }
    }
    
    public void setParams(int paramInt)
    {
      if (this.handle < 0) {
        return;
      }
      switch (this.value.length)
      {
      }
      for (;;)
      {
        RendererUtils.checkGlError("FloatsParam setParams");
        return;
        GLES20.glUniform1f(this.handle, this.value[0]);
        continue;
        GLES20.glUniform2fv(this.handle, 1, this.value, 0);
        continue;
        GLES20.glUniform3fv(this.handle, 1, this.value, 0);
        continue;
        GLES20.glUniform4fv(this.handle, 1, this.value, 0);
        continue;
        GLES20.glUniformMatrix3fv(this.handle, 1, false, this.value, 0);
        continue;
        GLES20.glUniformMatrix4fv(this.handle, 1, false, this.value, 0);
      }
    }
    
    public String toString()
    {
      return this.name + "=" + this.value.toString();
    }
  }
  
  public static class Int2iParam
    extends Param
  {
    int x;
    int y;
    
    public Int2iParam(String paramString, int paramInt1, int paramInt2)
    {
      super();
      this.x = paramInt1;
      this.y = paramInt2;
    }
    
    public void setParams(int paramInt)
    {
      if (this.handle < 0) {
        return;
      }
      GLES20.glUniform2i(this.handle, this.x, this.y);
      RendererUtils.checkGlError("IntParam setParams");
    }
    
    public String toString()
    {
      return this.name + "= [ x = " + this.x + ", y = " + this.y + "]";
    }
  }
  
  public static class IntParam
    extends Param
  {
    int value;
    
    public IntParam(String paramString, int paramInt)
    {
      super();
      this.value = paramInt;
    }
    
    public void setParams(int paramInt)
    {
      if (this.handle < 0) {
        return;
      }
      GLES20.glUniform1i(this.handle, this.value);
      RendererUtils.checkGlError("IntParam setParams");
    }
    
    public String toString()
    {
      return this.name + "=" + this.value;
    }
  }
  
  public static class Mat4Param
    extends Param
  {
    private final float[] mMatrix;
    
    public Mat4Param(String paramString, float[] paramArrayOfFloat)
    {
      super();
      this.mMatrix = paramArrayOfFloat;
    }
    
    public void setParams(int paramInt)
    {
      GLES20.glUniformMatrix4fv(this.handle, 1, false, this.mMatrix, 0);
    }
  }
  
  public static class TextureBitmapParam
    extends Param.TextureParam
  {
    int height;
    boolean needRecycle = false;
    Bitmap textureBitmap;
    int width;
    
    public TextureBitmapParam(String paramString, Bitmap paramBitmap, int paramInt, boolean paramBoolean)
    {
      super(0, paramInt);
      this.needRecycle = paramBoolean;
      this.textureBitmap = paramBitmap;
    }
    
    public void clear()
    {
      GLES20.glActiveTexture(this.textureId);
      GLES20.glDeleteTextures(1, this.texture, 0);
      super.clear();
      if ((this.needRecycle) && (this.textureBitmap != null))
      {
        this.textureBitmap.recycle();
        this.textureBitmap = null;
      }
    }
    
    public Bitmap getTextureBitmap()
    {
      return this.textureBitmap;
    }
    
    public void initialParams(int paramInt)
    {
      super.initialParams(paramInt);
      if ((this.textureBitmap == null) || (this.textureBitmap.isRecycled())) {
        return;
      }
      this.width = this.textureBitmap.getWidth();
      this.height = this.textureBitmap.getHeight();
      GLES20.glActiveTexture(this.textureId);
      GLES20.glGenTextures(1, this.texture, 0);
      GLES20.glBindTexture(3553, this.texture[0]);
      GLUtils.texImage2D(3553, 0, this.textureBitmap, 0);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
    }
    
    public void swapTextureBitmap(Bitmap paramBitmap)
    {
      this.textureBitmap = paramBitmap;
      if ((this.textureBitmap == null) || (this.textureBitmap.isRecycled())) {
        return;
      }
      GLES20.glActiveTexture(this.textureId);
      GLES20.glBindTexture(3553, this.texture[0]);
      if ((this.textureBitmap.getWidth() == this.width) && (this.textureBitmap.getHeight() == this.height))
      {
        GLUtils.texSubImage2D(3553, 0, 0, 0, this.textureBitmap);
        return;
      }
      GLUtils.texImage2D(3553, 0, this.textureBitmap, 0);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      this.width = this.textureBitmap.getWidth();
      this.height = this.textureBitmap.getHeight();
    }
  }
  
  public static class TextureFloatsParam
    extends Param.TextureParam
  {
    int[] value;
    
    public TextureFloatsParam(String paramString, int[] paramArrayOfInt, int paramInt)
    {
      super(0, paramInt);
      this.value = paramArrayOfInt;
    }
    
    public void clear()
    {
      GLES20.glActiveTexture(this.textureId);
      GLES20.glDeleteTextures(1, this.texture, 0);
      super.clear();
    }
    
    public void initialParams(int paramInt)
    {
      super.initialParams(paramInt);
      if (this.value == null) {
        return;
      }
      GLES20.glActiveTexture(this.textureId);
      GLES20.glGenTextures(1, this.texture, 0);
      GLSLRender.nativeTextCure(this.value, this.texture[0]);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
    }
  }
  
  public static class TextureParam
    extends Param
  {
    int[] texture = { 0 };
    int textureId;
    
    public TextureParam(String paramString, int paramInt1, int paramInt2)
    {
      super();
      this.textureId = paramInt2;
      this.texture[0] = paramInt1;
    }
    
    public void clear()
    {
      super.clear();
      this.texture[0] = 0;
    }
    
    public void setParams(int paramInt)
    {
      if ((this.handle < 0) || (this.texture[0] == 0)) {
        return;
      }
      GLES20.glActiveTexture(this.textureId);
      GLES20.glBindTexture(3553, this.texture[0]);
      paramInt = 0;
      switch (this.textureId)
      {
      }
      for (;;)
      {
        GLES20.glUniform1i(this.handle, paramInt);
        RendererUtils.checkGlError("TextureParam setParams");
        return;
        paramInt = 0;
        continue;
        paramInt = 1;
        continue;
        paramInt = 2;
        continue;
        paramInt = 3;
        continue;
        paramInt = 4;
        continue;
        paramInt = 5;
        continue;
        paramInt = 6;
        continue;
        paramInt = 7;
      }
    }
  }
  
  public static class TextureResParam
    extends Param.TextureParam
  {
    int flipy = 0;
    double ratio = 0.0D;
    String textureResName = null;
    
    public TextureResParam(String paramString1, String paramString2, int paramInt)
    {
      super(0, paramInt);
      this.textureResName = paramString2;
    }
    
    public TextureResParam(String paramString1, String paramString2, int paramInt, double paramDouble)
    {
      super(0, paramInt);
      this.textureResName = paramString2;
      this.ratio = paramDouble;
    }
    
    public TextureResParam(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      super(0, paramInt1);
      this.textureResName = paramString2;
      this.flipy = paramInt2;
    }
    
    public void clear()
    {
      GLES20.glActiveTexture(this.textureId);
      GLES20.glDeleteTextures(1, this.texture, 0);
      super.clear();
    }
    
    public void initialParams(int paramInt)
    {
      super.initialParams(paramInt);
      if (this.textureResName == null) {
        return;
      }
      GLES20.glActiveTexture(this.textureId);
      GLES20.glGenTextures(1, this.texture, 0);
      GLES20.glBindTexture(3553, this.texture[0]);
      Bitmap localBitmap = FilterDefault.decodeBitmap(this.textureResName);
      Object localObject = null;
      if (localBitmap != null) {
        if (this.ratio > 0.0D) {
          if (this.ratio < 1.0D)
          {
            localObject = BitmapUtils.cropCenter(localBitmap, (int)(localBitmap.getHeight() * this.ratio), localBitmap.getHeight(), false);
            localBitmap.recycle();
            localBitmap = null;
            label100:
            if (this.flipy == 1)
            {
              localObject = new Matrix();
              ((Matrix)localObject).setValues(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, localBitmap.getHeight(), 0.0F, 0.0F, 1.0F });
              localObject = BitmapUtils.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), (Matrix)localObject);
              if (localObject != null) {
                break label312;
              }
              localObject = localBitmap;
            }
            label190:
            if (localObject == null) {
              break label319;
            }
            GLUtils.texImage2D(3553, 0, (Bitmap)localObject, 0);
            ((Bitmap)localObject).recycle();
          }
        }
      }
      for (;;)
      {
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
        return;
        localObject = BitmapUtils.cropCenter(localBitmap, localBitmap.getWidth(), (int)(localBitmap.getWidth() / this.ratio), false);
        break;
        localObject = localBitmap;
        break label100;
        LogUtil.e("Param", "lastBitmap is null " + this.textureResName);
        break label100;
        label312:
        localBitmap.recycle();
        break label190;
        label319:
        LogUtil.e("Param", "bitmap is null");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\filter\Param.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */