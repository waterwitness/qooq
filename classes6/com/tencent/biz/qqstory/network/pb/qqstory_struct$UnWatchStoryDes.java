package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_struct$UnWatchStoryDes
  extends MessageMicro
{
  public static final int DES_FIELD_NUMBER = 1;
  public static final int LATEST_VIDEO_LIST_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "des", "latest_video_list" }, new Object[] { null, null }, UnWatchStoryDes.class);
  public qqstory_struct.StoryDes des = new qqstory_struct.StoryDes();
  public final PBRepeatMessageField latest_video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoDes.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\pb\qqstory_struct$UnWatchStoryDes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */