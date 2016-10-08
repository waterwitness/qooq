package tencent.im.troop_view;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import tencent.im.troop_search_popclassifc.popclassifc.RspBody;
import tencent.im.troop_search_searchtab.searchtab.RspBody;

public final class troopviewInfo$RspBody
  extends MessageMicro
{
  public static final int POPRSB_FIELD_NUMBER = 1;
  public static final int SEARCHRSB_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "popRsb", "searchRsb" }, new Object[] { null, null }, RspBody.class);
  public popclassifc.RspBody popRsb = new popclassifc.RspBody();
  public searchtab.RspBody searchRsb = new searchtab.RspBody();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\troop_view\troopviewInfo$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */