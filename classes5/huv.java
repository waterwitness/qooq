import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.imageCollection.ImageCollectionActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class huv
  implements View.OnClickListener
{
  public huv(ImageCollectionActivity paramImageCollectionActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, AccountDetailActivity.class);
    paramView.putExtra("uin", ImageCollectionActivity.a(this.a));
    paramView.putExtra("account_type", 1);
    this.a.startActivity(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\huv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */