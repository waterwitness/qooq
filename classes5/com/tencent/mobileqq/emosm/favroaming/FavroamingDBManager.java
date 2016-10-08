package com.tencent.mobileqq.emosm.favroaming;

import android.os.Looper;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.FunnyPicHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqManager;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import rgt;
import rgu;

public class FavroamingDBManager
  implements Manager
{
  private static final int jdField_a_of_type_Int = 1;
  public static final String a = "FavroamingDBManager";
  private static final int b = 2;
  private static final int c = 4;
  public QQAppInterface a;
  private List jdField_a_of_type_JavaUtilList;
  
  public FavroamingDBManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new Vector();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private CustomEmotionData a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    CustomEmotionData localCustomEmotionData = null;
    Object localObject = localCustomEmotionData;
    if (paramString1 != null)
    {
      if (!TextUtils.isEmpty(paramString2)) {
        break label25;
      }
      localObject = localCustomEmotionData;
    }
    label25:
    String str1;
    ResidParser localResidParser;
    String str2;
    do
    {
      do
      {
        do
        {
          return (CustomEmotionData)localObject;
          str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          localResidParser = new ResidParser(paramString1);
          localObject = localCustomEmotionData;
        } while (TextUtils.isEmpty(localResidParser.a));
        str2 = localResidParser.c;
        localObject = localCustomEmotionData;
      } while (str2 == null);
      localObject = localCustomEmotionData;
    } while ("".equals(str2));
    localCustomEmotionData = new CustomEmotionData();
    if (str2.equals("1"))
    {
      localCustomEmotionData.isMarkFace = true;
      localCustomEmotionData.uin = str1;
      localCustomEmotionData.emoPath = localResidParser.e;
      localCustomEmotionData.eId = localResidParser.f;
      localCustomEmotionData.resid = paramString1;
      localCustomEmotionData.RomaingType = paramString3;
      localCustomEmotionData.url = FavEmoConstant.a(paramString1, paramString2, str1);
      localCustomEmotionData.emoId = paramInt;
    }
    for (;;)
    {
      localObject = localCustomEmotionData;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FavroamingDBManager", 2, "createCustomEmotionDataByResIdList : emotionData = " + localCustomEmotionData + ", emotion name:" + paramString1);
      return localCustomEmotionData;
      if (str2.equals("0"))
      {
        localObject = localResidParser.f;
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("qto@")))
        {
          localObject = ((String)localObject).replace("qto@", "qto_");
          localCustomEmotionData.eId = ((String)localObject);
          if (QLog.isColorLevel()) {
            QLog.d("FavroamingDBManager", 2, "download funnyPic name.original->" + (String)localObject);
          }
        }
        localCustomEmotionData.isMarkFace = false;
        localCustomEmotionData.uin = str1;
        localCustomEmotionData.emoPath = FavEmoConstant.a(paramString1);
        localCustomEmotionData.resid = paramString1;
        localCustomEmotionData.md5 = localResidParser.d;
        localCustomEmotionData.url = FavEmoConstant.a(paramString1, paramString2, str1);
        localCustomEmotionData.RomaingType = paramString3;
        localCustomEmotionData.emoId = paramInt;
      }
    }
  }
  
  private void a(CustomEmotionData paramCustomEmotionData, int paramInt)
  {
    if (paramCustomEmotionData == null) {
      return;
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label185;
        }
        if (((CustomEmotionData)this.jdField_a_of_type_JavaUtilList.get(i)).emoId != paramCustomEmotionData.emoId) {
          break label107;
        }
        this.jdField_a_of_type_JavaUtilList.remove(i);
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingDBManager", 2, "can not update fav emoticon cache data, type:" + paramInt);
      }
      return;
      label107:
      i += 1;
      continue;
      this.jdField_a_of_type_JavaUtilList.add(paramCustomEmotionData);
      continue;
      if (i != -1)
      {
        this.jdField_a_of_type_JavaUtilList.add(i, paramCustomEmotionData);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("FavroamingDBManager", 2, "fav emoticon has been deleted, can not update type:" + paramInt);
        continue;
        label185:
        i = -1;
        switch (paramInt)
        {
        }
      }
    }
  }
  
  private void a(Runnable paramRunnable, int paramInt)
  {
    if (paramRunnable != null)
    {
      if (Looper.myLooper() != Looper.getMainLooper()) {
        paramRunnable.run();
      }
    }
    else {
      return;
    }
    ThreadManager.a(paramRunnable, paramInt, null, true);
  }
  
  private void a(List paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() < 1)) {
      return;
    }
    a(new rgt(this, paramList, paramInt), 8);
  }
  
  private void b(CustomEmotionData paramCustomEmotionData, int paramInt)
  {
    if (paramCustomEmotionData == null) {
      return;
    }
    a(new rgu(this, paramInt, paramCustomEmotionData), 8);
  }
  
  public CustomEmotionData a(List paramList, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((paramList == null) || (paramList.size() < 1)) {
      return null;
    }
    int j = paramList.size();
    int i = 0;
    CustomEmotionData localCustomEmotionData;
    for (;;)
    {
      if (i < j)
      {
        localCustomEmotionData = (CustomEmotionData)paramList.get(i);
        if (localCustomEmotionData == null) {
          label59:
          i += 1;
        } else if ((!TextUtils.isEmpty(localCustomEmotionData.resid)) && (localCustomEmotionData.resid.equals(paramString))) {
          paramList = localCustomEmotionData;
        }
      }
    }
    for (;;)
    {
      label94:
      return paramList;
      Object localObject = new ResidParser(paramString);
      if (!((ResidParser)localObject).a())
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("FavroamingDBManager", 2, "res id is not valid:" + paramString);
        return null;
      }
      if (localCustomEmotionData.isMarkFace)
      {
        str = ((ResidParser)localObject).e;
        localObject = ((ResidParser)localObject).f;
        if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject)) || (!str.equals(localCustomEmotionData.emoPath)) || (!((String)localObject).equals(localCustomEmotionData.eId))) {
          break label59;
        }
        localCustomEmotionData.resid = paramString;
        paramList = localCustomEmotionData;
        continue;
      }
      localObject = ((ResidParser)localObject).d;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label59;
      }
      if (!TextUtils.isEmpty(localCustomEmotionData.md5)) {}
      for (String str = localCustomEmotionData.md5;; str = HexUtil.bytes2HexStr(MD5.getFileMd5(localCustomEmotionData.emoPath)))
      {
        localCustomEmotionData.md5 = str;
        if (!((String)localObject).equals(str)) {
          break;
        }
        localCustomEmotionData.resid = paramString;
        paramList = localCustomEmotionData;
        break label94;
      }
      paramList = null;
    }
  }
  
  public List a()
  {
    int j = 0;
    int k = 0;
    int i = 0;
    Object localObject1 = new ArrayList();
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          if (i < this.jdField_a_of_type_JavaUtilList.size())
          {
            CustomEmotionData localCustomEmotionData = (CustomEmotionData)this.jdField_a_of_type_JavaUtilList.get(i);
            if (localCustomEmotionData == null) {
              break label311;
            }
            ((List)localObject1).add(localCustomEmotionData);
            break label311;
          }
          if (QLog.isColorLevel()) {
            QLog.d("FavroamingDBManager", 2, "getFavEmoticonList from cache: data size = " + ((List)localObject1).size());
          }
          return (List)localObject1;
        }
        ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        if (??? == null) {
          break label308;
        }
        localObject1 = ((EntityManager)???).a(CustomEmotionData.class, false, null, null, null, null, null, null);
        ((EntityManager)???).a();
        i = k;
        if (localObject1 != null)
        {
          i = k;
          if (((List)localObject1).size() > 0)
          {
            i = 0;
            if (j < ((List)localObject1).size())
            {
              ??? = (CustomEmotionData)((List)localObject1).get(j);
              if (TextUtils.isEmpty(((CustomEmotionData)???).RomaingType))
              {
                ((CustomEmotionData)???).RomaingType = "init";
                i = 1;
              }
              a((CustomEmotionData)???, 1);
              j += 1;
            }
          }
        }
      }
      if (i != 0) {
        a(localList, 2);
      }
      if (QLog.isColorLevel())
      {
        if (localList == null) {
          break label296;
        }
        QLog.d("FavroamingDBManager", 2, "getFavEmoticonList from db : data size = " + localList.size());
      }
      for (;;)
      {
        return localList;
        label296:
        QLog.d("FavroamingDBManager", 2, "getFavEmoticonList from db : data size = null");
      }
      label308:
      continue;
      label311:
      i += 1;
    }
  }
  
  public List a(int paramInt)
  {
    StartupTracker.a("AIO_EmoticonPanel_Refresh", null);
    Map localMap = ((VipComicMqqManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(140)).a();
    List localList = a();
    ArrayList localArrayList1 = new ArrayList();
    if (localList != null)
    {
      ArrayList localArrayList2 = new ArrayList();
      int i = localList.size() - 1;
      if (i >= 0)
      {
        Object localObject1 = (CustomEmotionData)localList.get(i);
        if ((TextUtils.isEmpty(((CustomEmotionData)localObject1).emoPath)) && (!TextUtils.isEmpty(((CustomEmotionData)localObject1).url)))
        {
          localArrayList2.add(localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("FavroamingDBManager", 2, "data is not intact ");
          }
        }
        for (;;)
        {
          i -= 1;
          break;
          if ((!((CustomEmotionData)localObject1).isMarkFace) && (("isUpdate".equals(((CustomEmotionData)localObject1).RomaingType)) || ("overflow_downloaded".equals(((CustomEmotionData)localObject1).RomaingType))) && (!new File(((CustomEmotionData)localObject1).emoPath).exists()))
          {
            localArrayList2.add(localObject1);
            if (QLog.isColorLevel()) {
              QLog.d("FavroamingDBManager", 2, "file not exist");
            }
          }
          else if ("needDel".equals(((CustomEmotionData)localObject1).RomaingType))
          {
            if (QLog.isColorLevel()) {
              QLog.d("FavroamingDBManager", 2, "data need delete, do not need display -> resId:" + ((CustomEmotionData)localObject1).resid);
            }
          }
          else if ((paramInt == 100) && (("needDownload".equals(((CustomEmotionData)localObject1).RomaingType)) || ("overflow".equals(((CustomEmotionData)localObject1).RomaingType))))
          {
            if (QLog.isColorLevel()) {
              QLog.d("FavroamingDBManager", 2, "data not downloaded, do not need display -> resId:" + ((CustomEmotionData)localObject1).resid);
            }
          }
          else
          {
            Object localObject2;
            if (((CustomEmotionData)localObject1).isMarkFace)
            {
              localObject2 = new PicEmoticonInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
              ((PicEmoticonInfo)localObject2).c = 6;
              String str = ((CustomEmotionData)localObject1).eId;
              localObject1 = ((CustomEmotionData)localObject1).emoPath;
              ((PicEmoticonInfo)localObject2).a = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a((String)localObject1, str);
              ((PicEmoticonInfo)localObject2).d = 2;
              if (((PicEmoticonInfo)localObject2).a != null) {
                localArrayList1.add(localObject2);
              }
            }
            else
            {
              localObject2 = new FavoriteEmoticonInfo();
              ((FavoriteEmoticonInfo)localObject2).c = 4;
              ((FavoriteEmoticonInfo)localObject2).m = ((CustomEmotionData)localObject1).emoPath;
              ((FavoriteEmoticonInfo)localObject2).d = 2;
              ((FavoriteEmoticonInfo)localObject2).l = ((CustomEmotionData)localObject1).eId;
              ((FavoriteEmoticonInfo)localObject2).n = FavoriteEmoticonInfo.a(localMap, ((CustomEmotionData)localObject1).md5);
              localArrayList1.add(localObject2);
            }
          }
        }
      }
      FunnyPicHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), localArrayList2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
      StartupTracker.a(null, "AIO_EmoticonPanel_Refresh");
    }
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingDBManager", 2, "getFavEmotionInfoShowedInPanel, display size:" + localArrayList1.size());
    }
    return localArrayList1;
  }
  
  public List a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    List localList = a();
    if ((localList != null) && (localList.size() > 0))
    {
      int i = 0;
      while (i < localList.size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(i);
        String str = localCustomEmotionData.resid;
        if ((!TextUtils.isEmpty(localCustomEmotionData.RomaingType)) || ((localCustomEmotionData.RomaingType.equals(paramString)) && (str != null) && (!"".equals(str)))) {
          localArrayList.add(str);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public List a(List paramList1, List paramList2)
  {
    if ((paramList1 == null) && (paramList2 == null)) {}
    ArrayList localArrayList;
    do
    {
      return null;
      localArrayList = new ArrayList();
      if (paramList1 != null) {
        localArrayList.addAll(paramList1);
      }
      if (paramList2 != null) {
        localArrayList.addAll(paramList2);
      }
      paramList1 = a("isUpdate");
    } while (paramList1 == null);
    paramList2 = new ArrayList();
    int i = 0;
    while (i < paramList1.size())
    {
      if (!localArrayList.contains(paramList1.get(i))) {
        paramList2.add(paramList1.get(i));
      }
      i += 1;
    }
    return paramList2;
  }
  
  public List a(List paramList1, List paramList2, String paramString)
  {
    int m = 0;
    ArrayList localArrayList = new ArrayList();
    List localList = a(paramList1, paramList2);
    if ((localList != null) && (localList.size() > 0)) {
      localArrayList.addAll(localList);
    }
    if ((paramList1 != null) && (paramList1.size() > 0)) {
      localArrayList.addAll(paramList1);
    }
    int i;
    Object localObject;
    if (localArrayList.size() > 0)
    {
      paramList1 = new ArrayList();
      localList = a();
      i = 0;
      while (i < localArrayList.size())
      {
        localObject = a(localList, (String)localArrayList.get(i));
        if (localObject != null) {
          paramList1.add(localObject);
        }
        i += 1;
      }
      e(paramList1);
    }
    localList = a();
    if (localList != null)
    {
      int k = 0;
      for (i = 1;; i = j)
      {
        j = i;
        if (k >= localList.size()) {
          break;
        }
        int n = ((CustomEmotionData)localList.get(k)).emoId;
        j = i;
        if (i < n) {
          j = n;
        }
        k += 1;
      }
    }
    int j = 1;
    localArrayList = new ArrayList();
    if (paramList2 != null)
    {
      localObject = a();
      paramList2 = paramList2.iterator();
      if (paramList2.hasNext())
      {
        String str = (String)paramList2.next();
        paramList1 = a((List)localObject, str);
        if (paramList1 == null)
        {
          j += 1;
          paramList1 = a(str, paramString, "needDownload", j);
        }
        for (;;)
        {
          localArrayList.add(paramList1);
          break;
          if (localList != null)
          {
            if ("init".equals(paramList1.RomaingType)) {
              paramList1.RomaingType = "isUpdate";
            }
            if (TextUtils.isEmpty(paramList1.url))
            {
              if (QLog.isColorLevel()) {
                QLog.d("FavroamingDBManager", 2, "url is null because of old db data exception, fix it");
              }
              paramList1.url = FavEmoConstant.a(str, paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
            }
            localList.remove(paramList1);
          }
        }
      }
    }
    if ((localList != null) && (localList.size() > 0)) {
      localArrayList.addAll(localList);
    }
    if (localArrayList.size() >= FavEmoConstant.b) {}
    for (paramList1 = localArrayList.subList(0, FavEmoConstant.b);; paramList1 = localArrayList)
    {
      i = 0;
      if (i < paramList1.size())
      {
        paramList2 = (CustomEmotionData)paramList1.get(i);
        if (i <= FavEmoConstant.a) {
          if (paramList2.RomaingType != null) {
            if (paramList2.RomaingType.equals("overflow_downloaded")) {
              paramList2.RomaingType = "isUpdate";
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if ((!paramList2.RomaingType.equals("isUpdate")) && (!paramList2.RomaingType.equals("init")))
          {
            paramList2.RomaingType = "needDownload";
            continue;
            paramList2.RomaingType = "needDownload";
            continue;
            if (i <= FavEmoConstant.b) {
              if (paramList2.RomaingType != null)
              {
                if (paramList2.RomaingType.equals("isUpdate")) {
                  paramList2.RomaingType = "overflow_downloaded";
                } else if ((!paramList2.RomaingType.equals("overflow_downloaded")) && (!paramList2.RomaingType.equals("init"))) {
                  paramList2.RomaingType = "overflow";
                }
              }
              else {
                paramList2.RomaingType = "overflow";
              }
            }
          }
        }
      }
      paramList2 = a();
      if (paramList2 != null)
      {
        i = paramList2.size();
        e(paramList2);
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(paramList1);
        a(paramList1, 1);
        j = m;
        if (localList != null)
        {
          j = localList.size() - 1;
          while (j >= 0)
          {
            paramList2 = (CustomEmotionData)localList.get(j);
            if ((paramList2 != null) && (!paramList1.contains(paramList2))) {
              localList.remove(j);
            }
            j -= 1;
          }
          j = localList.size();
        }
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingDBManager", 2, "updateFavEmotionsInLocalEx final cache size: " + paramList1.size() + ",delete size:" + i + ",upload size:" + j);
        }
        return localList;
        i = 0;
      }
    }
  }
  
  public void a(CustomEmotionData paramCustomEmotionData)
  {
    if (paramCustomEmotionData != null)
    {
      a(paramCustomEmotionData, 4);
      b(paramCustomEmotionData, 4);
    }
  }
  
  public void a(String paramString)
  {
    CustomEmotionData localCustomEmotionData = a(a(), paramString);
    if (localCustomEmotionData != null)
    {
      localCustomEmotionData.resid = paramString;
      localCustomEmotionData.RomaingType = "isUpdate";
      b(localCustomEmotionData);
    }
  }
  
  public void a(List paramList)
  {
    if (paramList == null) {
      return;
    }
    e(paramList);
  }
  
  public boolean a(CustomEmotionData paramCustomEmotionData, int paramInt)
  {
    if (paramCustomEmotionData == null) {}
    while (!"needDel".equals(paramCustomEmotionData.RomaingType)) {
      return false;
    }
    if (paramInt <= FavEmoConstant.a) {}
    for (Object localObject = "isUpdate";; localObject = "overflow_downloaded")
    {
      paramCustomEmotionData.RomaingType = ((String)localObject);
      b(paramCustomEmotionData);
      localObject = (FavroamingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(102);
      if (localObject != null) {
        ((FavroamingManager)localObject).syncUpload(paramCustomEmotionData);
      }
      return true;
    }
  }
  
  public List b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    List localList;
    do
    {
      return null;
      localList = a();
    } while ((localList == null) || (localList.size() <= 0));
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < localList.size())
    {
      CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(i);
      if (localCustomEmotionData.RomaingType.equals(paramString)) {
        localArrayList.add(localCustomEmotionData);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void b(CustomEmotionData paramCustomEmotionData)
  {
    if (paramCustomEmotionData != null)
    {
      a(paramCustomEmotionData, 2);
      b(paramCustomEmotionData, 2);
    }
  }
  
  public void b(List paramList)
  {
    if (paramList == null) {}
    List localList;
    do
    {
      return;
      localList = b("needDel");
    } while (localList == null);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      String str = (String)paramList.get(i);
      int j = 0;
      while (j < localList.size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(i);
        if ((localCustomEmotionData.resid != null) && (!"".equals(localCustomEmotionData.resid)) && (localCustomEmotionData.resid.equals(str)))
        {
          a(localCustomEmotionData, 4);
          localArrayList.add(localCustomEmotionData);
        }
        j += 1;
      }
      i += 1;
    }
    a(localArrayList, 4);
  }
  
  public List c(String paramString)
  {
    List localList = a();
    ArrayList localArrayList = new ArrayList();
    if ((localList != null) && (localList.size() > 0))
    {
      int i = 0;
      while (i < localList.size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(i);
        if ((localCustomEmotionData != null) && (localCustomEmotionData.emoPath.equals(paramString))) {
          localArrayList.add(localCustomEmotionData);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public void c(CustomEmotionData paramCustomEmotionData)
  {
    if (paramCustomEmotionData != null)
    {
      a(paramCustomEmotionData, 1);
      b(paramCustomEmotionData, 1);
    }
  }
  
  public void c(List paramList)
  {
    if ((paramList == null) || (paramList.size() < 1)) {
      return;
    }
    int i = 0;
    while (i < paramList.size())
    {
      a((CustomEmotionData)paramList.get(i), 1);
      i += 1;
    }
    a(paramList, 1);
  }
  
  public void d(List paramList)
  {
    if ((paramList == null) || (paramList.size() < 1)) {
      return;
    }
    int i = 0;
    while (i < paramList.size())
    {
      a((CustomEmotionData)paramList.get(i), 2);
      i += 1;
    }
    a(paramList, 2);
  }
  
  public void e(List paramList)
  {
    if ((paramList == null) || (paramList.size() < 1)) {
      return;
    }
    int i = 0;
    while (i < paramList.size())
    {
      a((CustomEmotionData)paramList.get(i), 4);
      i += 1;
    }
    a(paramList, 4);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emosm\favroaming\FavroamingDBManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */