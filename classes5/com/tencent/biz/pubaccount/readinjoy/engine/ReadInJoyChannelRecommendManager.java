package com.tencent.biz.pubaccount.readinjoy.engine;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfoNew;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import hxv;
import hxw;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.RspBody;

public class ReadInJoyChannelRecommendManager
{
  public static long a;
  public static ReadInJoyChannelRecommendManager a;
  public static String b = "";
  public final String a;
  public ConcurrentHashMap a;
  public boolean a;
  public String c = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private ReadInJoyChannelRecommendManager()
  {
    this.jdField_a_of_type_JavaLangString = ReadInJoyChannelRecommendManager.class.getSimpleName();
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
      jdField_a_of_type_Long = ReadInJoyHelper.a(localAppRuntime);
      if (localAppRuntime != null) {
        this.c = localAppRuntime.getAccount();
      }
      b = BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath() + File.separator + "channel_" + this.c;
      b();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "init channelrecommend error:" + localException.toString());
    }
  }
  
  public static ReadInJoyChannelRecommendManager a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyChannelRecommendManager == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyChannelRecommendManager = new ReadInJoyChannelRecommendManager();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyChannelRecommendManager;
    }
    finally {}
  }
  
  public ChannelInfoNew a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      return null;
    }
    return (ChannelInfoNew)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public ConcurrentHashMap a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void a()
  {
    String str = "";
    AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    if ((ReadInJoyHelper.c(BaseApplicationImpl.a().a())) || (!TextUtils.equals(this.c, str)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyChannelRecommendManager.jdField_a_of_type_JavaLangString, 2, "true to update channel list");
      }
      this.c = str;
      b = BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath() + File.separator + "channel_" + this.c;
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyChannelRecommendManager.b();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (!a()) {
      return;
    }
    try
    {
      ((ReadInJoyLogicManager)paramQQAppInterface.getManager(162)).a().a(2, 0);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "failed to requestChannelRecommendListTimely " + paramQQAppInterface.toString());
    }
  }
  
  public void a(oidb_cmd0x69f.RspBody paramRspBody)
  {
    try
    {
      ThreadManager.a(new hxv(this, paramRspBody), null, true);
      return;
    }
    finally
    {
      paramRspBody = finally;
      throw paramRspBody;
    }
  }
  
  public boolean a()
  {
    AppRuntime localAppRuntime = ReadInJoyUtils.a();
    if ((localAppRuntime == null) || (!(localAppRuntime instanceof QQAppInterface))) {}
    long l;
    do
    {
      return false;
      jdField_a_of_type_Long = ReadInJoyHelper.a(BaseApplicationImpl.a().a());
      l = System.currentTimeMillis();
      if (l >= 18000000L + (Math.random() * 7200000.0D) + jdField_a_of_type_Long) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "protect cur:" + l + ", last_update:" + jdField_a_of_type_Long + ", interval:" + (l - jdField_a_of_type_Long));
    return false;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "canUpdateChannelRecommend");
    }
    return true;
  }
  
  public void b()
  {
    ThreadManager.a(new hxw(this), null, false);
  }
  
  public void c()
  {
    jdField_a_of_type_Long = System.currentTimeMillis();
    ReadInJoyHelper.a(BaseApplicationImpl.a().a(), jdField_a_of_type_Long);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\engine\ReadInJoyChannelRecommendManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */