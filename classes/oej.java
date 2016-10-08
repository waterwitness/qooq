import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.DiscActiveTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class oej
  implements View.OnClickListener
{
  public oej(DiscActiveTipsBar paramDiscActiveTipsBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    DiscActiveTipsBar.a(this.a).a();
    ChatActivityUtils.a(DiscActiveTipsBar.a(this.a), DiscActiveTipsBar.a(this.a), DiscActiveTipsBar.a(this.a).jdField_a_of_type_Int, DiscActiveTipsBar.a(this.a).jdField_a_of_type_JavaLangString, true, true, null, null);
    ReportController.b(DiscActiveTipsBar.a(this.a), "CliOper", "", "", "0X8003F00", "0X8003F00", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */