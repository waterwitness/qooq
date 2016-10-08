package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$ReqComment
  extends MessageMicro
{
  public static final int AUTHOR_UNION_ID_FIELD_NUMBER = 8;
  public static final int COMMENT_CONTENT_FIELD_NUMBER = 6;
  public static final int COVER_FIELD_NUMBER = 2;
  public static final int CREATETIME_FIELD_NUMBER = 5;
  public static final int SUMMARY_FIELD_NUMBER = 4;
  public static final int TITLE_FIELD_NUMBER = 3;
  public static final int VID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField author_union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField comment_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField cover = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field createTime = PBField.initUInt64(0L);
  public final PBBytesField summary = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 66 }, new String[] { "vid", "cover", "title", "summary", "createTime", "comment_content", "author_union_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Long.valueOf(0L), localByteStringMicro5, localByteStringMicro6 }, ReqComment.class);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\pb\qqstory_service$ReqComment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */