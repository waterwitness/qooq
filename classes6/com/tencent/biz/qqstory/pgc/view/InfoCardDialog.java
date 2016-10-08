package com.tencent.biz.qqstory.pgc.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.pgc.QQStoryContentActivity;
import com.tencent.biz.qqstory.pgc.ShareUtil;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.InfoCardOnDismissListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import imh;
import imi;
import java.util.ArrayList;

public class InfoCardDialog
  extends Dialog
  implements DialogInterface.OnDismissListener, View.OnClickListener
{
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static boolean g;
  public int a;
  Context jdField_a_of_type_AndroidContentContext;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  QQStoryHandler jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler;
  protected QQStoryObserver a;
  public UserInfo a;
  public InfoCardOnDismissListener a;
  URLDrawable jdField_a_of_type_ComTencentImageURLDrawable = null;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new imh(this);
  public QQAppInterface a;
  public EllipsizingTextView a;
  String jdField_a_of_type_JavaLangString;
  public boolean a;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public LinearLayout b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  public boolean b;
  public boolean c = true;
  public boolean d = true;
  public boolean e;
  public boolean f;
  
  public InfoCardDialog(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this(paramContext, paramQQAppInterface, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public InfoCardDialog(Context paramContext, QQAppInterface paramQQAppInterface, InfoCardOnDismissListener paramInfoCardOnDismissListener)
  {
    super(paramContext);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new imi(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewInfoCardOnDismissListener = paramInfoCardOnDismissListener;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if (paramInt == 1)
      {
        localLayoutParams.width = DisplayUtil.a(this.jdField_a_of_type_AndroidWidgetImageView.getContext(), 18.0F);
        localLayoutParams.height = DisplayUtil.a(this.jdField_a_of_type_AndroidWidgetImageView.getContext(), 16.0F);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841412);
        this.jdField_b_of_type_AndroidWidgetTextView.setText("已关注");
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-8947849);
        return;
        if (paramInt == 0)
        {
          localLayoutParams.width = DisplayUtil.a(this.jdField_a_of_type_AndroidWidgetImageView.getContext(), 14.0F);
          localLayoutParams.height = DisplayUtil.a(this.jdField_a_of_type_AndroidWidgetImageView.getContext(), 16.0F);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841413);
          this.jdField_b_of_type_AndroidWidgetTextView.setText("已订阅");
        }
      }
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    if (paramInt == 1) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("关注");
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-15550475);
      return;
      if (paramInt == 0) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText("订阅");
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131300661));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131302794));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296829));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)findViewById(2131297013));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131302795));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131296790));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131296792));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302796));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131297633);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131297842));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
  }
  
  public void a(UserInfo paramUserInfo)
  {
    if (paramUserInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo = paramUserInfo;
    Object localObject2;
    if ((paramUserInfo.type == 1) && (!TextUtils.isEmpty(paramUserInfo.authTypeIcon)))
    {
      this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      try
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramUserInfo.authTypeIcon, (URLDrawable.URLDrawableOptions)localObject1);
        if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 2) {
          this.jdField_a_of_type_ComTencentImageURLDrawable.restartDownload();
        }
        this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          Object localObject1;
          if (QLog.isColorLevel()) {
            QLog.d("InfoCardDialog", 2, QLog.getStackTraceString(localException1));
          }
        }
      }
      if (TextUtils.isEmpty(paramUserInfo.headUrl)) {
        break label824;
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      localObject1 = (BitmapDrawable)ImageUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.type);
      localObject2 = (BitmapDrawable)ImageUtil.a();
      if (!this.f) {
        break label513;
      }
      localObject1 = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, Long.toString(paramUserInfo.uid), 3, (Drawable)localObject2, (Drawable)localObject2);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
      this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundResource(2130841410);
      label164:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramUserInfo.nick);
      if (!this.f) {
        break label836;
      }
      localObject1 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(String.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.uid));
      if (localObject1 == null) {
        break label918;
      }
      localObject1 = ((ExtensionInfo)localObject1).getRichStatus().getPlainText();
    }
    for (;;)
    {
      label220:
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(3);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText((CharSequence)localObject1);
      if (localObject1 != null)
      {
        int i = (int)this.jdField_a_of_type_AndroidGraphicsPaint.measureText((String)localObject1, 0, ((String)localObject1).length());
        int j = getContext().getResources().getDisplayMetrics().widthPixels;
        int k = DisplayUtil.a(getContext(), 137.0F);
        localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.getLayoutParams();
        if (i >= j - k) {
          ((RelativeLayout.LayoutParams)localObject1).addRule(14, 0);
        }
      }
      else
      {
        label311:
        if (!this.f) {
          break label863;
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        localObject1 = (TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131297843);
        localObject2 = (TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131297844);
        ((TextView)localObject1).setOnClickListener(this);
        ((TextView)localObject2).setOnClickListener(this);
        if (this.jdField_a_of_type_Int != 6) {
          break label853;
        }
        ((TextView)localObject1).setText("不让他看");
        label389:
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838454);
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
      for (;;)
      {
        if (paramUserInfo.type != 2) {
          break label901;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText("立即观看");
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-15550475);
        return;
        this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
        break;
        for (;;)
        {
          label513:
          URLDrawable.URLDrawableOptions localURLDrawableOptions;
          try
          {
            localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            if (paramUserInfo.type != 1) {
              break label753;
            }
            localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject2);
            localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
            localURLDrawableOptions.mRequestHeight = 140;
            localURLDrawableOptions.mRequestWidth = 140;
            String str2 = ThumbnailUrlHelper.a(paramUserInfo.headUrl);
            Object localObject3 = URLDrawable.getDrawable(ThumbnailUrlHelper.b(paramUserInfo.headUrl), localURLDrawableOptions);
            if ((((URLDrawable)localObject3).getStatus() != 1) && (((URLDrawable)localObject3).getStatus() != 0)) {
              ((URLDrawable)localObject3).startDownload();
            }
            ((URLDrawable)localObject3).startDownload();
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            if (paramUserInfo.type != 1) {
              break label768;
            }
            localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject2);
            localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
            localURLDrawableOptions.mRequestHeight = 140;
            localURLDrawableOptions.mRequestWidth = 140;
            this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(str2, (URLDrawable.URLDrawableOptions)localObject3);
            if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 2) {
              this.jdField_a_of_type_ComTencentImageURLDrawable.restartDownload();
            }
            if (paramUserInfo.type != 1) {
              break label783;
            }
            this.jdField_a_of_type_ComTencentImageURLDrawable.setTag(URLDrawableDecodeHandler.a(140, 140));
            this.jdField_a_of_type_ComTencentImageURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.a);
            this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundResource(2130841410);
            this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
          }
          catch (Exception localException2) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("InfoCardDialog", 2, QLog.getStackTraceString(localException2));
          break;
          label753:
          localURLDrawableOptions.mFailedDrawable = localException2;
          localURLDrawableOptions.mLoadingDrawable = localException2;
          continue;
          label768:
          localURLDrawableOptions.mFailedDrawable = localException2;
          localURLDrawableOptions.mLoadingDrawable = localException2;
          continue;
          label783:
          this.jdField_a_of_type_ComTencentImageURLDrawable.setTag(URLDrawableDecodeHandler.a(140, 140, 16));
          this.jdField_a_of_type_ComTencentImageURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.e);
          this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundResource(2130841411);
        }
        label824:
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        break label164;
        label836:
        str1 = paramUserInfo.desc;
        break label220;
        str1.addRule(14);
        break label311;
        label853:
        str1.setText("屏蔽");
        break label389;
        label863:
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841526);
      }
      label901:
      this.jdField_b_of_type_Boolean = paramUserInfo.isSubscribe;
      a(paramUserInfo.type);
      return;
      label918:
      String str1 = "";
    }
  }
  
  public void a(UserInfo paramUserInfo, int paramInt)
  {
    a(paramUserInfo, true, paramInt, false, null);
  }
  
  public void a(UserInfo paramUserInfo, boolean paramBoolean, int paramInt)
  {
    a(paramUserInfo, paramBoolean, paramInt, false, null);
  }
  
  public void a(UserInfo paramUserInfo, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    a(paramUserInfo, paramBoolean1, paramInt, paramBoolean2, null);
  }
  
  public void a(UserInfo paramUserInfo, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.e = paramBoolean1;
    this.f = paramBoolean2;
    this.jdField_a_of_type_JavaLangString = paramString;
    Window localWindow = super.getWindow();
    localWindow.setGravity(16);
    localWindow.setWindowAnimations(2131558675);
    if ((this.f) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(String.valueOf(paramUserInfo.uid)))) {}
    while ((paramUserInfo == null) || ((paramUserInfo.type != 0) && (paramUserInfo.type != 1) && (paramUserInfo.type != 2))) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo = paramUserInfo;
    this.jdField_a_of_type_Boolean = paramUserInfo.isSubscribe;
    if (((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (!((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing())) {
      show();
    }
    if (this.f)
    {
      StoryReportor.a("mini_data", "exp", 0, 0, new String[] { "", "", "", paramString });
      return;
    }
    StoryReportor.a("data_card", "exp", paramInt, paramUserInfo.type, new String[] { paramUserInfo.unionId });
  }
  
  public void dismiss()
  {
    boolean bool = false;
    super.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    g = false;
    if ((!this.c) && (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo != null))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(String.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.uid));
      StoryListUtils.a(localArrayList);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewInfoCardOnDismissListener != null) {
      if (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo != null) {
        break label123;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewInfoCardOnDismissListener.a(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo, bool);
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.isSubscribe;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      return;
      label123:
      if (this.jdField_a_of_type_Boolean != this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.isSubscribe) {
        bool = true;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Context localContext;
    if ((getContext() instanceof ContextThemeWrapper))
    {
      localContext = ((ContextThemeWrapper)getContext()).getBaseContext();
      switch (paramView.getId())
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localContext = getContext();
            break;
            if ((this.f) && ((localContext instanceof StoryPlayVideoActivity)) && (this.jdField_a_of_type_JavaLangString != null))
            {
              ((StoryPlayVideoActivity)localContext).a(null, this.jdField_a_of_type_JavaLangString, this);
              hide();
              StoryReportor.a("mini_data", "clk_report", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_JavaLangString });
              return;
            }
          } while (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo == null);
          StoryReportor.a("data_card", "share", this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.type, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.unionId });
          new ShareUtil(localContext).a(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo, this);
          hide();
          return;
        } while (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo == null);
        if (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.type == 2)
        {
          StoryReportor.a("data_card", "follow", this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.type, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.unionId, "", "5" });
          QQStoryContentActivity.a(localContext, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.type, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.unionId, this.jdField_a_of_type_Int);
          dismiss();
          return;
        }
        if (NetworkUtil.h(getContext()))
        {
          if (this.jdField_b_of_type_Boolean) {}
          for (int i = 1;; i = 0)
          {
            int k = i + 1;
            int j = k;
            if (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.type == 1) {
              j = k + 2;
            }
            StoryReportor.a("data_card", "follow", this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.type, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.unionId, "", "" + j });
            this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.type, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.unionId, i, 2);
            paramView = localContext.getResources().getDrawable(2130838321);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
            ((Animatable)paramView).start();
            this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            return;
          }
        }
        ToastUtil.a().a("当前网络不可用，请检查你的网络设置");
        return;
        dismiss();
        return;
      } while (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo == null);
      if (NetworkUtil.h(getContext()))
      {
        paramView = new ArrayList();
        paramView.add(String.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.uid));
        if (this.jdField_a_of_type_Int == 6) {
          if (this.d) {
            this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(paramView, true, true);
          }
        }
        for (;;)
        {
          StoryReportor.a("mini_data", "clk_block", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_JavaLangString });
          return;
          this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(paramView, true, false);
          continue;
          if (this.c) {
            this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(paramView, false, true);
          } else {
            this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(paramView, false, false);
          }
        }
      }
      ToastUtil.a().a("当前网络不可用，请检查你的网络设置");
      return;
    } while (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo == null);
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ChatActivity.class);
    paramView.putExtra("uin", String.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.uid));
    paramView.putExtra("uintype", 0);
    paramView.putExtra("uinname", this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.nick);
    paramView.putExtra("leftViewText", "日迹");
    paramView.putExtra("selfSet_leftViewText", "日迹");
    localContext.startActivity(paramView);
    dismiss();
    StoryReportor.a("mini_data", "send_msg", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_JavaLangString });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.requestWindowFeature(1);
    super.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    super.onCreate(paramBundle);
    super.setContentView(2130904455);
    super.setCanceledOnTouchOutside(true);
    int i = getContext().getResources().getDisplayMetrics().widthPixels;
    getWindow().getAttributes().width = (i - DisplayUtil.a(getContext(), 79.0F));
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    dismiss();
  }
  
  protected void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler = ((QQStoryHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if ((this.e) && (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.type != 2)) {
      this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.type, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.unionId);
    }
    if (this.f)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(String.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.uid));
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).b(new String[] { String.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.uid) });
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(DisplayUtil.a(getContext(), 14.0F));
    this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
    a();
    a(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo);
  }
  
  public void show()
  {
    if (!g)
    {
      super.show();
      g = true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\view\InfoCardDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */