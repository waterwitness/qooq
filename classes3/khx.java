import SummaryCard.RespSearch;
import SummaryCard.SearchInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.contact.addcontact.ContactSearchFacade.ISearchListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class khx
  implements ContactSearchFacade.ISearchListener
{
  public khx(AddFriendActivity paramAddFriendActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, boolean paramBoolean, Object paramObject, int paramInt2, String paramString)
  {
    AddFriendActivity.a(this.a);
    if ((!paramBoolean) || (paramInt2 != 0) || (paramInt1 != 87) || (!(paramObject instanceof RespSearch))) {
      if (!TextUtils.isEmpty(paramString)) {
        this.a.a(paramString);
      }
    }
    do
    {
      return;
      this.a.a(2131368643);
      return;
      try
      {
        paramString = (RespSearch)paramObject;
        if ((paramString.vRecords != null) && (!paramString.vRecords.isEmpty())) {
          break;
        }
        this.a.a(2131368946);
        return;
      }
      catch (Exception paramString)
      {
        this.a.a(2131368643);
      }
    } while (!QLog.isColorLevel());
    QLog.d("IphoneTitleBarActivity", 2, "onSearchResult | searchType = " + paramInt1 + " | isSuccess = " + paramBoolean + " | rsCode = " + paramInt2 + " | data = " + paramObject, paramString);
    return;
    if (paramString.vRecords.size() == 1)
    {
      AddFriendActivity.a(this.a, (SearchInfo)paramString.vRecords.get(0), this.a.app.a(), paramString.vSecureSig, false, 0);
      return;
    }
    this.a.a(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\khx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */