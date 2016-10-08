package com.tencent.biz.pubaccount.subscript;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SubscriptFeedsNewAdapter
  extends BaseAdapter
  implements FaceDecoder.DecodeTaskCompletionListener
{
  public static int a;
  private static final String jdField_a_of_type_JavaLangString;
  public static int b;
  public static int c;
  private static int jdField_d_of_type_Int;
  private float jdField_a_of_type_Float;
  private Context jdField_a_of_type_AndroidContentContext;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private RecentFaceDecoder jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashSet jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private float c;
  private float jdField_d_of_type_Float;
  private int e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = SubscriptFeedsNewAdapter.class.getSimpleName();
    jdField_d_of_type_Int = 3;
    jdField_c_of_type_Int = 1;
  }
  
  public SubscriptFeedsNewAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder = new RecentFaceDecoder(paramQQAppInterface, this, false);
    this.jdField_a_of_type_Boolean = ThemeUtil.isInNightMode(paramQQAppInterface);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131494172);
    this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131494173);
    this.jdField_c_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131494174);
    this.jdField_d_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131494175);
  }
  
  private void a(SubscriptFeedsNewAdapter.FeedItemCellHolder paramFeedItemCellHolder, String paramString)
  {
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localBitmap == null)
    {
      paramFeedItemCellHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(1008, paramString));
      return;
    }
    paramFeedItemCellHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_JavaUtilHashSet.isEmpty()) {
      ReportController.b(null, "CliOper", "", "", "0X8006110", "0X8006110", 0, this.jdField_a_of_type_JavaUtilHashSet.size(), 0, "", "", "", "");
    }
    if (this.e > 0) {
      ReportController.b(null, "CliOper", "", "", "0X8006154", "0X8006154", 0, this.e, 0, "", "", "", "");
    }
    if (this.jdField_b_of_type_Boolean) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006431", "0X8006431", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    this.jdField_a_of_type_JavaUtilHashSet = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a();
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilHashMap = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (this.jdField_a_of_type_ComTencentWidgetXListView == null) || (paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramBitmap);
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramBitmap = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1).getTag();
        if ((paramBitmap != null) && ((paramBitmap instanceof SubscriptFeedsNewAdapter.FeedItemCellHolder)))
        {
          paramBitmap = (SubscriptFeedsNewAdapter.FeedItemCellHolder)paramBitmap;
          if (paramString.equals(paramBitmap.jdField_a_of_type_JavaLangString)) {
            a(paramBitmap, paramString);
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = paramDragFrameLayout;
  }
  
  public void a(List paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void b()
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
  }
  
  public int getCount()
  {
    return this.jdField_b_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_b_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = jdField_d_of_type_Int;
    if ((this.jdField_b_of_type_JavaUtilList.get(paramInt) instanceof SubscriptionFeed)) {
      i = jdField_a_of_type_Int;
    }
    return i;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_b_of_type_JavaUtilList.size())) {
      return null;
    }
    int j = getItemViewType(paramInt);
    Object localObject = null;
    int i;
    if (paramView == null) {
      if (j == jdField_a_of_type_Int)
      {
        localObject = new SubscriptFeedsNewAdapter.FeedItemCellHolder(this);
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903769, null);
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131299991));
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299992));
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299993));
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299994));
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131299995));
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299998));
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131299999));
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131300000));
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_c_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131298740));
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).d = ((Button)paramView.findViewById(2131298786));
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramViewGroup = ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_c_of_type_AndroidWidgetTextView;
        if (this.jdField_a_of_type_Boolean)
        {
          i = this.jdField_a_of_type_AndroidContentResResources.getColor(2131427871);
          paramViewGroup.setTextColor(i);
          paramViewGroup = ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_AndroidWidgetTextView;
          if (!this.jdField_a_of_type_Boolean) {
            break label421;
          }
          i = this.jdField_a_of_type_AndroidContentResResources.getColor(2131427873);
          label349:
          paramViewGroup.setTextColor(i);
          paramViewGroup = ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_b_of_type_AndroidWidgetTextView;
          if (!this.jdField_a_of_type_Boolean) {
            break label436;
          }
          i = this.jdField_a_of_type_AndroidContentResResources.getColor(2131427875);
          label380:
          paramViewGroup.setTextColor(i);
          label386:
          paramViewGroup = paramView;
          if (paramView != null) {
            paramView.setTag(localObject);
          }
        }
      }
    }
    for (paramViewGroup = paramView;; paramViewGroup = paramView)
    {
      if (paramViewGroup == null)
      {
        return null;
        i = this.jdField_a_of_type_AndroidContentResResources.getColor(2131427872);
        break;
        label421:
        i = this.jdField_a_of_type_AndroidContentResResources.getColor(2131427870);
        break label349;
        label436:
        i = this.jdField_a_of_type_AndroidContentResResources.getColor(2131427874);
        break label380;
      }
      String str;
      label593:
      SubscriptionFeedItem localSubscriptionFeedItem;
      if (j == jdField_a_of_type_Int)
      {
        paramViewGroup.setTag(2131296517, Integer.valueOf(paramInt));
        paramView = (SubscriptFeedsNewAdapter.FeedItemCellHolder)paramViewGroup.getTag();
        localObject = (SubscriptionFeed)getItem(paramInt);
        if (this.jdField_a_of_type_JavaUtilHashSet != null) {
          this.jdField_a_of_type_JavaUtilHashSet.add(((SubscriptionFeed)localObject).jdField_a_of_type_JavaLangString);
        }
        paramView.jdField_a_of_type_JavaLangString = ((SubscriptionFeed)localObject).jdField_a_of_type_JavaLangString;
        a(paramView, ((SubscriptionFeed)localObject).jdField_a_of_type_JavaLangString);
        str = TroopBarAssistantManager.a().a(((SubscriptionFeed)localObject).jdField_a_of_type_JavaLangString);
        if (!TextUtils.isEmpty(str)) {
          break label910;
        }
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((SubscriptionFeed)localObject).jdField_a_of_type_JavaLangString);
        paramView.jdField_b_of_type_AndroidWidgetTextView.setText(TimeManager.a().a(((SubscriptionFeed)localObject).jdField_a_of_type_JavaLangString, ((SubscriptionFeed)localObject).jdField_a_of_type_Long));
        if (((SubscriptionFeed)localObject).h <= 0) {
          break label922;
        }
        paramInt = 3;
        CustomWidgetUtil.a(paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, paramInt, ((SubscriptionFeed)localObject).h, 2130843325, 99, null);
        if (((SubscriptionFeed)localObject).jdField_a_of_type_JavaUtilList.size() <= 0) {
          break label1018;
        }
        localSubscriptionFeedItem = (SubscriptionFeedItem)((SubscriptionFeed)localObject).jdField_a_of_type_JavaUtilList.get(0);
        if (localSubscriptionFeedItem.e != 0) {
          break label927;
        }
        paramView.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(1);
        paramView.jdField_c_of_type_AndroidWidgetTextView.setText(new QQText(localSubscriptionFeedItem.c.replaceFirst("^\\s+", ""), 3, 20));
        label687:
        paramView.jdField_a_of_type_AndroidViewViewGroup.setTag(2131296519, Integer.valueOf(((SubscriptionFeed)localObject).h));
        paramView.jdField_a_of_type_AndroidViewViewGroup.setTag(2131296520, ((SubscriptionFeed)localObject).jdField_a_of_type_JavaLangString);
        paramView.jdField_a_of_type_AndroidViewViewGroup.setTag(2131296521, str);
        paramView.jdField_a_of_type_AndroidViewViewGroup.setTag(2131296518, Integer.valueOf(jdField_b_of_type_Int));
        paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131296519, localObject);
        paramView.jdField_a_of_type_AndroidWidgetButton.setTag(2131296520, ((SubscriptionFeed)localObject).jdField_a_of_type_JavaLangString);
        paramView.jdField_b_of_type_AndroidWidgetButton.setTag(2131296520, ((SubscriptionFeed)localObject).jdField_a_of_type_JavaLangString);
        paramView.jdField_c_of_type_AndroidWidgetButton.setTag(2131296520, ((SubscriptionFeed)localObject).jdField_a_of_type_JavaLangString);
        paramView.jdField_c_of_type_AndroidWidgetButton.setTag(2131296521, str);
        paramView.d.setTag(2131296520, ((SubscriptionFeed)localObject).jdField_a_of_type_JavaLangString);
        if (TroopBarAssistantManager.a().a(((SubscriptionFeed)localObject).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          break label1056;
        }
        if (this.jdField_a_of_type_Boolean) {
          break label1043;
        }
        paramView.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130839532);
      }
      for (;;)
      {
        paramViewGroup.setTag(-3, Integer.valueOf((int)(this.jdField_a_of_type_Float + this.jdField_c_of_type_Float + this.jdField_d_of_type_Float)));
        paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramView.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        return paramViewGroup;
        label910:
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(str);
        break;
        label922:
        paramInt = 0;
        break label593;
        label927:
        if (localSubscriptionFeedItem.e == 1)
        {
          paramView.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(2);
          paramView.jdField_c_of_type_AndroidWidgetTextView.setText(localSubscriptionFeedItem.b.replaceFirst("^\\s+", ""));
          break label687;
        }
        if (localSubscriptionFeedItem.e == 2)
        {
          paramView.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(1);
          paramView.jdField_c_of_type_AndroidWidgetTextView.setText(2131364549);
          break label687;
        }
        paramView.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(1);
        paramView.jdField_c_of_type_AndroidWidgetTextView.setText(2131364552);
        break label687;
        label1018:
        if ((!QLog.isColorLevel()) || (!QLog.isColorLevel())) {
          break label687;
        }
        QLog.w(jdField_a_of_type_JavaLangString, 2, "getView feed.mItems.size() == 0, is error!!");
        break label687;
        label1043:
        paramView.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130839534);
      }
      label1056:
      if (!this.jdField_a_of_type_Boolean) {
        paramView.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130839533);
      }
      for (;;)
      {
        paramViewGroup.setTag(-3, Integer.valueOf((int)(this.jdField_b_of_type_Float + this.jdField_c_of_type_Float + this.jdField_d_of_type_Float)));
        paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        paramView.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        break;
        paramView.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130839535);
      }
      break label386;
    }
  }
  
  public int getViewTypeCount()
  {
    return jdField_d_of_type_Int;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\subscript\SubscriptFeedsNewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */