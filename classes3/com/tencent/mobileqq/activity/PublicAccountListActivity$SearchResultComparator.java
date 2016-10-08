package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;
import mbu;

public class PublicAccountListActivity$SearchResultComparator
  implements Comparator
{
  public PublicAccountListActivity$SearchResultComparator(PublicAccountListActivity paramPublicAccountListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(mbu parammbu1, mbu parammbu2)
  {
    long l = parammbu1.a.certifiedGrade;
    return (int)(parammbu2.a.certifiedGrade - l);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\PublicAccountListActivity$SearchResultComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */