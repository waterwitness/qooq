package tencent.im.oidb.cmd0x8f8;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class oidb_0x8f8$SubCmd19SetAsyncMsgStateRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField rpt_bytes_fail_feeds_id = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatField rpt_bytes_success_feeds_id = PBField.initRepeat(PBBytesField.__repeatHelper__);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_bytes_success_feeds_id", "rpt_bytes_fail_feeds_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, SubCmd19SetAsyncMsgStateRsp.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x8f8\oidb_0x8f8$SubCmd19SetAsyncMsgStateRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */