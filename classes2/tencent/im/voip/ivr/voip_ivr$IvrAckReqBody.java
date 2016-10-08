package tencent.im.voip.ivr;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class voip_ivr$IvrAckReqBody
  extends MessageMicro
{
  public static final int SEQ_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "seq" }, new Object[] { Integer.valueOf(0) }, IvrAckReqBody.class);
  public final PBUInt32Field seq = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\voip\ivr\voip_ivr$IvrAckReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */