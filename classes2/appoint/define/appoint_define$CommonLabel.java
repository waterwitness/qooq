package appoint.define;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class appoint_define$CommonLabel
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_lable_msg_last = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_lable_msg_pre = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField rpt_interst_name = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatField rpt_interst_type = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_lable_id = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40 }, new String[] { "uint32_lable_id", "bytes_lable_msg_pre", "bytes_lable_msg_last", "rpt_interst_name", "rpt_interst_type" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0) }, CommonLabel.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\appoint\define\appoint_define$CommonLabel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */