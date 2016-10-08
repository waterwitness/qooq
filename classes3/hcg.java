import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.widget.ShareActionSheetBuilder;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.app.BaseActivity;

public class hcg
  extends BaseAdapter
{
  private hcg(ShareActionSheetBuilder paramShareActionSheetBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int getCount()
  {
    return 5;
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
      paramViewGroup = LayoutInflater.from(ShareActionSheetBuilder.a(this.a)).inflate(2130905063, null);
    }
    int i;
    int j;
    switch (paramInt)
    {
    default: 
      i = 2131369520;
      j = 2130838111;
      paramInt = 2131369544;
    }
    for (;;)
    {
      paramView = (ImageView)paramViewGroup.findViewById(2131299820);
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131298113);
      paramView.setImageResource(j);
      localTextView.setText(i);
      if (AppSetting.j) {
        paramViewGroup.setContentDescription(ShareActionSheetBuilder.a(this.a).getString(paramInt));
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
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hcg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */