package pttcenterservice;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PttCenter$ServerListInfo
  extends MessageMicro
{
  public static final int UINT32_UP_IP_FIELD_NUMBER = 1;
  public static final int UINT32_UP_PORT_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_up_ip", "uint32_up_port" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ServerListInfo.class);
  public final PBUInt32Field uint32_up_ip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_up_port = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\pttcenterservice\PttCenter$ServerListInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */