package tencent.im.oidb.inner.cmdGroupAdGetAdInfo;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GetTroopAioTopAD$ExtAdInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_word", "str_ui_url", "str_jmp_url" }, new Object[] { "", "", "" }, ExtAdInfo.class);
  public final PBStringField str_jmp_url = PBField.initString("");
  public final PBStringField str_ui_url = PBField.initString("");
  public final PBStringField str_word = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\inner\cmdGroupAdGetAdInfo\GetTroopAioTopAD$ExtAdInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */