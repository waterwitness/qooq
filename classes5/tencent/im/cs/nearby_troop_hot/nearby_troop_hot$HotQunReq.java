package tencent.im.cs.nearby_troop_hot;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearby_troop_hot$HotQunReq
  extends MessageMicro
{
  public static final int GPS_FIELD_NUMBER = 4;
  public static final int PAGE_NUM_FIELD_NUMBER = 1;
  public static final int PAGE_SIZE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 34 }, new String[] { "page_num", "page_size", "gps" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, HotQunReq.class);
  public nearby_troop_hot.GPS gps = new nearby_troop_hot.GPS();
  public final PBUInt32Field page_num = PBField.initUInt32(0);
  public final PBUInt32Field page_size = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\nearby_troop_hot\nearby_troop_hot$HotQunReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */