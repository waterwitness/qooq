package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.TextureResParam;

public class VideoBlendFilter
  extends BaseFilter
{
  private static final String FRAGREMENT_SHADERS = " precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform int blendmode;\n void main()\n {\n     vec2 newcoor = vec2(textureCoordinate.x,1.0 - textureCoordinate.y);\n     vec4 c1 = texture2D(inputImageTexture2, newcoor);\n     vec4 c2 = texture2D(inputImageTexture, textureCoordinate.xy);\n        c2.a = 1.0;\n     if(blendmode == 0){\n        gl_FragColor = c2;\n     }\n     if(blendmode == 1){\n        gl_FragColor = mix(c1,c2,0.5);\n     }\n     if(blendmode == 2){\n        gl_FragColor = mix(c2,c1,c1.a);\n     }\n        gl_FragColor.a = 1.0;\n}\n";
  int blendmode = 0;
  
  public VideoBlendFilter(String paramString)
  {
    super(paramString);
  }
  
  public static VideoBlendFilter ctreateBlendFilter()
  {
    return new VideoBlendFilter(" precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform int blendmode;\n void main()\n {\n     vec2 newcoor = vec2(textureCoordinate.x,1.0 - textureCoordinate.y);\n     vec4 c1 = texture2D(inputImageTexture2, newcoor);\n     vec4 c2 = texture2D(inputImageTexture, textureCoordinate.xy);\n        c2.a = 1.0;\n     if(blendmode == 0){\n        gl_FragColor = c2;\n     }\n     if(blendmode == 1){\n        gl_FragColor = mix(c1,c2,0.5);\n     }\n     if(blendmode == 2){\n        gl_FragColor = mix(c2,c1,c1.a);\n     }\n        gl_FragColor.a = 1.0;\n}\n");
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    addParam(new Param.IntParam("blendmode", this.blendmode));
    addParam(new Param.TextureResParam("inputImageTexture2", "sh/quanminyingdi_curve.png", 33986));
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void setBlendMode(int paramInt)
  {
    this.blendmode = paramInt;
    addParam(new Param.IntParam("blendmode", paramInt));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\filter\VideoBlendFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */