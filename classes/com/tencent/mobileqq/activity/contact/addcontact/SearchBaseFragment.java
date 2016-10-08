package com.tencent.mobileqq.activity.contact.addcontact;

import SummaryCard.SearchInfo;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import oib;
import oic;
import oid;
import oie;

public class SearchBaseFragment
  extends Fragment
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  public static final String a = "from_key";
  public static final String b = "last_key_words";
  public static final String c = "start_search_key";
  private static final String e;
  public static final int g = -16734752;
  public static final int h = 0;
  public static final int i = 1;
  public static final int j = 2;
  public static final int k = 3;
  public Handler a;
  protected BaseAdapter a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected ContactSearchFacade.ISearchListener a;
  protected ContactSearchFacade a;
  CustomerLoadingDialog jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog;
  protected BaseActivity a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new oie(this);
  public QQAppInterface a;
  protected IIconListener a;
  protected StatusManager a;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private AccountSearchPb.record jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
  public XListView a;
  public Map a;
  private Handler b;
  public boolean b;
  public final int c = 64;
  protected boolean c;
  protected int d;
  public String d;
  public int e;
  protected int f;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_e_of_type_JavaLangString = SearchBaseFragment.class.getName();
  }
  
  public SearchBaseFragment()
  {
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade$ISearchListener = new oib(this);
    this.jdField_a_of_type_AndroidOsHandler = new oic(this);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new oid(this);
  }
  
  private static int a(String paramString1, String paramString2)
  {
    int m = paramString2.indexOf(paramString1);
    if (m >= 0) {
      return m;
    }
    return paramString2.toLowerCase().indexOf(paramString1.toLowerCase());
  }
  
  public static SpannableString a(String paramString, List paramList)
  {
    if (paramString == null) {
      return null;
    }
    if (paramList == null) {
      return new SpannableString(paramString);
    }
    int m = paramString.length();
    Object localObject = paramList.iterator();
    int n;
    if (((Iterator)localObject).hasNext())
    {
      n = a((String)((Iterator)localObject).next(), paramString);
      if ((n < 0) || (n >= m)) {
        break label231;
      }
      m = n;
    }
    label231:
    for (;;)
    {
      break;
      localObject = paramString;
      if (m > 8)
      {
        localObject = paramString;
        if (m != paramString.length()) {
          localObject = "…" + paramString.substring(m - 8);
        }
      }
      SpannableString localSpannableString = new SpannableString((CharSequence)localObject);
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        String str = (String)paramList.next();
        m = 0;
        for (paramString = (String)localObject;; paramString = paramString.substring(n))
        {
          int i1 = a(str, paramString);
          if (i1 < 0) {
            break;
          }
          n = str.length() + i1;
          localSpannableString.setSpan(new ForegroundColorSpan(-16734752), i1 + m, m + n, 33);
          m += n;
        }
      }
      return localSpannableString;
    }
  }
  
  private static String a(Iterable paramIterable, String paramString)
  {
    paramIterable = paramIterable.iterator();
    int n = 0;
    int i2 = -1;
    int i1 = -1;
    int m;
    int i3;
    if (paramIterable.hasNext())
    {
      String str = (String)paramIterable.next();
      m = a(str, paramString);
      i3 = i2;
      i2 = i1;
      if (i1 == -1)
      {
        i3 = m;
        i2 = m;
      }
      if ((m >= i2) || (m == -1)) {
        break label155;
      }
      i2 = str.length();
      i1 = m;
      n = m;
      m = i2;
    }
    for (;;)
    {
      i2 = n;
      n = m;
      break;
      if (i1 <= 10)
      {
        paramIterable = paramString;
        if (i1 > 6)
        {
          paramIterable = paramString;
          if (i1 + n <= 10) {}
        }
      }
      else
      {
        paramIterable = "…" + paramString.substring(i2 - 6);
      }
      return paramIterable;
      label155:
      m = n;
      n = i3;
      i1 = i2;
    }
  }
  
  protected int a()
  {
    return BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131492908);
  }
  
  public int a(TextView paramTextView, BaseActivity paramBaseActivity)
  {
    paramTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    int m = paramTextView.getMeasuredHeight();
    float f1 = paramTextView.getMeasuredWidth();
    int n = AIOUtils.a(18.0F, paramBaseActivity.getResources());
    float f2 = AIOUtils.a(260.0F, paramBaseActivity.getResources());
    float f3 = FontSettingManager.a() / 16.0F;
    return m / n + (int)(f1 * f3 / f2);
  }
  
  public SpannableString a(int paramInt, String paramString)
  {
    SpannableString localSpannableString2 = (SpannableString)this.jdField_a_of_type_JavaUtilMap.get(paramInt + ":" + paramString);
    SpannableString localSpannableString1 = localSpannableString2;
    if (localSpannableString2 == null) {
      localSpannableString1 = new SpannableString(paramString);
    }
    return localSpannableString1;
  }
  
  public SpannableString a(int paramInt, String paramString, SpannableString paramSpannableString)
  {
    return (SpannableString)this.jdField_a_of_type_JavaUtilMap.put(paramInt + ":" + paramString, paramSpannableString);
  }
  
  public BaseActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  }
  
  protected String a(SearchBaseFragment.ItemViewHolder paramItemViewHolder, AccountSearchPb.record paramrecord)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject;
    int n;
    int m;
    switch (paramrecord.sex.get())
    {
    default: 
      localObject = "";
      n = 0;
      m = 0;
      localStringBuilder.append((String)localObject);
      if ((n == 0) && (paramrecord.age.get() == 0))
      {
        paramItemViewHolder.c.setText("");
        paramItemViewHolder.c.setCompoundDrawables(null, null, null, null);
        paramItemViewHolder.c.setVisibility(4);
      }
      break;
    }
    for (;;)
    {
      localObject = new StringBuilder();
      if (!TextUtils.isEmpty(paramrecord.province_name.get())) {
        ((StringBuilder)localObject).append(paramrecord.province_name.get()).append(" ");
      }
      if (!TextUtils.isEmpty(paramrecord.city_name.get())) {
        ((StringBuilder)localObject).append(paramrecord.city_name.get());
      }
      if ((((StringBuilder)localObject).length() == 0) && (!TextUtils.isEmpty(paramrecord.country_name.get()))) {
        ((StringBuilder)localObject).append(paramrecord.country_name.get());
      }
      paramItemViewHolder.d.setText(((StringBuilder)localObject).toString());
      localStringBuilder.append(((StringBuilder)localObject).toString());
      a(paramItemViewHolder, paramrecord.richStatus);
      return localStringBuilder.toString();
      n = 2130838639;
      m = 2130840973;
      localObject = "男";
      break;
      n = 2130838634;
      m = 2130840962;
      localObject = "女";
      break;
      paramItemViewHolder.c.setVisibility(0);
      paramItemViewHolder.c.setCompoundDrawablesWithIntrinsicBounds(n, 0, 0, 0);
      paramItemViewHolder.c.setBackgroundResource(m);
      paramItemViewHolder.c.setText(String.valueOf(paramrecord.age.get()));
      paramItemViewHolder.c.setTextColor(BaseApplicationImpl.getContext().getResources().getColor(2131427407));
      localStringBuilder.append(paramItemViewHolder.c.getText());
    }
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_e_of_type_JavaLangString, 2, "onDecodeTaskCompleted type = " + paramInt2 + ", uin = " + paramString);
    }
    int m;
    if ((paramBitmap != null) && (this.jdField_e_of_type_Int == 0))
    {
      m = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
    }
    for (;;)
    {
      Object localObject;
      if (paramInt1 < m)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1).getTag();
        if ((localObject == null) || (!(localObject instanceof SearchBaseFragment.ItemViewHolder))) {
          break label167;
        }
        localObject = (SearchBaseFragment.ItemViewHolder)localObject;
        if ((!((SearchBaseFragment.ItemViewHolder)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) && (!paramString.equals(((SearchBaseFragment.ItemViewHolder)localObject).jdField_b_of_type_JavaLangString))) {
          break label167;
        }
        if (paramInt2 == 4)
        {
          if (80000001 != ((SearchBaseFragment.ItemViewHolder)localObject).jdField_b_of_type_Int) {
            break label167;
          }
          ((SearchBaseFragment.ItemViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
        }
      }
      else
      {
        return;
      }
      ((SearchBaseFragment.ItemViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      return;
      label167:
      paramInt1 += 1;
    }
  }
  
  protected void a(int paramInt, AccountSearchPb.record paramrecord)
  {
    if (a() == null) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 80000000: 
      a(paramrecord);
      return;
    case 80000001: 
      paramrecord = TroopInfoActivity.a(String.valueOf(paramrecord.code.get()), 2);
      paramrecord.putInt("exposureSource", 3);
      paramrecord.putInt("t_s_f", 1000);
      ChatSettingForTroop.a(a(), paramrecord, 2);
      return;
    }
    paramInt = paramrecord.account_flag.get();
    PublicView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramrecord.class_index.get(), String.valueOf(paramrecord.uin.get()), String.valueOf(paramrecord.uin.get()), paramInt, paramrecord.name.get(), 4);
  }
  
  public void a(int paramInt1, Object paramObject, int paramInt2, String paramString)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, paramString));
    }
  }
  
  @Deprecated
  public void a(Handler paramHandler)
  {
    this.b = paramHandler;
  }
  
  protected void a(View paramView)
  {
    if (paramView != null)
    {
      if (paramView.getParent() != null) {
        ((ViewGroup)paramView.getParent()).removeView(paramView);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView);
    }
  }
  
  public void a(SearchBaseFragment.ItemViewHolder paramItemViewHolder, RichStatus paramRichStatus)
  {
    paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
    if ((paramRichStatus != null) && (!paramRichStatus.isEmpty()))
    {
      if (!TextUtils.isEmpty(paramRichStatus.actionText))
      {
        paramItemViewHolder.jdField_a_of_type_Int = paramRichStatus.actionId;
        return;
      }
      paramItemViewHolder.jdField_a_of_type_Int = 0;
      return;
    }
    paramItemViewHolder.jdField_a_of_type_Int = 0;
  }
  
  protected void a(AccountSearchPb.record paramrecord)
  {
    this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = paramrecord;
    SearchInfo localSearchInfo = new SearchInfo();
    localSearchInfo.lUIN = paramrecord.uin.get();
    localSearchInfo.strNick = paramrecord.name.get();
    localSearchInfo.strMobile = paramrecord.mobile.get();
    localSearchInfo.bIsFriend = ((byte)(int)(paramrecord.relation.get() & 1L));
    localSearchInfo.bInContact = ((byte)(int)(paramrecord.relation.get() & 0x2));
    AddFriendActivity.a(a(), localSearchInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, true, 2);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
    if (this.jdField_e_of_type_Int != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
    }
    for (;;)
    {
      if (a() != null)
      {
        paramAbsListView = (InputMethodManager)a().getSystemService("input_method");
        if (paramAbsListView.isActive()) {
          paramAbsListView.hideSoftInputFromWindow(a().getWindow().getDecorView().getWindowToken(), 0);
        }
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b())
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
        if (this.jdField_a_of_type_AndroidWidgetBaseAdapter != null) {
          this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
        }
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "搜索失败，请稍后再试";
    }
    QQToast.a(BaseApplicationImpl.getContext(), str, 0).b(a());
  }
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public void a(ArrayList paramArrayList)
  {
    for (;;)
    {
      SearchResult localSearchResult;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      try
      {
        Iterator localIterator1 = paramArrayList.iterator();
        if (localIterator1.hasNext())
        {
          localSearchResult = (SearchResult)localIterator1.next();
          localObject1 = localSearchResult.jdField_a_of_type_JavaUtilList;
          Iterator localIterator2 = localSearchResult.b.iterator();
          if (!localIterator2.hasNext()) {
            break label306;
          }
          localObject2 = (AccountSearchPb.record)localIterator2.next();
          localObject3 = ((AccountSearchPb.record)localObject2).name.get();
          if (localSearchResult.jdField_a_of_type_Int == 80000003)
          {
            paramArrayList = SpannableString.valueOf(SearchUtils.a((String)localObject3, (ArrayList)localObject1, 255));
            a(localSearchResult.jdField_a_of_type_Int, (String)localObject3, paramArrayList);
            paramArrayList = null;
          }
        }
        else
        {
          switch (localSearchResult.jdField_a_of_type_Int)
          {
          case 80000001: 
            if (!TextUtils.isEmpty(paramArrayList))
            {
              localObject3 = a(paramArrayList, (List)localObject1);
              a(localSearchResult.jdField_a_of_type_Int, paramArrayList, (SpannableString)localObject3);
            }
            if ((localSearchResult.jdField_a_of_type_Int != 80000000) || (TextUtils.isEmpty(((AccountSearchPb.record)localObject2).mobile.get()))) {
              continue;
            }
            paramArrayList = ((AccountSearchPb.record)localObject2).mobile.get();
            localObject2 = a(paramArrayList, (List)localObject1);
            a(localSearchResult.jdField_a_of_type_Int, paramArrayList, (SpannableString)localObject2);
            continue;
            return;
          }
        }
      }
      catch (Exception paramArrayList)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_e_of_type_JavaLangString, 2, "", paramArrayList);
        }
      }
      paramArrayList = a((String)localObject3, (List)localObject1);
      continue;
      paramArrayList = String.valueOf(((AccountSearchPb.record)localObject2).code.get());
      continue;
      paramArrayList = String.valueOf(((AccountSearchPb.record)localObject2).uin.get());
      continue;
      paramArrayList = String.valueOf(((AccountSearchPb.record)localObject2).brief.get());
      continue;
      label306:
      paramArrayList = localSearchResult.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord;
      if ((paramArrayList != null) && (paramArrayList.hotword.has()))
      {
        paramArrayList = paramArrayList.hotword.get();
        localObject1 = SpannableString.valueOf(SearchUtils.a(paramArrayList, (ArrayList)localObject1, 255));
        a(localSearchResult.jdField_a_of_type_Int, paramArrayList, (SpannableString)localObject1);
      }
    }
  }
  
  public boolean a(ArrayList paramArrayList)
  {
    return true;
  }
  
  protected int b()
  {
    if ((this.jdField_d_of_type_Int == 0) || (this.jdField_d_of_type_Int == 3) || (this.jdField_d_of_type_Int == 4)) {
      return 80000000;
    }
    if (this.jdField_d_of_type_Int == 2) {
      return 80000002;
    }
    if (this.jdField_d_of_type_Int == 5) {
      return 80000003;
    }
    return 80000001;
  }
  
  protected String b(SearchBaseFragment.ItemViewHolder paramItemViewHolder, AccountSearchPb.record paramrecord)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramItemViewHolder.c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    paramItemViewHolder.c.setCompoundDrawablePadding(0);
    paramItemViewHolder.c.setBackgroundResource(0);
    if ((paramrecord.video_account.has()) && (paramrecord.video_account.get() == 1))
    {
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130838919, 0);
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding((int)DisplayUtils.a(BaseApplicationImpl.getContext(), 6.0F));
      if ((!paramrecord.class_index.has()) || (paramrecord.class_index.get() != 1)) {
        break label283;
      }
      if (paramrecord.class_name.has())
      {
        paramItemViewHolder.c.setText(paramrecord.class_name.get());
        localStringBuilder.append(paramrecord.class_name.get());
      }
      if (paramrecord.brief.has())
      {
        paramItemViewHolder.d.setText(a(80000002, paramrecord.brief.get()));
        localStringBuilder.append(paramrecord.brief.get());
      }
    }
    for (;;)
    {
      int m = BaseApplicationImpl.getContext().getResources().getColor(2131428302);
      paramItemViewHolder.c.setTextColor(m);
      return localStringBuilder.toString();
      if ((paramrecord.flag.has()) && (paramrecord.flag.get() == 1L))
      {
        paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130838906, 0);
        paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding((int)DisplayUtils.a(BaseApplicationImpl.getContext(), 6.0F));
        break;
      }
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break;
      label283:
      if (paramrecord.class_index.has())
      {
        paramItemViewHolder.c.setVisibility(8);
        if (paramrecord.brief.has())
        {
          paramItemViewHolder.d.setText(a(80000002, paramrecord.brief.get()));
          localStringBuilder.append(paramItemViewHolder.d.getText());
        }
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_e_of_type_JavaLangString, 2, "clearHighLightString");
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade = new ContactSearchFacade(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade$ISearchListener);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.f = ((int)DisplayUtils.a(BaseApplicationImpl.getContext(), 12.0F));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14));
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    }
  }
  
  public void f()
  {
    if (a() != null) {
      a(ViewFactory.a().a(80000005, a(), true));
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    }
  }
  
  public View getView()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  protected void h()
  {
    if (a() != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog = new CustomerLoadingDialog(a());
      }
      if (!a().isFinishing()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog.show();
      }
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog.dismiss();
    }
  }
  
  @Deprecated
  public void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)a().getAppRuntime());
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.jdField_d_of_type_Int = localBundle.getInt("from_key", 0);
      this.jdField_d_of_type_JavaLangString = localBundle.getString("last_key_words");
    }
    e();
    if ((localBundle != null) && (!TextUtils.isEmpty(localBundle.getString("start_search_key")))) {
      a(localBundle.getString("start_search_key"), false);
    }
  }
  
  @Deprecated
  public void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
    ViewFactory.a().a();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.d();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade = null;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = ((FragmentActivity)paramActivity);
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    j();
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(a());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
    this.jdField_a_of_type_ComTencentWidgetXListView = new XListView(a());
    this.jdField_a_of_type_ComTencentWidgetXListView.setCacheColorHint(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(2130843567);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    k();
    a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\contact\addcontact\SearchBaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */