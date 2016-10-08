package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class qqstory_service$RspGetPOIMarkPack
  extends MessageMicro
{
  public static final int CITY_FIELD_NUMBER = 5;
  public static final int COUNTRY_FIELD_NUMBER = 3;
  public static final int POI_MARK_PACK_FIELD_NUMBER = 2;
  public static final int PROVINCE_FIELD_NUMBER = 4;
  public static final int RESULT_FIELD_NUMBER = 1;
  public static final int STREET_FIELD_NUMBER = 6;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField country = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.EmoticonPack poi_mark_pack = new qqstory_struct.EmoticonPack();
  public final PBBytesField province = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBBytesField street = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "result", "poi_mark_pack", "country", "province", "city", "street" }, new Object[] { null, null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, RspGetPOIMarkPack.class);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\pb\qqstory_service$RspGetPOIMarkPack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */