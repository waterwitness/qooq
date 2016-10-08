package tencent.im.mobileqq.mobroute;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class DomainIp$NameRspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "SubCmd_name_Rsp" }, new Object[] { null }, NameRspBody.class);
  public DomainIp.SubCmd_name_Rsp SubCmd_name_Rsp = new DomainIp.SubCmd_name_Rsp();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\mobileqq\mobroute\DomainIp$NameRspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */