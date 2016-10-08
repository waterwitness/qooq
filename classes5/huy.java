import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.imageCollection.ImageCollectionActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;

public class huy
  implements View.OnClickListener
{
  public huy(ImageCollectionActivity paramImageCollectionActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.a.isShowing()) {
      this.a.a.dismiss();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\huy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */