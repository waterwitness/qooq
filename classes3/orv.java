import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.widget.AbsListView.LayoutParams;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class orv
  extends BaseAdapter
{
  Resources jdField_a_of_type_AndroidContentResResources;
  ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public ArrayList a;
  
  public orv(PhotoListActivity paramPhotoListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(570425344);
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramPhotoListActivity.getLayoutInflater();
    this.jdField_a_of_type_AndroidContentResResources = paramPhotoListActivity.getResources();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130842111);
  }
  
  public LocalMediaInfo a(int paramInt)
  {
    return (LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  String a(long paramLong)
  {
    paramLong /= 1000L;
    int i = (int)paramLong % 60;
    int j = (int)paramLong / 60;
    String str1;
    if (i > 9)
    {
      str1 = String.valueOf(i);
      if (j <= 9) {
        break label106;
      }
    }
    label106:
    for (String str2 = String.valueOf(j);; str2 = "0" + String.valueOf(j))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str2).append(":").append(str1);
      return localStringBuilder.toString();
      str1 = "0" + String.valueOf(i);
      break;
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    return AlbumUtil.a((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    Object localObject1;
    switch (i)
    {
    default: 
      localObject1 = paramView;
      return (View)localObject1;
    case 0: 
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904283, null);
        paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_g_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.h));
        paramViewGroup = new orw(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302159));
        paramViewGroup.b = ((ImageView)paramView.findViewById(2131302161));
        paramViewGroup.c = ((ImageView)paramView.findViewById(2131301237));
        paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131302164);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramView.findViewById(2131302165));
        paramViewGroup.jdField_a_of_type_Ort = new ort(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity);
        if (paramViewGroup.jdField_a_of_type_AndroidViewView != null) {
          paramViewGroup.jdField_a_of_type_AndroidViewView.setOnClickListener(paramViewGroup.jdField_a_of_type_Ort);
        }
        paramView.setTag(paramViewGroup);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_g_of_type_Boolean) {
          break label1256;
        }
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      break;
    }
    label209:
    label771:
    label840:
    label1072:
    label1095:
    label1253:
    label1256:
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Ort.a(paramInt);
      paramViewGroup.jdField_a_of_type_Ort.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox);
      localObject1 = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
      ((ImageView)localObject1).setAdjustViewBounds(false);
      LocalMediaInfo localLocalMediaInfo = a(paramInt);
      paramView.setContentDescription(PhotoUtils.a(i, localLocalMediaInfo, paramInt));
      int j = AlbumThumbDownloader.a;
      localLocalMediaInfo.jdField_g_of_type_Int = j;
      localLocalMediaInfo.f = j;
      Object localObject2 = paramViewGroup.jdField_a_of_type_ComTencentImageURLDrawable;
      Object localObject3 = new StringBuilder("albumthumb");
      ((StringBuilder)localObject3).append("://");
      ((StringBuilder)localObject3).append(localLocalMediaInfo.a);
      if ((localObject2 == null) || (!((URLDrawable)localObject2).getURL().toString().equals(((StringBuilder)localObject3).toString())))
      {
        localObject3 = URLDrawableHelper.a(AlbumUtil.a(localLocalMediaInfo), this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        ((URLDrawable)localObject3).setTag(localLocalMediaInfo);
        ((ImageView)localObject1).setImageDrawable((Drawable)localObject3);
        paramViewGroup.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject3);
        if (localObject2 != null) {
          ((URLDrawable)localObject2).cancelDownload();
        }
      }
      localObject1 = paramViewGroup.b;
      j = localLocalMediaInfo.jdField_b_of_type_Int;
      if (j == 1)
      {
        ((ImageView)localObject1).setVisibility(0);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.c.indexOf(localLocalMediaInfo.a) + 1);
        if (paramView.getBackground() != null) {
          paramView.setBackgroundDrawable(null);
        }
      }
      for (;;)
      {
        localObject1 = paramView;
        if (!AppSetting.j) {
          break;
        }
        localObject1 = PhotoUtils.a(i, localLocalMediaInfo, paramInt, paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked());
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setContentDescription((CharSequence)localObject1);
        return paramView;
        paramViewGroup = (orw)paramView.getTag();
        break label209;
        if (j == 3)
        {
          ((ImageView)localObject1).setVisibility(4);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.u)
          {
            if (paramView.getBackground() == null) {
              paramView.setBackgroundResource(2130837640);
            }
          }
          else {
            paramView.setBackgroundDrawable(null);
          }
        }
        else
        {
          ((ImageView)localObject1).setVisibility(4);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
          if (paramView.getBackground() != null) {
            paramView.setBackgroundDrawable(null);
          }
        }
      }
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904392, null);
        paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_g_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.h));
        paramViewGroup = new orw(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302159));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131302618));
        paramViewGroup.b = ((ImageView)paramView.findViewById(2131302161));
        paramViewGroup.c = ((ImageView)paramView.findViewById(2131301237));
        paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131302164);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramView.findViewById(2131302165));
        paramViewGroup.jdField_a_of_type_Ort = new ort(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity);
        if (paramViewGroup.jdField_a_of_type_AndroidViewView != null) {
          paramViewGroup.jdField_a_of_type_AndroidViewView.setOnClickListener(paramViewGroup.jdField_a_of_type_Ort);
        }
        paramView.setTag(paramViewGroup);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_g_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.D)) {
          break label1253;
        }
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      for (;;)
      {
        paramViewGroup.jdField_a_of_type_Ort.a(paramInt);
        paramViewGroup.jdField_a_of_type_Ort.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox);
        localObject2 = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
        ((ImageView)localObject2).setAdjustViewBounds(false);
        localLocalMediaInfo = a(paramInt);
        paramView.setContentDescription(PhotoUtils.a(i, localLocalMediaInfo, paramInt));
        if (localLocalMediaInfo.jdField_b_of_type_Boolean == true)
        {
          localObject1 = AlbumUtil.a(localLocalMediaInfo, "VIDEO");
          i = AlbumThumbDownloader.a;
          localLocalMediaInfo.jdField_g_of_type_Int = i;
          localLocalMediaInfo.f = i;
          localObject3 = paramViewGroup.jdField_a_of_type_ComTencentImageURLDrawable;
          if ((localObject3 == null) || (!((URLDrawable)localObject3).getURL().equals(localObject1)))
          {
            localObject1 = URLDrawableHelper.a((URL)localObject1, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
            ((URLDrawable)localObject1).setTag(localLocalMediaInfo);
            ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
            paramViewGroup.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject1);
            if (localObject3 != null) {
              ((URLDrawable)localObject3).cancelDownload();
            }
          }
          localObject1 = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
          if ((localLocalMediaInfo.jdField_b_of_type_Boolean) || (localLocalMediaInfo.e > 0L)) {
            break label1072;
          }
          ((TextView)localObject1).setVisibility(8);
          localObject1 = MediaScanner.a(BaseApplicationImpl.getContext());
          if (localObject1 != null) {
            ((MediaScanner)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, localLocalMediaInfo, paramInt);
          }
        }
        for (;;)
        {
          localObject1 = paramViewGroup.b;
          paramInt = localLocalMediaInfo.jdField_b_of_type_Int;
          if (paramInt != 1) {
            break label1095;
          }
          ((ImageView)localObject1).setVisibility(0);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.c.indexOf(localLocalMediaInfo.a) + 1);
          localObject1 = paramView;
          if (paramView.getBackground() == null) {
            break;
          }
          paramView.setBackgroundDrawable(null);
          return paramView;
          paramViewGroup = (orw)paramView.getTag();
          break label771;
          localObject1 = AlbumUtil.a(localLocalMediaInfo, "APP_VIDEO");
          break label840;
          ((TextView)localObject1).setVisibility(0);
          ((TextView)localObject1).setText(a(localLocalMediaInfo.e));
        }
        if (paramInt == 3)
        {
          ((ImageView)localObject1).setVisibility(4);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.u)
          {
            localObject1 = paramView;
            if (paramView.getBackground() != null) {
              break;
            }
            paramView.setBackgroundResource(2130837640);
            return paramView;
          }
          paramView.setBackgroundDrawable(null);
          return paramView;
        }
        ((ImageView)localObject1).setVisibility(4);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        localObject1 = paramView;
        if (paramView.getBackground() == null) {
          break;
        }
        paramView.setBackgroundDrawable(null);
        return paramView;
        if (paramView == null)
        {
          paramView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity);
          paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_g_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.h));
        }
        for (;;)
        {
          paramViewGroup = (ImageView)paramView;
          paramView.setBackgroundColor(-16777216);
          paramViewGroup.setImageResource(2130838730);
          paramViewGroup.setScaleType(ImageView.ScaleType.CENTER);
          return paramView;
        }
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return AlbumUtil.d.size();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\orv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */