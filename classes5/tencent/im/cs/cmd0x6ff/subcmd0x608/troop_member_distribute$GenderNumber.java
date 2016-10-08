package tencent.im.cs.cmd0x6ff.subcmd0x608;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class troop_member_distribute$GenderNumber
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_man_number", "uint32_woman_number", "uint32_unknow_number" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GenderNumber.class);
  public final PBUInt32Field uint32_man_number = PBField.initUInt32(0);
  public final PBUInt32Field uint32_unknow_number = PBField.initUInt32(0);
  public final PBUInt32Field uint32_woman_number = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\cmd0x6ff\subcmd0x608\troop_member_distribute$GenderNumber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */