import QQService.EVIPSPEC;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.ViewHolder;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class pmo
  extends BaseAdapter
{
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View jdField_a_of_type_AndroidViewView;
  
  public pmo(SpecailCareListActivity paramSpecailCareListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramSpecailCareListActivity.getSystemService("layout_inflater"));
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public int getCount()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.b.size();
    if (i > 0) {
      return i;
    }
    return 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.b.size()) {
      return this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.b.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.b.size() == 0) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject1;
    if (getItemViewType(paramInt) == 1)
    {
      localView = paramView;
      if (paramView == null)
      {
        localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904360, paramViewGroup, false);
        paramView = localView.getLayoutParams();
        if (paramView == null) {
          break label179;
        }
        paramView.height = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentWidgetXListView.getHeight();
        paramView.width = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentWidgetXListView.getWidth();
      }
      for (;;)
      {
        localView.setLayoutParams(paramView);
        paramInt = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.app.getManager(50)).c();
        paramView = (Button)localView.findViewById(2131302519);
        if (QLog.isColorLevel()) {
          QLog.d("SpecialCare", 2, "getView  friends count = " + paramInt);
        }
        paramViewGroup = (TextView)localView.findViewById(2131298153);
        localObject1 = (TextView)localView.findViewById(2131298160);
        if (paramInt > 0) {
          break;
        }
        ((TextView)localObject1).setVisibility(8);
        paramView.setVisibility(8);
        paramViewGroup = localView;
        return paramViewGroup;
        label179:
        paramView = new ViewGroup.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentWidgetXListView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentWidgetXListView.getHeight());
      }
      ((TextView)localObject1).setVisibility(0);
      paramView.setVisibility(0);
      paramViewGroup.setText(2131371038);
      paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity);
      return localView;
    }
    Object localObject2;
    if (paramView != null)
    {
      localObject1 = (SpecailCareListActivity.ViewHolder)paramView.getTag();
      localObject2 = localObject1;
      localView = paramView;
      if (localObject1 == null)
      {
        localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904364, paramViewGroup, false);
        localObject2 = new SpecailCareListActivity.ViewHolder();
        localView.setTag(localObject2);
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131296790));
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297741));
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297743));
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297746));
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131297734));
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131302527));
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131297678));
        ((SpecailCareListActivity.ViewHolder)localObject2).e = ((ImageView)localView.findViewById(2131297744));
        ((SpecailCareListActivity.ViewHolder)localObject2).f = ((ImageView)localView.findViewById(2131297745));
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView = localView.findViewById(2131302528);
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131297735));
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297739));
        ((SpecailCareListActivity.ViewHolder)localObject2).g = ((ImageView)localView.findViewById(2131297738));
        ((SpecailCareListActivity.ViewHolder)localObject2).h = ((ImageView)localView.findViewById(2131297737));
        ((SpecailCareListActivity.ViewHolder)localObject2).i = ((ImageView)localView.findViewById(2131297736));
        localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity);
      }
      localObject1 = (Friends)this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.b.get(paramInt);
      ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqDataFriends = ((Friends)localObject1);
      ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_JavaLangString = ((Friends)localObject1).uin;
      ((SpecailCareListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView.setTag(((Friends)localObject1).uin);
      ((SpecailCareListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity);
      if (AppSetting.j) {
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView.setContentDescription("删除");
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, ((Friends)localObject1).uin, 0);
      if (paramView != null) {
        break label1573;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(((Friends)localObject1).uin, 1, true);
      }
      ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((BitmapDrawable)ImageUtil.a());
      label665:
      paramInt = ContactUtils.a(((Friends)localObject1).detalStatusFlag, ((Friends)localObject1).iTermType);
      paramView = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.app.a(1);
      switch (paramInt)
      {
      case 5: 
      case 6: 
      default: 
        paramView = paramView.a(((Friends)localObject1).getLastLoginType());
        if (paramView == null) {
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131370230);
        }
        break;
      }
    }
    for (;;)
    {
      label765:
      if ((paramInt == 0) || (paramInt == 6))
      {
        paramInt = 1;
        label777:
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetTextView.setText("[" + paramView + "]");
        this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.a((Friends)localObject1, (SpecailCareListActivity.ViewHolder)localObject2);
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        if (paramInt != 0) {
          break label2020;
        }
      }
      label902:
      label942:
      label1314:
      label1485:
      label1526:
      label1573:
      label1661:
      label1719:
      label1844:
      label1888:
      label1932:
      label2020:
      for (int i = ((Friends)localObject1).netTypeIconId;; i = 0)
      {
        int k;
        int m;
        int n;
        int i1;
        RelativeLayout.LayoutParams localLayoutParams1;
        RelativeLayout.LayoutParams localLayoutParams2;
        int i2;
        float f;
        if ((paramInt == 0) && ((((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) || (((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) || (((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_QQVIP))))
        {
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getResources().getColorStateList(2131428329));
          if (!((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
            break label1661;
          }
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.g);
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130843363, 0);
          String str = ContactUtils.a((Friends)localObject1);
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(str);
          paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(((Friends)localObject1).uin, false);
          boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.d();
          int j = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(((Friends)localObject1).uin, paramViewGroup, 0, bool);
          k = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(((Friends)localObject1).uin, paramViewGroup, bool);
          m = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.c(((Friends)localObject1).uin, paramViewGroup, bool);
          n = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(((Friends)localObject1).uin, paramViewGroup, bool);
          this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.a((SpecailCareListActivity.ViewHolder)localObject2, j, k, m, n);
          i1 = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.a((SpecailCareListActivity.ViewHolder)localObject2);
          paramViewGroup = new RelativeLayout.LayoutParams((int)(50.0F * SpecailCareListActivity.l(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), (int)(50.0F * SpecailCareListActivity.m(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)));
          paramViewGroup.addRule(15);
          localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams1.addRule(1, 2131296790);
          localLayoutParams1.addRule(10);
          localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams2.addRule(1, 2131296790);
          if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.c) {
            break label1719;
          }
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(4);
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.setMargins((int)(46.0F * SpecailCareListActivity.n(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0, (int)(10.0F * SpecailCareListActivity.o(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0);
          i2 = (int)(22.0F * SpecailCareListActivity.p(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity));
          f = SpecailCareListActivity.q(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity);
          localLayoutParams1.setMargins(0, i2, (int)(i1 + 23.0F * f), 0);
          localLayoutParams2.setMargins(0, (int)(24.0F * SpecailCareListActivity.r(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0, 0);
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramViewGroup);
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams1);
          paramViewGroup = localView;
          if (!AppSetting.j) {
            break;
          }
          paramViewGroup = new StringBuilder(24);
          paramViewGroup.append(str).append(".").append(paramView).append(".");
          if ((((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) || (((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_QQVIP))) {
            paramViewGroup.append("QQ会员").append(".");
          }
          paramViewGroup.append(((SpecailCareListActivity.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.getText()).append(".");
          if (paramInt == 0) {
            paramViewGroup.append(ContactUtils.b(i));
          }
          if (n != 1) {
            break label1844;
          }
          paramViewGroup.append(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131372675, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.f) }));
          if (m != 1) {
            break label1888;
          }
          paramViewGroup.append(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131372673, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.d) }));
          if (j <= 0) {
            break label1932;
          }
          paramViewGroup.append(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131372677, new Object[] { Integer.valueOf(j) }));
        }
        for (;;)
        {
          localView.setContentDescription(paramViewGroup);
          return localView;
          localObject1 = null;
          break;
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramView));
          break label665;
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131370233);
          break label765;
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131370234);
          break label765;
          paramView = ContactUtils.a(((Friends)localObject1).netTypeIconId);
          break label765;
          paramInt = 0;
          break label777;
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getResources().getColorStateList(2131428262));
          break label902;
          if (((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_QQVIP))
          {
            ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.g);
            ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130843496, 0);
            break label942;
          }
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          break label942;
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(0);
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          paramViewGroup.setMargins((int)(12.0F * SpecailCareListActivity.s(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0, (int)(10.0F * SpecailCareListActivity.t(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0);
          i2 = (int)(10.0F * SpecailCareListActivity.u(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity));
          f = SpecailCareListActivity.v(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity);
          localLayoutParams1.setMargins(0, i2, (int)(i1 + 30.0F * f), 0);
          localLayoutParams2.setMargins(0, (int)(36.0F * SpecailCareListActivity.w(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0, 0);
          break label1314;
          if (n != 2) {
            break label1485;
          }
          paramViewGroup.append(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131372676, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.g) }));
          break label1485;
          if (m != 2) {
            break label1526;
          }
          paramViewGroup.append(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131372674, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.e) }));
          break label1526;
          if (k == 1) {
            paramViewGroup.append(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131372671, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b) }));
          } else if (k == 2) {
            paramViewGroup.append(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131372672, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.c) }));
          }
        }
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pmo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */