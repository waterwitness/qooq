package tencent.im.cs.huangye.citypages;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class citypages$RespGetCityPagesByCat
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "header", "sub_cat_infos", "busi_infos" }, new Object[] { null, null, null }, RespGetCityPagesByCat.class);
  public final PBRepeatMessageField busi_infos = PBField.initRepeatMessage(citypages.CityPagesInfo.class);
  public citypages.RespHeader header = new citypages.RespHeader();
  public final PBRepeatMessageField sub_cat_infos = PBField.initRepeatMessage(citypages.SubCatInfo.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\huangye\citypages\citypages$RespGetCityPagesByCat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */