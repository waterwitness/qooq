package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class qqstory_pgc$RspGetStory
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "story_info" }, new Object[] { null, null }, RspGetStory.class);
  public qqstory_pgc.ErrorInfo result = new qqstory_pgc.ErrorInfo();
  public qqstory_pgc.StoryInfo story_info = new qqstory_pgc.StoryInfo();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\pb\qqstory_pgc$RspGetStory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */