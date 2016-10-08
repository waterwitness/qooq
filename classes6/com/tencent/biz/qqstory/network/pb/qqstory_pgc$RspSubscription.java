package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_pgc$RspSubscription
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "result", "is_subscribe" }, new Object[] { null, Integer.valueOf(0) }, RspSubscription.class);
  public final PBUInt32Field is_subscribe = PBField.initUInt32(0);
  public qqstory_pgc.ErrorInfo result = new qqstory_pgc.ErrorInfo();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\pb\qqstory_pgc$RspSubscription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */