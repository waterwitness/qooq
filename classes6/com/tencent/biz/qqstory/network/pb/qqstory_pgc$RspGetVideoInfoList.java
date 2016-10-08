package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_pgc$RspGetVideoInfoList
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "video_info_list" }, new Object[] { null, null }, RspGetVideoInfoList.class);
  public qqstory_pgc.ErrorInfo result = new qqstory_pgc.ErrorInfo();
  public final PBRepeatMessageField video_info_list = PBField.initRepeatMessage(qqstory_pgc.VideoInfo.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\pb\qqstory_pgc$RspGetVideoInfoList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */