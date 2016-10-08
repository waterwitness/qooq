package tencent.im.oidb.cmd0x43c;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class Oidb_0x43c$RequestAdd
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "card_info", "isMine" }, new Object[] { null, Boolean.valueOf(false) }, RequestAdd.class);
  public Oidb_0x43c.CardInfo card_info = new Oidb_0x43c.CardInfo();
  public final PBBoolField isMine = PBField.initBool(false);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x43c\Oidb_0x43c$RequestAdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */