import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.lebasearch.SearchResultAdapter;
import com.tencent.biz.lebasearch.SearchResultAdapter.OnResultItemClickedListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hjy
  implements View.OnClickListener
{
  public hjy(SearchResultAdapter paramSearchResultAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && (paramView.getTag() != null))
    {
      SearchResultAdapter.a(this.a, (hjz)paramView.getTag());
      this.a.a.a((hjz)paramView.getTag());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hjy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */