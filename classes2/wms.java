import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.musicpendant.MusicPendantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.MusicPendantView;

public class wms
  implements View.OnClickListener
{
  public wms(MusicPendantView paramMusicPendantView, String paramString, Card paramCard)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
    paramView.getContext().startActivity(localIntent);
    ReportController.b(MusicPendantManager.a().a(), "dc00899", "NOW", "", "qq_zlk", "logo_click", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */