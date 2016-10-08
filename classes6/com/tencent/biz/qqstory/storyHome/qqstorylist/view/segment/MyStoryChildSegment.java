package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.CircleTransformation;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.TipIconView;
import com.tencent.biz.qqstory.support.ImageDownloader.FILE;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ity;
import java.util.ArrayList;

public class MyStoryChildSegment
  extends SegmentView
{
  protected static final String a = "Q.qqstory.home.my.MyStoryChildSegment";
  public static final String b = "my_story_child";
  public MyStorys a;
  
  public MyStoryChildSegment(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys = new MyStorys();
  }
  
  private void a(BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    ImageView localImageView2 = (ImageView)paramBaseViewHolder.a(2131302915);
    TextView localTextView4 = (TextView)paramBaseViewHolder.a(2131302920);
    TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131302919);
    ImageView localImageView1 = (ImageView)paramBaseViewHolder.a(2131302924);
    TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131302923);
    TextView localTextView3 = (TextView)paramBaseViewHolder.a(2131302922);
    TextView localTextView5 = (TextView)paramBaseViewHolder.a(2131302921);
    TipIconView localTipIconView = (TipIconView)paramBaseViewHolder.a(2131302918);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys == null) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a() == null))
    {
      SLog.e("Q.qqstory.home.my.MyStoryChildSegment", "myStorys is null!");
      return;
    }
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().get(paramInt);
    String str;
    if (StoryListUtils.b(localStoryVideoItem.mVideoLocalThumbnailPath))
    {
      str = ImageDownloader.FILE.a(localStoryVideoItem.mVideoLocalThumbnailPath);
      label149:
      if (!str.equals(localImageView2.getTag())) {
        UIUtils.b(localImageView2, str, 45, 80, new CircleTransformation());
      }
      localTextView1.setMaxWidth(UIUtils.b(this.jdField_a_of_type_AndroidContentContext, 180.0F));
    }
    switch (localStoryVideoItem.mUploadStatus)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 4: 
    case 3: 
    case 6: 
      for (;;)
      {
        paramBaseViewHolder.a(paramInt);
        localImageView1.setOnClickListener(paramBaseViewHolder);
        localTextView2.setOnClickListener(paramBaseViewHolder);
        paramBaseViewHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys);
        paramBaseViewHolder.a().setOnClickListener(paramBaseViewHolder);
        if (paramBaseViewHolder.a() != null) {
          break;
        }
        paramBaseViewHolder.a(new ity(this));
        return;
        if (localStoryVideoItem.mVideoThumbnailUrl == null)
        {
          SLog.e("Q.qqstory.home.my.MyStoryChildSegment", "mVideoThumbnailUrl is null! vid=" + localStoryVideoItem.mVid);
          localImageView2.setImageResource(2130841574);
          return;
        }
        str = ThumbnailUrlHelper.a(localStoryVideoItem.mVideoThumbnailUrl);
        break label149;
        localTextView5.setVisibility(0);
        localTextView5.setText("等待中...");
        localTextView4.setVisibility(8);
        localImageView1.setVisibility(8);
        localTextView2.setVisibility(8);
        localTextView1.setVisibility(8);
        localTextView3.setVisibility(8);
        localTipIconView.setVisibility(8);
        continue;
        localTextView5.setVisibility(0);
        localTextView5.setText("日迹上传中...");
        localTextView4.setVisibility(8);
        localImageView1.setVisibility(8);
        localTextView2.setVisibility(8);
        localTextView1.setVisibility(8);
        localTextView3.setVisibility(8);
        localTipIconView.setVisibility(8);
        continue;
        localTextView4.setVisibility(8);
        localTextView3.setVisibility(0);
        localImageView1.setVisibility(0);
        localTextView2.setVisibility(8);
        localTextView1.setVisibility(8);
        localTipIconView.setVisibility(8);
        localTextView5.setVisibility(8);
      }
    }
    localTextView4.setVisibility(0);
    localTextView5.setVisibility(8);
    localTextView4.setText(StoryListUtils.a(localStoryVideoItem.mCreateTime));
    if (localStoryVideoItem.mViewCount > 0)
    {
      localTextView2.setVisibility(0);
      if (localStoryVideoItem.mViewCount > 100000)
      {
        str = "100000+人浏览";
        label568:
        localTextView2.setText(str);
        label574:
        if (TextUtils.isEmpty(localStoryVideoItem.mDoodleText)) {
          break label675;
        }
        localTextView1.setText(localStoryVideoItem.mDoodleText);
        localTextView1.setVisibility(0);
      }
    }
    for (;;)
    {
      localImageView1.setVisibility(8);
      localTextView3.setVisibility(8);
      localTipIconView.setVisibility(0);
      localTipIconView.setCountdown(StoryListUtils.a(localStoryVideoItem.mCreateTime));
      break;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131366432, new Object[] { Integer.valueOf(localStoryVideoItem.mViewCount) });
      break label568;
      localTextView2.setVisibility(8);
      break label574;
      label675:
      if (!TextUtils.isEmpty(localStoryVideoItem.mLabel))
      {
        localTextView1.setText(localStoryVideoItem.mLabel);
        localTextView1.setVisibility(0);
      }
      else
      {
        localTextView1.setVisibility(8);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a();
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    a(paramBaseViewHolder, paramInt);
    return paramBaseViewHolder.a();
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    return new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904490, paramViewGroup, false));
  }
  
  public String a()
  {
    return "my_story_child";
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
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\view\segment\MyStoryChildSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */