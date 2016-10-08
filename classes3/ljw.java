import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.FreshNewsEditActivity;
import com.tencent.mobileqq.freshnews.FreshNewsDragGridView.OnItemOrderChangedListener;
import com.tencent.mobileqq.freshnews.FreshNewsManager.PhotoInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomImgView;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class ljw
  extends BaseAdapter
  implements FreshNewsDragGridView.OnItemOrderChangedListener
{
  private int jdField_a_of_type_Int;
  
  private ljw(FreshNewsEditActivity paramFreshNewsEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(FreshNewsEditActivity.a(), 4, "onItemSwap, oldPosition=" + paramInt1 + ", newPosition=" + paramInt2);
    }
    FreshNewsManager.PhotoInfo localPhotoInfo = (FreshNewsManager.PhotoInfo)this.jdField_a_of_type_ComTencentMobileqqActivityFreshNewsEditActivity.a.get(paramInt1);
    if (paramInt1 < paramInt2) {
      while (paramInt1 < paramInt2)
      {
        Collections.swap(this.jdField_a_of_type_ComTencentMobileqqActivityFreshNewsEditActivity.a, paramInt1, paramInt1 + 1);
        paramInt1 += 1;
      }
    }
    if (paramInt1 > paramInt2) {
      while (paramInt1 > paramInt2)
      {
        Collections.swap(this.jdField_a_of_type_ComTencentMobileqqActivityFreshNewsEditActivity.a, paramInt1, paramInt1 - 1);
        paramInt1 -= 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityFreshNewsEditActivity.a.set(paramInt2, localPhotoInfo);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityFreshNewsEditActivity.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return ((FreshNewsManager.PhotoInfo)this.jdField_a_of_type_ComTencentMobileqqActivityFreshNewsEditActivity.a.get(paramInt)).a;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (FreshNewsManager.PhotoInfo)this.jdField_a_of_type_ComTencentMobileqqActivityFreshNewsEditActivity.a.get(paramInt);
    if (paramView == null)
    {
      paramView = new CustomImgView(this.jdField_a_of_type_ComTencentMobileqqActivityFreshNewsEditActivity.getApplicationContext());
      paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityFreshNewsEditActivity.c, this.jdField_a_of_type_ComTencentMobileqqActivityFreshNewsEditActivity.c));
      paramView.setTag(new ljx(null));
    }
    for (;;)
    {
      if ("plus_sign".equals(paramViewGroup.a)) {
        ((CustomImgView)paramView).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityFreshNewsEditActivity.getResources().getDrawable(2130841020));
      }
      for (;;)
      {
        Object localObject = (ljx)paramView.getTag();
        ((ljx)localObject).jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$PhotoInfo = paramViewGroup;
        ((ljx)localObject).jdField_a_of_type_Int = paramInt;
        paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityFreshNewsEditActivity);
        if (paramInt != this.jdField_a_of_type_Int) {
          break;
        }
        paramView.setVisibility(4);
        return paramView;
        if (!TextUtils.isEmpty(paramViewGroup.a))
        {
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqActivityFreshNewsEditActivity.c;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqActivityFreshNewsEditActivity.c;
          ((CustomImgView)paramView).setImageDrawable(URLDrawable.getDrawable(new File(paramViewGroup.a), (URLDrawable.URLDrawableOptions)localObject));
        }
      }
      paramView.setVisibility(0);
      return paramView;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ljw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */