package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.preload.storylist.FirstVideoManager;
import com.tencent.biz.qqstory.base.preload.storylist.IPreloadVideoSource;
import com.tencent.biz.qqstory.database.LiveVideoEntry;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.CircleTransformation;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetRecentVideoStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.TipIconView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import iud;
import iuf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class RecentStorySegment
  extends SegmentView
{
  public static final String a = "recent_story";
  protected static final String b = "Q.qqstory.home.friend.RecentStorySegment";
  protected UserManager a;
  public GetRecentVideoStep a;
  protected ArrayList a;
  public HashMap a;
  protected LinkedHashMap a;
  public ArrayList b;
  
  public RecentStorySegment(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = new ArrayList(20);
    this.jdField_a_of_type_ComTencentBizQqstoryModelUserManager = ((UserManager)SuperManager.a(2));
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(20);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private void a(BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    ImageView localImageView1 = (ImageView)paramBaseViewHolder.a(2131302885);
    TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131302888);
    TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131302892);
    ImageView localImageView2 = (ImageView)paramBaseViewHolder.a(2131302889);
    ImageView localImageView3 = (ImageView)paramBaseViewHolder.a(2131302894);
    ProgressBar localProgressBar = (ProgressBar)paramBaseViewHolder.a(2131302886);
    TipIconView localTipIconView = (TipIconView)paramBaseViewHolder.a(2131302893);
    TextView localTextView3 = (TextView)paramBaseViewHolder.a(2131302890);
    if ((localTextView3 == null) || (localTextView1 == null) || (localTextView2 == null)) {}
    while (this.jdField_a_of_type_JavaUtilArrayList.size() <= paramInt) {
      return;
    }
    StoryItem localStoryItem = (StoryItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (localStoryItem == null)
    {
      localTextView1.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131428262));
      localTextView1.setText("未知");
      localProgressBar.setVisibility(8);
      localImageView2.setVisibility(8);
      SLog.e("Q.qqstory.home.friend.RecentStorySegment", "user item = null!");
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilHashMap.get(localStoryItem.key) != null) && (localStoryItem.preLoadStatus == 2)) {
      StoryReportor.b("home_page", "preload_time", 0, 0, new String[] { String.valueOf(NetConnInfoCenter.getServerTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(localStoryItem.key)).longValue()), "3" });
    }
    int i = localStoryItem.unReadCount;
    paramInt = i;
    if (i > 99) {
      paramInt = 99;
    }
    localTextView3.setText(localTextView3.getResources().getString(2131366430, new Object[] { Integer.valueOf(paramInt) }));
    String str = ThumbnailUrlHelper.a(localStoryItem.cover);
    if ((str != null) && (!str.equals(localImageView1.getTag()))) {
      UIUtils.b(localImageView1, str, 50, 88, new CircleTransformation());
    }
    if ((localStoryItem.liveVideo != null) && (localStoryItem.liveVideo.roomId != 0))
    {
      localImageView3.setVisibility(0);
      localTextView2.setVisibility(8);
      localTipIconView.setVisibility(8);
      label377:
      if (!this.jdField_a_of_type_ComTencentBizQqstoryModelUserManager.a().contains(String.valueOf(localStoryItem.user.uid))) {
        break label602;
      }
      localImageView2.setVisibility(0);
      localImageView2.setImageResource(2130841578);
      localTextView1.setMaxWidth(UIUtils.b(this.jdField_a_of_type_AndroidContentContext, 160.0F));
      label430:
      localTextView1.setText(localStoryItem.getTitle());
      localTextView2.setText(localStoryItem.getTime());
      if (localStoryItem.preLoadStatus != 1)
      {
        if (!((FirstVideoManager)SuperManager.a(12)).a(IPreloadVideoSource.a, String.valueOf(localStoryItem.user.uid))) {
          break label682;
        }
        paramInt = 2;
        label492:
        localStoryItem.preLoadStatus = paramInt;
      }
      switch (localStoryItem.preLoadStatus)
      {
      }
    }
    for (;;)
    {
      paramBaseViewHolder.a().setOnClickListener(paramBaseViewHolder);
      paramBaseViewHolder.a().setOnLongClickListener(paramBaseViewHolder);
      paramBaseViewHolder.a(localStoryItem);
      if (paramBaseViewHolder.a() != null) {
        break;
      }
      paramBaseViewHolder.a(new iud(this));
      return;
      localImageView3.setVisibility(8);
      localTextView2.setVisibility(0);
      localTipIconView.setVisibility(0);
      localTipIconView.setCountdown(localStoryItem.getCountDown());
      break label377;
      label602:
      if (!TextUtils.isEmpty(localStoryItem.user.symbolUrl))
      {
        localImageView2.setVisibility(0);
        UIUtils.b(localImageView2, localStoryItem.user.symbolUrl, 30, 30, null);
        localTextView1.setMaxWidth(UIUtils.b(this.jdField_a_of_type_AndroidContentContext, 160.0F));
        break label430;
      }
      localImageView2.setVisibility(8);
      localTextView1.setMaxWidth(UIUtils.b(this.jdField_a_of_type_AndroidContentContext, 180.0F));
      break label430;
      label682:
      paramInt = 0;
      break label492;
      localTextView1.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131428311));
      if (Build.VERSION.SDK_INT >= 16) {
        paramBaseViewHolder.a().setBackground(null);
      }
      localProgressBar.setVisibility(8);
      continue;
      localTextView1.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131428311));
      localProgressBar.setVisibility(0);
      if (Build.VERSION.SDK_INT >= 16) {
        paramBaseViewHolder.a().setBackground(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841384));
      }
      localTextView3.setText("正在加载...");
      continue;
      localTextView1.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131428262));
      if (Build.VERSION.SDK_INT >= 16) {
        paramBaseViewHolder.a().setBackground(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841384));
      }
      localProgressBar.setVisibility(8);
    }
  }
  
  private void a(String paramString, ImageView paramImageView)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramImageView.setVisibility(0);
      return;
    }
    if (paramImageView == null)
    {
      SLog.e("Q.qqstory.home.friend.RecentStorySegment", "setRecentStoryCover,cover is null!");
      return;
    }
    paramImageView.setVisibility(8);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    a(paramBaseViewHolder, paramInt);
    return paramBaseViewHolder.a();
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904481, paramViewGroup, false));
    this.b.add(paramViewGroup);
    return paramViewGroup;
  }
  
  public String a()
  {
    return "recent_story";
  }
  
  public void a() {}
  
  public void a(long paramLong)
  {
    label7:
    int i;
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      return;
    }
    else
    {
      i = 0;
      label11:
      if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label136;
      }
      if ((((StoryItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).user == null) || (((StoryItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).user.uid != paramLong)) {
        break label127;
      }
      ((StoryItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).preLoadStatus = 2;
    }
    for (;;)
    {
      Iterator localIterator = this.b.iterator();
      if (!localIterator.hasNext()) {
        break label7;
      }
      BaseViewHolder localBaseViewHolder = (BaseViewHolder)localIterator.next();
      if (localBaseViewHolder.a() != i) {
        break;
      }
      a(localBaseViewHolder, i);
      return;
      label127:
      i += 1;
      break label11;
      label136:
      i = -1;
    }
  }
  
  public void a(StoryItem paramStoryItem)
  {
    if ((paramStoryItem == null) || (paramStoryItem.user == null)) {
      return;
    }
    Bosses.get().postJob(new iuf(this, paramStoryItem));
  }
  
  public void a(Object paramObject)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll((ArrayList)paramObject);
      return;
    }
    catch (Exception paramObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      SLog.e("Q.qqstory.home.friend.RecentStorySegment", "set date error! e:" + paramObject);
      ((Exception)paramObject).printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\view\segment\RecentStorySegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */