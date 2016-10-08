import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ica
  extends ReadInJoyObserver
{
  public ica(ReadInJoyListViewGroup paramReadInJoyListViewGroup)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.a().runOnUiThread(new icb(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ica.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */