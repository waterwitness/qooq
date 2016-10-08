package tencent.im.oidb.cmd0x9c0;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x9c0$NearbyUser
  extends MessageMicro
{
  public static final int BYTES_NICK_FIELD_NUMBER = 4;
  public static final int BYTES_REMARK_FIELD_NUMBER = 3;
  public static final int UINT32_IS_FRD_FIELD_NUMBER = 2;
  public static final int UINT64_NEARBY_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_remark = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_is_frd = PBField.initUInt32(0);
  public final PBUInt64Field uint64_nearby_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint64_nearby_uin", "uint32_is_frd", "bytes_remark", "bytes_nick" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, NearbyUser.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x9c0\cmd0x9c0$NearbyUser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */