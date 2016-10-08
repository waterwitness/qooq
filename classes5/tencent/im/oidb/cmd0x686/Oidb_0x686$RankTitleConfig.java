package tencent.im.oidb.cmd0x686;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x686$RankTitleConfig
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_listtype", "str_first_title", "str_second_title" }, new Object[] { Integer.valueOf(0), "", "" }, RankTitleConfig.class);
  public final PBStringField str_first_title = PBField.initString("");
  public final PBStringField str_second_title = PBField.initString("");
  public final PBUInt32Field uint32_listtype = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x686\Oidb_0x686$RankTitleConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */