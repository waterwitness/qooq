package tencent.im.hw;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class group_mgr$HwQueryCardRsp
  extends MessageMicro
{
  public static final int CARD_INFO_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "card_info" }, new Object[] { null }, HwQueryCardRsp.class);
  public group_mgr.CardInfo card_info = new group_mgr.CardInfo();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\hw\group_mgr$HwQueryCardRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */