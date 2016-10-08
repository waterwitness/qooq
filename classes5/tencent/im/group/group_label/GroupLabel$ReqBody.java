package tencent.im.group.group_label;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GroupLabel$ReqBody
  extends MessageMicro
{
  public static final int RPT_GROUP_CODE_FIELD_NUMBER = 4;
  public static final int SOURCE_ID_FIELD_NUMBER = 1;
  public static final int UINT32_LABEL_STYLE_FIELD_NUMBER = 5;
  public static final int UINT32_NUMBER_LABEL_FIELD_NUMBER = 3;
  public static final int UIN_INFO_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "source_id", "uin_info", "uint32_number_label", "rpt_group_code", "uint32_label_style" }, new Object[] { null, null, Integer.valueOf(5), Long.valueOf(0L), Integer.valueOf(0) }, ReqBody.class);
  public final PBRepeatField rpt_group_code = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public GroupLabel.SourceId source_id = new GroupLabel.SourceId();
  public GroupLabel.UinInfo uin_info = new GroupLabel.UinInfo();
  public final PBUInt32Field uint32_label_style = PBField.initUInt32(0);
  public final PBUInt32Field uint32_number_label = PBField.initUInt32(5);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\group\group_label\GroupLabel$ReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */