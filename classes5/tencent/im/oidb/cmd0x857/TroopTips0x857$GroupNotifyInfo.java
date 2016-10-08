package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TroopTips0x857$GroupNotifyInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField opt_bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field opt_uint32_auto_pull_flag = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "opt_uint32_auto_pull_flag", "opt_bytes_feeds_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, GroupNotifyInfo.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x857\TroopTips0x857$GroupNotifyInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */