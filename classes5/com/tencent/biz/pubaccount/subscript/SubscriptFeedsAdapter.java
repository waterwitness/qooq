package com.tencent.biz.pubaccount.subscript;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PubAccountHttpDownloader;
import com.tencent.image.URLDrawable;
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
import idu;
import idv;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SubscriptFeedsAdapter
  extends BaseAdapter
  implements SubscriptPicManager.ImageHostListener, FaceDecoder.DecodeTaskCompletionListener
{
  public static int a = 0;
  private static final String jdField_a_of_type_JavaLangString;
  public static int b = 0;
  public static int c = 0;
  public static int d = 0;
  public static int e = 1;
  private static int h = 0;
  private static final int i = 7;
  private static final int j = 4;
  private float jdField_a_of_type_Float;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private SubscriptPicManager jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager;
  private SubscriptRecommendController jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController;
  private RecentFaceDecoder jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashSet jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  private float jdField_b_of_type_Float;
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  public boolean b;
  private float jdField_c_of_type_Float;
  private List jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private boolean jdField_d_of_type_Boolean;
  public int f = -1;
  public int g = -1;
  private final int k = 10;
  private int l;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = SubscriptFeedsAdapter.class.getSimpleName();
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 2;
    h = 3;
  }
  
  public SubscriptFeedsAdapter(Activity paramActivity, QQAppInterface paramQQAppInterface, XListView paramXListView, LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidAppActivity.getResources();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder = new RecentFaceDecoder(paramQQAppInterface, this, false);
    this.jdField_c_of_type_Boolean = ThemeUtil.isInNightMode(paramQQAppInterface);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131494172);
    this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131494173);
    this.jdField_c_of_type_Float = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131494174);
    this.jdField_d_of_type_Float = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131494175);
  }
  
  private void a(SubscriptFeedsAdapter.FeedItemCellHolder paramFeedItemCellHolder, String paramString)
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
    if (this.l > 0) {
      ReportController.b(null, "CliOper", "", "", "0X8006154", "0X8006154", 0, this.l, 0, "", "", "", "");
    }
    if (this.jdField_d_of_type_Boolean) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006431", "0X8006431", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    this.jdField_a_of_type_JavaUtilHashSet = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = null;
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager = null;
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a();
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilHashMap = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
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
        if ((paramBitmap != null) && ((paramBitmap instanceof SubscriptFeedsAdapter.FeedItemCellHolder)))
        {
          paramBitmap = (SubscriptFeedsAdapter.FeedItemCellHolder)paramBitmap;
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
  
  public void a(SubscriptPicManager paramSubscriptPicManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager = paramSubscriptPicManager;
  }
  
  public void a(SubscriptRecommendController paramSubscriptRecommendController)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController = paramSubscriptRecommendController;
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
  
  public boolean a(ImageView paramImageView)
  {
    if (paramImageView.getTag(2131296522).equals(Integer.valueOf(jdField_b_of_type_Int))) {
      return true;
    }
    if (paramImageView.getTag(2131296522).equals(Integer.valueOf(jdField_a_of_type_Int)))
    {
      int n = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      int m = 0;
      if (m < n)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(m).getTag();
        if ((localObject == null) || (!(localObject instanceof SubscriptFeedsAdapter.FeedItemCellHolder))) {}
        while (!((SubscriptFeedsAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_JavaLangString.equals(paramImageView.getTag(2131296520)))
        {
          m += 1;
          break;
        }
        return true;
      }
      return false;
    }
    return true;
  }
  
  public void b()
  {
    int n = 1;
    int m;
    if ((this.f == 1) && (this.jdField_a_of_type_Boolean))
    {
      m = 1;
      if ((this.g != 1) || (!this.jdField_b_of_type_Boolean)) {
        break label136;
      }
      label34:
      this.jdField_c_of_type_JavaUtilList.clear();
      this.jdField_c_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
      if ((m != 0) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
      {
        if (this.jdField_c_of_type_JavaUtilList.size() > 6) {
          break label141;
        }
        this.jdField_c_of_type_JavaUtilList.add(ReadInJoyArticle.TAG);
      }
    }
    for (;;)
    {
      if (n != 0)
      {
        if (this.jdField_c_of_type_JavaUtilList.size() > 3) {
          break label158;
        }
        this.jdField_c_of_type_JavaUtilList.add(SubscriptRecommendController.jdField_a_of_type_JavaLangString);
      }
      return;
      m = 0;
      break;
      label136:
      n = 0;
      break label34;
      label141:
      this.jdField_c_of_type_JavaUtilList.add(6, ReadInJoyArticle.TAG);
    }
    label158:
    this.jdField_c_of_type_JavaUtilList.add(3, SubscriptRecommendController.jdField_a_of_type_JavaLangString);
  }
  
  public void b(List paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.addAll(paramList);
  }
  
  public int getCount()
  {
    return this.jdField_c_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_c_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    int m = h;
    Object localObject = this.jdField_c_of_type_JavaUtilList.get(paramInt);
    if ((localObject instanceof SubscriptionFeed)) {
      paramInt = jdField_a_of_type_Int;
    }
    do
    {
      do
      {
        return paramInt;
        if (((localObject instanceof String)) && (localObject.equals(SubscriptRecommendController.jdField_a_of_type_JavaLangString))) {
          return jdField_c_of_type_Int;
        }
        paramInt = m;
      } while (!(localObject instanceof String));
      paramInt = m;
    } while (!localObject.equals(ReadInJoyArticle.TAG));
    return jdField_b_of_type_Int;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_c_of_type_JavaUtilList.size())) {
      return null;
    }
    int n = getItemViewType(paramInt);
    paramViewGroup = null;
    int m;
    if (paramView == null) {
      if (n == jdField_a_of_type_Int)
      {
        paramViewGroup = new SubscriptFeedsAdapter.FeedItemCellHolder(this);
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903768, null);
        paramViewGroup.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131299991));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299992));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299993));
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299994));
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131299995));
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299998));
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299996));
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299997));
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131299999));
        paramViewGroup.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131300000));
        paramViewGroup.jdField_c_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131298740));
        paramViewGroup.d = ((Button)paramView.findViewById(2131298786));
        paramViewGroup.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramViewGroup.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramViewGroup.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramViewGroup.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localObject1 = paramViewGroup.jdField_c_of_type_AndroidWidgetTextView;
        if (this.jdField_c_of_type_Boolean)
        {
          m = this.jdField_a_of_type_AndroidContentResResources.getColor(2131427871);
          ((TextView)localObject1).setTextColor(m);
          localObject1 = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
          if (!this.jdField_c_of_type_Boolean) {
            break label437;
          }
          m = this.jdField_a_of_type_AndroidContentResResources.getColor(2131427873);
          label361:
          ((TextView)localObject1).setTextColor(m);
          localObject1 = paramViewGroup.jdField_b_of_type_AndroidWidgetTextView;
          if (!this.jdField_c_of_type_Boolean) {
            break label452;
          }
          m = this.jdField_a_of_type_AndroidContentResResources.getColor(2131427875);
          label393:
          ((TextView)localObject1).setTextColor(m);
          label400:
          localObject1 = paramView;
          if (paramView != null) {
            paramView.setTag(paramViewGroup);
          }
        }
      }
    }
    for (Object localObject1 = paramView;; localObject1 = paramView)
    {
      if (localObject1 == null)
      {
        return null;
        m = this.jdField_a_of_type_AndroidContentResResources.getColor(2131427870);
        break;
        label437:
        m = this.jdField_a_of_type_AndroidContentResResources.getColor(2131427872);
        break label361;
        label452:
        m = this.jdField_a_of_type_AndroidContentResResources.getColor(2131427874);
        break label393;
        if (n == jdField_b_of_type_Int)
        {
          paramViewGroup = new idu(this, null);
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903770, null);
          paramViewGroup.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131300001));
          paramViewGroup.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localObject1 = (TextView)paramViewGroup.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131300002);
          int i1;
          if (!this.jdField_c_of_type_Boolean)
          {
            m = 2130839536;
            ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(0, 0, m, 0);
            paramViewGroup.jdField_a_of_type_JavaUtilArrayList.add((ViewGroup)paramView.findViewById(2131300003));
            paramViewGroup.jdField_a_of_type_JavaUtilArrayList.add((ViewGroup)paramView.findViewById(2131300004));
            paramViewGroup.jdField_a_of_type_JavaUtilArrayList.add((ViewGroup)paramView.findViewById(2131300005));
            paramViewGroup.jdField_a_of_type_JavaUtilArrayList.add((ViewGroup)paramView.findViewById(2131300006));
            i1 = paramViewGroup.jdField_a_of_type_JavaUtilArrayList.size();
            localObject1 = this.jdField_a_of_type_AndroidContentResResources;
            if (this.jdField_c_of_type_Boolean) {
              break label743;
            }
          }
          label743:
          for (m = 2131427876;; m = 2131427877)
          {
            int i2 = ((Resources)localObject1).getColor(m);
            m = 0;
            while (m < i1)
            {
              localObject1 = (ViewGroup)paramViewGroup.jdField_a_of_type_JavaUtilArrayList.get(m);
              ((ViewGroup)localObject1).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ViewGroup)localObject1).setTag(Integer.valueOf(m));
              ((TextView)((ViewGroup)localObject1).findViewById(2131300008)).setTextColor(i2);
              m += 1;
            }
            m = 2130839537;
            break;
          }
          paramView.setTag(-3, Integer.valueOf(0));
          break label400;
        }
        if (n != jdField_c_of_type_Int) {
          break label2003;
        }
        paramViewGroup = new idv(this, null);
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903772, null);
        this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.a(paramView);
        this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.b();
        this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.h();
        paramView.setTag(-3, Integer.valueOf(0));
        this.jdField_d_of_type_Boolean = true;
        break label400;
      }
      Object localObject2;
      label970:
      Object localObject3;
      if (n == jdField_a_of_type_Int)
      {
        ((View)localObject1).setTag(2131296517, Integer.valueOf(paramInt));
        paramView = (SubscriptFeedsAdapter.FeedItemCellHolder)((View)localObject1).getTag();
        paramViewGroup = (SubscriptionFeed)getItem(paramInt);
        if (this.jdField_a_of_type_JavaUtilHashSet != null) {
          this.jdField_a_of_type_JavaUtilHashSet.add(paramViewGroup.jdField_a_of_type_JavaLangString);
        }
        paramView.jdField_a_of_type_JavaLangString = paramViewGroup.jdField_a_of_type_JavaLangString;
        a(paramView, paramViewGroup.jdField_a_of_type_JavaLangString);
        localObject2 = TroopBarAssistantManager.a().a(paramViewGroup.jdField_a_of_type_JavaLangString);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup.jdField_a_of_type_JavaLangString);
          paramView.jdField_b_of_type_AndroidWidgetTextView.setText(TimeManager.a().a(paramViewGroup.jdField_a_of_type_JavaLangString, paramViewGroup.jdField_a_of_type_Long));
          if (paramViewGroup.h <= 0) {
            break label1309;
          }
          m = 3;
          CustomWidgetUtil.a(paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, m, paramViewGroup.h, 2130843325, 99, null);
          if (paramViewGroup.jdField_a_of_type_JavaUtilList.size() <= 0) {
            break label1668;
          }
          localObject3 = (SubscriptionFeedItem)paramViewGroup.jdField_a_of_type_JavaUtilList.get(0);
          if (((SubscriptionFeedItem)localObject3).e != 0) {
            break label1315;
          }
          paramView.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(1);
          paramView.jdField_c_of_type_AndroidWidgetTextView.setText(new QQText(((SubscriptionFeedItem)localObject3).c.replaceFirst("^\\s+", ""), 3, 20));
          paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          label1080:
          paramView.jdField_a_of_type_AndroidViewViewGroup.setTag(2131296519, Integer.valueOf(paramViewGroup.h));
          paramView.jdField_a_of_type_AndroidViewViewGroup.setTag(2131296520, paramViewGroup.jdField_a_of_type_JavaLangString);
          paramView.jdField_a_of_type_AndroidViewViewGroup.setTag(2131296521, localObject2);
          paramView.jdField_a_of_type_AndroidViewViewGroup.setTag(2131296518, Integer.valueOf(jdField_d_of_type_Int));
          paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131296519, paramViewGroup);
          paramView.jdField_a_of_type_AndroidWidgetButton.setTag(2131296520, paramViewGroup.jdField_a_of_type_JavaLangString);
          paramView.jdField_b_of_type_AndroidWidgetButton.setTag(2131296520, paramViewGroup.jdField_a_of_type_JavaLangString);
          paramView.jdField_c_of_type_AndroidWidgetButton.setTag(2131296520, paramViewGroup.jdField_a_of_type_JavaLangString);
          paramView.jdField_c_of_type_AndroidWidgetButton.setTag(2131296521, localObject2);
          paramView.d.setTag(2131296520, paramViewGroup.jdField_a_of_type_JavaLangString);
          if (TroopBarAssistantManager.a().a(paramViewGroup.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            break label1706;
          }
          if (this.jdField_c_of_type_Boolean) {
            break label1693;
          }
          paramView.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130839532);
          label1252:
          ((View)localObject1).setTag(-3, Integer.valueOf((int)(this.jdField_a_of_type_Float + this.jdField_c_of_type_Float + this.jdField_d_of_type_Float)));
          paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          paramView.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        }
      }
      for (;;)
      {
        return (View)localObject1;
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        break;
        label1309:
        m = 0;
        break label970;
        label1315:
        ViewGroup.LayoutParams localLayoutParams;
        if (((SubscriptionFeedItem)localObject3).e == 1)
        {
          paramView.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(2);
          paramView.jdField_c_of_type_AndroidWidgetTextView.setText(((SubscriptionFeedItem)localObject3).b.replaceFirst("^\\s+", ""));
          paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          if (TextUtils.isEmpty(((SubscriptionFeedItem)localObject3).g)) {
            paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          for (;;)
          {
            paramView.jdField_b_of_type_AndroidWidgetImageView.setTag(2131296520, paramView.jdField_a_of_type_JavaLangString);
            paramView.jdField_b_of_type_AndroidWidgetImageView.setTag(2131296522, Integer.valueOf(jdField_a_of_type_Int));
            localLayoutParams = paramView.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
            this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager.a(PubAccountHttpDownloader.a(((SubscriptionFeedItem)localObject3).jdField_a_of_type_JavaLangString, 1, paramViewGroup.jdField_a_of_type_JavaLangString), paramView.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams.width, localLayoutParams.height, this);
            if (!(paramView.jdField_b_of_type_AndroidWidgetImageView.getDrawable() instanceof URLDrawable)) {
              break;
            }
            localObject3 = (URLDrawable)paramView.jdField_b_of_type_AndroidWidgetImageView.getDrawable();
            if (paramInt < 10) {
              break;
            }
            ((URLDrawable)localObject3).setAutoDownload(false);
            break;
            paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          }
        }
        if (((SubscriptionFeedItem)localObject3).e == 2)
        {
          paramView.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(1);
          paramView.jdField_c_of_type_AndroidWidgetTextView.setText(2131364549);
          paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          paramView.jdField_b_of_type_AndroidWidgetImageView.setTag(2131296520, paramView.jdField_a_of_type_JavaLangString);
          paramView.jdField_b_of_type_AndroidWidgetImageView.setTag(2131296522, Integer.valueOf(jdField_a_of_type_Int));
          localLayoutParams = paramView.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
          this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager.a(PubAccountHttpDownloader.a(((SubscriptionFeedItem)localObject3).jdField_a_of_type_JavaNetURL.toString(), 1, paramViewGroup.jdField_a_of_type_JavaLangString), paramView.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams.width, localLayoutParams.height, this);
          break label1080;
        }
        paramView.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(1);
        paramView.jdField_c_of_type_AndroidWidgetTextView.setText(2131364552);
        paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        break label1080;
        label1668:
        if ((!QLog.isColorLevel()) || (!QLog.isColorLevel())) {
          break label1080;
        }
        QLog.w(jdField_a_of_type_JavaLangString, 2, "getView feed.mItems.size() == 0, is error!!");
        break label1080;
        label1693:
        paramView.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130839534);
        break label1252;
        label1706:
        if (!this.jdField_c_of_type_Boolean) {
          paramView.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130839533);
        }
        for (;;)
        {
          ((View)localObject1).setTag(-3, Integer.valueOf((int)(this.jdField_b_of_type_Float + this.jdField_c_of_type_Float + this.jdField_d_of_type_Float)));
          paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          paramView.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
          break;
          paramView.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130839535);
        }
        if (n == jdField_b_of_type_Int)
        {
          ((View)localObject1).setTag(2131296517, Integer.valueOf(paramInt));
          this.l += 1;
          paramView = (idu)((View)localObject1).getTag();
          m = paramView.jdField_a_of_type_JavaUtilArrayList.size();
          paramInt = 0;
          while (paramInt < m)
          {
            localObject2 = (ViewGroup)paramView.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
            paramViewGroup = (TextView)((ViewGroup)localObject2).findViewById(2131300008);
            localObject2 = (ImageView)((ViewGroup)localObject2).findViewById(2131300007);
            if (paramInt < this.jdField_b_of_type_JavaUtilList.size())
            {
              localObject3 = (ReadInJoyArticle)this.jdField_b_of_type_JavaUtilList.get(paramInt);
              paramViewGroup.setText(((ReadInJoyArticle)localObject3).mTitle.replaceFirst("^\\s+", ""));
              ((ImageView)localObject2).setTag(2131296522, Integer.valueOf(jdField_b_of_type_Int));
              paramViewGroup = (WindowManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("window");
              this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager.a(PubAccountHttpDownloader.a(((ReadInJoyArticle)localObject3).mFirstPagePicUrl, 1), (ImageView)localObject2, paramViewGroup.getDefaultDisplay().getWidth(), paramViewGroup.getDefaultDisplay().getHeight(), this);
            }
            paramInt += 1;
          }
        }
        else if (n != jdField_c_of_type_Int) {}
      }
      label2003:
      break label400;
    }
  }
  
  public int getViewTypeCount()
  {
    return h;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\subscript\SubscriptFeedsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */