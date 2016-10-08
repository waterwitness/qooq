package com.tencent.biz.qqstory.playvideo.watcherlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XListView;
import ipy;
import ipz;
import iqa;
import java.util.List;

public class QQStoryWatcherListView
  extends FrameLayout
  implements View.OnClickListener
{
  static final double jdField_a_of_type_Double = 0.5235987755982988D;
  public static final String a = "Q.qqstory.player.watcherlist";
  public int a;
  View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  QQStoryWatcherListAdapter jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter;
  QQStoryWatcherListView.OnWatcherViewListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListView$OnWatcherViewListener;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  public int b;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public int c;
  TextView c;
  int jdField_d_of_type_Int;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  int e;
  
  public QQStoryWatcherListView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_d_of_type_Int = 0;
    this.e = 0;
    a(paramContext);
  }
  
  public QQStoryWatcherListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_d_of_type_Int = 0;
    this.e = 0;
    a(paramContext);
  }
  
  public QQStoryWatcherListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_d_of_type_Int = 0;
    this.e = 0;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    Object localObject = LayoutInflater.from(paramContext).inflate(2130904508, this, true);
    this.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131302990);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131302991));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131302983));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131300184));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)((View)localObject).findViewById(2131302992));
    this.c = ((TextView)((View)localObject).findViewById(2131302881));
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2130904506, null);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131302989));
    this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_b_of_type_AndroidViewView);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(2);
    localObject = new ipz(this, new GestureDetector(paramContext, new ipy(this)));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener((View.OnTouchListener)localObject);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener((View.OnTouchListener)localObject);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter = new QQStoryWatcherListAdapter(paramContext, (View.OnTouchListener)localObject);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new iqa(this));
  }
  
  public void a()
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.c.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
  }
  
  public void a(List paramList)
  {
    if (paramList == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter.b(paramList);
    } while (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter.getCount() + this.e <= this.jdField_d_of_type_Int);
    setReadCount(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter.getCount() + this.e);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131302881)
    {
      this.c.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListView$OnWatcherViewListener != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListView$OnWatcherViewListener.b();
      }
    }
    while ((i != 2131300184) || (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListView$OnWatcherViewListener == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListView$OnWatcherViewListener.a();
  }
  
  public void setData(List paramList)
  {
    if (paramList == null) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter.a(paramList);
    } while (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter.getCount() + this.e <= this.jdField_d_of_type_Int);
    setReadCount(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter.getCount() + this.e);
  }
  
  public void setListener(QQStoryWatcherListView.OnWatcherViewListener paramOnWatcherViewListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListView$OnWatcherViewListener = paramOnWatcherViewListener;
  }
  
  public void setReadCount(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(StoryVideoItem.getViewCountString(paramInt));
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListView$OnWatcherViewListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListView$OnWatcherViewListener.a(this.jdField_d_of_type_Int);
    }
  }
  
  public void setStrangerCount(int paramInt)
  {
    this.e = paramInt;
    if (paramInt > 0)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText("还有" + StoryVideoItem.getViewCountString(paramInt) + "个非好友看过");
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\playvideo\watcherlist\QQStoryWatcherListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */