import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.discussion.LinkShareActionSheetBuilder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oks
  extends BaseAdapter
{
  private oks(LinkShareActionSheetBuilder paramLinkShareActionSheetBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int getCount()
  {
    return 6;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = LayoutInflater.from(LinkShareActionSheetBuilder.a(this.a)).inflate(2130905063, null);
    }
    int j;
    int i;
    switch (paramInt)
    {
    case 4: 
    default: 
      j = 2130838111;
      i = 2131369520;
      paramInt = 2131369544;
    }
    for (;;)
    {
      paramView = (ImageView)paramViewGroup.findViewById(2131299820);
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131298113);
      paramView.setImageResource(j);
      localTextView.setText(i);
      if (AppSetting.j) {
        paramViewGroup.setContentDescription(LinkShareActionSheetBuilder.a(this.a).getString(paramInt));
      }
      return paramViewGroup;
      i = 2131369516;
      j = 2130838114;
      paramInt = 2131369542;
      continue;
      i = 2131369519;
      j = 2130838115;
      paramInt = 2131369543;
      continue;
      i = 2131369514;
      j = 2130838116;
      paramInt = 2131369541;
      continue;
      i = 2131369513;
      j = 2130838112;
      paramInt = 2131369540;
      continue;
      paramInt = 2131364457;
      i = 2131364457;
      j = 2130839367;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */