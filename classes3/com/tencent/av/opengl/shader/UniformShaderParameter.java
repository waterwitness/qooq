package com.tencent.av.opengl.shader;

import android.opengl.GLES20;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class UniformShaderParameter
  extends ShaderParameter
{
  public UniformShaderParameter(String paramString)
  {
    super(paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = GLES20.glGetUniformLocation(paramInt, this.jdField_a_of_type_JavaLangString);
    Utils.a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\shader\UniformShaderParameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */