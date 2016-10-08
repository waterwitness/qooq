import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.conditionsearch.SearchResultActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XListView;

public class qzp
  implements Handler.Callback
{
  public qzp(SearchResultActivity paramSearchResultActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      SearchResultActivity.a(this.a);
      continue;
      SearchResultActivity.b(this.a);
      continue;
      this.a.a.H();
      QQToast.a(this.a, 2131369008, 0).b(this.a.getTitleBarHeight());
      continue;
      this.a.a.H();
      continue;
      this.a.a.H();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */