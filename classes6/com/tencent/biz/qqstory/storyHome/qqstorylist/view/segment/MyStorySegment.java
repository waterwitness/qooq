package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.preload.storylist.FirstVideoManager;
import com.tencent.biz.qqstory.base.preload.storylist.IPreloadVideoSource;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.CircleTransformation;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryDownloadView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.TipIconView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import itz;
import iua;

public class MyStorySegment
  extends SegmentView
{
  public static final String a = "my_story";
  public long a;
  public MyStorys a;
  protected BaseViewHolder a;
  private String b;
  
  public MyStorySegment(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = "MyStorySegment";
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys = new MyStorys();
  }
  
  private void a(BaseViewHolder paramBaseViewHolder)
  {
    Object localObject1 = (ImageView)paramBaseViewHolder.a(2131302905);
    TextView localTextView = (TextView)paramBaseViewHolder.a(2131302910);
    ImageView localImageView = (ImageView)paramBaseViewHolder.a(2131302911);
    StoryDownloadView localStoryDownloadView = (StoryDownloadView)paramBaseViewHolder.a(2131302913);
    Object localObject2 = (ImageView)paramBaseViewHolder.a(2131302914);
    ProgressBar localProgressBar = (ProgressBar)paramBaseViewHolder.a(2131302906);
    int i;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a())
    {
      ((ImageView)localObject2).setVisibility(0);
      localObject2 = (TipIconView)paramBaseViewHolder.a(2131302909);
      i = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.b();
      switch (i)
      {
      default: 
        label132:
        if (i != 0)
        {
          if (FFmpeg.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a())
          {
            localStoryDownloadView.setVisibility(0);
            localStoryDownloadView.a();
          }
        }
        else
        {
          label162:
          localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys;
          if (!((FirstVideoManager)SuperManager.a(12)).a(IPreloadVideoSource.c, QQStoryContext.a().a())) {
            break label642;
          }
          i = 2;
          label197:
          ((MyStorys)localObject1).g = i;
          if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a() == 0) {
            this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.g = 2;
          }
          switch (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.g)
          {
          }
        }
        break;
      }
    }
    for (;;)
    {
      localImageView.setOnClickListener(paramBaseViewHolder);
      localStoryDownloadView.setOnClickListener(paramBaseViewHolder);
      paramBaseViewHolder.a().setOnClickListener(paramBaseViewHolder);
      if (paramBaseViewHolder.a() == null) {
        paramBaseViewHolder.a(new itz(this, paramBaseViewHolder));
      }
      localStoryDownloadView.setOnLongClickListener(new iua(this));
      return;
      ((ImageView)localObject2).setVisibility(8);
      break;
      ((ImageView)localObject1).setImageResource(2130841574);
      localTextView.setText("立即拍摄，和好友分享我的一天");
      localImageView.setVisibility(8);
      localStoryDownloadView.setVisibility(8);
      localProgressBar.setVisibility(8);
      ((TipIconView)localObject2).setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.g = 2;
      break label132;
      String str = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.b();
      if (!str.equals(paramBaseViewHolder.a(2131302905)))
      {
        UIUtils.a((ImageView)localObject1, str, 55, 97, new CircleTransformation());
        paramBaseViewHolder.a(2131302905, str);
      }
      localTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a(this.jdField_a_of_type_AndroidContentContext));
      localImageView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a()) {
        localImageView.setImageResource(2130841479);
      }
      for (;;)
      {
        if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a()) {
          break label494;
        }
        ((TipIconView)localObject2).setVisibility(0);
        ((TipIconView)localObject2).setCountdown(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a());
        break;
        localImageView.setImageResource(2130841474);
      }
      label494:
      ((TipIconView)localObject2).setVisibility(8);
      break label132;
      str = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.b();
      if (!str.equals(((ImageView)localObject1).getTag())) {
        UIUtils.a((ImageView)localObject1, str, 55, 97, new CircleTransformation());
      }
      localTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a(this.jdField_a_of_type_AndroidContentContext));
      localImageView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a()) {
        localImageView.setImageResource(2130841478);
      }
      for (;;)
      {
        ((TipIconView)localObject2).setVisibility(0);
        ((TipIconView)localObject2).setCountdown(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a());
        break;
        localImageView.setImageResource(2130841473);
      }
      localStoryDownloadView.b();
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a())
      {
        localStoryDownloadView.setVisibility(0);
        break label162;
      }
      localStoryDownloadView.setVisibility(8);
      break label162;
      label642:
      i = 0;
      break label197;
      SLog.b(this.b, "myStorys.mPreLoadState=" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.g);
      localProgressBar.setVisibility(8);
      continue;
      SLog.b(this.b, "myStorys.mPreLoadState=" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.g);
      localProgressBar.setVisibility(0);
      continue;
      localProgressBar.setVisibility(8);
    }
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    a(paramBaseViewHolder);
    return paramBaseViewHolder.a();
  }
  
  public BaseViewHolder a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder;
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder = new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904489, paramViewGroup, false));
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder;
  }
  
  public String a()
  {
    return "my_story";
  }
  
  public void a(Object paramObject)
  {
    try
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys = ((MyStorys)paramObject);
      return;
    }
    catch (Exception paramObject)
    {
      ((Exception)paramObject).printStackTrace();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    StoryDownloadView localStoryDownloadView;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder != null)
    {
      localStoryDownloadView = (StoryDownloadView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131302913);
      localStoryDownloadView.setVisibility(0);
      if (paramBoolean) {
        localStoryDownloadView.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a());
      }
    }
    else
    {
      return;
    }
    localStoryDownloadView.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a());
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder == null) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131302905);
    } while (localImageView == null);
    localImageView.setTag(null);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder != null) {
      ((StoryDownloadView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131302913)).d();
    }
  }
  
  public void w_()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder != null)
    {
      StoryDownloadView localStoryDownloadView = (StoryDownloadView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131302913);
      localStoryDownloadView.setVisibility(0);
      localStoryDownloadView.a();
    }
  }
  
  public void x_()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder != null)
    {
      if (this.jdField_a_of_type_Long > 0L) {
        StoryReportor.b("home_page", "preload_time", 0, 0, new String[] { String.valueOf(NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_Long), "1" });
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.g = 2;
      a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\view\segment\MyStorySegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */