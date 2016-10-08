package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class qqstory_service$ReqGetPOIMarkPack
  extends MessageMicro
{
  public static final int GPS_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "gps" }, new Object[] { null }, ReqGetPOIMarkPack.class);
  public qqstory_struct.GpsMsg gps = new qqstory_struct.GpsMsg();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\pb\qqstory_service$ReqGetPOIMarkPack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */