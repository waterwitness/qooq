package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class qqshop$SQQSHPNewUserRecmd
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "recmdflag", "recmdurl" }, new Object[] { Integer.valueOf(0), "" }, SQQSHPNewUserRecmd.class);
  public final PBInt32Field recmdflag = PBField.initInt32(0);
  public final PBStringField recmdurl = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\qqshop\qqshop$SQQSHPNewUserRecmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */