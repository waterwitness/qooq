package com.tencent.mobileqq.bubble;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.util.LRULinkedHashMap;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import qts;
import qtt;
import qtu;
import qtv;

public class BubbleDiyFetcher
{
  private static BubbleDiyFetcher jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher;
  protected static final String a = "BubbleDiyFetcher";
  private static boolean jdField_a_of_type_Boolean;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public LRULinkedHashMap a;
  public HashMap a;
  public HashSet a;
  
  private BubbleDiyFetcher()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(32);
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public static BubbleDiyFetcher a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher == null) {
        jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher = new BubbleDiyFetcher();
      }
      BubbleDiyFetcher localBubbleDiyFetcher = jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher;
      return localBubbleDiyFetcher;
    }
    finally {}
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = true;
      ThreadManager.a(new qts(this, paramQQAppInterface), 5, null, false);
    }
  }
  
  public String a(VipBubbleDrawable paramVipBubbleDrawable, String paramString)
  {
    Object localObject = (String)this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(paramString);
    if (localObject != null) {
      return (String)localObject;
    }
    this.jdField_a_of_type_JavaUtilHashSet.add(paramString);
    List localList = (List)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject);
    }
    ((List)localObject).add(new SoftReference(paramVipBubbleDrawable));
    return null;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_JavaUtilHashSet.isEmpty()) || (paramQQAppInterface == null)) {
      return;
    }
    ThreadManager.a(new qtv(this, paramQQAppInterface), 5, null, false);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    b(paramQQAppInterface);
    if (paramInt <= 0)
    {
      a(paramQQAppInterface);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new qtu(this, paramQQAppInterface), paramInt);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, BusinessObserver paramBusinessObserver)
  {
    if (paramQQAppInterface == null) {}
    String str2;
    do
    {
      return;
      str2 = BubbleDiyText.makeKey(paramQQAppInterface.a(), paramInt);
      Object localObject2 = paramQQAppInterface.a().createEntityManager();
      String str1 = (String)this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(str2);
      localObject1 = str1;
      if (TextUtils.isEmpty(str1))
      {
        localObject2 = (BubbleDiyText)((EntityManager)localObject2).a(BubbleDiyText.class, " mUinAndTextId=? ", new String[] { str2 });
        localObject1 = str1;
        if (localObject2 != null)
        {
          localObject1 = str1;
          if (!TextUtils.isEmpty(((BubbleDiyText)localObject2).mText))
          {
            localObject1 = ((BubbleDiyText)localObject2).mText;
            this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(str2, localObject1);
          }
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break;
      }
      paramQQAppInterface = new BubbleDiyText(str2, (String)localObject1, 0L);
      localObject1 = new ArrayList();
      ((List)localObject1).add(paramQQAppInterface);
    } while (paramBusinessObserver == null);
    paramBusinessObserver.a(1, true, localObject1);
    return;
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(str2);
    ((BubbleDiyHandler)paramQQAppInterface.a(70)).a((List)localObject1, paramBusinessObserver);
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, List paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      BubbleDiyText localBubbleDiyText = (BubbleDiyText)localIterator.next();
      if (paramBoolean) {
        paramQQAppInterface.a().createEntityManager().a(localBubbleDiyText);
      }
      if ((!TextUtils.isEmpty(localBubbleDiyText.mUinAndTextId)) && (!TextUtils.isEmpty(localBubbleDiyText.mText))) {
        this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(localBubbleDiyText.mUinAndTextId, localBubbleDiyText.mText);
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new qtt(this, paramList));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\bubble\BubbleDiyFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */