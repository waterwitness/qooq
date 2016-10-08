import android.content.ClipData;
import android.content.ClipData.Item;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.widget.CustomImgView;

public class toi
  implements View.OnLongClickListener
{
  public toi(NearbyProfileEditPanel paramNearbyProfileEditPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.a.a.getChildCount() <= 1) {
      return true;
    }
    Object localObject = new ClipData.Item("");
    paramView.startDrag(new ClipData("", new String[] { "text/plain" }, (ClipData.Item)localObject), new tpd(this.a, paramView), paramView, 0);
    localObject = NearbyProfileEditPanel.a(this.a, (PicInfo)paramView.getTag(), null);
    ((CustomImgView)localObject).setVisibility(4);
    NearbyProfileEditPanel.a(this.a, (CustomImgView)localObject);
    int i = this.a.a.indexOfChild(paramView);
    if (i != -1)
    {
      this.a.a.removeView(paramView);
      this.a.a.addView(NearbyProfileEditPanel.a(this.a), i);
      return true;
    }
    paramView.setVisibility(4);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\toi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */