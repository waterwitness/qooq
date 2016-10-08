package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x388$ExpRoamPicInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_pic_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_pkg_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_shop_flag = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_shop_flag", "uint32_pkg_id", "bytes_pic_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, ExpRoamPicInfo.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\cmd0x388\cmd0x388$ExpRoamPicInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */