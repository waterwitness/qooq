package com.tencent.mobileqq.util;

import AvatarInfo.QQHeadInfo;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FaceDownloader;
import com.tencent.mobileqq.app.FaceDownloader.FaceDownloadListener;
import com.tencent.mobileqq.app.FaceHandler;
import com.tencent.mobileqq.app.FaceObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import vxx;

public class NearbyFaceDecoder
  extends FaceDecoderBase
  implements FaceDownloader.FaceDownloadListener, FaceDecodeTask.DecodeCompletionListener
{
  private static final String b = "Q.qqhead.NearbyFaceDecoder";
  static final boolean d = true;
  FaceDownloader jdField_a_of_type_ComTencentMobileqqAppFaceDownloader;
  FaceObserver jdField_a_of_type_ComTencentMobileqqAppFaceObserver;
  NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  
  public NearbyFaceDecoder(NearbyAppInterface paramNearbyAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader = ((FaceManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(215)).a();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader.a(this);
  }
  
  public Bitmap a(int paramInt1, String paramString, int paramInt2, byte paramByte)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null) {
      return null;
    }
    paramString = FaceInfo.a(paramInt1, paramString, paramInt2, paramByte);
    Bitmap localBitmap = ((FaceManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(215)).a(paramString);
    NearbyUtils.a(4, "Q.qqhead.NearbyFaceDecoder", "getBitmapFromcache", new Object[] { paramString, localBitmap });
    return localBitmap;
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, long paramLong) {}
  
  public void a(AppInterface paramAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface != paramAppInterface)
    {
      d();
      if ((paramAppInterface instanceof NearbyAppInterface)) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = ((NearbyAppInterface)paramAppInterface);
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, FaceInfo paramFaceInfo)
  {
    if (paramFaceInfo == null) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null) || (paramFaceInfo == null));
      this.jdField_c_of_type_Int -= 1;
      if ((paramFaceInfo.jdField_a_of_type_Int == 32) && (paramFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo == null) && ((FaceInfo)this.jdField_a_of_type_JavaUtilHashtable.get(paramFaceInfo.b()) != null)) {
        ((FaceHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(4)).a(paramFaceInfo);
      }
    } while ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) || (this.jdField_c_of_type_Int >= this.b));
    e();
  }
  
  public void a(FaceInfo paramFaceInfo, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "onDecodeTaskCompleted,avatar=" + paramBitmap + ",faceInfo=" + paramFaceInfo);
    }
    if ((paramFaceInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null)) {
      return;
    }
    this.jdField_c_of_type_Int -= 1;
    if ((!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) && (!this.jdField_a_of_type_Boolean)) {
      e();
    }
    Object localObject = (FaceInfo)this.jdField_a_of_type_JavaUtilHashtable.remove(paramFaceInfo.b());
    int i;
    if (localObject != null)
    {
      int j = FaceInfo.q;
      if (paramBitmap == null) {
        break label309;
      }
      i = FaceInfo.e;
      label116:
      ((FaceInfo)localObject).a(j, i);
      if ((this.jdField_c_of_type_Boolean) && (paramBitmap != null)) {
        if ((paramBitmap == null) || (localObject.jdField_a_of_type_ArrayOfLong[FaceInfo.q] <= 0L) || (localObject.jdField_a_of_type_ArrayOfLong[FaceInfo.i] <= 0L)) {
          break label358;
        }
      }
    }
    label309:
    label317:
    label358:
    for (long l = localObject.jdField_a_of_type_ArrayOfLong[FaceInfo.q] - localObject.jdField_a_of_type_ArrayOfLong[FaceInfo.i];; l = 0L)
    {
      if (l > 0L)
      {
        i = NetworkUtil.a(BaseApplicationImpl.a().getApplicationContext());
        if (i != 1) {
          break label317;
        }
        localObject = "actNearByFaceShowCostWIFI";
      }
      for (;;)
      {
        StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), (String)localObject, true, l, 0L, null, "");
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "onDecodeTaskCompleted.cost=" + l);
        }
        if ((this.jdField_a_of_type_Vxx == null) || (paramBitmap == null)) {
          break;
        }
        this.jdField_a_of_type_Vxx.a(this.jdField_c_of_type_Int + this.jdField_a_of_type_JavaUtilLinkedList.size(), paramFaceInfo.jdField_a_of_type_Int, paramFaceInfo.jdField_a_of_type_JavaLangString, paramBitmap);
        return;
        i = FaceInfo.f;
        break label116;
        if (i == 2) {
          localObject = "actNearByFaceShowCost2G";
        } else if (i == 3) {
          localObject = "actNearByFaceShowCost3G";
        } else if (i == 4) {
          localObject = "actNearByFaceShowCost4G";
        } else {
          localObject = null;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, FaceInfo paramFaceInfo, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "onFaceDownloadFinished,isSuccess=" + paramBoolean + ",faceInfo=" + paramFaceInfo + ",bitmap=" + paramBitmap);
    }
    if ((paramFaceInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null)) {
      return;
    }
    Object localObject = (FaceInfo)this.jdField_a_of_type_JavaUtilHashtable.remove(paramFaceInfo.b());
    int i;
    if (localObject != null)
    {
      int j = FaceInfo.q;
      if (paramBitmap == null) {
        break label304;
      }
      i = FaceInfo.e;
      label96:
      ((FaceInfo)localObject).a(j, i);
      if ((this.jdField_c_of_type_Boolean) && (paramBitmap != null)) {
        if ((localObject.jdField_a_of_type_ArrayOfLong[FaceInfo.q] <= 0L) || (localObject.jdField_a_of_type_ArrayOfLong[FaceInfo.i] <= 0L)) {
          break label351;
        }
      }
    }
    label304:
    label312:
    label351:
    for (long l = localObject.jdField_a_of_type_ArrayOfLong[FaceInfo.q] - localObject.jdField_a_of_type_ArrayOfLong[FaceInfo.i];; l = 0L)
    {
      if (l > 0L)
      {
        localObject = "";
        i = NetworkUtil.a(BaseApplicationImpl.a().getApplicationContext());
        if (i != 1) {
          break label312;
        }
        localObject = "actNearByFaceShowCostWIFI";
      }
      for (;;)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), (String)localObject, true, l, 0L, null, "");
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "onFaceDownloadFinished.cost=" + l);
        }
        if ((this.jdField_a_of_type_Vxx == null) || (paramBitmap == null)) {
          break;
        }
        this.jdField_a_of_type_Vxx.a(this.jdField_c_of_type_Int + this.jdField_a_of_type_JavaUtilLinkedList.size(), paramFaceInfo.jdField_a_of_type_Int, paramFaceInfo.jdField_a_of_type_JavaLangString, paramBitmap);
        return;
        i = FaceInfo.f;
        break label96;
        if (i == 2) {
          localObject = "actNearByFaceShowCost2G";
        } else if (i == 3) {
          localObject = "actNearByFaceShowCost3G";
        } else if (i == 4) {
          localObject = "actNearByFaceShowCost4G";
        }
      }
    }
  }
  
  public boolean a(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3)
  {
    if ((paramString == null) || (paramString.length() < 5))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "requestDecodeStrangeFace fail , uin = " + paramString);
      }
      return false;
    }
    String str = FaceInfo.a(paramInt2, paramString, paramInt1);
    FaceInfo localFaceInfo = (FaceInfo)this.jdField_a_of_type_JavaUtilHashtable.get(str);
    if ((localFaceInfo != null) && (!localFaceInfo.a(FaceInfo.i, 300000L)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "requestDecodeStrangeFace, uin repeat. uin=" + paramString);
      }
      if ((localFaceInfo.b) && (!paramBoolean2)) {
        localFaceInfo.b = false;
      }
      return true;
    }
    paramString = new FaceInfo(paramInt2, paramString, paramBoolean2, (byte)1, paramInt3, false, paramInt1);
    paramString.a(FaceInfo.i);
    this.jdField_a_of_type_JavaUtilHashtable.put(str, paramString);
    a(paramString);
    return true;
  }
  
  public boolean a(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3, QQHeadInfo paramQQHeadInfo)
  {
    if ((paramString == null) || (paramString.length() < 5))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "requestDecodeFaceWithFaceInfo fail , uin = " + paramString);
      }
      return false;
    }
    String str = FaceInfo.a(paramInt2, paramString, paramInt1);
    FaceInfo localFaceInfo = (FaceInfo)this.jdField_a_of_type_JavaUtilHashtable.get(str);
    if ((localFaceInfo != null) && (!localFaceInfo.a(FaceInfo.i, 300000L)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "requestDecodeFaceWithFaceInfo, uin repeat. uin=" + paramString);
      }
      if ((localFaceInfo.b) && (!paramBoolean2)) {
        localFaceInfo.b = false;
      }
      if (paramQQHeadInfo != null) {
        localFaceInfo.a(paramQQHeadInfo);
      }
      return true;
    }
    localFaceInfo = new FaceInfo(paramInt2, paramString, paramBoolean2, (byte)1, paramInt3, false, paramInt1, 1);
    localFaceInfo.a(paramQQHeadInfo);
    localFaceInfo.a(FaceInfo.i);
    this.jdField_a_of_type_JavaUtilHashtable.put(str, localFaceInfo);
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "requestDecodeFaceWithFaceInfo.uin = " + paramString + ",faceinfo=" + localFaceInfo);
    }
    a(localFaceInfo);
    return true;
  }
  
  public boolean a(ArrayList paramArrayList)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      bool1 = false;
    }
    int i;
    do
    {
      return bool1;
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "preloadFacesWithFaceInfo.size = " + paramArrayList.size());
      }
      new ArrayList(paramArrayList.size());
      i = 0;
      bool1 = bool2;
    } while (i >= paramArrayList.size());
    HeadRequest localHeadRequest = (HeadRequest)paramArrayList.get(i);
    if (a(32, localHeadRequest.jdField_a_of_type_JavaLangString, localHeadRequest.jdField_a_of_type_Int, (byte)3) != null) {}
    for (;;)
    {
      i += 1;
      break;
      a(localHeadRequest.jdField_a_of_type_JavaLangString, localHeadRequest.jdField_a_of_type_Int, true, 32, true, (byte)1, 3, localHeadRequest.jdField_a_of_type_AvatarInfoQQHeadInfo);
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFaceObserver != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppFaceObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceObserver = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader.b(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = null;
    super.d();
  }
  
  protected void e()
  {
    localObject1 = null;
    do
    {
      try
      {
        FaceInfo localFaceInfo = (FaceInfo)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
        if (localObject1 == null) {
          continue;
        }
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          this.jdField_c_of_type_Int += 1;
          FaceDecodeTask.a(FaceDecodeTask.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, localFaceInfo, this));
          return;
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            localObject1 = localThrowable1;
            Object localObject2 = localThrowable2;
          }
        }
        localThrowable1 = localThrowable1;
      }
      this.jdField_c_of_type_Int -= 1;
    } while (!QLog.isColorLevel());
    NearbyUtils.a("Q.qqhead.NearbyFaceDecoder", new Object[] { "runNextTask", localThrowable1, localObject1 });
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\util\NearbyFaceDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */