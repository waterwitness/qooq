import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopAdminList;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.List;
import java.util.Map;

public class vfz
  implements Runnable
{
  public vfz(TroopAdminList paramTroopAdminList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int j = this.a.a.size();
    int i = 0;
    while (i < j)
    {
      String str = (String)((Map)this.a.a.get(i)).get("uin");
      ((Map)this.a.a.get(i)).put("nick", ContactUtils.k(this.a.app, str));
      i += 1;
    }
    this.a.runOnUiThread(new vga(this));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vfz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */