package com.tencent.biz.pubaccount.serviceAccountFolder;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class ServiceAccountFolderManager$FeedComparator
  implements Comparator
{
  public ServiceAccountFolderManager$FeedComparator(ServiceAccountFolderManager paramServiceAccountFolderManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(ServiceAccountFolderFeed paramServiceAccountFolderFeed1, ServiceAccountFolderFeed paramServiceAccountFolderFeed2)
  {
    long l1 = paramServiceAccountFolderFeed1.a;
    long l2 = paramServiceAccountFolderFeed2.a;
    if (l2 > l1) {
      return 1;
    }
    if (l2 < l1) {
      return -1;
    }
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\serviceAccountFolder\ServiceAccountFolderManager$FeedComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */