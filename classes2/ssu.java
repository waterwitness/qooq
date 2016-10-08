import com.tencent.mobileqq.data.MessageForGrayTips.HightlightItem;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class ssu
  implements Comparator
{
  public ssu(MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(MessageForGrayTips.HightlightItem paramHightlightItem1, MessageForGrayTips.HightlightItem paramHightlightItem2)
  {
    return paramHightlightItem1.start - paramHightlightItem2.start;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ssu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */