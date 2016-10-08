package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_pgc$RspGetMediaStory
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "result", "seq", "media_storys" }, new Object[] { null, Integer.valueOf(0), null }, RspGetMediaStory.class);
  public final PBRepeatMessageField media_storys = PBField.initRepeatMessage(qqstory_pgc.RecommendItem.class);
  public qqstory_pgc.ErrorInfo result = new qqstory_pgc.ErrorInfo();
  public final PBUInt32Field seq = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\pb\qqstory_pgc$RspGetMediaStory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */