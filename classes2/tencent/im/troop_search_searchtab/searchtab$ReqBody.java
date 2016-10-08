package tencent.im.troop_search_searchtab;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.troop_search_userinfo.userinfo.UserInfo;

public final class searchtab$ReqBody
  extends MessageMicro
{
  public static final int UINT32_LABEL_STYLE_FIELD_NUMBER = 2;
  public static final int USER_INFO_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "user_info", "uint32_label_style" }, new Object[] { null, Integer.valueOf(0) }, ReqBody.class);
  public final PBUInt32Field uint32_label_style = PBField.initUInt32(0);
  public userinfo.UserInfo user_info = new userinfo.UserInfo();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\troop_search_searchtab\searchtab$ReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */