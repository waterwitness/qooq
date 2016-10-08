package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class qqstory_service$RspGetUserVideoInfo
  extends MessageMicro
{
  public static final int RESULT_FIELD_NUMBER = 1;
  public static final int VIDEO_INFO_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "video_info" }, new Object[] { null, null }, RspGetUserVideoInfo.class);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public qqstory_struct.StoryVideoDes video_info = new qqstory_struct.StoryVideoDes();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\pb\qqstory_service$RspGetUserVideoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */