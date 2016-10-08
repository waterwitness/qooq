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
import com.tencent.biz.qqstory.base.preload.storylist.UserClickManager;
import com.tencent.biz.qqstory.database.LiveVideoEntry;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.CircleTransformation;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetFriendsVideoStep;
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
import itv;
import itx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class FriendsSegment
  extends SegmentView
{
  public static final String a = "friends_story";
  private static final String b = "Q.qqstory.home.friend.FriendsSegment";
  protected UserClickManager a;
  protected UserManager a;
  public GetFriendsVideoStep a;
  protected ArrayList a;
  public HashMap a;
  protected LinkedHashMap a;
  protected ArrayList b;
  
  public FriendsSegment(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = new ArrayList(20);
    this.jdField_a_of_type_ComTencentBizQqstoryModelUserManager = ((UserManager)SuperManager.a(2));
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistUserClickManager = ((StoryManager)SuperManager.a(5)).a().a();
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(20);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private void a(BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    ImageView localImageView1 = (ImageView)paramBaseViewHolder.a(2131302782);
    Object localObject1 = (TextView)paramBaseViewHolder.a(2131302787);
    TextView localTextView = (TextView)paramBaseViewHolder.a(2131302784);
    ImageView localImageView2 = (ImageView)paramBaseViewHolder.a(2131302788);
    ImageView localImageView3 = (ImageView)paramBaseViewHolder.a(2131302785);
    TipIconView localTipIconView = (TipIconView)paramBaseViewHolder.a(2131302786);
    ProgressBar localProgressBar = (ProgressBar)paramBaseViewHolder.a(2131302783);
    Object localObject2 = paramBaseViewHolder.a(2131302789);
    if (paramInt == a() - 1) {}
    for (int i = 4;; i = 0)
    {
      ((View)localObject2).setVisibility(i);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > paramInt) {
        break;
      }
      return;
    }
    localObject2 = (StoryItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (localObject2 == null)
    {
      SLog.e("Q.qqstory.home.friend.FriendsSegment", "bindFriendStoryView,item=null,position=%s", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilHashMap.get(((StoryItem)localObject2).key) != null) && (((StoryItem)localObject2).preLoadStatus == 2)) {
      StoryReportor.b("home_page", "preload_time", 0, 0, new String[] { String.valueOf(NetConnInfoCenter.getServerTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(((StoryItem)localObject2).key)).longValue()), "4" });
    }
    if (((StoryItem)localObject2).user == null)
    {
      localTextView.setText("陌生人");
      label244:
      localProgressBar.setVisibility(8);
      if (((StoryItem)localObject2).user == null) {
        break label837;
      }
      if (((StoryItem)localObject2).preLoadStatus != 1)
      {
        if (!((FirstVideoManager)SuperManager.a(12)).a(IPreloadVideoSource.b, String.valueOf(((StoryItem)localObject2).user.uid))) {
          break label597;
        }
        paramInt = 2;
        label301:
        ((StoryItem)localObject2).preLoadStatus = paramInt;
      }
      switch (((StoryItem)localObject2).preLoadStatus)
      {
      default: 
        label340:
        if (this.jdField_a_of_type_ComTencentBizQqstoryModelUserManager.a().contains(String.valueOf(((StoryItem)localObject2).user.uid)))
        {
          localImageView3.setVisibility(0);
          localImageView3.setImageResource(2130841578);
          localTextView.setMaxWidth(UIUtils.b(this.jdField_a_of_type_AndroidContentContext, 160.0F));
          label393:
          if ((((StoryItem)localObject2).liveVideo == null) || (((StoryItem)localObject2).liveVideo.roomId == 0)) {
            break label880;
          }
          localImageView2.setVisibility(0);
          ((TextView)localObject1).setVisibility(8);
          localTipIconView.setVisibility(8);
        }
        break;
      }
    }
    for (;;)
    {
      localObject1 = ThumbnailUrlHelper.a(((StoryItem)localObject2).cover);
      if ((localObject1 != null) && (!((String)localObject1).equals(localImageView1.getTag()))) {
        UIUtils.b(localImageView1, (String)localObject1, 50, 88, new CircleTransformation());
      }
      paramBaseViewHolder.a().setOnClickListener(paramBaseViewHolder);
      paramBaseViewHolder.a().setOnLongClickListener(paramBaseViewHolder);
      paramBaseViewHolder.a(localObject2);
      if (paramBaseViewHolder.a() != null) {
        break;
      }
      paramBaseViewHolder.a(new itv(this));
      return;
      if (!TextUtils.isEmpty(((StoryItem)localObject2).user.remark))
      {
        localTextView.setText(((StoryItem)localObject2).user.remark);
        break label244;
      }
      if (!TextUtils.isEmpty(((StoryItem)localObject2).user.nickName))
      {
        localTextView.setText(((StoryItem)localObject2).user.nickName);
        break label244;
      }
      localTextView.setText(String.valueOf(((StoryItem)localObject2).user.uid));
      break label244;
      label597:
      paramInt = 0;
      break label301;
      if (Build.VERSION.SDK_INT >= 16) {
        paramBaseViewHolder.a().setBackground(null);
      }
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131428311));
      localProgressBar.setVisibility(8);
      break label340;
      if (Build.VERSION.SDK_INT >= 16) {
        paramBaseViewHolder.a().setBackground(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841384));
      }
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131428311));
      localProgressBar.setVisibility(0);
      break label340;
      if (Build.VERSION.SDK_INT >= 16) {
        paramBaseViewHolder.a().setBackground(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841384));
      }
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131428262));
      localProgressBar.setVisibility(8);
      break label340;
      if (!TextUtils.isEmpty(((StoryItem)localObject2).user.symbolUrl))
      {
        localImageView3.setVisibility(0);
        UIUtils.b(localImageView3, ((StoryItem)localObject2).user.symbolUrl, 30, 30, null);
        localTextView.setMaxWidth(UIUtils.b(this.jdField_a_of_type_AndroidContentContext, 160.0F));
        break label393;
      }
      localImageView3.setVisibility(8);
      localTextView.setMaxWidth(UIUtils.b(this.jdField_a_of_type_AndroidContentContext, 180.0F));
      break label393;
      label837:
      SLog.e("Q.qqstory.home.friend.FriendsSegment", "user item = null!");
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131428262));
      localProgressBar.setVisibility(8);
      localImageView3.setVisibility(8);
      break label393;
      label880:
      localImageView2.setVisibility(8);
      ((TextView)localObject1).setVisibility(0);
      localTipIconView.setVisibility(0);
      localTipIconView.setCountdown(StoryListUtils.a(((StoryItem)localObject2).updateTime));
      ((TextView)localObject1).setText(StoryListUtils.a(((StoryItem)localObject2).updateTime));
    }
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    a(paramBaseViewHolder, paramInt);
    return paramBaseViewHolder.a();
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904453, paramViewGroup, false));
    this.b.add(paramViewGroup);
    return paramViewGroup;
  }
  
  public String a()
  {
    return "friends_story";
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
    Bosses.get().postJob(new itx(this, paramStoryItem));
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
      SLog.e("Q.qqstory.home.friend.FriendsSegment", "set the error data into friends segment!");
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      ((Exception)paramObject).printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\view\segment\FriendsSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */