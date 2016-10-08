package tencent.im.new_year_2014;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class Unisso$UniSsoServerReq
  extends MessageMicro
{
  public static final int COMM_FIELD_NUMBER = 1;
  public static final int REQDATA_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public Unisso.UniSsoServerReqComm comm = new Unisso.UniSsoServerReqComm();
  public final PBBytesField reqdata = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "comm", "reqdata" }, new Object[] { null, localByteStringMicro }, UniSsoServerReq.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\new_year_2014\Unisso$UniSsoServerReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */