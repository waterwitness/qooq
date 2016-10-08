package com.tencent.mobileqq.ac;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class ArticleComment$ReportReadPhotoCollectionResponse
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ret" }, new Object[] { null }, ReportReadPhotoCollectionResponse.class);
  public ArticleComment.RetInfo ret = new ArticleComment.RetInfo();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ac\ArticleComment$ReportReadPhotoCollectionResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */