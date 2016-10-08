package com.tencent.biz.qqstory.pgc.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.pgc.model.StoryCoverInfo;
import com.tencent.biz.qqstory.pgc.model.StoryNowTopicDes;
import com.tencent.biz.qqstory.pgc.model.StoryRoomDes;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.IVPluginEvtListener;
import com.tencent.mobileqq.intervideo.now.NowFromData;
import com.tencent.mobileqq.intervideo.now.NowProxy;
import com.tencent.mobileqq.intervideo.now.NowProxy.ListNameData;
import inx;
import java.util.ArrayList;
import java.util.List;

public class WebcastContentView
  extends BaseContentPagerView
{
  protected URLImageView a;
  IVPluginEvtListener jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginEvtListener;
  List jdField_a_of_type_JavaUtilList;
  protected QQAppInterface b;
  
  public WebcastContentView(Context paramContext, List paramList, Story paramStory, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, paramStory, paramOnClickListener);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginEvtListener = new inx(this);
    if (!TextUtils.isEmpty(paramStory.contentTips)) {
      this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseCoverView.setTips(paramStory.contentTips);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      this.b = ((QQAppInterface)BaseApplicationImpl.a().a());
      ((NowProxy)this.b.getManager(181)).b(this.jdField_a_of_type_AndroidContentContext);
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseCoverView.setTips("正在直播");
    }
  }
  
  private void j()
  {
    int j = 0;
    int k = 0;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().addFlags(2048);
    }
    NowProxy localNowProxy = (NowProxy)this.b.getManager(181);
    localNowProxy.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginEvtListener);
    long l2 = 0L;
    long l1;
    String str;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.roomDesList != null) && (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.roomDesList.size() > 0))
    {
      l1 = ((StoryRoomDes)this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.roomDesList.get(0)).id;
      str = "";
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      if (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.user != null)
      {
        localBundle.putString("nick", this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.user.nick);
        localBundle.putString("unionid", this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.user.unionId);
      }
      localBundle.putString("storyid", this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId);
      NowFromData localNowFromData = new NowFromData();
      localNowFromData.b = "story";
      localNowFromData.a = "story";
      ArrayList localArrayList = new ArrayList();
      int i = j;
      if (!TextUtils.isEmpty(str))
      {
        i = j;
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          j = 0;
          i = k;
          for (;;)
          {
            if (i < this.jdField_a_of_type_JavaUtilList.size())
            {
              Story localStory = (Story)this.jdField_a_of_type_JavaUtilList.get(i);
              k = j;
              if (localStory.nowTopicContent != null)
              {
                k = j;
                if (localStory.nowTopicContent.topic != null)
                {
                  localArrayList.add(localStory.nowTopicContent.topic);
                  k = j;
                  if (localStory.nowTopicContent.topic.equals(str)) {
                    k = i;
                  }
                }
              }
              i += 1;
              j = k;
              continue;
              if (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.nowTopicContent == null) {
                break label465;
              }
              l1 = l2;
              if (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.nowTopicContent.roomContentList != null)
              {
                l1 = l2;
                if (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.nowTopicContent.roomContentList.size() > 0) {
                  l1 = ((StoryRoomDes)this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.nowTopicContent.roomContentList.get(0)).id;
                }
              }
              str = this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.nowTopicContent.topic;
              break;
            }
          }
          i = j;
        }
      }
      localNowProxy.a(new NowProxy.ListNameData(localArrayList, i), l1, localNowFromData, 2, localBundle);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2130968589, 2130968589);
      return;
      label465:
      str = "";
      l1 = 0L;
    }
  }
  
  public View a()
  {
    Object localObject = null;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.isNowContent()) {
      localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904437, this, false);
    }
    while (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.recommendCoverInfo == null) {
      return (View)localObject;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
    localObject = URLDrawable.getDrawable(ThumbnailUrlHelper.d(getContext(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.recommendCoverInfo.coverUrl), (URLDrawable.URLDrawableOptions)localObject);
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    return this.jdField_a_of_type_ComTencentImageURLImageView;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (paramInt == 1) {
      j();
    }
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 0;
  }
  
  public boolean b(int paramInt)
  {
    return false;
  }
  
  public void c()
  {
    super.c();
  }
  
  public void d()
  {
    super.d();
    ((NowProxy)this.b.getManager(181)).b(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginEvtListener);
  }
  
  public void e()
  {
    super.e();
    if (this.j == 1) {
      setCurrentPage(0, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\view\WebcastContentView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */