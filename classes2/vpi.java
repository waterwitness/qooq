import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopCommentBrowser;

public class vpi
  implements View.OnClickListener
{
  public vpi(TroopCommentBrowser paramTroopCommentBrowser)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Long, 0, null, new vpj(this, paramView));
    ReportController.b(this.a.app, "dc00899", "Grp_talk", "", "detail", "like_suc", 0, 0, this.a.jdField_a_of_type_JavaLangString, "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */