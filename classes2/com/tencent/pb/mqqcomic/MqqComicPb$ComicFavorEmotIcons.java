package com.tencent.pb.mqqcomic;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MqqComicPb$ComicFavorEmotIcons
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "md5", "info" }, new Object[] { "", "" }, ComicFavorEmotIcons.class);
  public final PBStringField info = PBField.initString("");
  public final PBStringField md5 = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\mqqcomic\MqqComicPb$ComicFavorEmotIcons.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */