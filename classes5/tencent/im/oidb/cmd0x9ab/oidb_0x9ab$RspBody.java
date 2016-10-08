package tencent.im.oidb.cmd0x9ab;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x9ab$RspBody
  extends MessageMicro
{
  public static final int ITEM_FIELD_NUMBER = 2;
  public static final int LIST_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "list", "item" }, new Object[] { null, null }, RspBody.class);
  public oidb_0x9ab.TabItem item = new oidb_0x9ab.TabItem();
  public oidb_0x9ab.GroupTabList list = new oidb_0x9ab.GroupTabList();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x9ab\oidb_0x9ab$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */