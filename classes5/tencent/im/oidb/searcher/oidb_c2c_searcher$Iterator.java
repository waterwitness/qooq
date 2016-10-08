package tencent.im.oidb.searcher;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_c2c_searcher$Iterator
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "complete", "uin", "key" }, new Object[] { Boolean.valueOf(false), Long.valueOf(0L), null }, Iterator.class);
  public final PBBoolField complete = PBField.initBool(false);
  public oidb_c2c_searcher.MsgKey key = new oidb_c2c_searcher.MsgKey();
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\searcher\oidb_c2c_searcher$Iterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */