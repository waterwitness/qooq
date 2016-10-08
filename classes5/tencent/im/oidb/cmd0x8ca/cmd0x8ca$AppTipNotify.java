package tencent.im.oidb.cmd0x8ca;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x8ca$AppTipNotify
  extends MessageMicro
{
  public static final int BYTES_TEXT_FIELD_NUMBER = 2;
  public static final int UINT32_ACTION_FIELD_NUMBER = 1;
  public static final int UINT32_NEEDED_TIP_INFO_SEQ_FIELD_NUMBER = 4;
  public static final int UINT32_NOTIFY_SEQ_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_action = PBField.initUInt32(0);
  public final PBUInt32Field uint32_needed_tip_info_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_notify_seq = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint32_action", "bytes_text", "uint32_notify_seq", "uint32_needed_tip_info_seq" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, AppTipNotify.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x8ca\cmd0x8ca$AppTipNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */