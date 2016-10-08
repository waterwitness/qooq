import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.biz.pubaccount.imageCollection.ImageCollectionCommentActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class hvs
  implements View.OnClickListener
{
  public hvs(ImageCollectionCommentActivity paramImageCollectionCommentActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = ImageCollectionCommentActivity.a(this.a).getText().toString();
    if ((!TextUtils.isEmpty(paramView)) && (paramView.length() > 200))
    {
      if (ImageCollectionCommentActivity.a(this.a) != null) {
        ImageCollectionCommentActivity.a(this.a).cancel();
      }
      ImageCollectionCommentActivity.a(this.a, QQToast.a(this.a, 0, this.a.getString(2131372661), 0).b(this.a.getTitleBarHeight()));
      return;
    }
    ImageCollectionCommentActivity.a(this.a);
    ImageCollectionCommentActivity.b(this.a, false);
    ImageCollectionCommentActivity.a(this.a, -1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hvs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */