import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.base.preload.pgc.PGCPlayingListPreloader;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.pgc.QQStoryContentActivity;
import com.tencent.biz.qqstory.pgc.QQStoryContentActivity.CoverClick;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.pgc.view.BaseContentPagerView;
import com.tencent.biz.qqstory.pgc.view.ContentEmptyView;
import com.tencent.biz.qqstory.pgc.view.CoverOnlyContentView;
import com.tencent.biz.qqstory.pgc.view.PostContentView;
import com.tencent.biz.qqstory.pgc.view.VideoContentView;
import com.tencent.biz.qqstory.pgc.view.WebcastContentView;
import com.tencent.biz.qqstory.view.StoryNewGuideDialog;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;

public class ikf
  extends QQStoryObserver
{
  public ikf(QQStoryContentActivity paramQQStoryContentActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, int paramInt, Story paramStory)
  {
    this.a.d = System.currentTimeMillis();
    Object localObject;
    if (paramBoolean)
    {
      if (!this.a.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        return;
      }
      if ((paramInt == 0) && (paramStory != null))
      {
        localObject = new ArrayList(1);
        ((List)localObject).add(paramStory);
        if (paramStory.contentType == 2)
        {
          localObject = new PostContentView(this.a, paramStory, new QQStoryContentActivity.CoverClick(this.a, 0, paramStory), false);
          ((BaseContentPagerView)localObject).setIndex(0, 1);
          ((BaseContentPagerView)localObject).setCoverComeFrom(this.a.g);
          ((BaseContentPagerView)localObject).c();
          ((BaseContentPagerView)localObject).setOnCloseClickListener(new ikj(this, paramStory));
          this.a.jdField_a_of_type_JavaUtilArrayList.add(localObject);
          this.a.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.a.jdField_a_of_type_ComTencentBizQqstoryPgcQQStoryContentActivity$ContentPagerAdaper);
          this.a.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(this.a);
          this.a.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0);
          this.a.h = 0;
          this.a.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOffscreenPageLimit(3);
          this.a.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(0);
          paramStory = paramStory.user;
        }
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      return;
      if (paramStory.contentType == 1)
      {
        localObject = new VideoContentView(this.a, paramStory, new QQStoryContentActivity.CoverClick(this.a, 0, paramStory));
        break;
      }
      if (paramStory.contentType == 4)
      {
        localObject = new WebcastContentView(this.a, (List)localObject, paramStory, new QQStoryContentActivity.CoverClick(this.a, 0, paramStory));
        break;
      }
      if (paramStory.contentType == 3)
      {
        localObject = new WebcastContentView(this.a, (List)localObject, paramStory, new QQStoryContentActivity.CoverClick(this.a, 0, paramStory));
        break;
      }
      if (paramStory.contentType == 5)
      {
        localObject = new PostContentView(this.a, paramStory, new QQStoryContentActivity.CoverClick(this.a, 0, paramStory), true);
        break;
      }
      localObject = new CoverOnlyContentView(this.a, paramStory, new QQStoryContentActivity.CoverClick(this.a, 0, paramStory));
      break;
      this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramStory = "当前网络不可用，请检查你的网络设置\r\n点击重试";
      if ((paramInt == 10100) || (paramInt == 10101))
      {
        paramStory = "该日迹已删除";
        this.a.jdField_b_of_type_AndroidViewView.setOnClickListener(new ikk(this));
      }
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramStory);
      continue;
      this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void a(boolean paramBoolean, UserInfo paramUserInfo)
  {
    if ((!paramBoolean) || (this.a.isFinishing())) {}
    int i;
    do
    {
      return;
      this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo = paramUserInfo;
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewContentEmptyView != null)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewContentEmptyView.setBackgroundColor(paramUserInfo.themeColor);
        this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewContentEmptyView.setNickname(paramUserInfo);
      }
      i = (int)(System.currentTimeMillis() - this.a.jdField_a_of_type_Long);
    } while ((!this.a.jdField_e_of_type_Boolean) || (i >= 3000) || (this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog != null));
    com.tencent.biz.qqstory.pgc.view.InfoCardDialog.g = false;
    this.a.a(3);
  }
  
  public void a(boolean paramBoolean1, List paramList, boolean paramBoolean2, String paramString)
  {
    this.a.d = System.currentTimeMillis();
    int i;
    int k;
    if (paramBoolean1)
    {
      if (!this.a.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        return;
      }
      paramString = ((QQStoryManager)this.a.app.getManager(180)).a(this.a.jdField_e_of_type_JavaLangString);
      Object localObject;
      if (paramString != null) {
        localObject = paramString[0];
      }
      for (;;)
      {
        if (paramString != null) {}
        try
        {
          for (i = Integer.parseInt(paramString[1]);; i = 0)
          {
            k = -1;
            j = 0;
            for (;;)
            {
              if (j >= paramList.size()) {
                break label500;
              }
              localStory = (Story)paramList.get(j);
              localStory.albumId = this.a.jdField_e_of_type_JavaLangString;
              localStory.userType = this.a.jdField_b_of_type_Int;
              if (localStory.contentType != 2) {
                break;
              }
              paramString = new PostContentView(this.a, localStory, new QQStoryContentActivity.CoverClick(this.a, j, localStory), false);
              paramString.setIndex(j, paramList.size());
              paramString.setCoverComeFrom(this.a.g);
              paramString.c();
              paramString.setOnCloseClickListener(new ikg(this, localStory));
              this.a.jdField_a_of_type_JavaUtilArrayList.add(paramString);
              int m = k;
              if (localObject != null)
              {
                m = k;
                if (((String)localObject).equals(localStory.storyId)) {
                  m = j;
                }
              }
              j += 1;
              k = m;
            }
            localObject = null;
            break;
          }
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            int j;
            Story localStory;
            i = -1;
            continue;
            if (localStory.contentType == 1) {
              paramString = new VideoContentView(this.a, localStory, new QQStoryContentActivity.CoverClick(this.a, j, localStory));
            } else if (localStory.contentType == 4) {
              paramString = new WebcastContentView(this.a, paramList, localStory, new QQStoryContentActivity.CoverClick(this.a, j, localStory));
            } else if (localStory.contentType == 3) {
              paramString = new WebcastContentView(this.a, paramList, localStory, new QQStoryContentActivity.CoverClick(this.a, j, localStory));
            } else if (localStory.contentType == 5) {
              paramString = new PostContentView(this.a, localStory, new QQStoryContentActivity.CoverClick(this.a, j, localStory), true);
            } else {
              paramString = new CoverOnlyContentView(this.a, localStory, new QQStoryContentActivity.CoverClick(this.a, j, localStory));
            }
          }
        }
      }
      label500:
      if (k == -1) {
        if (i != -1) {
          if (i >= this.a.jdField_a_of_type_JavaUtilArrayList.size()) {}
        }
      }
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 1)
      {
        paramString = (StoryConfigManager)SuperManager.a(10);
        if (!paramString.a())
        {
          if (this.a.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog == null) {
            this.a.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog = new StoryNewGuideDialog(this.a);
          }
          this.a.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog.a("左右滑动可切换日迹");
          this.a.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog.show();
          paramString.a(true);
          ((BaseContentPagerView)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.h)).h();
          this.a.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog.setOnDismissListener(new ikh(this));
        }
      }
      if (!this.a.jdField_a_of_type_JavaUtilArrayList.isEmpty())
      {
        this.a.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.a.jdField_a_of_type_ComTencentBizQqstoryPgcQQStoryContentActivity$ContentPagerAdaper);
        this.a.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(this.a);
        this.a.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(i);
        this.a.h = i;
        this.a.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOffscreenPageLimit(3);
        this.a.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(0);
        paramString = ((BaseContentPagerView)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.h)).a().user;
        label772:
        this.a.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPgcPGCPlayingListPreloader.b(paramList);
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
        return;
        i = 0;
        break;
        i = 0;
        break;
        if (k != this.a.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
          break label969;
        }
        i = 0;
        break;
        this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewContentEmptyView = new ContentEmptyView(this.a, this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo);
        this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewContentEmptyView.setOnCloseClickListener(new iki(this));
        this.a.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewContentEmptyView, -1, -1);
        this.a.jdField_b_of_type_AndroidViewView.setVisibility(8);
        if (this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo == null) {
          break label772;
        }
        this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewContentEmptyView.setNickname(this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo);
        this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewContentEmptyView.setBackgroundColor(this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.themeColor);
        break label772;
        this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      label969:
      i = k;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ikf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */