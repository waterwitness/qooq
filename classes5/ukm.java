import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.activity.GroupSearchActivity;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class ukm
  implements View.OnClickListener
{
  public ukm(GroupSearchActivity paramGroupSearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(-1)).intValue();
    GroupSearchActivity.a(this.a).a(GroupSearchActivity.a(this.a), paramView, i, 0L);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ukm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */