import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity.IShowExternalTroopDataChangedCallBack;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;

public class oke
  implements ShowExternalTroopListActivity.IShowExternalTroopDataChangedCallBack
{
  public oke(TroopActivity paramTroopActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((this.a.a.containsKey(paramString)) && (((Boolean)this.a.a.get(paramString)).booleanValue() != paramBoolean))
    {
      this.a.a.remove(paramString);
      return;
    }
    this.a.a.put(paramString, Boolean.valueOf(paramBoolean));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */