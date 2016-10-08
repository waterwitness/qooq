import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.Utils;
import java.util.List;

public class maq
  extends ShieldListObserver
{
  public maq(ProfileCardMoreActivity paramProfileCardMoreActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, List paramList)
  {
    if (this.a.a == null) {
      return;
    }
    String str = this.a.a.a;
    if (ProfileActivity.AllInOne.h(this.a.a)) {
      str = ProfileCardMoreActivity.a(this.a);
    }
    for (;;)
    {
      if (paramList == null) {}
      int k;
      for (int i = 0;; i = paramList.size())
      {
        int j = 0;
        k = 0;
        while ((k == 0) && (j < i))
        {
          if (Utils.a(String.valueOf(paramList.get(j)), str)) {
            k = 1;
          }
          j += 1;
        }
      }
      if (k == 0) {
        break;
      }
      this.a.a(paramBoolean, false);
      return;
    }
  }
  
  protected void b(boolean paramBoolean, List paramList)
  {
    int k = 0;
    if (this.a.a == null) {
      return;
    }
    String str = this.a.a.a;
    if (ProfileActivity.AllInOne.h(this.a.a)) {
      str = ProfileCardMoreActivity.a(this.a);
    }
    for (;;)
    {
      if (paramList == null) {}
      for (int i = 0;; i = paramList.size())
      {
        int j = 0;
        while ((k == 0) && (j < i))
        {
          if (Utils.a(String.valueOf(paramList.get(j)), str)) {
            k = 1;
          }
          j += 1;
        }
      }
      if (k == 0) {
        break;
      }
      this.a.a(paramBoolean, true);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\maq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */