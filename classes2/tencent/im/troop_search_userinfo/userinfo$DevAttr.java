package tencent.im.troop_search_userinfo;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class userinfo$DevAttr
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_imei", "str_imsi", "str_phonenum" }, new Object[] { "", "", "" }, DevAttr.class);
  public final PBStringField str_imei = PBField.initString("");
  public final PBStringField str_imsi = PBField.initString("");
  public final PBStringField str_phonenum = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\troop_search_userinfo\userinfo$DevAttr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */