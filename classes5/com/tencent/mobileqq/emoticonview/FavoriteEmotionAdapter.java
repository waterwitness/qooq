package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FunnyPicHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class FavoriteEmotionAdapter
  extends BaseEmotionAdapter
{
  public static final String b = FavoriteEmotionAdapter.class.getSimpleName();
  public static final String c = "100610.100612.100613";
  public static final int h = 56;
  public static final int i = 61;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FavoriteEmotionAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
  }
  
  private RelativeLayout b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(b, 2, "getFavrotiview");
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(this.f / this.c, (int)(61.0F * this.jdField_a_of_type_Float)));
    Object localObject = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    ((URLImageView)localObject).setId(2131296394);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Float * 56.0F), (int)(this.jdField_a_of_type_Float * 56.0F));
    localLayoutParams.addRule(13, -1);
    localLayoutParams.addRule(12, -1);
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject).setId(2131296485);
    ((RelativeLayout)localObject).setVisibility(8);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(3, 2131296394);
    localLayoutParams.addRule(7, 2131296394);
    localLayoutParams.addRule(6, 2131296394);
    ((RelativeLayout)localObject).setBackgroundResource(2130843325);
    localLayoutParams.topMargin = (-(int)(this.jdField_a_of_type_Float * 4.0F));
    localLayoutParams.rightMargin = (-(int)(this.jdField_a_of_type_Float * 4.0F));
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setId(2131296395);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(7, 2131296394);
    localLayoutParams.addRule(8, 2131296394);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    if (AppSetting.j) {
      localRelativeLayout.setFocusable(true);
    }
    return localRelativeLayout;
  }
  
  private void b(View paramView, EmotionPanelData paramEmotionPanelData)
  {
    if (QLog.isColorLevel()) {
      QLog.d(b, 2, "updateUI");
    }
    if ((paramView == null) || (paramEmotionPanelData == null)) {
      return;
    }
    if ((paramEmotionPanelData instanceof EmoticonInfo)) {}
    for (EmoticonInfo localEmoticonInfo = (EmoticonInfo)paramEmotionPanelData;; localEmoticonInfo = null)
    {
      if (localEmoticonInfo == null)
      {
        QLog.e(b, 1, "emotionInfo = null");
        return;
      }
      paramView.setTag(localEmoticonInfo);
      paramView.setVisibility(0);
      RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131296485);
      if (localRelativeLayout != null)
      {
        paramEmotionPanelData = localRelativeLayout.getTag();
        if ((paramEmotionPanelData != null) && ((paramEmotionPanelData instanceof RedTouch))) {
          ((RedTouch)paramEmotionPanelData).setVisibility(8);
        }
      }
      URLImageView localURLImageView = (URLImageView)paramView.findViewById(2131296394);
      localURLImageView.setVisibility(0);
      Object localObject = (RelativeLayout.LayoutParams)localURLImageView.getLayoutParams();
      paramEmotionPanelData = localEmoticonInfo.a;
      int j;
      if ("favEdit".equals(paramEmotionPanelData))
      {
        localURLImageView.setImageResource(2130841694);
        localURLImageView.setBackgroundDrawable(null);
        if (AppSetting.j) {
          localURLImageView.setContentDescription("收藏表情管理页面入口");
        }
        paramView = (ImageView)paramView.findViewById(2131296395);
        if (!(localEmoticonInfo instanceof PicEmoticonInfo)) {
          break label602;
        }
        if (((PicEmoticonInfo)localEmoticonInfo).a())
        {
          paramView.setVisibility(0);
          paramView.setImageResource(2130843335);
        }
      }
      else if ("funny_pic".equals(paramEmotionPanelData))
      {
        j = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("funny_pic_info", 0).getInt("funnypic_type_sp_key", 1);
        float f = BaseApplicationImpl.a.getResources().getDisplayMetrics().density;
        paramEmotionPanelData = URLDrawable.URLDrawableOptions.obtain();
        paramEmotionPanelData.mGifRoundCorner = (f * 10.0F);
        int k = (int)(this.jdField_a_of_type_Float * 57.0F);
        ((RelativeLayout.LayoutParams)localObject).height = k;
        paramEmotionPanelData.mRequestHeight = k;
        k = (int)(this.jdField_a_of_type_Float * 57.0F);
        ((RelativeLayout.LayoutParams)localObject).width = k;
        paramEmotionPanelData.mRequestWidth = k;
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841695);
        paramEmotionPanelData.mLoadingDrawable = ((Drawable)localObject);
        paramEmotionPanelData.mFailedDrawable = ((Drawable)localObject);
        paramEmotionPanelData.mPlayGifImage = true;
        localObject = FunnyPicHelper.a(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app);
      }
      for (;;)
      {
        try
        {
          paramEmotionPanelData = URLDrawable.getDrawable(new URL("funny_pic", null, (String)localObject), paramEmotionPanelData);
          paramEmotionPanelData.setTag(localObject);
          paramEmotionPanelData.addHeader("funnypic_type", String.valueOf(j));
          if ((paramEmotionPanelData.getCurrDrawable() instanceof GifDrawable)) {
            ((GifDrawable)paramEmotionPanelData.getCurrDrawable()).getImage().reset();
          }
          localURLImageView.setImageResource(2130841696);
          localURLImageView.setBackgroundDrawable(paramEmotionPanelData);
          if (localRelativeLayout != null)
          {
            paramEmotionPanelData = localRelativeLayout.getTag();
            if ((paramEmotionPanelData == null) || (!(paramEmotionPanelData instanceof RedTouch))) {
              break label612;
            }
            paramEmotionPanelData = (RedTouch)paramEmotionPanelData;
            if (paramEmotionPanelData != null) {
              break label609;
            }
            paramEmotionPanelData = new RedTouch(this.jdField_a_of_type_AndroidContentContext, localRelativeLayout);
            paramEmotionPanelData.setVisibility(0);
            paramEmotionPanelData.a(17);
            paramEmotionPanelData.a();
            localObject = (RedTouchManager)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getManager(35);
            BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)localObject).a("100610.100612.100613");
            paramEmotionPanelData.a(localAppInfo);
            ((RedTouchManager)localObject).a(localAppInfo);
            localRelativeLayout.setTag(paramEmotionPanelData);
          }
        }
        catch (MalformedURLException paramEmotionPanelData)
        {
          paramEmotionPanelData.printStackTrace();
          continue;
        }
        if (!AppSetting.j) {
          break;
        }
        localURLImageView.setContentDescription("趣图专区入口");
        break;
        localURLImageView.setImageDrawable(localEmoticonInfo.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float));
        localURLImageView.setBackgroundDrawable(null);
        break;
        paramView.setVisibility(8);
        return;
        label602:
        paramView.setVisibility(8);
        return;
        label609:
        continue;
        label612:
        paramEmotionPanelData = null;
      }
    }
  }
  
  public View a(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int k = 0;
    System.currentTimeMillis();
    paramViewGroup = (FavoriteEmotionAdapter.FavoriteEmotionViewHolder)paramViewHolder;
    int j;
    if (paramView == null)
    {
      paramView = EmotionPanelViewPool.a().a(this.e);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(b, 2, "getEmotionView position = " + paramInt + ";view from inflater");
        }
        paramView = new EmotionPanelLinearLayout(this.jdField_a_of_type_AndroidContentContext);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        paramView.setOrientation(0);
        if (paramInt == 0) {
          paramView.setPadding(0, (int)(11.0F * this.jdField_a_of_type_Float), 0, 0);
        }
        for (;;)
        {
          j = 0;
          for (;;)
          {
            paramViewHolder = paramView;
            if (j >= this.c) {
              break;
            }
            paramViewHolder = b();
            paramViewHolder.setVisibility(8);
            paramViewHolder.setFocusable(true);
            paramViewHolder.setFocusableInTouchMode(true);
            paramView.addView(paramViewHolder);
            j += 1;
          }
          paramView.setPadding(0, (int)(9.0F * this.jdField_a_of_type_Float), 0, 0);
        }
      }
      paramViewHolder = paramView;
      if (QLog.isColorLevel())
      {
        QLog.d(b, 2, "getEmotionView position = " + paramInt + ";view from cache");
        paramViewHolder = paramView;
      }
      ((EmotionPanelLinearLayout)paramViewHolder).setCallBack(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
      a(this.e, paramViewHolder);
      paramView = (ViewGroup)paramViewHolder;
      paramViewGroup.a = new RelativeLayout[this.c];
      j = 0;
      while (j < this.c)
      {
        paramViewGroup.a[j] = ((RelativeLayout)paramView.getChildAt(j));
        j += 1;
      }
      paramViewHolder.setTag(paramViewGroup);
      j = k;
    }
    for (;;)
    {
      if (j < this.c)
      {
        k = this.c * paramInt + j;
        if (k > this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          paramViewGroup.a[j].setTag(null);
          paramViewGroup.a[j].setVisibility(8);
        }
        for (;;)
        {
          j += 1;
          break;
          b(paramViewGroup.a[j], (EmotionPanelData)this.jdField_a_of_type_JavaUtilList.get(k));
        }
      }
      if (QLog.isColorLevel()) {}
      return paramViewHolder;
      paramViewHolder = paramView;
      j = k;
    }
  }
  
  public BaseEmotionAdapter.ViewHolder a()
  {
    return new FavoriteEmotionAdapter.FavoriteEmotionViewHolder();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(b, 2, "refreshPanelData");
    }
    List localList = EmotionPanelDataBuilder.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.e, null);
    if (localList != null)
    {
      a(localList);
      notifyDataSetChanged();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\FavoriteEmotionAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */