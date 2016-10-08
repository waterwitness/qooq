package msg.uin_list;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UinList$UinListUploadRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_store_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_result = PBField.initInt32(0);
  public final PBUInt32Field silence_period = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "int32_result", "bytes_store_key", "silence_period" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, UinListUploadRsp.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\msg\uin_list\UinList$UinListUploadRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */