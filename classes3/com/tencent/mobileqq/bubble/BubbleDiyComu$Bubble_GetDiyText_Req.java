package com.tencent.mobileqq.bubble;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class BubbleDiyComu$Bubble_GetDiyText_Req
  extends MessageMicro
{
  public static final int USER_TEXT_INFO_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "user_text_info" }, new Object[] { null }, Bubble_GetDiyText_Req.class);
  public final PBRepeatMessageField user_text_info = PBField.initRepeatMessage(BubbleDiyComu.UserTextInfo.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\bubble\BubbleDiyComu$Bubble_GetDiyText_Req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */