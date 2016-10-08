package com.tencent.mobileqq.search.model;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.activity.GroupSearchActivity;
import com.tencent.mobileqq.search.activity.PublicAcntSearchActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.ChnSpelling;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class PublicAccountSearchResultModel
  extends IContactSearchModel
{
  private static final String jdField_a_of_type_JavaLangString = "PublicAccountSearchResultModel";
  static final long jdField_b_of_type_Long = 4398046511104L;
  static final long jdField_c_of_type_Long = 2199023255552L;
  static final long d = 2147483648L;
  static final long e = 1073741824L;
  static final long f = 536870912L;
  static final long g = 134217728L;
  static final long h = 67108864L;
  static final long i = 12582912L;
  static final long j = 1048576L;
  static final long k = 524288L;
  static final long l = 131072L;
  static final long m = 13510798882111488L;
  static final long n = 13194139533312L;
  final PublicAccountInfo jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private long o;
  private long p;
  
  public PublicAccountSearchResultModel(QQAppInterface paramQQAppInterface, PublicAccountInfo paramPublicAccountInfo, int paramInt)
  {
    super(paramQQAppInterface, paramInt, 0L);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = -1;
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = paramPublicAccountInfo;
    if (paramQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin()))
    {
      this.p = IContactSearchable.K;
      return;
    }
    this.p = IContactSearchable.L;
  }
  
  public int a()
  {
    return 1;
  }
  
  protected long a(String paramString)
  {
    int i3 = 1;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.o = Long.MIN_VALUE;
    long l2 = SearchUtils.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name, 1073741824L);
    long l1 = l2;
    if (l2 != Long.MIN_VALUE) {
      l1 = (l2 & 0xC0000000000) >> 20 | 0xFFCFF3FFFFFFFFFF & l2 | (0x30000000000000 & l2) >> 26;
    }
    if (l1 > this.o) {
      this.o = l1;
    }
    for (int i1 = 1;; i1 = 0)
    {
      l2 = SearchUtils.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.summary, 131072L, false);
      l1 = l2;
      if (l2 != Long.MIN_VALUE) {
        l1 = (l2 & 0xC0000000000) >> 20 | 0xFFCFF3FFFFFFFFFF & l2 | (0x30000000000000 & l2) >> 26;
      }
      if (l1 > this.o)
      {
        this.o = l1;
        i1 = 0;
      }
      for (;;)
      {
        l2 = l1;
        if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.Marks != null)
        {
          l2 = l1;
          if (!this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.Marks.isEmpty())
          {
            Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.Marks.entrySet().iterator();
            l2 = l1;
            if (localIterator.hasNext())
            {
              Map.Entry localEntry = (Map.Entry)localIterator.next();
              l2 = l1;
              if (((String)localEntry.getKey()).equals(paramString)) {
                l2 = 683671552L - ((Integer)localEntry.getValue()).intValue();
              }
              ChnToSpell.ChnSpelling localChnSpelling = ChnToSpell.a((String)localEntry.getKey(), 1);
              if (!((String)localEntry.getKey()).equals(localChnSpelling.a)) {}
              for (int i2 = 1;; i2 = 0)
              {
                l1 = l2;
                if (i2 == 0) {
                  break;
                }
                l1 = l2;
                if (!localChnSpelling.a.equals(paramString)) {
                  break;
                }
                l1 = 616562688L - ((Integer)localEntry.getValue()).intValue();
                break;
              }
            }
          }
        }
        if (l2 > this.o)
        {
          this.o = l2;
          i1 = i3;
        }
        for (;;)
        {
          if (this.o != Long.MIN_VALUE)
          {
            if (this.p != IContactSearchable.K) {
              break label538;
            }
            this.o |= 0x100000;
            if (!this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.isOffLine)
            {
              this.o |= 0x20000000000;
              if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.clickCount >= 3) {
                if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.clickCount >= 128) {
                  break label553;
                }
              }
            }
          }
          label538:
          label553:
          for (this.o |= (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.clickCount & 0x7F) << 32;; this.o |= 0x7F00000000)
          {
            if (i1 != 0) {
              this.o |= 0x40000000000;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.certifiedGrade == 1L) {
              this.o |= 0x80000000;
            }
            return this.o;
            this.o |= 0x80000;
            break;
          }
        }
      }
    }
  }
  
  public PublicAccountInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo;
  }
  
  public Object a()
  {
    return Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.uin);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin();
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(View paramView)
  {
    Object localObject2 = paramView.getContext();
    if (localObject2 == null) {}
    label235:
    label452:
    label522:
    label525:
    for (;;)
    {
      return;
      String str = this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin();
      PAStartupTracker.a(null, "pubAcc_aio_open", str);
      Object localObject1 = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
      if (((localObject1 != null) && (((PublicAccountDataManager)localObject1).a(Long.valueOf(str)))) || ((localObject1 == null) && (PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str))))
      {
        Intent localIntent = new Intent(paramView.getContext(), ChatActivity.class);
        int i1 = 1008;
        if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.extendType == 2)
        {
          localIntent.putExtra("chat_subType", 1);
          i1 = 0;
        }
        if (TextUtils.isEmpty(str))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("PublicAccountSearchResultModel", 2, "uin is null");
          return;
        }
        localIntent.putExtra("uin", str);
        localIntent.putExtra("uintype", i1);
        localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name);
        localIntent.putExtra("selfSet_leftViewText", ((Context)localObject2).getString(2131367975));
        RecentUtil.a = true;
        RecentUtil.a(localIntent);
        ((Context)localObject2).startActivity(localIntent);
        this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.clickCount += 1;
        if (localObject1 != null) {
          ((PublicAccountDataManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
        }
        SearchUtils.a(this.jdField_b_of_type_JavaLangString, 50, 0, paramView, str, this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.isOffLine, this.c);
        SearchHistoryManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString);
        SearchUtils.a(this.jdField_b_of_type_JavaLangString, 50, paramView, false);
        if ((!(localObject2 instanceof BaseActivity)) || (this.jdField_b_of_type_Int <= 0)) {
          continue;
        }
        localObject1 = null;
        if (!(localObject2 instanceof GroupSearchActivity)) {
          break label452;
        }
        localObject1 = "0X8006570";
        paramView = "0X8005D1C";
      }
      for (;;)
      {
        if (paramView == null) {
          break label525;
        }
        localObject2 = ((BaseActivity)localObject2).app;
        if (this.c == 12)
        {
          ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 1, 0, this.jdField_b_of_type_Int + "", "", str, this.jdField_b_of_type_JavaLangString);
          return;
          if (TextUtils.isEmpty(str))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.w("PublicAccountSearchResultModel", 2, "uin is null");
            return;
          }
          localObject1 = new Intent(paramView.getContext(), AccountDetailActivity.class);
          ((Intent)localObject1).putExtra("uin", str);
          ((Intent)localObject1).putExtra("source", 4);
          ((Context)localObject2).startActivity((Intent)localObject1);
          break label235;
          if (!(localObject2 instanceof PublicAcntSearchActivity)) {
            break label522;
          }
          localObject1 = "0X8006588";
          paramView = "0X8005D1E";
          continue;
        }
        ReportController.b((QQAppInterface)localObject2, "P_CliOper", "Pb_account_lifeservice", str, paramView, paramView, 0, 1, 0, this.jdField_b_of_type_Int + "", "", this.jdField_b_of_type_JavaLangString, "");
        return;
        paramView = null;
      }
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return 0;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public CharSequence c()
  {
    return SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.summary, this.jdField_b_of_type_JavaLangString);
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\model\PublicAccountSearchResultModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */