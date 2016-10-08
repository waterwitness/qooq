package tencent.im.new_year_2014;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class Unisso$UniSsoServerRsp
  extends MessageMicro
{
  public static final int COMM_FIELD_NUMBER = 3;
  public static final int ERRMSG_FIELD_NUMBER = 2;
  public static final int RET_FIELD_NUMBER = 1;
  public static final int RSPDATA_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__;
  public Unisso.UniSsoServerRspComm comm = new Unisso.UniSsoServerRspComm();
  public final PBStringField errmsg = PBField.initString("");
  public final PBInt64Field ret = PBField.initInt64(0L);
  public final PBBytesField rspdata = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "ret", "errmsg", "comm", "rspdata" }, new Object[] { Long.valueOf(0L), "", null, localByteStringMicro }, UniSsoServerRsp.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\new_year_2014\Unisso$UniSsoServerRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */