package com.tencent.mobileqq.ac;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ArticleComment$GetPhotoCollectionInfoResponse
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField article_img_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField article_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField article_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField comment_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field enable_comment = PBField.initUInt32(0);
  public final PBRepeatMessageField item = PBField.initRepeatMessage(ArticleComment.PhotoItemInfo.class);
  public final PBUInt64Field puin = PBField.initUInt64(0L);
  public ArticleComment.RetInfo ret = new ArticleComment.RetInfo();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50, 56, 66 }, new String[] { "ret", "item", "article_url", "puin", "article_img_url", "article_title", "enable_comment", "comment_url" }, new Object[] { null, null, localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4 }, GetPhotoCollectionInfoResponse.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ac\ArticleComment$GetPhotoCollectionInfoResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */