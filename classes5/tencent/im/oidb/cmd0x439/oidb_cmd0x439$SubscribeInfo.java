package tencent.im.oidb.cmd0x439;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x439$SubscribeInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subscribe_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField rpt_article_list = PBField.initRepeatMessage(oidb_cmd0x439.ArticleInfo.class);
  public final PBRepeatField rpt_uint64_likely_subscribe_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_friend_subscribed_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_has_more = PBField.initUInt32(0);
  public final PBUInt64Field uint64_subscribe_id = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 74, 82, 162 }, new String[] { "uint64_subscribe_id", "rpt_uint64_likely_subscribe_list", "uint32_has_more", "uint32_friend_subscribed_count", "bytes_reason", "bytes_subscribe_name", "rpt_article_list" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, null }, SubscribeInfo.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x439\oidb_cmd0x439$SubscribeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */