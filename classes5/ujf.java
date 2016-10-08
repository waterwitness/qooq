import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.NoScrollGridView;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity.ItemViewHolder;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity.MoreViewHolder;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ujf
  extends BaseAdapter
{
  private ujf(StatusHistoryActivity paramStatusHistoryActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int getCount()
  {
    int i = 1;
    int j = StatusHistoryActivity.a(this.a).size();
    if (j == 0) {
      return 1;
    }
    if (StatusHistoryActivity.a(this.a) != 0) {}
    for (;;)
    {
      return i + j;
      i = 0;
    }
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt >= StatusHistoryActivity.a(this.a).size()) {
      return null;
    }
    return StatusHistoryActivity.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return getItemViewType(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = StatusHistoryActivity.a(this.a).size();
    if (i == 0) {
      return 2;
    }
    if (paramInt < i) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (i == 2)
    {
      StatusHistoryActivity.b(this.a).setLayoutParams(new AbsListView.LayoutParams(this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getWidth(), this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getHeight()));
      return StatusHistoryActivity.b(this.a);
    }
    if (i == 0)
    {
      View localView;
      Object localObject;
      if (paramView == null)
      {
        paramViewGroup = new StatusHistoryActivity.ItemViewHolder();
        localView = paramView;
        if (paramView == null)
        {
          localView = LayoutInflater.from(this.a).inflate(2130905002, null);
          localView.setFocusable(true);
          paramViewGroup.jdField_a_of_type_Ujg = new ujg(this.a, this.a);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131305011));
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView = ((ClickableColorSpanTextView)localView.findViewById(2131305015));
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297555));
          paramViewGroup.jdField_b_of_type_AndroidViewView = localView.findViewById(2131305007);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView.setTag(paramViewGroup);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView.setSpanClickListener(this.a);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)localView.findViewById(2131296816));
          paramViewGroup.jdField_a_of_type_AndroidViewView = paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout.findViewById(2131298227);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichstatusNoScrollGridView = ((NoScrollGridView)localView.findViewById(2131305018));
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichstatusNoScrollGridView.setNumColumns(-1);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichstatusNoScrollGridView.setColumnWidth(DisplayUtil.a(this.a, 30.0F));
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichstatusNoScrollGridView.setHorizontalSpacing(DisplayUtil.a(this.a, 7.0F));
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichstatusNoScrollGridView.setVerticalSpacing(DisplayUtil.a(this.a, 7.0F));
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichstatusNoScrollGridView.setStretchMode(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131305012));
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131305017));
          paramViewGroup.c = ((ImageView)localView.findViewById(2131305013));
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = ((AIOAnimationConatiner)localView.findViewById(2131305014));
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a = this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
          localView.setTag(paramViewGroup);
          localView.setClickable(true);
        }
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeAllViews();
        paramViewGroup.jdField_b_of_type_Int = paramInt;
        paramView = (RichStatus)StatusHistoryActivity.a(this.a).get(paramInt);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramView;
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppSignatureManager.a(Integer.toString(paramView.tplId));
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo = ((SignatureTemplateInfo)localObject);
        if ((localObject == null) || (((SignatureTemplateInfo)localObject).a == null)) {
          break label845;
        }
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView.setVisibility(4);
        label459:
        if (paramInt != StatusHistoryActivity.a(this.a).size() - 1) {
          break label856;
        }
        paramViewGroup.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130843346);
      }
      for (;;)
      {
        if (paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.feedsId != null)
        {
          paramViewGroup.jdField_a_of_type_JavaUtilList = new ArrayList();
          if ((paramView.mUins != null) && (paramView.mUins.size() > 0)) {
            paramViewGroup.jdField_a_of_type_JavaUtilList.addAll(paramView.mUins);
          }
          StatusHistoryActivity.a(this.a, paramViewGroup);
          paramViewGroup.jdField_a_of_type_Int = 0;
          if (paramViewGroup.jdField_a_of_type_JavaUtilList.size() > 0)
          {
            localObject = paramViewGroup.jdField_a_of_type_JavaUtilList.iterator();
            while (((Iterator)localObject).hasNext()) {
              if (((String)((Iterator)localObject).next()).equals(this.a.app.a())) {
                paramViewGroup.jdField_a_of_type_Int = 1;
              }
            }
          }
          paramInt = 7;
          if (1 == paramViewGroup.jdField_a_of_type_Int) {
            paramInt = 8;
          }
          localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppSignatureManager.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId, paramInt, DisplayUtil.a(this.a, 14.0F), DisplayUtil.a(this.a, 19.0F));
          if (localObject != null) {
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          }
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setTag(paramViewGroup);
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.a.b);
          paramViewGroup.jdField_a_of_type_Ujg.a(paramViewGroup.jdField_b_of_type_JavaUtilList);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichstatusNoScrollGridView.setAdapter(paramViewGroup.jdField_a_of_type_Ujg);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichstatusNoScrollGridView.setTag(paramViewGroup);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichstatusNoScrollGridView.setOnItemClickListener(this.a.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(paramView.getLocSS(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView, TimeFormatterUtils.d(this.a.app.a().getApplicationContext(), paramView.time * 1000L) + "    "));
        StatusHistoryActivity.b(this.a, paramViewGroup);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setEnabled(false);
        return localView;
        paramViewGroup = (StatusHistoryActivity.ItemViewHolder)paramView.getTag();
        break;
        label845:
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView.setVisibility(0);
        break label459;
        label856:
        paramViewGroup.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130843347);
      }
    }
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = this.a.getLayoutInflater().inflate(2130903408, null);
      paramViewGroup.setOnClickListener(this.a);
      paramView = new StatusHistoryActivity.MoreViewHolder();
      paramViewGroup.setTag(paramView);
      paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131297005));
      paramViewGroup.findViewById(2131298469).setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131298457));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131427409));
    }
    if (StatusHistoryActivity.a(this.a) == 1)
    {
      StatusHistoryActivity.a(this.a, 2);
      this.a.a(false, false);
    }
    paramView = (StatusHistoryActivity.MoreViewHolder)paramViewGroup.getTag();
    if (StatusHistoryActivity.a(this.a) == 3)
    {
      paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText("暂无更多，请重试。");
      return paramViewGroup;
    }
    paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText("加载更多中...");
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return 2 != getItemViewType(paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ujf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */