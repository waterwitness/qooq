import com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class pir
  extends TroopObserver
{
  public pir(TroopMemberListInnerFrame paramTroopMemberListInnerFrame)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString, boolean paramBoolean, List paramList)
  {
    ThreadManager.a(new pis(this, paramList), 5, null, true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pir.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */