package com.tencent.mobileqq.activity.aio;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.IndividualRedPacketManager.VIPHBStrategy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import ncv;
import ncw;
import ncx;

public class CustomizeStrategyFactory
{
  public static final int a = 1;
  private static CustomizeStrategyFactory jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory;
  private static final String jdField_a_of_type_JavaLangString = "CustomizeStrategyFactory";
  public static final int b = 2;
  public static final int c = 3;
  private static final int d = 1;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private HashMap b;
  
  private CustomizeStrategyFactory()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(5);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(32);
    this.b = new HashMap(8);
    this.jdField_a_of_type_AndroidOsHandler = new ncv(this, Looper.getMainLooper());
  }
  
  public static Bitmap a(Resources paramResources, int paramInt)
  {
    if (paramInt <= 0) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(paramResources, paramInt, localOptions);
    localOptions.inPreferredConfig = Bitmap.Config.ARGB_4444;
    localOptions.inJustDecodeBounds = false;
    try
    {
      paramResources = BitmapFactory.decodeResource(paramResources, paramInt, localOptions);
      return paramResources;
    }
    catch (OutOfMemoryError paramResources) {}
    return null;
  }
  
  private CustomizeStrategyFactory.HBCustomizeStrategy a(int paramInt, AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CustomizeStrategyFactory", 2, "getCustomizeStrategy type =" + paramInt);
    }
    CustomizeStrategyFactory.HBCustomizeStrategy localHBCustomizeStrategy = (CustomizeStrategyFactory.HBCustomizeStrategy)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localHBCustomizeStrategy != null) {
      return localHBCustomizeStrategy;
    }
    if (2 == paramInt)
    {
      paramAppInterface = new IndividualRedPacketManager.VIPHBStrategy(paramAppInterface);
      this.jdField_a_of_type_AndroidUtilSparseArray.append(paramInt, paramAppInterface);
      return paramAppInterface;
    }
    if (1 == paramInt)
    {
      paramAppInterface = new ncx(paramAppInterface);
      this.jdField_a_of_type_AndroidUtilSparseArray.append(paramInt, paramAppInterface);
      return paramAppInterface;
    }
    paramAppInterface = new ncw(paramAppInterface);
    this.jdField_a_of_type_AndroidUtilSparseArray.append(paramInt, paramAppInterface);
    return paramAppInterface;
  }
  
  public static CustomizeStrategyFactory a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory == null) {
      jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory = new CustomizeStrategyFactory();
    }
    return jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory;
  }
  
  public void a()
  {
    if (this.b != null)
    {
      Iterator localIterator = this.b.values().iterator();
      while (localIterator.hasNext())
      {
        ArrayList localArrayList = (ArrayList)localIterator.next();
        if (localArrayList != null) {
          localArrayList.clear();
        }
      }
      this.b.clear();
    }
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
      this.jdField_a_of_type_AndroidUtilSparseArray = null;
    }
    this.jdField_a_of_type_AndroidOsHandler = null;
    jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory = null;
  }
  
  public void a(AppInterface paramAppInterface, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, CustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener)
  {
    if ((paramRedPacketInfo == null) || (paramOnCustomizeListener == null) || (TextUtils.isEmpty(paramRedPacketInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    int i = paramRedPacketInfo.jdField_a_of_type_Int;
    Object localObject = new StringBuilder(paramRedPacketInfo.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append("_").append(paramRedPacketInfo.jdField_a_of_type_JavaLangString);
    if ((i == 2) && (!TextUtils.isEmpty(paramRedPacketInfo.b))) {
      ((StringBuilder)localObject).append("_").append(paramRedPacketInfo.b);
    }
    paramRedPacketInfo.c = ((StringBuilder)localObject).toString();
    localObject = (CustomizeStrategyFactory.RedPacketInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramRedPacketInfo.c);
    if (localObject == null)
    {
      if (!this.b.containsKey(paramRedPacketInfo.c)) {
        this.b.put(paramRedPacketInfo.c, new ArrayList(8));
      }
      ((ArrayList)this.b.get(paramRedPacketInfo.c)).add(paramOnCustomizeListener);
      a(i, paramAppInterface).a(paramRedPacketInfo);
      return;
    }
    paramOnCustomizeListener.a(i, (CustomizeStrategyFactory.RedPacketInfo)localObject);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (paramRedPacketInfo != null))
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      localMessage.what = 1;
      localMessage.obj = paramRedPacketInfo;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\CustomizeStrategyFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */