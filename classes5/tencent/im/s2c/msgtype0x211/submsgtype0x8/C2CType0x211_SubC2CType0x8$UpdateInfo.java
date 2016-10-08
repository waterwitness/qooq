package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class C2CType0x211_SubC2CType0x8$UpdateInfo
  extends MessageMicro
{
  public static final int MSG_USER_FIELD_NUMBER = 2;
  public static final int TYPE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "type", "msg_user" }, new Object[] { Integer.valueOf(1), null }, UpdateInfo.class);
  public C2CType0x211_SubC2CType0x8.UserProfile msg_user = new C2CType0x211_SubC2CType0x8.UserProfile();
  public final PBEnumField type = PBField.initEnum(1);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x211\submsgtype0x8\C2CType0x211_SubC2CType0x8$UpdateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */