package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import rla;

public class MagicFaceAdapter
  extends EmotionNeedDownloadAdapter
  implements Handler.Callback
{
  public static final String b;
  public static final int h = 72;
  public static final int i = 56;
  private static final int j = 63;
  private static final int k = 100;
  private static final int o = 101;
  URLDrawableDownListener jdField_a_of_type_ComTencentImageURLDrawableDownListener = new rla(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  List b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_JavaLangString = MagicFaceAdapter.class.getSimpleName();
  }
  
  public MagicFaceAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private ProgressBar a(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId))) {}
    while ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() <= 0)) {
      return null;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ProgressBar localProgressBar = (ProgressBar)localIterator.next();
      Object localObject = localProgressBar.getTag();
      if ((localObject instanceof String)) {}
      for (localObject = (String)localObject; (!TextUtils.isEmpty((CharSequence)localObject)) && (paramEmoticonPackage.epId.equals(localObject)); localObject = null) {
        return localProgressBar;
      }
    }
  }
  
  private void a(URLImageView paramURLImageView, PicEmoticonInfo paramPicEmoticonInfo)
  {
    if ((paramURLImageView == null) || (paramPicEmoticonInfo == null))
    {
      QLog.e(jdField_b_of_type_JavaLangString, 1, "updateImageView view or info = null");
      return;
    }
    Object localObject = (RelativeLayout.LayoutParams)paramURLImageView.getLayoutParams();
    if ("push".equals(paramPicEmoticonInfo.jdField_a_of_type_JavaLangString))
    {
      ((RelativeLayout.LayoutParams)localObject).width = ((int)(this.jdField_a_of_type_Float * 63.0F));
      ((RelativeLayout.LayoutParams)localObject).height = ((int)(this.jdField_a_of_type_Float * 63.0F));
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "show push_btn drawable.");
      }
      paramPicEmoticonInfo = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("mobileQQ", 0);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      boolean bool = paramPicEmoticonInfo.getBoolean("magic_promotion_is_new_content_" + (String)localObject, false);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841690);
      if (bool)
      {
        paramPicEmoticonInfo = paramPicEmoticonInfo.getString("magic_promotion_gifUrl", "");
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        if (TextUtils.isEmpty(paramPicEmoticonInfo)) {
          break label234;
        }
      }
      for (;;)
      {
        try
        {
          paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramPicEmoticonInfo, (URLDrawable.URLDrawableOptions)localObject));
          if (!AppSetting.j) {
            break;
          }
          paramURLImageView.setContentDescription("魔法表情专区入口");
          return;
          paramPicEmoticonInfo = paramPicEmoticonInfo.getString("magic_promotion_imgUrl", "");
        }
        catch (IllegalArgumentException paramPicEmoticonInfo)
        {
          if (QLog.isColorLevel()) {
            QLog.w(jdField_b_of_type_JavaLangString, 2, paramPicEmoticonInfo.getMessage());
          }
          paramURLImageView.setImageDrawable(null);
          continue;
        }
        label234:
        paramURLImageView.setImageDrawable(null);
      }
    }
    paramPicEmoticonInfo = paramPicEmoticonInfo.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float);
    if (paramPicEmoticonInfo != null) {
      paramURLImageView.setImageDrawable(paramPicEmoticonInfo);
    }
    for (;;)
    {
      paramURLImageView.setBackgroundDrawable(null);
      return;
      paramURLImageView.setVisibility(4);
    }
  }
  
  private RelativeLayout b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "getMagicView");
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(this.f / this.c, (int)(72.0F * this.jdField_a_of_type_Float)));
    Object localObject = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    ((URLImageView)localObject).setId(2131296394);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams((int)(56.0F * this.jdField_a_of_type_Float), (int)(56.0F * this.jdField_a_of_type_Float));
    localLayoutParams1.addRule(10, -1);
    localLayoutParams1.addRule(14, -1);
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    ((URLImageView)localObject).setLayoutParams(localLayoutParams1);
    localRelativeLayout.addView((View)localObject);
    localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject).setVisibility(8);
    ((TextView)localObject).setId(2131296396);
    ((TextView)localObject).setTextSize(11.0F);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.addRule(3, 2131296394);
    localLayoutParams1.topMargin = ((int)(5.0F * this.jdField_a_of_type_Float));
    localLayoutParams1.addRule(14, -1);
    localRelativeLayout.addView((View)localObject, localLayoutParams1);
    localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setVisibility(8);
    ((ImageView)localObject).setId(2131296395);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.addRule(8, 2131296394);
    localLayoutParams1.addRule(7, 2131296394);
    localRelativeLayout.addView((View)localObject, localLayoutParams1);
    localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setId(2131296398);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.addRule(5, 2131296394);
    localLayoutParams1.addRule(6, 2131296394);
    ProgressBar localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext);
    localProgressBar.setVisibility(8);
    localProgressBar.setId(2131296400);
    localProgressBar.setIndeterminateDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838321));
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams((int)(16.0F * this.jdField_a_of_type_Float), (int)(16.0F * this.jdField_a_of_type_Float));
    localLayoutParams2.addRule(14, -1);
    localLayoutParams2.topMargin = ((int)(20.0F * this.jdField_a_of_type_Float));
    localRelativeLayout.addView(localProgressBar, localLayoutParams2);
    localRelativeLayout.addView((View)localObject, localLayoutParams1);
    if (AppSetting.j) {
      localRelativeLayout.setFocusable(true);
    }
    return localRelativeLayout;
  }
  
  private void b(View paramView, EmotionPanelData paramEmotionPanelData)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "updateUI");
    }
    if ((paramView == null) || (paramEmotionPanelData == null)) {
      return;
    }
    if ((paramEmotionPanelData instanceof EmoticonInfo)) {}
    for (paramEmotionPanelData = (PicEmoticonInfo)paramEmotionPanelData;; paramEmotionPanelData = null)
    {
      if (paramEmotionPanelData == null)
      {
        QLog.e(jdField_b_of_type_JavaLangString, 1, "updateUI emotionInfo = null");
        return;
      }
      paramView.setVisibility(0);
      paramView.setTag(paramEmotionPanelData);
      URLImageView localURLImageView = (URLImageView)paramView.findViewById(2131296394);
      localURLImageView.setTag(Boolean.valueOf(false));
      localURLImageView.setVisibility(0);
      localURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener);
      a(localURLImageView, paramEmotionPanelData);
      Object localObject = (TextView)paramView.findViewById(2131296396);
      ImageView localImageView2 = (ImageView)paramView.findViewById(2131296398);
      ImageView localImageView1 = (ImageView)paramView.findViewById(2131296395);
      paramView = (ProgressBar)paramView.findViewById(2131296400);
      if ("push".equals(paramEmotionPanelData.jdField_a_of_type_JavaLangString))
      {
        ((TextView)localObject).setVisibility(8);
        localImageView2.setVisibility(8);
        localImageView1.setVisibility(8);
        paramView.setVisibility(8);
        return;
      }
      Emoticon localEmoticon = paramEmotionPanelData.jdField_a_of_type_ComTencentMobileqqDataEmoticon;
      if ((localEmoticon == null) || (TextUtils.isEmpty(localEmoticon.epId)))
      {
        QLog.e(jdField_b_of_type_JavaLangString, 1, "updateUI emotion is null or epid is null");
        return;
      }
      String str = localEmoticon.name;
      if (!TextUtils.isEmpty(str))
      {
        ((TextView)localObject).setVisibility(0);
        if (str.length() > 5)
        {
          ((TextView)localObject).setText(str.substring(0, 4) + "...");
          if (AppSetting.j) {
            ((TextView)localObject).setContentDescription(str);
          }
          label294:
          localImageView2.setVisibility(8);
          localImageView1.setVisibility(8);
          localObject = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(localEmoticon.epId);
          if ((localObject != null) && ((3 == ((EmoticonPackage)localObject).jobType) || (5 == ((EmoticonPackage)localObject).jobType)) && ((!((EmoticonPackage)localObject).valid) || (2 != ((EmoticonPackage)localObject).status)) && (!paramEmotionPanelData.jdField_a_of_type_Boolean))
          {
            paramEmotionPanelData = paramEmotionPanelData.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float);
            if ((paramEmotionPanelData == null) || (paramEmotionPanelData.getIntrinsicWidth() <= 0)) {
              break label545;
            }
            paramEmotionPanelData = ImageUtil.a(paramEmotionPanelData);
            if ((paramEmotionPanelData != null) && (paramEmotionPanelData.getWidth() > 0)) {
              localURLImageView.setImageBitmap(ImageUtil.a(paramEmotionPanelData));
            }
            label425:
            if (!((EmoticonPackage)localObject).valid)
            {
              localImageView1.setImageResource(2130841703);
              localImageView1.setVisibility(0);
            }
          }
          paramView.setVisibility(8);
          paramView.setTag(localEmoticon.epId);
          if (!this.jdField_b_of_type_JavaUtilList.contains(paramView)) {
            this.jdField_b_of_type_JavaUtilList.add(paramView);
          }
          if (((EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).a(localEmoticon.epId) < 0.0F) {
            break label556;
          }
        }
      }
      label545:
      label556:
      for (int m = 1;; m = 0)
      {
        if (m == 0) {
          break label562;
        }
        paramView.setVisibility(0);
        return;
        ((TextView)localObject).setText(str);
        break;
        ((TextView)localObject).setVisibility(8);
        break label294;
        localURLImageView.setTag(Boolean.valueOf(true));
        break label425;
      }
      label562:
      paramView.setVisibility(8);
      return;
    }
  }
  
  public View a(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int n = 0;
    paramViewGroup = (MagicFaceAdapter.MagicFaceViewHolder)paramViewHolder;
    int m;
    if (paramView == null)
    {
      paramView = EmotionPanelViewPool.a().a(this.e);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_b_of_type_JavaLangString, 2, "getEmotionView position = " + paramInt + ";view from infalter");
        }
        paramView = new EmotionPanelLinearLayout(this.jdField_a_of_type_AndroidContentContext);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        paramView.setOrientation(0);
        if (paramInt == 0) {
          paramView.setPadding(0, (int)(16.0F * this.jdField_a_of_type_Float), 0, 0);
        }
        for (;;)
        {
          m = 0;
          for (;;)
          {
            paramViewHolder = paramView;
            if (m >= this.c) {
              break;
            }
            paramViewHolder = b();
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.f / this.c, -1);
            paramViewHolder.setGravity(17);
            paramViewHolder.setVisibility(8);
            paramViewHolder.setLayoutParams(localLayoutParams);
            paramViewHolder.setFocusable(true);
            paramViewHolder.setFocusableInTouchMode(true);
            paramView.addView(paramViewHolder);
            m += 1;
          }
          paramView.setPadding(0, (int)(14.0F * this.jdField_a_of_type_Float), 0, 0);
        }
      }
      paramViewHolder = paramView;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "getEmotionView position = " + paramInt + ";view from cache");
        paramViewHolder = paramView;
      }
      ((EmotionPanelLinearLayout)paramViewHolder).setCallBack(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
      a(this.e, paramViewHolder);
      paramView = (ViewGroup)paramViewHolder;
      paramViewGroup.a = new RelativeLayout[this.c];
      m = 0;
      while (m < this.c)
      {
        paramViewGroup.a[m] = ((RelativeLayout)paramView.getChildAt(m));
        m += 1;
      }
      paramViewHolder.setTag(paramViewGroup);
      m = n;
    }
    for (;;)
    {
      if (m < this.c)
      {
        n = this.c * paramInt + m;
        if (n > this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          paramViewGroup.a[m].setTag(null);
          paramViewGroup.a[m].setVisibility(8);
        }
        for (;;)
        {
          m += 1;
          break;
          b(paramViewGroup.a[m], (EmotionPanelData)this.jdField_a_of_type_JavaUtilList.get(n));
        }
      }
      return paramViewHolder;
      paramViewHolder = paramView;
      m = n;
    }
  }
  
  public BaseEmotionAdapter.ViewHolder a()
  {
    return new MagicFaceAdapter.MagicFaceViewHolder();
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "packageDownloadEnd");
    }
    if (paramEmoticonPackage == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 101;
    localMessage.arg1 = paramInt;
    localMessage.obj = paramEmoticonPackage;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "refreshPanelData");
    }
    List localList = EmotionPanelDataBuilder.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.e, null);
    if (localList != null)
    {
      a(localList);
      super.notifyDataSetChanged();
    }
  }
  
  public void b(EmoticonPackage paramEmoticonPackage)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "packageDownloadStart");
    }
    if (paramEmoticonPackage == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 100;
    localMessage.obj = paramEmoticonPackage;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      paramMessage = a((EmoticonPackage)paramMessage.obj);
      if (paramMessage != null)
      {
        paramMessage.setVisibility(0);
        continue;
        ProgressBar localProgressBar = a((EmoticonPackage)paramMessage.obj);
        int m = paramMessage.arg1;
        if (localProgressBar != null)
        {
          localProgressBar.setVisibility(8);
          if (m == 0) {
            b();
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\MagicFaceAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */