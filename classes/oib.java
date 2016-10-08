import android.os.Handler;
import com.tencent.mobileqq.activity.contact.addcontact.ContactSearchFacade.ISearchListener;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResult;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class oib
  implements ContactSearchFacade.ISearchListener
{
  public oib(SearchBaseFragment paramSearchBaseFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, boolean paramBoolean, Object paramObject, int paramInt2, String paramString)
  {
    int i = 3;
    this.a.i();
    if (paramBoolean)
    {
      if ((paramObject != null) && ((paramObject instanceof ArrayList)))
      {
        paramObject = (ArrayList)paramObject;
        if (((ArrayList)paramObject).size() != 0) {
          break label94;
        }
        if (this.a.a != null)
        {
          paramObject = this.a.a;
          if (!this.a.b) {
            break label89;
          }
          paramInt1 = 3;
          ((Handler)paramObject).sendEmptyMessage(paramInt1);
        }
        if (QLog.isColorLevel()) {
          QLog.d(SearchBaseFragment.a(), 2, "error! SearchResult is null!");
        }
      }
      for (;;)
      {
        return;
        label89:
        paramInt1 = 2;
        break;
        label94:
        if (((ArrayList)paramObject).size() > 0) {}
        try
        {
          paramString = (SearchResult)((ArrayList)paramObject).get(0);
          if ((this.a.a((ArrayList)paramObject)) && (this.a.a != null))
          {
            this.a.a.sendEmptyMessage(0);
            return;
          }
        }
        catch (Exception paramObject)
        {
          if (QLog.isColorLevel()) {
            QLog.d(SearchBaseFragment.a(), 2, "", (Throwable)paramObject);
          }
          paramObject = this.a.a;
          if (!this.a.b) {}
        }
      }
      for (paramInt1 = i;; paramInt1 = 2)
      {
        ((Handler)paramObject).sendEmptyMessage(paramInt1);
        return;
      }
    }
    this.a.a(paramInt1, paramObject, paramInt2, paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */