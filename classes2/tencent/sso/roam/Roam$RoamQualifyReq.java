package tencent.sso.roam;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class Roam$RoamQualifyReq
  extends MessageMicro
{
  public static final int HEAD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "head" }, new Object[] { null }, RoamQualifyReq.class);
  public Roam.RoamReqHead head = new Roam.RoamReqHead();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\sso\roam\Roam$RoamQualifyReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */