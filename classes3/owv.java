import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class owv
  implements View.OnClickListener
{
  public owv(RecentAdapter paramRecentAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    Object localObject1;
    RecentBaseData localRecentBaseData;
    do
    {
      do
      {
        int i;
        do
        {
          return;
          i = paramView.getId();
        } while ((i < 0) || (i >= this.a.getCount()));
        localObject1 = this.a.getItem(i);
      } while ((localObject1 == null) || (!(localObject1 instanceof RecentBaseData)));
      localRecentBaseData = (RecentBaseData)localObject1;
      Object localObject2 = null;
      localObject1 = localObject2;
      if ((paramView instanceof TextView))
      {
        paramView = ((TextView)paramView).getText();
        localObject1 = localObject2;
        if (paramView != null) {
          localObject1 = paramView.toString();
        }
      }
    } while (TextUtils.isEmpty((CharSequence)localObject1));
    this.a.a(localRecentBaseData, (String)localObject1, "1");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\owv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */