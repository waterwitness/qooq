package tencent.im.oidb.cmd0x406;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x406$GroupFeeMemberListQuery
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "string_project_id", "uint32_member_type", "uint32_page_index", "uint32_page_size" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GroupFeeMemberListQuery.class);
  public final PBStringField string_project_id = PBField.initString("");
  public final PBUInt32Field uint32_member_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_page_index = PBField.initUInt32(0);
  public final PBUInt32Field uint32_page_size = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x406\cmd0x406$GroupFeeMemberListQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */