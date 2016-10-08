package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.model.item.DoodleEmojiItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DoodleEmojiManager$DoodleEmojiDownloadEvent
  extends BaseEvent
{
  public static final int a = 0;
  public final long a;
  public final DoodleEmojiItem a;
  public final boolean a;
  public final int b;
  public final long b;
  
  public DoodleEmojiManager$DoodleEmojiDownloadEvent(DoodleEmojiItem paramDoodleEmojiItem, int paramInt, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemDoodleEmojiItem = paramDoodleEmojiItem;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\DoodleEmojiManager$DoodleEmojiDownloadEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */