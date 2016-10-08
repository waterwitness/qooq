package tencent.im.cs.huangye.citypages;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class citypages$RespGetNeighborBusiness
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "header", "infos", "offset" }, new Object[] { null, null, Integer.valueOf(0) }, RespGetNeighborBusiness.class);
  public citypages.RespHeader header = new citypages.RespHeader();
  public final PBRepeatMessageField infos = PBField.initRepeatMessage(citypages.CityPagesInfo.class);
  public final PBUInt32Field offset = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\huangye\citypages\citypages$RespGetNeighborBusiness.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */