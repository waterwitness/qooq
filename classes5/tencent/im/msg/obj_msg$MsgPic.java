package tencent.im.msg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class obj_msg$MsgPic
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_original_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_small_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_local_pic_id = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "bytes_small_pic_url", "bytes_original_pic_url", "uint32_local_pic_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, MsgPic.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\msg\obj_msg$MsgPic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */