package tencent.im.oidb.olympic;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class OlympicTorchSvc$SceneWording
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "str_line1", "str_line2", "str_link_word", "str_link_url" }, new Object[] { "", "", "", "" }, SceneWording.class);
  public final PBStringField str_line1 = PBField.initString("");
  public final PBStringField str_line2 = PBField.initString("");
  public final PBStringField str_link_url = PBField.initString("");
  public final PBStringField str_link_word = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\olympic\OlympicTorchSvc$SceneWording.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */