package tencent.im.troop_search_popclassifc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class popclassifc$PopCard
  extends MessageMicro
{
  public static final int RPT_POP_ITEMS_FIELD_NUMBER = 2;
  public static final int TITLE_BAR_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "title_bar", "rpt_pop_items" }, new Object[] { null, null }, PopCard.class);
  public final PBRepeatMessageField rpt_pop_items = PBField.initRepeatMessage(popclassifc.PopItem.class);
  public popclassifc.TitleBar title_bar = new popclassifc.TitleBar();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\troop_search_popclassifc\popclassifc$PopCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */