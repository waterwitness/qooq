package com.tencent.av.opengl.program;

import android.content.Context;
import android.opengl.GLES20;
import com.tencent.av.opengl.shader.AttributeShaderParameter;
import com.tencent.av.opengl.shader.ShaderParameter;
import com.tencent.av.opengl.shader.UniformShaderParameter;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TextureProgram
{
  public static final String a = "aPosition";
  public static final int b = 0;
  public static final String b = "uColor";
  public static final int c = 1;
  public static final String c = "uMatrix";
  public static final int d = 2;
  public static final String d = "uTextureMatrix";
  public static final int e = 3;
  public static final String e = "uTextureSampler0";
  public static final int f = 4;
  public static final String f = "uTextureSampler1";
  public static final int g = 5;
  public static final String g = "uTextureSampler2";
  public static final int h = 6;
  public static final String h = "uTextureSampler3";
  public static final int i = 9;
  public static final String i = "toneCurveTexture";
  public static final int j = 10;
  public static final String j = "uAlpha";
  public static final int k = 8;
  public static final String k = "aTextureCoordinate";
  public static final int l = 7;
  public static final String l = "fWidth";
  public static final int m = 8;
  public static final String m = "fHeight";
  public static final int n = 11;
  public static final String n = "leavel";
  public static final int o = 9;
  public static final String o = "colorMat";
  public static final String p = "yuvFormat";
  public static final String q = "isModel";
  ShaderParameter[] a;
  int p;
  int q;
  int r;
  
  public TextureProgram()
  {
    this.p = -1;
    this.q = -1;
    this.r = -1;
    setAppContext(GLRootView.a());
    this.q = b(35633, TextureVertexShader());
    this.r = b(35632, TextureFragmentShader());
    this.a = new ShaderParameter[] { new AttributeShaderParameter("aPosition"), new UniformShaderParameter("uMatrix"), new UniformShaderParameter("uAlpha"), new UniformShaderParameter("uTextureMatrix"), new UniformShaderParameter("uTextureSampler0") };
    this.p = a(this.q, this.r, this.a);
  }
  
  protected TextureProgram(String paramString1, String paramString2, ShaderParameter[] paramArrayOfShaderParameter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.p = -1;
    this.q = -1;
    this.r = -1;
    setAppContext(GLRootView.a());
    this.q = b(35633, paramString1);
    this.r = b(35632, paramString2);
    this.a = paramArrayOfShaderParameter;
    this.p = a(this.q, this.r, this.a);
  }
  
  public TextureProgram(String paramString1, String paramString2, ShaderParameter[] paramArrayOfShaderParameter, boolean paramBoolean)
  {
    this.p = -1;
    this.q = -1;
    this.r = -1;
    setAppContext(GLRootView.a());
    if (paramBoolean) {
      this.q = b(35633, paramString1);
    }
    for (this.r = b(35632, paramString2);; this.r = a(35632, paramString2))
    {
      this.a = new ShaderParameter[] { new AttributeShaderParameter("aPosition"), new UniformShaderParameter("uMatrix"), new UniformShaderParameter("uAlpha"), new UniformShaderParameter("uTextureMatrix"), new UniformShaderParameter("uTextureSampler0") };
      this.p = a(this.q, this.r, this.a);
      return;
      this.q = a(35633, paramString1);
    }
  }
  
  protected static native String TextureFragmentShader();
  
  protected static native String TextureVertexShader();
  
  public static int a(int paramInt1, int paramInt2, ShaderParameter[] paramArrayOfShaderParameter)
  {
    int i1 = 0;
    int i2 = GLES20.glCreateProgram();
    Utils.a();
    if (i2 == 0) {
      throw new RuntimeException("Cannot create GL program: " + GLES20.glGetError());
    }
    GLES20.glAttachShader(i2, paramInt1);
    Utils.a();
    GLES20.glAttachShader(i2, paramInt2);
    Utils.a();
    GLES20.glLinkProgram(i2);
    Utils.a();
    int[] arrayOfInt = new int[1];
    GLES20.glGetProgramiv(i2, 35714, arrayOfInt, 0);
    paramInt1 = i1;
    if (arrayOfInt[0] != 1)
    {
      GLES20.glDeleteProgram(i2);
      return 0;
    }
    while (paramInt1 < paramArrayOfShaderParameter.length)
    {
      paramArrayOfShaderParameter[paramInt1].a(i2);
      paramInt1 += 1;
    }
    return i2;
  }
  
  public static int a(int paramInt, String paramString)
  {
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    Utils.a();
    GLES20.glCompileShader(paramInt);
    Utils.a();
    return paramInt;
  }
  
  public static int b(int paramInt, String paramString)
  {
    paramInt = GLES20.glCreateShader(paramInt);
    glShaderSource(paramInt, paramString);
    Utils.a();
    GLES20.glCompileShader(paramInt);
    Utils.a();
    return paramInt;
  }
  
  protected static native void glShaderSource(int paramInt, String paramString);
  
  public static native void setAppContext(Context paramContext);
  
  public int a()
  {
    return this.p;
  }
  
  public ShaderParameter[] a()
  {
    return this.a;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\program\TextureProgram.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */