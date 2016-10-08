import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.dating.DatingTopListActivity;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.dating.GodEntity;
import com.tencent.mobileqq.dating.GodListConfig;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.ImgDownloadListener;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;
import java.util.Set;

public class rfc
  extends BaseAdapter
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  int e;
  
  public rfc(DatingTopListActivity paramDatingTopListActivity, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.e = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramDatingTopListActivity.getLayoutInflater();
    this.e = paramInt;
  }
  
  private View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      localObject1 = paramView.getTag();
      if (!(localObject1 instanceof rex)) {}
    }
    for (Object localObject1 = (rex)localObject1;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity.getLayoutInflater().inflate(2130904227, paramViewGroup, false);
        localObject2 = new rex();
        ((rex)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298153));
        ((rex)localObject2).b = ((TextView)paramView.findViewById(2131298160));
        paramView.setTag(localObject2);
      }
      paramViewGroup = new LinearLayout.LayoutParams(((rex)localObject2).jdField_a_of_type_AndroidWidgetTextView.getLayoutParams());
      paramViewGroup.leftMargin = 50;
      paramViewGroup.rightMargin = 50;
      ((rex)localObject2).jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramViewGroup);
      localObject1 = ((rex)localObject2).jdField_a_of_type_AndroidWidgetTextView;
      DatingTopListActivity localDatingTopListActivity = this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity;
      if ((this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity.g == 0) || (this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity.g == 2)) {}
      for (paramViewGroup = "男";; paramViewGroup = "女")
      {
        ((TextView)localObject1).setText(localDatingTopListActivity.getString(2131371598, new Object[] { paramViewGroup }));
        ((rex)localObject2).b.setVisibility(4);
        return paramView;
      }
    }
  }
  
  private View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity.getLayoutInflater().inflate(2130904319, paramViewGroup, false);
      paramView = new rfa();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131302308));
      localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity);
      localView.setTag(paramView);
    }
    paramViewGroup = ((rfa)localView.getTag()).jdField_a_of_type_AndroidWidgetTextView;
    if ((this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity.g == 0) || (this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity.g == 2)) {}
    for (paramView = "男神标识";; paramView = "女神标识")
    {
      paramViewGroup.setText(paramView);
      return localView;
    }
  }
  
  private View c(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    int i;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity.getLayoutInflater().inflate(2130904328, paramViewGroup, false);
      paramView = new rfb();
      localView.setLayoutParams(new AbsListView.LayoutParams(DatingTopListActivity.d(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity), DatingTopListActivity.d(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity) * 15 / 16 + DatingTopListActivity.c()));
      localObject1 = (ImageView)localView.findViewById(2131302327);
      localObject2 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = DatingTopListActivity.c();
      ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject1);
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity.getLayoutInflater().inflate(2130904318, paramViewGroup, false);
      localObject1 = new RelativeLayout.LayoutParams(paramViewGroup.getLayoutParams());
      ((RelativeLayout.LayoutParams)localObject1).addRule(12);
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = DatingTopListActivity.c();
      localObject2 = (LinearLayout)paramViewGroup.findViewById(2131302303);
      ((LinearLayout)localObject2).measure(0, 0);
      i = ((LinearLayout)localObject2).getMeasuredWidth();
      i = (DatingTopListActivity.d(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity) - i * 3) / 4;
      LinearLayout localLinearLayout1 = (LinearLayout)paramViewGroup.findViewById(2131302305);
      LinearLayout localLinearLayout2 = (LinearLayout)paramViewGroup.findViewById(2131302307);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(localLinearLayout1.getLayoutParams());
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131302301);
      localLayoutParams.leftMargin = i;
      ((LinearLayout)localObject2).setLayoutParams(localLayoutParams);
      localLinearLayout1.setLayoutParams(localLayoutParams);
      localLinearLayout2.setLayoutParams(localLayoutParams);
      paramView.jdField_a_of_type_AndroidWidgetTextView = localTextView;
      paramView.b = ((TextView)paramViewGroup.findViewById(2131302304));
      paramView.c = ((TextView)paramViewGroup.findViewById(2131302306));
      ((LinearLayout)localObject2).setTag(paramView);
      localLinearLayout1.setTag(paramView);
      localLinearLayout2.setTag(paramView);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setTag(paramView);
      ((LinearLayout)localObject2).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity);
      localLinearLayout1.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity);
      localLinearLayout2.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity);
      paramView.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131302300));
      ((RelativeLayout)localView.findViewById(2131302341)).addView(paramViewGroup, (ViewGroup.LayoutParams)localObject1);
      localView.setTag(paramView);
      localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity);
    }
    Object localObject1 = (rfb)localView.getTag();
    Object localObject2 = (GodEntity)getItem(paramInt);
    ((rfb)localObject1).jdField_a_of_type_ComTencentMobileqqDatingGodEntity = ((GodEntity)localObject2);
    ((rfb)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(((GodEntity)localObject2).nickName);
    ((rfb)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (paramInt < 3)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity.getResources().getIdentifier("qq_ranking_no_" + (paramInt + 1), "drawable", this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity.getApplicationContext().getPackageName());
      ((rfb)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(i);
      ((rfb)localObject1).b.setText(DatingTopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity, ((GodEntity)localObject2).praiseCount));
      localView.setContentDescription(String.format("第%d名 %s 被赞%d次", new Object[] { Integer.valueOf(paramInt + 1), ((GodEntity)localObject2).nickName, Integer.valueOf(((GodEntity)localObject2).praiseCount) }));
      if (((GodEntity)localObject2).praiseflag != 1) {
        break label890;
      }
      ((rfb)localObject1).b.setCompoundDrawablesWithIntrinsicBounds(2130841172, 0, 0, 0);
      ((rfb)localObject1).c.setText(2131371584);
      paramView = ((GodEntity)localObject2).url;
      paramViewGroup = paramView;
      if (TextUtils.isEmpty(paramView))
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity.b.a().a(String.valueOf(((GodEntity)localObject2).tinyId), 202, true);
        paramViewGroup = paramView;
        if (!TextUtils.isEmpty(paramView))
        {
          ((GodEntity)localObject2).url = paramView;
          paramViewGroup = paramView;
        }
      }
      if (TextUtils.isEmpty(paramViewGroup)) {
        break label923;
      }
    }
    label890:
    label923:
    label989:
    for (;;)
    {
      try
      {
        paramView = URLDrawable.getDrawable(NearbyImgDownloader.a(paramViewGroup), DatingTopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity), DatingTopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity));
        if (paramView != null) {
          break label989;
        }
        paramView = URLDrawable.getDrawable(paramViewGroup, DatingTopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity), DatingTopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity));
        paramView.setDecodeHandler(URLDrawableDecodeHandler.f);
        paramView.setDownloadListener(new ImgDownloadListener(localView.getContext(), "actTopListPicDownload"));
        ((rfb)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        ((rfb)localObject1).jdField_a_of_type_ComTencentImageURLDrawable = paramView;
        return localView;
        ((rfb)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130841127);
        paramView = String.valueOf(paramInt + 1);
        int j = paramView.length();
        i = 0;
        if (i >= j) {
          break;
        }
        paramViewGroup = new TextView(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity);
        paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity.getResources().getIdentifier("qq_ranking_small_" + paramView.charAt(i), "drawable", this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity.getApplicationContext().getPackageName()), 0, 0, 0);
        ((rfb)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramViewGroup);
        i += 1;
        continue;
        ((rfb)localObject1).b.setCompoundDrawablesWithIntrinsicBounds(2130841171, 0, 0, 0);
      }
      catch (Exception paramView)
      {
        if (QLog.isDevelopLevel()) {
          paramView.printStackTrace();
        }
        paramView = null;
        continue;
      }
      ((rfb)localObject1).jdField_a_of_type_AndroidWidgetImageView.setTag(localObject1);
      if (!DatingTopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity).contains(((rfb)localObject1).jdField_a_of_type_AndroidWidgetImageView)) {
        DatingTopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity).add(((rfb)localObject1).jdField_a_of_type_AndroidWidgetImageView);
      }
      ((rfb)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(DatingTopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity));
      return localView;
    }
  }
  
  private View d(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity.getLayoutInflater().inflate(2130904324, paramViewGroup, false);
      paramView = new rez();
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131302327));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131302328));
      paramView.b = ((TextView)localView.findViewById(2131302329));
      paramView.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131302330));
      localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity);
      localView.setTag(paramView);
    }
    paramView = (rez)localView.getTag();
    paramViewGroup = (GodEntity)getItem(paramInt);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup.nickName);
    paramView.b.setText(paramViewGroup.constellation);
    paramView.jdField_a_of_type_ComTencentMobileqqDatingGodEntity = paramViewGroup;
    paramView.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    String str = String.valueOf(paramInt + 1);
    int i = str.length();
    paramInt = 0;
    while (paramInt < i)
    {
      TextView localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity);
      localTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      localTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity.getResources().getIdentifier("qq_ranking_" + str.charAt(paramInt), "drawable", this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity.getApplicationContext().getPackageName()), 0, 0, 0);
      paramView.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localTextView);
      paramInt += 1;
    }
    paramViewGroup = DatingUtil.b(paramViewGroup.tinyId + "", this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity.b, DatingTopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity), 202);
    paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
    return localView;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void b(List paramList)
  {
    if (paramList != null)
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = paramList;
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public int getCount()
  {
    int j = 0;
    int i = 0;
    if (this.jdField_a_of_type_Boolean) {}
    label120:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return 0;
              if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
                return 1;
              }
              if (DatingTopListActivity.c(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity) != 0) {
                break label120;
              }
              if ((DatingTopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity) != null) && (!DatingTopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity).hasMore)) {
                break;
              }
            } while (this.jdField_a_of_type_JavaUtilList == null);
            return this.jdField_a_of_type_JavaUtilList.size();
          } while (this.jdField_a_of_type_JavaUtilList == null);
          j = this.jdField_a_of_type_JavaUtilList.size();
          if (DatingTopListActivity.c(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity)) {}
          for (;;)
          {
            return i + j;
            i = 1;
          }
        } while (DatingTopListActivity.c(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity) != 1);
        if ((DatingTopListActivity.b(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity) != null) && (!DatingTopListActivity.b(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity).hasMore)) {
          break;
        }
      } while (this.jdField_a_of_type_JavaUtilList == null);
      return this.jdField_a_of_type_JavaUtilList.size();
    } while (this.jdField_a_of_type_JavaUtilList == null);
    int k = this.jdField_a_of_type_JavaUtilList.size();
    if (DatingTopListActivity.c(this.jdField_a_of_type_ComTencentMobileqqDatingDatingTopListActivity)) {}
    for (i = j;; i = 1) {
      return i + k;
    }
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {}
    while ((paramInt >= this.jdField_a_of_type_JavaUtilList.size()) || (this.jdField_a_of_type_JavaUtilList == null)) {
      return null;
    }
    return (GodEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {}
    while ((paramInt >= this.jdField_a_of_type_JavaUtilList.size()) || (this.jdField_a_of_type_JavaUtilList == null)) {
      return 0L;
    }
    return ((GodEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt)).tinyId;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return 3;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return 2;
    }
    if (paramInt < this.e) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      return paramView;
    case 0: 
      return c(paramInt, paramView, paramViewGroup);
    case 1: 
      return d(paramInt, paramView, paramViewGroup);
    case 2: 
      return b(paramInt, paramView, paramViewGroup);
    }
    return a(paramInt, paramView, paramViewGroup);
  }
  
  public int getViewTypeCount()
  {
    return 4;
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_Boolean = false;
    super.notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rfc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */