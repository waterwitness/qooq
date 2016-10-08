package com.tencent.mobileqq.precover;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tul;

public class PrecoverTestHandler
  extends PrecoverBusiConfigHandler
{
  public PrecoverTestHandler(QQAppInterface paramQQAppInterface, int paramInt)
  {
    super(paramQQAppInterface, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public tul a(ConfigurationService.Config paramConfig)
  {
    tul localtul = new tul();
    if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null)
      {
        paramConfig = PrecoverUtils.a(paramConfig);
        localtul.jdField_a_of_type_Int = 0;
        localtul.jdField_a_of_type_JavaLangString = paramConfig;
        localtul.b = 1;
      }
    }
    return localtul;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\precover\PrecoverTestHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */