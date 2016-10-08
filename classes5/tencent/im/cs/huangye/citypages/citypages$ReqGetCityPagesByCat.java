package tencent.im.cs.huangye.citypages;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class citypages$ReqGetCityPagesByCat
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "city_id", "sub_cat_reqs" }, new Object[] { Integer.valueOf(0), null }, ReqGetCityPagesByCat.class);
  public final PBUInt32Field city_id = PBField.initUInt32(0);
  public final PBRepeatMessageField sub_cat_reqs = PBField.initRepeatMessage(citypages.SubCatReq.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\huangye\citypages\citypages$ReqGetCityPagesByCat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */