package tencent.im.groupvideo.s2c;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class gv_pstn_bill$GroupVideoS2CBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_s2c_notify_bill_req" }, new Object[] { null }, GroupVideoS2CBody.class);
  public gv_pstn_bill.S2CNotifyBillReq msg_s2c_notify_bill_req = new gv_pstn_bill.S2CNotifyBillReq();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\groupvideo\s2c\gv_pstn_bill$GroupVideoS2CBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */