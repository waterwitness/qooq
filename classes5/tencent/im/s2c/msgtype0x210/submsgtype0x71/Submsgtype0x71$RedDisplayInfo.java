package tencent.im.s2c.msgtype0x210.submsgtype0x71;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Submsgtype0x71$RedDisplayInfo
  extends MessageMicro
{
  public static final int MSG_TAB_DISPLAY_INFO_FIELD_NUMBER = 2;
  public static final int RPT_MSG_RED_TYPE_INFO_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_msg_red_type_info", "msg_tab_display_info" }, new Object[] { null, null }, RedDisplayInfo.class);
  public Submsgtype0x71.RedTypeInfo msg_tab_display_info = new Submsgtype0x71.RedTypeInfo();
  public final PBRepeatMessageField rpt_msg_red_type_info = PBField.initRepeatMessage(Submsgtype0x71.RedTypeInfo.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x71\Submsgtype0x71$RedDisplayInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */