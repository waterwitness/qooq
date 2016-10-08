package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_struct$UserInfo
  extends MessageMicro
{
  public static final int EXT_FIELD_NUMBER = 5;
  public static final int HEAD_URL_FIELD_NUMBER = 3;
  public static final int IS_VIP_FIELD_NUMBER = 6;
  public static final int NICK_FIELD_NUMBER = 2;
  public static final int REMARK_FIELD_NUMBER = 4;
  public static final int SYMBOL_FIELD_NUMBER = 8;
  public static final int UID_FIELD_NUMBER = 1;
  public static final int UNION_ID_FIELD_NUMBER = 7;
  static final MessageMicro.FieldMap __fieldMap__;
  public qqstory_struct.UserInfoExt ext = new qqstory_struct.UserInfoExt();
  public final PBBytesField head_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field is_vip = PBField.initUInt32(0);
  public final PBBytesField nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField remark = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField symbol = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 58, 66 }, new String[] { "uid", "nick", "head_url", "remark", "ext", "is_vip", "union_id", "symbol" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, null, Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5 }, UserInfo.class);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\pb\qqstory_struct$UserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */