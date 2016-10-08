package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_struct$UserInfoExt
  extends MessageMicro
{
  public static final int HIS_STORY_FORBIDDEN_FIELD_NUMBER = 2;
  public static final int MY_STORY_FORBIDDEN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "my_story_forbidden", "his_story_forbidden" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, UserInfoExt.class);
  public final PBUInt32Field his_story_forbidden = PBField.initUInt32(0);
  public final PBUInt32Field my_story_forbidden = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\pb\qqstory_struct$UserInfoExt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */