package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class qqstory_struct$POIPosterData
  extends MessageMicro
{
  public static final int NAME_FIELD_NUMBER = 4;
  public static final int POSTER_JSON_LAYOUT_DESC_FIELD_NUMBER = 10;
  public static final int POSTER_NAME_FIELD_NUMBER = 2;
  public static final int POSTER_URL_FIELD_NUMBER = 3;
  public static final int THUMB_URL_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField poster_json_layout_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField poster_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField poster_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField thumb_url = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 82 }, new String[] { "thumb_url", "poster_name", "poster_url", "name", "poster_json_layout_desc" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5 }, POIPosterData.class);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\pb\qqstory_struct$POIPosterData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */