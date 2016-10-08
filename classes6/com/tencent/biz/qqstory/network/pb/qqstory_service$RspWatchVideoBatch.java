package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_service$RspWatchVideoBatch
  extends MessageMicro
{
  public static final int RESULT_FIELD_NUMBER = 1;
  public static final int SUCC_VIDEO_LIST_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "succ_video_list" }, new Object[] { null, null }, RspWatchVideoBatch.class);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBRepeatMessageField succ_video_list = PBField.initRepeatMessage(qqstory_service.VideoItem.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\pb\qqstory_service$RspWatchVideoBatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */