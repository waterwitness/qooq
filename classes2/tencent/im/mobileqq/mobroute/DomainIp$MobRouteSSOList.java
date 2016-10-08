package tencent.im.mobileqq.mobroute;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DomainIp$MobRouteSSOList
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_timeout", "vec_tcplist", "vec_httplist" }, new Object[] { Integer.valueOf(0), null, null }, MobRouteSSOList.class);
  public final PBUInt32Field uint32_timeout = PBField.initUInt32(0);
  public final PBRepeatMessageField vec_httplist = PBField.initRepeatMessage(DomainIp.MobRouteSSOListInfo.class);
  public final PBRepeatMessageField vec_tcplist = PBField.initRepeatMessage(DomainIp.MobRouteSSOListInfo.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\mobileqq\mobroute\DomainIp$MobRouteSSOList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */