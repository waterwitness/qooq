package com.tencent.biz.pubaccount.AccountDetail.bean;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AccountDetailDynamicInfo
{
  public long a;
  private ArrayList a;
  public boolean a;
  public long b;
  private ArrayList b;
  public long c;
  
  public AccountDetailDynamicInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new ArrayList();
    this.b = new ArrayList();
  }
  
  public ArrayList a()
  {
    return this.a;
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null) {
      this.a.addAll(paramArrayList);
    }
    if (QLog.isColorLevel()) {
      QLog.d("addOldDynamicInfoItemList", 2, "mDynamicInfoList.size():" + this.a.size());
    }
  }
  
  public ArrayList b()
  {
    return this.b;
  }
  
  public void b(ArrayList paramArrayList)
  {
    this.b.clear();
    if (paramArrayList == null) {}
    for (int i = 0;; i = paramArrayList.size())
    {
      int j = 0;
      while (j < i)
      {
        String str = (String)paramArrayList.get(j);
        if (!TextUtils.isEmpty(str))
        {
          DynamicInfo localDynamicInfo = new DynamicInfo();
          localDynamicInfo.a(str);
          this.b.add(localDynamicInfo);
        }
        j += 1;
      }
    }
    this.a.addAll(this.b);
    if (QLog.isColorLevel()) {
      QLog.d("parceJson2DynamicInfoItemList", 2, "mDynamicInfoList.size():" + this.b.size());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\AccountDetail\bean\AccountDetailDynamicInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */