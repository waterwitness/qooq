package com.tencent.mobileqq.activity.contact;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import ogn;

public class OnlineStatusIconHelper
{
  private static OnlineStatusIconHelper jdField_a_of_type_ComTencentMobileqqActivityContactOnlineStatusIconHelper;
  private static final String jdField_a_of_type_JavaLangString = "online_status_icon_config.xml";
  public HashMap a;
  
  private OnlineStatusIconHelper(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    a(paramContext);
  }
  
  public static OnlineStatusIconHelper a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityContactOnlineStatusIconHelper == null) {
        jdField_a_of_type_ComTencentMobileqqActivityContactOnlineStatusIconHelper = new OnlineStatusIconHelper(BaseApplicationImpl.getContext());
      }
      return jdField_a_of_type_ComTencentMobileqqActivityContactOnlineStatusIconHelper;
    }
    finally {}
  }
  
  private void a(Context paramContext)
  {
    try
    {
      SAXParser localSAXParser = SAXParserFactory.newInstance().newSAXParser();
      ogn localogn = new ogn(this);
      localSAXParser.parse(paramContext.getAssets().open("online_status_icon_config.xml"), localogn);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public int a(int paramInt)
  {
    return a(paramInt, 1);
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    if (localInteger == null) {
      return paramInt2;
    }
    return localInteger.intValue();
  }
  
  public boolean a(int paramInt)
  {
    paramInt = a(paramInt);
    return (paramInt == 3) || (paramInt == 2);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\contact\OnlineStatusIconHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */