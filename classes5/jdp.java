import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.troop.feeds.TroopNewGuidePopWindow;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager.TroopNotify;
import com.tencent.mobileqq.utils.DisplayUtils;

public class jdp
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public jdp(TroopNewGuidePopWindow paramTroopNewGuidePopWindow)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGlobalLayout()
  {
    int i = this.a.c.getMeasuredWidth();
    i = (int)(this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredWidth() - i - DisplayUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 5.0F));
    this.a.b.setMaxWidth(i);
    this.a.b.setText(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.g);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jdp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */