package tencent.im.group.group_label;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GroupLabel$GroupInfo
  extends MessageMicro
{
  public static final int INT32_RESULT_FIELD_NUMBER = 1;
  public static final int RPT_GROUP_LABEL_FIELD_NUMBER = 3;
  public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "int32_result", "uint64_group_code", "rpt_group_label" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null }, GroupInfo.class);
  public final PBInt32Field int32_result = PBField.initInt32(0);
  public final PBRepeatMessageField rpt_group_label = PBField.initRepeatMessage(GroupLabel.Label.class);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\group\group_label\GroupLabel$GroupInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */