package tencent.im.cs.huangye.citypages;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class citypages$RespGetCityPagesByBusinessId
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "header", "info" }, new Object[] { null, null }, RespGetCityPagesByBusinessId.class);
  public citypages.RespHeader header = new citypages.RespHeader();
  public citypages.CityPagesInfo info = new citypages.CityPagesInfo();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\huangye\citypages\citypages$RespGetCityPagesByBusinessId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */