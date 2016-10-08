package cooperation.huangye;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import mqq.app.MobileQQ;
import ycm;

public class HYConfigLoader
{
  private static volatile HYConfigLoader jdField_a_of_type_CooperationHuangyeHYConfigLoader;
  private static final String jdField_a_of_type_JavaLangString = "HYConfigLoader";
  private final long jdField_a_of_type_Long;
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private long b;
  
  private HYConfigLoader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Long = 3600000L;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
  }
  
  public static HYConfigLoader a()
  {
    if (jdField_a_of_type_CooperationHuangyeHYConfigLoader == null) {}
    try
    {
      if (jdField_a_of_type_CooperationHuangyeHYConfigLoader == null) {
        jdField_a_of_type_CooperationHuangyeHYConfigLoader = new HYConfigLoader();
      }
      return jdField_a_of_type_CooperationHuangyeHYConfigLoader;
    }
    finally {}
  }
  
  public String a()
  {
    return HYSharedPref.a().a("FileConfigure", null);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((System.currentTimeMillis() - this.b < 7200000L) || (!NetworkUtil.h(paramQQAppInterface.getApplication().getApplicationContext()))) {
      try
      {
        this.jdField_a_of_type_Boolean = true;
        paramQQAppInterface = new ycm(this, paramQQAppInterface);
        new Timer().schedule(paramQQAppInterface, 200L);
        return;
      }
      finally {}
    }
    try
    {
      this.jdField_a_of_type_Boolean = true;
      this.b = System.currentTimeMillis();
      ConfigServlet.d(paramQQAppInterface, paramQQAppInterface.a());
      return;
    }
    finally {}
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (HYSharedPref.a().a("FileConfigure", paramString))
      {
        SharedPreUtils.a(paramQQAppInterface.getApplication(), paramInt);
        str = paramString;
      }
    }
    for (;;)
    {
      try
      {
        paramString = this.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString.hasNext()) {
          ((HYConfigLoader.GetConfigListener)paramString.next()).a(paramQQAppInterface, str);
        }
        str = a();
      }
      finally {}
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(HYConfigLoader.GetConfigListener paramGetConfigListener)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramGetConfigListener)) {
      try
      {
        this.jdField_a_of_type_JavaUtilList.add(paramGetConfigListener);
        return;
      }
      finally {}
    }
  }
  
  public void b(HYConfigLoader.GetConfigListener paramGetConfigListener)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(paramGetConfigListener)) {
      try
      {
        this.jdField_a_of_type_JavaUtilList.remove(paramGetConfigListener);
        return;
      }
      finally {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\huangye\HYConfigLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */