package com.tencent.mobileqq.precover;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.List;
import tul;

public abstract class PrecoverBusiConfigHandler
{
  public static final int a = 0;
  public static final String a = "PrecoverBusiConfigHandler";
  public static final int b = -1;
  public static final int c = -1;
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 2;
  protected QQAppInterface a;
  protected int g;
  
  public PrecoverBusiConfigHandler(QQAppInterface paramQQAppInterface, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramQQAppInterface;
    this.g = paramInt;
  }
  
  private void a(ConfigurationService.Config paramConfig, tul paramtul)
  {
    if ((paramtul == null) || (paramConfig == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverBusiConfigHandler", 2, "parseBusiConfigResult|| result or config is null, type =" + this.g);
      }
    }
    label320:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (QLog.isColorLevel()) {
                  QLog.d("PrecoverBusiConfigHandler", 2, "parseBusiConfigResult|| result =" + paramtul + ",type=" + this.g);
                }
              } while (paramtul.jdField_a_of_type_Int != 0);
              PrecoverUtils.a(this.a, this.g, paramConfig.version.get());
              if (paramtul.jdField_b_of_type_Int != 0) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("PrecoverBusiConfigHandler", 2, "handleConfig|| doNothing, type =" + this.g);
            return;
            if ((paramtul.jdField_b_of_type_Int != 1) || (TextUtils.isEmpty(paramtul.jdField_a_of_type_JavaLangString))) {
              break label320;
            }
            paramConfig = PrecoverUtils.a(paramtul.jdField_a_of_type_JavaLangString);
            if (paramConfig == null)
            {
              QLog.d("PrecoverBusiConfigHandler", 1, "parseBusiConfigResult, pair is null");
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.d("PrecoverBusiConfigHandler", 2, "parseBusiConfigResult, pair.first=" + paramConfig.first + ", pair.second=" + paramConfig.second);
            }
            if ((paramConfig.first != null) && (paramConfig.second != null) && (((PrecoverBusinessInfo)paramConfig.first).a())) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("PrecoverBusiConfigHandler", 2, "parseBusiConfigResult, pair.first == null || pair.second == null || !pair.first.isValid()");
          return;
          paramtul = (PrecoverManager)this.a.getManager(178);
        } while (paramtul == null);
        paramtul.a(((PrecoverBusinessInfo)paramConfig.first).jdField_a_of_type_JavaLangString, (List)paramConfig.second);
        return;
        if ((paramtul.jdField_b_of_type_Int != 2) || (TextUtils.isEmpty(paramtul.jdField_b_of_type_JavaLangString)) || (paramtul.jdField_a_of_type_JavaUtilList == null) || (paramtul.jdField_a_of_type_JavaUtilList.isEmpty())) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PrecoverBusiConfigHandler", 2, "parseBusiConfigResult, TYPE_RES_PARSE_RESLIST, result.busineddIs=" + paramtul.jdField_b_of_type_JavaLangString + ", result.resList=" + paramtul.jdField_a_of_type_JavaUtilList);
        }
        paramConfig = (PrecoverManager)this.a.getManager(178);
      } while (paramConfig == null);
      paramConfig.a(paramtul.jdField_b_of_type_JavaLangString, paramtul.jdField_a_of_type_JavaUtilList);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("PrecoverBusiConfigHandler", 2, "handleConfig|| result is not correct, type =" + this.g);
  }
  
  public ConfigurationService.ConfigSeq a(ConfigurationService.ConfigSeq paramConfigSeq)
  {
    int i = PrecoverUtils.a(this.a, this.g);
    paramConfigSeq.version.set(i);
    return paramConfigSeq;
  }
  
  public abstract tul a(ConfigurationService.Config paramConfig);
  
  public void a()
  {
    ((PrecoverManager)this.a.getManager(178)).a(this.g);
  }
  
  public void a(ConfigurationService.Config paramConfig)
  {
    if (paramConfig == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverBusiConfigHandler", 2, "handleConfig|| config is null, type =" + this.g);
      }
      return;
    }
    a(paramConfig, a(paramConfig));
    a();
  }
  
  public void a(ConfigurationService.RespGetConfig paramRespGetConfig, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverBusiConfigHandler", 2, "handleConfigError||type=" + paramInt);
    }
    if (!paramBoolean) {
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverBusiConfigHandler", 2, "handleConfigError||isSuccess =" + paramBoolean);
      }
    }
    do
    {
      do
      {
        return;
        if (paramRespGetConfig.result.get() == 0) {
          break;
        }
        paramInt = paramRespGetConfig.result.get();
      } while (!QLog.isColorLevel());
      QLog.d("PrecoverBusiConfigHandler", 2, "handleConfigError||result =" + paramInt);
      return;
    } while (((paramRespGetConfig.config_list != null) && (paramRespGetConfig.config_list.size() != 0)) || (!QLog.isColorLevel()));
    QLog.d("PrecoverBusiConfigHandler", 2, "handleConfigError||config_list is null");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\precover\PrecoverBusiConfigHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */