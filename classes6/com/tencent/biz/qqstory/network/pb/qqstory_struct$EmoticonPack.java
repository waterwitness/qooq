package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_struct$EmoticonPack
  extends MessageMicro
{
  public static final int DOWNLOAD_ICON_FIELD_NUMBER = 8;
  public static final int DOWNLOAD_URL_FIELD_NUMBER = 4;
  public static final int ICON_FIELD_NUMBER = 2;
  public static final int MD5_FIELD_NUMBER = 6;
  public static final int NAME_FIELD_NUMBER = 3;
  public static final int PACK_ID_FIELD_NUMBER = 1;
  public static final int TYPE_FIELD_NUMBER = 5;
  public static final int VERSION_FIELD_NUMBER = 7;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField download_icon = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField download_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField icon = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field pack_id = PBField.initUInt32(0);
  public final PBEnumField type = PBField.initEnum(1);
  public final PBUInt32Field version = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 56, 66 }, new String[] { "pack_id", "icon", "name", "download_url", "type", "md5", "version", "download_icon" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(1), localByteStringMicro4, Integer.valueOf(0), localByteStringMicro5 }, EmoticonPack.class);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\pb\qqstory_struct$EmoticonPack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */