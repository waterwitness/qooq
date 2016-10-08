package tencent.im.oidb.oidb_0x8c9;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8c9$GroupAppUnreadInfo
  extends MessageMicro
{
  public static final int OPT_INT32_GROUP_ALBUM_PASSIVE_CNT_FIELD_NUMBER = 3;
  public static final int OPT_INT32_GROUP_UNREAD_NUM_FIELD_NUMBER = 2;
  public static final int OPT_UINT64_APPID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "opt_uint64_appid", "opt_int32_group_unread_num", "opt_int32_group_album_passive_cnt" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, GroupAppUnreadInfo.class);
  public final PBInt32Field opt_int32_group_album_passive_cnt = PBField.initInt32(0);
  public final PBInt32Field opt_int32_group_unread_num = PBField.initInt32(0);
  public final PBUInt64Field opt_uint64_appid = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\oidb_0x8c9\oidb_0x8c9$GroupAppUnreadInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */