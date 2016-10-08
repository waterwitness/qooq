package tencent.im.cs.huangye.citypages;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class citypages$RespGetCityList
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "header", "sig", "cities" }, new Object[] { null, "", null }, RespGetCityList.class);
  public final PBRepeatMessageField cities = PBField.initRepeatMessage(citypages.CityInfo.class);
  public citypages.RespHeader header = new citypages.RespHeader();
  public final PBStringField sig = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\huangye\citypages\citypages$RespGetCityList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */