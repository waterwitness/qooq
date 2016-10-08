package tencent.im.group.nearbybanner;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearbybanner$Banners
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_banner_info", "uint32_slide_time" }, new Object[] { null, Integer.valueOf(0) }, Banners.class);
  public final PBRepeatMessageField rpt_banner_info = PBField.initRepeatMessage(nearbybanner.BannerInfo.class);
  public final PBUInt32Field uint32_slide_time = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\group\nearbybanner\nearbybanner$Banners.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */