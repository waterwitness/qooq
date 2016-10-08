package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class EmotionPanelInfo
{
  public int a;
  public EmoticonPackage a;
  public int b;
  
  public EmotionPanelInfo(int paramInt1, int paramInt2, EmoticonPackage paramEmoticonPackage)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage = paramEmoticonPackage;
  }
  
  public String toString()
  {
    String str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null) {
      str = this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId;
    }
    return "EmotionPanelInfo [type=" + this.jdField_a_of_type_Int + ", columnNum=" + this.b + ", epid=" + str + "]";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\EmotionPanelInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */