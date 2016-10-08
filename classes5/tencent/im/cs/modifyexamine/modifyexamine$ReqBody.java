package tencent.im.cs.modifyexamine;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class modifyexamine$ReqBody
  extends MessageMicro
{
  public static final int SKEY_FIELD_NUMBER = 2;
  public static final int UINT64_GC_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_gc", "skey" }, new Object[] { Long.valueOf(0L), "" }, ReqBody.class);
  public final PBStringField skey = PBField.initString("");
  public final PBUInt64Field uint64_gc = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\modifyexamine\modifyexamine$ReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */