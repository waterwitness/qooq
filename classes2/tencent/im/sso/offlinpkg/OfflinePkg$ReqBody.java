package tencent.im.sso.offlinpkg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class OfflinePkg$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_network = PBField.initInt32(0);
  public final PBRepeatMessageField st_bid_pkg = PBField.initRepeatMessage(OfflinePkg.BidPkg.class);
  public final PBBytesField str_from = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_osbrand = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_osmodel = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_osrelease = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_osver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_qver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_platform = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 72, 82 }, new String[] { "uint32_cmd", "uint32_platform", "st_bid_pkg", "str_qver", "str_osver", "str_osrelease", "str_osbrand", "str_osmodel", "int32_network", "str_from" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), localByteStringMicro6 }, ReqBody.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\sso\offlinpkg\OfflinePkg$ReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */