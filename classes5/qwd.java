import android.view.View;
import com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class qwd
  implements AdapterView.OnItemClickListener
{
  public qwd(CardPicGalleryActivity paramCardPicGalleryActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!this.a.isFinishing())
    {
      this.a.overridePendingTransition(0, 2130968823);
      this.a.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qwd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */