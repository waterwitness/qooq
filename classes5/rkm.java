import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout.EmoticonAdapter;
import com.tencent.mobileqq.emoticonview.EmoticonPanelViewBinder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rkm
  extends EmoticonLinearLayout.EmoticonAdapter
{
  private static final int e = 30;
  private int f;
  private int g;
  
  public rkm(EmoticonPanelViewBinder paramEmoticonPanelViewBinder, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.f = ((int)(paramEmoticonPanelViewBinder.a.getResources().getDisplayMetrics().density * 30.0F));
    this.g = paramInt;
  }
  
  public void a(int paramInt, RelativeLayout paramRelativeLayout, ViewGroup paramViewGroup)
  {
    paramViewGroup = (ImageView)paramRelativeLayout.findViewById(2131296394);
    paramViewGroup.setVisibility(0);
    paramViewGroup.setTag(Boolean.valueOf(false));
    EmoticonInfo localEmoticonInfo = a(paramInt);
    paramRelativeLayout.setTag(localEmoticonInfo);
    paramRelativeLayout = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
    float f1 = this.a.a.getResources().getDisplayMetrics().density;
    if (localEmoticonInfo != null)
    {
      if ((localEmoticonInfo.c == 1) || (localEmoticonInfo.c == 2) || (localEmoticonInfo.c == 7))
      {
        paramRelativeLayout.width = this.f;
        paramRelativeLayout.height = this.f;
      }
      if (localEmoticonInfo.c != -1)
      {
        paramRelativeLayout = localEmoticonInfo.a(this.a.a, f1);
        if (paramRelativeLayout != null)
        {
          paramViewGroup.setImageDrawable(paramRelativeLayout);
          paramViewGroup.setBackgroundDrawable(null);
        }
      }
      while (!"delete".equals(localEmoticonInfo.a)) {
        for (;;)
        {
          return;
          paramViewGroup.setVisibility(4);
        }
      }
      paramViewGroup.setImageResource(2130838429);
      return;
    }
    paramViewGroup.setImageDrawable(null);
    paramViewGroup.setVisibility(4);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rkm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */