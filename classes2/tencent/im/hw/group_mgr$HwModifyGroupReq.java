package tencent.im.hw;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_mgr$HwModifyGroupReq
  extends MessageMicro
{
  public static final int GID_FIELD_NUMBER = 1;
  public static final int INFO_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "gid", "info" }, new Object[] { Long.valueOf(0L), null }, HwModifyGroupReq.class);
  public final PBUInt64Field gid = PBField.initUInt64(0L);
  public group_mgr.GroupInfo info = new group_mgr.GroupInfo();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\hw\group_mgr$HwModifyGroupReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */