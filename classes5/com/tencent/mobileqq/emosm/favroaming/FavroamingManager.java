package com.tencent.mobileqq.emosm.favroaming;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.app.FavEmoRoamingObserver;
import com.tencent.mobileqq.app.FunnyPicHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;
import rgv;
import rgw;
import rgx;
import rgz;
import tencent.im.cs.cmd0x388.cmd0x388.ExpRoamPicInfo;
import tencent.im.cs.cmd0x388.cmd0x388.ExtensionExpRoamTryUp;

public class FavroamingManager
  extends IPicDownloadListener
  implements Manager
{
  public static final String TAG = "FavroamingManager";
  private static int jdField_a_of_type_Int = 0;
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private static int jdField_b_of_type_Int = 0;
  private static AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private static final long serialVersionUID = 1L;
  public Map downMap = new HashMap();
  private EmoticonPackageDownloadListener downloadListener = new rgv(this);
  private FavEmoRoamingObserver favObserver = new rgx(this);
  boolean isAddHandler = false;
  AtomicBoolean isInSync = new AtomicBoolean(false);
  private EmotionJsonDownloadListener jsonListener = new rgw(this);
  CopyOnWriteArrayList listeners = new CopyOnWriteArrayList();
  public QQAppInterface mApp = null;
  TransFileController mFileController;
  private TransProcessorHandler mTransProcessorHandler = new rgz(this, ThreadManager.b());
  String uin;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FavroamingManager(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.uin = paramQQAppInterface.a();
    this.mFileController = paramQQAppInterface.a();
    if (!TextUtils.isEmpty(this.uin))
    {
      int i = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getInt("fav_roaming_max" + this.uin, 144);
      if (i > 144) {
        FavEmoConstant.jdField_a_of_type_Int = i;
      }
    }
  }
  
  private void a()
  {
    if (isSyncFinish())
    {
      this.isInSync.set(false);
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "------------end syncRoaming----------");
      }
      int i = 0;
      while (i < this.listeners.size())
      {
        if (this.listeners.get(i) != null)
        {
          SyncListener localSyncListener = (SyncListener)((WeakReference)this.listeners.get(i)).get();
          if (localSyncListener != null) {
            localSyncListener.b();
          }
        }
        i += 1;
      }
    }
  }
  
  private void b()
  {
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    jdField_b_of_type_Int = 0;
    int i = 0;
    while (i < this.listeners.size())
    {
      if (this.listeners.get(i) != null)
      {
        SyncListener localSyncListener = (SyncListener)((WeakReference)this.listeners.get(i)).get();
        if (localSyncListener != null) {
          localSyncListener.a();
        }
      }
      i += 1;
    }
    a();
  }
  
  private void c()
  {
    int j = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    jdField_a_of_type_Int = 0;
    int i = 0;
    while (i < this.listeners.size())
    {
      if (this.listeners.get(i) != null)
      {
        SyncListener localSyncListener = (SyncListener)((WeakReference)this.listeners.get(i)).get();
        if (localSyncListener != null) {
          localSyncListener.a(j);
        }
      }
      i += 1;
    }
    a();
  }
  
  public static boolean isSyncFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "downloadCount:" + jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", needDownloadCount" + jdField_a_of_type_Int + "uploadCount:" + jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", needUploadCount" + jdField_b_of_type_Int);
    }
    return (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == jdField_a_of_type_Int) && (jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == jdField_b_of_type_Int);
  }
  
  public void addSyncListener(SyncListener paramSyncListener)
  {
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext()) {
      if (((WeakReference)localIterator.next()).get() == paramSyncListener) {
        return;
      }
    }
    paramSyncListener = new WeakReference(paramSyncListener);
    this.listeners.add(paramSyncListener);
  }
  
  public void downLoadFav()
  {
    int i = 0;
    if (!NetworkUtil.e(BaseApplication.getContext())) {
      this.isInSync.set(false);
    }
    while (this.mApp == null) {
      return;
    }
    Object localObject1 = (FavroamingDBManager)this.mApp.getManager(148);
    Object localObject4 = ((FavroamingDBManager)localObject1).b("needDownload");
    Object localObject3 = ((FavroamingDBManager)localObject1).b("overflow");
    Object localObject2 = null;
    localObject1 = localObject2;
    if (localObject4 != null)
    {
      localObject1 = localObject2;
      if (((List)localObject4).size() > 0)
      {
        localObject1 = new ArrayList();
        ((List)localObject1).addAll((Collection)localObject4);
      }
    }
    if ((localObject3 != null) && (((List)localObject3).size() > 0))
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new ArrayList();
      }
      ((List)localObject2).addAll((Collection)localObject3);
      localObject1 = localObject2;
    }
    for (;;)
    {
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
        jdField_a_of_type_Int = ((List)localObject1).size();
        localObject2 = new ArrayList();
        localObject3 = new ArrayList();
        if (i >= ((List)localObject1).size()) {
          break label246;
        }
        localObject4 = (CustomEmotionData)((List)localObject1).get(i);
        if (!((CustomEmotionData)localObject4).isMarkFace) {
          break label234;
        }
        ((List)localObject3).add(localObject4);
      }
      for (;;)
      {
        i += 1;
        break;
        a();
        return;
        label234:
        ((List)localObject2).add(localObject4);
      }
      label246:
      if (this.mApp == null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "needDownload: " + jdField_a_of_type_Int + ", markFace size: " + ((List)localObject3).size() + ", noMarkFace size:" + ((List)localObject2).size());
      }
      FunnyPicHelper.a(this.mApp.a().getApplicationContext(), (List)localObject2, this.mApp, this);
      downLoadMarketEmoList((List)localObject3);
      return;
    }
  }
  
  public void downLoadMarketEmo(String paramString)
  {
    if (paramString == null) {
      return;
    }
    EmojiListenerManager.a().a(this.jsonListener);
    ((EmojiManager)this.mApp.getManager(42)).a(paramString, EmojiManager.e, null, false);
  }
  
  public void downLoadMarketEmoList(List paramList)
  {
    if (paramList == null) {
      return;
    }
    for (;;)
    {
      int i;
      Object localObject;
      try
      {
        this.downMap.clear();
        i = 0;
        if (i < paramList.size())
        {
          localObject = (CustomEmotionData)paramList.get(i);
          if (localObject == null) {
            break label218;
          }
          if (this.downMap.containsKey(((CustomEmotionData)localObject).emoPath))
          {
            ((ArrayList)this.downMap.get(((CustomEmotionData)localObject).emoPath)).add(localObject);
          }
          else
          {
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(localObject);
            this.downMap.put(((CustomEmotionData)localObject).emoPath, localArrayList);
          }
        }
      }
      finally {}
      try
      {
        paramList = this.downMap.entrySet().iterator();
        while (paramList.hasNext())
        {
          localObject = (Map.Entry)paramList.next();
          if (localObject != null) {
            downLoadMarketEmo((String)((Map.Entry)localObject).getKey());
          }
        }
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception paramList) {}
      QLog.d("FavroamingManager", 2, "downmap exception=" + paramList.toString());
      break;
      label218:
      i += 1;
    }
  }
  
  public boolean isInSyncing()
  {
    return this.isInSync.compareAndSet(false, true);
  }
  
  public void onDestroy()
  {
    if (this.mFileController != null)
    {
      this.mFileController.b(this.mTransProcessorHandler);
      this.mTransProcessorHandler = null;
    }
    this.listeners.clear();
    this.mApp.b(this.favObserver);
    this.isInSync.set(false);
    EmojiListenerManager.a().b(this.jsonListener);
  }
  
  public void onDone(List paramList1, List paramList2) {}
  
  public void onFileDone(CustomEmotionData paramCustomEmotionData, boolean paramBoolean)
  {
    if ((paramCustomEmotionData == null) || (this.mApp == null)) {}
    int i;
    label203:
    label226:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "onFileDone, resId=" + paramCustomEmotionData.resid + ",isSuccess = " + paramBoolean + " , roamingType: " + paramCustomEmotionData.RomaingType);
      }
      Object localObject = (FavroamingDBManager)this.mApp.getManager(148);
      if ((localObject != null) && (paramBoolean))
      {
        if (!"needDownload".equals(paramCustomEmotionData.RomaingType)) {
          break label203;
        }
        paramCustomEmotionData.RomaingType = "isUpdate";
        if ("needDel".equals(paramCustomEmotionData.RomaingType)) {
          break label226;
        }
        ((FavroamingDBManager)localObject).b(paramCustomEmotionData);
      }
      for (;;)
      {
        i = 0;
        while (i < this.listeners.size())
        {
          if (this.listeners.get(i) != null)
          {
            localObject = (SyncListener)((WeakReference)this.listeners.get(i)).get();
            if (localObject != null) {
              ((SyncListener)localObject).a(paramCustomEmotionData, jdField_a_of_type_Int, jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
            }
          }
          i += 1;
        }
        if (!"overflow".equals(paramCustomEmotionData.RomaingType)) {
          break;
        }
        paramCustomEmotionData.RomaingType = "overflow_downloaded";
        break;
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingManager", 2, "onFileDone, resId=" + paramCustomEmotionData.resid + " has been deleted");
        }
      }
      i = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "market face : downloadCount: " + i + ",needDownloadCount: " + jdField_a_of_type_Int);
      }
    } while (i < jdField_a_of_type_Int);
    c();
  }
  
  public void removeSyncListener(SyncListener paramSyncListener)
  {
    if (paramSyncListener == null) {}
    WeakReference localWeakReference;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = this.listeners.iterator();
      }
      localWeakReference = (WeakReference)localIterator.next();
    } while (localWeakReference.get() != paramSyncListener);
    this.listeners.remove(localWeakReference);
  }
  
  public void resetSyncState()
  {
    this.isInSync.set(false);
  }
  
  public void syncLocalDel()
  {
    if (this.mApp == null) {}
    List localList;
    do
    {
      FavEmoRoamingHandler localFavEmoRoamingHandler;
      do
      {
        return;
        localFavEmoRoamingHandler = (FavEmoRoamingHandler)this.mApp.a(72);
      } while (localFavEmoRoamingHandler == null);
      this.mApp.a(this.favObserver);
      localList = ((FavroamingDBManager)this.mApp.getManager(148)).a("needDel");
      if (localList.size() > 0)
      {
        localFavEmoRoamingHandler.a(localList, true);
        return;
      }
    } while (localList.size() != 0);
    syncRoaming();
  }
  
  public void syncRoaming()
  {
    if (this.mApp == null) {}
    FavEmoRoamingHandler localFavEmoRoamingHandler;
    do
    {
      return;
      localFavEmoRoamingHandler = (FavEmoRoamingHandler)this.mApp.a(72);
    } while (localFavEmoRoamingHandler == null);
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "------------start syncRoaming----------");
    }
    localFavEmoRoamingHandler.a();
  }
  
  public void syncUpload(CustomEmotionData paramCustomEmotionData)
  {
    uploadFavEmoticon(paramCustomEmotionData);
  }
  
  public void syncUpload(List paramList)
  {
    if (paramList != null) {
      uploadFavEmoticon(paramList);
    }
  }
  
  public void uploadFavEmoticon(CustomEmotionData paramCustomEmotionData)
  {
    if (paramCustomEmotionData == null) {}
    do
    {
      return;
      if ((!paramCustomEmotionData.isMarkFace) && (TextUtils.isEmpty(paramCustomEmotionData.md5)))
      {
        paramCustomEmotionData.md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramCustomEmotionData.emoPath));
        localObject = this.mApp.a().createEntityManager();
        if (localObject != null)
        {
          ((EntityManager)localObject).a(paramCustomEmotionData);
          ((EntityManager)localObject).a();
        }
      }
    } while (!NetworkUtil.e(BaseApplication.getContext()));
    if ((!this.isAddHandler) && (this.mTransProcessorHandler != null) && (this.mFileController != null))
    {
      this.mTransProcessorHandler.a(new Class[] { BDHCommonUploadProcessor.class });
      this.mFileController.a(this.mTransProcessorHandler);
      this.isAddHandler = true;
    }
    Object localObject = new TransferRequest();
    ((TransferRequest)localObject).jdField_b_of_type_Int = 24;
    ((TransferRequest)localObject).jdField_c_of_type_Int = 9;
    ((TransferRequest)localObject).jdField_a_of_type_JavaLangString = "scbqmanyou";
    ((TransferRequest)localObject).jdField_b_of_type_JavaLangString = this.uin;
    ((TransferRequest)localObject).jdField_c_of_type_JavaLangString = this.uin;
    ((TransferRequest)localObject).jdField_a_of_type_Boolean = true;
    if (paramCustomEmotionData.isMarkFace)
    {
      uploadMarkFace(paramCustomEmotionData, (TransferRequest)localObject);
      return;
    }
    uploadNoMarkFace(paramCustomEmotionData, (TransferRequest)localObject);
  }
  
  public void uploadFavEmoticon(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (!NetworkUtil.e(BaseApplication.getContext()))) {
      return;
    }
    List localList = paramList;
    if (paramList.size() > FavEmoConstant.jdField_a_of_type_Int)
    {
      i = paramList.size() - FavEmoConstant.jdField_a_of_type_Int;
      localList = paramList.subList(i, FavEmoConstant.jdField_a_of_type_Int + i);
    }
    int k = localList.size();
    int j = 0;
    int i = 0;
    if (j < k)
    {
      paramList = (CustomEmotionData)localList.get(j);
      if (("needDownload".equals(paramList.RomaingType)) || ("needDel".equals(paramList.RomaingType))) {
        break label158;
      }
      if (!"isUpdate".equals(paramList.RomaingType)) {}
    }
    label158:
    for (;;)
    {
      j += 1;
      break;
      uploadFavEmoticon(paramList);
      i += 1;
      continue;
      jdField_b_of_type_Int = i;
      return;
    }
  }
  
  public void uploadMarkFace(CustomEmotionData paramCustomEmotionData, TransferRequest paramTransferRequest)
  {
    if ((paramCustomEmotionData == null) || (paramTransferRequest == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "uploadMarkFace favEmoticon.epid=" + paramCustomEmotionData.emoPath + " and eid=" + paramCustomEmotionData.eId);
      }
      cmd0x388.ExtensionExpRoamTryUp localExtensionExpRoamTryUp = new cmd0x388.ExtensionExpRoamTryUp();
      cmd0x388.ExpRoamPicInfo localExpRoamPicInfo = new cmd0x388.ExpRoamPicInfo();
      localExpRoamPicInfo.bytes_pic_id.set(ByteStringMicro.copyFrom(paramCustomEmotionData.eId.getBytes()));
      localExpRoamPicInfo.uint32_pkg_id.set(Integer.parseInt(paramCustomEmotionData.emoPath));
      localExpRoamPicInfo.uint32_shop_flag.set(1);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localExpRoamPicInfo);
      localExtensionExpRoamTryUp.rpt_msg_exproam_pic_info.set(localArrayList);
      paramTransferRequest.jdField_a_of_type_ArrayOfByte = localExtensionExpRoamTryUp.toByteArray();
      paramTransferRequest.i = EmoticonUtils.l.replace("[epId]", paramCustomEmotionData.emoPath).replace("[eId]", paramCustomEmotionData.eId);
      paramTransferRequest.jdField_a_of_type_Long = paramCustomEmotionData.getId();
    } while (this.mFileController == null);
    this.mFileController.a(paramTransferRequest);
  }
  
  public void uploadNoMarkFace(CustomEmotionData paramCustomEmotionData, TransferRequest paramTransferRequest)
  {
    if ((paramCustomEmotionData == null) || (paramTransferRequest == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "uploadNoMarkFace favEmoticon.emoPath=" + paramCustomEmotionData.emoPath);
    }
    cmd0x388.ExtensionExpRoamTryUp localExtensionExpRoamTryUp = new cmd0x388.ExtensionExpRoamTryUp();
    cmd0x388.ExpRoamPicInfo localExpRoamPicInfo = new cmd0x388.ExpRoamPicInfo();
    Object localObject = FunnyPicHelper.a(paramCustomEmotionData.emoPath);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("qto_")))
    {
      localObject = ((String)localObject).replace("qto_", "qto@");
      localExpRoamPicInfo.bytes_pic_id.set(ByteStringMicro.copyFrom(((String)localObject).getBytes()));
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "upload FunnyPic name.replace->" + (String)localObject);
      }
      int j = FunnyPicHelper.a(paramCustomEmotionData.eId);
      int i = j;
      if (j == 0) {
        i = 1;
      }
      localExpRoamPicInfo.uint32_pkg_id.set(i);
    }
    for (;;)
    {
      localExpRoamPicInfo.uint32_shop_flag.set(0);
      localObject = new ArrayList();
      ((List)localObject).add(localExpRoamPicInfo);
      localExtensionExpRoamTryUp.rpt_msg_exproam_pic_info.set((List)localObject);
      paramTransferRequest.jdField_a_of_type_ArrayOfByte = localExtensionExpRoamTryUp.toByteArray();
      paramTransferRequest.jdField_a_of_type_Long = paramCustomEmotionData.getId();
      paramTransferRequest.i = paramCustomEmotionData.emoPath;
      if (this.mFileController == null) {
        break;
      }
      this.mFileController.a(paramTransferRequest);
      return;
      localExpRoamPicInfo.bytes_pic_id.set(ByteStringMicro.copyFrom("0".getBytes()));
      localExpRoamPicInfo.uint32_pkg_id.set(0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emosm\favroaming\FavroamingManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */