import android.database.DataSetObserver;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LebaListMgrActivity;
import com.tencent.mobileqq.adapter.LebaListMgrAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lrz
  extends DataSetObserver
{
  public lrz(LebaListMgrActivity paramLebaListMgrActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onChanged()
  {
    int j = 0;
    Object localObject = LebaListMgrActivity.a(this.a);
    if (LebaListMgrActivity.a(this.a).getCount() > 0)
    {
      i = 0;
      ((TextView)localObject).setVisibility(i);
      localObject = LebaListMgrActivity.a(this.a);
      if (LebaListMgrActivity.a(this.a).a() <= 0) {
        break label65;
      }
    }
    label65:
    for (int i = j;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      return;
      i = 8;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lrz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */