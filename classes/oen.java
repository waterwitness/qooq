import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.FriendHotTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class oen
  implements View.OnClickListener
{
  public oen(FriendHotTipsBar paramFriendHotTipsBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    ReportController.b(FriendHotTipsBar.a(this.a), "CliOper", "", "", "Free_call", "Clk_free_call_tips", 0, 0, "", "", "", "");
    FriendHotTipsBar.c(FriendHotTipsBar.a(this.a), FriendHotTipsBar.a(this.a).jdField_a_of_type_JavaLangString);
    FriendHotTipsBar.a(this.a).a();
    paramView = null;
    String str = null;
    if (FriendHotTipsBar.a(this.a).jdField_a_of_type_Int == 1006) {
      str = FriendHotTipsBar.a(this.a).jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      ChatActivityUtils.a(FriendHotTipsBar.a(this.a), FriendHotTipsBar.a(this.a), FriendHotTipsBar.a(this.a).jdField_a_of_type_Int, paramView, FriendHotTipsBar.a(this.a).d, str, true, FriendHotTipsBar.a(this.a).b, true, true, null, "from_internal");
      ReportController.b(FriendHotTipsBar.a(this.a), "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "8", "", "", "");
      return;
      paramView = FriendHotTipsBar.a(this.a).jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */