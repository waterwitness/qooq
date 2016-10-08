package tencent.im.oidb.cmd0x799;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x799$LongNickInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField StrNick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField StrTopicId = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field Type = PBField.initUInt32(0);
  public final PBUInt32Field dwCreateTime = PBField.initUInt32(0);
  public final PBUInt32Field dwDelTime = PBField.initUInt32(0);
  public final PBUInt32Field dwModiTime = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48 }, new String[] { "StrTopicId", "StrNick", "Type", "dwCreateTime", "dwModiTime", "dwDelTime" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, LongNickInfo.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x799\oidb_0x799$LongNickInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */