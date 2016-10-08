package tencent.im.cs.cmd0x355;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Stt$TransGroupPttReq
  extends MessageMicro
{
  public static final int STR_FILE_PATH_FIELD_NUMBER = 9;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 64, 72 }, new String[] { "uint64_sessionid", "uint64_sender_uin", "uint64_group_uin", "uint32_fileid", "str_filemd5", "uint32_ptt_time", "uint32_filesize", "uint32_ptt_format", "str_file_path" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, TransGroupPttReq.class);
  public final PBStringField str_file_path = PBField.initString("");
  public final PBStringField str_filemd5 = PBField.initString("");
  public final PBUInt32Field uint32_fileid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_filesize = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ptt_format = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ptt_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\cmd0x355\Stt$TransGroupPttReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */