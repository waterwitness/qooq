package com.tencent.biz.qqstory.pgc.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.pgc.QQStoryContentActivity;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.pgc.model.StoryCoverInfo;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.biz.qqstory.view.widget.VerticalPagerView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import ilk;
import ill;
import ilm;
import ilo;
import ilq;
import ilr;
import ilt;
import ilu;

public abstract class BaseContentPagerView
  extends VerticalPagerView
{
  public static final String a;
  public int a;
  public Context a;
  protected View a;
  public Button a;
  public ImageView a;
  public QQStoryHandler a;
  private QQStoryObserver a;
  public Story a;
  public BaseCoverView a;
  public QQAppInterface a;
  public boolean a;
  public View b;
  public boolean b;
  public boolean c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = BaseContentPagerView.class.getName();
  }
  
  public BaseContentPagerView(Context paramContext, Story paramStory, View.OnClickListener paramOnClickListener)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new ilu(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory = paramStory;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQStoryBaseActivity)paramContext).app;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo == null) || (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.type != 2)) {
      this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseCoverView = new PictureCoverView(paramContext, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory);
    }
    for (;;)
    {
      super.addView(this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseCoverView);
      this.jdField_a_of_type_AndroidViewView = a();
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297585));
        this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131302847);
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131302848));
        super.addView(this.jdField_a_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseCoverView.setOnTipsClickListener(new ilk(this));
      this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseCoverView.setOnClickListener(new ill(this, paramOnClickListener));
      paramContext = this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.user;
      if ((paramContext == null) || ((!TextUtils.isEmpty(paramContext.logoURL)) && (this.jdField_a_of_type_AndroidWidgetImageView != null))) {}
      try
      {
        paramOnClickListener = URLDrawable.URLDrawableOptions.obtain();
        paramStory = getContext().getResources().getDrawable(2130838321);
        paramOnClickListener.mLoadingDrawable = paramStory;
        paramOnClickListener.mFailedDrawable = paramStory;
        paramOnClickListener.mUseAutoScaleParams = false;
        paramStory = ThumbnailUrlHelper.a(paramContext.logoURL);
        paramOnClickListener = URLDrawable.getDrawable(paramStory, paramOnClickListener);
        if (paramOnClickListener.getStatus() == 1)
        {
          int i = DisplayUtil.a(getContext(), 19.0F);
          int j = paramOnClickListener.getIntrinsicWidth() * i / paramOnClickListener.getIntrinsicHeight();
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
          localLayoutParams.width = j;
          localLayoutParams.height = i;
          this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramOnClickListener);
        paramOnClickListener.setURLDrawableListener(new ilm(this, paramStory));
      }
      catch (Exception paramStory)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, QLog.getStackTraceString(paramStory));
          }
        }
      }
      if (this.b != null)
      {
        this.b.setBackgroundDrawable(a(paramContext.themeColor));
        this.b.setOnClickListener(new ilo(this));
        this.b.setOnTouchListener(new ilq(this, paramContext));
      }
      if (this.jdField_a_of_type_AndroidWidgetButton != null)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(b(paramContext.themeColor));
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ilr(this, paramContext));
        this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(new ilt(this, paramContext));
      }
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseCoverView = new VideoCoverView(paramContext, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory, this);
      setEnableChangePage(false);
    }
  }
  
  public Drawable a(int paramInt)
  {
    Drawable localDrawable = getResources().getDrawable(2130841516);
    if (Build.VERSION.SDK_INT <= 10) {}
    for (localDrawable = localDrawable.getConstantState().newDrawable(getResources());; localDrawable = localDrawable.getConstantState().newDrawable(getResources()).mutate())
    {
      localDrawable.setColorFilter(new LightingColorFilter(-16777216, paramInt));
      localDrawable.setAlpha(paramInt >>> 24);
      return localDrawable;
    }
  }
  
  public abstract View a();
  
  public Story a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "BaseContentPagerView: onPagerChanged");
    }
    if (paramInt != 0)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseCoverView.d();
      StoryReportor.a("play_page", "down", ((QQStoryContentActivity)getContext()).g, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.contentType, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, "", "" });
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseCoverView.c();
    StoryReportor.a("play_page", "up", ((QQStoryContentActivity)getContext()).g, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.contentType, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, "", "" });
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseCoverView.a(paramBoolean);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory == null) || (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.user == null)) {
      return false;
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      MessageForQQStory localMessageForQQStory = new MessageForQQStory();
      Object localObject2 = "";
      Object localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo != null)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.screenshotUrl)) {
          break label496;
        }
        localMessageForQQStory.coverImgUrl = this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.screenshotUrl;
        localObject1 = "screenshotUrl";
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (TextUtils.isEmpty(localMessageForQQStory.coverImgUrl))
        {
          localObject2 = localObject1;
          if (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.recommendCoverInfo != null)
          {
            localObject2 = localObject1;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.recommendCoverInfo.coverUrl))
            {
              localMessageForQQStory.coverImgUrl = this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.recommendCoverInfo.coverUrl;
              localObject2 = "recommendCoverInfo.coverUrl";
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.share", 2, "onShareButtonClick, coverType=" + (String)localObject2);
        }
        localMessageForQQStory.logoImgUrl = this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.user.logoURL;
        localMessageForQQStory.briefBgColor = this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.user.themeColor;
        localMessageForQQStory.brief = this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.title;
        localMessageForQQStory.srcName = "日迹";
        localMessageForQQStory.srcAction = "mqqapi://qstory/opendiscovery?src_type=internal&version=1&key_from=3";
        localMessageForQQStory.msgAction = (String.format("mqqapi://qstory/opencontent?storyid=%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId + "" }) + "&src_type=internal&version=1&" + "contentType" + "=" + this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.contentType + "&" + "unionid" + "=" + this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId() + "&" + "sharefromtype" + "=" + 10);
        localMessageForQQStory.authorName = this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.user.nick;
        TroopShareUtility.a((Activity)this.jdField_a_of_type_AndroidContentContext, localMessageForQQStory, 1001);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.tag_story_content_share", 2, "onShareButtonClick==>" + localMessageForQQStory.toString());
        }
        StoryReportor.a("play_page_share", "share", ((QQStoryContentActivity)getContext()).g, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.contentType, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, "", "" });
        return true;
        label496:
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.coverUrl))
        {
          localMessageForQQStory.coverImgUrl = this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.coverUrl;
          localObject1 = "coverUrl";
        }
      }
    }
    return false;
  }
  
  public Drawable b(int paramInt)
  {
    Drawable localDrawable = getResources().getDrawable(2130841517);
    if (Build.VERSION.SDK_INT <= 10) {}
    for (localDrawable = localDrawable.getConstantState().newDrawable(getResources());; localDrawable = localDrawable.getConstantState().newDrawable(getResources()).mutate())
    {
      localDrawable.setColorFilter(new LightingColorFilter(-16777216, paramInt));
      localDrawable.setAlpha(paramInt >>> 24);
      return localDrawable;
    }
  }
  
  public void b() {}
  
  public boolean b()
  {
    return true;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseCoverView.a();
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler = ((QQStoryHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    UserInfo localUserInfo = this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.user;
    if ((this.jdField_a_of_type_AndroidWidgetButton != null) && (localUserInfo != null)) {
      this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(localUserInfo.type, localUserInfo.unionId);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseCoverView.b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
  }
  
  public void e()
  {
    if (this.j == 0) {
      this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseCoverView.c();
    }
  }
  
  public void f()
  {
    if (this.j == 0) {
      this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseCoverView.d();
    }
  }
  
  public void g() {}
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseCoverView.g();
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseCoverView.h();
  }
  
  public void setCoverComeFrom(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseCoverView.jdField_a_of_type_Int = paramInt;
  }
  
  public void setIndex(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseCoverView.setIndex(paramInt1, paramInt2);
  }
  
  public void setOnCloseClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseCoverView.setOnCloseClickListener(paramOnClickListener);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\view\BaseContentPagerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */