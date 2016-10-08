import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity.ItemViewHolder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class uiv
  implements View.OnClickListener
{
  private static final long jdField_a_of_type_Long = 200L;
  private long b;
  
  public uiv(StatusHistoryActivity paramStatusHistoryActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.e(this.a))
    {
      QQToast.a(this.a, this.a.getString(2131367256), 0).b(this.a.getTitleBarHeight());
      return;
    }
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.b) < 200L)
    {
      QQToast.a(this.a, this.a.getString(2131372027), 0).b(this.a.getTitleBarHeight());
      return;
    }
    this.b = l;
    paramView = (StatusHistoryActivity.ItemViewHolder)paramView.getTag();
    label533:
    for (;;)
    {
      try
      {
        if (1 == paramView.jdField_a_of_type_Int)
        {
          paramView.jdField_a_of_type_Int = 0;
          paramView.jdField_b_of_type_JavaUtilList.clear();
          if (paramView.jdField_a_of_type_JavaUtilList.size() < 1) {
            break;
          }
          j = paramView.jdField_a_of_type_JavaUtilList.size();
          i = 0;
          if (i < j)
          {
            if (!((String)paramView.jdField_a_of_type_JavaUtilList.get(i)).equals(this.a.app.a())) {
              break label533;
            }
            paramView.jdField_a_of_type_JavaUtilList.remove(i);
          }
          StatusHistoryActivity.a(this.a, paramView);
          paramView.jdField_a_of_type_Ujg.a(paramView.jdField_b_of_type_JavaUtilList);
          ReportController.b(this.a.app, "CliOper", "", "", "signiture", "his_act_off", 0, 0, "", "", "", "");
          i = 7;
          j = 0;
          paramView.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.mUins = paramView.jdField_a_of_type_JavaUtilList;
          StatusHistoryActivity.a(this.a).set(paramView.jdField_b_of_type_Int, paramView.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus);
          localObject = this.a.a.a(paramView.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId, i, paramView.jdField_b_of_type_AndroidWidgetImageView.getWidth(), paramView.jdField_b_of_type_AndroidWidgetImageView.getHeight());
          if (localObject != null) {
            paramView.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          }
          localObject = (SignatureHandler)this.a.app.a(41);
          if (localObject != null) {
            ((SignatureHandler)localObject).a(StatusHistoryActivity.a(this.a), paramView.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.feedsId, 255, j);
          }
          paramView.jdField_a_of_type_Ujg.notifyDataSetChanged();
          this.a.a(false, 0L);
          return;
        }
        paramView.jdField_a_of_type_Int = 1;
        Object localObject = new ArrayList();
        if (paramView.jdField_a_of_type_JavaUtilList.size() > 0) {
          ((List)localObject).addAll(paramView.jdField_a_of_type_JavaUtilList);
        }
        paramView.jdField_a_of_type_JavaUtilList.clear();
        paramView.jdField_a_of_type_JavaUtilList.add(this.a.app.a());
        if (((List)localObject).size() > 0) {
          paramView.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
        }
        StatusHistoryActivity.a(this.a, paramView);
        paramView.jdField_a_of_type_Ujg.a(paramView.jdField_b_of_type_JavaUtilList);
        ReportController.b(this.a.app, "CliOper", "", "", "signiture", "his_act_on", 0, 0, "", "", "", "");
        int i = 8;
        int j = 1;
        continue;
        i += 1;
      }
      catch (Exception paramView)
      {
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uiv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */