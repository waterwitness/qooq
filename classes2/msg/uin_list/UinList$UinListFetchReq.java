package msg.uin_list;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class UinList$UinListFetchReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_store_key = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_store_key" }, new Object[] { localByteStringMicro }, UinListFetchReq.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\msg\uin_list\UinList$UinListFetchReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */