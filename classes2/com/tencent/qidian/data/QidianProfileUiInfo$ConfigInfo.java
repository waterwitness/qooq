package com.tencent.qidian.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qidian.proto.mobileqq_qidian.ConfigInfo;

public class QidianProfileUiInfo$ConfigInfo
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  public String d;
  
  public QidianProfileUiInfo$ConfigInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.c = "";
    this.d = "";
  }
  
  public QidianProfileUiInfo$ConfigInfo(mobileqq_qidian.ConfigInfo paramConfigInfo)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.c = "";
    this.d = "";
    if (paramConfigInfo.uint32_type.has()) {
      this.jdField_a_of_type_Int = paramConfigInfo.uint32_type.get();
    }
    if (paramConfigInfo.uint32_event.has()) {
      this.jdField_b_of_type_Int = paramConfigInfo.uint32_event.get();
    }
    if (paramConfigInfo.str_title.has()) {
      this.jdField_a_of_type_JavaLangString = paramConfigInfo.str_title.get();
    }
    if (paramConfigInfo.str_content.has()) {
      this.jdField_b_of_type_JavaLangString = paramConfigInfo.str_content.get();
    }
    if (paramConfigInfo.str_action.has()) {
      this.c = paramConfigInfo.str_action.get();
    }
    if (paramConfigInfo.str_aaction.has()) {
      this.d = paramConfigInfo.str_aaction.get();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qidian\data\QidianProfileUiInfo$ConfigInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */