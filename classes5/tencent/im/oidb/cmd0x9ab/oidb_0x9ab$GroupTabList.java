package tencent.im.oidb.cmd0x9ab;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x9ab$GroupTabList
  extends MessageMicro
{
  public static final int RPT_TAB_LIST_FIELD_NUMBER = 2;
  public static final int UINT32_CURR_TAB_ID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_curr_tab_id", "rpt_tab_list" }, new Object[] { Integer.valueOf(0), null }, GroupTabList.class);
  public final PBRepeatMessageField rpt_tab_list = PBField.initRepeatMessage(oidb_0x9ab.TabItem.class);
  public final PBUInt32Field uint32_curr_tab_id = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x9ab\oidb_0x9ab$GroupTabList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */