package com.tencent.av.opengl.program;

import com.tencent.av.opengl.shader.AttributeShaderParameter;
import com.tencent.av.opengl.shader.ShaderParameter;
import com.tencent.av.opengl.shader.UniformShaderParameter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class RGBToYUVProgrtam
  extends TextureProgram
{
  public RGBToYUVProgrtam()
  {
    super(TextureVertexShader(), RGBToYUVProgrtamFragmentShader(), new ShaderParameter[] { new AttributeShaderParameter("aPosition"), new UniformShaderParameter("uMatrix"), new UniformShaderParameter("uAlpha"), new UniformShaderParameter("uTextureMatrix"), new UniformShaderParameter("uTextureSampler0") });
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected static native String RGBToYUVProgrtamFragmentShader();
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\program\RGBToYUVProgrtam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */