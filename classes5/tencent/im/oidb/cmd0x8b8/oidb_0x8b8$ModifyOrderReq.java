package tencent.im.oidb.cmd0x8b8;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8b8$ModifyOrderReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_pic_cnt", "rpt_uint32_pic_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ModifyOrderReq.class);
  public final PBRepeatField rpt_uint32_pic_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_pic_cnt = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x8b8\oidb_0x8b8$ModifyOrderReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */