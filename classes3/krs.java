import com.tencent.mobileqq.activity.Call;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class krs
  extends TroopObserver
{
  public krs(Call paramCall)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean1, ArrayList paramArrayList, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2) && (paramArrayList != null) && (paramArrayList.size() > 0) && ((TroopMemberCardInfo)paramArrayList.get(0) != null)) {
      this.a.i();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\krs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */