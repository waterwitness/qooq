package com.tencent.biz.qqstory.pgc.adapter;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.pgc.view.InfoCardDialog;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.biz.qqstory.view.widget.TipsView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import ilg;
import ilh;
import ili;
import ilj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchResultAdapter
  extends BaseAdapter
{
  public static int b;
  public static int c = 1;
  public static int d = 2;
  public static int f = 5;
  public int a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public InfoCardDialog a;
  public QQStoryBaseActivity a;
  public QQAppInterface a;
  ilh jdField_a_of_type_Ilh;
  public String a;
  public ArrayList a;
  private List jdField_a_of_type_JavaUtilList;
  public int e = 10;
  final int g = 0;
  final int h = 1;
  final int i = 2;
  final int j = 3;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SearchResultAdapter(QQStoryBaseActivity paramQQStoryBaseActivity, QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity = paramQQStoryBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private SpannableString a(String paramString, List paramList)
  {
    if (paramString == null) {
      return null;
    }
    if (paramList == null) {
      return new SpannableString(paramString);
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (String)localIterator.next();
      int k = paramString.toLowerCase().indexOf(paramList.toLowerCase());
      if (k != -1)
      {
        paramString = new SpannableString(paramString);
        paramString.setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), k, paramList.length() + k, 34);
        return paramString;
      }
    }
    return new SpannableString(paramString);
  }
  
  private ili a(int paramInt1, int paramInt2, UserInfo paramUserInfo)
  {
    ili localili = new ili();
    localili.jdField_a_of_type_Int = paramInt1;
    localili.b = paramInt2;
    localili.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo = paramUserInfo;
    return localili;
  }
  
  private void a(boolean paramBoolean, View paramView, int paramInt, String paramString)
  {
    a(paramBoolean, paramView, paramInt, paramString, false);
  }
  
  private void a(boolean paramBoolean1, View paramView, int paramInt, String paramString, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302846));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297202));
    Object localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    if (paramBoolean1)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramView.setBackgroundResource(2130841522);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.getResources().getColor(2131427409));
      if (paramInt == 0)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841524);
        ((LinearLayout.LayoutParams)localObject).width = com.tencent.mobileqq.util.DisplayUtil.a(paramView.getContext(), 12.0F);
        ((LinearLayout.LayoutParams)localObject).height = com.tencent.mobileqq.util.DisplayUtil.a(paramView.getContext(), 14.0F);
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_AndroidWidgetTextView.setText("已订阅");
        localObject = (QQStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(180);
        if ((!((QQStoryManager)localObject).b()) && (paramBoolean2))
        {
          ((QQStoryManager)localObject).a();
          TipsView.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity, paramView, "订阅成功，新日迹将在首页优先展示。", 1, 2, 0);
          StoryReportor.a("new_guide", "search", 0, 0, new String[] { paramString });
        }
      }
    }
    do
    {
      QQStoryManager localQQStoryManager;
      do
      {
        do
        {
          return;
        } while (paramInt != 1);
        ((LinearLayout.LayoutParams)localObject).width = com.tencent.mobileqq.util.DisplayUtil.a(paramView.getContext(), 14.0F);
        ((LinearLayout.LayoutParams)localObject).height = com.tencent.mobileqq.util.DisplayUtil.a(paramView.getContext(), 10.0F);
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841523);
        this.jdField_a_of_type_AndroidWidgetTextView.setText("已关注");
        paramInt = com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil.b(paramView.getContext());
        localObject = new int[2];
        paramView.getLocationOnScreen((int[])localObject);
        localQQStoryManager = (QQStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(180);
      } while ((localQQStoryManager.a()) || (!paramBoolean2));
      localQQStoryManager.b();
      if (paramInt - localObject[1] - paramView.getHeight() > com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil.b(paramView.getContext(), 60.0F)) {
        TipsView.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity, paramView, "关注成功，可在首页“好友更新”中查看TA的日迹。", 1, 2, 0);
      }
      for (;;)
      {
        StoryReportor.a("new_guide", "search_vip", 0, 0, new String[] { paramString });
        return;
        TipsView.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity, paramView, "关注成功，可在首页“好友更新”中查看TA的日迹。", 2, 2, 0);
      }
      paramView.setBackgroundResource(2130841521);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.getResources().getColor(2131427407));
      if (paramInt == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText("订阅");
        return;
      }
    } while (paramInt != 1);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("关注");
  }
  
  private boolean a(View paramView)
  {
    paramView = (TextView)paramView.findViewById(2131297202);
    return (paramView.getText().equals("已订阅")) || (paramView.getText().equals("已关注"));
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    notifyDataSetChanged();
  }
  
  public void a(XListView paramXListView, boolean paramBoolean, int paramInt, String paramString)
  {
    int k = 0;
    if (k < paramXListView.getChildCount())
    {
      View localView = paramXListView.getChildAt(k);
      if (localView == null) {}
      Object localObject;
      do
      {
        do
        {
          k += 1;
          break;
          localObject = (RelativeLayout)localView.findViewById(2131298071);
        } while (localObject == null);
        localView = ((RelativeLayout)localObject).findViewById(2131302795);
        localObject = ((RelativeLayout)localObject).getTag();
      } while ((localObject == null) || (!(localObject instanceof UserInfo)) || (!((UserInfo)localObject).unionId.equals(paramString)));
      a(paramBoolean, localView, paramInt, paramString, true);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog != null) && (this.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog.dismiss();
    }
  }
  
  public void b(List paramList)
  {
    Object localObject1;
    int k;
    if (this.jdField_a_of_type_Int == b)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      Object localObject2 = new ArrayList();
      localObject1 = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        UserInfo localUserInfo = (UserInfo)localIterator.next();
        if (localUserInfo.type == 0) {
          ((List)localObject2).add(a(0, 0, localUserInfo));
        }
      }
      if (((List)localObject2).size() > 0) {
        this.jdField_a_of_type_JavaUtilArrayList.add(a(2, 0, null));
      }
      if (((List)localObject2).size() > f) {}
      for (k = f;; k = ((List)localObject2).size())
      {
        this.jdField_a_of_type_JavaUtilArrayList.addAll(((List)localObject2).subList(0, k));
        if (((List)localObject2).size() > f) {
          this.jdField_a_of_type_JavaUtilArrayList.add(a(3, 0, null));
        }
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject2 = (UserInfo)paramList.next();
          if (((UserInfo)localObject2).type == 1) {
            ((List)localObject1).add(a(1, 1, (UserInfo)localObject2));
          }
        }
      }
      if (((List)localObject1).size() > 0) {
        this.jdField_a_of_type_JavaUtilArrayList.add(a(2, 1, null));
      }
      if (((List)localObject1).size() > f)
      {
        k = f;
        this.jdField_a_of_type_JavaUtilArrayList.addAll(((List)localObject1).subList(0, k));
        if (((List)localObject1).size() > f) {
          this.jdField_a_of_type_JavaUtilArrayList.add(a(3, 1, null));
        }
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      k = ((List)localObject1).size();
      break;
      if ((this.jdField_a_of_type_Int == c) || (this.jdField_a_of_type_Int == d))
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList.size() == 0) && (paramList.size() > 0)) {
          this.jdField_a_of_type_JavaUtilArrayList.add(a(2, ((UserInfo)paramList.get(0)).type, null));
        }
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject1 = (UserInfo)paramList.next();
          this.jdField_a_of_type_JavaUtilArrayList.add(a(((UserInfo)localObject1).type, ((UserInfo)localObject1).type, (UserInfo)localObject1));
        }
      }
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((ili)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    }
    Object localObject1;
    label215:
    label531:
    do
    {
      do
      {
        return paramView;
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.getLayoutInflater().inflate(2130904484, paramViewGroup, false);
        }
        paramView = (TextView)((View)localObject1).findViewById(2131297123);
        if (((ili)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b == 0) {
          paramView.setText("栏目");
        }
        for (;;)
        {
          paramViewGroup = ((View)localObject1).findViewById(2131298342);
          if (paramInt <= 0) {
            break;
          }
          paramViewGroup.setVisibility(0);
          return (View)localObject1;
          paramView.setText("认证帐户");
        }
        paramView = (View)localObject1;
      } while (paramInt != 0);
      paramViewGroup.setVisibility(8);
      return (View)localObject1;
      localObject1 = ((ili)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo;
      Object localObject2;
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.getLayoutInflater().inflate(2130904470, null);
        paramViewGroup = new ilj(this, paramView);
        paramView.setTag(paramViewGroup);
        if (getItemViewType(paramInt - 1) != 2) {
          break label531;
        }
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localObject2 = a(((UserInfo)localObject1).nick, this.jdField_a_of_type_JavaUtilList);
        if (localObject2 != null) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        }
        if (TextUtils.isEmpty(((UserInfo)localObject1).headUrl)) {}
      }
      for (;;)
      {
        try
        {
          localObject2 = (BitmapDrawable)ImageUtil.a(((UserInfo)localObject1).type);
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestHeight = 100;
          localURLDrawableOptions.mRequestWidth = 100;
          localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject2);
          localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
          localObject2 = URLDrawable.getDrawable(ThumbnailUrlHelper.a(((UserInfo)localObject1).headUrl), localURLDrawableOptions);
          if (((URLDrawable)localObject2).getStatus() == 2) {
            ((URLDrawable)localObject2).restartDownload();
          }
          if (((UserInfo)localObject1).type != 1) {
            continue;
          }
          ((URLDrawable)localObject2).setTag(URLDrawableDecodeHandler.a(100, 100));
          ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.a);
          paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
        }
        catch (Exception localException1)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("InfoCardDialog", 2, QLog.getStackTraceString(localException1));
          continue;
          paramViewGroup.b.setVisibility(8);
          continue;
        }
        if (((UserInfo)localObject1).type != 1) {
          continue;
        }
        paramViewGroup.b.setVisibility(0);
        if (!TextUtils.isEmpty(((UserInfo)localObject1).authTypeIcon)) {}
        try
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          localObject2 = URLDrawable.getDrawable(((UserInfo)localObject1).authTypeIcon, (URLDrawable.URLDrawableOptions)localObject2);
          if (((URLDrawable)localObject2).getStatus() == 2) {
            ((URLDrawable)localObject2).restartDownload();
          }
          paramViewGroup.b.setImageDrawable((Drawable)localObject2);
        }
        catch (Exception localException2)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("InfoCardDialog", 2, QLog.getStackTraceString(localException2));
          continue;
        }
        a(((UserInfo)localObject1).isSubscribe, paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout, ((UserInfo)localObject1).type, ((UserInfo)localObject1).unionId);
        if (this.jdField_a_of_type_Ilh == null) {
          this.jdField_a_of_type_Ilh = new ilh(this);
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(localObject1);
        paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_Ilh);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject1);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_Ilh);
        return paramView;
        paramViewGroup = (ilj)paramView.getTag();
        break;
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        break label215;
        ((URLDrawable)localObject2).setTag(URLDrawableDecodeHandler.a(100, 100, 10));
        ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.e);
      }
      localObject1 = paramView;
      if (paramView == null) {
        localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.getLayoutInflater().inflate(2130904483, paramViewGroup, false);
      }
      paramView = (View)localObject1;
    } while ((ili)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt) == null);
    ((View)localObject1).setTag(this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
    ((View)localObject1).setOnClickListener(new ilg(this, paramInt));
    return (View)localObject1;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\adapter\SearchResultAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */