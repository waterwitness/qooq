package tencent.im.oidb.cmd0x614;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class Oidb_0x614$ReqBody
  extends MessageMicro
{
  public static final int MSG_DM_HEAD_FIELD_NUMBER = 1;
  public static final int MSG_MDN_REQ_BODY_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_dm_head", "msg_mdn_req_body" }, new Object[] { null, null }, ReqBody.class);
  public Oidb_0x614.DeviceManageHead msg_dm_head = new Oidb_0x614.DeviceManageHead();
  public Oidb_0x614.ReNameDeviceNameReqBody msg_mdn_req_body = new Oidb_0x614.ReNameDeviceNameReqBody();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x614\Oidb_0x614$ReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */