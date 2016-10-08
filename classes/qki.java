import com.tencent.mobileqq.app.fms.FullMessageSearchManager;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult;
import com.tencent.mobileqq.app.fms.SearchListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qki
  implements SearchListener
{
  public qki(FullMessageSearchManager paramFullMessageSearchManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(FullMessageSearchResult paramFullMessageSearchResult)
  {
    FullMessageSearchManager.a(this.a);
    this.a.notifyObservers(paramFullMessageSearchResult);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qki.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */