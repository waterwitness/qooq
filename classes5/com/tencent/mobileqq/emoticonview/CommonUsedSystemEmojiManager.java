package com.tencent.mobileqq.emoticonview;

import android.util.SparseIntArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.pb.emosm.EmosmPb.SmallYellowItem;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x13Rsp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import rjo;
import rjp;
import rjq;

public class CommonUsedSystemEmojiManager
  implements Manager
{
  public static final int a = 1;
  public static final String a;
  private static final HashMap jdField_a_of_type_JavaUtilHashMap;
  public static final int b = 2;
  public static final String b = "commonUsedSystemEmoji_sp";
  public static final String c = "lastRequestTime";
  public static final String d = "commonusedSystemEmojiInfoFile_v2_";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public List a;
  public int[] a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = CommonUsedSystemEmojiManager.class.getSimpleName();
    jdField_a_of_type_JavaUtilHashMap = new HashMap(5);
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(217), Integer.valueOf(0));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(223), Integer.valueOf(3));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(168), Integer.valueOf(8));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(219), Integer.valueOf(10));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(212), Integer.valueOf(12));
  }
  
  public CommonUsedSystemEmojiManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ArrayOfInt = new int[] { 128525, 13, 128532, 5, 6, 14, 3, 20, 109, 28, 127874, 63, 9, 1, 49, 22, 128557, 11, 128169, 128163, 98, 27, 35, 2 };
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private List a(List paramList1, List paramList2)
  {
    List localList = null;
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "mergeAndSortSystemEmojiInfo");
    }
    if ((paramList1 == null) && (paramList2 == null))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "mergeAndSortSystemEmojiInfo list IS null");
      paramList1 = localList;
      return paramList1;
    }
    if (paramList1 == null) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "mergeAndSortSystemEmojiInfo  list1 = NULL");
    }
    for (localList = paramList2;; localList = null)
    {
      if (paramList2 == null)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "mergeAndSortSystemEmojiInfo  list2 = NULL");
        localList = paramList1;
      }
      if (localList == null)
      {
        paramList1.addAll(paramList2);
        localList = paramList1;
      }
      for (;;)
      {
        Object localObject;
        int i;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder("mergeAndSortSystemEmojiInfo:");
          if (paramList1 != null)
          {
            ((StringBuilder)localObject).append("befor sort list1 : ");
            i = 0;
            while (i < paramList1.size())
            {
              EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)paramList1.get(i);
              ((StringBuilder)localObject).append("type = " + localSmallYellowItem.type.get()).append(";id = " + localSmallYellowItem.id.get()).append(";ts = " + localSmallYellowItem.ts.get());
              i += 1;
            }
          }
          if (paramList2 != null)
          {
            ((StringBuilder)localObject).append("befor sort list2 : ");
            i = 0;
            while (i < paramList2.size())
            {
              paramList1 = (EmosmPb.SmallYellowItem)paramList2.get(i);
              ((StringBuilder)localObject).append("type = " + paramList1.type.get()).append(";id = " + paramList1.id.get()).append(";ts = " + paramList1.ts.get());
              i += 1;
            }
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "mergeAndSortSystemEmojiInfo merge:" + ((StringBuilder)localObject).toString());
        }
        Collections.sort(localList, new rjp(this));
        if (QLog.isColorLevel())
        {
          paramList1 = new StringBuilder("mergeAndSortSystemEmojiInfo:");
          if (localList != null)
          {
            paramList1.append("after sort ,mergeList:");
            i = 0;
            while (i < localList.size())
            {
              paramList2 = (EmosmPb.SmallYellowItem)localList.get(i);
              paramList1.append("type = " + paramList2.type.get()).append(";id = " + paramList2.id.get()).append(";ts = " + paramList2.ts.get());
              i += 1;
            }
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "mergeAndSortSystemEmojiInfo merge:" + paramList1.toString());
        }
        paramList1 = new HashSet();
        paramList2 = localList.iterator();
        while (paramList2.hasNext())
        {
          localObject = (EmosmPb.SmallYellowItem)paramList2.next();
          localObject = ((EmosmPb.SmallYellowItem)localObject).type.get() + "-" + ((EmosmPb.SmallYellowItem)localObject).id.get();
          if (paramList1.contains(localObject)) {
            paramList2.remove();
          } else {
            paramList1.add(localObject);
          }
        }
        paramList1 = localList;
        if (!QLog.isColorLevel()) {
          break;
        }
        paramList1 = new StringBuilder("mergeAndSortSystemEmojiInfo:");
        if (localList != null)
        {
          paramList1.append("after merge ,mergeList:");
          i = j;
          while (i < localList.size())
          {
            paramList2 = (EmosmPb.SmallYellowItem)localList.get(i);
            paramList1.append("type = " + paramList2.type.get()).append(";id = " + paramList2.id.get()).append(";ts = " + paramList2.ts.get());
            i += 1;
          }
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "mergeAndSortSystemEmojiInfo merge:" + paramList1.toString());
        return localList;
      }
    }
  }
  
  private List c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getCacheInfo");
    }
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() < 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getCacheInfo is null");
      }
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((EmosmPb.SmallYellowItem)localIterator.next());
      }
    }
    finally {}
    return localList;
  }
  
  public List a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() < 1))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "getCommonUsedSystemEmojiInfo  useDefaultinfo");
      a();
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      int i = 0;
      if (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        EmosmPb.SmallYellowItem localSmallYellowItem = new EmosmPb.SmallYellowItem();
        int j = this.jdField_a_of_type_ArrayOfInt[i];
        int k;
        if (j > MessageUtils.b.length)
        {
          localSmallYellowItem.type.set(2);
          k = EmotcationConstants.a.get(j);
          j = k;
          if (jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(k)))
          {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "getCommonUsedSystemEmojiInfo dedault before EMOTIONPANEL_EMOJI_MAP index = " + k);
            j = ((Integer)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(k))).intValue();
            QLog.d(jdField_a_of_type_JavaLangString, 2, "getCommonUsedSystemEmojiInfo dedault after EMOTIONPANEL_EMOJI_MAP index = " + j);
          }
          localSmallYellowItem.id.set(j);
        }
        for (;;)
        {
          localSmallYellowItem.ts.set(0L);
          this.jdField_a_of_type_JavaUtilList.add(localSmallYellowItem);
          i += 1;
          break;
          localSmallYellowItem.type.set(1);
          k = MessageUtils.b[j];
          j = k;
          if (k == 250) {
            j = 10;
          }
          localSmallYellowItem.id.set(j);
        }
      }
      return c();
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getCommonUsedSystemEmojiInfo ");
    }
    return c();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateCacheFromFile");
    }
    ThreadManager.a().post(new rjo(this));
  }
  
  public void a(EmosmPb.SmallYellowItem paramSmallYellowItem)
  {
    int i = 0;
    if (paramSmallYellowItem == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "saveSystemEmojiInfoToCahce info = null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "saveSystemEmojiInfoToCahce id = " + paramSmallYellowItem.id.get() + ";type = " + paramSmallYellowItem.type.get() + ";ts = " + paramSmallYellowItem.ts.get());
    }
    int j = paramSmallYellowItem.type.get();
    int k = paramSmallYellowItem.id.get();
    for (;;)
    {
      EmosmPb.SmallYellowItem localSmallYellowItem;
      try
      {
        if (this.jdField_a_of_type_JavaUtilList == null) {
          break label325;
        }
        if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label350;
        }
        localSmallYellowItem = (EmosmPb.SmallYellowItem)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localSmallYellowItem.type.get() == j) && (localSmallYellowItem.id.get() == k))
        {
          localSmallYellowItem = null;
          if (i < 0) {
            break label284;
          }
          localSmallYellowItem = (EmosmPb.SmallYellowItem)this.jdField_a_of_type_JavaUtilList.remove(i);
          if ((QLog.isColorLevel()) && (localSmallYellowItem != null)) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "saveSystemEmojiInfoToCahce removeInfo : type =" + localSmallYellowItem.type.get() + ";id = " + localSmallYellowItem.id.get() + ";ts = " + localSmallYellowItem.ts.get());
          }
          this.jdField_a_of_type_JavaUtilList.add(0, paramSmallYellowItem);
          return;
        }
      }
      finally {}
      i += 1;
      continue;
      label284:
      if (this.jdField_a_of_type_JavaUtilList.size() >= 21)
      {
        localSmallYellowItem = (EmosmPb.SmallYellowItem)this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1);
        continue;
        label325:
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        this.jdField_a_of_type_JavaUtilList.add(paramSmallYellowItem);
        continue;
        label350:
        i = -1;
      }
    }
  }
  
  public void a(List paramList)
  {
    if (paramList == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "updateItemInfo info = null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateItemInfo backList size = " + paramList.size());
    }
    ??? = new ArrayList();
    int i = 0;
    Object localObject2;
    int j;
    int m;
    int k;
    if (i < paramList.size())
    {
      localObject2 = (EmosmPb.SmallYellowItem)paramList.get(i);
      j = ((EmosmPb.SmallYellowItem)localObject2).type.get();
      m = ((EmosmPb.SmallYellowItem)localObject2).id.get();
      if (j == 1) {
        if ((m >= 0) && (m < MessageUtils.b.length))
        {
          k = MessageUtils.b[m];
          j = k;
          if (k == 250) {
            j = 10;
          }
          if ((j >= EmotcationConstants.b) || (j < 0))
          {
            ((List)???).add(localObject2);
            QLog.e(jdField_a_of_type_JavaLangString, 1, "updateItemInfo system id overflow index = " + m + ";emId = " + j);
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        ((EmosmPb.SmallYellowItem)localObject2).id.set(j);
        continue;
        ((List)???).add(localObject2);
        QLog.e(jdField_a_of_type_JavaLangString, 1, "updateItemInfo system id overflow index = " + m);
        continue;
        if (j == 2)
        {
          k = EmotcationConstants.a.get(m);
          j = k;
          if (jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(k)))
          {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "updateItemInfo before EMOTIONPANEL_EMOJI_MAP index = " + k);
            j = ((Integer)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(k))).intValue();
            QLog.d(jdField_a_of_type_JavaLangString, 2, "updateItemInfo after EMOTIONPANEL_EMOJI_MAP index = " + j);
          }
          if (j < 0)
          {
            ((List)???).add(localObject2);
            QLog.e(jdField_a_of_type_JavaLangString, 1, "updateItemInfo emoji id overflow index = " + m + ";localIndex = " + j);
          }
          else
          {
            ((EmosmPb.SmallYellowItem)localObject2).id.set(j);
          }
        }
      }
    }
    if (((List)???).size() > 0) {
      paramList.removeAll((Collection)???);
    }
    if (paramList.size() < 1)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "updateItemInfo itemInfos size < 1");
      return;
    }
    new ArrayList();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      paramList = a(paramList, c());
    }
    while (paramList.size() > 21)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "before remove size = " + paramList.size());
      }
      ??? = new ArrayList();
      i = 21;
      for (;;)
      {
        if (i < paramList.size())
        {
          ((List)???).add(paramList.get(i));
          i += 1;
          continue;
          paramList = a(null, paramList);
          break;
        }
      }
      paramList.removeAll((Collection)???);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "after remove size = " + paramList.size());
      }
    }
    label752:
    int i1;
    if (paramList.size() < 21)
    {
      i = paramList.size();
      ??? = new ArrayList();
      if (21 - i < 0)
      {
        j = 0;
        k = 0;
        if (j < this.jdField_a_of_type_ArrayOfInt.length)
        {
          i = this.jdField_a_of_type_ArrayOfInt[j];
          int n;
          if (i > MessageUtils.b.length)
          {
            m = MessageUtils.b[i];
            i = 2;
            n = 0;
          }
          for (;;)
          {
            if (n >= paramList.size()) {
              break label1123;
            }
            localObject2 = (EmosmPb.SmallYellowItem)paramList.get(n);
            i1 = ((EmosmPb.SmallYellowItem)localObject2).type.get();
            int i2 = ((EmosmPb.SmallYellowItem)localObject2).id.get();
            if ((i1 == i) && (i2 == m))
            {
              i1 = 1;
              n = k;
              if (i1 == 0)
              {
                n = k + 1;
                localObject2 = new EmosmPb.SmallYellowItem();
                ((EmosmPb.SmallYellowItem)localObject2).type.set(i);
                ((EmosmPb.SmallYellowItem)localObject2).id.set(m);
                ((EmosmPb.SmallYellowItem)localObject2).ts.set(0L);
                ((List)???).add(localObject2);
              }
              j += 1;
              k = n;
              break;
              m = EmotcationConstants.a.get(i);
              i = m;
              if (jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(m)))
              {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "updateItemInfo dedault before EMOTIONPANEL_EMOJI_MAP index = " + m);
                i = ((Integer)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(m))).intValue();
                QLog.d(jdField_a_of_type_JavaLangString, 2, "updateItemInfo dedault after EMOTIONPANEL_EMOJI_MAP index = " + i);
              }
              n = 1;
              m = i;
              i = n;
              break label752;
            }
            n += 1;
          }
        }
      }
    }
    for (;;)
    {
      if (??? != null) {
        paramList.addAll((Collection)???);
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        localObject2 = new File(BaseApplicationImpl.a.getFilesDir(), "commonusedSystemEmojiInfoFile_v2_" + BaseApplicationImpl.a.a().getAccount());
        EmosmPb.SubCmd0x13Rsp localSubCmd0x13Rsp = new EmosmPb.SubCmd0x13Rsp();
        localSubCmd0x13Rsp.itemlist.set(paramList);
        FileUtils.a(((File)localObject2).getAbsolutePath(), localSubCmd0x13Rsp.toByteArray(), false);
        try
        {
          this.jdField_a_of_type_JavaUtilList = paramList;
          return;
        }
        finally {}
      }
      label1123:
      i1 = 0;
      break;
      ??? = null;
    }
  }
  
  public List b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getLocalSystemEmojiInfoFromFile");
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Object localObject3 = new File(BaseApplicationImpl.a.getFilesDir(), "commonusedSystemEmojiInfoFile_v2_" + BaseApplicationImpl.a.a().getAccount());
      if (!((File)localObject3).exists())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getLocalSystemEmojiInfoFromFile file not exists");
        return null;
      }
      localObject3 = FileUtils.a((File)localObject3);
      if (localObject3 == null)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "Can not translate pb file to byte");
        return null;
      }
    }
    ??? = new EmosmPb.SubCmd0x13Rsp();
    for (;;)
    {
      int i;
      int k;
      try
      {
        ((EmosmPb.SubCmd0x13Rsp)???).mergeFrom(arrayOfByte);
        ??? = ((EmosmPb.SubCmd0x13Rsp)???).itemlist.get();
        localObject4 = new ArrayList();
        if ((??? != null) && (((List)???).size() > 0))
        {
          i = 0;
          if (i < ((List)???).size())
          {
            localObject5 = (EmosmPb.SmallYellowItem)((List)???).get(i);
            localSmallYellowItem = new EmosmPb.SmallYellowItem();
            localSmallYellowItem.ts.set(((EmosmPb.SmallYellowItem)localObject5).ts.get());
            localSmallYellowItem.type.set(((EmosmPb.SmallYellowItem)localObject5).type.get());
            localSmallYellowItem.id.set(((EmosmPb.SmallYellowItem)localObject5).id.get());
            ((List)localObject4).add(localSmallYellowItem);
            i += 1;
            continue;
          }
        }
        Object localObject5 = c();
        if ((??? != null) && (((List)???).size() > 0))
        {
          i = 0;
          if (i < ((List)???).size())
          {
            localSmallYellowItem = (EmosmPb.SmallYellowItem)((List)???).get(i);
            j = localSmallYellowItem.type.get();
            k = localSmallYellowItem.id.get();
            if (j != 1) {
              continue;
            }
            if ((k >= 0) && (k < MessageUtils.a.length))
            {
              j = k;
              if (k == 10) {
                j = 250;
              }
              j = MessageUtils.a[j];
              localSmallYellowItem.id.set(j);
              break label526;
            }
            QLog.e(jdField_a_of_type_JavaLangString, 1, "getLocalSystemEmojiInfoFromFile system error localId = " + k);
          }
        }
        localObject4 = a((List)localObject4, (List)localObject5);
      }
      catch (Exception localException)
      {
        Object localObject4;
        EmosmPb.SmallYellowItem localSmallYellowItem;
        int j;
        QLog.e(jdField_a_of_type_JavaLangString, 1, "getLocalSystemEmojiInfoFromFile mergeFromBody exception e = " + localException.getMessage());
        return null;
      }
      try
      {
        this.jdField_a_of_type_JavaUtilList = ((List)localObject4);
        return (List)???;
      }
      finally {}
      if ((k >= 0) && (k < EmotcationConstants.c.length))
      {
        j = EmotcationConstants.c[k];
        localSmallYellowItem.id.set(j);
      }
      else
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "getLocalSystemEmojiInfoFromFile emoji error localId = " + k);
        continue;
      }
      label526:
      i += 1;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "saveSystemEmojiInfoToFile");
    }
    ThreadManager.a().post(new rjq(this));
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\CommonUsedSystemEmojiManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */