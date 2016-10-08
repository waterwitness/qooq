package com.tencent.mobileqq.nearby.rn;

import com.tencent.bitapp.preDownload.IRNPreDownloadListener;
import com.tencent.bitapp.preDownload.RNPreDownloadFacade;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import java.lang.ref.WeakReference;

public class NearbyRNAppManager$PreLoadSo
  implements IRNPreDownloadListener
{
  int jdField_a_of_type_Int;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  int b;
  
  public NearbyRNAppManager$PreLoadSo(AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public void a()
  {
    boolean bool = RNPreDownloadFacade.a();
    if (NearbyUtils.b()) {
      NearbyUtils.a(NearbyRNAppManager.a, new Object[] { "PreLoadSo", "onLoadSuccess", Boolean.valueOf(bool) });
    }
    if (bool) {
      NearbyRNAppManager.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_Int, this.b);
    }
  }
  
  public void a(int paramInt)
  {
    if (NearbyUtils.b()) {
      NearbyUtils.a(NearbyRNAppManager.a, new Object[] { "PreLoadSo", "onLoadFail" });
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (NearbyUtils.b()) {
      NearbyUtils.a(NearbyRNAppManager.a, new Object[] { "PreLoadSo", "onProgress", Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\rn\NearbyRNAppManager$PreLoadSo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */