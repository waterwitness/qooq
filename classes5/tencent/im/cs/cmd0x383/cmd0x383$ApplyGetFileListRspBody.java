package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x383$ApplyGetFileListRspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 56 }, new String[] { "uint32_file_count", "uint32_all_file_count", "bool_is_end", "rpt_msg_file_info_list", "uint32_folder_count", "rpt_msg_folder_info_list", "uint32_filter_code" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), null, Integer.valueOf(0), null, Integer.valueOf(0) }, ApplyGetFileListRspBody.class);
  public final PBBoolField bool_is_end = PBField.initBool(false);
  public final PBRepeatMessageField rpt_msg_file_info_list = PBField.initRepeatMessage(cmd0x383.ApplyGetFileListRspBody.FileInfo.class);
  public final PBRepeatMessageField rpt_msg_folder_info_list = PBField.initRepeatMessage(cmd0x383.ApplyGetFileListRspBody.FolderInfo.class);
  public final PBUInt32Field uint32_all_file_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_filter_code = PBField.initUInt32(0);
  public final PBUInt32Field uint32_folder_count = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\cmd0x383\cmd0x383$ApplyGetFileListRspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */