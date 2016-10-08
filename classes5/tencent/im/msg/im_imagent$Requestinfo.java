package tencent.im.msg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_imagent$Requestinfo
  extends MessageMicro
{
  public static final int REQ_FLAG_FIELD_NUMBER = 3;
  public static final int REQ_IP_FIELD_NUMBER = 1;
  public static final int REQ_PORT_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 16, 24 }, new String[] { "req_ip", "req_port", "req_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Requestinfo.class);
  public final PBUInt32Field req_flag = PBField.initUInt32(0);
  public final PBFixed32Field req_ip = PBField.initFixed32(0);
  public final PBUInt32Field req_port = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\msg\im_imagent$Requestinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */