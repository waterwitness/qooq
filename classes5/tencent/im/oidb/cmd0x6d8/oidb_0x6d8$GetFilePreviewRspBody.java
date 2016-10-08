package tencent.im.oidb.cmd0x6d8;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x6d8$GetFilePreviewRspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_download_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_reserved_field = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBUInt32Field int32_server_ip = PBField.initUInt32(0);
  public final PBUInt32Field int32_server_port = PBField.initUInt32(0);
  public final PBStringField str_client_wording = PBField.initString("");
  public final PBStringField str_cookie_val = PBField.initString("");
  public final PBStringField str_download_dns = PBField.initString("");
  public final PBStringField str_ret_msg = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50, 58, 66, 74 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording", "int32_server_ip", "int32_server_port", "str_download_dns", "bytes_download_url", "str_cookie_val", "bytes_reserved_field" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", localByteStringMicro1, "", localByteStringMicro2 }, GetFilePreviewRspBody.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x6d8\oidb_0x6d8$GetFilePreviewRspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */