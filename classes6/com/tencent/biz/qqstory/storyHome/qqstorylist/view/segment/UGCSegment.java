package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.HotTopicItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.UGCLayout;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.UGCThemeLayout;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import iuh;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class UGCSegment
  extends SegmentView
{
  public static final String a = "UGCSegment";
  public static final String b = "UGCSegment";
  protected int a;
  protected View a;
  protected ViewGroup a;
  protected BaseViewHolder a;
  public ArrayList a;
  protected boolean a;
  protected BaseViewHolder[] a;
  
  public UGCSegment(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = false;
    this.jdField_a_of_type_ArrayOfComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder = new BaseViewHolder[6];
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(6);
  }
  
  private void a(UGCThemeLayout paramUGCThemeLayout)
  {
    ImageView localImageView = (ImageView)paramUGCThemeLayout.findViewById(2131302959);
    ViewGroup.LayoutParams localLayoutParams = localImageView.getLayoutParams();
    localLayoutParams.height = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 22.0F);
    localImageView.setLayoutParams(localLayoutParams);
    paramUGCThemeLayout = (TextView)paramUGCThemeLayout.findViewById(2131302958);
    int i = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
    paramUGCThemeLayout.setPadding(i, i, 0, i);
  }
  
  private void a(UGCThemeLayout paramUGCThemeLayout, HotTopicItem paramHotTopicItem, BaseViewHolder paramBaseViewHolder, int paramInt1, int paramInt2)
  {
    ImageView localImageView2 = (ImageView)paramUGCThemeLayout.findViewById(2131302954);
    paramBaseViewHolder = (ImageView)paramUGCThemeLayout.findViewById(2131302959);
    ImageView localImageView1 = (ImageView)paramUGCThemeLayout.findViewById(2131302955);
    TextView localTextView = (TextView)paramUGCThemeLayout.findViewById(2131302958);
    int j = paramHotTopicItem.topicColor;
    try
    {
      new URL(paramHotTopicItem.topicCover);
      i = 1;
    }
    catch (MalformedURLException paramUGCThemeLayout)
    {
      for (;;)
      {
        paramUGCThemeLayout.printStackTrace();
        SLog.e("UGCSegment", "topicItem.topicCover is illegal:" + paramHotTopicItem.topicCover);
        int i = 0;
        continue;
        paramUGCThemeLayout = paramHotTopicItem.topicCover;
        continue;
        if (paramInt2 == 6)
        {
          if ((paramInt1 == 1) || (paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 4)) {
            paramUGCThemeLayout = ThumbnailUrlHelper.b(this.jdField_a_of_type_AndroidContentContext, paramHotTopicItem.topicCover);
          } else {
            paramUGCThemeLayout = paramHotTopicItem.topicCover;
          }
        }
        else {
          paramUGCThemeLayout = paramHotTopicItem.topicCover;
        }
      }
    }
    if (i != 0)
    {
      ThumbnailUrlHelper.b(this.jdField_a_of_type_AndroidContentContext, paramHotTopicItem.topicCover);
      if ((paramInt2 < 3) || (paramInt2 >= 6)) {
        break label231;
      }
      if ((paramInt1 != 1) && (paramInt1 != 2)) {
        break label223;
      }
      paramUGCThemeLayout = ThumbnailUrlHelper.b(this.jdField_a_of_type_AndroidContentContext, paramHotTopicItem.topicCover);
      UIUtils.b(localImageView2, paramUGCThemeLayout, 0, 0, null);
    }
    try
    {
      new URL(paramHotTopicItem.topicLogo);
      paramInt1 = 1;
    }
    catch (MalformedURLException paramUGCThemeLayout)
    {
      for (;;)
      {
        paramUGCThemeLayout.printStackTrace();
        SLog.e("UGCSegment", "topicItem.topicLogo is illegal:" + paramHotTopicItem.topicLogo);
        paramInt1 = 0;
      }
    }
    if (paramInt1 != 0) {
      UIUtils.b(paramBaseViewHolder, ThumbnailUrlHelper.c(this.jdField_a_of_type_AndroidContentContext, paramHotTopicItem.topicLogo), 0, 0, null);
    }
    localImageView1.setBackgroundColor(0xFF000000 | j);
    localTextView.setText(paramHotTopicItem.topicName);
  }
  
  private BaseViewHolder b(int paramInt, ViewGroup paramViewGroup)
  {
    int i = 0;
    if (this.jdField_a_of_type_ArrayOfComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder[(paramInt - 1)] == null)
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904497, paramViewGroup, false);
      UGCLayout localUGCLayout = (UGCLayout)paramViewGroup.findViewById(2131302953);
      while (i < this.jdField_a_of_type_Int)
      {
        UGCThemeLayout localUGCThemeLayout = new UGCThemeLayout(this.jdField_a_of_type_AndroidContentContext);
        if ((this.jdField_a_of_type_Int >= 3) && ((i == 1) || (i == 2))) {
          a(localUGCThemeLayout);
        }
        if ((this.jdField_a_of_type_Int == 6) && ((i == 3) || (i == 4))) {
          a(localUGCThemeLayout);
        }
        localUGCLayout.a(localUGCThemeLayout);
        i += 1;
      }
      this.jdField_a_of_type_ArrayOfComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder[(paramInt - 1)] = new BaseViewHolder(paramViewGroup);
    }
    return this.jdField_a_of_type_ArrayOfComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder[(paramInt - 1)];
  }
  
  private void b(UGCThemeLayout paramUGCThemeLayout)
  {
    ImageView localImageView = (ImageView)paramUGCThemeLayout.findViewById(2131302959);
    ViewGroup.LayoutParams localLayoutParams = localImageView.getLayoutParams();
    localLayoutParams.height = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 22.0F);
    localImageView.setLayoutParams(localLayoutParams);
    paramUGCThemeLayout = (TextView)paramUGCThemeLayout.findViewById(2131302958);
    int i = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
    paramUGCThemeLayout.setPadding(i, i, 0, i);
  }
  
  public int a()
  {
    if ((this.b) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.size();
      if (this.jdField_a_of_type_Int > 6) {
        this.jdField_a_of_type_Int = 6;
      }
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    paramInt = 0;
    paramViewGroup = b(this.jdField_a_of_type_Int, paramViewGroup);
    if (paramViewGroup == null) {
      return this.jdField_a_of_type_AndroidViewView;
    }
    Object localObject = (UGCLayout)paramViewGroup.a(2131302953);
    if (localObject == null) {
      return this.jdField_a_of_type_AndroidViewView;
    }
    localObject = ((UGCLayout)localObject).a();
    if (localObject == null) {
      return this.jdField_a_of_type_AndroidViewView;
    }
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null)) {
      for (;;)
      {
        if ((paramInt >= this.jdField_a_of_type_Int) || (((ArrayList)localObject).size() < paramInt) || (this.jdField_a_of_type_JavaUtilArrayList.size() < paramInt)) {
          return this.jdField_a_of_type_AndroidViewView;
        }
        paramBaseViewHolder = (UGCThemeLayout)((ArrayList)localObject).get(paramInt);
        if (paramBaseViewHolder != null) {
          paramBaseViewHolder.setMaskAlpha(0.3F);
        }
        paramInt += 1;
      }
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (this.jdField_a_of_type_Int > 6) {
      this.jdField_a_of_type_Int = 6;
    }
    paramViewGroup.a(paramBaseViewHolder.a());
    paramViewGroup.b(paramBaseViewHolder.b());
    paramInt = 0;
    for (;;)
    {
      if ((paramInt >= this.jdField_a_of_type_Int) || (((ArrayList)localObject).size() < paramInt) || (this.jdField_a_of_type_JavaUtilArrayList.size() < paramInt))
      {
        paramViewGroup.a(this.jdField_a_of_type_JavaUtilArrayList);
        if (paramViewGroup.a() == null) {
          paramViewGroup.a(new iuh(this));
        }
        this.jdField_a_of_type_AndroidViewView = paramViewGroup.a();
        return this.jdField_a_of_type_AndroidViewView;
      }
      UGCThemeLayout localUGCThemeLayout = (UGCThemeLayout)((ArrayList)localObject).get(paramInt);
      a(localUGCThemeLayout, (HotTopicItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), paramBaseViewHolder, paramInt, this.jdField_a_of_type_JavaUtilArrayList.size());
      localUGCThemeLayout.setOnClickListener(paramViewGroup);
      paramInt += 1;
    }
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    BaseViewHolder localBaseViewHolder = b(this.jdField_a_of_type_Int, paramViewGroup);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder = localBaseViewHolder;
    return localBaseViewHolder;
  }
  
  public String a()
  {
    return "UGCSegment";
  }
  
  public void a() {}
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (paramObject != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll((ArrayList)paramObject);
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (this.jdField_a_of_type_Int > 6) {
      this.jdField_a_of_type_Int = 6;
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder == null) {}
    for (;;)
    {
      return;
      Object localObject = (UGCLayout)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131302953);
      if (localObject != null)
      {
        localObject = ((UGCLayout)localObject).a();
        if (localObject != null)
        {
          int i = 0;
          while (i < ((ArrayList)localObject).size())
          {
            UGCThemeLayout localUGCThemeLayout = (UGCThemeLayout)((ArrayList)localObject).get(i);
            if (localUGCThemeLayout != null) {
              localUGCThemeLayout.setMaskAlpha(0.3F);
            }
            i += 1;
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\view\segment\UGCSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */