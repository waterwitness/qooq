package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.PADetailReportUtil;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.activity.GroupSearchActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ohm;
import ohn;
import oho;

public class ClassificationSearchFragment
  extends SearchBaseFragment
{
  private static SearchResult jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult;
  private static final String jdField_e_of_type_JavaLangString = "ClassificationSearchFragment";
  private static boolean jdField_e_of_type_Boolean = false;
  private static final int l = 0;
  private static final int m = 1;
  private static final int n = 2;
  private static final int o = 3;
  private static final int p = 4;
  private static int r = 0;
  private static final int t = 0;
  private static final int u = 1;
  private static final int v = 2;
  private static final int w = 3;
  public int a;
  private View jdField_a_of_type_AndroidViewView;
  private List jdField_a_of_type_JavaUtilList;
  private oho jdField_a_of_type_Oho;
  public boolean a;
  int b;
  private boolean d;
  private int q;
  private int s;
  
  public ClassificationSearchFragment()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(20);
  }
  
  public static ClassificationSearchFragment a(int paramInt)
  {
    r = paramInt;
    return new ClassificationSearchFragment();
  }
  
  public static ClassificationSearchFragment a(SearchResult paramSearchResult)
  {
    jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult = paramSearchResult;
    return new ClassificationSearchFragment();
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Oho != null) {
      this.jdField_a_of_type_Oho.notifyDataSetChanged();
    }
  }
  
  private boolean b(ArrayList paramArrayList)
  {
    if ((!this.jdField_b_of_type_Boolean) && (paramArrayList != null) && (paramArrayList.size() == 1))
    {
      Object localObject = ((SearchResult)paramArrayList.get(0)).jdField_b_of_type_JavaUtilList;
      if ((localObject != null) && (((List)localObject).size() == 1))
      {
        localObject = (AccountSearchPb.record)((List)localObject).get(0);
        a(((SearchResult)paramArrayList.get(0)).jdField_a_of_type_Int, (AccountSearchPb.record)localObject);
        return true;
      }
    }
    return false;
  }
  
  private String c(SearchBaseFragment.ItemViewHolder paramItemViewHolder, AccountSearchPb.record paramrecord)
  {
    int j = 11;
    StringBuilder localStringBuilder = new StringBuilder();
    paramItemViewHolder.jdField_a_of_type_JavaLangString = (paramrecord.uin.get() + "");
    paramItemViewHolder.jdField_b_of_type_JavaLangString = paramrecord.mobile.get();
    boolean bool;
    Object localObject2;
    Object localObject1;
    label147:
    label220:
    int i;
    if (paramrecord.uin.get() != 0L)
    {
      bool = true;
      paramItemViewHolder.jdField_a_of_type_Boolean = bool;
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(a(paramItemViewHolder.jdField_b_of_type_Int, paramrecord.name.get()));
      localStringBuilder.append(paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.getText());
      if (paramItemViewHolder.jdField_b_of_type_Int == 80000000)
      {
        localObject2 = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject2).append("(");
        if (!paramItemViewHolder.jdField_a_of_type_Boolean) {
          break label340;
        }
        localObject1 = paramItemViewHolder.jdField_a_of_type_JavaLangString;
        ((SpannableStringBuilder)localObject2).append(a(80000000, (String)localObject1));
        ((SpannableStringBuilder)localObject2).append(")");
        paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        localStringBuilder.append(paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getText());
      }
      switch (this.jdField_d_of_type_Int)
      {
      case 1: 
      default: 
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
        if (paramItemViewHolder.jdField_a_of_type_Boolean)
        {
          i = 1;
          label235:
          if (!paramItemViewHolder.jdField_a_of_type_Boolean) {
            break label385;
          }
          paramrecord = paramItemViewHolder.jdField_a_of_type_JavaLangString;
          label247:
          localObject1 = ((FaceDecoder)localObject1).a(i, paramrecord);
          paramrecord = (AccountSearchPb.record)localObject1;
          if (localObject1 == null)
          {
            localObject1 = ImageUtil.a();
            if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b())
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
              if (!paramItemViewHolder.jdField_a_of_type_Boolean) {
                break label393;
              }
            }
          }
        }
        break;
      }
    }
    label340:
    label385:
    label393:
    for (paramrecord = paramItemViewHolder.jdField_a_of_type_JavaLangString;; paramrecord = paramItemViewHolder.jdField_b_of_type_JavaLangString)
    {
      i = j;
      if (paramItemViewHolder.jdField_a_of_type_Boolean) {
        i = 1;
      }
      ((FaceDecoder)localObject2).a(paramrecord, i, true, (byte)1);
      paramrecord = (AccountSearchPb.record)localObject1;
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramrecord);
      return localStringBuilder.toString();
      bool = false;
      break;
      localObject1 = paramItemViewHolder.jdField_b_of_type_JavaLangString;
      break label147;
      localStringBuilder.append(a(paramItemViewHolder, paramrecord));
      break label220;
      localStringBuilder.append(b(paramItemViewHolder, paramrecord));
      break label220;
      i = 11;
      break label235;
      paramrecord = paramItemViewHolder.jdField_b_of_type_JavaLangString;
      break label247;
    }
  }
  
  protected void a()
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("isGetMore = ").append(this.jdField_b_of_type_Boolean).append(" mListData is null = ");
      if (this.jdField_a_of_type_JavaUtilList != null) {
        break label75;
      }
    }
    label75:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ClassificationSearchFragment", 2, bool);
      if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilList != null)) {
        break;
      }
      f();
      return;
    }
    if (this.jdField_a_of_type_Oho == null)
    {
      this.jdField_a_of_type_Oho = new oho(this, null);
      this.jdField_a_of_type_Oho.a(this.jdField_a_of_type_JavaUtilList);
      localObject2 = this.jdField_a_of_type_AndroidViewView;
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.jdField_d_of_type_Int == 0)
      {
        localObject1 = "好友";
        label135:
        ((View)localObject2).setContentDescription((String)localObject1 + "搜索结果");
        this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_a_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Oho);
        this.a = this.jdField_a_of_type_Oho;
      }
    }
    else
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0) != this.jdField_a_of_type_ComTencentWidgetXListView)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentWidgetXListView);
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label356;
      }
      this.jdField_a_of_type_Oho.a().addAll(this.jdField_a_of_type_JavaUtilList);
    }
    int i;
    for (;;)
    {
      this.jdField_a_of_type_Oho.notifyDataSetChanged();
      if (this.c)
      {
        this.c = false;
        this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      }
      if ((this.jdField_d_of_type_Int != 2) || (this.jdField_a_of_type_JavaUtilList == null)) {
        break;
      }
      localObject1 = new StringBuilder();
      localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        ((StringBuilder)localObject1).append(String.valueOf(((AccountSearchPb.record)((Iterator)localObject2).next()).uin.get())).append("#");
        i += 1;
      }
      localObject1 = "公共号";
      break label135;
      label356:
      this.jdField_a_of_type_Oho.a(this.jdField_a_of_type_JavaUtilList);
    }
    Object localObject2 = PADetailReportUtil.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_d_of_type_JavaLangString);
    PADetailReportUtil.a().a((String)localObject2, this.jdField_d_of_type_JavaLangString, 3, true, i, ((StringBuilder)localObject1).toString());
  }
  
  public void a(int paramInt)
  {
    this.s = paramInt;
  }
  
  protected void a(String paramString)
  {
    super.a(paramString);
    b(3);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Boolean) {
      if (GroupSearchActivity.e == 12) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_d_of_type_JavaLangString, this.q, 0.0D, 0.0D, 1);
      }
    }
    for (;;)
    {
      if (this.jdField_d_of_type_Int == 2)
      {
        paramString = getActivity();
        if ((paramString != null) && ((paramString instanceof SearchBaseActivity)))
        {
          int i = ((SearchBaseActivity)paramString).a();
          int j = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a();
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D21", "0X8005D21", 0, 1, 0, "" + (j + 1), SearchBaseActivity.JumpSrcConstants.a(i), this.jdField_d_of_type_JavaLangString, "");
        }
      }
      return;
      if (r == ClassificationSearchActivity.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_d_of_type_JavaLangString, this.q, 0.0D, 0.0D, 2);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_d_of_type_JavaLangString, this.q, 0.0D, 0.0D, 0);
        continue;
        if (NetworkUtil.e(BaseApplicationImpl.getContext()))
        {
          h();
          this.jdField_d_of_type_JavaLangString = paramString;
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.c();
          if (GroupSearchActivity.e == 12) {
            this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_d_of_type_JavaLangString, this.q, 0.0D, 0.0D, 1);
          }
          for (;;)
          {
            this.c = true;
            break;
            if (r == ClassificationSearchActivity.jdField_a_of_type_Int) {
              this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_d_of_type_JavaLangString, this.q, 0.0D, 0.0D, 2);
            } else {
              this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_d_of_type_JavaLangString, this.q, 0.0D, 0.0D, 0);
            }
          }
        }
        QQToast.a(BaseApplicationImpl.getContext(), 2131369008, 0).b(a());
        b(4);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  protected boolean a(ArrayList paramArrayList)
  {
    SearchResult localSearchResult = (SearchResult)paramArrayList.get(0);
    if (b(paramArrayList))
    {
      this.jdField_d_of_type_Boolean = true;
      return false;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new ohm(this, localSearchResult));
    }
    if (QLog.isColorLevel()) {
      QLog.d("ClassificationSearchFragment", 2, "is no more page  = " + localSearchResult.jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_JavaUtilList = localSearchResult.jdField_b_of_type_JavaUtilList;
    if (!this.jdField_b_of_type_Boolean) {
      d();
    }
    a(paramArrayList);
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      b(2);
      a(this.jdField_d_of_type_JavaLangString, true);
    }
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Int == 2) {
      b(0);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    Object localObject2;
    AccountSearchPb.record localrecord;
    Object localObject3;
    if (localObject1 != null)
    {
      if (!(localObject1 instanceof SearchBaseFragment.ItemViewHolder)) {
        break label450;
      }
      localObject2 = (SearchBaseFragment.ItemViewHolder)localObject1;
      a(((SearchBaseFragment.ItemViewHolder)localObject2).jdField_b_of_type_Int, ((SearchBaseFragment.ItemViewHolder)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record);
      int i = ((SearchBaseFragment.ItemViewHolder)localObject2).c;
      int j = ((SearchBaseFragment.ItemViewHolder)localObject2).jdField_b_of_type_Int;
      int k = ((SearchBaseFragment.ItemViewHolder)localObject2).c;
      if (((SearchBaseFragment.ItemViewHolder)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin == null) {
        break label335;
      }
      localObject1 = ((SearchBaseFragment.ItemViewHolder)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get() + "";
      SearchUtils.a(j, 0, k, false, (String)localObject1, this.jdField_d_of_type_JavaLangString, GroupSearchActivity.e);
      if (((SearchBaseFragment.ItemViewHolder)localObject2).jdField_b_of_type_Int == 80000002)
      {
        localrecord = ((SearchBaseFragment.ItemViewHolder)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
        localObject1 = getActivity();
        if ((localObject1 != null) && ((localObject1 instanceof ClassificationSearchActivity)))
        {
          localObject1 = SearchBaseActivity.JumpSrcConstants.a(((SearchBaseActivity)localObject1).a());
          paramView = paramView.getTag(2131297389);
          if ((paramView != null) && ((paramView instanceof Integer))) {
            ((SearchBaseFragment.ItemViewHolder)localObject2).c = (((Integer)paramView).intValue() + 1);
          }
          localObject3 = PADetailReportUtil.a();
          if (localrecord.uin == null) {
            break label340;
          }
          paramView = localrecord.uin.get() + "";
          label222:
          ((PADetailReportUtil)localObject3).a(3, paramView, i, GroupSearchActivity.e);
          if (GroupSearchActivity.e != 12) {
            break label352;
          }
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject2 = ((SearchBaseFragment.ItemViewHolder)localObject2).c + "";
          if (localrecord.uin == null) {
            break label346;
          }
          paramView = localrecord.uin.get() + "";
          label306:
          ReportController.b((QQAppInterface)localObject3, "CliOper", "", "", "0X800658B", "0X800658B", 0, 1, 0, (String)localObject2, (String)localObject1, paramView, this.jdField_d_of_type_JavaLangString);
        }
      }
    }
    label335:
    label340:
    label346:
    label352:
    label450:
    label512:
    do
    {
      do
      {
        return;
        localObject1 = null;
        break;
        paramView = "";
        break label222;
        paramView = "";
        break label306;
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localrecord.uin != null) {}
        for (paramView = localrecord.uin.get() + "";; paramView = "")
        {
          ReportController.b((QQAppInterface)localObject3, "P_CliOper", "Pb_account_lifeservice", paramView, "0X8005D22", "0X8005D22", 0, 1, 0, ((SearchBaseFragment.ItemViewHolder)localObject2).c + "", (String)localObject1, this.jdField_d_of_type_JavaLangString, "");
          return;
        }
        if (!(localObject1 instanceof ohn)) {
          break label512;
        }
      } while ((this.jdField_a_of_type_Int != 3) && (this.jdField_a_of_type_Int != 4));
      if (NetworkUtil.e(BaseApplicationImpl.getContext()))
      {
        b(1);
        return;
      }
      QQToast.a(BaseApplicationImpl.getContext(), 2131369008, 0).b(a());
      b(4);
      return;
    } while (!(localObject1 instanceof SearchBaseFragment.ArticleItemViewHolder));
    paramView = (SearchBaseFragment.ArticleItemViewHolder)localObject1;
    localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("url", paramView.jdField_a_of_type_JavaLangString);
    if (GroupSearchActivity.e == 1) {
      ((Intent)localObject1).putExtra("articalChannelId", 10);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject1);
      if (GroupSearchActivity.e != 12) {
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800658C", "0X800658C", 0, 0, "" + paramView.jdField_a_of_type_Int, "", this.jdField_d_of_type_JavaLangString, "" + paramView.jdField_a_of_type_Long);
      return;
      if (GroupSearchActivity.e == 2) {
        ((Intent)localObject1).putExtra("articalChannelId", 11);
      } else if (this.s == 14) {
        ((Intent)localObject1).putExtra("articalChannelId", 14);
      } else if (this.s == 13) {
        ((Intent)localObject1).putExtra("articalChannelId", 12);
      } else if (this.s == 15) {
        ((Intent)localObject1).putExtra("articalChannelId", 13);
      }
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D97", "0X8005D97", 0, 0, "" + paramView.jdField_a_of_type_Int, "", this.jdField_d_of_type_JavaLangString, "" + paramView.jdField_a_of_type_Long);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = a().getLayoutInflater().inflate(2130903375, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      this.jdField_a_of_type_AndroidViewView.setClickable(false);
      this.jdField_a_of_type_AndroidViewView.setFocusable(true);
    }
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    PADetailReportUtil.a().b();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult != null)
    {
      int i;
      if (!jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult.jdField_a_of_type_Boolean)
      {
        i = 1;
        b(i);
        this.jdField_a_of_type_JavaUtilList.addAll(jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult.jdField_b_of_type_JavaUtilList);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult.jdField_b_of_type_Int);
        if (ViewFactory.a(jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult.jdField_a_of_type_Int) != 2131369706) {
          break label165;
        }
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297123)).setText(PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext()));
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_JavaUtilMap.size() == 0) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
        {
          paramView = new ArrayList();
          paramView.add(jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult);
          a(paramView);
        }
        jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult = null;
        a();
        this.q = b();
        return;
        i = 0;
        break;
        label165:
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297123)).setText(ViewFactory.a(jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult.jdField_a_of_type_Int));
      }
    }
    if ((r == ClassificationSearchActivity.jdField_a_of_type_Int) || (r == ClassificationSearchActivity.jdField_b_of_type_Int)) {
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297123)).setText(ViewFactory.a(80000003));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClassificationSearchFragment", 2, "searchResult is null");
      }
      f();
      break;
      if (r == ClassificationSearchActivity.c) {
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297123)).setText(ViewFactory.a(80000002));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\contact\addcontact\ClassificationSearchFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */