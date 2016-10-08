package com.tencent.mobileqq.activity.contact.addcontact;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.util.PADetailReportUtil;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.NearbyTroops.CustomViewHolder;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import oih;
import oii;
import oij;
import oik;
import oil;

public class SearchContactsFragment
  extends SearchBaseFragment
{
  public static final int b = 0;
  private static final String e = "SearchContactsFragment";
  public static final int l = 1;
  public static final int m = 2;
  public static final int n = 3;
  public static final int o = 4;
  public static final int p = 5;
  private static final int q = 3;
  private static int r = -1;
  private double jdField_a_of_type_Double;
  public int a;
  private ViewFactory.GuideView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView;
  protected SosoInterface.OnLocationListener a;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  public oij a;
  private oil jdField_a_of_type_Oil;
  public boolean a;
  private double jdField_b_of_type_Double;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  private Map jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  private String f;
  private String g = "";
  private String h = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SearchContactsFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new oih(this, 0, true, false, 60000L, false, false, "SearchContacts");
    SosoInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    case 80000000: 
    default: 
      return 1;
    case 80000001: 
      return 2;
    }
    return 3;
  }
  
  public static SearchContactsFragment a(int paramInt)
  {
    r = paramInt;
    return new SearchContactsFragment();
  }
  
  @Deprecated
  public static SearchContactsFragment a(BaseActivity paramBaseActivity, int paramInt)
  {
    SearchContactsFragment localSearchContactsFragment = a(paramInt);
    localSearchContactsFragment.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    Bundle localBundle = new Bundle();
    localBundle.putInt("from_key", paramInt);
    localSearchContactsFragment.setArguments(localBundle);
    localSearchContactsFragment.j();
    localSearchContactsFragment.onCreateView(paramBaseActivity.getLayoutInflater(), null, null);
    return localSearchContactsFragment;
  }
  
  private SearchResult a(int paramInt)
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      SearchResult localSearchResult = (SearchResult)localIterator.next();
      if (localSearchResult.jdField_a_of_type_Int == paramInt) {
        return localSearchResult;
      }
    }
    return null;
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 80000000: 
      return "0X8004BEE";
    case 80000001: 
      return "0X8004BEF";
    }
    return "0X8004BF0";
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        oik localoik = (oik)localIterator.next();
        if ((localoik != null) && (localoik.jdField_b_of_type_Int == 80000002)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean b(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() == 1))
    {
      Object localObject = ((SearchResult)paramArrayList.get(0)).b;
      if ((localObject != null) && (((List)localObject).size() == 1))
      {
        localObject = (AccountSearchPb.record)((List)localObject).get(0);
        if (((SearchResult)paramArrayList.get(0)).jdField_a_of_type_Int == 80000003) {
          return false;
        }
        a(((SearchResult)paramArrayList.get(0)).jdField_a_of_type_Int, (AccountSearchPb.record)localObject);
        if (((SearchBaseActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a() == 0) {
          a().finish();
        }
        return true;
      }
      if ((localObject != null) && (((List)localObject).size() == 2))
      {
        localObject = SearchBaseActivity.c.matcher(this.jdField_d_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("SearchContactsFragment", 2, "needJump lastKeywords = " + this.jdField_d_of_type_JavaLangString);
        }
        if (((Matcher)localObject).matches())
        {
          d();
          a(this.jdField_b_of_type_JavaUtilArrayList);
          a(((SearchResult)paramArrayList.get(0)).jdField_a_of_type_Int, false);
          return true;
        }
      }
    }
    return false;
  }
  
  public String a(SearchBaseFragment.ItemViewHolder paramItemViewHolder, oik paramoik)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramoik.jdField_b_of_type_Int;
    paramItemViewHolder.jdField_a_of_type_JavaLangString = (paramoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get() + "");
    boolean bool;
    SpannableStringBuilder localSpannableStringBuilder;
    if (paramoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get() != 0L)
    {
      bool = true;
      paramItemViewHolder.jdField_a_of_type_Boolean = bool;
      paramItemViewHolder.jdField_b_of_type_JavaLangString = paramoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.mobile.get();
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      localSpannableStringBuilder = new SpannableStringBuilder();
      switch (i)
      {
      default: 
        label132:
        paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
        localStringBuilder.append(paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
        localStringBuilder.append(paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getText().toString());
        switch (i)
        {
        default: 
          i = 1;
        }
        break;
      }
    }
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(i, paramItemViewHolder.jdField_a_of_type_JavaLangString);
      paramoik = (oik)localObject;
      if (localObject == null)
      {
        localObject = ImageUtil.a();
        paramoik = (oik)localObject;
        if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b())
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramItemViewHolder.jdField_a_of_type_JavaLangString, i, true, (byte)1);
          paramoik = (oik)localObject;
        }
      }
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramoik);
      return localStringBuilder.toString();
      bool = false;
      break;
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(a(80000000, paramoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get()));
      localSpannableStringBuilder.append("(");
      if (paramItemViewHolder.jdField_a_of_type_Boolean) {}
      for (localObject = paramItemViewHolder.jdField_a_of_type_JavaLangString;; localObject = paramItemViewHolder.jdField_b_of_type_JavaLangString)
      {
        localSpannableStringBuilder.append(a(80000000, (String)localObject));
        localSpannableStringBuilder.append(")");
        break;
      }
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(a(80000002, String.valueOf(paramoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get())));
      break label132;
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(a(80000001, String.valueOf(paramoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get())));
      localSpannableStringBuilder.append("(");
      localSpannableStringBuilder.append(a(80000001, String.valueOf(paramoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get())));
      localSpannableStringBuilder.append(")");
      break label132;
      localStringBuilder.append(a(paramItemViewHolder, paramoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record));
      i = 1;
      continue;
      i = 4;
      paramItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      paramItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.number.get() + "人");
      paramItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131428302));
      paramItemViewHolder.d.setText(paramoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.brief.get());
      paramItemViewHolder.jdField_a_of_type_JavaLangString = String.valueOf(paramoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get());
      localStringBuilder.append(paramItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.getText()).append(paramItemViewHolder.d.getText());
      continue;
      localStringBuilder.append(b(paramItemViewHolder, paramoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record));
      i = 1;
    }
  }
  
  ArrayList a(ArrayList paramArrayList)
  {
    int[] arrayOfInt = ViewFactory.a(b());
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        SearchResult localSearchResult = (SearchResult)localIterator.next();
        if (localSearchResult.jdField_a_of_type_Int == k) {
          localArrayList.add(localSearchResult);
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      f();
    }
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Oil == null)
        {
          this.jdField_a_of_type_Oil = new oil(this, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 4, true);
          this.jdField_a_of_type_Oil.a(this.jdField_a_of_type_JavaUtilArrayList);
          this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Oil);
          this.a = this.jdField_a_of_type_Oil;
        }
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0) != this.jdField_a_of_type_ComTencentWidgetXListView)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentWidgetXListView);
        }
        this.jdField_a_of_type_Oil.a(this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_Oil.notifyDataSetChanged();
        if (this.c)
        {
          this.c = false;
          this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
        }
      } while (!a());
      localObject1 = getActivity();
      if ((localObject1 != null) && ((localObject1 instanceof SearchContactsActivity)))
      {
        localObject1 = SearchBaseActivity.JumpSrcConstants.a(((SearchContactsActivity)localObject1).a());
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D1F", "0X8005D1F", 0, 1, 0, "", (String)localObject1, this.jdField_d_of_type_JavaLangString, "");
      }
    } while (this.jdField_a_of_type_JavaUtilArrayList == null);
    Object localObject1 = new StringBuilder();
    int i = 0;
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      oik localoik = (oik)((Iterator)localObject2).next();
      if ((localoik != null) && (localoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record != null) && (localoik.jdField_b_of_type_Int == 80000002))
      {
        ((StringBuilder)localObject1).append(String.valueOf(localoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get())).append("#");
        i += 1;
      }
    }
    localObject2 = PADetailReportUtil.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_d_of_type_JavaLangString);
    PADetailReportUtil.a().a((String)localObject2, this.jdField_d_of_type_JavaLangString, 2, false, i, ((StringBuilder)localObject1).toString());
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("last_key_words", this.jdField_d_of_type_JavaLangString);
    switch (paramInt)
    {
    default: 
      paramInt = 1;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BF1", "0X8004BF1", paramInt, 0, "", "", "", "");
      return;
      ((Intent)localObject1).putExtra("from_key", 0);
      ((Intent)localObject1).setClass(a(), ClassificationSearchActivity.class);
      ClassificationSearchActivity.a(a(), (Intent)localObject1, a(paramInt));
      paramInt = 1;
      continue;
      long l1 = Double.valueOf(this.jdField_a_of_type_Double * 1000000.0D).longValue();
      long l2 = Double.valueOf(this.jdField_b_of_type_Double * 1000000.0D).longValue();
      Object localObject2 = "http://qqweb.qq.com/m/relativegroup/index.html?source=qun_rec&keyword=" + URLEncoder.encode(this.jdField_d_of_type_JavaLangString) + "&gpstype=1&sid=AWSAPtjyiVRg92WelXNMAqd0&_bid=165&lon=" + Long.valueOf(l2) + "&lat=" + Long.valueOf(l1);
      localObject1 = localObject2;
      if (paramBoolean) {
        localObject1 = (String)localObject2 + "&show_tab=hot";
      }
      if (QLog.isColorLevel()) {
        QLog.d("SearchContactsFragment", 2, "lastKeywords = " + this.jdField_d_of_type_JavaLangString + " jump url is : " + (String)localObject1);
      }
      localObject2 = new Intent(a(), QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      ((Intent)localObject2).putExtra("portraitOnly", true);
      ((Intent)localObject2).putExtra("hide_more_button", true);
      ((Intent)localObject2).putExtra("hide_operation_bar", true);
      ((Intent)localObject2).putExtra("isShowAd", false);
      a().startActivity((Intent)localObject2);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "result", "Clk_more", 0, 0, "", "", "", "");
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.jdField_d_of_type_JavaLangString.matches("^\\d{5,11}$")) {}
      for (localObject1 = "2";; localObject1 = "1")
      {
        ReportController.b((QQAppInterface)localObject2, "dc00899", "Grp_find", "", "inte_add", "inte_find_grp", 0, 0, (String)localObject1, this.jdField_d_of_type_JavaLangString, "", "");
        paramInt = 2;
        break;
      }
      ((Intent)localObject1).putExtra("from_key", 2);
      localObject2 = getActivity();
      if ((localObject2 != null) && ((localObject2 instanceof SearchContactsActivity))) {
        ((Intent)localObject1).putExtra("jump_src_key", ((SearchContactsActivity)localObject2).a());
      }
      ((Intent)localObject1).setClass(a(), ClassificationSearchActivity.class);
      ClassificationSearchActivity.a(a(), (Intent)localObject1, a(paramInt));
      if ((localObject2 != null) && ((localObject2 instanceof SearchBaseActivity)))
      {
        paramInt = ((SearchBaseActivity)localObject2).a();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D21", "0X8005D21", 0, 1, 0, "0", SearchBaseActivity.JumpSrcConstants.a(paramInt), this.jdField_d_of_type_JavaLangString, "");
        paramInt = 3;
        continue;
        ((Intent)localObject1).putExtra("from_key", 5);
        ((Intent)localObject1).putExtra("fromType", r);
        ((Intent)localObject1).setClass(a(), ClassificationSearchActivity.class);
        ClassificationSearchActivity.a(a(), (Intent)localObject1, a(paramInt));
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D96", "0X8005D96", 0, 0, "0", "", this.jdField_d_of_type_JavaLangString, "");
        paramInt = 1;
      }
      else
      {
        paramInt = 3;
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      Intent localIntent = new Intent(a(), PublicAccountBrowser.class);
      localIntent.putExtra("url", paramString1);
      a().startActivity(localIntent);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F2A", "0X8006F2A", 0, 0, this.jdField_d_of_type_JavaLangString, paramString2, paramString3, "2");
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("SearchContactsFragment", 2, "doSearch");
    }
    if (NetworkUtil.e(BaseApplicationImpl.getContext()))
    {
      h();
      this.jdField_d_of_type_JavaLangString = paramString;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SearchContactsFragment", 2, "doSearch:should not be here | searchFacade = null");
        }
        i();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.c();
      if (r == 12)
      {
        localContactSearchFacade = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade;
        if (this.jdField_a_of_type_Boolean) {}
        for (i = this.jdField_a_of_type_Int;; i = 80000005)
        {
          localContactSearchFacade.a(paramString, i, this.jdField_b_of_type_Double, this.jdField_a_of_type_Double, 1);
          this.c = true;
          if (!this.jdField_a_of_type_Boolean) {
            break;
          }
          paramString = a(this.jdField_a_of_type_Int);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramString, paramString, this.jdField_d_of_type_Int + 1, 0, "", "", "", "");
          return;
        }
      }
      ContactSearchFacade localContactSearchFacade = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade;
      if (this.jdField_a_of_type_Boolean) {}
      for (int i = this.jdField_a_of_type_Int;; i = 80000004)
      {
        localContactSearchFacade.a(paramString, i, this.jdField_b_of_type_Double, this.jdField_a_of_type_Double, 0);
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BED", "0X8004BED", this.jdField_d_of_type_Int + 1, 0, "", "", "", "");
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2131369008, 0).b(a());
  }
  
  protected boolean a(ArrayList paramArrayList)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
      if (!b(this.jdField_b_of_type_JavaUtilArrayList))
      {
        this.jdField_a_of_type_JavaUtilArrayList = b(a(paramArrayList));
        d();
        a(this.jdField_b_of_type_JavaUtilArrayList);
        return true;
      }
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    d();
    a(this.jdField_b_of_type_JavaUtilArrayList);
    if (!b(this.jdField_b_of_type_JavaUtilArrayList)) {
      a(((SearchResult)paramArrayList.get(0)).jdField_a_of_type_Int, false);
    }
    return false;
  }
  
  ArrayList b(ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList(12);
    int i1 = paramArrayList.size();
    int i = 0;
    SearchResult localSearchResult;
    for (;;)
    {
      if (i < i1)
      {
        localSearchResult = (SearchResult)paramArrayList.get(i);
        if ((localSearchResult == null) || (localSearchResult.b.size() <= 0))
        {
          i += 1;
        }
        else
        {
          localObject = new oik();
          ((oik)localObject).jdField_a_of_type_Int = 0;
          ((oik)localObject).jdField_b_of_type_Int = localSearchResult.jdField_a_of_type_Int;
          if (ViewFactory.a(localSearchResult.jdField_a_of_type_Int) == 2131369706)
          {
            ((oik)localObject).jdField_a_of_type_JavaLangString = PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
            label114:
            localArrayList.add(localObject);
            if (TextUtils.isEmpty(localSearchResult.jdField_a_of_type_JavaLangString)) {
              break label650;
            }
          }
        }
      }
    }
    label286:
    label650:
    for (Object localObject = localSearchResult.jdField_a_of_type_JavaLangString;; localObject = null)
    {
      oik localoik;
      int j;
      if ((localSearchResult.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord != null) && (localSearchResult.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.has()))
      {
        localoik = new oik();
        localoik.jdField_a_of_type_Int = 2;
        localoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord = localSearchResult.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord;
        localoik.jdField_b_of_type_Int = localSearchResult.jdField_a_of_type_Int;
        localoik.jdField_c_of_type_Int = localSearchResult.jdField_c_of_type_Int;
        localoik.jdField_b_of_type_JavaLangString = ((String)localObject);
        localArrayList.add(localoik);
        j = 2;
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F75", "0X8006F75", 0, 0, this.jdField_d_of_type_JavaLangString, localoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.get(), String.valueOf(localoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_type.get()), "");
      }
      for (;;)
      {
        int i2 = localSearchResult.b.size();
        int k = 0;
        if (k < j)
        {
          localoik = new oik();
          localoik.jdField_a_of_type_Int = 2;
          localoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((AccountSearchPb.record)localSearchResult.b.get(k));
          localoik.jdField_b_of_type_Int = localSearchResult.jdField_a_of_type_Int;
          localoik.jdField_c_of_type_Int = localSearchResult.jdField_c_of_type_Int;
          localoik.jdField_b_of_type_JavaLangString = ((String)localObject);
          localArrayList.add(localoik);
          if (k < i2 - 1) {}
        }
        else
        {
          if (i2 > 3)
          {
            localObject = new oik();
            ((oik)localObject).jdField_a_of_type_Int = 1;
            ((oik)localObject).jdField_b_of_type_Int = localSearchResult.jdField_a_of_type_Int;
            ((oik)localObject).jdField_c_of_type_Int = localSearchResult.jdField_c_of_type_Int;
            localArrayList.add(localObject);
          }
          if (QLog.isColorLevel()) {
            QLog.d("SearchContactsFragment", 2, "search reuslt : type = " + localSearchResult.jdField_a_of_type_Int + "count = " + localSearchResult.b.size());
          }
          localObject = "";
          switch (localSearchResult.jdField_a_of_type_Int)
          {
          }
        }
        for (;;)
        {
          ReportController.b(null, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, String.valueOf(Math.min(i2, 3)), "", "", "");
          break;
          ((oik)localObject).jdField_a_of_type_JavaLangString = a().getString(ViewFactory.a(localSearchResult.jdField_a_of_type_Int));
          break label114;
          if (localSearchResult.jdField_a_of_type_Int == 80000001) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "result", "exp", 0, 0, "", "", "", "");
          }
          k += 1;
          break label286;
          localObject = "0X80061B8";
          continue;
          localObject = "0X80061BB";
          continue;
          localObject = "0X80061BE";
          continue;
          localObject = "0X80061C1";
        }
        return localArrayList;
        j = 3;
      }
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView = ((ViewFactory.GuideView)ViewFactory.a().a(80000004, a(), true));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView != null) {}
    }
    while (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0) == this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView.setListener(new oii(this));
      a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView);
  }
  
  void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView.a(b(), paramString);
    }
  }
  
  public void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      b();
      b(paramString);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
  }
  
  protected void f()
  {
    super.f();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void k()
  {
    super.k();
    d();
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    Object localObject3;
    if (localObject1 != null)
    {
      if (!(localObject1 instanceof SearchBaseFragment.ItemViewHolder)) {
        break label492;
      }
      localObject2 = (SearchBaseFragment.ItemViewHolder)localObject1;
      a(((SearchBaseFragment.ItemViewHolder)localObject2).jdField_b_of_type_Int, ((SearchBaseFragment.ItemViewHolder)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BF2", "0X8004BF2", a(((SearchBaseFragment.ItemViewHolder)localObject2).jdField_b_of_type_Int), 0, "", "", "", "");
      localObject3 = (Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(((SearchBaseFragment.ItemViewHolder)localObject2).jdField_b_of_type_Int));
      localObject1 = null;
      paramView = (View)localObject1;
      if (localObject2 != null)
      {
        paramView = (View)localObject1;
        if (((SearchBaseFragment.ItemViewHolder)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record != null)
        {
          paramView = (View)localObject1;
          if (((SearchBaseFragment.ItemViewHolder)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin != null) {
            paramView = String.valueOf(((SearchBaseFragment.ItemViewHolder)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get());
          }
        }
      }
      int j = ((SearchBaseFragment.ItemViewHolder)localObject2).jdField_b_of_type_Int;
      if (localObject3 == null) {
        break label374;
      }
      i = ((Integer)localObject3).intValue();
      SearchUtils.a(j, i, ((SearchBaseFragment.ItemViewHolder)localObject2).jdField_c_of_type_Int, true, paramView, this.jdField_d_of_type_JavaLangString, r);
      if (((SearchBaseFragment.ItemViewHolder)localObject2).jdField_b_of_type_Int == 80000002)
      {
        localObject1 = ((SearchBaseFragment.ItemViewHolder)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
        paramView = getActivity();
        if ((localObject1 != null) && (paramView != null) && ((paramView instanceof SearchBaseActivity)))
        {
          i = ((SearchBaseActivity)paramView).a();
          localObject3 = PADetailReportUtil.a();
          if (((AccountSearchPb.record)localObject1).uin == null) {
            break label380;
          }
          paramView = ((AccountSearchPb.record)localObject1).uin.get() + "";
          label253:
          ((PADetailReportUtil)localObject3).a(2, paramView, ((SearchBaseFragment.ItemViewHolder)localObject2).jdField_c_of_type_Int, r);
          if (r != 12) {
            break label392;
          }
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject2 = ((SearchBaseFragment.ItemViewHolder)localObject2).jdField_c_of_type_Int + "";
          String str = SearchBaseActivity.JumpSrcConstants.a(i);
          if (((AccountSearchPb.record)localObject1).uin == null) {
            break label386;
          }
          paramView = ((AccountSearchPb.record)localObject1).uin.get() + "";
          label344:
          ReportController.b((QQAppInterface)localObject3, "CliOper", "", "", "0X8006571", "0X8006571", 0, 1, 0, (String)localObject2, str, paramView, this.jdField_d_of_type_JavaLangString);
        }
      }
    }
    label374:
    label380:
    label386:
    label392:
    label492:
    do
    {
      do
      {
        return;
        i = 0;
        break;
        paramView = "";
        break label253;
        paramView = "";
        break label344;
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (((AccountSearchPb.record)localObject1).uin != null) {}
        for (paramView = ((AccountSearchPb.record)localObject1).uin.get() + "";; paramView = "")
        {
          ReportController.b((QQAppInterface)localObject3, "P_CliOper", "Pb_account_lifeservice", paramView, "0X8005D20", "0X8005D20", 0, 1, 0, ((SearchBaseFragment.ItemViewHolder)localObject2).jdField_c_of_type_Int + "", SearchBaseActivity.JumpSrcConstants.a(i), this.jdField_d_of_type_JavaLangString, "");
          return;
        }
        if ((localObject1 instanceof NearbyTroops.CustomViewHolder))
        {
          paramView = (NearbyTroops.CustomViewHolder)localObject1;
          localObject1 = TroopInfoActivity.a(paramView.jdField_b_of_type_JavaLangString, 2);
          ((Bundle)localObject1).putInt("exposureSource", 3);
          ((Bundle)localObject1).putInt("t_s_f", 1000);
          ChatSettingForTroop.a(a(), (Bundle)localObject1, 2);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BF2", "0X8004BF2", a(80000001), 0, "", "", "", "");
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "result", "Clk_grpdate", 0, 0, paramView.jdField_b_of_type_JavaLangString, "", "", "");
          localObject1 = (Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(80000001));
          if (localObject1 != null) {}
          for (i = ((Integer)localObject1).intValue();; i = 0)
          {
            SearchUtils.a(80000001, i, paramView.jdField_a_of_type_Int, true, paramView.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, r);
            return;
          }
        }
      } while (!(localObject1 instanceof SearchBaseFragment.ArticleItemViewHolder));
      paramView = getActivity();
    } while (paramView == null);
    localObject1 = (SearchBaseFragment.ArticleItemViewHolder)localObject1;
    Object localObject2 = new Intent(paramView, PublicAccountBrowser.class);
    ((Intent)localObject2).putExtra("url", ((SearchBaseFragment.ArticleItemViewHolder)localObject1).jdField_a_of_type_JavaLangString);
    if (r == 13)
    {
      ((Intent)localObject2).putExtra("articalChannelId", 12);
      paramView.startActivity((Intent)localObject2);
      if (r != 12) {
        break label952;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800658A", "0X800658A", 0, 0, "" + ((SearchBaseFragment.ArticleItemViewHolder)localObject1).jdField_a_of_type_Int, "", this.jdField_d_of_type_JavaLangString, "" + ((SearchBaseFragment.ArticleItemViewHolder)localObject1).jdField_a_of_type_Long);
      label817:
      paramView = (Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(80000003));
      if (paramView == null) {
        break label1029;
      }
    }
    label952:
    label1029:
    for (int i = paramView.intValue();; i = 0)
    {
      SearchUtils.a(80000003, i, ((SearchBaseFragment.ArticleItemViewHolder)localObject1).jdField_a_of_type_Int, true, null, this.jdField_d_of_type_JavaLangString, r);
      return;
      if (r == 1)
      {
        ((Intent)localObject2).putExtra("articalChannelId", 10);
        if ((localObject1 == null) || (((SearchBaseFragment.ArticleItemViewHolder)localObject1).jdField_b_of_type_JavaLangString == null)) {
          break;
        }
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F2A", "0X8006F2A", 0, 0, this.jdField_d_of_type_JavaLangString, ((SearchBaseFragment.ArticleItemViewHolder)localObject1).jdField_b_of_type_JavaLangString, ((SearchBaseFragment.ArticleItemViewHolder)localObject1).c, "1");
        break;
      }
      if (r != 2) {
        break;
      }
      ((Intent)localObject2).putExtra("articalChannelId", 11);
      break;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D95", "0X8005D95", 0, 0, "" + ((SearchBaseFragment.ArticleItemViewHolder)localObject1).jdField_a_of_type_Int, "", this.jdField_d_of_type_JavaLangString, "" + ((SearchBaseFragment.ArticleItemViewHolder)localObject1).jdField_a_of_type_Long);
      break label817;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Oil != null) {
      this.jdField_a_of_type_Oil.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener != null) {
      SosoInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\contact\addcontact\SearchContactsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */