package tencent.im.msg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_msg_body$NearByMessageType
  extends MessageMicro
{
  public static final int ETypeClearingImg = 2;
  public static final int ETypeClearingText = 1;
  public static final int ETypeDefault = 0;
  public static final int ETypeIdentify = 1;
  public static final int ETypeNormal = 0;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_type", "uint32_identify_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, NearByMessageType.class);
  public final PBUInt32Field uint32_identify_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\msg\im_msg_body$NearByMessageType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */