package tencent.im.oidb.cmd0x683;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x683$GodInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_chatsig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_declaration = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_nickname = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_praise_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_constellation = PBField.initString("");
  public final PBStringField str_distance = PBField.initString("");
  public final PBStringField str_vipinfo = PBField.initString("");
  public final PBUInt32Field uint32_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_charm = PBField.initUInt32(0);
  public final PBUInt32Field uint32_charm_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_chatflag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_chatup_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_marriage = PBField.initUInt32(0);
  public final PBUInt32Field uint32_praisecount = PBField.initUInt32(0);
  public final PBUInt32Field uint32_praiseflag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profession = PBField.initUInt32(0);
  public final PBUInt32Field uint32_recommend = PBField.initUInt32(0);
  public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50, 56, 66, 72, 82, 88, 96, 104, 112, 120, 128, 138, 144, 152, 162 }, new String[] { "uint64_tinyid", "bytes_nickname", "bytes_declaration", "uint32_age", "uint32_gender", "str_constellation", "uint32_profession", "str_distance", "uint32_marriage", "str_vipinfo", "uint32_recommend", "uint32_praiseflag", "uint32_praisecount", "uint64_uin", "uint32_chatflag", "uint32_chatup_count", "bytes_chatsig", "uint32_charm", "uint32_charm_level", "bytes_praise_cookies" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4 }, GodInfo.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x683\cmd0x683$GodInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */