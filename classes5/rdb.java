import android.view.View;
import android.widget.Adapter;
import appoint.define.appoint_define.LocaleInfo;
import com.tencent.mobileqq.dating.DatingDestinationActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class rdb
  implements AdapterView.OnItemClickListener
{
  public rdb(DatingDestinationActivity paramDatingDestinationActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramAdapterView.a().getItem(paramInt);
    if (paramAdapterView != null)
    {
      if ((paramAdapterView instanceof String)) {
        this.a.a((String)paramAdapterView);
      }
    }
    else {
      return;
    }
    this.a.a.a("CliOper", "", "", "0X8004F32", "0X8004F32", 0, 0, "", "", "", "");
    this.a.a((appoint_define.LocaleInfo)paramAdapterView);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rdb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */