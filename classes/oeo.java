import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.GamePartyTipsBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.report.ReportCenter;

public class oeo
  implements View.OnClickListener
{
  public oeo(GamePartyTipsBar paramGamePartyTipsBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(GamePartyTipsBar.a(this.a), QQBrowserActivity.class);
    paramView.putExtra("url", String.format("http://openmobile.qq.com/TeamGame/index.html?_wv=1031&uin=%s&team_id=%s&srcSessionType=%d&srcSessionUin=%s", new Object[] { GamePartyTipsBar.a(this.a).getAccount(), GamePartyTipsBar.a(this.a), Integer.valueOf(GamePartyManager.a(GamePartyTipsBar.a(this.a).jdField_a_of_type_Int)), GamePartyTipsBar.a(this.a).jdField_a_of_type_JavaLangString }));
    GamePartyTipsBar.a(this.a).startActivity(paramView);
    ReportCenter.a().a(GamePartyTipsBar.a(this.a).a(), "", "", "2000", "2016", "0", false);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oeo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */