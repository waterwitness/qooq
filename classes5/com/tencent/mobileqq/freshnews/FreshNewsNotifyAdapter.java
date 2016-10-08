package com.tencent.mobileqq.freshnews;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import sqq;

public class FreshNewsNotifyAdapter
  extends BaseAdapter
{
  private static final int jdField_a_of_type_Int = 388;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View jdField_a_of_type_AndroidViewView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public FreshNewsNotifyAdapter(AppInterface paramAppInterface, Activity paramActivity, FaceDecoder paramFaceDecoder, ListView paramListView, View.OnClickListener paramOnClickListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  private void a(long paramLong, ImageView paramImageView)
  {
    if (paramLong > 0L) {
      try
      {
        String str = String.valueOf(paramLong);
        Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(32, str, 202);
        if (localBitmap == null)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) {
            this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(str, 202, true, false);
          }
          if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
            this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)ImageUtil.a());
          }
          paramImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
          return;
        }
        paramImageView.setImageBitmap(localBitmap);
        return;
      }
      catch (Throwable paramImageView)
      {
        paramImageView.printStackTrace();
        return;
      }
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)ImageUtil.a());
    }
    paramImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
  }
  
  public FreshNewsNotify a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (FreshNewsNotify)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public List a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(long paramLong, FreshNewsNotifyAdapter.ViewHolder paramViewHolder, Bitmap paramBitmap)
  {
    if (paramLong == paramViewHolder.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsNotify.userTinyId) {
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new BitmapDrawable(paramBitmap));
    }
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_Boolean = paramBoolean;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0);
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return 1;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130904169, null);
        if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
          break label104;
        }
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131427641);
      }
      for (;;)
      {
        paramView = new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentWidgetListView.getWidth(), this.jdField_a_of_type_ComTencentWidgetListView.getHeight());
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramView);
        this.jdField_a_of_type_AndroidViewView.requestLayout();
        return this.jdField_a_of_type_AndroidViewView;
        label104:
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131427640);
      }
    }
    Object localObject1;
    if ((paramView != null) && (paramView != this.jdField_a_of_type_AndroidViewView))
    {
      localObject1 = (FreshNewsNotifyAdapter.ViewHolder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject1;
    }
    for (;;)
    {
      FreshNewsNotify localFreshNewsNotify = a(paramInt);
      paramView.jdField_a_of_type_Int = paramInt;
      paramView.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsNotify = localFreshNewsNotify;
      paramView.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new sqq(this, localFreshNewsNotify));
      switch (localFreshNewsNotify.eventType)
      {
      default: 
        label208:
        if (!TextUtils.isEmpty(localFreshNewsNotify.userNickName))
        {
          paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localFreshNewsNotify.userNickName);
          a(localFreshNewsNotify.userTinyId, paramView.jdField_a_of_type_AndroidWidgetImageView);
        }
        break;
      }
      try
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = AIOUtils.a(55.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth;
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840689);
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840678);
        localObject1 = URLDrawable.getDrawable(localFreshNewsNotify.imageUrl + 388, (URLDrawable.URLDrawableOptions)localObject1);
        if (localObject1 != null)
        {
          paramView.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
          if (localFreshNewsNotify.time <= 0) {
            break label712;
          }
          paramView.c.setText(FreshNewsUtil.a(localFreshNewsNotify.time, true));
          if (localFreshNewsNotify.readType != 0) {
            break label725;
          }
          paramView.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838349);
          paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          return paramViewGroup;
          paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130904181, null);
          paramView = new FreshNewsNotifyAdapter.ViewHolder();
          paramView.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131297886);
          paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131298361));
          paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131301730));
          paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131301729));
          paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131300559));
          paramView.c = ((TextView)paramViewGroup.findViewById(2131301731));
          paramViewGroup.setTag(paramView);
          continue;
          if (!TextUtils.isEmpty(localFreshNewsNotify.commentRichTextString))
          {
            localObject1 = new QQText(localFreshNewsNotify.commentRichTextString, 3, 16);
            paramView.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
            break label208;
          }
          paramView.jdField_b_of_type_AndroidWidgetTextView.setText("评论了你");
          break label208;
          if (!TextUtils.isEmpty(localFreshNewsNotify.commentRichTextString))
          {
            localObject1 = new QQText(localFreshNewsNotify.commentRichTextString, 3, 16);
            paramView.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
            break label208;
          }
          paramView.jdField_b_of_type_AndroidWidgetTextView.setText("回复了你");
          break label208;
          if (!TextUtils.isEmpty(localFreshNewsNotify.eventTips))
          {
            paramView.jdField_b_of_type_AndroidWidgetTextView.setText(localFreshNewsNotify.eventTips);
            break label208;
          }
          paramView.jdField_b_of_type_AndroidWidgetTextView.setText("赞了你");
          break label208;
          paramView.jdField_a_of_type_AndroidWidgetTextView.setText("");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          Object localObject2 = null;
          continue;
          paramView.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840689));
          continue;
          label712:
          paramView.c.setText("");
          continue;
          label725:
          paramView.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130840683);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\FreshNewsNotifyAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */