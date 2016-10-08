import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.PoiMapActivity.TabView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class heq
  implements View.OnClickListener
{
  public heq(PoiMapActivity paramPoiMapActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof PoiMapActivity.TabView))
    {
      this.a.a(((PoiMapActivity.TabView)paramView).a);
      this.a.l();
      if (QLog.isDevelopLevel()) {
        QLog.i("PoiMapActivity", 4, "mTabClickListener" + ((PoiMapActivity.TabView)paramView).a);
      }
      if (PoiMapActivity.a(this.a)) {
        this.a.a("share_locate", "click_tab" + (((PoiMapActivity.TabView)paramView).a + 1), "", "", "", "");
      }
    }
    else
    {
      return;
    }
    this.a.a("share_locate", "click_tab" + (((PoiMapActivity.TabView)paramView).a + 1), this.a.f, this.a.e, "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\heq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */