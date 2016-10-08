package tencent.im.oidb.cmd0x9d3;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x9d3$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "str_feed_id", "str_comment_id", "uint32_fetch_old_count", "uint32_fetch_new_count" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  public final PBStringField str_comment_id = PBField.initString("");
  public final PBStringField str_feed_id = PBField.initString("");
  public final PBUInt32Field uint32_fetch_new_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_fetch_old_count = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x9d3\oidb_0x9d3$ReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */