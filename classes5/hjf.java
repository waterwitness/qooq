import android.content.Intent;
import com.tencent.biz.lebasearch.SearchActivity;
import com.tencent.biz.lebasearch.SearchProtocol.WordItem;
import com.tencent.biz.widgets.ActiveSearchTipsContainer.OnTipClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.Iterator;
import java.util.List;

public class hjf
  implements ActiveSearchTipsContainer.OnTipClickListener
{
  public hjf(SearchActivity paramSearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString)
  {
    SearchProtocol.WordItem localWordItem;
    if (paramString != null)
    {
      Iterator localIterator = this.a.a.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localWordItem = (SearchProtocol.WordItem)localIterator.next();
      } while (!paramString.equals(localWordItem.word));
    }
    for (;;)
    {
      if ((localWordItem != null) && (localWordItem.type == 2))
      {
        paramString = new Intent(this.a, QQBrowserActivity.class);
        paramString.putExtra("hide_operation_bar", true);
        paramString.putExtra("url", localWordItem.jumpUrl);
        paramString.putExtra("articalChannelId", 13);
        this.a.startActivity(paramString);
      }
      for (;;)
      {
        if (localWordItem != null)
        {
          this.a.y = localWordItem.id;
          ReportController.b(this.a.app, "CliOper", "", "", "0X8004AB4", "0X8004AB4", 0, 0, localWordItem.id, null, null, null);
          ReportController.b(null, "CliOper", "", "", "0X800516E", "0X800516E", 0, 0, "1", null, null, null);
        }
        return;
        this.a.i = 3;
        this.a.a(paramString);
        this.a.d(paramString);
        this.a.c(paramString);
        this.a.a(true);
      }
      localWordItem = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hjf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */