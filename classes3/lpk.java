import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividuationConfigInfo.ActivityConfig;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class lpk
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "100005.100023";
  IndividuationSetActivity jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity;
  RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  RedTouchManager jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchManager;
  BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public lpk(IndividuationSetActivity paramIndividuationSetActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity = paramIndividuationSetActivity;
    if ((paramIndividuationSetActivity.getAppRuntime() != null) && ((paramIndividuationSetActivity.getAppRuntime() instanceof QQAppInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchManager = ((RedTouchManager)paramIndividuationSetActivity.getAppRuntime().getManager(35));
    }
  }
  
  public IndividuationConfigInfo.ActivityConfig a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return (IndividuationConfigInfo.ActivityConfig)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity = null;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    IndividuationConfigInfo.ActivityConfig localActivityConfig = a(paramInt);
    if (localActivityConfig == null) {
      return paramView;
    }
    if (paramView == null)
    {
      paramView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, 2130904543, null);
      paramViewGroup = new lpl(this);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131303121));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131303123));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131303122));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      if ((paramInt == 0) && (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) && (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchManager != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, paramViewGroup.jdField_a_of_type_AndroidWidgetImageView).a(53).a();
        this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchManager.a("100005.100023");
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      }
      if (!TextUtils.isEmpty(localActivityConfig.b))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width;
        localURLDrawableOptions.mRequestHeight = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height;
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(localActivityConfig.b, localURLDrawableOptions));
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localActivityConfig.c);
      paramViewGroup.b.setText(localActivityConfig.d);
      return paramView;
      paramViewGroup = (lpl)paramView.getTag();
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = a(paramInt);
    if (paramAdapterView != null)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.app, "CliOper", "", "", "Trends_tab", "Clk_activity", 0, 0, paramAdapterView.a, "", "", "");
      IndividuationSetActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, paramAdapterView.e);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchManager.b("100005.100023");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lpk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */