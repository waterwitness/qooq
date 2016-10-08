import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class myx
  implements Comparator
{
  private myx(TroopTransferActivity paramTroopTransferActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(TroopTransferActivity.TroopMemberItem paramTroopMemberItem1, TroopTransferActivity.TroopMemberItem paramTroopMemberItem2)
  {
    return paramTroopMemberItem1.f.compareToIgnoreCase(paramTroopMemberItem2.f);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\myx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */