package com.tencent.mobileqq.ptt.preop;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PreDownloadParams$Params
{
  public int a;
  public final int[] a;
  
  public PreDownloadParams$Params()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfInt = new int[6];
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append(this.jdField_a_of_type_Int);
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      localStringBuilder.append('#').append(i).append('_').append(this.jdField_a_of_type_ArrayOfInt[i]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ptt\preop\PreDownloadParams$Params.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */