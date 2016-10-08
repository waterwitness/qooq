package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x383$ApplyGetFileListRspBody$FolderInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "str_folder_path", "str_folder_name", "uint32_create_time", "uint64_create_uin" }, new Object[] { "", "", Integer.valueOf(0), Long.valueOf(0L) }, FolderInfo.class);
  public final PBStringField str_folder_name = PBField.initString("");
  public final PBStringField str_folder_path = PBField.initString("");
  public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_create_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\cmd0x383\cmd0x383$ApplyGetFileListRspBody$FolderInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */