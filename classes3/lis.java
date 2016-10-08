import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FunnyPicHelper;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class lis
  extends BaseAdapter
{
  private float jdField_a_of_type_Float;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public List a;
  
  public lis(FavEmosmManageActivity paramFavEmosmManageActivity, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramFavEmosmManageActivity.getLayoutInflater();
    this.jdField_a_of_type_Float = paramFavEmosmManageActivity.getApplicationContext().getResources().getDisplayMetrics().density;
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      this.jdField_a_of_type_JavaUtilList.remove(paramInt);
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903335, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(FavEmosmManageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity), FavEmosmManageActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity)));
      paramViewGroup = new lit(this, null);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131298174));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298176));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131298175);
      paramView.setTag(paramViewGroup);
      if (paramInt != 0) {
        break label224;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
        break label202;
      }
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.getResources().getDrawable(2130841698));
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        if (((Byte)this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).byteValue() != 0) {
          break label456;
        }
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return paramView;
      paramViewGroup = (lit)paramView.getTag();
      break;
      label202:
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.getResources().getDrawable(2130841697));
      continue;
      label224:
      Object localObject1 = (EmoticonInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.jdField_a_of_type_JavaUtilList.contains(localObject1))
      {
        Object localObject2;
        try
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.getResources().getDrawable(2130841690);
          File localFile = new File(AppConstants.bs + FunnyPicHelper.a(((FavoriteEmoticonInfo)localObject1).m));
          if (!localFile.exists()) {
            break label373;
          }
          localObject1 = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject2);
          ((URLDrawable)localObject1).startDownload();
          paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        }
        catch (MalformedURLException localMalformedURLException) {}
        if (QLog.isColorLevel())
        {
          QLog.d("FavEmosmManageActivity", 2, localMalformedURLException.getMessage());
          continue;
          label373:
          localObject2 = URLDrawable.getDrawable(new URL("funny_pic", "", ((FavoriteEmoticonInfo)localMalformedURLException).m), (URLDrawable.URLDrawableOptions)localObject2);
          ((URLDrawable)localObject2).setTag(((FavoriteEmoticonInfo)localMalformedURLException).m);
          ((URLDrawable)localObject2).startDownload();
          paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
        }
      }
      else
      {
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localMalformedURLException.a(this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.getApplicationContext(), this.jdField_a_of_type_Float));
      }
    }
    label456:
    paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    return paramView;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */