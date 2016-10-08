import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.tips.ComicTipsBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.comic.VipComicJumpActivity;
import cooperation.comic.VipComicReportUtils;
import org.json.JSONObject;

public class oeh
  implements View.OnClickListener
{
  public oeh(ComicTipsBar paramComicTipsBar, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (ComicTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsComicTipsBar)) {
      paramView = new JSONObject();
    }
    try
    {
      paramView.put("from", "19");
      Intent localIntent = new Intent(ComicTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsComicTipsBar), VipComicJumpActivity.class);
      localIntent.putExtra("options", paramView.toString());
      ComicTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsComicTipsBar).startActivity(localIntent);
      for (;;)
      {
        this.jdField_a_of_type_AndroidViewView.postDelayed(new oei(this), 2500L);
        if (!ComicTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsComicTipsBar)) {
          break;
        }
        VipComicReportUtils.a(ComicTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsComicTipsBar), "3009", "2", "40039", ComicTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsComicTipsBar), new String[0]);
        return;
        ComicTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsComicTipsBar).finish();
      }
      VipComicReportUtils.a(ComicTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsComicTipsBar), "3006", "2", "40025", ComicTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsComicTipsBar), new String[] { "2" });
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oeh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */