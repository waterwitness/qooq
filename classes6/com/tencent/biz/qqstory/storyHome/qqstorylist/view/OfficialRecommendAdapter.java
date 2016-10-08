package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.pgc.model.RecommendItem;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.pgc.view.DiscoverItem;
import com.tencent.biz.qqstory.pgc.view.InfoCardDialog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class OfficialRecommendAdapter
  extends BaseAdapter
  implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  public Context a;
  InfoCardDialog a;
  public OfficialRecommendListView a;
  public List a;
  
  public OfficialRecommendAdapter(Context paramContext, List paramList, OfficialRecommendListView paramOfficialRecommendListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendListView = paramOfficialRecommendListView;
  }
  
  private View a()
  {
    DiscoverItem localDiscoverItem = new DiscoverItem(this.jdField_a_of_type_AndroidContentContext, 22, 1, this, this, null);
    localDiscoverItem.setLayoutParams(new AbsListView.LayoutParams(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 83.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 134.0F)));
    localDiscoverItem.setId(2131296658);
    return localDiscoverItem;
  }
  
  private void a(BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    paramBaseViewHolder = (DiscoverItem)paramBaseViewHolder.a(2131296658);
    paramBaseViewHolder.setRecommendItem(paramInt, (RecommendItem)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    paramBaseViewHolder.setMaskAlpha(paramBaseViewHolder.c);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {}
    for (paramView = new BaseViewHolder(a());; paramView = (BaseViewHolder)paramView.getTag())
    {
      a(paramView, paramInt);
      return paramView.a();
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendListView == null) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendListView.a == null) || (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendListView.e)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendListView.a.a(paramInt, paramView, (RecommendItem)getItem(paramInt));
  }
  
  public boolean onItemLongClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendListView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendListView.a != null)) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendListView.setAutoFlip(false);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a().a();
    paramAdapterView = (QQStoryHandler)localQQAppInterface.a(98);
    this.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog = new InfoCardDialog(paramView.getContext(), localQQAppInterface, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendListView);
    paramView = ((RecommendItem)getItem(paramInt)).a;
    if (paramView != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog.a(paramView, 1);
      paramAdapterView.a(paramView.type, paramView.unionId);
      StoryReportor.a("recommend", "press", 0, paramView.type, new String[] { paramView.unionId });
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\view\OfficialRecommendAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */