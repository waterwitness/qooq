import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.struct.InterestLabelInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyInterestLabelViewGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ViewUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

public class ibw
  extends PagerAdapter
{
  private int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private int jdField_b_of_type_Int;
  private WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  
  public ibw(ReadInJoyInterestLabelViewGroup paramReadInJoyInterestLabelViewGroup, List paramList, HashMap paramHashMap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Int = 10;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramList);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramHashMap);
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      i = j;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        List localList = (List)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        i = localList.size() / this.jdField_b_of_type_Int;
        if (localList.size() % this.jdField_b_of_type_Int == 0) {
          break label76;
        }
        i += 1;
      }
    }
    label76:
    for (;;)
    {
      j = i;
      if (i == 0) {
        j = i + 1;
      }
      return j;
    }
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyInterestLabelViewGroup.getContext());
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    localLinearLayout.setOrientation(1);
    localLinearLayout.removeAllViews();
    int i = this.jdField_b_of_type_Int;
    int j = this.jdField_b_of_type_Int;
    i *= paramInt;
    if ((i >= (paramInt + 1) * j) || (i >= this.jdField_a_of_type_Int))
    {
      paramViewGroup.addView(localLinearLayout);
      return localLinearLayout;
    }
    InterestLabelInfo localInterestLabelInfo = (InterestLabelInfo)((List)this.jdField_a_of_type_JavaLangRefWeakReference.get()).get(i);
    Object localObject;
    label167:
    label257:
    Button localButton;
    if (i % 5 == 0)
    {
      localObject = (ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyInterestLabelViewGroup.a().getLayoutInflater().inflate(2130903758, null);
      if (ViewUtils.a() < 2.0F)
      {
        localLayoutParams.topMargin = ViewUtils.a(10.0F);
        ((Button)((ViewGroup)localObject).findViewById(2131299972)).setTag(Integer.valueOf(i));
        ((Button)((ViewGroup)localObject).findViewById(2131299973)).setTag(Integer.valueOf(i + 1));
        localLinearLayout.addView((View)localObject, localLayoutParams);
      }
    }
    else
    {
      if (i % 5 == 2)
      {
        localObject = (ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyInterestLabelViewGroup.a().getLayoutInflater().inflate(2130903759, null);
        if (ViewUtils.a() >= 2.0F) {
          break label468;
        }
        localLayoutParams.topMargin = ViewUtils.a(10.0F);
        ((Button)((ViewGroup)localObject).findViewById(2131299975)).setTag(Integer.valueOf(i));
        ((Button)((ViewGroup)localObject).findViewById(2131299976)).setTag(Integer.valueOf(i + 1));
        ((Button)((ViewGroup)localObject).findViewById(2131299977)).setTag(Integer.valueOf(i + 2));
        localLinearLayout.addView((View)localObject, localLayoutParams);
      }
      localButton = (Button)localLinearLayout.findViewWithTag(Integer.valueOf(i));
      if (localButton != null)
      {
        if (this.jdField_b_of_type_JavaLangRefWeakReference != null) {
          break label481;
        }
        localObject = null;
        label349:
        if (localObject == null) {
          break label509;
        }
        ReadInJoyInterestLabelViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyInterestLabelViewGroup).put(Integer.valueOf(localInterestLabelInfo.mInterestLabelID), localInterestLabelInfo);
        localButton.setVisibility(0);
        localButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localButton.setTextColor(-1);
        localButton.setText(localInterestLabelInfo.mInterestLabelNme);
        localButton.setTag(2131362961, localInterestLabelInfo);
        localButton.setBackgroundResource(2130839523);
        label421:
        if (ViewUtils.a() >= 2.0F) {
          break label560;
        }
        localButton.setPadding(ViewUtils.a(25.0F), 0, ViewUtils.a(25.0F), 0);
      }
    }
    for (;;)
    {
      i += 1;
      break;
      localLayoutParams.topMargin = ViewUtils.a(20.0F);
      break label167;
      label468:
      localLayoutParams.topMargin = ViewUtils.a(20.0F);
      break label257;
      label481:
      localObject = (InterestLabelInfo)((HashMap)this.jdField_b_of_type_JavaLangRefWeakReference.get()).get(Integer.valueOf(localInterestLabelInfo.mInterestLabelID));
      break label349;
      label509:
      localButton.setVisibility(0);
      localButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localButton.setTextColor(-15550475);
      localButton.setText(localInterestLabelInfo.mInterestLabelNme);
      localButton.setTag(2131362961, localInterestLabelInfo);
      localButton.setBackgroundResource(2130839522);
      break label421;
      label560:
      localButton.setPadding(ViewUtils.a(30.0F), 0, ViewUtils.a(30.0F), 0);
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ibw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */