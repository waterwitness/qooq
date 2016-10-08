import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.RecommendTroopAdapter;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;

public class vfu
  implements View.OnClickListener
{
  public vfu(RecommendTroopAdapter paramRecommendTroopAdapter, RecommendTroopItem paramRecommendTroopItem)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityRecommendTroopAdapter.b(this.jdField_a_of_type_ComTencentMobileqqTroopDataRecommendTroopItem.uin);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vfu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */