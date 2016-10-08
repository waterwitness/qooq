package com.tencent.av.opengl.program;

import com.tencent.av.opengl.shader.AttributeShaderParameter;
import com.tencent.av.opengl.shader.ShaderParameter;
import com.tencent.av.opengl.shader.UniformShaderParameter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class YUVTextureProgram
  extends TextureProgram
{
  public YUVTextureProgram()
  {
    super(YUVTextureVertexShader(), YUVTextureFragmentShader(), new ShaderParameter[] { new AttributeShaderParameter("aPosition"), new UniformShaderParameter("uMatrix"), new UniformShaderParameter("uAlpha"), new UniformShaderParameter("uTextureMatrix"), new UniformShaderParameter("uTextureSampler0"), new UniformShaderParameter("uTextureSampler1"), new UniformShaderParameter("uTextureSampler2"), new UniformShaderParameter("fWidth"), new UniformShaderParameter("fHeight"), new UniformShaderParameter("colorMat"), new UniformShaderParameter("yuvFormat"), new UniformShaderParameter("uTextureSampler3"), new UniformShaderParameter("isModel") });
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected static native String YUVTextureFragmentShader();
  
  protected static native String YUVTextureVertexShader();
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\program\YUVTextureProgram.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */